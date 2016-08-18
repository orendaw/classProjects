package test;

import java.util.ArrayList;

public class MyProgram {
    public static void foo1(ArrayList arrString) {
        arrString = new ArrayList();
        arrString.add("A");
        arrString.add("B");
        foo2(arrString);
    }
    public static void foo2(ArrayList arrString) {
        arrString.add("dog");
        arrString.add("cat");
        if(arrString.size() < 4)
            foo1(arrString);
    }
    public static void main(String[] args) {
        ArrayList arrStringA = new ArrayList();
        ArrayList arrStringB = new ArrayList();
        foo1(arrStringA);
        foo2(arrStringB);
        System.out.println(arrStringA.size() + " / " + arrStringB.size());
        System.out.println(arrStringB.get(1));
    }
}
