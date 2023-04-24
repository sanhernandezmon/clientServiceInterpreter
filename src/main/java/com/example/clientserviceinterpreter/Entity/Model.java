package com.example.clientserviceinterpreter.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Models")
public class Model {
    @Id
    private String id;
    private String id_atribute;
    private String name_atribute;
    private DateModel date_atribute;
    private ProductsModel product_atribute;

}
