import oop.ex2.GameGUI;
import oop.ex2.SpaceShipPhysics;

/**
 * This is a class for a human controlled spaceship.
 * 
 * @author Avichai
 *
 */
public class HumanSpaceShip extends SpaceShip {

	/**
	 * Does the actions of this ship for this round. This is called once per
	 * round by the SpaceWars game driver.
	 * 
	 * @param game
	 *            the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {
		if (game != null) {
			GameGUI myGameGui = game.getGUI();
			tryToTeleport(game, myGameGui);
			move(game, myGameGui);
			tryToActivateOrDiactivateSheild(game, myGameGui);
			tryToFireAShot(game, myGameGui);
			super.doAction(game);
		}
	}

	/*
	 * If the human player press on the teleport key the spaceship tries to
	 * teleport.
	 */
	private void tryToTeleport(SpaceWars game, GameGUI myGameGui) {
		if (game != null && myGameGui != null) {
			if (myGameGui.isTeleportPressed()) {
				teleport();
			}
		}
	}

	/*
	 * The spaceship moves accordingly to the keys pressed by the
	 * user(accelerate or turn).
	 */
	private void move(SpaceWars game, GameGUI myGameGui) {
		SpaceShipPhysics mySpaceShipPhysics = super.getPhysics();
		boolean accelerate;
		int turn;

		if (game != null && myGameGui != null) {
			if (myGameGui.isLeftPressed() && !myGameGui.isRightPressed()) {
				turn = Constant.LEFT_TURN;
			} else if (myGameGui.isRightPressed() && !myGameGui.isLeftPressed()) {
				turn = Constant.RIGHT_TURN;
			} else {
				turn = Constant.NO_TURN;
			}
			if (myGameGui.isUpPressed()) {
				accelerate = Constant.ACCELERATE;
			} else {
				accelerate = Constant.DONT_ACCELERATE;
			}
			mySpaceShipPhysics.move(accelerate, turn);
		}
	}

	private void tryToActivateOrDiactivateSheild(SpaceWars game,
			GameGUI myGameGui) {
		if (game != null && myGameGui != null) {
			if (myGameGui.isShieldsPressed()) {
				super.shieldOn();
			} else {
				super.shieldOff();
			}
		}
	}

	/*
	 * If the human player press on the fire key the spaceship tries to fire.
	 */
	private void tryToFireAShot(SpaceWars game, GameGUI myGameGui) {
		if (game != null && myGameGui != null) {
			if (myGameGui.isShotPressed()) {
				super.fire(game);
			}
		}
	}

	/**
	 * override method. Gets the image of this ship- a human controlled ship.
	 * This method should return the image of the ship with or without the
	 * shield. This will be displayed on the GUI at the end of the round.
	 * 
	 * @return the image of this ship.
	 */
	public java.awt.Image getImage() {
		if (getShieldOn()) {
			return GameGUI.SPACESHIP_IMAGE_SHIELD;
		} else {
			return GameGUI.SPACESHIP_IMAGE;
		}
	}
}
