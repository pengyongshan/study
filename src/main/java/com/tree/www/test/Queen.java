package com.tree.www.test;

/**
 * 八皇后问题
 * 
 * @author pys
 *
 * @date 2016年5月13日 下午5:12:07
 */
public class Queen {

    public static final int N = 8;

	private int[] column; // 列
	private int[] rup; // \(同一条线上横纵坐标相加相等)
	private int[] lup; // /(同一条线上横纵坐标相减相等)
	private int[] queen; // 解答

	private int num; // 统计解答数

	public Queen() {
		column = new int[N + 1];
		rup = new int[2 * N];
		lup = new int[2 * N];
		queen = new int[N + 1];
	}

	public static void main(String[] args) {
		Queen queen = new Queen();
		queen.backTrack(1); // 第一行开始遍历
	}

	private void backTrack(int j) {
		if (j > N) {
			showAnswer(); // 找完8 行 可以showAnswer了
		} else {
			for (int i = 1; i <= N; i++) {
				if (column[i] == 0 && rup[i + j - 1] == 0 && lup[i - j + N] == 0) {
					// i-j 范围 -7到7 加 N, i+j范围2-16 所以减1
					queen[j] = i; // j行i列暂居位置。
					column[i] = rup[i + j - 1] = lup[i - j + N] = 1; // 同时该位置的列、/和\都不能再放皇后。
					backTrack(j + 1); // 下一行找
					column[i] = rup[i + j - 1] = lup[i - j + N] = 0; // 找完一个解恢复原位
				}
			}
		}

	}

	private void showAnswer() {
		System.out.println("第" + ++num + "个解答：");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (queen[i] == j) {
					System.out.print("Q");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
