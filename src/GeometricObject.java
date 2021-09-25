/*  copied this class from the requirements, did not
    copy the comments as this is a provided class and
    no input from myself has been added
 */
public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;

    protected GeometricObject(){}

    protected GeometricObject (String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

}
