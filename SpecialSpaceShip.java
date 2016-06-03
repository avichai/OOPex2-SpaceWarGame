import oop.ex2.SpaceShipPhysics;

/**
 * This is a class for a computer controlled spaceship which flies in circles
 * around itself and fire all the time. This ship has a cheating ability in a
 * way that her energy is always enough to fire.
 * 
 * @author Avichai
 */
public class SpecialSpaceShip extends ComputerControlledSpaceShip {

	/**
	 * overrides. The move of the special spaceship in the game.
	 */
	protected void tryToMove(SpaceShipPhysics mySpaceShipPhysics,
			SpaceShip closestShip, SpaceWars game) {
		if (mySpaceShipPhysics != null && closestShip != null && game != null) {
			mySpaceShipPhysics.move(Constant.DONT_ACCELERATE,
					Constant.LEFT_TURN);
			doYourSpecialMove(game);
		}
	}

	/**
	 * overrides. do the unique move of the special spaceship. - firing all the
	 * time.
	 * 
	 * @param game
	 *            the game object to which this ship belongs.
	 */
	protected void doYourSpecialMove(SpaceWars game) {
		if (game != null) {
			super.fire(game);
			if (super.getCurrentEnergy() <= Constant.CONSUMED_ENERGY_FOR_FIRING) {
				super.resetEnergy();
			}
		}
	}
}
