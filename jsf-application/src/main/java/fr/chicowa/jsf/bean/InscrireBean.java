package fr.chicowa.jsf.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.chicowa.jsf.entities.Utilisateur;
import fr.chicowa.jsf.repository.RepositoryContainer;
import lombok.Getter;

@SuppressWarnings( "serial" )
@ManagedBean( name = "inscrireBean" )
@ViewScoped
public class InscrireBean implements Serializable {

    @Getter
    private Utilisateur                   utilisateur;

    @Autowired
    private RepositoryContainer.Container repos;

    public InscrireBean() {
        utilisateur = new Utilisateur();
    }

    public void inscrire() {

        repos.utilisateurRepository.save( utilisateur );
        // utilisateurDao.creer( utilisateur );

        FacesMessage message = new FacesMessage( "Succès de l'inscrption" );

        // null: e message n'a pas d'id particulier et sera affiché dans
        // <h:messages globalOnly="true" />

        FacesContext.getCurrentInstance().addMessage( null, message );
        System.out.println( "la méthode est bien appelée " );
    }

}
