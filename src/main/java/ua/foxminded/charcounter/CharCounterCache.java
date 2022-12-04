package ua.foxminded.charcounter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounterCache {

    private final HashMap<String, LinkedHashMap<Character, Integer>> cache = new HashMap<>();

    public boolean contains(String input) {
        return cache.containsKey(input);
    }

    public Map<Character, Integer> getCountResult(String input) {
        return cache.get(input);
    }

    public void put(String input, LinkedHashMap<Character, Integer> countResult) {
        cache.put(input, countResult);
    }
}
