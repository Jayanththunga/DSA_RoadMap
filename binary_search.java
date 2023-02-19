import java.util.Arrays;
import java.util.Scanner;

public class binary_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num: ");
        int x = sc.nextInt();

        System.out.print("Enter no.of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter elements: ");
        takeinp(arr);
        Arrays.sort(arr);

        System.out.println(binarySearch(arr, x));
        System.out.println(binarysearchrec(arr, 0, n - 1, x));

        sc.close();

    }

    private static int binarySearch(int[] arr, int x) {
        int si = 0;
        int ei = arr.length - 1;
        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                ei = mid--;
            } else if (arr[mid] < x) {
                si = mid++;
            }
        }

        return -1;
    }

    private static void takeinp(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    // recursion method for binary search:
    public static int binarysearchrec(int[] arr, int si, int ei, int x) {
        if (si > ei) {
            return -1;
        }

        int mid = (si + ei) / 2;

        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            return binarysearchrec(arr, mid + 1, ei, x);
        } else {
            return binarysearchrec(arr, si, mid - 1, x);
        }

        // return mid;

    }
}
