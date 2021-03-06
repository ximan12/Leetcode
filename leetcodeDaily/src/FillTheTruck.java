import java.util.*;
public class FillTheTruck {
    public static int fillTheTruck(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            Integer count = map.getOrDefault(unitsPerBox.get(i) * (-1), 0);
            count += boxes.get(i);
            map.put(unitsPerBox.get(i) * (-1), count);
        }

        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) >= truckSize) {
                res = truckSize * key * (-1);
                return res;
            }
            res += map.get(key) * key * (-1);
            truckSize -= map.get(key);
        }

        return res;


    }
}
