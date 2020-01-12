package Graph;

import java.util.ArrayList;

/*
    Problem Link : https://leetcode.com/problems/number-of-operations-to-make-network-connected/
    Solution Link : https://leetcode.com/submissions/detail/293513986/
*/

public class NetworksConnected {

    public void dfs(ArrayList<Integer> G[], int index, boolean visited[]) {
        if(visited[index]) return;
        visited[index] = true;
        for(int x : G[index])
            dfs(G, x, visited);
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        ArrayList<Integer> G[] = new ArrayList[n];
        for(int i = 0;i < n;i++)
            G[i] = new ArrayList<>();
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int connection[] : connections){
            int x = connection[0];
            int y = connection[1];
            G[x].add(y);
            G[y].add(x);
        }

        for(int i = 0;i < n;i++)
            if(!visited[i]){
                dfs(G, i, visited);
                count++;
            }

        return (count - 1);
    }

    public static void main(String args[]) {
        System.out.println(new NetworksConnected().makeConnected(6,new int[][]{
                {0,1},{0,2},{0,3},{1,2},{1,3}
        }));
    }
}
