import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int N = sc.nextInt();
            int length = (int) Math.pow(3, N);
            StringBuilder result = new StringBuilder();

            // 초기 문자열 설정
            for (int i = 0; i < length; i++) {
                result.append('-');
            }

            // 칸토어 집합 생성
            generateCantoSet(result, 0, length);

            System.out.println(result.toString());
        }

        sc.close();
    }

    private static void generateCantoSet(StringBuilder result, int start, int length) {
        if (length < 3) {
            return;
        }

        int third = length / 3;

        // 가운데 부분을 공백으로 대체
        for (int i = start + third; i < start + 2 * third; i++) {
            result.setCharAt(i, ' ');
        }

        // 왼쪽과 오른쪽 부분에 대해 재귀적으로 동일한 작업 수행
        generateCantoSet(result, start, third);
        generateCantoSet(result, start + 2 * third, third);
    }

}
