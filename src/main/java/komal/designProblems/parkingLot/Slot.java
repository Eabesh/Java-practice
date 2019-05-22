package komal.designProblems.parkingLot;

public abstract class Slot {
    public int slotId;
    public Size size;
    public boolean isAvailable = true;
    public int vehicleNumber;


    public abstract boolean canPark(Vehicle vehicle);
}
