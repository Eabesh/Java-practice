package komal.designProblems.parkingLot;

public class LargeSlot extends  Slot {

    LargeSlot(int sId){
        slotId = sId;
        size = Size.LARGE;
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return (vehicle.size == Size.LARGE|| vehicle.size == Size.COMPACT || vehicle.size == Size.SMALL);
    }
}
