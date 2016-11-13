package design.patterns.structural.decorator;

public class PizzaMaker {

    public static void main(String[] args) {

        Pizza pizza = new TomatoSauce(new Mozzerella(new PlainPizza()));

        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());

    }
}
