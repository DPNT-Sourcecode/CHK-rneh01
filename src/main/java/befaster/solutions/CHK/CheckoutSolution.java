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
        counters.put("B", 0);
        counters.put("C", 0);
        counters.put("D", 0);
        counters.put("E", 0);
        counters.put("F", 0);
        counters.put("G", 0);
        counters.put("H", 0);
        counters.put("I", 0);
        counters.put("J", 0);
        counters.put("K", 0);
        counters.put("L", 0);
        counters.put("M", 0);
        counters.put("N", 0);
        counters.put("O", 0);
        counters.put("P", 0);
        counters.put("Q", 0);
        counters.put("R", 0);
        counters.put("S", 0);
        counters.put("T", 0);
        counters.put("U", 0);
        counters.put("V", 0);
        counters.put("W", 0);
        counters.put("X", 0);
        counters.put("Y", 0);
        counters.put("Z", 0);
    }

    public Integer checkout(String skus) {
        int total = 0;

        for (int i = 0; i < skus.length(); i++) {
            String sku = String.valueOf(skus.charAt(i));
            Integer counter = counters.get(sku);
            if (counter != null)
                counters.put(sku, counter + 1);
            else
                return -1;
        }

        total += AAAAA_PRICE * (counters.get("A") / 5);
        counters.put("A", counters.get("A") % 5);
        total += AAA_PRICE * (counters.get("A") / 3);
        total += INDIVIDUAL_PRICES.get("A") * (counters.get("A") % 3);

        counters.put("B", counters.get("B") - (counters.get("E") / 2));
        if (counters.get("B") > 0) {
            total += BB_PRICE * (counters.get("B") / 2);
            total += INDIVIDUAL_PRICES.get("B") * (counters.get("B") % 2);
        }

        counters.put("F", counters.get("F") - (counters.get("F") / 3));
        counters.put("M", counters.get("M") - (counters.get("N") / 3));

        total += INDIVIDUAL_PRICES.get("C") * counters.get("C");

        total += INDIVIDUAL_PRICES.get("D") * counters.get("D");

        total += INDIVIDUAL_PRICES.get("E") * counters.get("E");

        total += INDIVIDUAL_PRICES.get("F") * counters.get("F");

        total += INDIVIDUAL_PRICES.get("G") * counters.get("G");

        total += TEN_H_PRICE * (counters.get("H") / 10);
        counters.put("H", counters.get("H") % 10);
        total += FIVE_H_PRICE * (counters.get("H") / 5);
        total += INDIVIDUAL_PRICES.get("H") * (counters.get("H") % 5);

        total += INDIVIDUAL_PRICES.get("I") * counters.get("I");

        total += INDIVIDUAL_PRICES.get("J") * counters.get("J");

        total += TWO_K_PRICE * (counters.get("K") / 2);
        total += INDIVIDUAL_PRICES.get("K") * (counters.get("K") % 2);

        total += INDIVIDUAL_PRICES.get("L") * counters.get("L");

        total += counters.get("M") > 0
                ? INDIVIDUAL_PRICES.get("M") * counters.get("M")
                : 0;

        total += INDIVIDUAL_PRICES.get("N") * counters.get("N");

        total += INDIVIDUAL_PRICES.get("O") * counters.get("O");

        total += FIVE_P_PRICE * (counters.get("P") / 5);
        total += INDIVIDUAL_PRICES.get("P") * (counters.get("P") % 5);

        counters.put("Q", counters.get("Q") - (counters.get("R") / 3));

        if (counters.get("Q") > 0) {
            total += THREE_Q_PRICE * (counters.get("Q") / 3);
            total += INDIVIDUAL_PRICES.get("Q") * (counters.get("Q") % 3);

        }

        total += INDIVIDUAL_PRICES.get("R") * counters.get("R");

        total += INDIVIDUAL_PRICES.get("S") * counters.get("S");

        total += INDIVIDUAL_PRICES.get("T") * counters.get("T");

        counters.put("U", counters.get("U") - (counters.get("U") / 4));

        total += INDIVIDUAL_PRICES.get("U") * counters.get("U");

        total += THREE_V_PRICE * (counters.get("V") / 3);
        counters.put("V", counters.get("V") % 3);
        total += TWO_V_PRICE * (counters.get("V") / 2);
        total += INDIVIDUAL_PRICES.get("V") * (counters.get("V") % 2);

        total += INDIVIDUAL_PRICES.get("W") * counters.get("W");

        total += INDIVIDUAL_PRICES.get("X") * counters.get("X");

        total += INDIVIDUAL_PRICES.get("Y") * counters.get("Y");

        total += INDIVIDUAL_PRICES.get("Z") * counters.get("Z");

        return total;
    }
}
