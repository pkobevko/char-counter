package ua.foxminded.charcounter;

import java.util.Map;

public class CharCounterFormatter {

    public String format(Map<Character, Integer> data) {
        validate(data);
        StringBuilder stringBuilder = new StringBuilder();

        data.forEach((k, v) -> {
            stringBuilder.append(String.format("\"%c\" - %d\n", k, v));
        });

        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private void validate(Map<Character, Integer> data) {
        if (data == null) {
            throw new IllegalArgumentException("You cannot pass null to this function");
        }
    }
}
