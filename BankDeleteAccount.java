import java.util.Scanner;

public class BankDeleteAccount {
    public static void Menu() {
        System.out.println("==Bank==");
        System.out.println(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3] + " " + BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 2] + " to delete your account please enter your password please");
        //System.out.println("Consider that the value should be a positive number !");
    }

    public static void Delete_account() {
        Scanner scanner = new Scanner(System.in);
        Menu();
        boolean back_opt = false;
        boolean password_received = false;

        while (!back_opt && !password_received) {
            try {
                String password = scanner.next();
                System.out.print("\033[H\033[2J");
                if (password.equals(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 1])) {
                    System.out.println("==Bank==");
                    System.out.println("Are you sure you want to delete your account?");
                    System.out.println("[y] Yes");
                    System.out.println("[n] No");

                    while (true) {
                        char choice_delete = scanner.next().charAt(0);
                        System.out.print("\033[H\033[2J");
                        if (choice_delete == 'y') {
                            // Code to delete the account
                            BankHistory.add_save_history(BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] ]+".txt", BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3 ] + " " +BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] -2] +" has deleted his/her account ") ;
                            String[][] newArray = new String[BankSignUp.users_detail.length - 1][BankSignUp.users_detail[0].length];
                            int newIndex = 0;
                            for (int i = 0; i < BankSignUp.users_detail.length; i++) {
                                if (i != BankLogin.account_detail[0]) {
                                    newArray[newIndex++] = BankSignUp.users_detail[i];
                                }
                            }
                            BankSignUp.users_detail = newArray;
                            BankCsv.file_update() ;
                            System.out.println("==Bank==");
                            System.out.println("Your account had deleted successfully !");
                            for (String[] row :  BankSignUp.users_detail) {
                                        for (String element : row) {
                                            System.out.print(element + " ");
                                        }
                                        System.out.println();
                                    }

                            password_received = true;
                            break;
                        } else if (choice_delete == 'n') {
                            password_received = true;
                            break;
                        }
                    }
                } else {
                    System.out.println("==Bank==");
                    System.out.println("Dear " + BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 3] + " " + BankSignUp.users_detail[BankLogin.account_detail[0]][BankLogin.account_detail[1] - 2] + " The password you've entered is not correct. Please try again!");
                    System.out.println("[c] Continue");
                    System.out.println("[b] Back");

                    while (true) {
                        char choice_wrong_pass = scanner.next().charAt(0);
                        if (choice_wrong_pass == 'c') {
                            System.out.println("==Bank==");
                            System.out.println("Please enter your password again correctly:");
                            break;
                        } else if (choice_wrong_pass == 'b') {
                            back_opt = true;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("==Bank==");
                System.out.println("Error! Invalid input !");
                System.out.println("[c] Continue");
                System.out.println("[b] Back");

                while (true) {
                    char choice = scanner.next().charAt(0);
                    if (choice == 'c') {
                        System.out.println("==Bank==");
                        System.out.println("Please enter your password again correctly:");
                        break;
                    } else if (choice == 'b') {
                        back_opt = true;
                        break;
                    }
                }
            }
        }
    }
}
