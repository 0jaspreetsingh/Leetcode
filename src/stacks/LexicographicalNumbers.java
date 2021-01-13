package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        Stack<Integer> st = new Stack<>();
        for (int i = 9; i > 0; i--) {
            st.push(i);
        }

        while (!st.isEmpty()) {
            int currVal = st.pop();
            if (currVal <= n) {
                ans.add(currVal);
                int bigValue = currVal * 10;
                if (bigValue <= n) {
                    for (int i = 9; i >= 0; i--) {
                        st.push(bigValue + i);
                    }
                }
            }

        }

        return ans;
    }
}
