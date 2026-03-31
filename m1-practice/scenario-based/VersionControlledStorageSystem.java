import java.util.*;

class Version{
    String name;
    int size;
    int order;

    Version(String name, int size, int order){
        this.name = name;
        this.size = size;
        this.order = order;
    }
}

public class VersionControlledStorageSystem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Version>> storage = new HashMap<>();
        int uploadCounter = 0;

        for(int i=0; i<n; i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String operation = parts[0];
            if(operation.equals("UPLOAD")){
                String file = parts[1];
                String version = parts[2];
                int size = Integer.parseInt(parts[3]);

                storage.putIfAbsent(file, new ArrayList<>());

                boolean exists = false;
                for(Version v : storage.get(file)){
                    if(v.name.equals(version)){
                        exists = true;
                        break;
                    }
                }

                if(!exists){
                    storage.get(file).add(new Version(version, size, uploadCounter++));
                }
            }

            else if (operation.equals("FETCH")) {

                String file = parts[1];

                if (!storage.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                List<Version> list = new ArrayList<>(storage.get(file));

                list.sort((a, b) -> {
                    if (a.size != b.size)
                        return a.size - b.size;
                    return a.name.compareTo(b.name);
                });

                for (Version v : list) {
                    System.out.println(file + " " + v.name + " " + v.size);
                }

            } 
            else if (operation.equals("LATEST")) {

                String file = parts[1];

                if (!storage.containsKey(file) || storage.get(file).isEmpty()) {
                    System.out.println("File Not Found");
                    continue;
                }

                Version latest = null;

                for (Version v : storage.get(file)) {
                    if (latest == null || v.order > latest.order) {
                        latest = v;
                    }
                }

                System.out.println(file + " " + latest.name + " " + latest.size);

            } 
            else if (operation.equals("TOTAL_STORAGE")) {

                String file = parts[1];

                if (!storage.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                int total = 0;

                for (Version v : storage.get(file)) {
                    total += v.size;
                }

                System.out.println(file + " " + total);
            }
        }
    }
}
