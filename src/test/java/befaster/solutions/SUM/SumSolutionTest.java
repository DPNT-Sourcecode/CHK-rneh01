package befaster.solutions.SUM;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumSolutionTest {
    private SumSolution sum;

    @Before
    public void setUp() {

        sum = new SumSolution();
    }

    @Test
    public void compute_sum() throws Exception {
        assertThat(sum.compute(1, 1), equalTo(2));
    }

    @Test
    public void compute_another_sum() throws Exception {
        assertThat(sum.compute(50, 100), equalTo(150));
    }

    @Test(expected = java.lang.Exception.class)
    public void should_not_compute_when_x_greater_than_100() throws Exception {
        sum.compute(101, 50);
    }

    @Test(expected = java.lang.Exception.class)
    public void should_not_compute_when_x_less_than_0() throws Exception {
        sum.compute(-1, 50);
    }

    @Test(expected = java.lang.Exception.class)
    public void should_not_compute_when_y_greater_than_100() throws Exception {
        sum.compute(33, 101);
    }

    @Test(expected = java.lang.Exception.class)
    public void should_not_compute_when_y_less_than_0() throws Exception {
        sum.compute(33, -1);
    }
}
