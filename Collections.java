import java.util.*;

public class Collections {
  public static void main(String[] args) {
    // ----- List -----
    List<String> list = new ArrayList<>();
    list.add("a"); // add element
    list.remove("a"); // remove by value
    list.set(0, "x"); // replace element
    System.out.println(list.get(0)); // access by index
    System.out.println(list.size()); // count elements

    // ----- Set -----
    // Unordered collection, no duplicates.
    Set<String> set = new HashSet<>();
    set.add("A"); set.add("B");
    set.add("A"); // ignored
    System.out.println(set.contains("B")); // check existence
    System.out.println(set.isEmpty()); // check empty

    // ----- Map -----
    // Key-value pairs, unique keys, fast lookup.
    Map<String, Integer> scores = new HashMap<>();
    scores.put("Alice", 90);
    scores.put("Bob", 75);
    System.out.println(scores.get("Alice")); // access
    scores.remove("Bob"); // delete
    System.out.println(scores.containsKey("Bob")); // false
    System.out.println(scores.size());

    for (String key : scores.keySet()) // iterate keys
      System.out.println(key);
    for (int value : scores.values()) // iterate values
      System.out.println(value);
    for (Map.Entry<String, Integer> e : scores.entrySet()) // both
      System.out.println(e.getKey() + ": " + e.getValue());

    // LinkedHashMap/LinkedHashSet is ordered Map/Set

    // ----- Queue (FIFO) -----
    Queue<String> queue = new LinkedList<>();
    queue.add("first"); // add to tail
    queue.offer("second"); // add if place exists (returns boolean)
    System.out.println(queue.peek()); // view head without removing
    System.out.println(queue.poll()); // remove head
    System.out.println(queue.isEmpty());
    System.out.println(queue.size());

    // ----- ArrayDeque -----
    // Double-ended queue, fast insert/remove at both ends. Using as Stack or Queue.
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addFirst("front");
    deque.addLast("back");
    System.out.println(deque.removeFirst()); // removeLast()
    System.out.println(deque.peek()); // head element

    // ----- Stack (LIFO) -----
    Stack<Integer> stack = new Stack<>();
    stack.push(10); // add to top
    System.out.println(stack.peek()); // view top
    System.out.println(stack.pop()); // remove top
    System.out.println(stack.empty());

    // ----- LinkedList -----
    // Doubly-linked list, fast insert/remove at ends, supports List and Queue interfaces
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("a"); // add to tail
    linkedList.addFirst("start"); // add to head
    linkedList.removeLast(); // remove tail
    System.out.println(linkedList.getFirst()); // view head
    System.out.println(linkedList.size());
    
    // ~~~~~~~~~~ features ~~~~~~~~~~
    // fixed-size structures backed by an array
    List<String> fixedList = Arrays.asList("A", "B", "C");
    Set<String> fixedSet = Set.of("A", "B", "C"); 
    Map<String, Integer> fixedMap = Map.of("A", 1, "B", 2); 
    // fixedList.add("D"); // UnsupportedOperationException (for any fixed)
    
    // mutable structures
    List<String> mutableList = new ArrayList<>(Arrays.asList("A", "B", "C"));
    Set<String> mutableSet = new HashSet<>(Arrays.asList("A", "B", "C"));
    Map<String, Integer> mutableMap = new HashMap<>(Map.of("A", 1, "B", 2));  
    mutableList.add("D"); // allowed
  
    // ----- Iterator (any Iterable) -----
    List<String> l = new ArrayList<>(Arrays.asList("first", "second", "third"));
    
    Iterator<String> itList = l.iterator(); // List iterator
    while(itList.hasNext()) {
      String s = itList.next();
      System.out.println(s);
      itList.remove(); // safe removal during iteration
    }
    
    Map<String, Integer> m = new HashMap<>();
    m.put("Alice",10); m.put("Bob",20);
    Iterator<String> itMap = m.keySet().iterator();
    while(itMap.hasNext()) {
      String key = itMap.next();
      System.out.println(key + ": " + m.get(key));
      itMap.remove();
    }

    // Optional
    // Wrapper for nullable values. Helps avoid NullPointerException.
    Optional<String> name = Optional.of("Alice");
    System.out.println(name.isPresent()); // true
    System.out.println(name.orElse("Unknown")); // Alice (if <name> is empty - "Unknown")

    // PriorityQueue
    // Elements are ordered by natural order or custom Comparator.
    Queue<Integer> pq = new PriorityQueue<>();
    pq.add(5);
    pq.add(1);
    System.out.println(pq.poll()); // 1 (returns smallest element)

    // ~~~~~~~~~~ advanced ~~~~~~~~~~
    // ----- TreeMap -----
    // Sorted key-value map (keys sorted naturally or by comparator).
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("b",2); treeMap.put("a",1);
    System.out.println(treeMap); // {a = 1, b = 2}
    System.out.println(treeMap.firstKey()); // smallest key
    System.out.println(treeMap.lastKey()); // largest key
  
    // ----- TreeSet -----
    // Sorted set (elements unique, automatically sorted).
    TreeSet<String> treeSet = new TreeSet<>();
    treeSet.add("b"); treeSet.add("a");
    System.out.println(treeSet); // [a, b, c]
    treeSet.remove("b");
    System.out.println(treeSet.contains("b")); // false
  }
}
