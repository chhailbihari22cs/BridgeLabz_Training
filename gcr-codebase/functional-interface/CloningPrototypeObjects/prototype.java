package CloningPrototypeObjects;

public class Prototype implements Cloneable {
    int value = 10;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}