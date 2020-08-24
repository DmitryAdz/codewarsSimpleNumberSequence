
package by.odinets.codewars.simpleNumberSequence;

import java.util.Arrays;

/*
* In this Kata, you will be given a string of numbers in sequence and your task will be to return the missing number. 
* If there is no number missing or there is an error in the sequence, return -1.
* For example:
*
*missing("123567") = 4 
*missing("899091939495") = 92
*missing("9899101102") = 100
*missing("599600601602") = -1 -- no number missing
*missing("8990919395") = -1 -- error in sequence. Both 92 and 94 missing.
*
*The sequence will always be in ascending order.
*
*More examples in the test cases.
*
*Good luck!
*/

public class Solution {

	public static int numberSearch = -1;
	
	public static int missing(String s){
	
		int lengthStr = s.length();
		boolean isSequence = false;
		for(int i = 1; i <= lengthStr; i++) {
			//System.out.println("********************************************");
			if(!isSequence) {
				boolean isSequenceStep = (lengthStr >= i*2) && (lengthStr%i == 0);
				if(isSequenceStep) {
					Integer[] numbers = cutString(s, i);
					isSequence = checkIsSequence(numbers);
				}
			} else {
				break;
			}
		}
				
		return numberSearch;
	}

	/**
	 * метод режет строку (str) на подстроки по количеству (numbDigits) указанных символов 
	 * @param str
	 * @param numbDigits
	 * @return
	 */
	public static Integer[] cutString(String str, int numbDigits) {
		int lengthStr = str.length();
		int arrSize = lengthStr;
		if(numbDigits > 1) {
			arrSize = lengthStr / numbDigits;
		}
		Integer[] result = new Integer[arrSize];
		int indexLetter = 0;
		for(int i = 0; i < arrSize; i++) {
			result[i] = Integer.parseInt(str.substring(indexLetter, indexLetter + numbDigits)); 
			indexLetter = indexLetter + numbDigits;
		}
		
		//System.out.println("result :: " + Arrays.toString(result));
		return result;
	}
	
	/**
	 * метод проверяет является ли массив чисел - последовательностью, есть ли недостающий элемент
	 * @param numbers
	 * @return
	 */
	public static boolean checkIsSequence(Integer[] numbers) {
		boolean isSequence = false;	
		boolean flagMissingNumber = false;
		for(int i = 0; i < numbers.length-1; i++) {
			//System.out.println(" numbers :: " + numbers[i] + " - " + numbers[i+1]);
			int numbX = searchNumbMissing(numbers[i], numbers[i+1]);
			//System.out.println(" numbX :: " + numbX);
			if(numbX == 0) {
				isSequence = false;
				break;
			}
			if(numbX == 1) {
				isSequence = true;
			}
			if(numbX > 1) {
				if(!flagMissingNumber) {
					numberSearch = numbX;
					flagMissingNumber = true;
					isSequence = true;
				} else {
					numberSearch = -1;
					isSequence = false;
					break;
				}
			}
		}
		//System.out.println("numberSearch :: " + numberSearch);
		//System.out.println("isSequence :: " + isSequence);
		return isSequence;
	}

	/**
	 * метод определяет разность двух чисел
	 * @param numb1
	 * @param numb2
	 * @return 1 - числа идут последовательно, numb1+1 - между числами пропущено число numb1+1,  исключение предыдущих вариантов
	 */
	public static int searchNumbMissing(int numb1, int numb2) {
		if(numb2 - numb1 == 1) {
			return 1;
		}
		if(numb2 - numb1 == 2) {
			return ++numb1;
		}
		return 0;
	}
}