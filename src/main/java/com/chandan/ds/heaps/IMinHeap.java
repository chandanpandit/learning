package com.chandan.ds.heaps;

public interface IMinHeap<E> {
   void minHeapify(int index);
   int parent(int i);
   int left(int i);
   int right(int i);
   E extractMin(int i);
   void decreaseKey(int i,int newVal);
   E getMin();
   void deleteKey(int i);
   void insertKey(int k);

}