public class Circulo implements Forma{
    private double raio;

    public Circulo (double raio) {
        super();
        this.raio = raio;
    }

    public double area() {
        double result = Math.PI * raio * raio;
        
        return result;
    }
}
