package fr.chicowa.jsf.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long      id;

    @NotEmpty
    @Email
    @Pattern( regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Merci de saisir une adresse mail valide" )
    private String    email;

    @Column( name = "mot_de_passe" )
    @NotEmpty
    @Size( min = 3, message = "Le mot de passe doit contenir au moins 3 caractères" )
    private String    motDePasse;

    @NotEmpty
    private String    nom;

    @Column( name = "date_inscription" )
    private Timestamp dateInscription = new Timestamp( System.currentTimeMillis() );

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public java.sql.Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public void setDateInscription( java.sql.Timestamp dateInscription ) {
        // TODO Auto-generated method stub
        this.dateInscription = dateInscription;
    }

}
