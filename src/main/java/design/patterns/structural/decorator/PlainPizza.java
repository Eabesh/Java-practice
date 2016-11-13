package design.patterns.structural.decorator;

public class PlainPizza implements Pizza {

    public String getDescription() {
        return "Pizza";
    }

    public int getCost() {
        return 100;
    }

}
