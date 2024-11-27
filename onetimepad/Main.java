package stage_1;

public class Main {
    public static void main(String[] args) {
        String guessedPlaintext = "that's just as bad as listening to the beatles without earmuffs";
        String cipherText = "430b05474446425910171013584b4300595042044a455e0a444d5c585c0f01454d0b42470900425706504609564245165d175c0d4c10135357455f1300044748";
        String foundKey = "";
        int i = 0;
        while (i < guessedPlaintext.length()) {
            int xorResult = Integer.parseInt(cipherText.substring(i * 2, i * 2 + 2), 16)
                    ^ (int) guessedPlaintext.charAt(i);
            foundKey += (char) xorResult;
            i++;
        }
        System.out.println(foundKey);
    }
}
