import java.util.Iterator;
import java.util.Comparator;


public class TestAVLTree {

    public static void main(String[] args){

        Comparator<String> myComparator = String::compareTo;
        AvlTreeMap<String, ThreeDObject> avlTreeMap = new AvlTreeMap<>(myComparator);

        avlTreeMap.put("earth", new ThreeDSphere(2,3,4,5));
        avlTreeMap.put("cubiq", new ThreeDCuboid(2,3,4,5,6,7));
        avlTreeMap.put("gizeh", new ThreeDPyramid(2,3,4,5,6,7));
        avlTreeMap.put("asia", new ThreeDCylinder(2,3,4,5,6));
        avlTreeMap.put("delhi", new ThreeDCylinder(2,3,4,5,6));
        avlTreeMap.put("lynda", new ThreeDCylinder(2,3,4,5,6));
        System.out.println(avlTreeMap);



/*
        for (ThreeDObject threeDObject : avlTreeMap){
            objectsString.append(threeDObject);

            if (avlTreeMap.iterator().hasNext()){
                objectsString.append(", ");
            }
        }*/


        avlTreeMap.put("bambi", new ThreeDCuboid(1,2,3,4,5,6));
        System.out.println(avlTreeMap);

    }
}