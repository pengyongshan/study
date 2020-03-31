package com.tree.www.leetCode;

/**
 * 999.车的可用捕获量
 * <p>
 * Created by pysh on 2020-03-26.
 */
public class NumRookCaptures {
    /**
     * 在一个 8 x 8 的棋盘上，有一个白色车（rook）,也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
     * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
     * <p>
     * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），
     * 然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
     * 另外，车不能与其他友方（白色）象进入同一个方格。
     * <p>
     * 返回车能够在一次移动中捕获到的卒的数量。
     * <p>
     * board.length == board[i].length == 8
     * board[i][j] 可以是 'R'，'.'，'B' 或 'p'
     * 只有一个格子上存在 board[i][j] == 'R'
     */
    public int numRookCaptures(char[][] board) {
        int result = 0;
        // 定义上下左右四个方向
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    for (int k = 0; k < 4; k++) {
                        int x = i, y = j;
                        while (true) {
                            x += dr[k];
                            y += dc[k];
                            if (x < 0 || x == 8 || y < 0 || y == 8 || board[x][y] == 'B') {
                                break; // 到底、到顶或被自己的象挡住
                            }
                            if (board[x][y] == 'p') {
                                result++;
                                break; // 一个方向最多只能吃一个卒
                            }
                        }
                    }
                    return result;
                }
            }
        }
        return -1;
    }
}
