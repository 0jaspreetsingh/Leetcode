package CompanyQuestions;

public class MergeStrings {

    static String mergeStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int l1 = s1.length(), l2 = s2.length();
        int arr1[] = new int[26], arr2[] = new int[26];
        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            arr2[c - 'a']++;
        }
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (arr1[s1.charAt(i) - 'a'] == arr2[s2.charAt(j) - 'a']) {
                if (s1.charAt(i) <= s2.charAt(j)) sb.append(s1.charAt(i++));
                else sb.append(s2.charAt(j++));
            } else if (arr1[s1.charAt(i) - 'a'] < arr2[s2.charAt(j) - 'a']) {
                sb.append(s1.charAt(i++));
            } else {
                sb.append(s2.charAt(j++));
            }
        }
        if (i < l1) {
            sb.append(s1.substring(i));
        }
        if (j < l1) {
            sb.append(s2.substring(j));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeStrings("super", "tower"));
    }

}
