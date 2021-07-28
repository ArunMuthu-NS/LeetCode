package HackerEarth;

import java.io.*;
import java.util.*;


public class LandProb {
    public static final String template = "x:%s,y:%s,d:%s";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] strNums = br.readLine().split(" ");
            int rows = Integer.parseInt(strNums[0]);
            int cols = Integer.parseInt(strNums[1]);
            int threshold = Integer.parseInt(strNums[2]);
            int[][] initThickness = new int[rows][cols];
            for(int i_initThickness=0; i_initThickness<rows; i_initThickness++)
            {
                String[] arr_initThickness = br.readLine().split(" ");
                for(int j_initThickness=0; j_initThickness<arr_initThickness.length; j_initThickness++)
                {
                    initThickness[i_initThickness][j_initThickness] = Integer.parseInt(arr_initThickness[j_initThickness]);
                }
            }
            long[][] rate = new long[rows][cols];
            for(int i_rate=0; i_rate<rows; i_rate++)
            {
                String[] arr_rate = br.readLine().split(" ");
                for(int j_rate=0; j_rate<arr_rate.length; j_rate++)
                {
                    rate[i_rate][j_rate] = Long.parseLong(arr_rate[j_rate]);
                }
            }

            String out_ = mazeTraveller(threshold, initThickness, rate, rows, cols);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static String mazeTraveller(int threshold, int[][] initThickness, long[][] rate, int rows, int cols){
        int x = 0, y = 0, day = 1;
        HashMap<String, Boolean> hashMap = new HashMap<>();
        travel(threshold, initThickness, rate, rows, cols, x, y, day, hashMap);
        if(hashMap.get(String.format(template, x, y , day)))
            return "YES";
        else
            return "NO";
    }

    static boolean travel(int threshold, int[][] initThickness, long[][] rate, int rows, int cols, int x, int y, int d, HashMap<String, Boolean> map){

        if(x >= rows || y >= cols){
            map.put(String.format(template,x,y,d), false);
            return false;
        }

        if((initThickness[x][y] + (rate[x][y] * (d - 1))) > threshold){
            map.put(String.format(template,x,y,d), false);
            return false;
        }

        if(x == rows - 1 && y == cols - 1) {
            map.put(String.format(template,x,y,d), true);
            return true;
        }

        if(map.get(String.format(template, x, y , d)) != null) return map.get(String.format(template, x, y , d));

        boolean res1 = travel(threshold, initThickness, rate, rows, cols,x + 1, y, d + 1, map);

        map.put(String.format(template,x,y,d), res1);

        if(res1) return true;

        boolean res2 = travel(threshold, initThickness, rate, rows, cols,x , y + 1, d + 1, map);

        map.put(String.format(template,x,y,d), res2);

        return res2;

    }
}
