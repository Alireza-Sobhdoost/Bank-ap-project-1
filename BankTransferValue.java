import java.util.Scanner;

public class BankTransferValue {
    public static int[] dst_account_detail ;
    public static void Menu () {
        System.out.println("==Bank==");
        System.out.println("Please enter the account number which you want to transfer money ");

    }

    public static void tranfer_value () {
        Scanner scanner = new Scanner(System.in);
        boolean back_opt = false ;
        Menu () ;
        while (!back_opt){
            try {
                String dst_accountNumber = scanner.next();
                System.out.print("\033[H\033[2J");
                dst_account_detail = BankLogin.findIndex2D(BankSignUp.users_detail ,dst_accountNumber) ;
                if (dst_account_detail[0] != -1){
                    System.out.println("The account owner name is " + BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1] - 3] + " " + BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1] - 2] );
                    while (true){
                        System.out.println("==Bank==");
                        System.out.println("Do you want to countinue ?");
                        System.out.println("[c] countinue ");
                        System.out.println("[b] back");
                        char choice = scanner.next().charAt(0);
                        System.out.print("\033[H\033[2J");
                        if (choice == 'c') {
                            System.out.println("==Bank==");
                            System.out.println("Please enter the value which you want to transfer ");
                            boolean flag = false ;

                            while (!flag) {
                                flag = false ;
                                
                                try {
                                    int value = scanner.nextInt() ;
                                    System.out.print("\033[H\033[2J");
                                    if ((value <= 0) ||(value > Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1]))) {
                                        if (value <= 0) {
                                            System.out.println("The value should be a possetive number!");
                                        }
                                        else if ( value > Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1])) {
                                            System.out.println("The value is larger than your inventory !");
                                        }
                                        System.out.println("[c] countinue ");
                                        System.out.println("[b] back");
                                        
                                        while (true){
                                            char choice_transfer = scanner.next().charAt(0);
                                            System.out.print("\033[H\033[2J");
                                            if (choice_transfer == 'c') {
                                                System.out.println("==Bank==");
                                                System.out.println("Please enter the value considering that the value sould be a possetine number ");
                                                break ;
                                            } else if (choice_transfer == 'b') {
                                                flag = true;
                                            }
                                        }
                                    
                                    }   
                                    else {
                                        System.out.println("==Bank==");
                                        System.out.println("Please enter your password once again to verify the operation below  ");
                                        System.out.println("-------------------------------------------------------------------------");
                                        System.out.println("Transfer " + value + " to " + BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1] - 3] + " " + BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1] - 2]);
                                        System.out.println("-------------------------------------------------------------------------");
                                        boolean is_password_ok = false ;
                                        while (!is_password_ok && !flag) {
                                            try {
                                                String password = scanner.next();
                                                System.out.print("\033[H\033[2J");
                                                if (password.equals(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 1])) {
                                                    BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] +1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1]) - value);
                                                    BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1]+1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1]+1]) + value);
                                                    BankHistory.add_save_history(BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1] ]+".txt" , BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -3] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2]  + " has tranferd you "  + value +" tooman") ;
                                                    BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1]]+".txt" , "You have transfered " + value +" tooman to " + BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1] - 3] + " " + BankSignUp.users_detail[dst_account_detail[0]][dst_account_detail[1] - 2]) ;
                                                    
                                                    BankCsv.file_update();
                                                        
                                                    
                                                    System.out.println("Transfer value has comleted successfuly ! ");
                                                    back_opt = true ;
                                                    is_password_ok = true;
                                                    flag = true ;
                                                } else {
                                                    System.out.println("==Bank==");
                                                    System.out.println("Dear " + BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3] + " " + BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 2] + " The password you've entered is not correct. Please try again!");
                                                }
                                            }
                                            catch (Exception e){
                                                System.out.println("Error! password isn't in order !");
                                                System.out.println("[c] Countinue , try again");
                                                System.out.println("[b] Back");
                                                while (!flag){
                                                    char choice_a = scanner.next().charAt(0);
                                                    System.out.print("\033[H\033[2J");
                                                    if (choice_a == 'c') {
                                                        System.out.println("==Bank==");
                                                        System.out.println("Please enter your password correct ! ");
                                                        break ;
                                                    } else if (choice_a == 'b') {
                                                        flag = true;
                                                    }
                                                }
                                            continue;
                                        }
                                        }
                                       
                                    }
                                }
                                catch (Exception e){
                                        System.out.println("Error! Consider that the value sould be a integer number !");
                                        System.out.println("[c] Countinue , try again");
                                        System.out.println("[b] Back");
                                        while (!flag){
                                            char choice_a = scanner.next().charAt(0);
                                            System.out.print("\033[H\033[2J");
                                            if (choice_a == 'c') {
                                                System.out.println("==Bank==");
                                                System.out.println("Please enter the value considering that the value sould be a possetive number ");
                                                break ;
                                            } else if (choice_a == 'b') {
                                                flag = true;
                                            }
                                        }
                                    continue;
                                }
                            }
                            break ;
                        } else if (choice == 'b') {
                            
                            back_opt = true ;
                            break ;
                        }
                    }
                    
                }
                else {
                    System.out.println("Error! The account which you want to transfer value dosen't exist !");
                    System.out.println("[c] continue");
                    System.out.println("[b] back");
                    while (true){
                        char choice = scanner.next().charAt(0);
                        System.out.print("\033[H\033[2J");
                        if (choice == 'c') {
                            System.out.println("==Bank==");
                            System.out.println("Please enter your account number again correctly:");
                            break ;
                        } else if (choice == 'b') {
                            back_opt = true ;
                            break ;
                        }
                    }
                }
            }   
            catch (Exception e) {
                //System.out.println("==Bank==");
                System.out.println("Error! Invalid input !");
                System.out.println("[c] continue");
                System.out.println("[b] back");
                    while (true){
                        char choice = scanner.next().charAt(0);
                        System.out.print("\033[H\033[2J");
                        if (choice == 'c') {
                            System.out.println("==Bank==");
                            System.out.println("Please enter your account number again correctly:");
                            break ;
                        } else if (choice == 'b') {
                            back_opt = true ;
                            break ;
                        }
                    }
                
            }    
        }


    }
}
