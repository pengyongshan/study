package com.tree.www.algorithm;

public class Coins {
    private int[] coins;

    public Coins() {
        coins = new int[8];
        for (int i = 0; i < 8; i++)
            coins[i] = 10;
    }

    public void setFake(int weight) {
        coins[(int) (Math.random() * 7)] = weight;
    }

    public void fake() {
        if (coins[0] + coins[1] + coins[2] == coins[3] + coins[4] + coins[5]) {
            if (coins[6] > coins[7])
                compare(6, 7, 0);
            else
                compare(7, 6, 0);
        } else if (coins[0] + coins[1] + coins[2] > coins[3] + coins[4] + coins[5]) {
            if (coins[0] + coins[3] == coins[1] + coins[4])
                compare(2, 5, 0);
            else if (coins[0] + coins[3] > coins[1] + coins[4])
                compare(0, 4, 1);
            if (coins[0] + coins[3] < coins[1] + coins[4])
                compare(1, 3, 0);
        } else if (coins[0] + coins[1] + coins[2] < coins[3] + coins[4] + coins[5]) {
            if (coins[0] + coins[3] == coins[1] + coins[4])
                compare(5, 2, 0);
            else if (coins[0] + coins[3] > coins[1] + coins[4])
                compare(3, 1, 0);
            if (coins[0] + coins[3] < coins[1] + coins[4])
                compare(4, 0, 1);
        }
    }

    protected void compare(int i, int j, int k) {
        if (coins[i] > coins[k])
            System.out.print("\n假币 " + (i + 1) + " 较重");
        else
            System.out.print("\n假币 " + (j + 1) + " 较轻");
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("输入假币重量（比10大或小）");
            System.out.println("ex. java Coins 5");
            return;
        }

        Coins eightCoins = new Coins();
        eightCoins.setFake(Integer.parseInt(args[0]));
        eightCoins.fake();
    }
}
