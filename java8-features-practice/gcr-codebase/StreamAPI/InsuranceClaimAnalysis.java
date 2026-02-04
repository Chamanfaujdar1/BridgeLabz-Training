import java.util.*;
import java.util.stream.*;

public class InsuranceClaimAnalysis {
    static class Claim {
        String claimType;
        double claimAmount;

        Claim(String claimType, double claimAmount) {
            this.claimType = claimType;
            this.claimAmount = claimAmount;
        }
    }

    public static void main(String[] args){
        List<Claim> claims = List.of(
            new Claim("Health", 50000),
            new Claim("Vehicle", 30000),
            new Claim("Health", 70000),
            new Claim("Property", 120000),
            new Claim("Vehicle", 45000),
            new Claim("Health", 60000),
            new Claim("Property", 100000)
        );

        Map<String, Double> averageClaimByType = claims.stream()
            .collect(
                Collectors.groupingBy(
                    claim -> claim.claimType,
                    Collectors.averagingDouble(claim -> claim.claimAmount)
                )
            );

        System.out.println("Average Claim Amount by Claim Type:");
        averageClaimByType.forEach((type, avgAmount) ->
            System.out.println(type + " → " + avgAmount)
        );
    }
}
