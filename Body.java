/**
 * Abstract class for 3D objects. Use to create geometric 3d objects
 */
public abstract class Body {
    final double x;
    final double y;
    final double z;

    Body(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    /**
     *
     * @return volume of a 3d object
     */
    abstract double volume();

    /**
     *
     * @return area of a 3d object
     */
    abstract double area();

    @Override
    public String toString() {
        return ("(" + this.x + ", " + this.y + ", " + this.z + ")");
    }
}
