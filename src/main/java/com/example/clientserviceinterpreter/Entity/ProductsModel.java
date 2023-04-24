package com.example.clientserviceinterpreter.Entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.aggregation.Fields;

import java.util.List;

@Getter
public class ProductsModel {
    private String product_atribute_id;
    private String product_atribute_internal_name;
    private String product_atribute_price;
    private String product_atribute_name;
}
