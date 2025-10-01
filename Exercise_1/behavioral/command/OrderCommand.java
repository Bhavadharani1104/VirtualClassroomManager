
public class OrderCommand implements Command {
    private String foodItem;

    public OrderCommand(String item) {
        this.foodItem = item;
    }

    @Override
    public void execute() {
        System.out.println("Order placed: " + foodItem);
    }
}
