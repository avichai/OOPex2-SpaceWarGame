/**
 * This class is about creating the spaceships for the game according to the
 * given input by the user.
 * 
 * @author Avichai
 *
 */
public class SpaceShipFactory {

	private static final int INITIAL_INDEX_IN_ARRAY = 0; // The initial index in the returned array.

	/**
	 * creating the spaceships for the game according to the given input by the
	 * user.
	 * 
	 * @param args
	 *            - the arguments given by the user
	 * @return an array with the created spaceship.
	 */
	public static SpaceShip[] createSpaceShips(String[] args) {
		if (args == null) {
			return null;
		} else {
			SpaceShip[] gameSpaceShips = new SpaceShip[args.length];
			int countHumanSpaceShip = 0;

			int index = INITIAL_INDEX_IN_ARRAY;

			for (String typeShip : args) {
				// creating a human spaceship.
				if (typeShip.equals(Constant.HUMAN_SPACE_SHIP)) {
					gameSpaceShips[index++] = new HumanSpaceShip();
					countHumanSpaceShip++;
				}
				// creating a runner spaceship.
				else if (typeShip.equals(Constant.RUNNER_SPACE_SHIP)) {
					gameSpaceShips[index++] = new RunnerSpaceShip();
				}
				// creating a basher spaceship.
				else if (typeShip.equals(Constant.BASHER_SPACE_SHIP)) {
					gameSpaceShips[index++] = new BasherSpaceShip();
				}
				// creating an aggressive spaceship.
				else if (typeShip.equals(Constant.AGGRESSIVE_SPACE_SHIP)) {
					gameSpaceShips[index++] = new AggressiveSpaceShip();
				}
				// creating a drunker spaceship.
				else if (typeShip.equals(Constant.DRUNKER_SPACE_SHIP)) {
					gameSpaceShips[index++] = new DrunkerSpaceShip();
				}
				// creating a special spaceship.
				else if (typeShip.equals(Constant.SPECIAL_SPACE_SHIP)) {
					gameSpaceShips[index++] = new SpecialSpaceShip();
				}
				// if a unrecognized argument was given.
				else {
					gameSpaceShips = null;
					break;
				}
			}
			// checking if the game does not has exactly one human spaceship.
			if (countHumanSpaceShip != Constant.NUM_OF_HUMAN_SPACESHIP) {
				return null;
			}
			return gameSpaceShips;
		}
	}
}
