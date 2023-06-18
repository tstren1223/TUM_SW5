package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        detectDeadlock(new SwimmingPool());
    }

    public static void detectDeadlock(SwimmingPool swimmingPool) {
        // TODO 2
        List<Swimmer> swimmers = new ArrayList<Swimmer>();
        for (int i = 0; i < 100; i++) {
            swimmers.add(new Swimmer());
            if (i % 2 ==0) {
                swimmers.get(i).goToSwimmingPool(swimmingPool, SwimmingPoolActionOrder.CHANGING_ROOM_BEFORE_LOCKER);
            }
            else {
                swimmers.get(i).goToSwimmingPool(swimmingPool, SwimmingPoolActionOrder.LOCKER_BEFORE_CHANGING_ROOM);
            }
        }
    }
}
