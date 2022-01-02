package com.example.demo.alg;

public class HaltingProblemTest {
    static class Good {
        Human human;
        String status;

        public Good() {
        }

        public void setHuman(Human human) {
            this.human = human;
            status = human.status;
        }

    }

    static class Human {
        String status = "HALT";
        Good good;

        public Human() {
        }

        public void setGood(Good good) {
            this.good = good;
        }

        void judge() {
            if ("HALT".equals(good.status)) {
                status = "RUN";
            } else {
                status = "HALT";
            }
            good.status = status;
        }
    }

    public static void main(String[] args) {
        Good good = new Good();
        Human human = new Human();

        good.setHuman(human);
        human.setGood(good);

        while ("RUN".equals(human.status) || "HALT".equals(good.status)) {
            human.judge();
        }
    }

}
