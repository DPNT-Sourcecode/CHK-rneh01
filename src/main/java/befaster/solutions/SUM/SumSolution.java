package befaster.solutions.SUM;

import befaster.runner.SolutionNotImplementedException;

public class SumSolution {

    public int compute(int x, int y) throws Exception {
        if (x > 100) throw new Exception("Out of range");

        return x + y;
    }

}



