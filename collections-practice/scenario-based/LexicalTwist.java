public class LexicalTwist {
    private static boolean isValidWord(String word) {
        return !word.contains(" ");
    }

    private static boolean isReverse(String first, String second) {
        String reversed = new StringBuilder(first).reverse().toString();
        return reversed.equalsIgnoreCase(second);
    }

    private static String replaceVowels(String word) {
        return word.replaceAll("[aeiou]", "@");
    }

    private static boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) != -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        if (!isValidWord(first)) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        if (!isValidWord(second)) {
            System.out.println(second + " is an invalid word");
            return;
        }

        if (isReverse(first, second)) {
            String result = new StringBuilder(first)
                    .reverse()
                    .toString()
                    .toLowerCase();
            result = replaceVowels(result);
            System.out.println(result);
        }

        else{
            String combined = (first + second).toUpperCase();

            int vowelCount = 0, consonantCount = 0;
            LinkedHashSet<Character> vowels = new LinkedHashSet<>();
            LinkedHashSet<Character> consonants = new LinkedHashSet<>();

            for (char ch : combined.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (isVowel(ch)) {
                        vowelCount++;
                        vowels.add(ch);
                    } else {
                        consonantCount++;
                        consonants.add(ch);
                    }
                }
            }

            if (vowelCount > consonantCount) {
                int count = 0;
                for (char v : vowels) {
                    System.out.print(v);
                    if (++count == 2) break;
                }
            } 
            else if (consonantCount > vowelCount) {
                int count = 0;
                for (char c : consonants) {
                    System.out.print(c);
                    if (++count == 2) break;
                }
            } 
            else {
                System.out.println("Vowels and consonants are equal");
            }
        }
        sc.close();
    }
}
