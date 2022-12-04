package ua.foxminded.charcounter;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();

            CharCounter charCounter = new CharCounter();
            Map<Character, Integer> countResult = charCounter.countCharacters(input);
            CharCounterFormatter formatter = new CharCounterFormatter();
            System.out.println(formatter.format(countResult));
        }
    }
}