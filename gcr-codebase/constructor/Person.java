public class Person {
    String name;
    int age;
    String gender;

    Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    Person(Person person1){
        this.name = person1.name;
        this.age = person1.age;
        this.gender = person1.gender;
    }

    void displayPersonInfo(){
        System.out.println("Name: " + name + ", Age: " + age + ", gender: " + gender);
    }

    public static void main(String[]args){
        Person actualPerson = new Person("Naman", 22, "Male");
        System.out.println("Actual Person Details: ");
        actualPerson.displayPersonInfo();

        Person otherPerson = new Person(actualPerson);
        System.out.println("Other Person's Details: ");
        otherPerson.displayPersonInfo();

        otherPerson.name = "Rahul";
        System.out.println("After modifying the name of otherPerson: ");
        actualPerson.displayPersonInfo();
        otherPerson.displayPersonInfo();
    }



}
