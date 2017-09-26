package fr.chicowa.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings( "serial" )
@Data
@NoArgsConstructor
@ManagedBean
@RequestScoped
public class User implements Serializable {

    private String name;
    private String prenom;

}
