import java.util.*;
public class DesignSearchAutocompleteSystem {
    private final char END_CHAR = '#';
    private Map<String, Integer> sentencesMap = new HashMap<>(); // (sentence, count)
    private String data = ""; // current search word

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) { // initialize database
            sentencesMap.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == END_CHAR) { // update db and clean the data
            sentencesMap.put(data, sentencesMap.getOrDefault(data, 0) + 1);
            data = "";
            return new ArrayList<>();
        }

        data += c;
        PriorityQueue<Sentence> queue = new PriorityQueue<>((a, b) -> (a.count == b.count ? a.letters.compareTo(b.letters) : b.count - a.count));
        // iterate all the sentence in the database and use startsWith to compare two strings
        for (String s : sentencesMap.keySet()) {
            if (s.startsWith(data)) queue.offer(new Sentence(s, sentencesMap.get(s)));
        }

        List<String> result = new ArrayList<>();
        while(!queue.isEmpty() && result.size() < 3) {
            Sentence a = queue.poll();
            result.add(a.letters);
        }
        return result;
    }

    public static class Sentence {
        String letters;
        int count;
        Sentence(String s, int c) {
            letters = s;
            count = c;
        }
    }


}
