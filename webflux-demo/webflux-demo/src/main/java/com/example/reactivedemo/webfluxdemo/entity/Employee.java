package com.example.reactivedemo.webfluxdemo.entity;

//import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(value = "employees")
public class Employee {
    @Id
    private String id;
    private String empName;
    private String bloodGroup;
    private String religion;
}
