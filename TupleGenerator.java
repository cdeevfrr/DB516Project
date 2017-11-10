package Trial1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class TupleGenerator {
    static Random r = new Random(0);

    int numAttributes;
    int[] numAttributeValues;
    ProbabilisticFunction[][] functions; // pairs, for example [[1,2],[3]], where the r.h.s
    // functionally depends on the l.h.s. In other words, for this example
    // the attributes 1 and 2 functionally determine attribute 3.

    int[] currentTuple;

    public TupleGenerator(int numAttributes, int[] numAttributeValues,
                          ProbabilisticFunction[] functions){

        /*
        Later, we will generate values for tuples in order according to the order of functions.
        To ensure good probabilities for everything, we need to generate each l.h.s
        before we generate r.h.s for any function. This can be accomplished
        by doing a topological sort on the functions where
        f1 < f2 whenever f1 determines the l.h.s of f2. In other words,

            f1.rhs intersect f2.lhs neq emptyset.

        */

        Arrays.sort(functions, new Comparator<ProbabilisticFunction>(){
            @Override
            public int compare(ProbabilisticFunction f1, ProbabilisticFunction f2){
                for(Integer i : f2.lhs){
                    if(f1.rhs.contains(i)){

                    }
                }
            }
        });

    }

    /**
     * sample
     * @param attributes
     * @return
     */
    public int drawFrom(int attributes){

    }


    /**
     *
     * @return
     */
    public int[] makeTuple(){
        currentTuple = new int[numAttributes];
        if(functions.length > 1){
            throw new RuntimeException("Multiple functions are not supported yet");
        }
        for(int i = 0; i < functions.length ; i ++){
            if(r.nextDouble() > probabilities[i]){
                //We want to enforce function i.

            }
        }
    }


}
