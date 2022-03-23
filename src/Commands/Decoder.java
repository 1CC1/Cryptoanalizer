package Commands;

import Common.Common;

import java.util.Arrays;

public class Decoder implements Action {
    @Override
    public String execute(String[] parameters) {
        System.out.println("Decoding...");

        int key = Integer.parseInt(parameters[0]) % Common.ALPHABET.length;
        parameters = Arrays.copyOfRange(parameters, 1, parameters.length);

        return "Decoding " + Common.moveLetters(-key, parameters);
    }
}
