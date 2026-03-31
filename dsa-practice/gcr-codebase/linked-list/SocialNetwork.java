public class SocialNetwork {

    static class User {
        int id;
        String name;
        int[] friends = new int[10];
        int count = 0;
        User next;

        User(int i, String n) {
            id = i;
            name = n;
        }
    }

    User head;

    void addUser(int i, String n) {
        User u = new User(i, n);
        u.next = head;
        head = u;
    }

    void addFriend(int u1, int u2) {
        User a = find(u1), b = find(u2);
        if (a != null && b != null) {
            a.friends[a.count++] = u2;
            b.friends[b.count++] = u1;
        }
    }

    User find(int id) {
        User t = head;
        while (t != null) {
            if (t.id == id)
                return t;
            t = t.next;
        }
        return null;
    }
}