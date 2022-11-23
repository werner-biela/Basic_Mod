import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // << Fields >>
    private static final String file1 = "others//message1.txt";
    private static final String file2 = "others//message2.txt";

    public static void main(String[] args) {

        ArrayList<Integer> numberSet1 = ReadFileToArray(file1);
        ArrayList<Integer> numberSet2 = ReadFileToArray(file2);

        DisplayMapResults(new NumberMapping(false), FindModOf(numberSet1),"basic-mod1");
        DisplayMapResults(new NumberMapping(true), FindModInverseOf(numberSet2),"basic-mod2");
        System.out.println();
    }

    // << Methods >>

    //Reads the data from the text file and parse it into an array of integers to be processed.
    private static ArrayList<Integer> ReadFileToArray(String file){
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

    // Maps out the results to their given character to be displayed on console.
    private static void DisplayMapResults(NumberMapping convert, int[] numbers, String PicoCTF_challenge){
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

    /*
     * Method that finds out the inverse mod41 of the numbers
     * in a given Integer ArrayList using calculateModInverse().
     */
    private static int[] FindModInverseOf(ArrayList<Integer> array){
        int[] modInverseList = new int[array.size()];
        for (int i = 0; i < array.size(); i++){
            modInverseList[i] = calculateModInverse(array.get(i), 41 );
        }
        return modInverseList;
    }

    @SuppressWarnings("SameParameterValue")
    private static int calculateModInverse(int a, int b){
        a = a % b;
        for (int x = 1; x < b; x++){
            if((a * x) % b == 1) return x;
        }
        return 1;
    }
}
