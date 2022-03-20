package Commands;

import Common.Common;

import java.io.IOException;

public class Decoder implements Action {
    @Override
    public String execute(int key, String[] parameters) throws IOException {
        return "Decoding " + Common.moveLetters(-key, parameters);
    }
}
