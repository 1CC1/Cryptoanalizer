package Constants;

import java.io.File;

public class Constants {
    private static final String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String digits = "0123456789";
    private static final String symbols = ",./<>?;':\"[]{}`~!@#№$%^&*()-_=+\\|";

    public static final String ALPHABET = rus + rus.toUpperCase() + digits + symbols;
    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "texts" + File.separator;
}
