import Trial1.TupleGenerator;

public class Driver {

    /**
     * upload two databases to the external DBMS, one where the
     * tuples are split according the the function, and the other
     * where tuples are not split.
     *
     *  Be sure to give both databases unique names.
     *
     *  Function is a array like [1, 2], [3] which would mean "attributes
     *  1 and 2 functionally determine attribute 3."
     *
     *  Use t.makeTuple()
     */
    public String[] makeDatabase(int numTuples, TupleGenerator t, int[][] function){

    }
    public void splitTuple(int[][] function){

    }


    /**
     * Collect stats from DBMS about these db names, and store in a file.
     * @param dbNames
     */
    public void gatherStatistics(String[] dbNames){

    }
}
