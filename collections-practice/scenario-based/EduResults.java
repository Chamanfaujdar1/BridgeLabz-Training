import java.util.*;

class Student {
    int id;
    String name;
    int score;
    String district;

    Student(int id, String name, int score, String district) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.district = district;
    }

    public String toString() {
        return name + " (" + district + ") -> " + score;
    }
}

public class EduResults {
    static List<Student> mergeTwoSortedLists(List<Student> a, List<Student> b) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            Student s1 = a.get(i);
            Student s2 = b.get(j);

            if (s1.score > s2.score) {
                merged.add(s1);
                i++;
            } else if (s1.score < s2.score) {
                merged.add(s2);
                j++;
            } else {
                merged.add(s1);
                i++;
            }
        }

        while (i < a.size()) merged.add(a.get(i++));
        while (j < b.size()) merged.add(b.get(j++));

        return merged;
    }

    static List<Student> mergeAllDistrictLists(List<List<Student>> districtLists) {
        if (districtLists.size() == 0) return new ArrayList<>();

        List<Student> result = districtLists.get(0);

        for (int i = 1; i < districtLists.size(); i++) {
            result = mergeTwoSortedLists(result, districtLists.get(i));
        }

        return result;
    }

    static void merge(List<Student> list, int left, int mid, int right) {
        List<Student> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            Student s1 = list.get(i);
            Student s2 = list.get(j);

            if (s1.score > s2.score) {
                temp.add(s1);
                i++;
            } else if (s1.score < s2.score) {
                temp.add(s2);
                j++;
            } else {
                temp.add(s1);
                i++;
            }
        }

        while (i <= mid) temp.add(list.get(i++));
        while (j <= right) temp.add(list.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            list.set(left + k, temp.get(k));
        }
    }

    static void mergeSort(List<Student> list, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    public static void main(String[] args) {
        List<Student> district1 = Arrays.asList(
                new Student(1, "Aman", 95, "D1"),
                new Student(2, "Neha", 90, "D1"),
                new Student(3, "Ravi", 85, "D1")
        );

        List<Student> district2 = Arrays.asList(
                new Student(4, "Sara", 96, "D2"),
                new Student(5, "Karan", 90, "D2"),
                new Student(6, "Mira", 80, "D2")
        );

        List<Student> district3 = Arrays.asList(
                new Student(7, "Rohan", 97, "D3"),
                new Student(8, "Pooja", 88, "D3"),
                new Student(9, "Vikas", 85, "D3")
        );

        List<List<Student>> districtLists = new ArrayList<>();
        districtLists.add(new ArrayList<>(district1));
        districtLists.add(new ArrayList<>(district2));
        districtLists.add(new ArrayList<>(district3));

        List<Student> merged = mergeAllDistrictLists(districtLists);

        mergeSort(merged, 0, merged.size() - 1);

        System.out.println("Final State-wise Rank List:");
        for (int i = 0; i < merged.size(); i++) {
            System.out.println((i + 1) + ". " + merged.get(i));
        }
    }
}
