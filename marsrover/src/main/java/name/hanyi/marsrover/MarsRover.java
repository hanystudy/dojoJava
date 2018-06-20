package name.hanyi.marsrover;

import name.hanyi.marsrover.domain.Direction;
import name.hanyi.marsrover.domain.Mars;
import name.hanyi.marsrover.domain.Position;
import name.hanyi.marsrover.domain.Rover;

import java.util.*;

public class MarsRover {
    private Mars mars;
    private Rover rover;

    public Mars buildMars(String input) {
        String[] size = input.split(" ");
        this.mars = new Mars(Integer.valueOf(size[0]), Integer.valueOf(size[1]));
        return this.mars;
    }

    public Rover buildRover(String input) {
        String[] position = input.split(" ");
        this.rover = new Rover(this.mars, Integer.valueOf(position[0]), Integer.valueOf(position[1]), position[2]);
        return this.rover;
    }

    public void runRover(String commands) {
        for(char cmd : commands.toCharArray()) {
            switch(cmd) {
                case 'L':
                    this.rover.turnLeft();
                    break;
                case 'R':
                    this.rover.turnRight();
                    break;
                case 'M':
                    this.rover.stepForward();
                    break;
                default:
                    break;
            }
        }
    }

    public Position getRoverLocation() {
        return this.rover.getPosition();
    }

    public Direction getRoverDirection() {
        return this.rover.getDirection();
    }

    public static void main(String[] args) {
        MarsRover marsRover = new MarsRover();
        Queue<String> inputs = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Test input:");
        while(scanner.hasNextLine()) {
            inputs.add(scanner.nextLine());
        }
        System.out.println("Expected output:");
        marsRover.buildMars(inputs.remove());
        do {
            marsRover.buildRover(inputs.remove());
            marsRover.runRover(inputs.remove());
            System.out.println(marsRover.getRoverLocation().toString() + " " + marsRover.getRoverDirection().toString());
        } while(!inputs.isEmpty());
    }
}
