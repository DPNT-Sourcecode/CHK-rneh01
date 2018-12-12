package befaster.solutions.SUM;

public class SumSolution {

    public int compute(int x, int y) throws Exception {
        if (x > 100 || x < 0 || y > 100 || y < 0) throw new Exception("Out of range");

        return x + y;
    }

}
