/*
From, GeeksforGeeks.org
http://www.geeksforgeeks.org/array-rotation/

Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
*/

public class Rotation {

    private static void rotate(int[] a, int places) {
        int len = a.length;

        if(places > len) {
            places = places % len;
        }

        if(places < len && places > 0) {
            // Reverse entire array
            reverse(a, 0, len - 1);

            // Reverse first half
            reverse(a, 0, len - places - 1);

            // Reverse second half
            reverse(a, len - places, a.length - 1);
        }

    }


    private static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;
        }
    }

    private static void test(int[] a, int places) {
        System.out.print("Before: ");
        printArray(a);
        rotate(a, places);
        System.out.print("After [" + places + "]: ");
        printArray(a);
        System.out.println();
    }


    public static void main(String[] args) {
        test(new int[] {1,2,3,4,5,6,7,8,9}, 3);
        test(new int[] {1,2,3,4,5,6,7,8,9}, 0);
        test(new int[] {1,2,3,4,5,6,7,8,9}, 5);
        test(new int[] {1,2,3,4,5,6,7,8,9}, 11);
    }

    private static void printArray(int[] a) {
        System.out.print("{" + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println("}");
    }

}
