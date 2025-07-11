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
		if (!(array == null || array.length == 0 || leftIndex < 0 || rightIndex >= array.length || rightIndex < leftIndex)){

			int smallest = min(array, leftIndex, rightIndex);
			int greatest = max(array, leftIndex, rightIndex);
			int arrayLength = greatest - smallest + 1;

			// create counter
			Integer[] counter = new Integer[arrayLength];

			// populate the counter array
			for (int i = leftIndex; i <= rightIndex; i ++){      
				counter[array[i]] ++;
			}

			// accumulate the values in the array
			for (int i = 1; i < counter.length; i++){
				counter[i] += counter[i-1];                    
			}

			// create a new array
			Integer[] newArray = new Integer[array.length];

			// populate the new array
			for (int i = newArray.length -1; i > -1; i--){
				if (i < leftIndex || i > rightIndex){
					newArray[i] = array[i];
				} else {
					int position1 = array[i];                               
					int position2 = counter[position1] -1;
					newArray[position2 + leftIndex] = array[i];
					counter[position1]--;
				}
			}

		}
	}

	private int min(Integer[] array, int leftIndex, int rightIndex){
		int smallest = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++){
			if (array[i] < smallest){
				 smallest = array[i];
			}
		}
		return smallest;
	}

	private int max(Integer[] array, int leftIndex, int rightIndex){
		int greatest = array[leftIndex];
		for (int i = leftIndex; i <= rightIndex; i++){
			if (array[i] > greatest){
				 greatest = array[i];
			}
		}
		return greatest;
	}

}
