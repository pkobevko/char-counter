package ua.foxminded.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter {

    private CharCounterCache cache = new CharCounterCache();

    public void setCache(CharCounterCache cache) {
        this.cache = cache;
    }

    public Map<Character, Integer> countCharacters(String input) {
        validate(input);

        if (cache.containsString(input)) {
            return cache.getValue(input);
        }

        LinkedHashMap<Character, Integer> countResult = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            countResult.putIfAbsent(character, 0);
            countResult.put(character, countResult.get(character) + 1);
        }
        cache.put(input, countResult);
        return countResult;
    }

    private void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("You cannot pass null to this function");
        }
    }
}
