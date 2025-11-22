import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class User {

    private String email, password, displayName;
    private static final Scanner input = new Scanner(System.in);
    private static final String DATAFILE = "UserData/UserData.txt";

    public boolean register() {
        
        try (
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(DATAFILE,true));
            Scanner inputStream = new Scanner(new FileInputStream(DATAFILE));
            ) {
            System.out.print("Enter email: ");
            email = input.nextLine();

            if (!email.contains("@")) {
                System.out.println("Invaild input.");
                return false;
            }
            // Check if already registered
            while (inputStream.hasNextLine()) {
                String currentLine = inputStream.nextLine();
                if (currentLine.equals(email)) {
                    System.out.println("You have already registered. Please use log in.");
                    return false;
                }
            }

            outputStream.println(email);
            System.out.print("Enter display name: ");
            displayName = input.nextLine();
            while (checkNoInput(displayName)) {
                System.out.print("Enter display name: ");
                displayName = input.nextLine();
            }
            outputStream.println(displayName);
            System.out.print("Enter password: ");
            password = input.nextLine();
            while (checkNoInput(password)) {
                System.out.print("Enter password: ");
                password = input.nextLine();
            }
            outputStream.println(password);
        } 
        catch (IOException e) {
            System.out.println("Problem with file!!"); 
            return false;
        }
        System.out.println("You have successfully registered!");
        return true;
    }

    public boolean login() {
        try (Scanner inputStream = new Scanner(new FileInputStream(DATAFILE))) {
            System.out.print("Enter email: ");
            email = input.nextLine();
            System.out.print("Enter password: ");
            password = input.nextLine();
            int lineNumber = 0;
            // Check availablity
            while (inputStream.hasNextLine()) {
                lineNumber++;
                String currentLine = inputStream.nextLine();
                if (lineNumber % 3 == 1) {
                    if (currentLine.equals(email)) {
                        // Get displayName and check password
                        displayName = inputStream.nextLine();
                        if (password.equals(inputStream.nextLine())) {
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
        System.out.println("Email or password incorrect!");
        return false;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public String getEmail() {
        return email;
    }

    private boolean checkNoInput(String inputLine) {
        if (inputLine.equals("")) {
            System.out.println("Invaild input. Please try again.");
            return true;
        }
        else return false;
    }
}
