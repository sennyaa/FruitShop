package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> storage = new HashMap<>();

    public static void setQuantity(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public static void addQuantity(String fruit, int quantity) {
        storage.merge(fruit, quantity,Integer::sum);
    }

    public static void clear() {
        storage.clear();
    }
}
