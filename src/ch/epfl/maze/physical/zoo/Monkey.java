package ch.epfl.maze.physical.zoo;

import ch.epfl.maze.physical.Animal;
import ch.epfl.maze.physical.WallFollower;
import ch.epfl.maze.util.Direction;
import ch.epfl.maze.util.Vector2D;

/**
 * Monkey A.I. that puts its hand on the left wall and follows it.
 * 
 */

public class Monkey extends Animal implements WallFollower {

    private Direction _orientation = Direction.UP;

    /**
     * Constructs a monkey with a starting position.
     * 
     * @param position
     *            Starting position of the monkey in the labyrinth
     */

    public Monkey(Vector2D position) {
	super(position);
    }

    /**
     * Constructs a monkey with a starting position.
     * 
     * @param position
     *            Starting position of the monkey in the labyrinth
     */

    public Monkey(Vector2D position, Direction orientation) {
	super(position);
	setOrientation(orientation);
    }

    /*
     * GETTERS AND SETTERS
     */

    public Direction getOrientation() {
	return _orientation;
    }

    public void setOrientation(Direction o) {
	_orientation = o;
    }

    /**
     * Moves according to the relative left wall that the monkey has to follow.
     */

    @Override
    public Direction move(Direction[] choices) {
	Direction choice = followLeftWall(choices, getOrientation());
	setOrientation(computeOrientation(choice, getOrientation()));

	return choice;
    }

    @Override
    public Animal copy() {
	return new Monkey(getPosition(), getOrientation());
    }

    @Override
    public void resetAnimal() {
	super.resetAnimal();
	setOrientation(Direction.UP);
    }
}
