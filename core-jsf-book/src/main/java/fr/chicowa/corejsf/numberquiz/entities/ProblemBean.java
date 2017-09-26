package fr.chicowa.corejsf.numberquiz.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@SuppressWarnings( "serial" )
@Data
public class ProblemBean implements Serializable {

    private int           solution;

    private List<Integer> sequence;

    public ProblemBean( Integer values[], int solut ) {
        sequence = Arrays.asList( values );
        this.solution = solut;
    }
}
