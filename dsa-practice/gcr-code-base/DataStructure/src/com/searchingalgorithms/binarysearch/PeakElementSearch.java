package com.searchingalgorithms.binarysearch;

public class PeakElementSearch {

    // Method to find a peak element index
    public static int findPeakElement(int[] arr) {

        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean leftIsSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightIsSmaller = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            // Check if mid is a peak
            if (leftIsSmaller && rightIsSmaller) {
                return mid;
            }

            // If left neighbor is greater, move left
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Else move right
            else {
                left = mid + 1;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeakElement(arr);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}
