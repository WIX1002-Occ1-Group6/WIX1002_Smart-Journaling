import java.time.*;
import java.util.Scanner;

public class SmartJournal {

    public static final ZoneId timezone = ZoneId.of("Asia/Kuala_Lumpur");
    public static final ZonedDateTime now = ZonedDateTime.now(timezone);
    public static final Scanner input = new Scanner(System.in);
    public static final LocalDate today = now.toLocalDate();
    public static final User user = new User();
    public static final Journal journal = new Journal();

    public static void loginPage() {
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }
        System.out.println("\n=== Welcome to Smart Journal ===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("\n> ");

        switch (input.nextLine()) {
            case "1":
                if(user.login()) welcomePage();
                loginPage();
                break;
            case "2":
                if(user.register()) welcomePage();
                loginPage();
                break;
            case "3":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invaild input!");
                loginPage();
        }
    }

    public static void welcomePage() {
        // Different welcome displays based on time
        ZonedDateTime fivePM = ZonedDateTime.of(LocalDate.now(timezone), LocalTime.of(17, 0), timezone);
        ZonedDateTime twelveAM = ZonedDateTime.of(LocalDate.now(timezone), LocalTime.of(12, 0), timezone);
        for (int i = 0; i < 50; i++) {
            System.out.println("\n");
        }
        if (now.isAfter(fivePM)) {
            System.out.println("\nGood Evening! " + user.getDisplayName());
        } else if (now.isAfter(twelveAM)) {
            System.out.println("\nGood Afternoon! " + user.getDisplayName());
        } else {
            System.out.println("\nGood Morning! " + user.getDisplayName());
        }

        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Create Journals");
        System.out.println("2. View Weekly Mood Summary");
        System.out.println("3. Log Out");
        System.out.print("\n> ");

        switch (input.nextLine()) {
            case "1":
                journalDatePage();
                welcomePage();
                break;
            case "2":
                // todo qwq
                System.out.println("todo............................................................");
                welcomePage();
                break;
            case "3":
                System.out.println("See you!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                welcomePage();
                break;
        }
    }

    public static void journalDatePage() {
        int countJournal = journal.datePage(user.getEmail());
        int journalDateNum = -1;
        while (journalDateNum < 0 || journalDateNum > countJournal) {
            System.out.println("\nSelect a date to view journal, or create a new journal for today:");
            System.out.print("> ");
            journalDateNum = input.nextInt();
        }
        if (journalDateNum > 0) {
            journal.journalPage(journalDateNum,user.getEmail());
            journalDatePage();
        }

    }

    public static void main(String[] args) {
        loginPage();
    }
}
