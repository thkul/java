import java.util.*;

public class Other {
  public static void main(String[] args) {
    // The User class implements Comparable, defining how to compare instances of
    // User
    class User implements Comparable<User> {
      String name;
      int age;

      // Constructor to initialize name and age
      public User(String name, int age) {
        this.name = name;
        this.age = age;
      }

      // 1️⃣ Implementation of the compareTo method from Comparable
      // We compare by age (you could change this to any other property)
      public int compareTo(User other) {
        return this.age - other.age; // If this.age < other.age, the result will be negative
      }

      // Method to display the User object as a string (for pretty printing)
      public String toString() {
        return name + " (" + age + ")";
      }
    }

    // Creating a list of users
    List<User> users = new ArrayList<>();
    users.add(new User("Alice", 25)); // Age 25
    users.add(new User("Charlie", 20)); // Age 20
    users.add(new User("Bob", 30)); // Age 30

    // 2️⃣ Sorting the list by natural order (by age)
    // This uses the compareTo method we implemented in the User class
    Collections.sort(users);
    System.out.println(users); // Prints the list of users sorted by age in ascending order

    // 3️⃣ Sorting the list by another criterion (by name)
    // Using a Comparator to sort users by their name
    users.sort(Comparator.comparing(u -> u.name));
    System.out.println(users); // Prints the list of users sorted by name in alphabetical order
  }
}
