import java.util.*;
import java.util.regex.*;
import java.time.LocalDate;

public class DynamicTemplateProcessor {
    public static String processLine(String line){
        Pattern pattern = Pattern.compile("\\$\\{(\\w+):(.*?)\\}");
        Matcher matcher = pattern.matcher(line);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String type = matcher.group(1);
            String value = matcher.group(2);

            String replacement = processPlaceholder(type, value);

            matcher.appendReplacement(result, replacement);
        }

        matcher.appendTail(result);
        return result.toString();
    }

    private static String processPlaceholder(String type, String value) {
        try {
            switch (type) {
                case "UPPER":
                    return value.toUpperCase();

                case "LOWER":
                    return value.toLowerCase();

                case "DATE":
                    return processDate(value);

                case "REPEAT":
                    return processRepeat(value);

                default:
                    return "INVALID";
            }
        } catch (Exception e) {
            return "INVALID";
        }
    }

    private static String processDate(String value) {
        String[] parts = value.split("-");
        if (parts.length != 3) return "INVALID";

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        // Validate date using LocalDate
        LocalDate date = LocalDate.of(year, month, day);

        return String.format("%04d/%02d/%02d", year, month, day);
    }

    private static String processRepeat(String value) {
        String[] parts = value.split(",");
        if (parts.length != 2) return "INVALID";

        String word = parts[0];
        int count = Integer.parseInt(parts[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(word);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            String line = sc.nextLine();
            System.out.println(processLine(line));
        }
    }
}
