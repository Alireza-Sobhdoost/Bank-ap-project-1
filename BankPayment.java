import java.util.Scanner;
import java.io.IOException;

public class BankPayment {
    static  int[] detail_of_borrow = new int[2];
    
    public static void Menu () {
        System.out.println("==Bank==");
        System.out.println("Please enter your identify code (to pay your borrowing's cost)");
    }
    
    public static void re_pay (){

        Menu();
        Scanner scanner = new Scanner(System.in);

        boolean has_user_payed = false;
        boolean back_opt = false ;
       

        while (!has_user_payed && !back_opt) {
            try{

                String identify_code = scanner.next();
                System.out.print("\033[H\033[2J");
                detail_of_borrow = BankLogin.findIndex2D(BankBorrowing.broowing_detail , identify_code) ;
                // System.out.println(identify_code.substring(1, 5)) ;
                // System.out.println(identify_code.substring(0, 1)) ;
                if (BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]].equals(identify_code)){
                    if (BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1]].equals(identify_code.substring(1, 5))){
                        if ("1".equals(identify_code.substring(0, 1))){
                            if (Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1]) < 4250000) {
                                System.out.println("Your credit isn't enough to pay your cost");
                                System.out.println("[c] try again") ;
                                System.out.println("[b] back") ;
                                while (!has_user_payed){
                                    char choice = scanner.next().charAt(0);
                                    System.out.print("\033[H\033[2J");
                                    if (choice == 'c') {
                                        Menu();
                                        break ;
                                    } else if (choice == 'b') {
                                        back_opt = true;
                                        break ;
                                    }
                                }
                            }
                            else{

                                if (Integer.parseInt(BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]+1]) > 1) {
                                    System.out.println("Cost payment has been done successfully ");
                                    
                                    BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1]) - 4250000);
                                    BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]+1] = String.valueOf(Integer.parseInt(BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]+1]) - 1) ;
                                
                                    try {
                                        BankCsv.file_update_broowing() ;
                                        
                                        BankCsv.file_update();     
                                        BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt" , BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has payed one of his/her cost " + BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]] +" and there is " +BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]+1] +" costs left") ;
                                        }
                                    catch (IOException e) {
                                        e.printStackTrace();
                                        }
                                        has_user_payed = true;
                                }
                                else if (Integer.parseInt(BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]+1]) == 1) 
                                {   

                                    System.out.println("Congratulation ! You have payed all of your costs ! ");
                                    BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1] = String.valueOf(Integer.parseInt(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] + 1]) - 4250000);
                                    BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]+1] = String.valueOf(Integer.parseInt(BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]+1]) - 1) ;
                                
                                    try {
                                        BankCsv.file_update_broowing() ;
                                        
                                        BankCsv.file_update();     
                                        BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt" , BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has payed  his/her the last cost " + BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]]) ;
                                    }
                                    catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    has_user_payed = true;
                                }
                                else if (Integer.parseInt(BankBorrowing.broowing_detail[detail_of_borrow[0]][detail_of_borrow[1]+1]) <= 0){
                                    System.out.println("You have paid All costs of this borrowing program");
                                    has_user_payed = true;
                                    
                                }
                                
                            }

                        }
                        else {
                            System.out.println("This borrowing program doesn't exist !");
                            System.out.println("[c] try again") ;
                            System.out.println("[b] back") ;
                            while (!has_user_payed){
                                char choice = scanner.next().charAt(0);
                                System.out.print("\033[H\033[2J");
                                if (choice == 'c') {
                                    Menu();
                                    break ;
                                } else if (choice == 'b') {
                                    back_opt = true;
                                    break ;
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("You dont use any borrowing program ! so you dont have to pay :) ");
                        System.out.println("[c] try again") ;
                        System.out.println("[b] back") ;
                        while (!has_user_payed){
                            char choice = scanner.next().charAt(0);
                            System.out.print("\033[H\033[2J");
                            if (choice == 'c') {
                                Menu();
                                break ;
                            } else if (choice == 'b') {
                                back_opt = true;
                                break ;
                            }
                        }
                    }

                }
                else {
                    System.out.println("This identify code doesn't exist");
                    System.out.println("[c] try again") ;
                    System.out.println("[b] back") ;
                    while (!has_user_payed){
                        char choice = scanner.next().charAt(0);
                        System.out.print("\033[H\033[2J");
                        if (choice == 'c') {
                            Menu();
                            break ;
                        } else if (choice == 'b') {
                            back_opt = true;
                            break ;
                        }
                    }

                }
                
            }
            catch (Exception e){
                System.out.println("Error! the entered code is invalid !");
                System.out.println("[c] try again") ;
                System.out.println("[b] back") ;
                while (!has_user_payed){
                    char choice = scanner.next().charAt(0);
                    System.out.print("\033[H\033[2J");
                    if (choice == 'c') {
                        Menu();
                        break ;
                    } else if (choice == 'b') {
                        back_opt = true;
                        break ;
                    }
                }
                
            }

        }
            


    }

}

