package HackerEarth;
import java.util.*;

class StringConversion {
    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine());
        while(T > 0) {
            String s1 = s.nextLine().trim();
            String t1 = s.nextLine().trim();
            int arr[] = new int[26];
            for(char x : s1.toCharArray())
                arr[x - 'a']++;
            for(char x : t1.toCharArray())
                arr[x - 'a']++;

            int i;
            for(i = 0;i < 26;i++)
                if(arr[i] % 2 != 0) break;

            if(i == 26)
                System.out.println("YES");
            else
                System.out.println("NO");
            T--;
        }
    }
}
