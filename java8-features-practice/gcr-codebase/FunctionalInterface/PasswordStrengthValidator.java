public class PasswordStrengthValidator {
    interface SecurityUtils{
        static boolean isStrongPassword(String password){
            if(password == null || password.length() < 8){
                return false;
            }

            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            for(char ch : password.toCharArray()){
                if(Character.isUpperCase(ch)) hasUpper = true;
                else if(Character.isLowerCase(ch)) hasLower = true;
                else if(Character.isDigit(ch)) hasDigit = true;
                else hasSpecial = true;
            }

            return hasUpper && hasLower && hasDigit && hasSpecial;
        }
    }

    public static void main(String[] args){
        String password = "Ch@m@n12345";
        if(SecurityUtils.isStrongPassword(password)){
            System.out.println("The password is strong.");
        }
        else{
            System.out.println("The password is weak.");
        }
    }
}
