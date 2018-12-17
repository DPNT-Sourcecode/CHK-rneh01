package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CheckoutSolution {
    private final Map<String, Map<Integer, ?>> PRICES = new TreeMap<>();
    private final Map<String, Integer> counters = new HashMap<>();


    public CheckoutSolution() {
        Map<Integer, Integer> numPrice = new TreeMap<>();
        numPrice.put(1, 50);
        numPrice.put(3, 130);
        numPrice.put(5, 200);
        PRICES.put("A", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 30);
        numPrice.put(2, 45);
        PRICES.put("B", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 20);
        PRICES.put("C", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 15);
        PRICES.put("D", numPrice);

        Map<Integer, Object> mixPrice = new TreeMap<>();
        mixPrice.put(1, 40);
        mixPrice.put(2, "B");
        PRICES.put("E", mixPrice);

        mixPrice = new TreeMap<>();
        mixPrice.put(1, 10);
        mixPrice.put(3, "F");
        PRICES.put("F", mixPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 20);
        PRICES.put("G", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 10);
        numPrice.put(5, 45);
        numPrice.put(10, 80);
        PRICES.put("H", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 35);
        PRICES.put("I", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 60);
        PRICES.put("J", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 80);
        numPrice.put(2, 150);
        PRICES.put("K", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 90);
        PRICES.put("L", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 15);
        PRICES.put("M", numPrice);

        mixPrice = new TreeMap<>();
        mixPrice.put(1, 40);
        mixPrice.put(3, "M");
        PRICES.put("N", mixPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 10);
        PRICES.put("O", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 50);
        numPrice.put(5, 200);
        PRICES.put("P", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 30);
        numPrice.put(3, 80);
        PRICES.put("Q", numPrice);

        mixPrice = new TreeMap<>();
        mixPrice.put(1, 50);
        mixPrice.put(3, "Q");
        PRICES.put("R", mixPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 30);
        PRICES.put("S", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 20);
        PRICES.put("T", numPrice);

        mixPrice = new TreeMap<>();
        mixPrice.put(1, 40);
        mixPrice.put(4, "U");
        PRICES.put("U", mixPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 50);
        numPrice.put(2, 90);
        numPrice.put(3, 130);
        PRICES.put("V", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 20);
        PRICES.put("W", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 90);
        PRICES.put("X", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 10);
        PRICES.put("Y", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 50);
        PRICES.put("Z", numPrice);

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
            if (PRICES.containsKey(sku)) {
                int quantity =  counters.get(sku);
                counters.put(sku, ++quantity);

                TreeMap<Integer, ?> priceMap = (TreeMap<Integer, ?>) PRICES.get(sku);
                Object priceObj = priceMap.get(priceMap.lastKey());
                if (priceObj instanceof String && quantity >= priceMap.lastKey()) {
                    int discountedQuantity = quantity / priceMap.lastKey();
                    String discountedSku = (String) priceObj;
                    counters.put(discountedSku, counters.get(discountedSku) - discountedQuantity);
                }
            } else {
                return -1;
            }
        }

        for (Map.Entry<String, Integer> skuQuantity: counters.entrySet()) {
            String sku = skuQuantity.getKey();
            int quantity = skuQuantity.getValue();

            TreeMap<Integer, ?> priceMap = (TreeMap<Integer, ?>) PRICES.get(sku);
            for (Map.Entry<Integer, ?> map: priceMap.descendingMap().entrySet()) {
                int multiBuyQuantity = map.getKey();
                Object priceObj = map.getValue();
                if (priceObj instanceof Integer && quantity >= multiBuyQuantity) {
                    int multiBuyPrice = (Integer) priceObj;
                    int multiBuyLots = quantity / multiBuyQuantity;
                    total += multiBuyLots * multiBuyPrice;
                    quantity = quantity % multiBuyQuantity;
                }
            }
        }


        return total;
    }
}
