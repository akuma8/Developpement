package fr.chicowa.corejsf.javaquiz.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.chicowa.corejsf.javaquiz.entities.JQuizProblem;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings( "serial" )
@Data
@NoArgsConstructor
@ManagedBean( name = "jquiz" )
@SessionScoped
public class JQuizBean implements Serializable {

    private static String      REDIRECT = "?faces-redirect=true";

    private int                currentProblem;
    private int                tries;
    private int                score;
    private String             response = "";
    private String             correctAnswer;

    private List<JQuizProblem> problems = Arrays.asList(
            new JQuizProblem( "What trademarked slogan describes Java development? Write once, ...", "run anywhere" ),
            new JQuizProblem( "What are the first 4 bytes of every class file (in hexadecimal)?", "CAFEBABE" ),
            new JQuizProblem( "What does this statement print? System.out.println(1+\"2\");", "12" ),
            new JQuizProblem( "Which Java keyword is used to define a subclass?", "extends" ),
            new JQuizProblem( "What was the original name of the Java programming language?", "Oak" ),
            new JQuizProblem( "Which java.util class describes a point in time?", "Date" ) );

    public String answerAction() {

        tries++;

        if ( problems.get( currentProblem ).isCorrect( response ) ) {
            score++;
            nexProblem();
            System.out.println( "Réponse correcte " );
            return currentProblem == problems.size() ? "done?faces-redirect=true" : "success?faces-redirect=true";
        } else if ( tries == 1 ) {
            System.out.println( "Erreur on recommence" );
            return "again";
        } else {
            nexProblem();
        }

        return currentProblem == problems.size() ? "done" : "failure";
    }

    void nexProblem() {
        correctAnswer = problems.get( currentProblem ).getAnswer();
        currentProblem++;
        tries = 0;
        response = "";
    }

    public String startOverAction() {
        Collections.shuffle( problems );
        currentProblem = 0;
        score = 0;
        tries = 0;
        response = "";
        return "startOver";
    }

    public String getQuestion() {
        return problems.get( currentProblem ).getQuestion();
    }

    public String getSkipOutcome() {
        return currentProblem == problems.size() - 1 ? "done" + REDIRECT : "index";
    }
}
