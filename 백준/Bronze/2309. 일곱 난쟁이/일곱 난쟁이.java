import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] height = new int[9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {

            height[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(height);

//        System.out.println(Arrays.toString(height));

        // 제외 하는 두 인덱스 노드 번호
        int leftNode = 0;
        int rightNode = 1;

        // 못찾는 경우는 존재 X

        while (true) {

//            if(leftNode == 7 && rightNode == 8) {
//                break;
//            }

            int result = 0;

            for (int i = 0; i < 9; i++) {

                if( leftNode == i || rightNode == i) {
                    continue;
                }

                result += height[i];
            }

//            System.out.println(result);

            if( result == 100 ) {
                resultFunction(leftNode, rightNode);
                break;
            } else {

                if(rightNode == 8) {
                    leftNode++;
                    rightNode = leftNode + 1;
                } else {
                    rightNode++;
                }

            }

        }

    }

    public static void resultFunction(int leftNode, int rightNode) {

        for (int i = 0; i < 9; i++) {

            if( leftNode == i || rightNode == i) {
                continue;
            }
            System.out.println(height[i]);
        }

    }

}
