package recursao;

import java.util.Arrays;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS ELEMENTOS DE UM ARRAY
		
		int result = 0;
		int[] newArr = new int[array.length - 1];
		if(array.length == 1) {
			result = array[0];
		} else {
			array[0] = array[0] + array[array.length -1];	
			for(int i = 0; i < array.length - 1; i++) {
				newArr[i] = array[i];
			}
			return calcularSomaArray(newArr);
		}
		return result;
	}
	public long calcularFatorial(int n) {
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O FATORIAL DO PARAMETRO
		// DE ACORDO COM O QUE FOI MOSTRADO NO EXERCCICIO. OBSERVE QUE SENDO O
		// METODO
		// RECURSIVO, O FATORIAL DOS NUMEROS ANTERIORES TAMBEM VAO SER IMPRESSOS

		long result = 1;
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
			return n;
		} else {
			return calcularFibonacci(n - i) + calcularFibonacci(n - j);
		}
	}



	public int countNotNull(Object[] array) {
		int result = 0;
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		Object[] newArr = new Object[array.length - 1];

		if(array.length == 1) {
			return result;
		}

		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				array[i] = array[array.length - 1];	
				array[array.length - 1] = null;				
			}
		}

		for(int j = 0; j < array.length - 1; j++) {
			newArr[j] = array[j];
		}

		for(int k = 0; k < array.length; k++) {
			if(array[k] != null) {
				result += 1;
			} 
		}

		if(result != 0) {
			return result;
		} else {
			return countNotNull(newArr);
		}
	}

	public long potenciaDe2(int expoente) {
		long result = 2;

		if(expoente == 0 ) {
			return result = 1;
		}
		else if(expoente == 1) {
			return result;
		} else {
			return result * potenciaDe2(expoente - 1);
		}
		// TODO IMPLEMENTE (USANDO RECURSAO) O CODIGO PARA PRODUZIR A N-ESIMA
		// POTENCIA
		// DE 2
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		
		if(n == 1) {
			return result;
		} else {
			return progressaoAritmetica( termoInicial + razao, razao, n - 1);
		}


		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		double result = termoInicial;

		if(n == 1) {
			return result;
		} else {
			return progressaoGeometrica( termoInicial * razao, razao, n - 1);
		}
	}
	
	public static void main(String args[]) {
		MetodosRecursivos mr = new MetodosRecursivos();
		int[] arr = new int[]{1,2,3,4,5};
		int factorial = 10;
		int fibo = 20;
		int potencia = 1;
		Object[] notNull = new Object[]{1,null,1,1};
		double termoInicial = 3;
		double razao = 4;
		int n = 5;
		System.out.println(mr.countNotNull(notNull));
	}
	
}
