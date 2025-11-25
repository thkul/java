public class Interfaces {
    public static void main(String[] args) {
        class Human { public void speak() { System.out.println("Hi"); } }
        class Robot { public void speak() { System.out.println("Beep"); } }

        Human h = new Human();
        Robot r = new Robot();
        Object[] speakers = { h, r };
        
        for (Object s : speakers) {
            if (s instanceof Human) {
                ((Human)s).speak();
            } else if (s instanceof Robot) {
                ((Robot)s).speak();
            }
        }
        
        interface Speaker { void speak2(); }
        class Human2 implements Speaker { public void speak2() { System.out.println("Hi2"); } }
        class Robot2 implements Speaker { public void speak2() { System.out.println("Beep2"); } }

        Speaker[] speakers2 = { new Human2(), new Robot2() };

        for (Speaker s : speakers2) {
            s.speak2();
        }
    }  
}
