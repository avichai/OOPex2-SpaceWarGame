import java.util.Random;

/**
 * This is a class for a computer controlled spaceship witch tries to fly
 * towards other spaceships but because the driver is drunk it does random
 * action when she is near other spaceship.
 * 
 * @author Avichai
 */
public class DrunkerSpaceShip extends ComputerControlledSpaceShip {

	// a random instance.
	private Random myRandom;

	private static final int NUM_OF_RANDOM_OPTIONS = 3;
	private static final int TELEPORT_OPTION = 0;
	private static final int SHIELD_OPTION = 1;

	/**
	 * creating a new drunker space ship- a computer controlled space ship
	 * instance.
	 */
	public DrunkerSpaceShip() {
		super();
		myRandom = new Random();
	}

	/**
	 * overrides. the drunker space ship will do something randomly(out of
	 * teleporting, shield up, fire) when it's too close to another ship.
	 * 
	 * @param game
	 *            the game object to which this ship belongs.
	 */
	protected void doYourSpecialMove(SpaceWars game) {
		if (game != null) {
			int myRangomMove = myRandom.nextInt(NUM_OF_RANDOM_OPTIONS);
			if (myRangomMove == TELEPORT_OPTION) {
				super.teleport();
			} else if (myRangomMove == SHIELD_OPTION) {
				super.shieldOn();
			}
			// The random number is 2- the fire option.
			else {
				super.fire(game);
			}
		}
	}

	/**
	 * overrides. the drunker space ship will shield down when it's not too
	 * close to another ship.
	 */
	protected void doCounterToSPecialMove() {
		super.shieldOff();
	}

}
