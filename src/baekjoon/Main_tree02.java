package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_tree02 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        StringBuilder builder = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            str = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());

            for (int j = 0; j < M; j++) {
                str = new StringTokenizer(reader.readLine());
                int from = Integer.parseInt(str.nextToken());
                int to = Integer.parseInt(str.nextToken());
            }

            builder.append(N-1+"\n");
            
            
        }
        System.out.println(builder.toString());
    }
}
