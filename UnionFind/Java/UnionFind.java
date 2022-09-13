package UnionFind.Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnionFind
{
    private int[] id; 
    private int count;

    public UnionFind(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count()
    { 
        return count; 
    }

    public boolean connected(int p, int q)
    { 
        return find(p) == find(q);
    }

    public int find(int p)
    { 
        return id[p]; 
    }

    public void union(int p, int q)
    { 
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;
    
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            } 
        }
            
        count--;
    }
    
    public static void main(String[] args)
    {
        Scanner in;
        try {
            in = new Scanner(new File("/Users/sangnguyen/Documents/IMP_221/AdvancedAlgorithms/Projects/Algos/UnionFind/tiny.txt"));
            int N = in.nextInt();    // Read number of sites
            UnionFind uf = new UnionFind(N); // Initialize N components.
            while (in.hasNextInt())
            {
                int p = in.nextInt();
                int q = in.nextInt(); // Read pair to connect.
                if (uf.connected(p, q)) continue; // Ignore if connected.
                uf.union(p, q); // Combine components
                System.out.println(p + " " + q); // and print connection.
            }
            System.out.println(uf.count() + " components");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}