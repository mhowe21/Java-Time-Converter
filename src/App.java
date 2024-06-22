
import java.util.*;
import java.lang.System;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class App {
    public static void main(String[] args) throws Exception {
        int optionSelect = 0;
        Scanner scan = new Scanner(System.in);

        boolean keepGoing = true;
        // optionSelect = scan.nextInt();

        while (keepGoing == true) {
            System.out.println(
                    "Please slect your option\n1. Get current local time\n2. Get GMT time\n3. get current offset from GMT\n4.Get offset from 2 diffrent timecodes\n5. Get time Codes\n6. Exit");
            optionSelect = scan.nextInt();
            if (optionSelect == 1) {

                ZonedDateTime time = ZonedDateTime.now();
                System.out.println(STR."\{time}");
                keepGoing = shouldContinue();
                System.out.println();
            } else if (optionSelect == 2) {
                ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Z"));
                System.out.println(STR."\{time}");
                keepGoing = shouldContinue();

            } else if (optionSelect == 3) {
                ZonedDateTime time = ZonedDateTime.now();
                System.out.println(STR."\{time.getOffset()} from GMT");
                        keepGoing = shouldContinue();
                System.out.println();

            } else if (optionSelect == 4) {
                System.out.print("Enter first time zone: ");
                scan.nextLine();
                String Zone1 = scan.nextLine();
                System.out.print("Enter second time zone: ");
                String Zone2 = scan.nextLine();
                ZonedDateTime timeZone1 = ZonedDateTime.now(ZoneId.of(Zone1));
                ZonedDateTime timeZone2 = ZonedDateTime.now(ZoneId.of(Zone2));
                ZoneOffset offset1 = timeZone1.getOffset();
                ZoneOffset offset2 = timeZone2.getOffset();
                try {
                    int differenceInHours = offset2.getTotalSeconds() / 3600 - offset1.getTotalSeconds() / 3600;
                    System.out.println(Zone2 + " is " + differenceInHours + " hours offset from " + Zone1);
                } catch (Exception e) {
                    System.out.println("Error" + e);

                }

                keepGoing = shouldContinue();
                System.out.println();

            } else if (optionSelect == 5) {
                // TimeZone tZone = TimeZone.getDefault();
                System.out.println(ZoneId.getAvailableZoneIds());
                Set<String> outPut1 = ZoneId.getAvailableZoneIds();
                String outString = outPut1.toString();
                outString = outString.replaceAll(",", "\n");
                System.out.println(outString);

                keepGoing = shouldContinue();
                System.out.println();

            } else {
                System.out.println("Exiting...");
                scan.close();
                System.exit(0);
            }

        }

    }

    public static boolean shouldContinue() {
        Scanner scanYN = new Scanner(System.in);
        String YN = scanYN.nextLine();
        if (YN.equalsIgnoreCase("y") || YN.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }

    }
}
