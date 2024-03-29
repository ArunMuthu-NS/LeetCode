package HackerEarth;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PopularShops {
    static class Shop {
        int index;
        int visits;

        Shop(int index, int visits){
            this.index = index;
            this.visits = visits;
        }
    }
    public static void main(String args[]) throws Exception {
        Reader reader = new Reader();
        int T = Integer.parseInt(reader.readLine());
        while(T > 0) {
            String NM[] = reader.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            int prefix[] = new int[N+1];

            for(int i = 0;i < M;i++){
                String visits[] = reader.readLine().split(" ");
                int L = Integer.parseInt(visits[0]);
                int R = Integer.parseInt(visits[1]);
                prefix[L] += 1;
                if(R + 1 < N + 1)
                    prefix[R + 1] -= 1;
            }

            for(int i = 1;i < N + 1;i++)
                prefix[i] = prefix[i - 1] + prefix[i];

            List<Shop> shopList = new ArrayList<>();
            for(int i = 1;i < N + 1;i++)
                shopList.add(new Shop(i, prefix[i]));

            Collections.sort(shopList, new Comparator<Shop>() {
                @Override
                public int compare(Shop o1, Shop o2) {
                    if(o1.visits > o2.visits) return -1;
                    else if(o1.visits < o2.visits) return 1;
                    else if(o1.index < o2.index) return -1;
                    else return 1;
                }
            });

            int shops[] = new int[3];
            for(int i = 0;i < 3;i++)
                shops[i] = shopList.get(i).index;

            Arrays.sort(shops);
            for(int i = 0;i < 3;i++)
                System.out.print(shops[i] + " ");
            System.out.println();
            T--;
        }

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
