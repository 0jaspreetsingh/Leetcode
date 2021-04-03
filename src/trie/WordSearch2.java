package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch2 {

    int size = 26;

    static Trie root;

    class Trie {

        Trie[] children = new Trie[size];
        boolean isEnd = false;
        int indexOfWord = -1;
    }

    public void insert(String str, int indexOfWord) {
        Trie pointer = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (pointer.children[index] == null) {
                pointer.children[index] = new Trie();
            }
            pointer = pointer.children[index];
        }
        pointer.isEnd = true;
        pointer.indexOfWord = indexOfWord;
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        root = new Trie();
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, ans, i, j, root, words);
            }
        }
        return ans;
    }

    private void dfs(char[][] board, List<String> ans, int i, int j, Trie pointer, String[] words) {

        char ch = board[i][j];
        if (ch == '#' || pointer.children[ch - 'a'] == null) return;
        pointer = pointer.children[ch - 'a'];
        if (pointer.isEnd && pointer.indexOfWord != -1) {
            ans.add(words[pointer.indexOfWord]);
            pointer.indexOfWord = -1;
            pointer.isEnd = false;
        }

        board[i][j] = '#';
        if (i < board.length - 1) dfs(board, ans, i + 1, j, pointer, words);
        if (j < board[0].length - 1) dfs(board, ans, i, j + 1, pointer, words);
        if (i > 0) dfs(board, ans, i - 1, j, pointer, words);
        if (j > 0) dfs(board, ans, i, j - 1, pointer, words);
        board[i][j] = ch;
    }
}
