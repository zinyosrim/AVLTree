import java.util.Iterator;
import java.util.Comparator;


public class TestAVLTree {

    public static void main(String[] args){

        Comparator<String> myComparator = String::compareTo;
        AvlTreeMap<String, ThreeDObject> avlTreeMap = new AvlTreeMap<>(myComparator);

        /*avlTreeMap.put("earth", new ThreeDSphere(2,3,4,5));
        avlTreeMap.put("cubiq", new ThreeDCuboid(2,3,4,5,6,7));
        avlTreeMap.put("gizeh", new ThreeDPyramid(2,3,4,5,6,7));
        avlTreeMap.put("asia", new ThreeDCylinder(2,3,4,5,6));
        avlTreeMap.put("delhi", new ThreeDCylinder(2,3,4,5,6));
        avlTreeMap.put("lynda", new ThreeDCylinder(2,3,4,5,6));
        System.out.println(avlTreeMap);*/
/*
        avlTreeMap.put("c", new ThreeDCylinder(3,3,3,3,3));
        avlTreeMap.put("b", new ThreeDCylinder(2,2,2,2,2));
        avlTreeMap.put("d", new ThreeDCuboid(4,4,4,4,4,4));
        avlTreeMap.put("a", new ThreeDCuboid(1,1,1,1,1,1));
*/
        avlTreeMap.put("a0", new ThreeDSphere(0,0,0,0));
        avlTreeMap.put("a1", new ThreeDSphere(1,1,1,1));
        avlTreeMap.put("a1", new ThreeDSphere(2,2,2,2));


        StringBuilder objectsString = new StringBuilder();
        Iterator iterator = avlTreeMap.iterator();
        objectsString.append("[");

        if (!avlTreeMap.isEmpty()) {

            while (iterator.hasNext()) {
                objectsString.append(iterator.next());

                if (iterator.hasNext()) {
                    objectsString.append(", ");
                }
            }
        }
        objectsString.append("]\n");
        System.out.println(objectsString.toString());

        /*AvlNode<String, ThreeDObject> a0 = new AvlNode<>("a0", new ThreeDCuboid(0,0,0,0,0,0));
        AvlNode<String, ThreeDObject> a1 = new AvlNode<>("a1", new ThreeDCuboid(0,0,0,0,0,0));
        AvlNode<String, ThreeDObject> a2 = new AvlNode<>("a2", new ThreeDCuboid(0,0,0,0,0,0));

        avlTreeMap.put("a0 klein", new ThreeDCuboid(0,0,0,0,0,0));

        avlTreeMap.insert(avlTreeMap.getRoot(), a1);
        avlTreeMap.insert(avlTreeMap.getRoot(), a2);
        System.out.println(avlTreeMap.toString());*/
    }
}
