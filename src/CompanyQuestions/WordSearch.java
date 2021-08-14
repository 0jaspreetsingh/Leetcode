package CompanyQuestions;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

    int size = 256;

    static Trie root;

    public class Trie {
        Trie[] children = new Trie[size];
        boolean isEnd = false;

        public Trie addWord(String str) {
            Trie pointer = root;
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i);
                if (pointer.children[index] == null) {
                    pointer.children[index] = new Trie();
                }
                pointer = pointer.children[index];
            }
            pointer.isEnd = true;
            return root;
        }

        public List<String> findMatches(String pattern) {
            List<String> ls = new ArrayList<>();
            Trie pointer = root;
            int level = 0;
            String answers = "";
            dfs(pattern, level, ls, pointer, answers);
            return ls;
        }

        private void dfs(String pattern, int level, List<String> ls, Trie pointer, String ans) {
            if (level > pattern.length()) return;
            if (level == pattern.length()) {
                if (pointer.isEnd) {
                    ls.add(ans);
                }
                return;
            }
            char ch = pattern.charAt(level);
            if (ch == ']') {
                for (int j = 0; j < pointer.children.length; j++) {
                    if (pointer.children[j] != null) {
                        String ans2 = ans + (char) j;
                        dfs(pattern, level + 1, ls, pointer.children[j], ans2);
                    }
                }
            } else if (pointer.children[(int) ch] == null) {
                return;
            } else {
                ans += ch;
                dfs(pattern, level + 1, ls, pointer.children[(int) ch], ans);
            }
        }
    }

    public Trie builder() {
        root = new Trie();
        return root;
    }


    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        List<String> ans = ws.builder().addWord("apple").addWord("ample").addWord("aqqqe").addWord("test").findMatches("a]]]e");
        System.out.println(ans.toString());
    }

}
