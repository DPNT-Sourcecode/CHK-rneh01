package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CheckoutSolution {
    private final Map<String, Map<Integer, ?>> PRICES = new TreeMap<>();

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
    }

    public Integer checkout(String skus) {
        final Map<String, Integer> counters = new HashMap<>();

        for (int i = 0; i < skus.length(); i++) {
            String sku = String.valueOf(skus.charAt(i));
            if (PRICES.containsKey(sku)) {
                int quantity =  counters.getOrDefault(sku, 0);
                counters.put(sku, ++quantity);
            } else {
                return -1;
            }
        }

        applyItemReductionOffers(counters);

        return calculateTotal(counters);
    }

    private Integer calculateTotal(Map<String, Integer> counters) {
        int total = 0;
        for (Map.Entry<String, Integer> skuQuantity: counters.entrySet()) {
            String sku = skuQuantity.getKey();
            int quantity = skuQuantity.getValue();

            TreeMap<Integer, ?> priceMap = (TreeMap<Integer, ?>) PRICES.get(sku);
            for (Map.Entry<Integer, ?> map : priceMap.descendingMap().entrySet()) {
                int multiBuyQuantity = map.getKey();
                Object priceObj = map.getValue();
                if (priceObj instanceof Integer && quantity >= multiBuyQuantity) {
                    total += quantity / multiBuyQuantity * (Integer) priceObj;
                    quantity = quantity % multiBuyQuantity;
                }
            }
        }


        return total;
    }

    private void applyItemReductionOffers(Map<String, Integer> counters) {
        for (Map.Entry<String, Integer> skuQuantity : counters.entrySet()) {
            String sku = skuQuantity.getKey();
            int quantity = skuQuantity.getValue();

            TreeMap<Integer, ?> priceMap = (TreeMap<Integer, ?>) PRICES.get(sku);
            Object priceObj = priceMap.get(priceMap.lastKey());
            if (priceObj instanceof String && quantity >= priceMap.lastKey()) {
                int discountedQuantity = quantity / priceMap.lastKey();
                String discountedSku = (String) priceObj;
                counters.put(
                        discountedSku,
                        counters.getOrDefault(discountedSku, 0) - discountedQuantity
                );
            }
        }
    }
}

