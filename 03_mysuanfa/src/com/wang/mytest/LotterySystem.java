package com.wang.mytest;

import java.util.Random;

public class LotterySystem {
    // 用户类
    static class User {
        int totalDraws;         // 累计抽奖次数
        double totalRedPackets; // 累计获得的红包
        int totalGameCoins;     // 累计获得的游戏币

        public User(int totalDraws, double totalRedPackets, int totalGameCoins) {
            this.totalDraws = totalDraws;
            this.totalRedPackets = totalRedPackets;
            this.totalGameCoins = totalGameCoins;
        }
    }

    // 获取中奖概率的方法
    public static String getDrawProbability(User user) {
        if (user.totalDraws < 10) {
            return "高概率"; // 前10次必为高概率
        }
        if (user.totalRedPackets > 40) {
            return "低概率"; // 累计获得红包大于40时必为低概率
        }
        if (user.totalDraws > 30) {
            return "低概率"; // 抽奖次数大于30次时必为低概率
        }
        if (user.totalDraws > 15 && user.totalGameCoins > 300) {
            return "低概率"; // 累计抽奖次数大于15次并且游戏币大于300个时必为低概率
        }
        return "中概率"; // 默认中概率
    }

    // 抽奖方法
    public static String drawPrize(User user) {
        String probability = getDrawProbability(user);
        Random random = new Random();

        switch (probability) {
            case "高概率":
                return highProbabilityDraw(random);
            case "中概率":
                return mediumProbabilityDraw(random);
            case "低概率":
                return lowProbabilityDraw(random);
            default:
                return "未中奖";
        }
    }

    // 高概率抽奖
    private static String highProbabilityDraw(Random random) {
        int chance = random.nextInt(100);
        if (chance < 70) {
            return "中奖（高概率）";
        } else {
            return "未中奖（高概率）";
        }
    }

    // 中概率抽奖
    private static String mediumProbabilityDraw(Random random) {
        int chance = random.nextInt(100);
        if (chance < 30) {
            return "中奖（中概率）";
        } else {
            return "未中奖（中概率）";
        }
    }

    // 低概率抽奖
    private static String lowProbabilityDraw(Random random) {
        int chance = random.nextInt(100);
        if (chance < 10) {
            return "中奖（低概率）";
        } else {
            return "未中奖（低概率）";
        }
    }

    // 测试代码
    public static void main(String[] args) {
        User user = new User(16, 35.0, 320); // 示例用户

        for (int i = 1; i <= 10; i++) {
            System.out.println("第 " + i + " 次抽奖: " + drawPrize(user));
            user.totalDraws++;
        }
    }
}