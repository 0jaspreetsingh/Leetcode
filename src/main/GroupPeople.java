package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class GroupPeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> li = new ArrayList<>();
        int len = groupSizes.length;
        HashMap<Integer, List<Integer>> hs = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> temp = hs.getOrDefault(groupSizes[i], new ArrayList<Integer>());
            temp.add(i);
            hs.put(groupSizes[i], temp);
            if (temp.size() == groupSizes[i]) {
                li.add(temp);
                hs.remove(groupSizes[i]);
            }
        }

        return li;
    }


    public static void main(String[] args) {
        GroupPeople gp = new GroupPeople();
        int groupSizes[] = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(gp.groupThePeople(groupSizes));
    }
}
