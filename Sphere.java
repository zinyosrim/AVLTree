/**
 * Use to create a sphere 3d object with
 * radius r at coordinates (x, y, z)
 */
public class Sphere extends Body{

    private final double r;

    public Sphere(double r, double x, double y, double z) {
        super(x, y, z);
        this.r = r;
    }

    @Override
    double volume() {
        return Math.PI*r*r*r*4/3;
    }

    @Override
    double area() {
        return 4*Math.PI*r*4;
    }

    @Override
    public String toString() {
        return "Sphere with radius " + this.r + " at ( "+
                super.x + ", " +
                super.y + ", " +
                super.z + ")";
    }
}