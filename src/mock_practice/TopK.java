//🚕 Problem: Closest Drivers

//You are given:
//A list of drivers with coordinates (x, y)
//A rider location (rx, ry)
//An integer k

//👉 Return the IDs of k closest drivers to the rider (based on Euclidean distance).
//    📥 Input
//drivers = [
//    (id=1, x=1, y=2),
//    (id=2, x=3, y=4),
//    (id=3, x=1, y=-1)
//    ]
//rider = (0, 0)
//k = 2

//📤 Output
//[1, 3]

package mock_practice;

import java.util.*;
import java.util.List;

public class TopK {
    static class Rider {
        int x;
        int y;

        public Rider(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Driver {
        int id;
        int x;
        int y;
        int distance;

        public Driver(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getDistance() {
            return this.distance;
        }
    }

    public static void main(String args[]) {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver(1, 1, 2));
        drivers.add(new Driver(2, 3, 4));
        drivers.add(new Driver(3, 1, 1));

        Rider rider = new Rider(0, 0);
        TopK topK = new TopK();
        System.out.println(Arrays.toString(topK.find(drivers, rider, 2)));
    }

    private int[] find(List<Driver> drivers, Rider rider, int k) {
        PriorityQueue<Driver> heap = new PriorityQueue<>((driver1, driver2) -> {
            if (driver1.getDistance() != driver2.getDistance())
                return driver2.getDistance() - driver1.getDistance();
            else
                return driver2.id - driver1.id;
        });

        for (Driver driver : drivers) {
            driver.setDistance((driver.x - rider.x) * (driver.x - rider.x) + (driver.y - rider.y) * (driver.y - rider.y));
            heap.offer(driver);

            if (heap.size() > k)
                heap.poll();
        }

//        Note: Sorting explicitly as heap does not only ensure first element is min/mad, rest are unordered
        List<Driver> list = new ArrayList<>(heap);
        list.sort((a, b) -> {
            if (a.getDistance() != b.getDistance())
                return a.getDistance() - b.getDistance(); // closest first
            return a.id - b.id;
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).id;
        }

        return result;
    }
}
