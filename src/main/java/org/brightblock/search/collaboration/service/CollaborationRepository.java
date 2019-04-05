package org.brightblock.search.collaboration.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborationRepository extends MongoRepository<CollaborationMessage, String> {

    public List<CollaborationMessage> findBySender(String username);
    public List<CollaborationMessage> findByRecipient(String username);
}
