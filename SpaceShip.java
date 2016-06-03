import oop.ex2.*;

/**
 * This is an abstract class for a some spaceship.
 * 
 * @author Avichai
 */
public abstract class SpaceShip {

	private SpaceShipPhysics mySpaceShipPhysics; // The instance physics.
	private int maximalEnergyLevel;
	private int currentEnergyLevel;
	private int healthLevel;
	private boolean shieldOn; // true if the instance has it's shield up.
	private int numRoundsForFiring; // the number of rounds the instance waited before firing.

	/**
	 * creating a new space ship instance with default values for the fields.
	 * (remember this is an abstract class).
	 */
	protected SpaceShip() {
		this.healthLevel = Constant.INITIAL_HEALTH_LEVEL;
		this.maximalEnergyLevel = Constant.INITIAL_MAXIMAL_ENERGY_LEVEL;
		this.currentEnergyLevel = Constant.INITIAL_CURRENT_ENERGY_LEVEL;
		this.shieldOn = Constant.INITIAL_SHIELD_ON;
		this.mySpaceShipPhysics = new SpaceShipPhysics();
		this.numRoundsForFiring = Constant.INITIAL_NUM_ROUNDS_TO_FIRE;
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
			this.numRoundsForFiring += 1;
			if (this.shieldOn) {
				if (this.currentEnergyLevel < Constant.NO_ENERGY) {
					this.shieldOff();
				}
				this.currentEnergyLevel -= Constant.ENERGY_CONSUMED_BY_SHIELD;
			}
			if (this.maximalEnergyLevel > this.currentEnergyLevel) {
				this.currentEnergyLevel += Constant.CHARGING_SPACE_SHIP_PER_ROUND;
			}
		}
	}

	/**
	 * This method is called every time a collision with this ship occurs
	 */
	public void collidedWithAnotherShip() {
		if (this.shieldOn) {
			this.maximalEnergyLevel += Constant.INCREASE_ENERGY_LEVEL_DUE_TO_BASHING_WHITH_SHIELD;
			this.currentEnergyLevel += Constant.INCREASE_ENERGY_LEVEL_DUE_TO_BASHING_WHITH_SHIELD;
		} else {
			handleCollideOrShotAt();
		}
	}

	/*
	 * handle the situation where the spaceship is shot at or colided with
	 * another spaceship without having it's shield on.
	 */
	private void handleCollideOrShotAt() {
		this.healthLevel -= 1;
		this.maximalEnergyLevel -= Constant.DECREASE_ENERGY_LEVEL_DUE_TO_HITTING_OR_FIRED_AT;
		if (this.maximalEnergyLevel < this.currentEnergyLevel) {
			this.currentEnergyLevel = this.maximalEnergyLevel;
		}
	}

	/**
	 * This method is called whenever a ship has died. It resets the ship's
	 * attributes, and starts it at a new random position.
	 */
	public void reset() {
		this.healthLevel = Constant.INITIAL_HEALTH_LEVEL;
		this.maximalEnergyLevel = Constant.INITIAL_MAXIMAL_ENERGY_LEVEL;
		this.currentEnergyLevel = Constant.INITIAL_CURRENT_ENERGY_LEVEL;
		this.shieldOn = Constant.INITIAL_SHIELD_ON;
		this.mySpaceShipPhysics = new SpaceShipPhysics();
		this.numRoundsForFiring = Constant.INITIAL_NUM_ROUNDS_TO_FIRE;
	}

	/**
	 * Checks if this ship is dead.
	 * 
	 * @return true if the ship is dead. false otherwise.
	 */
	public boolean isDead() {
		return this.healthLevel == Constant.NO_LIVES_LEFT;
	}

	/**
	 * Gets the physics object that controls this ship.
	 * 
	 * @return the physics object that controls the ship.
	 */
	public SpaceShipPhysics getPhysics() {
		return this.mySpaceShipPhysics;
	}

	/**
	 * This method is called by the SpaceWars game object when ever this ship
	 * gets hit by a shot.
	 */
	public void gotHit() {
		if (!this.shieldOn) {
			handleCollideOrShotAt();
		}
	}

	/**
	 * Gets the image of this ship. This method should return the image of the
	 * ship with or without the shield. This will be displayed on the GUI at the
	 * end of the round.
	 * 
	 * @return the image of this ship.
	 */
	public abstract java.awt.Image getImage();

	/**
	 * Attempts to fire a shot.
	 * 
	 * @param game
	 *            the game object.
	 */
	public void fire(SpaceWars game) {
		if (game != null) {
			if (this.numRoundsForFiring >= Constant.INITIAL_NUM_ROUNDS_TO_FIRE
					&& this.currentEnergyLevel >= Constant.CONSUMED_ENERGY_FOR_FIRING) {
				game.addShot(mySpaceShipPhysics);
				this.numRoundsForFiring = Constant.JUST_FIRED_A_SHOT;
				this.currentEnergyLevel -= Constant.CONSUMED_ENERGY_FOR_FIRING;
			}
		}
	}

	/**
	 * Attempts to turn on the shield.
	 */
	public void shieldOn() {
		if (this.currentEnergyLevel >= Constant.NO_ENERGY && !this.shieldOn) {
			this.shieldOn = true;
		}
	}

	/**
	 * Turn off the shield.
	 */
	public void shieldOff() {
		this.shieldOn = false;
	}

	/**
	 * Attempts to teleport.
	 */
	public void teleport() {
		if (this.currentEnergyLevel >= Constant.CONSUMED_ENERGY_FOR_TELEPORTING) {
			this.mySpaceShipPhysics = new SpaceShipPhysics();
			this.currentEnergyLevel -= Constant.CONSUMED_ENERGY_FOR_TELEPORTING;
		}
	}

	/**
	 * 
	 * @return true if the spaceship has it's shield on, false otherwise.
	 */
	public boolean getShieldOn() {
		return this.shieldOn;
	}

	/**
	 * 
	 * @return the currentEnergy the ship has.
	 */
	protected int getCurrentEnergy() {
		return this.currentEnergyLevel;
	}

	/**
	 * reset the current energy and maximal energy to the initial values. used
	 * as cheats for this game.- this method is used in the special spaceship
	 * and one should always be careful when using this method.
	 */
	protected void resetEnergy() {
		this.maximalEnergyLevel = Constant.INITIAL_MAXIMAL_ENERGY_LEVEL;
		this.currentEnergyLevel = this.maximalEnergyLevel;
	}
}
