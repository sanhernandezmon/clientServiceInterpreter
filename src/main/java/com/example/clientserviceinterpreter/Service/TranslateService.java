package com.example.clientserviceinterpreter.Service;

import com.example.clientserviceinterpreter.Entity.Client;
import com.example.clientserviceinterpreter.Entity.DateModel;
import com.example.clientserviceinterpreter.Entity.Model;
import com.example.clientserviceinterpreter.Entity.Producto;
import com.example.clientserviceinterpreter.Repository.ClientRepository;
import com.example.clientserviceinterpreter.Repository.ModelsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class TranslateService {
    private final ModelsRepository modelsRepository;
    private final ClientRepository clientRepository;


    @Autowired
    private TranslateService(ModelsRepository modelsRepository, ClientRepository clientRepository) {
        this.modelsRepository = modelsRepository;
        this.clientRepository = clientRepository;
    }

    public Client SaveClient (String EntityId, String Json){
        Model model = modelsRepository.findModelById(EntityId);
        Client client = new Client();
        ObjectMapper mapper = new ObjectMapper();

        // parse the JSON string into a JsonNode
        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(Json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        client.setForeingId(jsonNode.get(model.getId_atribute()).asText());
        client.setNombre(jsonNode.get(model.getName_atribute()).asText());
        String DateString = jsonNode.get(model.getDate_atribute().getDate_atribute_name()).asText();
        String DateFormat = model.getDate_atribute().getDate_format();
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
        try {
            client.setFechaDeNacimiento(sdf.parse(DateString));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return clientRepository.save(client);
    }
}
