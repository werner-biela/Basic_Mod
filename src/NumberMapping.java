import java.util.HashMap;

public class NumberMapping {

    private static final HashMap<Integer, Character> numberMapping = new HashMap<>();

    public NumberMapping(boolean altSet) {
        if (altSet){
            int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37};
            char[] chars = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','_'};
            for(int i = 0; i < numbers.length; i++){
                numberMapping.put(numbers[i], chars[i]);
            }
        }
        else {
            int[] numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
            char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_'};
            for (int i = 0; i < numbers.length; i++) {
                numberMapping.put(numbers[i], chars[i]);
            }
        }
    }

    public char MapTo(int number){
        return numberMapping.get(number);
    }
}
