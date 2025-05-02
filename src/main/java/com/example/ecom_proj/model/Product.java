package com.example.ecom_proj.model;


import java.math.BigDecimal;
import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Lob;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    // @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date releaseDate;
    private int quantity;

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;


}