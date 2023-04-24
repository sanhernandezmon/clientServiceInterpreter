package com.example.clientserviceinterpreter.Repository;

import com.example.clientserviceinterpreter.Entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}