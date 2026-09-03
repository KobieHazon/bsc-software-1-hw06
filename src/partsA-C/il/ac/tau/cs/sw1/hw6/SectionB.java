package il.ac.tau.cs.sw1.hw6;

public class SectionB {
    public static boolean contains(int[] array, int value) {
        if (array != null) {
            for (int element : array) {
                if (element == value) {
                    return true;
                }
            }
        }
        return false;
    }

    public static double[] roots(int[] array) {
        return new double[1];
    }

    public static int min(int[] array) {
        return array[0];
    }

    public static int min2(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static String reverse(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            builder.append(word.charAt(i));
        }
        return builder.toString();
    }
}
