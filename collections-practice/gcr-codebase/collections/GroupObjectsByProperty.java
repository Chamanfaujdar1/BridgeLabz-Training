// package collections_practice.collections;

import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class GroupObjectsByProperty {
	
	public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees) {
            map.putIfAbsent(e.department, new ArrayList<>());
            map.get(e.department).add(e);
        }

        return map;
    }

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        System.out.println(groupByDepartment(employees));
	}

}
