package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS ELEMENTOS DE UM ARRAY
		if(array.length == 1) {
			result += array[-1];
			return result;
		} else {
			result += array[-1];
			for(int i = 0; i < array.length; i++) {
				array[i] = array[i+1];
				}
			calcularSomaArray(array);
			}
			return result;
	}
	public long calcularFatorial(int n) {
		long result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS
		if(n == 0) {
			return result;
		} else {
			return (n * calcularFatorial(n-1));
		}
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		int i = 1;
		int j = 2;
		if(n < 2) {
			return result;
		} else {
			return calcularFibonacci(n - i) + calcularFibonacci(n - j);
		}
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		if(array[0] == null) {
			return result;
		} else {
			if(array[0] != null) {
				result += 1;
				array[0] = array[1];
				countNotNull(array);
			}
		}
		return result;
	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		return result;
	}
	
	public static void main(String args[]) {
		MetodosRecursivos mr = new MetodosRecursivos();
		int[] arr = new int[]{1,2,3};
		int factorial = 5;
		int fibo = 3;
		Object[] notNull = new Object[]{1,2,3};
		System.out.println(mr.countNotNull(notNull));
	}
	
}
