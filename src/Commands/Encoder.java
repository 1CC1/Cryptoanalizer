package Commands;

import Constants.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Encoder implements Action {
    @Override
    public String execute(String[] parameters) throws IOException {
        Path src = Path.of(Constants.TXT_FOLDER + parameters[0]);
        Path dst = Path.of(Constants.TXT_FOLDER + parameters[1]);
        int key = Integer.parseInt(parameters[2]) % Constants.ALPHABET.length();

        try (BufferedReader reader = Files.newBufferedReader(src);
             BufferedWriter writer = Files.newBufferedWriter(dst)) {

            while (reader.ready()) {
                char[] line = reader.readLine().toCharArray();

                for (int i = 0; i < line.length - 1; i++) {
                    int charIndex = Constants.ALPHABET.indexOf(line[i]);
                    if (charIndex >= 0) {
                        int newCharIndex = (charIndex + key) % Constants.ALPHABET.length();
                        line[i] = Constants.ALPHABET.charAt(newCharIndex);
                    }
                }

                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Encoding done";
    }
}
