// package java8_features_practice.LambdaExpressions;

public class SmartHomeLightingAutomation {
	interface LightAction{
		void execute(String location);
	}
	
	static class SmartLightSystem{
		public void activateLight(String location, LightAction action) {
			System.out.println("Trigger received for: " + location);
                        action.execute(location);
                        System.out.println("---------");
		}
	}
	
	public static void main(String[] args) {
		SmartLightSystem smla = new SmartLightSystem();

		smla.activateLight("Hallway",
                loc -> System.out.println("Motion detected! Turning ON bright lights in " + loc));
		
		smla.activateLight("Bedroom",
                loc -> System.out.println("Night mode: Dimming lights in " + loc));

        smla.activateLight("Living Room",
                loc -> System.out.println("Voice command: Activating PARTY lights in " + loc));

        smla.activateLight("Entire House",
                loc -> System.out.println("Away mode: Turning OFF all lights in " + loc));

        smla.activateLight("Garden",
                loc -> System.out.println("Sunset mode: Warm lights ON in " + loc));
	}
}
