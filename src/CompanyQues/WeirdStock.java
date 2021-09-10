package CompanyQues;

public class WeirdStock {
    // broken calculator
    static int findMinDays(int n, int m) {
        int counter = 0;
        while (m > n) {
            counter++;
            if (m % 2 == 1) {
                m++;
            } else {
                m /= 2;
            }
        }

        int ans = counter + n - m;

        return ans;

    }
}
