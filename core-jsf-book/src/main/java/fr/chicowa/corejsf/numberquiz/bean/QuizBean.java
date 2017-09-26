package fr.chicowa.corejsf.numberquiz.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.chicowa.corejsf.numberquiz.entities.ProblemBean;
import lombok.Data;

@SuppressWarnings( "serial" )
@Data
@ManagedBean( name = "quiz" )
@ViewScoped // Un objet de view scope est quand meme détruit si une de ses
            // méthodes est appelé dans l'attribut "action" d'un
            // <h:commandButton >renvoie un résultat
// lorsque JSF appelle un bean dans la vue, il appelle en premier lieu son
// constructeur sans paramètres
public class QuizBean implements Serializable {

    @ManagedProperty( "#{msg}" )
    private ResourceBundle    msg;

    private List<ProblemBean> problems;

    private int               score;

    private String            answer;

    private int               currentIndex;

    public QuizBean() {

        problems = Arrays.asList(
                new ProblemBean( new Integer[] { 3, 1, 4, 1, 5 }, 9 ),
                new ProblemBean( new Integer[] { 1, 1, 2, 3, 5 }, 8 ),
                new ProblemBean( new Integer[] { 1, 4, 9, 16, 25 }, 36 ),
                new ProblemBean( new Integer[] { 2, 3, 5, 7, 11 }, 13 ),
                new ProblemBean( new Integer[] { 1, 2, 4, 8, 16 }, 32 ) );
    }

    public void verifAnswer() {
        int answer = Integer.parseInt( getAnswer() );
        if ( getCurrent().getSolution() == answer ) {
            score += 1;
            FacesContext.getCurrentInstance().addMessage( "bien", new FacesMessage( msg.getString( "solution.msg" ) ) );
        }
        currentIndex = ( currentIndex + 1 ) % problems.size();
    }

    public ProblemBean getCurrent() {
        return problems.get( currentIndex );
    }

    @PreDestroy
    void destroyed() {
        System.out.println( "L'objet de la classe " + this.getClass() + "est détruit " );
    }

}
