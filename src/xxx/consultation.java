package xxx;

import java.util.Random;

public class consultation {
    public static void main(String[] args) {
        Random random = new Random();
        String[] contents = {"학원생활", "시험", "멘탈관리", "기타"};

        for (int i = 1; i <= 100; i++) {
            int studentNum = random.nextInt(25) + 1; // 1부터 25까지의 번호 랜덤 선택
            int randomIndex = random.nextInt(contents.length);
            String content = contents[randomIndex];

            String sql = "INSERT INTO tblRequestConsultation (seq, studentNum, content) " +
                         "VALUES ((SELECT NVL(MAX(seq), 0) + 1 FROM tblRequestConsultation), " +
                         studentNum + ", '" + content + "');";

            System.out.println(sql);
        }
    }
}
