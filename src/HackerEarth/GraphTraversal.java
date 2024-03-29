package HackerEarth;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class GraphTraversal {
    public static void main(String args[]) throws Exception {
        Reader reader = new Reader();
        int N = Integer.parseInt(reader.readLine());
        char powers[] = new char[N + 1];
        int i = 1;
        for(String power : reader.readLine().split(" ")){
            powers[i++] = power.charAt(0);
        }

        List<Integer> G[] = new LinkedList[N + 1];

        for(i = 0;i < N + 1;i++)
            G[i] = new LinkedList<>();

        for(i = 0;i < N - 1;i++) {
            String path[] = reader.readLine().split(" ");
            int src = Integer.parseInt(path[0]);
            int dest = Integer.parseInt(path[1]);
            G[src].add(dest);
            G[dest].add(src);
        }

        int Q = Integer.parseInt(reader.readLine());

        for (i = 0;i < Q;i++) {
            String path[] = reader.readLine().split(" ");
            int src = Integer.parseInt(path[0]);
            int dest = Integer.parseInt(path[1]);
            boolean visited[] = new boolean[N + 1];
            int charMap[] = new int[26];
            dfs(G, src, dest, visited, charMap, powers);
        }
    }

    private static boolean dfs(List<Integer> G[], int src, int dest, boolean visited[], int charMap[], char powers[]) {
        if(!visited[src]) {
            visited[src] = true;
            charMap[powers[src] - 'a']++;
            if(dest == src) return true;
            for (Integer x : G[src]){
                boolean pathExist = dfs(G, x, dest, visited, charMap, powers);
                if(!pathExist)
                    charMap[powers[src] - 'a']--;
            }
        }
        return false;
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
