package main;

// unsolved
public class ValidNumber {

    public boolean isNumber(String s) {

        s = s.trim();
        if (s.length() == 0) {
            return false;
        }

        int e = 0;
        int dot = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                dot++;
                if (dot > 1) {
                    return false;
                }
            } else if (s.charAt(i) == 'e') {
                e++;
                if (e > 1) {
                    return false;
                }
            } else if (!(validChar(s.charAt(i)) || checkIfNo(s.charAt(i)))) {
                return false;
            }
        }

        String arr[] = s.split("e");
        if (arr.length > 0) {
            boolean frontAns = true;
            String front = arr[0];
            frontAns = isNumberWithDecimal(front);
            boolean lastAns = true;
            if (arr.length > 1) {
                String last = arr[1];
                lastAns = isNumberWithoutDecimal(last);
            }

            return frontAns && lastAns;
        }


        return false;

    }

    private boolean isNumberWithoutDecimal(String last) {
        if (last.length() > 0) {
            if (last.charAt(0) == '+' || last.charAt(0) == '-') {
                last = last.substring(1);
            }
            for (int i = 0; i < last.length(); i++) {
                if (!checkIfNo(last.charAt(i))) {
                    return false;
                }
            }
        } else {
            return true;
        }
        return true;
    }

    private boolean isNumberWithDecimal(String front) {
        if (front.length() > 0) {
            if (front.charAt(0) == '+' || front.charAt(0) == '-') {
                front = front.substring(1);
            }

            for (int i = 0; i < front.length(); i++) {

                if (front.charAt(i) == '.') {
                    if (i + 1 == front.length()) {
                        return false;
                    }
                    if (!checkIfNo(front.charAt(i + 1))) {
                        return false;
                    }
                } else if (!checkIfNo(front.charAt(i))) {
                    return false;
                }

            }
        } else {
            return true;
        }
        return true;
    }

    private boolean checkIfNo(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean validChar(char c) {
        return c == '+' || c == '-';
    }


    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber("e"));
    }
}
