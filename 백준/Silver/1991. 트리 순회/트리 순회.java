import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 노드 개수
    static int N;
    static Node root = new Node('A', null, null);

    // 노드 객체 클래스
    static private class Node {
        char value;
        Node left;
        Node right;

        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }


    /*
    * 이진 트리 그래프 탐색 문제
    * 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
    * 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
    * 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
    *
    * -- 루트는 항상 A, N은 26 이하
    * */
    public static void main(String[] args) throws IOException {


        input();

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();


    }

    public static void preOrder(Node node) {
        if(node ==null) return;
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node ==null) return;
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node ==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    public static void insertNode(Node temp, char node, char leftNode, char rightNode) {

        // 부모 노드 인경우 (A는 항상 부모 노드)
        if (temp.value == node) {
            temp.left = (leftNode == '.' ? null : new Node(leftNode,null,null));
            temp.right = (rightNode == '.' ? null : new Node(rightNode,null,null));
        }
        // 부모 노드가 아니면 ..
        else {
            if(temp.left != null) insertNode(temp.left, node, leftNode, rightNode);
            if(temp.right != null) insertNode(temp.right, node, leftNode, rightNode);
        }

    }

    private static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드 개수
        N = Integer.parseInt(br.readLine());

        // 트리 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // 참조 레퍼런스로 전역 Node 클래스 Type root 를 전달하여 여기서 트리 구조 완성
            insertNode(root, node, left, right);

        }


    }

}
