import java.util.Scanner;

public class BankLogin {

    public static int[] account_detail ;
    public static boolean has_user_logged_in = false;
    //public static String[][] users_detail; // Define the users_detail variable

    public static int[] findIndex2D(String[][] arr, String target) {
        int[] index = new int[2]; // Store the row and column indices

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals(target)) {
                    index[0] = i; // Row index
                    index[1] = j; // Column index
                    return index;
                }
            }
        }

        // If the target element is not found
        index[0] = -1;
        index[1] = -1;
        return index;
    }

    public static void login_menu() {
        System.out.println("==Bank==");
        System.out.println("Welcome! Please enter your account number:");
    }

    public static void login_error() {
        System.out.println("==Bank==");
        System.out.println("The account doesn't exist! or maybe you've entered your account number wrong!");
        System.out.println("[c] continue");
        System.out.println("[b] back");
    }

    // public static void main(String[] args) {
    //     String[][] my_array = {{"A", "S", "1213", "1111", "10000"}, {"s", "S", "1214", "2222", "10000"}};
    //     BankSignUp.users_detail = my_array; // Assign the array to users_detail
    //     userLogin();
    // }

    public static void userLogin() {
        Scanner scanner = new Scanner(System.in);
        login_menu();
        
        has_user_logged_in = false;

        while (!has_user_logged_in) {
            try{
                String accountNumber = scanner.next();
                System.out.print("\033[H\033[2J");
                account_detail = findIndex2D(BankSignUp.users_detail, accountNumber);
                if (account_detail[0] != -1) {
                    System.out.println("==Bank==");
                    System.out.println("Welcome back dear " + BankSignUp.users_detail[account_detail[0]][account_detail[1] - 3] + " " + BankSignUp.users_detail[account_detail[0]][account_detail[1] - 2] + " Please enter your password");

                    while (!has_user_logged_in) {
                        String password = scanner.next();
                        System.out.print("\033[H\033[2J");
                        if (password.equals(BankSignUp.users_detail[account_detail[0]][account_detail[1] - 1])) {
                            System.out.println("You have logged in successfully !");
                            has_user_logged_in = true;
                        } else {
                            System.out.println("==Bank==");
                            System.out.println("Dear " + BankSignUp.users_detail[account_detail[0]][account_detail[1] - 3] + " " + BankSignUp.users_detail[account_detail[0]][account_detail[1] - 2] + " The password you've entered is not correct. Please try again!");
                        }
                    }
                } else {
                    login_error();
                    while (!has_user_logged_in){
                        char choice = scanner.next().charAt(0);
                        System.out.print("\033[H\033[2J");
                        if (choice == 'c') {
                            System.out.println("==Bank==");
                            System.out.println("Please enter your account number again correctly:");
                            break ;
                        } else if (choice == 'b') {
                            has_user_logged_in = true;
                        }
                    }
                }
            }
            catch (Exception e) {
                login_error();
                    while (!has_user_logged_in){
                        char choice = scanner.next().charAt(0);
                        System.out.print("\033[H\033[2J");
                        if (choice == 'c') {
                            System.out.println("==Bank==");
                            System.out.println("Please enter your account number again correctly:");
                            break ;
                        } else if (choice == 'b') {
                            has_user_logged_in = true;
                        }
                    }
            }
        }
    }
}
