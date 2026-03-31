import java.time.LocalDate;

public class Policy {
    private final String policyNumber;
    private final String policyholderName;
    private final LocalDate expiryDate;
    private final String coverageType;
    private final double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return policyNumber.equals(p.policyNumber);
    }

    public int hashCode() {
        return policyNumber.hashCode();
    }

    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", name='" + policyholderName + '\'' +
                ", expiry=" + expiryDate +
                ", coverage='" + coverageType + '\'' +
                ", premium=" + premiumAmount +
                '}';
    }
}
