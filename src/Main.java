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

        DisplayMapResults(new NumberMapping(false), FindMod(numberSet1, 37,false),"basic-mod1");
        DisplayMapResults(new NumberMapping(true), FindMod(numberSet2, 41, true),"basic-mod2");
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

    // Finds the remainder or the inverse mod of a given number set and divisor.
    private static int[] FindMod(ArrayList<Integer> arrayList, int divisor, boolean inverse){
        int[] modList = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++){
            if(inverse){
                modList[i] = calculateModInverse(arrayList.get(i), divisor);
            } else modList[i] = arrayList.get(i) % divisor;
        }
        return modList;
    }
    
    private static int calculateModInverse(int a, int b){
        a = a % b;
        for (int x = 1; x < b; x++){
            if((a * x) % b == 1) return x;
        }
        return 1;
    }
}
