import java.io.*;
import java.util.*;


class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        long n = Long.parseLong(br.readLine().trim());

        long out_ = FindBigNum(n);
        wr.println(out_);
        wr.close();
        br.close();
    }

    static long FindBigNum(long n) {
        // Write your code here
        String sb =  new String("");
        int M = 1000000007;

        for(long i =1; i <= n; i++) {
            String curBinary = Long.toBinaryString(i);
            sb =  sb+curBinary;
            long l = Long.parseLong(sb,2);
            long m = l%M;
            sb = Long.toBinaryString(m);
        }
        return Long.parseLong(sb, 2);

    }
}