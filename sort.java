import java.util.Scanner;

public class sort {

    private static void takeinp(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter no.of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("enter numbers: ");
        takeinp(arr);

        bubblesort(arr, n);
        System.out.println("Bubble Sort: ");
        print(arr);
        System.out.println();

        selectionsort(arr, n);
        System.out.println("Selection Sort: ");
        print(arr);
        System.out.println();

        insertionsort(arr, n);
        System.out.println("Insertion Sort: ");
        print(arr);
        System.out.println();

        mergeSort(arr, n);
        System.out.println("Merge Sort: ");
        print(arr);
        System.out.println();

        quickSort(arr, 0, n - 1);
        System.out.println("Quick Sort: ");
        print(arr);

        sc.close();
    }

    public static void bubblesort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void selectionsort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int maxnum = Integer.MIN_VALUE;
            int ind = -1;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > maxnum) {
                    maxnum = arr[j];
                    ind = j;
                }
            }
            //
            arr[ind] = arr[n - i - 1];
            arr[n - i - 1] = maxnum;
        }
    }

    public static void insertionsort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int j = i - 1;

            int temp = arr[i];

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int part = partition(arr, si, ei);
        quickSort(arr, si, part - 1);
        quickSort(arr, part + 1, ei);
    }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[si];
        // count no.of elements that are less than pivots:
        int lessnums = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (arr[i] < pivot) {
                lessnums++;
            }
        }

        // swap pivot and element at index after lessnums
        arr[si] = arr[lessnums + si];
        arr[lessnums + si] = pivot;

        int i = si;
        int j = ei;
        while (i < j) {
            if (arr[i] < pivot) {
                i++;
            } else if (arr[j] >= pivot) {
                j--;
            } else {
                // swap arr[i] and arr[j]:
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return lessnums + si;
    }

    public static void mergeSort(int[] arr, int n) {
        if (arr.length <= 1) {
            return;
        }
        int n1 = n / 2;
        int n2 = n - n1;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[i];
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[i + n1];
        }

        mergeSort(arr1, n1);
        mergeSort(arr2, n2);

        merge(arr1, arr2, arr);
    }

    public static void merge(int[] arr1, int[] arr2, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }

        if (i < arr1.length) {
            while (i < arr1.length) {
                arr[k] = arr1[i];
                i++;
                k++;
            }
        }

        if (j < arr2.length) {
            while (j < arr2.length) {
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }
    }
}
