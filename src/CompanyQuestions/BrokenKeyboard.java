package CompanyQuestions;

public class BrokenKeyboard {

    static int brokenKeyboard(String text, char[] letters) {
        if (text.length() == 0) return 0;
        int hm[] = new int[26];
        for (char c : letters) {
            hm[c - 'a']++;
        }
        String arr[] = text.toLowerCase().split(" ");
        int ans = 0;
        for (String str : arr) {
            if (check(str, hm)) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean check(String txt, int[] arr) {
        for (char c : txt.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (arr[c - 'a'] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
