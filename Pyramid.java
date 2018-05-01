/**
 * Use to create a pyramid 3d object with
 * length l, width w, height h at coordinates (x, y, z)
 */
public class Pyramid extends Body{

    private final double l;
    private final double w;
    private final double h;

    public Pyramid(double l, double w, double h, double x, double y, double z) {
        super(x, y, z);
        this.l = l;
        this.w = w;
        this.h = h;
    }

    @Override
    double volume() {
        return l*w*h/3 ;
    }

    @Override
    double area() {

        double s1 = Math.sqrt( w*w/4 + h*h);
        double s2 = Math.sqrt( l*l/4 + h*h);
        return l*w + l*s1 + w*s2;
    }

    @Override
    public String toString() {
        return "Pyramid with base (" + this.l + ", " + this.w +
                ") and height " + this.h + " at (" +
                super.x + ", " +
                super.y + ", " +
                super.z + ")";
    }
}

