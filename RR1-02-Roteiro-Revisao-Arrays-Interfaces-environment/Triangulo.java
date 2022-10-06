public class Triangulo implements Forma {
    private double altura;
    private double base;

    public Triangulo (double altura, double base) {
        super();
        this.altura = altura;
        this.base = base;
    }

    public double area() {
        double result = ( base * altura ) / altura;

        return result;
    }
}
