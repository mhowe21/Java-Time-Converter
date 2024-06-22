
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

public class App {

    /**
     * The main function of the program. It prompts the user to select an option and
     * performs the corresponding action.
     *
     * @param args the command-line arguments
     * @throws Exception if an error occurs during the execution of the program
     */
    public static void main(String[] args) throws Exception {
        // sets an intial option value of 0 when the program starts
        int optionSelect = 0;
        // this creates a scanner class to get user input
        Scanner scan = new Scanner(System.in);

        // this will keep the program running until the user chooses to exit
        boolean keepGoing = true;

        // this is the loop that keeps the program running util the above value is false
        while (keepGoing == true) {
            System.out.println(
                    "Please slect your option\n1. Get current local time\n2. Get GMT time\n3. get current offset from GMT\n4.Get offset from 2 diffrent timecodes\n5. Get time Codes\n6. Exit");
            optionSelect = scan.nextInt();
            // if the user selects 1, it will print the current time in the local time zone
            // zone
            if (optionSelect == 1) {

                ZonedDateTime time = ZonedDateTime.now();
                System.out.println("Current time is: " + time);
                keepGoing = shouldContinue();
                System.out.println();
                // if the user selects 2, it will print the current time in the Zulu time zone
                // (Universal time)
            } else if (optionSelect == 2) {
                ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Z"));
                System.out.println("Current GMT time is: " + time);
                keepGoing = shouldContinue();
                // this gets the users current offset from Zulu time
            } else if (optionSelect == 3) {
                ZonedDateTime time = ZonedDateTime.now();
                System.out.println("Current offset from GMT is: " + time.getOffset() + " from GMT");
                keepGoing = shouldContinue();
                System.out.println();
                // this gets the offset in hours from 2 diffrent timezones
            } else if (optionSelect == 4) {
                System.out.print("Enter first time zone: ");
                scan.nextLine();
                String Zone1 = scan.nextLine();
                System.out.print("Enter second time zone: ");
                String Zone2 = scan.nextLine();
                // if the timezone the user enters does not exist it will print an error and ask
                // them to use option 5 to get all timezones
                try {
                    ZonedDateTime timeZone1 = ZonedDateTime.now(ZoneId.of(Zone1));
                    ZonedDateTime timeZone2 = ZonedDateTime.now(ZoneId.of(Zone2));
                    ZoneOffset offset1 = timeZone1.getOffset();
                    ZoneOffset offset2 = timeZone2.getOffset();
                    int differenceInHours = offset2.getTotalSeconds() / 3600 - offset1.getTotalSeconds() / 3600;
                    System.out.println(Zone2 + " is " + differenceInHours + " hours offset from " + Zone1);
                } catch (Exception e) {

                    System.out.println("Unknown time zone plese use option 5 to get all time zones");

                }

                keepGoing = shouldContinue();
                System.out.println();
                // this prints out all valid timezones that can be used for step 4
            } else if (optionSelect == 5) {
                System.out.println(ZoneId.getAvailableZoneIds());
                Set<String> outPut1 = ZoneId.getAvailableZoneIds();
                String outString = outPut1.toString();
                outString = outString.replaceAll(",", "\n");
                System.out.println(outString);

                keepGoing = shouldContinue();
                System.out.println();

                // this exits the program if hey choose a non valid option
            } else {
                System.out.println("Exiting...");
                scan.close();
                System.exit(0);
            }

        }

    }

    /**
     * Prompts the user to continue or not.
     *
     * @return true if the user wants to continue, false otherwise
     */
    public static boolean shouldContinue() {
        Scanner scanYN = new Scanner(System.in);
        System.out.println("Do you want to continue? (y/n)");
        String YN = scanYN.nextLine();
        if (YN.equalsIgnoreCase("y") || YN.equalsIgnoreCase("yes")) {
            scanYN.close();
            return true;

        } else {
            scanYN.close();
            return false;

        }

    }
}
