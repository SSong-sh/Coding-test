package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sort {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        try {

            StringTokenizer st = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 단어와 반복횟수 저장할 map
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < N; i++) {

                String word = reader.readLine();

                if (word.length() < M) {
                    continue;
                } else {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }

            }

            // 단어만 저장하는 list
            // Returns a Set view of the keys contained in this map
            List<String> words = new ArrayList<>(map.keySet());

            // 정렬시작
            // 길이 순으로 정렬
            Collections.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                   if (!map.get(o1).equals(map.get(o2))) {
                       //등장 횟수를 기준으로 정렬 > 등장 횟수가 다를 때
                       return Integer.compare(map.get(o2), map.get(o1)); // 양수면 o2부터, 아니면 o1부터
                   } else if (o1.length() != o2.length()) {
                       // 길이가 다르면 긴 단어를 우선으로 정렬 > 등장 횟수가 같을 때
                       return Integer.compare(o2.length(), o1.length());
                   } else {
                       // 사전 순으로 정렬 > 등장 횟수가 같을 때
                       return o1.compareTo(o2);
                   }

                }
            });

            for (String str : words) {
                builder.append(str).append('\n');
            }
            System.out.println(builder);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}