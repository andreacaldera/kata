package org.andreacaldera.tenniskata;


import org.junit.Assert;
import org.junit.Test;

public class ScoreTest {

	@Test
	public void shouldStartGame() {
		Score score = new Score("Player one", "Player two");
		Assert.assertEquals("Love all", score.toString());
		Assert.assertTrue(score.result() == 0);
	}
	
	@Test
	public void shouldPlayerOneLead() {
		Score score = new Score("Player one", "Player two");
		score.playerOneScore();
		Assert.assertEquals("Fifteen - Love", score.toString());
		Assert.assertTrue(score.result() > 0);
		Assert.assertFalse(score.isCompleted());
	}
	
	@Test
	public void shouldChangeServe() {
		Score score = new Score("Player one", "Player two");
		score.playerTwoScore();
		Assert.assertEquals("Love all", score.toString());
	}
	
	@Test
	public void shouldDraw() {
		Score score = new Score("Player one", "Player two");
		score.playerOneScore();
		score.playerTwoScore();
		Assert.assertEquals("Fifteen - Love", score.toString());
		score.playerTwoScore();
		Assert.assertEquals("Fifteen all", score.toString());
		Assert.assertTrue(score.result() == 0);
		Assert.assertFalse(score.isCompleted());
	}
	
	@Test
	public void shouldPlayerTwoLead() {
		Score score = new Score("Player one", "Player two");
		score.playerOneScore();
		score.playerTwoScore();
		score.playerTwoScore();
		score.playerTwoScore();
		Assert.assertEquals("Fifteen - Thirty", score.toString());
		Assert.assertTrue(score.result() < 0);
		Assert.assertFalse(score.isCompleted());
	}
	
	@Test
	public void shouldPlayerTwoWin() {
		Score score = new Score("Player one", "Player two");
		score.playerOneScore();
		score.playerOneScore();
		score.playerTwoScore();
		score.playerTwoScore();
		score.playerTwoScore();
		score.playerTwoScore();
		score.playerTwoScore();
		Assert.assertEquals("Thirty - Game", score.toString());
		Assert.assertTrue(score.playerTwoWon());
		Assert.assertFalse(score.playerOneWon());
	}
	
	@Test
	public void shouldPlayerTwoWinWithAdvantages() {
		Score score = new Score("John", "Michael");
		score.playerOneScore();
		score.playerOneScore();
		score.playerOneScore();
		score.playerTwoScore();
		score.playerTwoScore();
		score.playerTwoScore();
		score.playerTwoScore();
		
		Assert.assertEquals("Advantages draw", score.toString());
		Assert.assertFalse(score.isCompleted());
		Assert.assertFalse(score.playerTwoWon());
		Assert.assertFalse(score.playerOneWon());
		
		score.playerOneScore();
		score.playerOneScore();
		Assert.assertEquals("Advantage John", score.toString());
		
		score.playerTwoScore();
		score.playerTwoScore();
		Assert.assertEquals("Advantages draw", score.toString());
		Assert.assertFalse(score.isCompleted());
		Assert.assertFalse(score.playerTwoWon());
		Assert.assertFalse(score.playerOneWon());
		
		
		score.playerTwoScore();
		Assert.assertEquals("Advantage Michael", score.toString());
		
		score.playerTwoScore();
		Assert.assertEquals("Michael wins advantages", score.toString());
		Assert.assertTrue(score.isCompleted());
		Assert.assertTrue(score.playerTwoWon());
		Assert.assertFalse(score.playerOneWon());
	}

}
