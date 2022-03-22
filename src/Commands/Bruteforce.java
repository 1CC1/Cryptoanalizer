package Commands;

import Common.Common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bruteforce implements Action {
    @Override
    public String execute(String[] parameters) throws IOException {
        int bestKey = Integer.MIN_VALUE;
        int bestEntryCount = 0;

        for (int i = 1; i < Common.ALPHABET.length; i++) {
//        for (int i = 1; i < 4; i++) {
            int key = i % Common.ALPHABET.length;
            Common.moveLetters(-key, parameters);

            Path dst = Path.of(Common.TXT_FOLDER + parameters[1]);
            String text = Files.readString(dst);

            Pattern pattern = Pattern.compile(Common.REGEX_PATTERN);
            Matcher matcher = pattern.matcher(text);

            int entryCount = 0;
            while (matcher.find()) {
                entryCount++;
            }
            if (entryCount > bestEntryCount) {
                bestEntryCount = entryCount;
                bestKey = key;
            }
        }

        if (bestKey != Common.ALPHABET.length) {
            Common.moveLetters(-bestKey, parameters);
        }

        return "Bruteforce done. Key = " + bestKey;
    }
}
