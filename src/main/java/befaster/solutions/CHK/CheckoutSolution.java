package befaster.solutions.CHK;

public class CheckoutSolution {
    private final int A_PRICE = 50;
    private final int B_PRICE = 30;
    private final int C_PRICE = 20;
    private final int D_PRICE = 15;
    private final int E_PRICE = 40;
    private final int F_PRICE = 10;
    private final int AAA_PRICE = 130;
    private final int AAAAA_PRICE = 200;
    private final int BB_PRICE = 45;

    public Integer checkout(String skus) {
        int aCounter = 0;
        int bCounter = 0;
        int cCounter = 0;
        int dCounter = 0;
        int eCounter = 0;
        int fCounter = 0;
        int total = 0;

        for (int i = 0; i < skus.length(); i++) {
            switch (skus.charAt(i)) {
                case 'A':
                    aCounter++;
                    break;
                case 'B':
                    bCounter++;
                    break;
                case 'C':
                    cCounter++;
                    break;
                case 'D':
                    dCounter++;
                    break;
                case 'E':
                    eCounter++;
                    break;
                case 'F':
                    fCounter++;
                    break;
                default:
                    return -1;
            }
        }

        total += AAAAA_PRICE * (aCounter / 5);
        aCounter = aCounter % 5;
        total += AAA_PRICE * (aCounter / 3);
        total += A_PRICE * (aCounter % 3);

        bCounter -= eCounter / 2;
        if (bCounter > 0) {
            total += BB_PRICE * (bCounter / 2);
            total += B_PRICE * (bCounter % 2);
        }

        total += C_PRICE * cCounter;

        total += D_PRICE * dCounter;

        total += E_PRICE * eCounter;

        fCounter -= fCounter / 3;
        total += F_PRICE * fCounter;

        return total;
    }
}


