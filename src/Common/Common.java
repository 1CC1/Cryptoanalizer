package Common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Common {
    private static final String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String digits = "0123456789";
    private static final String symbols = ",./<>?;':\"[]{}`~!@#№$%^&*()-_=+\\|";
    private static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "texts" + File.separator;

    public static final char[] ALPHABET = (rus + rus.toUpperCase() + digits + symbols).toCharArray();

    public static String moveLetters(int key, String[] parameters) {
        Path src = Path.of(TXT_FOLDER + parameters[0]);
        Path dst = Path.of(TXT_FOLDER + parameters[1]);

        try (BufferedReader reader = Files.newBufferedReader(src);
             BufferedWriter writer = Files.newBufferedWriter(dst)) {

            String line;
            while ((line = reader.readLine()) != null) {
                char[] charArray = line.toCharArray();

                for (int i = 0; i < charArray.length - 1; i++) {
                    int charIndex = Arrays.binarySearch(ALPHABET, charArray[i]);
                    if (charIndex >= 0) {
                        int newCharIndex = (charIndex + key) % ALPHABET.length;
                        if (key < 0 && newCharIndex < 0) {
                            newCharIndex = ALPHABET.length + newCharIndex;
                        }
                        newCharIndex = Math.abs(newCharIndex);
                        charArray[i] = ALPHABET[newCharIndex];
                    }
                }

                writer.write(charArray);
                if (reader.ready()) {
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "done";
    }
}
