import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Use to create a cuboid 3d object with
 * length l, width w, height h at coordinates (x, y, z)
 */
public class ThreeDCuboid extends ThreeDObject {

    private final double l;

    private final double w;

    private final double h;

    public ThreeDCuboid(double x, double y, double z, double l, double w, double h) {
        super(x, y, z);
        this.l = l;
        this.w = w;
        this.h = h;
    }

    /**
     * Calculate the volume of a cuboid
     * @return double volume
     */
    @Override
    double volume() {
        return l*w*h;
    }

    /**
     * Calculate the area of a cuboid
     * @return double area
     */
    @Override
    double area() {
        return 2 * (l*w + w*h + l*h);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        return "Cuboid with dimensions (" +
                df.format(this.l) + ", " +
                df.format(this.w) + ", " +
                df.format(this.h) + ") at (" +
                df.format(super.x) + ", " +
                df.format(super.y) + ", " +
                df.format(super.z) + ")";
    }
}
