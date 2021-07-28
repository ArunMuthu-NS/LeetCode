package HackerEarth;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class TileScores {
    public static void main(String args[] ) throws Exception {
        Reader s = new Reader();
        int T = Integer.parseInt(s.readLine());
        while(T > 0) {
            int n = Integer.parseInt(s.readLine());
            int tiles[][] = new int[n][3];
            int res[] = new int[n];
            for(int i = 0;i < n;i++) {
                res[i] = -1;
                String val[] = s.readLine().split(" ");
                tiles[i][0] = Integer.parseInt(val[0]);
                tiles[i][1] = Integer.parseInt(val[1]);
                tiles[i][2] = Integer.parseInt(val[2]);
            }
            System.out.println(f1(tiles, n, res));
            T--;
        }
    }

    private static int f1(int tiles[][], int n, int res[]) {
        for(int i = n - 1;i >= 0;i--){
            int a = tiles[i][0], b = tiles[i][1], c = tiles[i][2];
            int res1 = ((a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c)) + ((i + 1 < n) ? res[i + 1] : 0);
            int res2 = ((a < b) ? ((b < c) ? b : c) : ((a < c) ? a : c)) + ((i + 2 < n) ? res[i + 2] : 0);
            int res3 = ((a < b) ? ((b < c) ? c : b) : ((a < c) ? c : a)) + ((i + 3 < n) ? res[i + 3] : 0);

            res[i] = Math.max(res1, res2);
            res[i] = Math.max(res[i], res3);
        }

        return res[0];
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
