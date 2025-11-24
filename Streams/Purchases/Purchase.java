package Streams.Purchases;

import java.util.HashMap;
import java.util.Map;

public class Purchase {
    String cardName;
    HashMap<Commodity, Double> items = new HashMap<>();

    public Purchase(String cardName) {
        this.cardName = cardName;
    }

    public void addItem(Commodity item, Double number) {
        items.put(item, number);
    }

    public HashMap<Commodity, Double> getItems() {
        return items;
    }


}
