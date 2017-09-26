package fr.chicowa.corejsf.validator;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import lombok.Setter;

@ManagedBean( name = "numValid" )
@ViewScoped
public class NumberValidator implements Validator {

    @Setter
    @ManagedProperty( "#{msg}" )
    private ResourceBundle bundle;

    @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
        try {
            Integer.parseInt( value.toString() );
        } catch ( Exception e ) {
            // e.printStackTrace();
            throw new ValidatorException( new FacesMessage( FacesMessage.SEVERITY_ERROR, bundle.getString( "error.not.integer" ), null ) );
        }
    }

}
