package komal.designProblems.parkingLot;

import java.util.ArrayList;
import java.util.Collections;

public class Row {
    public int rowNumber;
    public ArrayList<Slot> slotArrayList ;

    Row(int n, ArrayList<Slot> list){
        rowNumber = n;
        slotArrayList = list;
    }

    public ArrayList<SmallSlot> getSmallSlots(){
        ArrayList<SmallSlot> smallSlots = new ArrayList<>();
        for(Slot slot: slotArrayList){
            if(slot.size == Size.SMALL && slot.isAvailable)
                smallSlots.add((SmallSlot)slot);
        }
        return smallSlots;
    }

    public ArrayList<LargeSlot> getLargeSlots(){
        ArrayList<LargeSlot> largeSlots = new ArrayList<>();
        for(Slot slot: slotArrayList){
            if(slot.size == Size.LARGE&& slot.isAvailable)
                largeSlots.add((LargeSlot) slot);
        }
        return largeSlots;
    }
    public ArrayList<CompactSlot> getCSlots(){
        ArrayList<CompactSlot> compactSlot = new ArrayList<>();
        for(Slot slot: slotArrayList){
            if(slot.size == Size.COMPACT&& slot.isAvailable)
                compactSlot.add((CompactSlot)slot);
        }
        return compactSlot;
    }

    public ArrayList<Slot> getAvailableSlots(Vehicle vehicle){
        ArrayList<Slot> arrayList = new ArrayList<>();

        for(Slot slot: slotArrayList){
            if(slot.canPark(vehicle)&& slot.isAvailable)
                arrayList.add(slot);
        }
        return arrayList;
       /* Size size = vehicle.size;
        switch (size){
            case COMPACT:
                for(Slot slot: slotArrayList){
                    if(slot.canPark(vehicle)&& slot.isAvailable)
                        arrayList.add(slot);
                }
                return arrayList;
            case SMALL:
                for(Slot slot: slotArrayList){
                    if(slot.canPark(vehicle)&& slot.isAvailable)
                        arrayList.add(slot);
                }
                return arrayList;

        }*/
    }
}
