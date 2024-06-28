package com.normdevstorm.never_give_up.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.normdevstorm.never_give_up.service.ProductService;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
    @Id
    @SequenceGenerator(name = "int_sequence",sequenceName = "int_sequence", initialValue = 1)
    @GeneratedValue(generator = "int_sequence", strategy = GenerationType.SEQUENCE)
    @JsonIgnore
    private Integer id;
    @Size(max = 2083)
    @Column(length = 2083)
    private String source;

}
