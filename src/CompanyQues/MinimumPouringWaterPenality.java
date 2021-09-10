package CompanyQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPouringWaterPenality {
    static class Tree {
        int level;
        List<Tree> children;

        Tree(int level) {
            this.level = level;
            this.children = new ArrayList<>();
        }

        public boolean isEmpty() {
            return this.children.isEmpty();
        }
    }

    static int answer = Integer.MAX_VALUE;
    static int sohp = 0;
    static int suhp = 0;
    static int uhp = 0;

    static int minimumPouringWaterPenalty(List<Integer> parent, List<Integer> waterLevel, int overhydratedPenalty, int underhydratedPenalty) {
        suhp = underhydratedPenalty;
        sohp = overhydratedPenalty;
        Tree arr[] = new Tree[parent.size()];
        for (int i = 0; i < parent.size(); i++) {
            if (waterLevel.get(i) <= -1) uhp += underhydratedPenalty;
            arr[i] = new Tree(waterLevel.get(i));
        }
        Tree root = arr[0];
        for (int i = 1; i < parent.size(); i++) {
            arr[parent.get(i)].children.add(arr[i]);
        }
        int penality[] = dfs(root, new int[2]);
        return answer;
    }

    private static int[] dfs(Tree node, int[] ans) {
        if (node == null) return new int[2];
        if (node.level >= 1) {
            ans[0]++;
        } else if (node.level <= -1) {
            ans[1]++;
        }
        for (Tree ch : node.children) {
            dfs(ch, ans);
        }
        int val = ans[0] * sohp + uhp - ans[1] * suhp;
        answer = Math.min(answer, val);
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> parent = Arrays.asList(-1, 0, 1);
        List<Integer> waterLevel = Arrays.asList(1, -1, -1);
        System.out.println(minimumPouringWaterPenalty(parent, waterLevel, 10, 15));

    }
}
