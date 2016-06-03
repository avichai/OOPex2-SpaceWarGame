/**
 * This is a class for a computer controlled spaceship witch tries to fly
 * towards other spaceships and shot them.
 * 
 * @author Avichai
 */
public class AggressiveSpaceShip extends ComputerControlledSpaceShip {

	/**
	 * overrides. the aggressive space ship will try to fire when it's too close
	 * to another ship.
	 * 
	 * @param game
	 *            the game object to which this ship belongs.
	 */
	protected void doYourSpecialMove(SpaceWars game) {
		if (game != null) {
			super.fire(game);
		}
	}
}
