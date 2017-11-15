

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class TupleGenerator {
    static Random r = new Random(0);

    int numAttributes;
    int[] numAttributeValues;
    ProbabilisticFunction[] functions; // pairs, for example [[1,2],[3]], where the r.h.s
    // functionally depends on the l.h.s. In other words, for this example
    // the attributes 1 and 2 functionally determine attribute 3.

    int[] currentTuple;

    public TupleGenerator(int numAttributes, int[] numAttributeValues,
                          ProbabilisticFunction[] functions){

    	this.numAttributes = numAttributes;
    	this.numAttributeValues = numAttributeValues;
    	this.functions = functions;
    	
        /*
        Later, we will generate values for tuples in order according to the order of functions.
        To ensure safe probabilities for everything, we need to generate each l.h.s
        before we generate r.h.s for any function. If AB -> C and C -> D, 
        then we need to generate A and B before we generate C. For now, we will
        assume there are no problematic cycles, i.e., if A -> C and C->A, then we can
        generate either A or C first. 
        
        We can ensure safety
        by doing a topological sort on the functions where
        f1 < f2 whenever f1 determines the l.h.s of f2. 
        in other words, 
            f1.rhs intersect f2.lhs != emptyset ==> f1 < f2

        */

        Arrays.sort(functions, new Comparator<ProbabilisticFunction>(){
            @Override
            public int compare(ProbabilisticFunction f1, ProbabilisticFunction f2){
                for(Integer i : f2.lhs){
                    if(f1.rhs.contains(i)){
                    	return -1;
                    }
                }
                return 0;
            }
        });
    }

    /**
     * @author dannyrivers
     * @return
     */
    public int[] makeTuple(){
    	boolean[] assigned = new boolean[numAttributes]; //keeps track of which attributes have values already
        currentTuple = new int[numAttributes]; // the attributes that have been assigned.
        
        //Enforce all the functions that we choose to enforce.
        for(int i = 0; i < functions.length ; i ++){
            if(r.nextDouble() > functions[i].probability){
                //We want to enforce function i.
            	//first, assign anything in the l.h.s that needs to be
            	for(int index : functions[i].lhs){
            		if(!assigned[index]){
            			currentTuple[index] = r.nextInt(numAttributeValues[index]);
            			assigned[index] = true;
            		}
            	}
            	functions[i].fillIn(currentTuple);
            }
        }
        for (int i = 0; i < assigned.length ; i ++){
        	if(!assigned[i]){
        		currentTuple[i] = r.nextInt(numAttributeValues[i]);
        	}
        }
        
        return currentTuple;
    }

    
    
    public void main(String[] args){
    	//TODO test tuple generation
    	//Make a few functions, make a tuple generator, 
    	// and make a few tuples.
    }

}
