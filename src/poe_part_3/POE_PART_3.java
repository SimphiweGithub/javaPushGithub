
package poe_part_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class POE_PART_3 {

    static { JOptionPane.showMessageDialog(null, "Please enter your first name:"); }
    public static String FirstName = FirstName();
    static { JOptionPane.showMessageDialog(null, "Please enter your last name:"); }
    public static String LastName = LastName();

    public static String Hold_Username;
    public static String Hold_Password;
    public boolean usernameValid;
    public boolean passwordComplexityValid;

    public static void main(String[] args) {
       System.out.println(registerUser());
        System.out.println(returnLoginStatus());
         Task.main(args);
        
    }

    private static String FirstName() {
        return JOptionPane.showInputDialog("Enter your first name:");
    }

    private static String LastName() {
        return JOptionPane.showInputDialog("Enter your last name:");
    }

    public static String registerUser() {
        Hold_Username = JOptionPane.showInputDialog("Please enter your username: ");
        while (!checkUserName(Hold_Username)) {
            JOptionPane.showMessageDialog(null, "Username is not correct, please ensure that your username contains an underscore and is no more than 5 characters in length");
            Hold_Username = JOptionPane.showInputDialog("Please enter your username again: ");
        }

        Hold_Password = JOptionPane.showInputDialog("Please enter your password: ");
        while (!checkPasswordComplexity(Hold_Password)) {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure your password contains at least 8 characters, a capital letter, a number, and a special character");
            Hold_Password = JOptionPane.showInputDialog("Please enter your password again: ");
        }

        return "You have successfully registered.";
    }

    public static boolean checkUserName(String Hold_Username) {
        return (Hold_Username.length() <= 5) && (Hold_Username.contains("_"));
    }

    public static boolean checkPasswordComplexity(String Hold_Password) {
        Pattern Password_complex_checker = Pattern.compile("[a-zA-Z0-9]*");
        Pattern Password_Capital_letters = Pattern.compile("[A-Z]");
        Pattern Password_number_checker = Pattern.compile("[0-9]");

        Matcher Pass_complex_check_matcher = Password_complex_checker.matcher(Hold_Password);
        Matcher Password_Capital_letter_checker = Password_Capital_letters.matcher(Hold_Password);
        Matcher Password_number_checker_2 = Password_number_checker.matcher(Hold_Password);

        return Hold_Password.length() >= 8 && Pass_complex_check_matcher.find() && Password_Capital_letter_checker.find() && Password_number_checker_2.find();
    }

    public static boolean loginUser(){
        String loginUsername = JOptionPane.showInputDialog("Please enter your login Username: ");
        String loginPassword = JOptionPane.showInputDialog("Please enter your login Password: ");
        return loginPassword.equals(Hold_Password) && loginUsername.equals(Hold_Username);
    }

    public static String returnLoginStatus() {
         
     boolean holdThis =loginUser();
        Task.decision =holdThis;
        if(holdThis) {
            return "Welcome " + FirstName + "," + LastName + " it is great to see you again";
        } else {
            return "Username and/or password Incorrect please try again";
        }
    }
}
