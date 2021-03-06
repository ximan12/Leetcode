import java.util.*;
public class PackagingAutomation {

    public int packing (List<Integer> items) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer item : items) {
            map.merge(item, 1, Integer::sum);
        }

        int next = 1;
        int borrowed = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            //there is next value in the map  [1 4 5 5 5 5 5] -> [1 2 3 4 5 5 5]
            if (map.containsKey(next)) {
                int payback = borrowed - map.get(next);
                if (payback < 0) {
                    int times = payback * (-1);
                    i = i + times - 1;
                    while (times > 0) {
                        times--;
                        list.add(next);
                    }
                    borrowed = 0;

                } else {
                    borrowed = payback;
                    list.add(next);
                }
            }
            //there is not next value in the map
            else {
                list.add(next);
                borrowed++;
            }
            next++;

        }

        return list.get(items.size() - 1);
    }
}
