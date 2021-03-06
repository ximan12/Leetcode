import java.util.*;

public class FetchItemsToDisplay {

    public static List<String> fetchItemsToDisplay(int sortParameter, int sortOrder, int itemsPerPage, int pageNumber, Map<String, int[]> items) {
        List<String> ordered = new ArrayList<>(items.keySet());
        ordered.sort((a, b) -> {
            int res;
            if (sortParameter == 0) {
                res = a.compareTo(b);
            } else {

                res = items.get(a)[sortParameter - 1] - items.get(b)[sortParameter - 1];
            }
            return res * (sortOrder == 0 ? 1 : -1);


        });
        return ordered.subList(itemsPerPage * pageNumber,
                Math.min(itemsPerPage * pageNumber + itemsPerPage, ordered.size()));


    }
}
