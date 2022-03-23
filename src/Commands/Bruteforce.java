package Commands;

import Common.Common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bruteforce implements Action {
    @Override
    public String execute(String[] parameters) {
        System.out.println("Bruteforcing...");

        int bestKey = Integer.MIN_VALUE;
        int bestEntryCount = 0;

        for (int key = 1; key < Common.ALPHABET.length + 1; key++) {
            Common.moveLetters(-key, parameters);

            Path dst = Path.of(parameters[1]);
            if (dst.getParent() == null) {
                dst = Path.of(Common.TXT_FOLDER + parameters[1]);
            }
            String text = "";
            try {
                text = Files.readString(dst);
            } catch (IOException e) {
                e.printStackTrace();
            }

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
