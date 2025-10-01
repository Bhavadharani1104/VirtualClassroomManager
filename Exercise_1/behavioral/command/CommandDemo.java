
public class CommandDemo {
    public static void main(String[] args) {
        FoodOrderSystem system = new FoodOrderSystem();

        system.takeOrder(new OrderCommand("Pizza"));
        system.takeOrder(new OrderCommand("Burger"));
        system.takeOrder(new OrderCommand("Pasta"));

        system.processOrders();
    }
}
