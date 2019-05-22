package komal.designProblems.parkingLot;

import java.util.ArrayList;

public class Level {
    public   int levelNumber;
    public ArrayList<Row> rows;

    Level(int number,ArrayList<Row> rows) {
        this.levelNumber = number;
        this.rows = rows;
    }
}
