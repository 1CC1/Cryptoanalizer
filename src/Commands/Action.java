package Commands;

import java.io.IOException;

public interface Action {
    String execute(String[] parameters, int key) throws IOException;
}
