import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class Journal {

    public static Scanner input = new Scanner(System.in);
    public static final ZoneId timezone = ZoneId.of("Asia/Kuala_Lumpur");
    public static final ZonedDateTime now = ZonedDateTime.now(timezone);
    public static final LocalDate today = now.toLocalDate();

    private final API api = new API();

    private String date = "";
    private int lineNumber;
    private int countJournal = 1;
    private boolean isTodayNoJournal = false;

    int datePage(String email) {
        try (Scanner inputStream = new Scanner(new FileInputStream(email + "_journal.txt"))) {
            System.out.println("\n=== Journal Dates ===");
            System.out.println("0. Return to Main Menu");
            lineNumber = 0;
            while (inputStream.hasNextLine()) {
                lineNumber++;
                countJournal = lineNumber / 4 + 1;
                String currentLine = inputStream.nextLine();
                if (lineNumber % 4 == 1) {
                    System.out.print(countJournal + ". "+ currentLine);
                    date = currentLine;
                    if (date.equals(today.toString())) {
                        System.out.println(" (Today)");
                    } else System.out.println();
                }
            }
            if (!date.equals(today.toString())) {
                System.out.println(countJournal + ". (No journal for today, create one!)");
                isTodayNoJournal = true;
            } else countJournal--;
        } 
        catch (IOException e) {
            System.out.println("Problem with file!!"); 
        }
        return countJournal;
    }

    void journalPage(int journalDateNum, String email) {
        int dateLine = journalDateNum * 4 - 3;
        try (
            Scanner inputStream = new Scanner(new FileInputStream(email + "_journal.txt"));
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(email + "_journal.txt",true));
            ) {
            int lineNumber = 0;
            String date = null;
            while (inputStream.hasNextLine()) {
                lineNumber++;
                String currentLine = inputStream.nextLine();
                if (lineNumber == dateLine) {
                    date = currentLine;
                    break;
                }
            }
            if (isTodayNoJournal && journalDateNum == countJournal) {
                System.out.println("\nEnter your journal entry for " + today + ": ");
                System.out.print("> ");
                String entryText = input.nextLine();

                outputStream.println(today);
                outputStream.println("Weather: ");
                outputStream.println("Mood: ");
                outputStream.println(entryText);
                System.out.println("Journal saved successfully!");
                isTodayNoJournal = false;
                journalPage(journalDateNum, email);
            } else if (journalDateNum == countJournal) {
                System.out.println("\n=== Journal Entry for " + date + " ===");
                System.out.println("Would you like to:");
                System.out.println("1. View Journal");
                System.out.println("2. Edit Journal");
                System.out.println("3. Back to Dates");
                System.out.print("\n> ");
                String journalEditChoice = input.nextLine();
                switch (journalEditChoice) {
                    case "1":
                        System.out.println("\n=== Journal Entry for " + date + " ===");
                        String tempLine = null;
                        for (int i = 0; i < 3; i++) {
                            tempLine = inputStream.nextLine();
                        }
                        System.out.println(tempLine);
                        System.out.print("\nPress Enter to go back.\n> ");
                        input.nextLine();
                        break;
                    case "2":
                        System.out.println("\nEdit your journal entry for " + date + ":");
                        System.out.print("> ");
                        editJournal(email);
                        break;
                }
            } else {
                System.out.println("\n=== Journal Entry for " + date + " ===");
                String tempLine = null;
                for (int i = 0; i < 3; i++) {
                    tempLine = inputStream.nextLine();
                }
                System.out.println(tempLine);
                System.out.print("\nPress Enter to go back.\n> ");
                input.nextLine();
            }
        } 
        catch (Exception e) {
            System.out.println("Problem with file!!"); 
        } 
    }

    void editJournal(String email) {
        // Read & write n-1 line to temp file, then add 1 new line in temp, then rewrite temp file into original file 
        File originalFile = new File(email + "_journal.txt");
        File tempFile = new File("temp.txt");
        try (
            Scanner inputStream = new Scanner(new FileInputStream(originalFile));
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(tempFile));
            ) {
            String lineBuffer = inputStream.nextLine();
            while (inputStream.hasNextLine()) { 
                String line = inputStream.nextLine();
                outputStream.println(lineBuffer);
                lineBuffer = line;
            }
            outputStream.print(input.nextLine());
        } catch (Exception e) {
            System.out.println("Problem with file!!");
        }
        try (
            Scanner inputStream = new Scanner(new FileInputStream(tempFile));
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(originalFile));
            ) {
            while (inputStream.hasNextLine()) { 
                outputStream.println(inputStream.nextLine());
            }
            System.out.println("Journal saved successfully!");
            } catch (Exception e) {
            System.out.println("Problem with file!!");
        }
    }
}
