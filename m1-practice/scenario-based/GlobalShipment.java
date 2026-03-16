public class GlobalShipment {
    static boolean validCode(String code){
        if(!code.matches("SHIP-[1-9][0-9]{5}")){
            return false;
        }

        String digits = code.substring(5);
        int count = 1;
        for(int i=1; i<digits.length(); i++){
            if(digits.charAt(i) == digits.charAt(i-1)){
                count++;
                if(count > 3){
                    return false;
                }
            }else{
                count = 1;
            }
        }
        return true;
    }

    static boolean validDate(String date){
        try{
            if(!date.matches("20\\d{4}-\\d{2}-\\d{2}")){
            return false;
            }
            LocalDate.parse(date);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    static boolean validMode(String mode){
        String[] modes = {"AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT"};
        for(String m : modes){
            if(m.equals(mode)){
                return true;
            }
        }
        return false;
    }

    static boolean validWeight(String weight){
        if(!weight.matches("(0|[1-9]\\d{0,5})(\\.\\d{1,2})?")){
            return false;
        }
        double w = Double.parseDouble(weight);

        return w >= 0 && w <= 999999.99;
    }

    static boolean validStatus(String status){
        String[] statuses = {"DELIVERED", "CANCELLED", "IN_TRANSIT"};

        for(String s : statuses){
            if(s.equals(status)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++){
            String record = sc.nextLine();
            String[] parts = record.split("\\|");

            if(parts.length != 5){
                System.out.println("IN_TRANSIT");
                continue;
            }

            boolean valid =
                    validCode(parts[0]) &&
                    validDate(parts[1]) &&
                    validMode(parts[2]) &&
                    validWeight(parts[3]) &&
                    validStatus(parts[4]);

            if(valid){
                System.out.println("COMPLIANT RECORD");
            }else{
                System.out.println("NON-COMPLIANT RECORD");
            }
        }
    }
}
