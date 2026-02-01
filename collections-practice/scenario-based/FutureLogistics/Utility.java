public class Utility {

    public static boolean validateTransportId(String transportId) {
        return transportId.matches("RTS[0-9]{3}[A-Z]");
    }

    public static GoodsTransport parseDetails(String input) {
        String[] data = input.split(":");

        String transportId = data[0];
        String date = data[1];
        int rating = Integer.parseInt(data[2]);
        String type = data[3];

        if (!validateTransportId(transportId)) {
            System.out.println("Transport id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            return null;
        }

        if (type.equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(
                    transportId, date, rating,
                    Float.parseFloat(data[4]),
                    Integer.parseInt(data[5]),
                    Float.parseFloat(data[6])
            );
        }

        if (type.equalsIgnoreCase("TimberTransport")) {
            return new TimberTransport(
                    transportId, date, rating,
                    Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),
                    data[6],
                    Float.parseFloat(data[7])
            );
        }
        return null;
    }

    public static String findObjectType(GoodsTransport gt) {
        if (gt instanceof TimberTransport)
            return "TimberTransport";
        if (gt instanceof BrickTransport)
            return "BrickTransport";
        return "Unknown";
    }
}
