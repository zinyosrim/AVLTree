/**
 * Use to create a cuboid 3d object with
 * length l, width w, height h at coordinates (x, y, z)
 */
public class Cuboid extends Body{

    private final double l;
    private final double w;
    private final double h;

    public Cuboid(double l, double w, double h, double x, double y, double z) {
        super(x, y, z);
        this.l = l;
        this.w = w;
        this.h = h;
    }

    @Override
    double volume() {
        return l*w*h;
    }

    @Override
    double area() {
        return 2 * (l*w + w*h + l*h);
    }

    @Override
    public String toString() {
        return "Cuboid with dimensions (" +
                this.l + ", " +
                this.w + ", " +
                this.h + ") at ( " +
                super.x + ", " +
                super.y + ", " +
                super.z + ")";
    }
}
