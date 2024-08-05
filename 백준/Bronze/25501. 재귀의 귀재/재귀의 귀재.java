import java.util.*;

public class Main {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<String> strList = new ArrayList<>();

        for (int i = 0; i<N; i++) {

            strList.add(sc.next());

        } sc.close();
        // 입력 끝

        for (int i = 0; i<N; i++) {
            Map<String, Object> result = new HashMap<>();
            result.put("isPalindrome", 0);
            result.put("resultCount", 0);

            isPalindrome(strList.get(i), result);

            System.out.println(result.get("isPalindrome") + " " + result.get("resultCount"));

        }



    }

    public static Map<String, Object> recursion(String s, int l, int r, Map<String, Object> map){
        if(l >= r) {
            map.put("resultCount", (int) map.get("resultCount") + 1);
            map.put("isPalindrome", 1);
            return map;
        }
        else if (s.charAt(l) != s.charAt(r)) {
            map.put("resultCount", (int) map.get("resultCount") + 1);
            map.put("isPalindrome", 0);
            return map;
        }
        else {
            map.put("resultCount", (int) map.get("resultCount") + 1);
            return recursion(s, l+1, r-1, map);
        }
    }
    public static Map isPalindrome(String s, Map<String, Object> result){



        recursion(s, 0, s.length()-1, result);

        return result;
    }

}
