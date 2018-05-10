import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Use to create a sphere 3d object with
 * radius r at coordinates (x, y, z)
 */
public class ThreeDSphere extends ThreeDObject {

    private final double r;

    public ThreeDSphere(double x, double y, double z, double r) {
        super(x, y, z);
        this.r = r;
    }

    /**
     * Calculate the volume of a sphere
     * @return double volume
     */
    @Override
    double volume() {
        return Math.PI*r*r*r*4/3;
    }

    /**
     * Calculate the area of a sphere
     * @return double area
     */
    @Override
    double area() {
        return 4*Math.PI*r*4;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        return "Sphere with radius " + df.format(this.r) + " at ("+
                df.format(super.x) + ", " +
                df.format(super.y) + ", " +
                df.format(super.z) + ")";
    }
}