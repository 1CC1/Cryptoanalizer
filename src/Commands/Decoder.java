package Commands;

import Constants.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Decoder {
    public StringWriter decode(String[] parameters) throws IOException {
        int key = -Integer.parseInt(parameters[0]) % Constants.ALPHABET.length;
        Path src = Path.of(Constants.TXT_FOLDER + parameters[1]);
        StringWriter writer = new StringWriter();

        try (BufferedReader reader = Files.newBufferedReader(src)
//             ; BufferedWriter writer = Files.newBufferedWriter(dst)
        ) {

            String line;
            while ((line = reader.readLine()) != null) {
                char[] charArray = line.toCharArray();

                for (int i = 0; i < charArray.length - 1; i++) {
                    int charIndex = Arrays.binarySearch(Constants.ALPHABET, charArray[i]);
                    if (charIndex >= 0) {
                        int newCharIndex = (charIndex + key) % Constants.ALPHABET.length;
                        if (newCharIndex < 0) {
                            newCharIndex = Constants.ALPHABET.length + newCharIndex;
                        }
                        newCharIndex = Math.abs(newCharIndex);
                        charArray[i] = Constants.ALPHABET[newCharIndex];
                    }
                }

                writer.write(charArray.toString());

//                writer.write(charArray);
//                if (reader.ready()) {
//                    writer.newLine();
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer;
    }

    public String writeToFile(StringWriter stringWriter, String[] parameters) {
        Path dst = Path.of(Constants.TXT_FOLDER + parameters[2]);

        try (BufferedWriter bufWriter = Files.newBufferedWriter(dst)) {
            bufWriter.write(stringWriter.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Decoding done";
    }
}
