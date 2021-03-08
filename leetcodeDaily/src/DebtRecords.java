import java.util.*;

public class DebtRecords {
    public static List<String> debtRecords(List<List<String>> debts) {

        Map<String, Integer> map = new HashMap<>();
        List<String> s = new ArrayList<>();
        s.add("Nobody has a negative balance.");

        for (List<String> items : debts) {
            int amount = Integer.parseInt(items.get(2));
            map.merge(items.get(0), amount * (-1),
                    Integer::sum );
            map.merge(items.get(1), amount,
                    Integer::sum );
        }

        List<String> names = new ArrayList<>(map.keySet());
        names.sort((a, b) -> {
            return map.get(a) - map.get(b);
        });
        if (map.get(names.get(0)) >= 0)
            return s;
        s.remove(0);
        int prev = map.get(names.get(0));
        for (String name : names) {
            if (map.get(name) == prev)
                s.add(name);
            else break;
        }
        Collections.sort(s);
        return s;
    }
}
