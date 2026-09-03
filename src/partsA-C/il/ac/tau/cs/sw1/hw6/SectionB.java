package il.ac.tau.cs.sw1.hw6;

public class SectionB {
	
	/*
	* @post $ret == true iff exists i such that array[i] == value
	*/
	public static boolean contains(int[] array, int value) { 
		if (array != null && array.length != 0) {
			for (int var : array ) {
				if (var == value) {
					return true;
				}
			}
		}
		return false;
	}
	/*
	* @pre array != null
	* @pre array.length > 0 and array.length <= 2
	* @post for all j=0,..$ret.length: sum(i= 0...array.length-1): $ret[j]*array[i] = 0
	*/
	public static double[] roots(int[] array) { 
		return new double[1];
	}
	/*
	* @pre Arrays.equals(array, Arrays.sort(array))
	* @pre array.length >= 1
	* @post for all i array[i] >= $ret
	*/
	public static int min(int[] array) { 
		return array[0];
	}
	
	/*
	* @pre array.length >=1
	* @post for all i array[i] >= $ret
	* @post Arrays.equals(array, prev(array))
	*/
	public static int min2(int[] array) { 
		int min = array[0];
		for (int value: array) {
			if (value > min) {
				min = value;
			}
		}
		return min;
	}
	
	/*
	* @pre word.length() >=1
	* @post for all i : $ret.charAt(i) == word.charAt(word.length() - i - 1)

	*/
	public static String reverse(String word) 
	{
		StringBuffer sbuffer = new StringBuffer("");
		for (int i=word.length()-1; i>=0; i--) {
			sbuffer.append(word.charAt(i));
		}
		String s = sbuffer.toString();
		return s;
	}


}
