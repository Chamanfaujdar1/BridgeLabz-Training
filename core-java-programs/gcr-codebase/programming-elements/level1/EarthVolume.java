public class VolumeCalculator{
	public static void main(String[] args){
		double radius = 6371; // radius of earth in km
        double pi = Math.PI;

        double volumeKm = (4.0 / 3.0) * pi * radius * radius * radius;
        double volumeMiles = volumeKm / 0.24;

        System.out.println(
            "The volume of Earth in cubic kilometers is " + volumeKm +
            " and cubic miles is " + volumeMiles
        );
	}

	


 

}
