package com.example.clientserviceinterpreter.Repository;

import com.example.clientserviceinterpreter.Entity.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModelsRepository extends MongoRepository<Model, String> {
    Model findModelById(String EntiryId);
}