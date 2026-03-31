import java.util.*;
public class ReturnAllCharacters {
	public static char[] withoutUsingCharArray(String str) {
		char[] chars = new char[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			chars[i] = str.charAt(i);
		}
		return chars;
	}
	
	public static boolean comparision(char[] arr1, char[] arr2) {
		if(arr1.length != arr2.length) {
			return false;
		}
		for(int i=0; i<arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.next();
        
        char[] manual = withoutUsingCharArray(str);
        
        char[] inBuilt = str.toCharArray();
        boolean answer = comparision(manual, inBuilt);
        
        System.out.print("Characters using user defined method: ");
        for(char c : manual) {
        	System.out.println(c + " ");
        }
        
        System.out.print("Characters using In Built method: ");
        for(char c : inBuilt) {
        	System.out.println(c + " ");
        }
        
        System.out.println("Are Both Character Arrays equal: " + answer);
    }
}
