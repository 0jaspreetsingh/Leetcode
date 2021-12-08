package CompanyQuestions;


public class BuildPalindrome {

    public String buildPalindrome(String st) {
        for (int i = 0; i < st.length(); i++) {
            if (isPalindrome(st.substring(i))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(st);
                String rev = new StringBuilder(st.substring(0, i - 1)).reverse().toString();
                stringBuilder.append(rev);
                return stringBuilder.toString();
            }
        }
        return "";
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
