import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.io.File;
// import BankSignUp.* ;





public class BankMain {
    public static void greet() {
        System.out.println("==Bank==");
        System.out.println("Welcome to your bank! The program is at your service!");
    }

    public static void firstMenu() {
        System.out.println("==Bank==");
        System.out.println("How can we help you?");
        System.out.println("[m] make a new bank account");
        System.out.println("[l] log in to your bank account");
        System.out.println("[e] exit");
    }

    public static void exitMenu() {
        System.out.println("==Exit==");
        System.out.println("Do you want to leave this program that soon?");
        System.out.println("[y] Yes, I'll be back another time!");
        System.out.println("[n] No, I want to stay!");
    }


    public static void exit() {
        try {
            ProcessBuilder pb = new ProcessBuilder("clear");
            Process p = pb.start();
            p.waitFor();
            System.out.println("Exiting program.");
            TimeUnit.SECONDS.sleep(1);
            pb = new ProcessBuilder("clear");
            p = pb.start();
            p.waitFor();
            System.out.println("Exiting program..");
            TimeUnit.SECONDS.sleep(1);
            pb = new ProcessBuilder("clear");
            p = pb.start();
            p.waitFor();
            System.out.println("Exiting program...");
            TimeUnit.SECONDS.sleep(1);
            pb = new ProcessBuilder("clear");
            p = pb.start();
            p.waitFor();
            System.out.println("Exiting program....");
            TimeUnit.SECONDS.sleep(1);
            pb = new ProcessBuilder("clear");
            p = pb.start();
            p.waitFor();
            System.out.println("Exiting program.....");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    public static void loged_options() {
        System.out.println("==Bank==");
        System.out.println("Welcome back dear " + BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3] + " " + BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 2] + " how can we serve you today ?");
        System.out.println("[i] Increase inventory");
        System.out.println("[t] Transfer value");
        System.out.println("[d] Delete your bank account");
        System.out.println("[c] Charging");
        System.out.println("[h] History");
        System.out.println("[b] Borrowing programs");
        System.out.println("[p] Pay your borrowing");
        System.out.println("[e] Exit your account");
        
    }

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        int number_of_accounts = 0 ;
        
        Scanner scanner = new Scanner(System.in);
        // try{
        //     BankCsv.file_update() ;
        //     BankCsv.file_update_broowing() ;
        // }
        // catch (IOException e){
        //     e.printStackTrace();
        // }
        
        BankCsvReader.read_data() ;
        BankCsvReader.read_borrowing_data();
        for (String[] row : BankSignUp.users_detail) {
            String file_name = row[3]+".txt" ;
            File file = new File(file_name) ;
            if (!file.exists()) {
                BankHistory.save_history(row[3]+".txt",row[0] + " " + row[1] + " has signed up") ;
            }
            number_of_accounts += 1 ;
        }
        // try{
        //     BankCsv.file_update();
        //     }
        //     catch (IOException e) {
        //         e.printStackTrace();
        //     }
            
        
        
        while (true) {
            greet();
            firstMenu();
            char choice = scanner.nextLine().charAt(0);
            System.out.print("\033[H\033[2J");
            if (choice == 'm') {
                
                //System.out.println(number_of_accounts);
                BankSignUp.userRegister();
                System.out.println("--------------------------------");
                                System.out.println("[b] back");
                                char choice_increas = scanner.nextLine().charAt(0);
                                while (true) {
                                    if (choice_increas == 'b'){
                                        System.out.print("\033[H\033[2J");
                                        break ;
                                    }
                                }
                System.out.print("\033[H\033[2J");
                //BankCsvReader.read_data() ;
                // try {
                //     BankCsv.file_update();
                // } catch (IOException e) {
                //     e.printStackTrace();
                // }
                // for (int i = 0; i < BankSignUp.users_detail.length; i++) {
                //     for (int j = 0; j < BankSignUp.users_detail[i].length; j++) {
                //         System.out.println(BankSignUp.users_detail[i][j]);
                //     }
                // }

               
                number_of_accounts += 1 ;
                
 
            } 
            else if (choice == 'l') {
                    int count_of_log_in = 1 ;
                    BankLogin.userLogin() ;

                    System.out.print("\033[H\033[2J");
                    if (BankLogin.has_user_logged_in){
                        while (true) {
                            loged_options();
                            if (count_of_log_in == 1)
                                BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt", BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has loged in ") ;
                            
                            char choice_loged_in = scanner.nextLine().charAt(0);
                            System.out.print("\033[H\033[2J");
                            if (choice_loged_in == 'e'){
                                System.out.println("==Bank==");
                                System.out.println("Are you sure you want to exit our account ?");
                                System.out.println("[y] Yes");
                                System.out.println("[n] NO");
                                char choice_exit_acc ;
                                while (true) {
                                    choice_exit_acc = scanner.nextLine().charAt(0);
                                    if (choice_exit_acc == 'y'){
                                        break;
                                    }
                                    else if (choice_exit_acc == 'n'){
                                        break;
                                    }
                                } 
                                System.out.print("\033[H\033[2J");
                                if (choice_exit_acc == 'y'){
                                    BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ] +".txt", BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has logged out from his/her account " ) ;
                                    System.out.println("Good bye " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2]) ;
                                    break ;
                                }
                            }
                            else if (choice_loged_in == 'i') {
                                BankIncreaseInventory.Increase_value() ;
                                System.out.println("--------------------------------");
                                System.out.println("[b] back");
                                char choice_increas = scanner.nextLine().charAt(0);
                                while (true) {
                                    if (choice_increas == 'b'){
                                        System.out.print("\033[H\033[2J");
                                        break ;
                                    }
                                }
                                
                            }
                            else if (choice_loged_in == 'b') {
                                BankBorrowing.borrow() ;
                                System.out.println("--------------------------------");
                                System.out.println("[b] back");
                                char choice_increas = scanner.nextLine().charAt(0);
                                while (true) {
                                    if (choice_increas == 'b'){
                                        System.out.print("\033[H\033[2J");
                                        break ;
                                    }
                                }
                            }
                            else if (choice_loged_in == 'p') {
                                BankPayment.re_pay() ;
                                System.out.println("--------------------------------");
                                System.out.println("[b] back");
                                char choice_increas = scanner.nextLine().charAt(0);
                                while (true) {
                                    if (choice_increas == 'b'){
                                        System.out.print("\033[H\033[2J");
                                        break ;
                                    }
                                }
                            }
                            else if (choice_loged_in == 't') {
                                BankTransferValue.tranfer_value() ;
                                System.out.println("--------------------------------");
                                System.out.println("[b] back");
                                char choice_increas = scanner.nextLine().charAt(0);
                                while (true) {
                                    if (choice_increas == 'b'){
                                        System.out.print("\033[H\033[2J");
                                        break ;
                                    }
                                }
                            }
                            else if (choice_loged_in == 'c') {
                                BankCharge.charge() ;
                                System.out.println("--------------------------------");
                                System.out.println("[b] back");
                                char choice_increas = scanner.nextLine().charAt(0);
                                while (true) {
                                    if (choice_increas == 'b'){
                                        System.out.print("\033[H\033[2J");
                                        break ;
                                    }
                                }
                            }
                            else if (choice_loged_in == 'h') {
                                BankHistory.read_saved_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ] +".txt");
                                BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt", BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has cheked his/her history ") ;
                                System.out.println("--------------------------------");
                                System.out.println("[b] back");
                                char choice_history = scanner.nextLine().charAt(0);
                                while (true) {
                                    if (choice_history == 'b'){
                                        System.out.print("\033[H\033[2J");
                                        break ;
                                    }
                                }
                            }
                            else if (choice_loged_in == 'd') {
                                BankDeleteAccount.Delete_account() ;
                                break ;
                            }
                            count_of_log_in += 1 ;
                            
                        }
                    }
            }
            else if (choice == 'e') {
                boolean exitLoop = false;
                while (!exitLoop) {
                    exitMenu();
                    char choice_exit_menu = scanner.nextLine().charAt(0);
                    if (choice_exit_menu == 'y') {
                        System.out.print("\033[H\033[2J");
                        exit();
                    } else if (choice_exit_menu == 'n') {
                        break;
                    }
                }
            } 
            else {
                System.out.println("Invalid choice. Please try again.");
            }
            // firstMenu();
            // choice = scanner.nextLine().charAt(0);
        }
        
    
                     
    }
}




