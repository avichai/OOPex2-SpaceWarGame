/**
 * This is a class for a computer controlled spaceship witch tries to bash other
 * spaceships.
 * 
 * @author Avichai
 */
public class BasherSpaceShip extends ComputerControlledSpaceShip {

	/**
	 * overrides. the basher space ship will try to shield up when it's too
	 * close to another ship.
	 * 
	 * @param game
	 *            the game object to which this ship belongs.
	 */
	protected void doYourSpecialMove(SpaceWars game) {
		if (game != null) {
			super.shieldOn();
		}
	}

	/**
	 * overrides. the basher space ship will shield down when it's not too close
	 * to another ship.
	 */
	protected void doCounterToSPecialMove() {
		super.shieldOff();
	}
}
