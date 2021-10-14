package com.INFO6205.QuizSolutons.Quiz5;

/*
Priority Queue implementation:

You are familiar with concept of Priority Queue. For this quiz, we will create the priority queue with binary heap. You have to implement deleteMax and sink logic.
deleteMax function delete's the maximum priority element in the Priority Queue.
sink function fixes a violation by sinking an element downwards until there arent any violations in the Priority Queue
*/
public class PriorityQueue {
    private int[] pq;
    private int N = 0;

    public PriorityQueue(int n) {
        pq = new int[n + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int v) {
        N++;
        pq[N] = v;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    public int delMax() {
        int max = pq[1];

        swap(1, N);
        N--;
        pq[N + 1] = 0;
        sink(1);
        return max;
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            ;
            swap(k, j);
            k = j;
        }
    }


    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    private void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public int[] getPq() {
        return pq;
    }

    public static void main(String[] args) {
        int[] arr = {28, 79, 91, 76, 100, 45};

        PriorityQueue pq = new PriorityQueue(arr.length);
        for (int i : arr) {
            pq.insert(i);
        }

        for (int i = 0; i < 3; i++) System.out.println("Max Element deleted: " + pq.delMax());
    }
}