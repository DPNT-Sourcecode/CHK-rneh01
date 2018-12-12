package befaster.solutions.HLO;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloSolutionTest {
    private HelloSolution helloSolution;

    @Before
    public void setUp() {
        helloSolution = new HelloSolution();
    }

    @Test
    public void testHelloWithEmptyName() {
        assertThat(helloSolution.hello(""), equalTo("Hello, World!"));
    }

    @Test
    public void testHelloWithNullName() {
        assertThat(helloSolution.hello(null), equalTo("Hello, World!"));
    }

    @Test
    public void testHelloWithAName() {
        assertThat(helloSolution.hello("John"), equalTo("Hello, John!"));
    }
}
