import java.util.Scanner;
import java.io.IOException;
import java.util.Random;

public class BankCharge {
    public static void Menu () {
        System.out.println("==Bank==");
        System.out.println("Please choose your operator ");
        System.out.println("[h] Hamrah aval");
        System.out.println("[i] Irancel");
        System.out.println("[r] Raitel");
        System.out.println("[b] Back ");


    }
    public static String pass_generator() {
        // Define the length of the random number
        int length = 20;
        String generated_str = "";

        // Create an instance of Random class
        Random random = new Random();

        // Generate a random 20-character number
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generate a random digit (0-9)
            generated_str += String.valueOf(digit);
        }

        return generated_str;
    }
    public static void charge () {
        
        Scanner scanner = new Scanner(System.in);
        char choice ;
        
        boolean back_opt = false ;
        while (!back_opt) {
            String operator = "";
            Menu();
            choice = scanner.nextLine().charAt(0);
            System.out.print("\033[H\033[2J");
            if (choice == 'h' || choice == 'i' || choice == 'r') {
                if (choice == 'h') {
                    System.out.println("==Hamrah aval==");
                    operator = "Hamrah aval" ;
                }
                else if (choice == 'i'){
                    System.out.println("==Irancel==");
                    operator = "Irancel" ;
                }
                else if (choice == 'r'){
                    System.out.println("==Raitel==");
                    operator = "Raitel" ;
                }
                else if (choice == 'b'){
                    back_opt = true ;
                }
                System.out.println("[1] 5000 toman |usal| ");
                System.out.println("[2] 10000 tooman |sepcial|");
                System.out.println("[3] 20000 tooman |Javanan!|");
                System.out.println("[b] Back ");
                char choice_service ;
                while (true){
                    choice_service = scanner.nextLine().charAt(0);
                    System.out.print("\033[H\033[2J");
                    if (choice_service == '1' || choice_service == '2' || choice_service == '3' || choice_service == 'b') {
                        if (choice_service == '1') {
                            if (5000 > Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1])) {
                            System.out.println("You dont have enough money to buy the charge ! ");
                            break ;
                            }
                            else {
                                BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1])  - 5000);
                                String password = pass_generator() ;
                                System.out.println("The activation code for your charge is : " + password);
                                try {
                                    BankCsv.file_update();  
                                    BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt" , BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has bought charge his/her phone |Operator : " + operator +"| 5000 Tooman whose activation code is : " + password) ;
                                }
                                catch (IOException e) {
                                    e.printStackTrace();
                                }
                                back_opt = true ;
                                break ;
                            }
                        }
                        else if (choice_service == '2'){
                            if (10000 > Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1])) {
                                System.out.println("You dont have enough money to buy the charge ! ");
                                break ;
                                }
                            else {
                                BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1])  - 10000);
                                String password = pass_generator() ;
                                System.out.println("The activation code for your charge is : " + password);
                                try {
                                    BankCsv.file_update();  
                                    BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt" , BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has bought charge his/her phone |Operator : " + operator +"| 10000 Tooman whose activation code is : " + password) ;
                                }
                                catch (IOException e) {
                                    e.printStackTrace();
                                }
                                back_opt = true ;
                                break ;
                            }
                        }
                        else if (choice_service == '3'){
                            if (20000 > Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1])) {
                                System.out.println("You dont have enough money to buy the charge ! ");
                                break ;
                                }
                            else {
                                BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1])  - 20000);
                                String password = pass_generator() ;
                                System.out.println("The activation code for your charge is : " + password);
                                    try {
                                        BankCsv.file_update();     
                                        BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt" , BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has bought charge his/her phone |Operator : " + operator +"| 20000 Tooman whose activation code is : " + password) ;
                                    }
                                    catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                back_opt = true ;
                                break ;
                                }
                            
                        }
                        else if (choice_service == 'b'){
                            break ;
                        }
                    }

                }
            }
        }
        

        
       
    }
}
