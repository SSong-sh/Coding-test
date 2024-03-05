package xxx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class dummy {
    private static final int INDIVIDUAL_COUNT = 40;
    private static final int GROUP_COUNT = 2;
    private static final int MAX_TRIES = 1000;

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<String> ssns = new ArrayList<>();
        List<String> tels = new ArrayList<>();

        for (int groupNum = 1; groupNum <= GROUP_COUNT; groupNum++) {
            for (int i = 7; i < INDIVIDUAL_COUNT; i++) {
                // 랜덤한 이름, 주민등록번호, 전화번호 생성
                String name, ssn, tel;
                int tryCount = 0;
                do {
                    name = generateRandomName();
                    ssn = generateRandomSSN();
                    tel = generateRandomPhoneNumber();
                    tryCount++;
                } while ((names.contains(name) || ssns.contains(ssn) || tels.contains(tel)) && tryCount < MAX_TRIES);

                if (tryCount >= MAX_TRIES) {
                    System.err.println("Failed to generate unique values. Consider increasing MAX_TRIES.");
                    return;
                }

                names.add(name);
                ssns.add(ssn);
                tels.add(tel);

                System.out.printf("insert into tblVolunteer (seq, openCurriculumNum, name, volunteerDate, ssn, tel) values ((select nvl(max(seq), 0) + 1 from tblVolunteer), 8, '%s', to_date('2024-12-15','YYYY-MM-DD'), '%s', '%s');\n", name, ssn, tel);
            }
        }
    }

    // 임의의 이름 생성
    private static String generateRandomName() {
        String[] firstNames = {"김", "이", "박", "최", "정", "한", "서", "조", "임", "오", "윤", "장", "임", "남", "양", "강", "송", "변", "구", "고"};
        String[] middleNames = {"수", "이", "희", "소", "병", "성", "민", "미", "도", "지", "인", "윤", "이", "하", "예", "정", "영", "태", "원", "상"};
        String[] lastNames = {"현", "수", "라", "걸", "혜", "정", "자", "혁", "혜", "서", "정", "림", "수", "준", "민"};

        Random random = new Random();
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String middleName = middleNames[random.nextInt(middleNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];

        return firstName + middleName + lastName;
    }

    // 임의의 주민등록번호 생성
    private static String generateRandomSSN() {
        Random random = new Random();
        StringBuilder ssn = new StringBuilder();

        // 90년도부터 99년도 중 임의의 연도 생성
        int year = random.nextInt(10) + 90;

        // 생년월일 6자리
        ssn.append(String.format("%02d%02d%02d-",
                year, // 연도(90~99)
                random.nextInt(12) + 1, // 월(1~12)
                random.nextInt(31) + 1)); // 일(1~31)

        // 뒷자리 7자리
        for (int i = 0; i < 7; i++) {
            ssn.append(random.nextInt(10));
        }

        return ssn.toString();
    }

    // 임의의 전화번호 생성
    private static String generateRandomPhoneNumber() {
        Random random = new Random();

        return String.format("010-%04d-%04d",
                random.nextInt(10000), // 가운데 네 자리
                random.nextInt(10000)); // 마지막 네 자리
    }
}