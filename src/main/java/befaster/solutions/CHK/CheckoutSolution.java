package befaster.solutions.CHK;

public class CheckoutSolution {
    private final int A_PRICE = 50;
    private final int B_PRICE = 30;
    private final int C_PRICE = 20;
    private final int D_PRICE = 15;
    private final int AAA_PRICE = 130;
    private final int BB_PRICE = 45;

    public Integer checkout(String skus) {
        String[] splittedSkus = skus.split(",");
        int aCounter = 0;
        int bCounter = 0;
        int cCounter = 0;
        int dCounter = 0;
        int total = 0;

        for (int i = 0; i < splittedSkus.length; i++) {
            switch (splittedSkus[i]) {
                case "A":
                    aCounter++;
                    break;
                case "B":
                    bCounter++;
                    break;
                case "C":
                    cCounter++;
                    break;
                default:
                    dCounter++;
            }
        }

        total += AAA_PRICE * aCounter / 3;
        total += A_PRICE * aCounter % 3;
        total += BB_PRICE * bCounter / 2;
        total += B_PRICE * bCounter % 2;
        total += C_PRICE * cCounter;
        total += D_PRICE * dCounter;

        return total;
    }
}


