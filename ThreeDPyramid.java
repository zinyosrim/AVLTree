import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Use to create a pyramid 3d object with
 * length l, width w, height h at coordinates (x, y, z)
 */
public class ThreeDPyramid extends ThreeDObject {

    private final double l;

    private final double w;

    private final double h;

    public ThreeDPyramid(double x, double y, double z, double l, double w, double h) {
        super(x, y, z);
        this.l = l;
        this.w = w;
        this.h = h;
    }

    /**
     * Calculate the volume of a pyramid
     * @return double volume
     */
    @Override
    public double volume() {
        return l*w*h/3 ;
    }

    /**
     * Calculate the area of a pyramid
     * @return double area
     */@Override
    public double area() {
        double s1 = Math.sqrt( w*w/4 + h*h);
        double s2 = Math.sqrt( l*l/4 + h*h);
        return l*w + l*s1 + w*s2;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);
        return "Pyramid with base (" +  df.format(this.l) + ", " +  df.format(this.w) +
                ") and height " +  df.format(this.h) + " at (" +
                df.format(super.x) + ", " +
                df.format(super.y) + ", " +
                df.format(super.z) + ")";
    }
}

