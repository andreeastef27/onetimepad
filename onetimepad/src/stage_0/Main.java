package stage_0;

import java.io.IOException;
import java.nio.file.*;
import static stage_0.Decrypt.decrypt;

public class Main {
    public static void main(String[] args) {
        try {
            String cipherText = Files.readString(Paths.get("D:\\Master Viena\\sem 1\\ISM\\One time pad\\onetimepad\\src\\stage_0\\stage_0.txt")).toUpperCase();
            String decryptedText = decrypt(cipherText).toLowerCase();

            System.out.println("Decrypted text: " + decryptedText);
        } catch (IOException e) {
            System.err.println("Error reading string: " + e.getMessage());
        }
    }
}


