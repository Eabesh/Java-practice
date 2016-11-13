package design.patterns.structural.decorator;

public class TomatoSauce extends ToppingDecorator {

    TomatoSauce(Pizza newPizza) {
        super(newPizza);
    }

    public String getDescription() {
        return tempPizza.getDescription() + " added sauce";
    }

    public int getCost() {
        return tempPizza.getCost() + 5;
    }

}