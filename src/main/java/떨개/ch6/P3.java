package 떨개.ch6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P3 {

    public static void main(String[] args) {

        // Ch6. 문자열 처리
        //  - 03. 로그 파일 재정렬
        //   1) 로그의 가장 앞부분은 식별자로서, 순서에 영향을 끼지치 않는다.
        //   2) 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
        //   3) 문자가 동일한 경우에는 식별자순으로 한다.
        //   4) 숫자 로그는 입력 순서대로 한다.

        // 현재 input 정답 : id2, id5, id4, id1, id3
        // List<String> logs = Arrays.asList("id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero");
        // List<String> logs = Arrays.asList("dig3 8 1 5 1","let4 art can","dig2 8 1 5 1","let2 own kit dig","let3 art can");
        List<String> logs = Arrays.asList("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo");

        System.out.println(Arrays.toString(answer1(logs)));

    }

    private static String[] answer1(List<String> logs) {

        // 1. 문자 로그와 숫자 로그를 구분해 각각 처리
        //  - 책을 보면서 작업

        List<String> stringList = new ArrayList<>(); // 문자 로그 저장소
        List<String> digitList = new ArrayList<>(); // 숫자 로그 저장소

        for (String log : logs) {
            // 숫자 로그인 경우
            if(Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            }
            // 문자 로그인 경우
            else {
                stringList.add(log);
            }
        }

        stringList.sort((s1, s2) -> {
            // 식별자와 식별자 외 나머지 부분, 이렇게 두 부분으로 나눈다.
            String[] s1_arr = s1.split(" ");
            String[] s2_arr = s2.split(" ");

            // System.out.println("Arrays.toString(s1_arr) = " + Arrays.toString(s1_arr));
            // System.out.println("Arrays.toString(s2_arr) = " + Arrays.toString(s2_arr));
            System.out.println("s1_arr[1] = " + s1_arr[1]);
            System.out.println("s2_arr[1] = " + s2_arr[1]);

            // 문자 로그 사전순 비교
            int compared = s1_arr[1].compareTo(s2_arr[1]);

            // 문자가 동일한 경우 식별자 비교
            if(compared == 0) {
                return s1_arr[0].compareTo(s2_arr[0]);
            }
            // 비교 대상의 순서가 동일한 경우 0, 순서가 앞인 경우 1, 뒤인 경우 -1이 된다.(compareTo 설명)
            else {
                return compared;
            }

        });

        stringList.addAll(digitList);

        return stringList.toArray(new String[0]);
    }

}
