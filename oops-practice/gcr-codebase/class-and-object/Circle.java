class Circle {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void displayResult() {
        System.out.printf("Area of circle: %.4f\n", Math.PI * radius * radius);
        System.out.printf("Circumference of circle: %.4f\n", 2 * Math.PI * radius);
    }

    public static void main(String[] args) {
        new Circle(2.5).displayResult();
    }
}
