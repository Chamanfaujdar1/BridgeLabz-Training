class Parent {
    void s() {
        System.out.println("Animal");
    }
}

class Child extends Parent {
    @Override
    void s() {
        System.out.println("Dog");
    }
}

public class OverrideAnnotationTest {
    public static void main(String[] a) {
        Parent x = new Child();
        x.s();
    }
}