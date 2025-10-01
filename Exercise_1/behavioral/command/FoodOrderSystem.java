

import java.util.LinkedList;
import java.util.Queue;

public class FoodOrderSystem {
    private Queue<Command> orders = new LinkedList<>();

    public void takeOrder(Command order) {
        orders.add(order);
    }

    public void processOrders() {
        while (!orders.isEmpty()) {
            orders.poll().execute();
        }
    }
}
