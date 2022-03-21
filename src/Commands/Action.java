package Commands;

import java.io.IOException;
import java.nio.file.Path;

public interface Action {
    String execute(String[] parameters) throws IOException;
}
