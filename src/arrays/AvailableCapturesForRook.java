package arrays;

/**
 * https://leetcode.com/problems/available-captures-for-rook/
 */
public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int counter = 0;

        int ri = -1;
        int rj = -1;

        outerloop:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    ri = i;
                    rj = j;
                    break outerloop;
                }
            }
        }

        if (ri != -1 && rj != -1) {
            loop:
            for (int i = ri + 1; i < 8; i++) {
                if (board[i][rj] == 'B') {
                    break loop;
                } else {
                    if (board[i][rj] == 'p') {
                        counter++;
                        break loop;
                    }
                }

            }

            loop:
            for (int i = ri - 1; i >= 0; i--) {
                if (board[i][rj] == 'B') {
                    break loop;
                } else {
                    if (board[i][rj] == 'p') {
                        counter++;
                        break loop;
                    }
                }

            }

            loop:
            for (int j = rj + 1; j < 8; j++) {
                if (board[ri][j] == 'B') {
                    break loop;
                } else {
                    if (board[ri][j] == 'p') {
                        counter++;
                        break loop;
                    }
                }

            }

            loop:
            for (int j = rj - 1; j >= 0; j--) {
                if (board[ri][j] == 'B') {
                    break loop;
                } else {
                    if (board[ri][j] == 'p') {
                        counter++;
                        break loop;
                    }
                }

            }

        }

        return counter;
    }


    public static void main(String[] args) {
        AvailableCapturesForRook av = new AvailableCapturesForRook();
        char arr[][] = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(av.numRookCaptures(arr));
    }
}
