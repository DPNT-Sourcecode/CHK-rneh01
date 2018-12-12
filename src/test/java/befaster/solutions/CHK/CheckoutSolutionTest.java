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
    public void testCheckoutWithBasicValidSkus() {
        assertThat(checkoutSolution.checkout("AAABBACDD"), equalTo(130 + 45 + 50 + 20 + 15 + 15));
    }

    @Test
    public void testCheckoutWithInvalidSkus() {
        assertThat(checkoutSolution.checkout("AEF"), equalTo(-1));
    }

    @Test
    public void testCheckoutWithExtendedValidSkus() {
        assertThat(checkoutSolution.checkout("AAABBAAAAACDDE"), equalTo(130 + 45 + 200 + 20 + 15 + 15 + 40));
    }
}

