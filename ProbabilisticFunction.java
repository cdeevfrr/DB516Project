

import java.util.HashMap;
import java.util.HashSet;

public class ProbabilisticFunction {
    double probability;
    HashSet<Integer> lhs;
    HashSet<Integer> rhs;
    
    
    /**
     * Constructs a default probabilistic function from attribute
     * 0 to attribute 1.
     * @param probability
     */
    public ProbabilisticFunction(double probability){
    	this(probability, new int[]{0}, new int[]{1});
    }
    
    
    /**
     * TODO add clear explanation of why the lhs and rhs are integers.
     * 
     * @param probability
     * @param lhs
     * @param rhs
     */
    public ProbabilisticFunction(double probability, int[] lhs, int[] rhs){
    	this.probability = probability;
    	this.lhs = new HashSet<Integer>(lhs.length);
    	for(int i = 0; i < lhs.length ; i ++){
    		this.lhs.add(lhs[i]);
    	}
    	this.rhs = new HashSet<Integer>(rhs.length);
    	for(int i = 0; i < rhs.length ; i ++){
    		this.rhs.add(rhs[i]);
    	}
    }
    
    
    /**
     * Fill in the rhs of current tuple based 
     * on the values currently in the lhs.
     * 
     *  are using a very simple function for all 
     * generated probabilistic functions: 
     * 
     * the sum of the lhs + 5, divided evenly among the r.h.s.
     * 
     * @Author Danny Rivers
     * @param currentTuple
     */
    public void fillIn(int[] currentTuple){
    	int sum = 0;
    	for(int i : lhs){
    		sum += currentTuple[i];
    	}
    	
    }
    
    /**
     * Given this dictionary (hash map) of values, compute the values for 
     * each of this function's outputs. For example, if the function is 
     * 	AB -> CD
     * then we would be given a hash map like
     * A:1  B:5   
     * and would return
     * C:3  D:2
     * (for example)
     * 
     * For now (11/15/2017), all functions simply compute the sum of the lhs
     * and divide that evenly among all outputs. In the future, we may support
     * arbitrary functions.
     * 
     * @author Danny Rivers
     * @return
     */
    public HashMap<Integer, Integer> valuesOf(HashMap<Integer, Integer> lhsValues){
    	int sum = 0;
    	for(Integer t : lhsValues.values() ){
    		sum += t;
    	}
    	int resultValue = sum / rhs.size();
    	
    	HashMap<Integer, Integer> result = new HashMap<Integer, Integer>(rhs.size());
    	for(int i : rhs){
    		result.put(i, resultValue);
     	}
    	return result;
    }
    
}
