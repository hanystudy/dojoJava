package name.hanyi.marsrover.domain;

public class Mars {
    private int x;
    private int y;

    public Mars(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean validPosition(Position position) {
        return position.getX() >= 0
                && position.getX() <= this.x
                && position.getY() >= 0
                && position.getY() <= this.y;
    }
}
