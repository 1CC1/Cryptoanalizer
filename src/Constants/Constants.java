package Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Constants {
    private static final String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String digits = "0123456789";
    private static final String symbols = " ,./<>?;':\"[]{}`~!@#№$%^&*()-_=+\\|";

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "texts" + File.separator;
    public static final char[] ALPHABET = (rus + rus.toUpperCase() + digits + symbols).toCharArray();
}
