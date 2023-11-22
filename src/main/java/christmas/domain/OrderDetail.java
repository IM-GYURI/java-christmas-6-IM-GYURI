package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class OrderDetail {
    private Map<String, Integer> orderMap;

    public OrderDetail() {
        this.orderMap = new HashMap<>();
    }

    public void addMenu(String menu, int quantity) {
        orderMap.merge(menu, quantity, Integer::sum);
    }

    public Map<String, Integer> getOrderMap() {
        return orderMap;
    }
}
