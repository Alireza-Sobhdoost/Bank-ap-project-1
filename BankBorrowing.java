import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

public class BankBorrowing {
    static Random rand = new Random();
    static ArrayList<String> borrowing_identifier = new ArrayList<>();
    static String[][] broowing_detail = new String[0][5];
    static  String[] dataOfBorrowX = new String[2];

    public static void Menu() {
        System.out.println("==Bank==");
        System.out.println("See our Bank borrowing options?");
        System.out.println("Press any key to continue");
        System.out.println("[b] back");
    }

    public static void brow_options() {
        System.out.println("==Bank==");
        System.out.println("[1] Maskan javan mehr");
        System.out.println("[b] back");
    }

    public static void opt_1_detail() {
        System.out.println("==Bank==");
        System.out.println("--------------------------------");
        System.out.println("Maskan javan mehr");
        System.out.println("We offer this option in order to increase the marriage index of society!");
        System.out.println("For Javan to use that in get 1 from 6 of a house in maskan mehr area!");
        System.out.println("value = 850,000,000 rial (85 million toman)");
        System.out.println("mark up = %25 (212,500,000 rial)");
        System.out.println("time = 25 months");
        System.out.println("payment = 42,500,000 rial (4,250 million toman)");
        System.out.println("--------------------------------");
        System.out.println("[g] agree and want to use borrowing option");
        System.out.println("[b] back");
    }

    public static void borrow() {
        Scanner scanner = new Scanner(System.in);

        Menu();
        char choice_fst = scanner.nextLine().charAt(0);
        boolean get_borrowing = false;
        boolean back_opt = false;
        boolean used_opt_1 = false;
        if (choice_fst == 'b')
            get_borrowing = false;
        else {

                while (!get_borrowing &&!back_opt) {
                    brow_options();
                    char choice = scanner.nextLine().charAt(0);
                    if (choice == '1') {
                        opt_1_detail();
                        if (used_opt_1) {
                            System.out.println("You already borrowed and used this option!");
                            System.out.println("--------------------------------");
                            System.out.println("[b] back");
                            char choice_increase = scanner.nextLine().charAt(0);
                            while (true) {
                                if (choice_increase == 'b')
                                    break;
                            }
                        } else {
                            while (true) {
                                char choice_to_use_opt = scanner.nextLine().charAt(0);
                                if (choice_to_use_opt == 'g') {
                                    int borrowNumber = rand.nextInt(90000) + 10000;
                                    while (true) {
                                        boolean number_exist = false;
                                        for (String number : borrowing_identifier) {
                                            if (number.equals( "1"+BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1]]+String.valueOf(borrowNumber))) {
                                                number_exist = true;
                                                borrowNumber = rand.nextInt(90000) + 10000;
                                                break;
                                            }
                                        }
                                        if (!number_exist) {
                                            break;
                                        }
                                    }
                                    borrowing_identifier.add( "1" + BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1]]+String.valueOf(borrowNumber));
                                    dataOfBorrowX [0] = "1"+BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1]] +borrowNumber ;
                                    dataOfBorrowX[1]= "25" ;
                                    broowing_detail = BankCsvReader.appendData(broowing_detail , dataOfBorrowX) ;
                                    BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1]) + 85000000);
                                    try {
                                        BankCsv.file_update_broowing() ;
                                        BankCsv.file_update();     
                                        BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt" , BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has borrowed 85 milion Toman from the bank with identify vode : "+"1" +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1]]+borrowNumber) ;
                                        }
                                    catch (IOException e) {
                                        e.printStackTrace();
                                        }
                                
                                System.out.println("The identify code with you will need in your repayment is : 1"+BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1]] +borrowNumber);
                                System.out.println("borrowing option had been done successfully !");
                                
                                get_borrowing = true ;
                                break ;
                                    
                                } else if (choice_to_use_opt == 'b') {
                                    break;
                                }
                            }
                        }
                    } else if (choice == 'b') {
                        back_opt = true;
                        break;
                    }
                }
            
        }
    }
}
