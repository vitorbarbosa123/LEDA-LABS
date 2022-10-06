public class Retangulo implements Forma {
    private double base;
    private double altura;

    public Retangulo (doube base, double altura) {
        super();
        this.base = base;
        this.altura = altura;
    }

    public double area() {
        double result = base * altura;
        return result;
    }
}
