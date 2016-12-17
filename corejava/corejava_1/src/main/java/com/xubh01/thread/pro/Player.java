package com.xubh01.thread.pro;

/**
 * 生产者
 */
public class Player implements Runnable {
    private Movie m;

    public Player(Movie m) {
        super();
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (0 == i % 2) {
                m.play("左青龙");
            } else {
                m.play("右白虎");
            }
        }
    }

}
