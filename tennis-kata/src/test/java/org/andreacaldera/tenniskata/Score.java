package org.andreacaldera.tenniskata;

public class Score {

	private final int winPoints = 4;

	private Player playerOne;
	private Player playerTwo;
	private Player servingPlayer;
	
	@SuppressWarnings("unused")
	private Score() {
		
	}

	public Score(String playerOneName, String playerTwoName) {
		playerOne = new Player(playerOneName, PlayerTypeEnum.FIRST_SERVING);
		playerTwo = new Player(playerTwoName, PlayerTypeEnum.FIRST_RECEIVING);
		servingPlayer = playerOne;
	}

	public void playerOneScore() {
		if (!servingPlayer.equals(playerOne)) {
			servingPlayer = playerOne;
		} else if (!isCompleted()) {
			playerOne.point();
		}

	}

	public void playerTwoScore() {
		if (!servingPlayer.equals(playerTwo)) {
			servingPlayer = playerTwo;
		} else if (!isCompleted()) {
			playerTwo.point();
		}
	}

	public int result() {
		return playerOne.getPoints() - playerTwo.getPoints();
	}

	public boolean playerOneWon() {
		return isCompleted() && result() > 0;
	}

	public boolean playerTwoWon() {
		return isCompleted() && result() < 0;
	}

	public boolean isCompleted() {
		if (isAdvantages())
			return Math.abs(playerOne.getPoints() - playerTwo.getPoints()) > 1;
		return (playerOne.getPoints() == winPoints || playerTwo.getPoints() == winPoints);
	}

	private boolean isAdvantages() {
		return (playerOne.getPoints() >= winPoints - 1 && playerTwo.getPoints() >= winPoints - 1);
	}

	private boolean isDraw() {
		return playerOne.getPoints() == playerTwo.getPoints();
	}

	public String toString() {
		if (isAdvantages()) {
			if (isCompleted())
				return playerOne.winnerName(playerTwo) +" wins advantages";
			if (isDraw())
				return "Advantages draw";
			else
				return (playerOne.getPoints() - playerTwo.getPoints() > 0) ? "Advantage "
						+ playerOne.getName()
						: "Advantage " + playerTwo.getName();
		}
		if (playerOne.getPoints() == playerTwo.getPoints())
			return playerTwo.getScore() + " all";
		return playerOne.getScore() + " - " + playerTwo.getScore();
	}

}
