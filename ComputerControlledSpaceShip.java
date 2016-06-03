import oop.ex2.GameGUI;
import oop.ex2.SpaceShipPhysics;

/**
 * This is an abstract class for a computer controlled spaceship.
 * 
 * @author Avichai
 *
 */
public abstract class ComputerControlledSpaceShip extends SpaceShip {

	/**
	 * creating a new computer controlled ship. (remember this is an abstract
	 * class).
	 */
	protected ComputerControlledSpaceShip() {
		super();
	}

	/**
	 * Does the actions of this ship for this round. This is called once per
	 * round by the SpaceWars game driver.
	 * 
	 * @param game
	 *            the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {
		if (game != null) {
			super.doAction(game);
			SpaceShip closestShip = findClosestSpaceShip(game);
			SpaceShipPhysics mySpaceShipPhysics = super.getPhysics();
			tryToMove(mySpaceShipPhysics, closestShip, game);
		}
	}

	/**
	 * The move of this spaceship in the game.
	 */
	protected void tryToMove(SpaceShipPhysics mySpaceShipPhysics, SpaceShip closestShip, SpaceWars game) {
		if (mySpaceShipPhysics != null && closestShip != null && game != null) {
			SpaceShipPhysics closestShipPhysics = closestShip.getPhysics();
			double distancFromClosestShip = mySpaceShipPhysics
					.distanceFrom(closestShipPhysics);
			double angleToClosestShip = mySpaceShipPhysics
					.angleTo(closestShipPhysics);
			moveShip(mySpaceShipPhysics, angleToClosestShip);
			if (distancFromClosestShip <= Constant.TO_CLOSE_DISTANCE_TO_NEAREST_SPACE_SHIP
					&& Math.abs(angleToClosestShip) <= Math
							.toDegrees(Constant.TO_CLOSE_ANGLE_IN_RADIANS_TO_NEAREST_SPACE_SHIP)) {
				doYourSpecialMove(game);
			} else {
				doCounterToSPecialMove();
			}
		}
	}

	/**
	 * do the unique move of the specific spaceship if it's close enough to
	 * another spaceship.
	 * 
	 * @param game
	 *            the game object to which this ship belongs.
	 */
	protected abstract void doYourSpecialMove(SpaceWars game);

	/**
	 * do the move of the specific spaceship if it's not close enough to another
	 * spaceship.
	 */
	protected void doCounterToSPecialMove() {

	}

	/*
	 * 
	 * @param game - the instance of the game the is taking place.
	 * 
	 * @return the closest spaceship to 'this' spaceship.
	 */
	private SpaceShip findClosestSpaceShip(SpaceWars game) {
		if (game != null) {
			SpaceShip closestShip = game.getClosestShipTo(this);
			return closestShip;
		}
		return null;
	}

	/**
	 * Trying to move the spaceship towards the given angle.
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
				mySpaceShipPhysics.move(Constant.ACCELERATE, Constant.LEFT_TURN);
			} else {
				mySpaceShipPhysics.move(Constant.ACCELERATE,
						Constant.RIGHT_TURN);
			}
		}

	}

	/**
	 * overrides. Gets the image of this ship- a computer controlled ship. This
	 * method should return the image of the ship with or without the shield.
	 * This will be displayed on the GUI at the end of the round.
	 * 
	 * @return the image of this ship.
	 */
	public java.awt.Image getImage() {
		if (super.getShieldOn()) {
			return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
		} else {
			return GameGUI.ENEMY_SPACESHIP_IMAGE;
		}
	}
}
