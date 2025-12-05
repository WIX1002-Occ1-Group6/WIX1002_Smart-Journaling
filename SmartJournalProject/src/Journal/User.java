package Journal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class User {

    private String email, displayName;
    private static final Scanner input = new Scanner(System.in);
    private static final String DATAFILE = "UserData/UserData.txt";

    public boolean register() {
        
        try (
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(DATAFILE,true));
            Scanner inputStream = new Scanner(new FileInputStream(DATAFILE));
            ) {
            System.out.print("Enter email: ");
            this.email = input.nextLine();

            if (!this.email.contains("@")) {
                clearScreen();
                System.out.println("Invaild email.");
                return false;
            }
            // Check if already registered
            while (inputStream.hasNextLine()) {
                String currentLine = inputStream.nextLine();
                if (currentLine.equals(this.email)) {
                    clearScreen();
                    System.out.println("You have already registered. Please use log in.");
                    return false;
                }
            }

            outputStream.println(this.email);
            System.out.print("Enter display name: ");
            this.displayName = input.nextLine();
            while (checkNoInput(this.displayName)) {
                System.out.print("Enter display name: ");
                this.displayName = input.nextLine();
            }
            outputStream.println(this.displayName);
            System.out.print("Enter password: ");
            String password = input.nextLine();
            while (checkNoInput(password)) {
                System.out.print("Enter password: ");
                password = input.nextLine();
            }
            String encryptedPasswd = getSHA256(password);
            outputStream.println(encryptedPasswd);
        } 
        catch (IOException e) {
            System.out.println("Problem with file!!"); 
            return false;
        }
        clearScreen();
        System.out.println("You have successfully registered!");
        return true;
    }

    public boolean login() {
        try (
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(DATAFILE,true));
            Scanner inputStream = new Scanner(new FileInputStream(DATAFILE));
        ) {
            System.out.print("Enter email: ");
            this.email = input.nextLine();
            System.out.print("Enter password: ");
            String password = input.nextLine();
            String encryptedPasswd = getSHA256(password);
            int lineNumber = 0;
            // Check availablity
            while (inputStream.hasNextLine()) {
                lineNumber++;
                String currentLine = inputStream.nextLine();
                if (lineNumber % 3 == 1) {
                    if (currentLine.equals(this.email)) {
                        // Get displayName and check password
                        this.displayName = inputStream.nextLine();
                        if (encryptedPasswd.equals(inputStream.nextLine())) {
                            clearScreen();
                            System.out.println("Login successful!");
                            return true;
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found");
            return false;
        }
        clearScreen();
        System.out.println("Email or password incorrect!");
        return false;
    }

    public String getDisplayName() {
        return this.displayName;
    }
    
    public String getEmail() {
        return this.email;
    }

    private boolean checkNoInput(String inputLine) {
        if (inputLine.equals("")) {
            System.out.println("Invaild input. Please try again.");
            return true;
        }
        else return false;
    }

    public static String getSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
            byte[] hash = md.digest(input.concat("MaybeAddSomeSalt").getBytes(StandardCharsets.UTF_8));
            String hexString = "";
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                // Pad with a leading zero
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                hexString += hex;
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return input;
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
