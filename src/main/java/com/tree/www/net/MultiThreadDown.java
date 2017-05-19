package com.tree.www.net;

public class MultiThreadDown {

	public static void main(String[] args) throws Exception {
		final DownUtil downUtil = new DownUtil(
				"http://g.hiphotos.baidu.com/image/pic/item/f603918fa0ec08fa0fdfede45eee3d6d54fbda92.jpg",
				"D:\\pys\\ios.png", 4);
		downUtil.download();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (downUtil.getCompleteRate() < 1) {
					System.out.println("已完成：" + downUtil.getCompleteRate());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("已完成.");
			}
		}).start();
	}
}
