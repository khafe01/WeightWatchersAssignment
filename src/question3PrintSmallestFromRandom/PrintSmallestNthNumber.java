package question3PrintSmallestFromRandom;
import java.util.Arrays;
import java.util.Random;

public class PrintSmallestNthNumber {

    public static void main(String[]args){
        System.out.println(findNthSmallest(5));
    }


    public static int findNthSmallest(int n){
        Random random = new Random();
        int[] randomArray = new int[500];

        for(int i=0; i<500; i++){
            randomArray[i] = random.nextInt(3000)+1;
        }
        Arrays.sort(randomArray);
        return randomArray[n-1];

    }
}