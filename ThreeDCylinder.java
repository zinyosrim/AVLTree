import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Use to create a cylinder 3d object with
 * radius r, height h at coordinates (x, y, z)
 */
public class ThreeDCylinder extends ThreeDObject {

    private final double r;

    private final double h;

    public ThreeDCylinder(double x, double y, double z, double r, double h) {
        super(x, y, z);
        this.r = r;
        this.h = h;
    }

    /**
     * Calculate the volume of a cylinder
     * @return double volume
     */
    @Override
    double volume() {
        return Math.PI*r*r*h;
    }

    /**
     * Calculate the area of a cylinder
     * @return double cylinder
     */
    @Override
    double area() {
        return 2*Math.PI*r*h;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        return "Cylinder with radius " + df.format(this.r) + " and height "+ df.format(this.h) +
                " at ("+
                df.format(super.x) + ", " +
                df.format(super.y) + ", " +
                df.format(super.z) + ")";
    }
}