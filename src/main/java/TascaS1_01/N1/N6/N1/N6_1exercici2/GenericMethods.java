package TascaS1_01.N1.N6.N1.N6_1exercici2;

public class GenericMethods {
    public static <T, S, U> void printArgs(T arg1, S arg2, U arg3) {
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
    }
}