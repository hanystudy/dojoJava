package name.hanyi.marathon;

import java.util.Random;

public class Runner {
    private String name;
    private int distance = 0;

    public Runner(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void run(int distance) {
        System.out.println(name + " starts running!");
        while (!isFinish(distance)) {
            Random random = new Random();
            this.distance += random.nextInt(20);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {}

        }
        System.out.println(name + " finishes running!");
    }

    public boolean isFinish(int distance) {
        return this.distance >= distance;
    }
}
