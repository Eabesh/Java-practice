package komal.designProblems.parkingLot;

public class SmallSlot extends Slot {
    SmallSlot(int sId){
        slotId = sId;
        size = Size.SMALL;
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return ( vehicle.size == Size.COMPACT || vehicle.size == Size.SMALL);
    }
}
