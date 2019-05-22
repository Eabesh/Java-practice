package komal.designProblems.parkingLot;

public class CompactSlot extends Slot{
    CompactSlot(int sId){
        slotId = sId;
        size = Size.COMPACT;
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return ( vehicle.size == Size.COMPACT);
    }
}
