/**
 * Created by ZY on 30.04.18.
 */
public class BodyTest {
    public static void main( String [] args ) {
        Cuboid c = new Cuboid(1,1,4,1,2,3);
        System.out.println(c);
        System.out.println("Volume: " +c.volume() + ", Area: " + c.area());

        Pyramid p = new Pyramid(1,1,4,1,2,3);
        System.out.println(p);
        System.out.println("Volume: " +p.volume() + ", Area: " + p.area());

        Cylinder cy = new Cylinder(4,5,1,2,3);
        System.out.println(cy);
        System.out.println("Volume: " +cy.volume() + ", Area: " + cy.area());

        Sphere s = new Sphere(4,1,2,3);
        System.out.println(s);
        System.out.println("Volume: " +s.volume() + ", Area: " + s.area());


    }
}
