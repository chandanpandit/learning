package com.chandan.ds.sorting;

import java.util.Random;

public class SortUtil {
   public static void bubbleSort(int[] a) {
      for (int i = 0; i < a.length - 1; i++) {
         for (int j = 0; j < a.length - 1 - i; j++) {
            if (a[j] > a[j + 1]) {
               swap(a, j, j + 1);
            }
         }
      }
   }

   public static void selectionSort(int[] a){
      for (int i = 0; i < a.length; i++) {
         for (int j = i+1; j < a.length; j++) {
            if(a[j] < a[i]){
               swap(a,i,j);
            }
         }
      }
   }

   /**
    * Sorts by placing next element on its correct position in already sorted array
    * @param a
    */
   public static void insertionSort(int[] a){
      int key;
      for (int i = 1; i < a.length; i++) {
         key = a[i];
         int j;
         // shift the sorted array to make place for current key to be inserted
         for (j = i-1; j >= 0 && a[j] > key; j--) {
            a[j+1] = a[j];
         }
         a[j+1] = key;
      }
   }

   public static void mergeSort(int[] a){
      mergeSortUtil(a,0,a.length-1);
   }

   private static void mergeSortUtil(int[] a,int low, int high){
      if(low < high){
         int mid = low + (high - low) / 2;
         mergeSortUtil(a,low,mid);
         mergeSortUtil(a,mid+1,high);
         merge(a,low,mid,high);
      }
   }

   private static void merge(int[] a, int low,int mid,int high){
      int i = low;
      int j = mid+1;
      int k = low;
      int[] temp = new int[high+1];
      while (i <= mid && j <= high){
         if(a[i] < a[j]){
            temp[k] = a[i];
            i++;
         }else{
            temp[k] = a[j];
            j++;
         }
         k++;
      }
      while (i <= mid){
         temp[k] = a[i];
         i++;k++;
      }
      while (j <= high){
         temp[k] = a[j];
         j++;k++;
      }
      for (int l = low; l <= high ; l++) {
         a[l] = temp[l];
      }
   }

   public static void quickSort(int[] a){
      quickSortUtil(a,0,a.length-1);
   }

   private static void quickSortUtil(int[] a, int low, int high){
      if(low < high){
         int pivot = partition(a,low,high);
         quickSortUtil(a,low,pivot-1);
         quickSortUtil(a,pivot+1,high);
      }
   }

   private static int partition(int[] a,int low,int high){
      int p = low, i = low+1, j = high;
      do{
         while (i<= high && a[i] < a[p])
            i++;
         while (j>= low+1 && a[j] > a[p])
            j--;
         if(i < j){
            swap(a,i,j);
            i++;
            j--;
         }
      }while (i<j);
      // swap j with pivot
      swap(a,j,p);
      return j;
   }

   public static void main(String[] args) {
      Random r = new Random();
      int n = 1;
      System.out.println("Len\t\tBubble\tSelection\tInsertion\tMerge\tQuick");
      for (int i = 1; i < 100000; i+=1000) {
         //generate Array of length n*10
         int len = n * i;
         int[] a = new int[len];
         int[] b = new int[len];
         int[] c = new int[len];
         int[] d = new int[len];
         int[] e = new int[len];
         int divide = 1000;
         for (int j = 0; j < len; j++) {
            a[j] = b[j] = c[j] = d[j] = e[j] = r.nextInt();
         }
         long start = System.nanoTime();
         bubbleSort(a);
         long bubble = (System.nanoTime()-start)/divide;

         start = System.nanoTime();
         selectionSort(b);
         long selection = (System.nanoTime()-start)/divide;;

         start = System.nanoTime();
         insertionSort(c);
         long insertion = (System.nanoTime()-start)/divide;;

         start = System.nanoTime();
         mergeSort(d);
         long merge = (System.nanoTime()-start)/divide;;

         start = System.nanoTime();
         quickSort(e);
         long quickSort = (System.nanoTime()-start)/divide;
         System.out.println(len+"\t\t"+bubble+"\t\t"+selection+"\t\t"+insertion+"\t\t"+merge+"\t\t"+quickSort);
      }
   }

   private static void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   private static void printArray(int[] a) {
      for (int i = 0; i < a.length; i++) {
         System.out.print(a[i]+",");
      }
      System.out.println();
   }
}
