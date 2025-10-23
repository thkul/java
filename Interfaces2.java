/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaces;

/**
 *
 * @author imtable
 */
public class Interfaces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        class Human { public void speak() { System.out.println("Hi"); } }
        class Robot { public void speak() { System.out.println("Beep"); } }

        Human h = new Human();
        Robot r = new Robot();
        Object[] arr = { h, r };
        
        for (Object speaker : arr) {
            if (speaker instanceof Human) {
                ((Human)speaker).speak();
            } else if (speaker instanceof Robot) {
                ((Robot)speaker).speak();
            }
        }
        
        // Interfaces
        interface Speaker { void speak2(); }
        class Human2 implements Speaker { public void speak2() { System.out.println("Hi2"); } }
        class Robot2 implements Speaker { public void speak2() { System.out.println("Beep2"); } }

        Speaker[] arr2 = { new Human2(), new Robot2() };

        for (Speaker s : arr2) {
            s.speak2();
        }
    }
    
}
