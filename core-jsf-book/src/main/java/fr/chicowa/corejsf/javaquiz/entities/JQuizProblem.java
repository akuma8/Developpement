package fr.chicowa.corejsf.javaquiz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class JQuizProblem {

    private String question;
    private String answer;

    public boolean isCorrect( String response ) {
        return response.trim().equalsIgnoreCase( answer );
    }

}
