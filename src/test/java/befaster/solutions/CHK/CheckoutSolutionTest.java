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
        assertThat(checkoutSolution.checkout("AEX-"), equalTo(-1));
    }

    @Test
    public void testCheckoutWithExtendedValidSkus() {
        assertThat(checkoutSolution.checkout("AAAABBAAAAACDDE"), equalTo(130 + 50 + 45 + 200 + 20 + 15 + 15 + 40));
    }

    @Test
    public void testCheckoutWithFreeB() {
        assertThat(checkoutSolution.checkout("BBEEE"), equalTo(30 + 40 + 40 + 40));
    }

    @Test
    public void testCheckoutWithFreeB_butBDoesNotExist() {
        assertThat(checkoutSolution.checkout("EE"), equalTo(40 + 40));
    }

    @Test
    public void testCheckoutWithFreeF() {
        assertThat(checkoutSolution.checkout("BFFFBBF"), equalTo(10 + 10 + 45 + 30 + 10));
    }

    @Test
    public void testCheckoutWithFullSkuRange() {
        assertThat(checkoutSolution.checkout("GHHHHHIJKLMNNN"), equalTo(20 + 45 + 35 + 60 + 80 + 90 + 40));
    }
}




