package name.hanyi.player;

import java.util.Random;

public class Player {
    private String name;
    private int health = 10000;

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

    public synchronized void damage(int damage, String enemy) {
        if (this.health > damage) {
            this.health -= damage;
        } else if (this.health > 0) {
            this.health = 0;
            System.out.println(name + " is dead for damage " + damage + " by enemy " + enemy);
        } else {
            System.out.println(name + " is already dead");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
