package fr.chicowa.jsf.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@SuppressWarnings( "serial" )
@Entity
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long       id;

    @Column
    private String     name;

    @Column
    private BigDecimal price;

    public Product() {
    }

    public Product( String name, BigDecimal price ) {
        this.name = name;
        this.price = price;
    }

}
