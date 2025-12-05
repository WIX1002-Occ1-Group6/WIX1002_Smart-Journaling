package Journal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Scanner;


public class Journal {

    private static final Scanner input = new Scanner(System.in);
    private static final ZoneId timezone = ZoneId.of("Asia/Kuala_Lumpur");
    private static final ZonedDateTime now = ZonedDateTime.now(timezone);
    private static final LocalDate today = now.toLocalDate();

    private String date = "";
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
                this.countJournal = lineNumber / 4 + 1;
                String currentLine = inputStream.nextLine();
                if (lineNumber % 4 == 1) {
                    System.out.print(this.countJournal + ". "+ currentLine);
                    dateFind = currentLine;
                    if (dateFind.equals(today.toString())) {
                        System.out.println(" (Today)");
                    } else System.out.println();
                }
            }
            if (!dateFind.equals(today.toString())) {
                System.out.println(this.countJournal + ". (No journal for today, create one!)");
                this.isTodayNoJournal = true;
            } else this.countJournal--;
        } 
        catch (IOException e) {
            System.out.println("Problem with file!!"); 
        }
        return this.countJournal;
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
                    this.date = currentLine;
                    break;
                }
            }
            if (this.isTodayNoJournal && journalDateNum == this.countJournal) {
                System.out.println("\nEnter your journal entry for " + today + ": ");
                System.out.print("> ");
                String entryText = input.nextLine();
                while (checkNoInput(entryText)) {
                    System.out.println("\nEnter your journal entry for " + today + ": ");
                    System.out.print("> ");
                    entryText = input.nextLine();
                }
                System.out.println("Processing...");
                String json = getMood(entryText);
                String mood = parser(json, "\"label\":");
                String weather = weatherInEng(parser(json, "\"summary_forecast\":"));

                outputStream.println(today);
                outputStream.println(weather);
                outputStream.println(mood);
                outputStream.println(entryText);
                clearScreen();
                System.out.println("Journal saved successfully!");
                this.isTodayNoJournal = false;
                inputStream.close();
                outputStream.close();
                journalPage(journalDateNum, email);
            } else if (journalDateNum == this.countJournal) {
                System.out.println("\n=== Journal Entry for " + this.date + " ===");
                System.out.println("Would you like to:");
                System.out.println("1. View Journal");
                System.out.println("2. Edit Journal");
                System.out.println("3. Back to Dates");
                System.out.print("\n> ");
                String journalEditChoice = input.nextLine();
                switch (journalEditChoice) {
                    case "1":
                        System.out.println("\n=== Journal Entry for " + this.date + " ===");
                        System.out.println("Weather: " + inputStream.nextLine());
                        System.out.println("Mood: " + inputStream.nextLine());
                        System.out.println(inputStream.nextLine());
                        System.out.print("\nPress Enter to go back.\n> ");
                        input.nextLine();
                        clearScreen();
                        break;
                    case "2":
                        System.out.println("\nEdit your journal entry for " + this.date + ":");
                        System.out.print("> ");
                        editJournal(email);
                        break;
                    case "3":
                        clearScreen();
                        break;
                    default:
                        clearScreen();
                        System.out.println("\nInvaild input.");
                        journalPage(journalDateNum, email);
                        break;
                }
            } else {
                System.out.println("\n=== Journal Entry for " + this.date + " ===");
                System.out.println("Weather: " + inputStream.nextLine());
                System.out.println("Mood: " + inputStream.nextLine());
                System.out.println(inputStream.nextLine());
                System.out.print("\nPress Enter to go back.\n> ");
                input.nextLine();
                clearScreen();
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
                System.out.println("\nEdit your journal entry for " + this.date + ":");
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
            clearScreen();
            System.out.println("Journal saved successfully!");
            } catch (Exception e) {
            System.out.println("Problem with file!!");
        }
    }

    public void weeklySummary(String email) {
        System.out.println("=== Weekly Mood Summary ===");
        String format = "%-12s %-55s %-10s%n";
        System.out.printf(format, "Date", "Weather", "Mood");
        
        int count = 0;
        for (int i = 6; i >= 0; i--) {
            LocalDate dateToCheck = today.minusDays(i);
            String dateString = dateToCheck.toString();
            try (
                PrintWriter outputStream = new PrintWriter(new FileOutputStream("UserData/" + email + "_journal.txt",true));
                Scanner inputStream = new Scanner(new FileInputStream("UserData/" + email + "_journal.txt"));
                ) {
                outputStream.close();
                while (inputStream.hasNextLine()) {
                    String currentLine = inputStream.nextLine();
                    if(dateString.equals(currentLine)) {
                        System.out.printf(format, currentLine, inputStream.nextLine(), inputStream.nextLine());
                        count++;
                        break;
                    }
                }
            } catch (IOException e) {
            System.out.println("Problem with file!!"); 
            }
        }
        System.out.println("\nIn last 7 days, you wrote " + count + " journal entry.");
        System.out.print("\nPress Enter to go back.\n> ");
        input.nextLine();
        clearScreen();
    } 
        
    

    private boolean checkNoInput(String inputLine) {
        if (inputLine.equals("")) {
            System.out.println("Invaild input. Please try again.");
            return true;
        }
        else return false;
    }

    private static String getMood(String entryText) {
        // copy from API.java
        API api = new API();
        Map<String, String> env = EnvLoader.loadEnv(".env");
        String response = null;
        try {
            // --- Example GET request: Fetch latest weather forecast for Kuala Lumpur ---
            String getUrl = "https://api.data.gov.my/weather/forecast/?contains=WP%20Kuala%20Lumpur@location__location_name&sort=date&limit=1";
            String getResponse = api.get(getUrl);
            // System.out.println("GET Response:\n" + getResponse);

            // --- Example POST request: Perform sentiment analysis using HuggingFace model ---
            String journalInput = entryText;
            String postUrl = "https://router.huggingface.co/hf-inference/models/distilbert/distilbert-base-uncased-finetuned-sst-2-english";

            // Safely get bearer token
            String bearerToken = env.get("BEARER_TOKEN");
            if (bearerToken == null || bearerToken.isEmpty()) {
                System.err.println("Error: BEARER_TOKEN is not set in the environment.");
                return "Error";
            }

            // Format JSON body
            String jsonBody = "{\"inputs\": \"" + journalInput + "\"}";

            // Call POST
            String postResponse = api.post(postUrl, bearerToken, jsonBody);
            // System.out.println("\nSentiment Analysis Response:\n" + postResponse);
            response = getResponse + postResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private static String parser(String jsonString, String keyToFind) {
        //String keyToFind = "\"summary_forecast\":";
        String summaryForecast = null;
        int startIndex = jsonString.indexOf(keyToFind);

        if (startIndex != -1) {
            int valueStart = startIndex + keyToFind.length();
            // Find value start with "
            valueStart = jsonString.indexOf('\"', valueStart);
            if (valueStart != -1) {
                // End with same "
                int valueEnd = jsonString.indexOf('\"', valueStart + 1);
                if (valueEnd != -1) {
                    summaryForecast = jsonString.substring(valueStart + 1, valueEnd);
                }
            }
        }
        return summaryForecast;
    }

    private static String weatherInEng(String malay) {
        String eng = null;
        switch (malay) {
            case "Berjerebu" -> eng = "Hazy";
            case "Tiada hujan" -> eng = "No rain";
            case "Hujan" -> eng = "Rain";
            case "Hujan di beberapa tempat" -> eng = "Scattered rain";
            case "Hujan di satu dua tempat" -> eng = "Isolated Rain";
            case "Hujan di satu dua tempat di kawasan pantai" -> eng = "Isolated rain over coastal areas";
            case "Hujan di satu dua tempat di kawasan pedalaman" -> eng = "Isolated rain over inland areas";
            case "Ribut petir" -> eng = "Thunderstorms";
            case "Ribut petir di beberapa tempat" -> eng = "Scattered thunderstorms";
            case "Ribut petir di beberapa tempat di kawasan pedalaman" -> eng = "Scattered thunderstorms over inland areas";
            case "Ribut petir di satu dua tempat" -> eng = "Isolated thunderstorms";
            case "Ribut petir di satu dua tempat di kawasan pantai" -> eng = "Isolated thunderstorms over coastal areas";
            case "Ribut petir di satu dua tempat di kawasan pedalaman" -> eng = "Isolated thunderstorms over inland areas";
            default -> eng = malay;
        }
        return eng;
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
