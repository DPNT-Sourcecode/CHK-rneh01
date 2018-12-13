package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    private final Map<String, Integer> INDIVIDUAL_PRICES = new HashMap<>();
    private final Map<String, Integer> counters = new HashMap<>();

    private final int AAA_PRICE = 130;
    private final int AAAAA_PRICE = 200;
    private final int BB_PRICE = 45;
    private final int FIVE_H_PRICE = 45;
    private final int TEN_H_PRICE = 80;
    private final int TWO_K_PRICE = 150;
    private final int FIVE_P_PRICE = 200;
    private final int THREE_Q_PRICE = 80;
    private final int TWO_V_PRICE = 90;
    private final int THREE_V_PRICE = 130;


    public CheckoutSolution() {
        INDIVIDUAL_PRICES.put("A", 50);
        INDIVIDUAL_PRICES.put("B", 30);
        INDIVIDUAL_PRICES.put("C", 20);
        INDIVIDUAL_PRICES.put("D", 15);
        INDIVIDUAL_PRICES.put("E", 40);
        INDIVIDUAL_PRICES.put("F", 10);
        INDIVIDUAL_PRICES.put("G", 20);
        INDIVIDUAL_PRICES.put("H", 10);
        INDIVIDUAL_PRICES.put("I", 35);
        INDIVIDUAL_PRICES.put("J", 60);
        INDIVIDUAL_PRICES.put("K", 80);
        INDIVIDUAL_PRICES.put("L", 90);
        INDIVIDUAL_PRICES.put("M", 15);
        INDIVIDUAL_PRICES.put("N", 40);
        INDIVIDUAL_PRICES.put("O", 10);
        INDIVIDUAL_PRICES.put("P", 50);
        INDIVIDUAL_PRICES.put("Q", 30);
        INDIVIDUAL_PRICES.put("R", 50);
        INDIVIDUAL_PRICES.put("S", 30);
        INDIVIDUAL_PRICES.put("T", 20);
        INDIVIDUAL_PRICES.put("U", 40);
        INDIVIDUAL_PRICES.put("V", 50);
        INDIVIDUAL_PRICES.put("W", 20);
        INDIVIDUAL_PRICES.put("X", 90);
        INDIVIDUAL_PRICES.put("Y", 10);
        INDIVIDUAL_PRICES.put("Z", 50);

        counters.put("A", 0);
        counters.put("B", 30);
        counters.put("C", 20);
        counters.put("D", 15);
        counters.put("E", 40);
        counters.put("F", 10);
        counters.put("G", 20);
        INDIVIDUAL_PRICES.put("H", 10);
        INDIVIDUAL_PRICES.put("I", 35);
        INDIVIDUAL_PRICES.put("J", 60);
        INDIVIDUAL_PRICES.put("K", 80);
        INDIVIDUAL_PRICES.put("L", 90);
        INDIVIDUAL_PRICES.put("M", 15);
        INDIVIDUAL_PRICES.put("N", 40);
        INDIVIDUAL_PRICES.put("O", 10);
        INDIVIDUAL_PRICES.put("P", 50);
        INDIVIDUAL_PRICES.put("Q", 30);
        INDIVIDUAL_PRICES.put("R", 50);
        INDIVIDUAL_PRICES.put("S", 30);
        INDIVIDUAL_PRICES.put("T", 20);
        INDIVIDUAL_PRICES.put("U", 40);
        INDIVIDUAL_PRICES.put("V", 50);
        INDIVIDUAL_PRICES.put("W", 20);
        INDIVIDUAL_PRICES.put("X", 90);
        INDIVIDUAL_PRICES.put("Y", 10);
        INDIVIDUAL_PRICES.put("Z", 50);
    }

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
        total += INDIVIDUAL_PRICES.get("A") * (aCounter % 3);

        bCounter -= eCounter / 2;
        if (bCounter > 0) {
            total += BB_PRICE * (bCounter / 2);
            total += INDIVIDUAL_PRICES.get("B") * (bCounter % 2);
        }

        total += INDIVIDUAL_PRICES.get("C") * cCounter;

        total += INDIVIDUAL_PRICES.get("D") * dCounter;

        total += INDIVIDUAL_PRICES.get("E") * eCounter;

        fCounter -= fCounter / 3;
        total += INDIVIDUAL_PRICES.get("F") * fCounter;

        return total;
    }
}

