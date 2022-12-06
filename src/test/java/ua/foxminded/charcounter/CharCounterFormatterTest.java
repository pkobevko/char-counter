package ua.foxminded.charcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CharCounterFormatterTest {

    CharCounterFormatter formatter = new CharCounterFormatter();
    CharCounter charCounter = new CharCounter();

    @Test
    void format_shouldThrowIllegalArgumentException_whenPassingNull() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                formatter.format(null);
            });

        String expectedMessage = "You cannot pass null to this function";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void format_shouldReturnEmptyString_whenPassingEmptyString() {
        String expected = "";

        Map<Character, Integer> countResult = charCounter.countCharacters("");

        String actual = formatter.format(countResult);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldWorkCorrect_whenInputStringContentsSingleCharacter() {
        String expected = "\"a\" - 1";

        Map<Character, Integer> countResult = charCounter.countCharacters("a");
        String actual = formatter.format(countResult);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldWorkCorrect_whenInputStringContentsSameCharacterMultipleTimes() {
        String expected = "\"a\" - 7";

        Map<Character, Integer> countResult = charCounter.countCharacters("aaaaaaa");
        String actual = formatter.format(countResult);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldWorkCorrect_whenInputStringContentsOnlySpaces() {
        String expected = "\" \" - 5";

        Map<Character, Integer> countResult = charCounter.countCharacters("     ");
        String actual = formatter.format(countResult);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnCorrectlyFormattedString_whenExample1() {
        String expected = """
            "h" - 1
            "e" - 1
            "l" - 3
            "o" - 2
            " " - 1
            "w" - 1
            "r" - 1
            "d" - 1
            "!" - 1""";

        Map<Character, Integer> countResult = charCounter.countCharacters("hello world!");
        String actual = formatter.format(countResult);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void format_shouldReturnCorrectlyFormattedString_whenExample2() {
        String expected = """
            "P" - 1
            "e" - 2
            "t" - 1
            "r" - 1
            "o" - 3
            " " - 1
            "K" - 1
            "b" - 1
            "v" - 1
            "k" - 1""";

        Map<Character, Integer> countResult = charCounter.countCharacters("Petro Kobevko");
        String actual = formatter.format(countResult);

        Assertions.assertEquals(expected, actual);
    }
}