package edu.cmu.cs.cs214.hw4.core;

/**
 * The Shuffle Tile is a special tile that shuffles all the tiles in the rack of
 * the player that activated the tile. Custom tile by Hizal
 * 
 * @author Hizal
 *
 */
public class ShuffleTile implements SpecialTile {

	private int price;
	private String description;
	private String icon;
	private Coord loc;
	private Player owner;

	/**
	 * initizalizes the shuffle tile, its price, description and location
	 * 
	 * @param i
	 *            filepath for the icon to display the tile
	 */
	public ShuffleTile(String i) {
		price = 10;
		description = "Shuffle all the tiles in the player's rack!";
		loc = new Coord(-1, -1);
		icon = i;
	}

	@Override
	public void setLoc(Coord c) {
		loc = c;
	}

	@Override
	public Coord getLoc() {
		return loc;
	}

	@Override
	public String getIcon() {
		return icon;
	}

	@Override
	public String activate(Game game, Move move) {
		game.shufflePlayerRack(game.getTurn().rackToString());
		return "Your tiles have been shuffled, thanks to " + owner.getName()
				+ "!";
	}

	@Override
	public void setOwner(Player p) {
		owner = p;
	}

	@Override
	public Player getOwner() {
		return owner;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getName() {
		return "Shuffle";
	}

	@Override
	public String toString() {
		return getName() + " (" + price + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ShuffleTile))
			return false;
		if (obj == this)
			return true;
		ShuffleTile c = (ShuffleTile) obj;
		return (this.toString().equals(c.toString()));
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
