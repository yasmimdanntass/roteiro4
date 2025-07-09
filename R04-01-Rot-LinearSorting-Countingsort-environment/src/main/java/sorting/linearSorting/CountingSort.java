package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int maxNum = array[leftIndex]; // escolhendo o maior número 

		for (int i = leftIndex; i <= rightIndex; i++){
			if (array[i] > maxNum){
				maxNum = array[i];
			}
		}

		//criando o contador

		int[] counter = new int[maxNum];

		//preenchendo o contador
		for (int i = leftIndex; i <= rightIndex; i++){
			counter[array[i]-1] ++;
		}

		//fazendo a soma acumulativa
		for (int i = 1; i < counter.length; i++){
			counter[array[i]-1] ++;
		}

		
	}

}
