package Commands;

import Common.Common;

import java.io.IOException;
import java.util.Arrays;

public class Encoder implements Action {
    @Override
    public String execute(String[] parameters) throws IOException {
        int key = Integer.parseInt(parameters[0]) % Common.ALPHABET.length;
        parameters = Arrays.copyOfRange(parameters, 1, parameters.length);

        return "Encoding " + Common.moveLetters(key, parameters);
    }
}
