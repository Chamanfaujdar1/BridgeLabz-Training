public class DataSerializationForBackup {
    static class UserData implements Serializable {
        int userId;
        String name;

        UserData(int userId, String name) {
            this.userId = userId;
            this.name = name;
        }
    }

    static class BackupService {

        static void backup(Object obj) {
            if (obj instanceof Serializable) {
                System.out.println("Object is eligible for backup");
            } else {
                System.out.println("Object NOT eligible for backup");
            }
        }
    }

    public static void main(String[] args) {
        UserData user = new UserData(1, "Alice");
        BackupService.backup(user);
    }
}
