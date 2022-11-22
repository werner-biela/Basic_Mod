import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String file = "others//message.txt";
        ArrayList<Integer> numbers = new ArrayList<>();
        NumberMapping convert = new NumberMapping();
        
        /* 
        * Read the data from the text file and parse it into an array of integers
        * to be processed. 
        */
        try{
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String[] data = myReader.nextLine().split(" ");
                for (String datum : data) {
                    numbers.add(Integer.parseInt(datum));
                }
            }
            myReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        /*
        * Find out the mod37 of each number in the Integer ArrayList,
        * and map out the results to their given character to be
        * displayed on console.
        */
        int[] modResults = FindModOf(numbers);
        System.out.print("Flag: picoCTF{");
        for (int i = 0; i < numbers.size(); i++){
            System.out.print(convert.MapTo(modResults[i]));
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
}