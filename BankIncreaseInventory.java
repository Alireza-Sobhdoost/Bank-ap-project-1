import java.io.IOException;
import java.util.Scanner;

public class BankIncreaseInventory {
    
    public static void Menu() {
        System.out.println("==Bank==");
        System.out.println("How many toman you want to add to your bank value ?");
        //System.out.println("Consider that the value sould be a possetine number !");

    }

    public static void Increase_value () {
        Menu() ;
        Scanner scanner = new Scanner(System.in);
        
        boolean flag = false ;
        
        while (!flag) {
            flag = false ;
            
            try {
                int value = scanner.nextInt() ;
                System.out.print("\033[H\033[2J");
                if (value > 0) {
                    BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1]) + value);
                    try {
                    BankCsv.file_update();     
                    BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt" , BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has increased his/her value " + value + " Toman") ;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Your value has been increased successfully !");
                    break ;
                }
                else {
                    System.out.println("Error! Consider that the value sould be a possetine number !");
                    System.out.println("[c] Countinue , try again");
                    System.out.println("[b] Back");
                    while (!flag){
                        char choice = scanner.next().charAt(0);
                        if (choice == 'c') {
                            System.out.println("==Bank==");
                            System.out.println("Please enter the value considering that the value sould be a possetine number ");
                            break ;
                        } else if (choice == 'b') {
                            flag = true;
                        }
                    }
                }
            }
            catch (Exception e){
                    System.out.println("Error! Consider that the value sould be a integer number !");
                    System.out.println("[c] Countinue , try again");
                    System.out.println("[b] Back");
                    while (!flag){
                        char choice = scanner.next().charAt(0);
                        if (choice == 'c') {
                            System.out.println("==Bank==");
                            System.out.println("Please enter the value considering that the value sould be a possetine number ");
                            break ;
                        } else if (choice == 'b') {
                            flag = true;
                        }
                    }
                continue;
            }
        }
    } 
}
