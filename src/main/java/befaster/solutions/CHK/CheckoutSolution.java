package befaster.solutions.CHK;

import java.util.*;

public class CheckoutSolution {
    private final Map<String, Map<Integer, ?>> PRICES = new TreeMap<>();
    private final Integer SPECIAL_OFFER_LOT_SIZE = 3;
    private final Integer SPECIAL_OFFER_LOT_PRICE = 45;
    private final List<String> SPECIAL_OFFER_QUALIFIED_SKUS = new ArrayList();

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
        numPrice.put(1, 20);
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
        numPrice.put(1, 17);
        PRICES.put("X", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 20);
        PRICES.put("Y", numPrice);

        numPrice = new TreeMap<>();
        numPrice.put(1, 21);
        PRICES.put("Z", numPrice);

        SPECIAL_OFFER_QUALIFIED_SKUS.add("X");
        SPECIAL_OFFER_QUALIFIED_SKUS.add("S");
        SPECIAL_OFFER_QUALIFIED_SKUS.add("T");
        SPECIAL_OFFER_QUALIFIED_SKUS.add("Y");
        SPECIAL_OFFER_QUALIFIED_SKUS.add("Z");
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
        int specialOfferQualifiedSkuQuantity = 0;

        for (Map.Entry<String, Integer> skuQuantity: counters.entrySet()) {
            String sku = skuQuantity.getKey();
            int quantity = skuQuantity.getValue();

            TreeMap<Integer, ?> priceMap = (TreeMap<Integer, ?>) PRICES.get(sku);
            if (SPECIAL_OFFER_QUALIFIED_SKUS.contains(sku)) {
                specialOfferQualifiedSkuQuantity += quantity;
            } else {
                for (Map.Entry<Integer, ?> map : priceMap.descendingMap().entrySet()) {
                    int multiBuyQuantity = map.getKey();
                    Object priceObj = map.getValue();
                    if (priceObj instanceof Integer && quantity >= multiBuyQuantity) {
                        total += quantity / multiBuyQuantity * (Integer) priceObj;
                        quantity = quantity % multiBuyQuantity;
                    }
                }
            }
        }

        total += (specialOfferQualifiedSkuQuantity / SPECIAL_OFFER_LOT_SIZE) * SPECIAL_OFFER_LOT_PRICE;
        int remainingQualifiedSkuQuantity = specialOfferQualifiedSkuQuantity % SPECIAL_OFFER_LOT_SIZE;
        int lastIndex = 0;
        while (remainingQualifiedSkuQuantity > 0) {
            String sku = SPECIAL_OFFER_QUALIFIED_SKUS.get(lastIndex);
            int quantity = counters.getOrDefault(sku, 0);
            Object priceObj = PRICES.get(sku).get(1);

            if (!(priceObj instanceof Integer))
                return -1;

            if (remainingQualifiedSkuQuantity > quantity) {
                total += quantity * (Integer)priceObj;
                remainingQualifiedSkuQuantity -= quantity;
                lastIndex++;
            } else {
                total += remainingQualifiedSkuQuantity * (Integer)priceObj;
                remainingQualifiedSkuQuantity = 0;
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
