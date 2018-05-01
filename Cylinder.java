/**
 * Use to create a cylinder 3d object with
 * radius r, height h at coordinates (x, y, z)
 */
public class Cylinder extends Body{

    private final double r;
    private final double h;

    public Cylinder(double r, double h, double x, double y, double z) {
        super(x, y, z);
        this.r = r;
        this.h = h;
    }

    @Override
    double volume() {
        return Math.PI*r*r*h;
    }

    @Override
    double area() {
        return 2*Math.PI*r*h;
    }

    @Override
    public String toString() {
        return "Cylinder with radius " + this.r + ", and height "+ this.h +
                " at ( "+
                super.x + ", " +
                super.y + ", " +
                super.z + ")";
    }
}