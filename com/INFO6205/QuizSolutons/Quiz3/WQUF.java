package com.INFO6205.QuizSolutons.Quiz3;


           /*

                Weighted quick Union Find

                All of you are aware of the concept of Quick Union-find.
                Weighted quick union find modifies the process of Union to attach smaller tree to the larger tree to ensure that the size of tree does not increase leading to faster Find.
                For this quiz, you will have to implement union logic and find component logic.
                You will need to add your code in the 'TODO' section. You will find 2 'TODO's, one in the find function and the other in the union function.
                You must not make any changes apart from the code.
                Make your changes in Solution.java


            */
public class WQUF {

    private int[] root;
    private int[] rank;

    public WQUF(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }


    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        WQUF uf = new WQUF(100);
        uf.union(2, 83);
        uf.union(99, 27);
        uf.union(8, 2);
        uf.union(99, 8);
        uf.union(11, 8);

        System.out.println(uf.connected(81, 99));
        System.out.println(uf.connected(7, 8));
        System.out.println(uf.connected(81, 7));
        System.out.println(uf.connected(11, 21));
        System.out.println(uf.connected(81, 99));
        System.out.println(uf.connected(7, 8));

        uf.union(81, 23);
        uf.union(21,9);
        uf.union(11,7);
        uf.union(23, 9);
        uf.union(11, 81);

        System.out.println(uf.connected(81, 99));
        System.out.println(uf.connected(7, 8));
        System.out.println(uf.connected(81, 7));
        System.out.println(uf.connected(11, 21));
        System.out.println(uf.connected(81, 99));
        System.out.println(uf.connected(7, 8));

    }
}
