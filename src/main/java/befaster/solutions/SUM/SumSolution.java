package befaster.solutions.SUM;

public class SumSolution {

    public int compute(int x, int y) throws Exception {
        if (x > 99 || x < 1 || y > 99 || y < 1) throw new Exception("Out of range");

        return x + y;
    }

}
