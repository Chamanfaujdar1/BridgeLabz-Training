public class TemperatureAnalyzer {

    public static void main(String[] args) {
        float[][] weeklyData = new float[7][24];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                weeklyData[i][j] = 20.0f + (float)(Math.random() * 15); 
            }
        }
        analyzeTemperatures(weeklyData);
    }

    public static void analyzeTemperatures(float[][] tempData) {
        float globalMax = -Float.MAX_VALUE;
        float globalMin = Float.MAX_VALUE;
        int hottestDayIdx = 0;
        int coldestDayIdx = 0;
        
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println("--- Daily Average Temperatures ---");
        
        for (int day = 0; day < tempData.length; day++) {
            float daySum = 0;
            
            for (int hour = 0; hour < tempData[day].length; hour++) {
                float currentTemp = tempData[day][hour];
                daySum += currentTemp;
                if (currentTemp > globalMax) {
                    globalMax = currentTemp;
                    hottestDayIdx = day;
                }
                if (currentTemp < globalMin) {
                    globalMin = currentTemp;
                    coldestDayIdx = day;
                }
            }
            
            float average = daySum / tempData[day].length;
            System.out.printf("%s: %.2f°C%n", daysOfWeek[day], average);
        }

        System.out.println("\n--- Analysis Result ---");
        System.out.println("The Hottest Day was: " + daysOfWeek[hottestDayIdx] + " (Peak: " + globalMax + "°C)");
        System.out.println("The Coldest Day was: " + daysOfWeek[coldestDayIdx] + " (Low: " + globalMin + "°C)");
    }
}