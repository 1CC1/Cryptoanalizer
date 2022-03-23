import Common.Common;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class Display {
    static void showModes(boolean addLine) {
        if (addLine) {
            System.out.println();
        }

        System.out.println("Select mode:");
        System.out.println("1 - encode");
        System.out.println("2 - decode");
        System.out.println("3 - brute force");
        System.out.println("0 - exit");
        System.out.println();
    }

    static int askForKey(Scanner scanner) {
        System.out.printf("Enter key (or press ENTER to choose random from 1 to %d):%n", Common.ALPHABET.length);
        int key;

        String line = scanner.nextLine();
        while (true) {
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.equals("")) {
                    Random random = new Random();
                    key = random.nextInt(Common.ALPHABET.length);
                    break;
                } else {
                    try {
                        key = Integer.parseInt(line);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter the number");
                    }
                }
            }
        }

        return key;
    }

    static String askForFileName(Scanner scanner, String messagePart, String defaultFileName, boolean makeSureFileExists) {
        System.out.printf("Enter %s file name (or press ENTER to choose \"%s\"):%n", messagePart, Common.TXT_FOLDER + defaultFileName);
        String fileName;

        String line = "";
        while (true) {
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.equals("")) {
                    fileName = Common.TXT_FOLDER + defaultFileName;
                    break;
                } else {
                    if (makeSureFileExists && Files.notExists(Path.of(line))) {
                        System.out.printf("%nFile \"%s\" is not exists%n", line);
                        System.out.printf("Enter %s file name (or press ENTER to choose \"%s\"):%n", messagePart, Common.TXT_FOLDER + defaultFileName);
                    } else {
                        fileName = line;
                        break;
                    }
                }
            }
        }

        return fileName;
    }
}
