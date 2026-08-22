package patterns.heap;

public class ArrayToHeap {
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


//        System.out.println(index+" "+leftChildIndex+" "+rightChildIndex);
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

    public static void main(String[] args) {
        ArrayToHeap arrayToHeap=  new ArrayToHeap();
        System.out.println(arrayToHeap.buildHeap(new int[] {1,2,3,4,5,6}));
        System.out.println(arrayToHeap.buildHeap(new int[] {6,5,4,3,2,1}));
        System.out.println(arrayToHeap.buildHeap(new int[] {}));
    }
}