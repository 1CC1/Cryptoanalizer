import Commands.Action;
import Commands.Bruteforce;
import Commands.Decoder;
import Commands.Encoder;
import Common.Common;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arrays.sort(Common.ALPHABET);

        if (args.length > 0) {
            performWithArguments(args);
        } else {
            performInInteractiveMode();
        }
    }

    private static void performInInteractiveMode() {
        String result = "";
        Scanner scanner = new Scanner(System.in);

        Display.showModes(false);

        while (scanner.hasNextInt()) {
            int mode = scanner.nextInt();
            if (mode == 1) {
                int key = Display.askForKey(scanner);
                String src = Display.askForFileName(scanner, "source", "text.txt", true);
                String dst = Display.askForFileName(scanner, "destination", "encoded.txt", false);
                String[] parameters = new String[]{Integer.toString(key), src, dst};

                result = runEncoder(parameters);
            } else if (mode == 2) {
                int key = Display.askForKey(scanner);
                String src = Display.askForFileName(scanner, "source", "encoded.txt", true);
                String dst = Display.askForFileName(scanner, "destination", "decoded.txt", false);
                String[] parameters = new String[]{Integer.toString(key), src, dst};

                result = runDecoder(parameters);
            } else if (mode == 3) {
                scanner.nextLine();
                String src = Display.askForFileName(scanner, "source", "encoded.txt", true);
                String dst = Display.askForFileName(scanner, "destination", "decoded.txt", false);
                String[] parameters = new String[]{src, dst};

                result = runBruteForce(parameters);
            } else if (mode == 0) {
                break;
            }

            System.out.printf("%s%n", result);
            Display.showModes(true);
        }
    }

    private static void performWithArguments(String[] args) {
        String result = "";
        String action = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        switch (action) {
            case "1" -> {
                Action encoder = new Encoder();
                result = encoder.execute(parameters);
            }
            case "2" -> {
                Action decoder = new Decoder();
                result = decoder.execute(parameters);
            }
            case "3" -> {
                Action bruteForce = new Bruteforce();
                result = bruteForce.execute(parameters);
            }
        }

        System.out.printf("%s%n", result);
    }

    private static String runEncoder(String[] parameters) {
        String result;

        Action encoder = new Encoder();
        result = encoder.execute(parameters);

        return result;
    }

    private static String runDecoder(String[] parameters) {
        String result;

        Action decoder = new Decoder();
        result = decoder.execute(parameters);

        return result;
    }

    private static String runBruteForce(String[] parameters) {
        String result;

        Action bruteForce = new Bruteforce();
        result = bruteForce.execute(parameters);

        return result;
    }

}

