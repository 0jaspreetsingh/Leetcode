package CompanyQues;

import java.util.List;

public class PositiveProduct {
    static int maxLength(List<Integer> arr) {
        int positive = 0, negative = 0, answer = 0;
        for (int i : arr) {
            if (i == 0) {
                positive = 0;
                negative = 0;
            } else if (i > 0) {
                positive++;
                if (negative != 0) {
                    negative++;
                }
                answer = Math.max(answer, positive);
            } else {
                int temp = positive;
                positive = negative;
                negative = temp;

                negative++;
                if (positive != 0) {
                    positive++;
                }
                answer = Math.max(answer, positive);
            }
        }
        return answer;
    }

}
