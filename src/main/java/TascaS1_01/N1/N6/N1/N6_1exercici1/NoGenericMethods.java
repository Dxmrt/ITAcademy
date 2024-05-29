package TascaS1_01.N1.N6.N1.N6_1exercici1;

public class NoGenericMethods {

    private Object[] objects;

    public NoGenericMethods(String obj1, String obj2, String obj3) {
        objects = new Object[]{obj1, obj2, obj3};
    }

    public Object getObject(int index) {
        return objects[index];
    }
}

