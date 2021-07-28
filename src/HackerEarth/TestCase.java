package HackerEarth;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestCase {
    public static void main(String args[]) {
        for(int i = 1;i <= 300000;i++){
            if(i % 3 == 0)
                System.out.println(i);
            else
                System.out.print(i + " ");
        }
    }
}