package org.brightblock.sidecar.conf.jwt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JWTHandlerInterceptor implements HandlerInterceptor {

	private static final Logger logger = LogManager.getLogger(JWTHandlerInterceptor.class);
	private static final String SPLITTER = "::";
	private static final String PREFIX = "/v1/admin/";
	private static final String AUTHORIZATION = "Authorization";
	private static final String Identity_Address = "IdentityAddress";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		try {
			logger.info("Handling: " + handler + " path: " + request.getRequestURI());
			if (handler instanceof HandlerMethod) {
				String path = request.getRequestURI();
				if (protectedPath(path)) {
					String address = request.getHeader(Identity_Address).split(SPLITTER)[0];
					String apiKey = request.getHeader(Identity_Address).split(SPLITTER)[1];
					logger.info("Authentication: api key=" + apiKey);
					String authToken = request.getHeader(AUTHORIZATION);
					authToken = authToken.split(" ")[1]; // stripe out Bearer string before passing along..
					UserTokenAuthentication v1Authentication = UserTokenAuthentication.getInstance(authToken);
					boolean auth = v1Authentication.isAuthenticationValid(address);
					String username = v1Authentication.getUsername();
					if (!auth) {
						throw new IllegalAccessException("Not authorised to make this request");
					}
					request.getSession().setAttribute("USERNAME", username);
				} else {
					logger.info("Authentication not required.");
				}
			} else {
				logger.info("Unknown request.");
			}
		} catch (Exception e) {
			throw new IllegalAccessException("Not authorised to make this request");
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	private boolean protectedPath(String path) {
		boolean proct = path.startsWith(PREFIX);
		return proct;
	}
}
