package stage_0;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Decrypt {
    public static String decrypt(String cipherText) {
        //String ENGLISH_FREQ = "ETAOINSHRDLCUMWFGYPBVKJXQZ"; //initial frequency string
        String ENGLISH_FREQ = "ETAOINSHRLDUMYCWGBFPKVZJXQ";

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        List<Character> sortedChars = freqMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .toList();

        Map<Character, Character> mapping = new HashMap<>();
        for (int i = 0; i < sortedChars.size() && i < ENGLISH_FREQ.length(); i++) {
            mapping.put(sortedChars.get(i), ENGLISH_FREQ.charAt(i));
        }

        StringBuilder decryptedText = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) {
                char decryptedChar = mapping.getOrDefault(c, c);
                decryptedText.append(Character.isUpperCase(c) ? decryptedChar : Character.toLowerCase(decryptedChar));
            } else {
                decryptedText.append(c);
            }
        }
        return decryptedText.toString();
    }
}
