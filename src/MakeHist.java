/**
 * Created by Вадик on 09.11.2015.
 */
public class MakeHist {
    public static void main(String[] args) {
        int numValues = 5;
        int[] array = randomArray(numValues);
        selectionSort(array);
        printArray(array);
 //       printArray(makeHist(array));
 //       System.out.println(areFactors(3, array));
 //       System.out.println(firstAppear(2, array));

        System.out.println(max(array));
    }



    public static int[] makeHist(int[] scores) {
        int[] counts = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            int index = scores[i];
            counts[index]++;
        }
        return counts;
    }

    public static int[] randomArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i<a.length; i++) {
            a[i] = randomInt(0, 100);
        }
        return a;
    }

    public static int randomInt(int low, int high){
        return (int) (low + Math.random()*(high-low));

    }

    public static void printArray(int[] a) {
        for (int i = 0; i<a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static boolean areFactors(int n, int[] arr){
        int i=0;
        while( i<arr.length){
            if((arr[i]%n) != 0){
                return false;
            }
            i++;
          }
        return true;

        }

    public static int firstAppear(int n, int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] == n){
                return i;
            }
        }
        return -1;
    }

    /**
     * Recursive minimax method for arrays*/
    public static int maxInRange(int arr[], int lowIndex, int highIndex ) {

        if (lowIndex == highIndex) {
            return arr[highIndex];
        }
        if( arr[lowIndex]<= arr[highIndex]) {
            return maxInRange(arr,lowIndex+1,highIndex);
        } else{
            return maxInRange(arr, lowIndex, highIndex-1);
        }

    }

/**
 * Wrapper method for maxInRange
* */
        public static int  max(int[] arr){
            return maxInRange(arr, 0, arr.length-1);
    }

    public static int indexOfMaxInRange(int[] arr, int index1){
        int max = 0;
        for (int i = 1; i <=index1 ; i++) {
            if(arr[max] <= arr[i]){
                max = i;
            }
        }
        return max;

    }

    public static void swapElement(int[] arr, int index1, int index2){
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static void selectionSort(int[] arr){
        for (int i = arr.length-1; i >0 ; i--) {
            swapElement(arr, i, indexOfMaxInRange(arr, i));
        }
    }

}
