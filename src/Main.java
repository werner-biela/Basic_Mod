import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String file1 = "others//message1.txt";
        String file2 = "others//message2.txt";
        ArrayList<Integer> numberSet1;
        ArrayList<Integer> numberSet2;

        numberSet1 = ReadFileToArray(file1);
        numberSet2 = ReadFileToArray(file2);

        FindModResults(new NumberMapping(false), FindModOf(numberSet1),"basic-mod1");
        FindModResults(new NumberMapping(true), FindModInverseOf(numberSet2),"basic-mod2");
        System.out.println();
    }
    private static ArrayList<Integer> ReadFileToArray(String file){
        /*
         * Read the data from the text file and parse it into an array of integers
         * to be processed.
         */
        ArrayList<Integer> collectedNumbers = new ArrayList<>();
        try{
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String[] data = myReader.nextLine().split(" ");
                for (String datum : data) {
                    collectedNumbers.add(Integer.parseInt(datum));
                }
            }
            myReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return collectedNumbers;
    }

    private static void FindModResults(NumberMapping convert, int[] numbers, String PicoCTF_challenge){
        /*
         * Maps out the results to their given character to be
         * displayed on console.
         */
        System.out.print("\n" + PicoCTF_challenge.toUpperCase() + " Flag: picoCTF{");
        for (int number : numbers) {
            System.out.print(convert.MapTo(number));
        }
        System.out.print("}");
    }

    // Method that finds out the mod37 of the numbers in a given Integer ArrayList
    private static int[] FindModOf(ArrayList<Integer> array) {
        int[] modList = new int[array.size()];
        for(int i = 0; i< array.size(); i++) {
            modList[i] = array.get(i) % 37;
        }
        return modList;
    }

    private static int[] FindModInverseOf(ArrayList<Integer> array){
        int[] modInverseList = new int[array.size()];
        for (int i = 0; i < array.size(); i++){
            modInverseList[i] = calModInv(array.get(i), 41 );
        }
        return modInverseList;
    }

    private static int calModInv(int a, int b){
        a = a % b;
        for (int x = 1; x < b; x++){
            if((a*x)%b == 1){
                return x;
            }
        }
        return 1;
    }
}