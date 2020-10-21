package by.odinets.codewars.simpleNumberSequence;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {

	public static int numberSearch = -1;
	
	public static int missing(String s){
	
		int lengthStr = s.length();
		boolean isSequence = false;
		for(int i = 1; i <= lengthStr; i++) {
			//System.out.println("********************************************");
			if(!isSequence) {
				//System.out.println("i :: " + i);
				boolean isSequenceStep = (lengthStr >= i*2);
				if(isSequenceStep) {
					String[] strNumb = cutString(s, i);
					System.out.println("strNumb :: " + Arrays.toString(strNumb));
					isSequence = checkIsSequence(strNumb);
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
	public static String[] cutString(String str, int numbDigits) {
		ArrayList<String> arrNumbers = new ArrayList<String>();
		int indexLetter = 0;
		boolean flagIsNextRank = false;
		while(indexLetter + numbDigits <= str.length()) {
			String number = str.substring(indexLetter, indexLetter + numbDigits);
			arrNumbers.add(number);
			indexLetter = indexLetter + numbDigits;
			if(!flagIsNextRank) {
				if(isNextRank(number)) {
					numbDigits++;
					flagIsNextRank = true;
				}
			}
		}
		
		String[] result = null;
		if(!arrNumbers.isEmpty()) {
			result = new String[arrNumbers.size()];
			for(int i = 0; i < arrNumbers.size(); i++) {
				result[i] = arrNumbers.get(i);
			}
		}
		return result;
	}
	
	/**
	 * метод проверяет будет ли число последним в данном ранге, т.е. 99 -> 100, 9999 -> 10000
	 * @param number
	 * @return
	 */
	public static boolean isNextRank(String number) {
		boolean result = false;
		char[] test  = number.toCharArray();
		for(int i = 0; i < test.length; i++) {
			if(test[i] != '9') {
				return result;
			}
	    } 
		result = true;
		return result;
	}
	
	/**
	 * метод проверяет является ли массив чисел - последовательностью, есть ли недостающий элемент
	 * @param numbers
	 * @return
	 */
	public static boolean checkIsSequence(String[] numbers) {
		boolean isSequence = false;	
		boolean flagMissingNumber = false;
		numberSearch = -1;
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
	public static int searchNumbMissing(String numb1, String numb2) {
		int lengthN1 = numb1.length();
		int lengthN2 = numb2.length();
		String lastNumb1 = numb1.substring(lengthN1 - 1, lengthN1);
		String lastNumb2;
		if(isNextRank(numb1)) {
			lastNumb1 = numb1;
			if(lengthN2 == 1) {
				return 0;
			}
			lastNumb2 = numb2;
		} else {
			if(isNextRank(lastNumb1)) {
				if(lengthN1 > 1) {
					lastNumb1 = numb1.substring(lengthN1 - 2, lengthN1);
				}
				if(lengthN2 == 1) {
					return 0;
				}
				lastNumb2 = numb2.substring(lengthN2 - 2, lengthN2);
			} else {
				lastNumb2 = numb2.substring(lengthN2 - 1, lengthN2);
			}
			
		}
			
		System.out.println("lastNumb1 :: " + lastNumb1);
		System.out.println("lastNumb2 :: " + lastNumb2);
		
		if(isNextRank(lastNumb1)) {
			String strEquals = "1";
			String strNextEquals = "1";
			for(int i = 1; i <= lastNumb1.length(); i++) {
				strEquals += "0";
				if(i < lastNumb1.length()) {
					strNextEquals += "0";
				} else {
					strNextEquals += "1";
				}
				
			}
			if(lastNumb2.equals(strEquals)) {
				System.out.println("sequence :: " + lastNumb1 + " , " + lastNumb2);
				return 1;
			}
			if(lastNumb2.equals(strNextEquals)) {
				System.out.println("sequence :: " + lastNumb1 + " , " + lastNumb2);
				return 1;
			}
		} else {
			
		}
		/*if(numb2 - numb1 == 1) {
			return 1;
		}
		if(numb2 - numb1 == 2) {
			return ++numb1;
		}*/
		return 0;
	}
}
