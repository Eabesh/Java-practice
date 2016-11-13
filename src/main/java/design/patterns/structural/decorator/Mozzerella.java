package design.patterns.structural.decorator;

public class Mozzerella extends ToppingDecorator {

    Mozzerella(Pizza newPizza) {
        super(newPizza);
    }

    public String getDescription() {
        return tempPizza.getDescription() + " added mozzeralla";
    }

    public int getCost() {
        return tempPizza.getCost() + 10;
    }

}