package CloningPrototypeObjects;

public class CloneTest {

    public static void main(String[] args) throws Exception {
        Prototype p1 = new Prototype();
        Prototype p2 = (Prototype) p1.clone();

        System.out.println(p1.value);
        System.out.println(p2.value);

    }

}