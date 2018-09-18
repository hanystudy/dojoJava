import name.hanyi.player.Player;

public class GroupFightMain {
    public static void main(String[] args) {
        Player playerA = new Player("A");
        Player playerB = new Player("B");
        Player playerC = new Player("C");
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                playerA.hit(playerC);
            }
        });
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                playerB.hit(playerC);
            }
        });
        threadA.start();
        threadB.start();
    }
}
