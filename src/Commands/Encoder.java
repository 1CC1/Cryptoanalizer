package Commands;

import Common.Common;

import java.io.IOException;

public class Encoder implements Action {
    @Override
    public String execute(int key, String[] parameters) throws IOException {
        return "Encoding " + Common.moveLetters(key, parameters);
    }
}
