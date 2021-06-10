package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		//initialise array
		int[] numArr = { 4, 3, 2, 10, 12, 1, 5, 6};
		System.out.println("Unsorted Array in Original Order: ");
		System.out.println(Arrays.toString(numArr));
		ascendingSort(numArr);
		System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(numArr));
	}
	
	static void ascendingSort(int array[]) {
        int size = array.length, i;
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    	
	}

}
