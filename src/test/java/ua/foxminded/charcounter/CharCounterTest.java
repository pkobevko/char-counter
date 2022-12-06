package ua.foxminded.charcounter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class CharCounterTest {

    @Test
    void countCharacters_shouldThrowIllegalArgumentException_whenPassingNull() {
        CharCounter charCounter = new CharCounter();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                charCounter.countCharacters(null);
            });

        String expectedMessage = "You cannot pass null to this function";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    void countCharacters_shouldReturnMapWithCorrectData_whenExample1() {
        CharCounter charCounter = new CharCounter();
        LinkedHashMap<Character, Integer> countResultExpected = new LinkedHashMap<>();
        countResultExpected.put('h', 1);
        countResultExpected.put('e', 1);
        countResultExpected.put('l', 3);
        countResultExpected.put('o', 2);
        countResultExpected.put(' ', 1);
        countResultExpected.put('w', 1);
        countResultExpected.put('r', 1);
        countResultExpected.put('d', 1);
        countResultExpected.put('!', 1);

        Map<Character, Integer> countResultActual = charCounter.countCharacters("hello world!");

        Assertions.assertEquals(countResultExpected, countResultActual);
    }

    @Test
    void countCharacters_shouldGetValueFromCache_whenInputStringAlreadyInCache() {
        LinkedHashMap<Character, Integer> expectedCountResult = new LinkedHashMap<>();
        expectedCountResult.put('t', 1);

        CharCounterCache charCounterCache = new CharCounterCache();
        charCounterCache.put("test", expectedCountResult);

        CharCounter charCounter = new CharCounter();
        charCounter.setCache(charCounterCache);

        Map<Character, Integer> actualCountResult = charCounter.countCharacters("test");

        Assertions.assertEquals(expectedCountResult, actualCountResult);
    }

    @Test
    void countCharacters_shouldPutDataInCache_whenInputStringIsAbsentInCache() {
        CharCounterCache charCounterCache = new CharCounterCache();
        CharCounter charCounter = new CharCounter();
        charCounter.setCache(charCounterCache);
        charCounter.countCharacters("test");
        Assertions.assertTrue(charCounterCache.containsString("test"));
    }
}