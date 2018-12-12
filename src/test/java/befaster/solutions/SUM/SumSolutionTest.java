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
        assertThat(sum.compute(50, 99), equalTo(149));
    }

    @Test(expected = Exception.class)
    public void should_not_compute_sum() throws Exception {
        sum.compute(100, 50);
    }
}


