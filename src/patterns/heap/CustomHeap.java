//https://www.scaler.com/academy/mentee-dashboard/class/514050/assignment/problems/90663?navref=cl_tt_nv
package patterns.heap;

public class CustomHeap {

    public int[] buildHeap(int[] array) {
        if(array.length <= 1)
            return array;

        int lastParent = (array.length/2) -1;

        for (int index = lastParent; index >= 0; index--) {
            heapifyDown(array, index);
        }

        return array;
    }

    private void heapifyDown(int[] array, int index) {
        int leftChildIndex = (index * 2) + 1;
        int rightChildIndex = (index * 2) + 2;
        int smallestIndex = index;


        if(leftChildIndex < array.length && array[leftChildIndex] < array[smallestIndex] )
            smallestIndex=leftChildIndex;
        if(rightChildIndex < array.length  && array[rightChildIndex] < array[smallestIndex] )
            smallestIndex=rightChildIndex;


        if(smallestIndex!= index){
            swap(array, index, smallestIndex);
            heapifyDown(array, smallestIndex);
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}