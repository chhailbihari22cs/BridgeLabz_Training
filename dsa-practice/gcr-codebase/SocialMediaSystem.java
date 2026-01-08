import java.util.*;

// Friend node (Hum simplified version ke liye IDs store karenge)
class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // Har user ki apni friends list
    User next;

    User(int id, String name, int age) {
        this.userId = id;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialNetwork {
    User head = null;

    // 1. Add User to Platform
    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    // 2. Add Friend Connection (Both ways)
    public void makeFriends(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 != null && u2 != null) {
            if (!u1.friendIds.contains(id2)) {
                u1.friendIds.add(id2);
                u2.friendIds.add(id1);
                System.out.println(u1.name + " and " + u2.name + " are now friends!");
            }
        } else {
            System.out.println("User nahi mila!");
        }
    }

    // 3. Find User by ID (Helper Function)
    public User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // 4. Find Mutual Friends
    public void findMutualFriends(int id1, int id2) {
        User u1 = findUserById(id1);
        User u2 = findUserById(id2);

        if (u1 == null || u2 == null) return;

        System.out.print("Mutual Friends of " + u1.name + " & " + u2.name + ": ");
        boolean found = false;
        for (int fId1 : u1.friendIds) {
            if (u2.friendIds.contains(fId1)) {
                User mutual = findUserById(fId1);
                System.out.print(mutual.name + " ");
                found = true;
            }
        }
        if (!found) System.out.print("None");
        System.out.println();
    }

    // 5. Display Friends of a User
    public void displayFriends(int id) {
        User u = findUserById(id);
        if (u != null) {
            System.out.println(u.name + "'s Friends (Count: " + u.friendIds.size() + "):");
            for (int fId : u.friendIds) {
                User friend = findUserById(fId);
                System.out.println(" - " + friend.name);
            }
        }
    }
}

public class SocialMediaSystem {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        // Platform par users add karna
        network.addUser(1, "Rahul", 22);
        network.addUser(2, "Amit", 23);
        network.addUser(3, "Sneha", 21);
        network.addUser(4, "Priya", 22);

        // Connections banana
        network.makeFriends(1, 2); // Rahul - Amit
        network.makeFriends(1, 3); // Rahul - Sneha
        network.makeFriends(4, 2); // Priya - Amit
        network.makeFriends(4, 3); // Priya - Sneha

        // Rahul aur Priya ke mutual friends check karna (Amit & Sneha hone chahiye)
        network.findMutualFriends(1, 4);

        System.out.println();
        network.displayFriends(1);
    }
}

