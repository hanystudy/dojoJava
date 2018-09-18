package name.hanyi.player;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class Player {
    private String name;
    private int health = 10000;
    private final Lock lock = new ReentrantLock();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void hit(Player player) {
        while (player.isAlive()) {
            Random random = new Random();
            player.damage(random.nextInt(10), name);
        }
    }

    public void damage(int damage, String enemy) {
        boolean hasLock = false;
        try {
            hasLock = lock.tryLock();
            if (this.health > damage) {
                this.health -= damage;
            } else if (this.health > 0) {
                this.health = 0;
                System.out.println(name + " is dead for damage " + damage + " by enemy " + enemy);
            } else {
                System.out.println(name + " is already dead");
            }
        } finally {
            if (hasLock) {
                lock.unlock();
            } else {
                System.out.println(enemy + " missed hit");
            }
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
