import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws IOException{
        FastReader reader = new FastReader();
        int T = Integer.parseInt(reader.nextLine());
        int testCase = 1;
        while(T > 0) {
            String line[] = reader.nextLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            int houses[] = new int[N];
            line = reader.nextLine().split(" ");
            for (int i = 0; i < line.length; i++)
                houses[i] = Integer.parseInt(line[i]);

            Arrays.sort(houses);

            int max = 0, count = 0, tempB = B;
            for (int i = 0; i < houses.length;) {
                if(tempB - houses[i] >= 0){
                    tempB = tempB - houses[i];
                    count++;

                    i++;
                }
                else
                    break;
            }
            max = Math.max(max, count);

            System.out.println("Case #" + testCase + ": " + max);
            T--;
            testCase++;
        }
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
