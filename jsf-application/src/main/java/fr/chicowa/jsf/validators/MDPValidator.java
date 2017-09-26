package fr.chicowa.jsf.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator( value = "mdp-validator" )
public class MDPValidator implements Validator {

    private static String MDP_ATTRIBUTE = "composantMDP";
    private static String MDP_DIFFERENT = "Mot de passe différent !";

    @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {

        UIInput composantMDP = (UIInput) component.getAttributes().get( MDP_ATTRIBUTE );

        String mdp = (String) composantMDP.getValue();

        String confirmation = (String) value;

        if ( confirmation != null && !confirmation.equals( mdp ) ) {
            throw new ValidatorException( new FacesMessage( FacesMessage.SEVERITY_ERROR, MDP_DIFFERENT, null ) );
        }
    }

}
