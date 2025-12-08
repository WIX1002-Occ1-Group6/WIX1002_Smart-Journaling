package Journal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class User {

    private String email, displayName;
    private static final Scanner input = new Scanner(System.in);
    private static final String DATAFILE = "UserData/UserData.txt";

    public boolean register() {
        
        try (PrintWriter outputStream = new PrintWriter(new FileOutputStream(DATAFILE,true));) {
            System.out.print("Enter email: ");
            this.email = input.nextLine();

            if (!this.email.contains("@")) {
                clearScreen();
                System.out.println("Invaild email.");
                return false;
            }

            Map<String, List<String>> loginMap = new HashMap<>();
            readData(loginMap);
            List<String> emailList = new ArrayList<>(loginMap.keySet());
            if (emailList.contains(this.email)) {
                clearScreen();
                System.out.println("You have already registered. Please use log in.");
                return false;
            }

            System.out.print("Enter display name: ");
            this.displayName = input.nextLine();
            while (checkNoInput(this.displayName)) {
                System.out.print("Enter display name: ");
                this.displayName = input.nextLine();
            }
            System.out.print("Enter password: ");
            String password = input.nextLine();
            while (checkNoInput(password)) {
                System.out.print("Enter password: ");
                password = input.nextLine();
            }
            String encryptedPasswd = getSHA256(password);
            outputStream.println("\n===\n===\n");
            outputStream.println(this.email);
            outputStream.println(this.displayName);
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
        System.out.print("Enter email: ");
        this.email = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        String encryptedPasswd = getSHA256(password);

        Map<String, List<String>> loginMap = new HashMap<>();
        readData(loginMap);
        List<String> emailList = new ArrayList<>(loginMap.keySet());
        if (emailList.contains(this.email)) {
            List<String> privacyList = loginMap.get(this.email);
            this.displayName = privacyList.get(0);
            if (privacyList.get(1).equals(encryptedPasswd)) {
                clearScreen();
                System.out.println("Login successful!");
                return true;
            }
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

    private void readData(Map<String, List<String>> map) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(DATAFILE)));
            content = content.replace("\r\n", "\n"); // Unify Windows(\r\n) Linux(\n) difference
            String[] blocks = content.split("\n===\n===\n");
            for (String block : blocks) {
                block = block.trim(); // Discard space
                if (block.isEmpty()) continue;
                String[] lines = block.split("\n");
                if (lines.length >= 3) {
                    String emailKey = lines[0].trim();
                    List<String> privacyKey = new ArrayList<>();
                    privacyKey.add(lines[1].trim());
                    privacyKey.add(lines[2].trim());
                    map.put(emailKey, privacyKey);   
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
