
import java.util.*;
public class secretmessagedecoder {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while (n-- > 0) {
            String S = sc.nextLine();
            char[] arr = S.toCharArray();
            Arrays.sort(arr); 
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            for (char ch : arr) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();
            for(char ch : map.keySet()){
                sb.append(ch +":").append(map.get(ch)).append(" ");
            }

            System.out.println(sb.toString());
        }
    }
}
