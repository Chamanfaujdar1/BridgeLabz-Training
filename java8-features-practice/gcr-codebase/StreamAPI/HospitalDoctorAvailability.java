import java.util.*;

public class HospitalDoctorAvailability {
    static class Doctor {
        String name;
        String specialty;
        boolean availableOnWeekend;

        Doctor(String name, String specialty, boolean availableOnWeekend) {
            this.name = name;
            this.specialty = specialty;
            this.availableOnWeekend = availableOnWeekend;
        }

        @Override
        public String toString() {
            return name + " | Specialty: " + specialty +
           " | Weekend Available: " + availableOnWeekend;
        }
    }

    public static void main(String[] args){
        List<Doctor> doctors = List.of(
            new Doctor("Dr. Sharma", "Cardiology", true),
            new Doctor("Dr. Mehta", "Neurology", false),
            new Doctor("Dr. Khan", "Orthopedics", true),
            new Doctor("Dr. Singh", "Dermatology", true),
            new Doctor("Dr. Patel", "Pediatrics", false),
            new Doctor("Dr. Rao", "Cardiology", true)
        );

        List<Doctor> weekendDoctors = doctors.stream()

            // 1️⃣ Filter doctors available on weekends
            .filter(doctor -> doctor.availableOnWeekend)

            // 2️⃣ Sort by specialty (alphabetical order)
            .sorted(Comparator.comparing(d -> d.specialty))

            .toList();

        // Print result
        System.out.println("🏥 Doctors Available on Weekends (Sorted by Specialty):");
        weekendDoctors.forEach(System.out::println);

    }
}
