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

    public static final String REGEX_PATTERN = "[^а-яА-я][ ]?([нН]а|[нН]ад|[иИ]ли|[тТ]ам|[пП]о|[оО]б|[иИ]з|[иИ]х|[еЕ]й|[еЕ]ё|[бБ]ез|[мМ]не|[пП]од|[нН]е|[нН]у|[кК]ак|[тТ]ак|[чЧ]то|[нН]ас|[еЕ]сли|[вВ]ы|[вВ]ас|[вВ]сех|[вВ]с[юя]|[бБ]ыл[а]|[нН]о|[оО]н[а]?|[оО]т|[дД]ля)[ ]";
    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "texts" + File.separator;
    public static final char[] ALPHABET = (rus + rus.toUpperCase() + digits + symbols).toCharArray();

    public static String moveLetters(int key, String[] parameters) {
        Path src = Path.of(parameters[0]);
        if (src.getParent() == null) {
            src = Path.of(TXT_FOLDER + parameters[0]);
        }

        Path dst = Path.of(parameters[1]);
        if (dst.getParent() == null) {
            dst = Path.of(TXT_FOLDER + parameters[1]);
        }

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
