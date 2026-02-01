public class TimberTransport extends GoodsTransport {
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius,
                           String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    @Override
    public String vehicleSelection() {
        float area = 2 * 3.147f * timberRadius * timberLength;
        if (area < 250)
            return "Truck";
        else if (area <= 400)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {
        float volume = 3.147f * timberRadius * timberRadius * timberLength;

        float typeRate = timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f;
        float price = volume * timberPrice * typeRate;

        float tax = price * 0.3f;

        float discount = 0;
        if (transportRating == 5)
            discount = price * 0.20f;
        else if (transportRating == 3 || transportRating == 4)
            discount = price * 0.10f;

        float vehicleCost = getVehicleCost(vehicleSelection());
        return (price + tax + vehicleCost) - discount;
    }

    private float getVehicleCost(String vehicle) {
        if (vehicle.equalsIgnoreCase("Truck")) return 1000;
        if (vehicle.equalsIgnoreCase("Lorry")) return 1700;
        return 3000;
    }

    public String getTimberType() {
        return timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }
}
