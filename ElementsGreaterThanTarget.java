public class ElementsGreaterThanTarget{
	public static String helper(String str, char target){
		String ans = "";
		for(char ch : str.toCharArray()){
			if(ch > target){
				ans += ch;
			}
		}

		return ans.toString();
	}

	public static void main(String[] args){
		String str = "cfj";
		char target = 'c';
		System.out.println(helper(str, target));
		
	}
}