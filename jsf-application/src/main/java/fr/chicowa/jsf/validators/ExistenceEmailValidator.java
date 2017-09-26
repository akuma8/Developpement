package fr.chicowa.jsf.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.chicowa.jsf.repository.DAOException;
import fr.chicowa.jsf.repository.RepositoryContainer;

//L'interface Validator permet de définir des règles de validatin
@Component( "existenceEmailValidator" )
@Scope( "request" )
public class ExistenceEmailValidator implements Validator {

    private final String                  EMAIL_EXISTE = "Cette adresse email existe déjà !";

    @Autowired
    private RepositoryContainer.Container repos;

    @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {

        // récupération du paramètre
        String email = (String) value;

        try {
            if ( repos.utilisateurRepository.findByEmail( email ) != null ) {
                // C'est le framework qui gère de lui-même les messages et s'en
                // sert pour l'afficher
                throw new ValidatorException( new FacesMessage( FacesMessage.SEVERITY_ERROR, EMAIL_EXISTE, null ) );
            }
        } catch ( DAOException e ) {
            /*
             * En cas d'erreur imprévue émanant de la BDD, on prépare un message
             * d'erreur contenant l'exception retournée, pour l'afficher à
             * l'utilisateur ensuite.
             */
            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, e.getMessage(), null );
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage( component.getClientId( facesContext ), message );
        }

    }

}
