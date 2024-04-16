import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class BankSignUp {
    static List<String[]> userDetail = new ArrayList<>();
    static String[][] users_detail = new String[0][5];
    static  String[] detailOfUserX = new String[5];
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void getUserName() {
        System.out.println("==Bank==");
        System.out.println("What should we call you?");
        System.out.println("Please enter your name in the following format:");
        System.out.println("1- Enter your first name and last name with a space between them.");
        System.out.println("2- The first character of each part should be written with capital letters.");
        System.out.println("<<Frist Last>>");
        System.out.println("Example: Alireza Sobhdoost");
    }

    public static void getUserNameWithError() {
        System.out.println("==Bank==");
        System.out.println("Error! Please enter your name in the correct format:");
        System.out.println("1- Enter your first name and last name with a space between them.");
        System.out.println("2- The first character of each part should be written with capital letters.");
        System.out.println("Example: John Doe");
    }

    public static void getPassword() {
        System.out.println("==Bank==");
        System.out.println("What would be your password in our bank?");
        System.out.println("Please enter your password in the following format:");
        System.out.println("1- Your password should be made of numbers and English letters.");
        System.out.println("2- Your password's length should be 4 characters.");
        System.out.println("Example: 1As9");
    }

    public static void getPasswordWithError() {
        System.out.println("==Bank==");
        System.out.println("Error! Please enter your password in the correct format:");
        System.out.println("1- Your password should be made of numbers and English letters.");
        System.out.println("2- Your password's length should be 4 characters.");
        System.out.println("Example: 1As9");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            userRegister();
        }

        for (String[] user : userDetail) {
            for (String detail : user) {
                System.out.println(detail);
            }
        }
    }

    // Other methods remain the same

    public static void userRegister() {
        
        getUserName();
        boolean flagErrorInRegister;
       
        

        while (true) {
            flagErrorInRegister = false;
            String name = scanner.nextLine();
            System.out.print("\033[H\033[2J");
            try {
                String[] splitedUsername = name.split(" ");
                Pattern pattern = Pattern.compile("^[A-Z][a-z]*");
                Matcher checkForFirstName = pattern.matcher(splitedUsername[0]);
                Matcher checkForLastName = pattern.matcher(splitedUsername[1]);

                if (checkForFirstName.matches() && checkForLastName.matches()) {
                    
                    for (String[] userDetails : users_detail) {
                        if (splitedUsername[0].equals(userDetails[0]) && splitedUsername[1].equals(userDetails[1])) {
                            flagErrorInRegister = true;
                            System.out.println("Username already exists!");
                            getUserNameWithError();
                            break;
                        }
                    }
                    if (!flagErrorInRegister) {
                        detailOfUserX[0] = splitedUsername[0];
                        detailOfUserX[1] = splitedUsername[1];
                    }
                } else {
                    getUserNameWithError();
                    continue;
                }
            } catch (Exception e) {
                getUserNameWithError();
                continue;
            }

            if (flagErrorInRegister) {
                continue;
            } else {
                
                break;
            }
        }

        System.out.print("\033[H\033[2J");
        getPassword();
        while (true) {
            
            String password = scanner.nextLine();
            System.out.print("\033[H\033[2J");
            Pattern pattern = Pattern.compile("\\w*");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches() && !password.contains("_") && password.length() == 4) {
                detailOfUserX[2] = password;
                break;
            } else {
                getPasswordWithError();
            }
        }

        int accountNumber = rand.nextInt(9000) + 1000;
        while (true) {
            boolean accountExists = false;
            for (String[] userDetails : users_detail) {
                if (userDetails[2].equals(String.valueOf(accountNumber))) {
                    accountExists = true;
                    accountNumber = rand.nextInt(9000) + 1000;
                    break;
                }
            }
            if (!accountExists) {
                break;
            }
        }

        String accountNumberStr = String.valueOf(accountNumber);
        detailOfUserX[3] = accountNumberStr;
        detailOfUserX[4] = "10000" ;

        // // Convert users_detail to a List to add new user details
        // List<String[]> userList = new ArrayList<>();
        // for (String[] user : users_detail) {
        //     userList.add(user);
        // }
        // userList.add(detailOfUserX);
        // userDetail= userList ;

        // // Convert back to String[][] and assign to users_detail
        // users_detail = userList.toArray(new String[userList.size()][]);

        //users_detail.add(detailOfUserX) ;

        String csvFileName = "account_data.csv";
        String data = detailOfUserX[0]+"," + detailOfUserX[1]+"," +detailOfUserX[2]+"," +detailOfUserX[3]+"," +detailOfUserX[4]+"," ;
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName, true))) {
            writer.write(data);
            writer.newLine();
            //System.out.println("Data added successfully to the CSV file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
        
        //String csvFileName = "yourfile.csv";
        // String lastLine = "";

        // try (BufferedReader reader = new BufferedReader(new FileReader(csvFileName))) {
        //     String line;
        //     boolean firstLineSkipped = false ;
        //     while ((line = reader.readLine()) != null) {
        //         if (!firstLineSkipped) {
        //             firstLineSkipped = true;
        //             continue; // Skip the first line
        //         }
        //         lastLine = line;
        //         detailOfUserX = line.split(","); // Split the CSV line by comma
        //         //users_detail = BankCsvReader.appendData( users_detail, detailOfUserX);
        //     }
        //     //System.out.println("Last line of the CSV file: " + lastLine);
        // } catch (IOException e) {
        //     System.err.println("Error reading the file: " + e.getMessage());
        // }
        BankCsvReader.read_data () ;
        BankHistory.save_history(detailOfUserX[3] + ".txt", detailOfUserX[0] + " " +detailOfUserX[1] + " has signed up") ;

        System.out.println("Registered Successfully!");
        System.out.println("Your account number is : " + detailOfUserX[3]);
        //System.out.println(users_detail[0][4]);
    }
}
