public class ScoreOfAString {
    public static int scoreOfString(String s) {
        int score = 0;
        for(char ch=0; ch<s.length()-1; ch++){
            score += Math.abs((int) s.charAt(ch) - (int) s.charAt(ch+1));
        }

        return score;
    }

    public static void main(String[] args){
        String s = "aman";
        System.out.println(scoreOfString(s));
    }
}
