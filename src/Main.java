import Commands.Action;
import Commands.Bruteforce;
import Commands.Decoder;
import Commands.Encoder;
import Common.Common;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Arrays.sort(Common.ALPHABET);

        String result = "";
        if (args.length > 0) {
            result = performWithArguments(args);
        } else {
            result = performInInteractiveMode();
        }

        System.out.printf("%s%n", result);
    }

    private static String performInInteractiveMode() {
        String result = "";
        Scanner scanner = new Scanner(System.in);

        showModes(false);

        while (scanner.hasNextInt()) {
            int mode = scanner.nextInt();
            if (mode == 1) {
                int key = askAboutKey(scanner);
//                Action encoder = new Encoder();
//                try {
//                    result = encoder.execute(parameters);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                showModes(true);
            } else if (mode == 2) {
                int key = askAboutKey(scanner);
//                Action decoder = new Decoder();
//                try {
//                    result = decoder.execute(parameters);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                showModes(true);
            } else if (mode == 3) {
//                Action bruteForce = new Bruteforce();
//                try {
//                    result = bruteForce.execute(parameters);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                showModes(true);
            } else if (mode == 0) {
                break;
            }
        }
        return result;
    }

    private static int askAboutKey(Scanner scanner) {
        System.out.printf("Enter key (or press ENTER to choose random from 1 to %d):%n", Common.ALPHABET.length);

        int key = 0;
        boolean isFirstLine = true;

        String readString = scanner.nextLine();
        while (true) {
            if (scanner.hasNextLine()) {
//                isFirstLine = false;
                readString = scanner.nextLine();
                if (readString.equals("")) {
                    Random random = new Random();
                    key = random.nextInt(Common.ALPHABET.length);
                    break;
                } else {
                    key = Integer.parseInt(readString);
                    break;
                }
            }
        }

        return key;
    }

    private static String performWithArguments(String[] args) {
        String result = "";
        String action = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        if (action.equals("1")) {
            Action encoder = new Encoder();
            try {
                result = encoder.execute(parameters);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (action.equals("2")) {
            Action decoder = new Decoder();
            try {
                result = decoder.execute(parameters);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (action.equals("3")) {
            Action bruteForce = new Bruteforce();
            try {
                result = bruteForce.execute(parameters);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private static void showModes(boolean addLine) {
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
}

