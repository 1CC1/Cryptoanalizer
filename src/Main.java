import Commands.Action;
import Commands.Decoder;
import Commands.Encoder;
import Common.Common;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Arrays.sort(Common.ALPHABET);

        if (args.length > 0) {
            String action = args[0];

            if (action.equals("1") || action.equals("2")) {
                int key = Integer.parseInt(args[1]) % Common.ALPHABET.length;
                String[] parameters = Arrays.copyOfRange(args, 2, args.length);
                String result = "";

                if (action.equals("1")) {
                    Action encoder = new Encoder();
                    try {
                        result = encoder.execute(key, parameters);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("2")) {
                    Action decoder = new Decoder();
                    try {
                        result = decoder.execute(key, parameters);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.printf("%s%n", result);
            }
//            else if (action.equals("2")) {
//
//            } else if (action.equals("3")) {
//
//            }
        } else {
            // interactive mode
//        Scanner scanner = new Scanner(System.in);
//
//        showModes(false);
//
//        while (scanner.hasNextInt()) {
//            int mode = scanner.nextInt();
//            if (mode == 1) {
//                Action encoder = new Encoder();
//                String result = encoder.execute(args);
//                System.out.printf("%s", result);
//
//                showModes(true);
//            } else if (mode == 2) {
//                System.out.printf("2 mode");
//                showModes(true);
//            } else if (mode == 3) {
//                System.out.printf("3 mode");
//                showModes(true);
//            } else if (mode == 0) {
//                break;
//            }
//        }
        }
    }

    private static void showModes(boolean addLine) {
        if (addLine) {
            System.out.println();
        }

        System.out.printf("%s%n", "Select mode:");
        System.out.printf("%s%n", "1 - encode");
        System.out.printf("%s%n", "2 - decode");
        System.out.printf("%s%n", "3 - brute force");
        System.out.printf("%s%n", "0 - exit");
        System.out.println();
    }
}

