package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSolutionTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void testCheckoutWithValidSkus() {
        assertThat(checkoutSolution.checkout("AAABBCDD"), equalTo(130 + 45 + 20 + 15 + 15));
    }

    @Test
    public void testCheckoutWithInvalidSkus() {
        assertThat(checkoutSolution.checkout("AEF"), equalTo(-1));
    }
}


