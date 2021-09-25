public class TestOctagon {
    public static void main(String[] args) {
        GeometricObject octagon = new Octagon(5);

        displayOctagon(octagon);
    }

    public static void displayOctagon(GeometricObject octagon) {
        System.out.println("Area is: " + octagon.getArea());
        System.out.println("Perimeter is: " + octagon.getPerimeter());
    }
}
