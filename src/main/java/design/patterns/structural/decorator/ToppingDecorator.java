package design.patterns.structural.decorator;

abstract public class ToppingDecorator implements Pizza {

    protected Pizza tempPizza;

    ToppingDecorator(Pizza newPizza) {
        tempPizza = newPizza;
    }

    public String getDescription() {
        return tempPizza.getDescription();
    }

    public int getCost() {
        return tempPizza.getCost();
    }

}
