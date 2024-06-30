package com.normdevstorm.never_give_up.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Mutability;
import org.hibernate.type.descriptor.java.MutableMutabilityPlan;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Cart implements Serializable {
    private static final long serialVersionUID = 4963847910013365856L;
    @Id
    @Column(name = "userId")
    private String id;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;
    @ManyToMany(fetch = FetchType.EAGER
    ,cascade = CascadeType.ALL)
    @JoinTable(joinColumns =
            @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> productList;
}