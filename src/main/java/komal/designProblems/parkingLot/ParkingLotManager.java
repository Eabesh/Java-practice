package komal.designProblems.parkingLot;

import java.util.ArrayList;

public class ParkingLotManager {

    public ParkingLot init() {
        CompactSlot compactSlot1 = new CompactSlot(1);
        CompactSlot compactSlot2 = new CompactSlot(2);
        CompactSlot compactSlot3 = new CompactSlot(3);
        CompactSlot compactSlot4 = new CompactSlot(4);

        SmallSlot smallSlot1 = new SmallSlot(1);
        SmallSlot smallSlot2 = new SmallSlot(2);
        SmallSlot smallSlot3 = new SmallSlot(3);
        SmallSlot smallSlot4 = new SmallSlot(4);

        LargeSlot largeSlot1 = new LargeSlot(1);
        LargeSlot largeSlot2 = new LargeSlot(2);
        LargeSlot largeSlot3 = new LargeSlot(3);
        LargeSlot largeSlot4 = new LargeSlot(4);

        ArrayList<Slot> slotArrayList = new ArrayList<>();
        slotArrayList.add(compactSlot1);
        slotArrayList.add(compactSlot2);
        slotArrayList.add(compactSlot3);
        slotArrayList.add(compactSlot4);
        slotArrayList.add(smallSlot1);
        slotArrayList.add(smallSlot2);
        slotArrayList.add(smallSlot3);
        slotArrayList.add(smallSlot4);
        slotArrayList.add(largeSlot1);
        slotArrayList.add(largeSlot2);
        slotArrayList.add(largeSlot3);
        slotArrayList.add(largeSlot4);

        Row row1 = new Row(1,slotArrayList);
        Row row2 = new Row(2,slotArrayList);
        ArrayList<Row> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        Level level1 = new Level(1,rows);
        Level level2 = new Level(2,rows);
        ArrayList<Level> levels = new ArrayList<>();
        levels.add(level1);
        levels.add(level2);
        ParkingLot parkingLot = new ParkingLot(levels);
        return parkingLot;
    }

    public ParkingTicket isParkingAvailable(Vehicle vehicle){
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        ParkingLot lot = parkingLotManager.init();
        System.out.println("lot size "+ lot.levels.size());
        Size size = vehicle.size;

        ArrayList<Slot> availableSlots = null;
        Row availablRow = null;
        Level availableLevel = null;
        String ticketNumber="";
        for(Level level: lot.levels){
            System.out.println("level number is "+ level.levelNumber);
            availableSlots = null;
            for(Row row : level.rows){
                System.out.println("row number is "+ row.rowNumber);
                availableSlots = row.getAvailableSlots(vehicle);
                if(availableSlots!= null) {
                    System.out.println("row number1 is "+ row.rowNumber);
                    availablRow= row;
                    ticketNumber=ticketNumber+""+row.rowNumber;
                    break;
                }
            }
            if(availableSlots!= null) {
                availableLevel = level;
                ticketNumber=ticketNumber+""+level.levelNumber;
                break;
            }
        }
        Slot availableSlot = null;
        if(availableSlots!=null ) {
           availableSlot = availableSlots.get(0);
           ticketNumber=ticketNumber+""+availableSlot.slotId;
           availableSlot.isAvailable = false;
           availablRow.slotArrayList.add(availableSlot);
           availableLevel.rows.add(availablRow);
        }
        ParkingTicket parkingTicket = new ParkingTicket(vehicle.vehicleNumber,ticketNumber);
        return parkingTicket;
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(123,Size.SMALL);
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        System.out.println("ticket is "+parkingLotManager.isParkingAvailable(vehicle).ticketNumber);
        Vehicle vehicle2 = new Vehicle(1234,Size.SMALL);
        System.out.println("ticket2 is "+parkingLotManager.isParkingAvailable(vehicle2).ticketNumber);


    }

}
