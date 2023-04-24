package com.example.clientserviceinterpreter.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Clients")
public class Client {
    @Id
    private String Id;

    private String ForeingId;
    private String Nombre;
    private Date FechaDeNacimiento;
    private List<Producto> Productos;

    @Override
    public String toString() {
        return "Client{" +
                "Id='" + Id + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", FechaDeNacimiento=" + FechaDeNacimiento +
                ", Productos=" + Productos +
                '}';
    }
}
