
public class FactoryDemo {
    public static void main(String[] args) {
        Pizza p1 = PizzaFactory.createPizza("margherita");
        p1.prepare();

        Pizza p2 = PizzaFactory.createPizza("pepperoni");
        p2.prepare();
    }
}
