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

    private static final Scanner input = new Scanner(System.in);
    private static final ZoneId timezone = ZoneId.of("Asia/Kuala_Lumpur");
    private static final ZonedDateTime now = ZonedDateTime.now(timezone);
    private static final LocalDate today = now.toLocalDate();

    private String date = "";
    private final API api = new API();
    private int countJournal = 1;
    private boolean isTodayNoJournal = false;

    public int datePage(String email) {
        try (
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("UserData/" + email + "_journal.txt",true));
            Scanner inputStream = new Scanner(new FileInputStream("UserData/" + email + "_journal.txt"));
            ) {
            outputStream.close();
            System.out.println("\n=== Journal Dates ===");
            System.out.println("0. Return to Main Menu");
            String dateFind = "";
            // Find all the date line in file
            for (int lineNumber = 0; inputStream.hasNextLine(); ) {
                lineNumber++;
                countJournal = lineNumber / 4 + 1;
                String currentLine = inputStream.nextLine();
                if (lineNumber % 4 == 1) {
                    System.out.print(countJournal + ". "+ currentLine);
                    dateFind = currentLine;
                    if (dateFind.equals(today.toString())) {
                        System.out.println(" (Today)");
                    } else System.out.println();
                }
            }
            if (!dateFind.equals(today.toString())) {
                System.out.println(countJournal + ". (No journal for today, create one!)");
                isTodayNoJournal = true;
            } else countJournal--;
        } 
        catch (IOException e) {
            System.out.println("Problem with file!!"); 
        }
        return countJournal;
    }

    public void journalPage(int journalDateNum, String email) {
        int dateLine = journalDateNum * 4 - 3;
        try (
            Scanner inputStream = new Scanner(new FileInputStream("UserData/" + email + "_journal.txt"));
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("UserData/" + email + "_journal.txt",true));
            ) {
            for (int lineNumber = 0; inputStream.hasNextLine(); ) {
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
                while (checkNoInput(entryText)) {
                    System.out.println("\nEnter your journal entry for " + today + ": ");
                    System.out.print("> ");
                    entryText = input.nextLine();
                }

                outputStream.println(today);
                outputStream.println("Weather: ");
                outputStream.println("Mood: ");
                outputStream.println(entryText);
                System.out.println("Journal saved successfully!");
                isTodayNoJournal = false;
                inputStream.close();
                outputStream.close();
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
                    case "3":
                        break;
                    default:
                        System.out.println("\nInvaild input.");
                        journalPage(journalDateNum, email);
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

    public void editJournal(String email) {
        // Read & write n-1 line to temp file, then add 1 new line in temp, then rewrite temp file into original file 
        File originalFile = new File("UserData/" + email + "_journal.txt");
        File tempFile = new File("UserData/temp.txt");
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
            String editInput = input.nextLine();
            while (checkNoInput(editInput)) {
                System.out.println("\nEdit your journal entry for " + date + ":");
                System.out.print("> ");
                editInput = input.nextLine();
            }
            outputStream.print(editInput);
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

    private boolean checkNoInput(String inputLine) {
        if (inputLine.equals("")) {
            System.out.println("Invaild input. Please try again.");
            return true;
        }
        else return false;
    }
}
