package org.andreacaldera.tenniskata;

import java.util.HashMap;
import java.util.Map;

public class Player {

	private String name;
	private PlayerTypeEnum type;
	private int points;
	private Map<Integer, String> scores = new HashMap<Integer, String>();

	public Player(String name, PlayerTypeEnum type) {
		this.name = name;
		this.type = type;
		this.points = 0;
		scores.put(0, "Love");
		scores.put(1, "Fifteen");
		scores.put(2, "Thirty");
		scores.put(3, "Fourty");
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Player))
			return false;
		return ((Player) obj).name.equals(name);
	}

	public PlayerTypeEnum getType() {
		return type;
	}

	public int getPoints() {
		return points;
	}

	public String getScore() {
		return scores.containsKey(points) ? scores.get(points) : "Game";
	}
	
	public void point() {
		points++;
	}
	
	public String winnerName(Player other) {
		return (getPoints() > other.getPoints()) ? getName() : other.getName();
	}

}
