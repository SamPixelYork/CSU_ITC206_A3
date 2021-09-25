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
public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>{
    /*  standard class with my setters and getters
        task states we can assume the octagon has equal sides
        so we only have one variable for the sides
     */
    private double side;

    /*  easy peasy no args constructor
     */
    public Octagon() {}

    /* standard constructor
     */
    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    /*  decided to use a shallow clone copy
        as it works and did not want to change
        it further
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /*  creating my compare to method to compare
        the area of the octagons
     */
    public int compareTo(Octagon object) {
        return Double.compare(getArea(), object.getArea());
    }
}
