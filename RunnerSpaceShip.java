import oop.ex2.SpaceShipPhysics;

/**
 * This is a class for a computer controlled spaceship witch tries to fly away
 * from other spaceships.
 * 
 * @author Avichai
 */
public class RunnerSpaceShip extends ComputerControlledSpaceShip {

	/**
	 * overrides. Trying to move the spaceship away from the given angle.
	 * 
	 * @param mySpaceShipPhysics
	 *            - the physical aspect of the space ship.
	 * @param angleToClosestShip
	 *            - the angle this spaceship should turn in order to face the
	 *            position of another ship
	 */
	protected void moveShip(SpaceShipPhysics mySpaceShipPhysics, double angleToClosestShip) {
		if (mySpaceShipPhysics != null) {
			if (angleToClosestShip >= Constant.FACING_THE_ENEMY_DEGREE) {
				mySpaceShipPhysics.move(Constant.ACCELERATE,
						Constant.RIGHT_TURN);
			} else {
				mySpaceShipPhysics.move(Constant.ACCELERATE, Constant.LEFT_TURN);
			}
		}
	}

	/**
	 * overrides. if the runner spaceship is too close to another ship it tries
	 * to teleport.
	 * 
	 * @param game
	 *            the game object to which this ship belongs.
	 */
	protected void doYourSpecialMove(SpaceWars game) {
		if (game != null) {
			super.teleport();
		}
	}
}
