/**
 *   Sam Pixel York
 *   #11719416
 *   25 SEP 2021
 *
 *   ITC206: Programming in Java 2
 *   Assessment 1: Programming Tasks
 *
 *   Task 2: Octagon
 *   Create a couple of octagon objects and
 *   demonstrate the clone and compare methods
 */
public class TestOctagon {
    public static void main(String[] args) {
        Octagon octagon = new Octagon(5);
        Octagon cloneOctagon = (Octagon) octagon.clone();
        //System.out.println(octagon.equals(cloneOctagon)); //quick check that the clone worked
        displayOctagon(octagon);
        displayOctagon(cloneOctagon);
        compareOctagon(octagon, cloneOctagon);
    }

    /*  standard output of the area and perimeter results
     */
    public static void displayOctagon(GeometricObject octagon) {
        System.out.println("\nArea is: " + octagon.getArea());
        System.out.println("Perimeter is: " + octagon.getPerimeter());
    }

    /*  I wanted a nice printout of the compareTo method results
     */
    public static void compareOctagon(Octagon octagon, Octagon cloneOctagon) {
        System.out.println("\nCompare the area of the two octagon objects");
        System.out.println("-------------------------------------------");
        switch (octagon.compareTo(cloneOctagon)) {
            case -1 -> System.out.println("First octagon has a larger area");
            case 1 -> System.out.println("Second octagon has a larger area");
            case 0 -> System.out.println("Both octagons have the same area");
        }

    }

}
