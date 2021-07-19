package CompanyQuestions;

import java.util.Arrays;
import java.util.HashMap;

public class DigitalAnagrams {

    static long digitAnagrams(int[] a) {
        long ans = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            String str = sortString(a[i]);
            if (hm.containsKey(str)) {
                int freq = hm.get(str);
                ans += freq;
                hm.put(str, freq + 1);
            } else {
                hm.put(str, 1);
            }
        }
        return ans;
    }


    private static String sortString(int i) {
        char arr[] = Integer.toString(i).toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(digitAnagrams(new int[]{25, 35, 872, 228, 53, 278, 872}));
    }
}
