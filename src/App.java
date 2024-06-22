import static java.lang.StringTemplate.STR;

import java.io.*;
import java.util.*;
import java.lang.System;
//import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(
                "Please slect your option\n1. Get current local time\n2. Get GMT time\n3. get current offset from GMT\n4.Get offset from 2 diffrent timecodes\n5. get Time Codes\n6. Exit");
        Scanner scan = new Scanner(System.in);
        int str = scan.nextInt();

        // TimeZone tz = TimeZone.getDefault();

        if (str == 1) {
            // LocalTime time = LocalTime.now();
            // System.out.println(STR."\{time} - \{tz.getDisplayName()}");
            ZonedDateTime time = ZonedDateTime.now();
            System.out.println(STR."\{time}");
        } else if (str == 2) {
            ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Z"));
            System.out.println(STR."\{time}");
        } else if (str == 3) {
            ZonedDateTime time = ZonedDateTime.now();
            System.out.println(STR."\{time.getOffset()} from GMT");
        } else if (str == 4) {
            System.out.print("Enter first time zone: ");
            scan.nextLine();
            String Zone1 = scan.nextLine();
            System.out.print("Enter second time zone: ");
            String Zone2 = scan.nextLine();
            ZonedDateTime timeZone1 = ZonedDateTime.now(ZoneId.of(Zone1));
            ZonedDateTime timeZone2 = ZonedDateTime.now(ZoneId.of(Zone2));
            ZoneOffset offset1 = timeZone1.getOffset();
            ZoneOffset offset2 = timeZone2.getOffset();

            int differenceInHours = offset2.getTotalSeconds() / 3600 - offset1.getTotalSeconds() / 3600;
            System.out.println(Zone2 + " is " + differenceInHours + " hours ahead of " + Zone1);
        } else if (str == 5) {
            // TimeZone tZone = TimeZone.getDefault();
            System.out.println(ZoneId.getAvailableZoneIds());
            Set<String> outPut1 = ZoneId.getAvailableZoneIds();
            String outString = outPut1.toString();
            outString = outString.replaceAll(",", "\n");
            System.out.println(outString);

        } else {
            System.out.println("Exiting...");
            System.exit(0);
        }

    }
}
