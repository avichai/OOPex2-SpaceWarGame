/**
 * Class for all the mutual constants in the game.
 * 
 * @author Avichai
 * 
 */
public class Constant {
	/**
	 * Makes the spaceship turn left when used in the move method of
	 * SpaceShipPhysics class.
	 */
	public static final int LEFT_TURN = 1;
	/**
	 * Makes the spaceship turn right when used in the move method of
	 * SpaceShipPhysics class.
	 */
	public static final int RIGHT_TURN = -1;
	/**
	 * Makes the spaceship stay at the same direction when used in the move
	 * method of SpaceShipPhysics class.
	 */
	public static final int NO_TURN = 0;
	/**
	 * Makes the spaceship accelerate when used in the move method of
	 * SpaceShipPhysics class.
	 */
	public static final boolean ACCELERATE = true;
	/**
	 * Makes the spaceship stay at the same speed when used in the move method
	 * of SpaceShipPhysics class.
	 */
	public static final boolean DONT_ACCELERATE = false;
	/**
	 * The distance decided to be close enough to another spaceship so it should
	 * do something if the angle from her is also close enough.
	 */
	public static final double TO_CLOSE_DISTANCE_TO_NEAREST_SPACE_SHIP = 0.2;
	/**
	 * The angle decided to be close enough to another spaceship so it should do
	 * something if the distance from her is also close enough.
	 */
	public static final double TO_CLOSE_ANGLE_IN_RADIANS_TO_NEAREST_SPACE_SHIP = 0.2;
	/**
	 * The amount of energy a ship need to be able to fire.
	 */
	public static final int CONSUMED_ENERGY_FOR_FIRING = 20;
	/**
	 * a constant means this ship is facing the enemy ship.
	 */
	public static final int FACING_THE_ENEMY_DEGREE = 0;
	/**
	 * user input for wanting a human space ship in game.
	 */
	public static final String HUMAN_SPACE_SHIP = "h";
	/**
	 * user input for wanting a runner space ship in game.
	 */
	public static final String RUNNER_SPACE_SHIP = "r";
	/**
	 * user input for wanting a basher space ship in game.
	 */
	public static final String BASHER_SPACE_SHIP = "b";
	/**
	 * user input for wanting an aggressive space ship in game.
	 */
	public static final String AGGRESSIVE_SPACE_SHIP = "a";
	/**
	 * user input for wanting a drunker space ship in game.
	 */
	public static final String DRUNKER_SPACE_SHIP = "d";
	/**
	 * user input for wanting a special space ship in game.
	 */
	public static final String SPECIAL_SPACE_SHIP = "s";
	/**
	 * the number of human spaceship the game should have.
	 */
	public static final int NUM_OF_HUMAN_SPACESHIP = 1;
	/**
	 * the initial health for a space ship.
	 */
	public static final int INITIAL_HEALTH_LEVEL = 20;
	/**
	 * the initial maximal energy level for a space ship.
	 */
	public static final int INITIAL_MAXIMAL_ENERGY_LEVEL = 200;
	/**
	 * the initial current energy leve for a space ship.
	 */
	public static final int INITIAL_CURRENT_ENERGY_LEVEL = 200;
	/**
	 * the initial shield position for a spaceship.
	 */
	public static final boolean INITIAL_SHIELD_ON = false;
	/**
	 * the initial number of rounds the space ship has waited, the space ship
	 * can fire only when this number reaches 8.
	 */
	public static final int INITIAL_NUM_ROUNDS_TO_FIRE = 8;
	/**
	 * constant for when a ship dose'nt have anymore energy.
	 */
	public static final int NO_ENERGY = 0;
	/**
	 * the energy a space ship consumed for using its shield.
	 */
	public static final int ENERGY_CONSUMED_BY_SHIELD = 3;
	/**
	 * constant for amount of energy a ship is gaining in each round played.
	 */
	public static final int CHARGING_SPACE_SHIP_PER_ROUND = 1;
	/**
	 * The amount of energy a ship is gaining due to bashing with another ship
	 * when its shield on.
	 */
	public static final int INCREASE_ENERGY_LEVEL_DUE_TO_BASHING_WHITH_SHIELD = 20;
	/**
	 * The amount of energy a ship is losing due to bashing with another ship or
	 * fired at when its shield is off.
	 */
	public static final int DECREASE_ENERGY_LEVEL_DUE_TO_HITTING_OR_FIRED_AT = 10;
	/**
	 * when a ship dies it reaches this level of health.
	 */
	public static final int NO_LIVES_LEFT = 0;
	/**
	 * when a ship fire a shot, her number of rounds until it can fire again
	 * reset to this number.
	 */
	public static final int JUST_FIRED_A_SHOT = 0;
	/**
	 * The amount of energy a ship need to be able to teleport.
	 */
	public static final int CONSUMED_ENERGY_FOR_TELEPORTING = 150;

	// don't want anyone to be able to create instance of Constant.
	private Constant() {

	}

}
