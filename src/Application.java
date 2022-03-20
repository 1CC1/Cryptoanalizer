import Commands.Action;
import Commands.Encoder;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);

            if (action.equals("1")) {
                Encoder encoder = new Encoder();
                String result = null;
                try {
                    result = encoder.execute(parameters, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s", result);
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

