package org.andreacaldera.tenniskata;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void shouldHaveNameAndType() {
		Player player = new Player("John", PlayerTypeEnum.FIRST_SERVING);
		Assert.assertEquals("John", player.getName());
		Assert.assertEquals(PlayerTypeEnum.FIRST_SERVING, player.getType());
		Assert.assertEquals(0, player.getPoints());
	}
	
	@Test
	public void shouldRecordPoint() {
		Player player = new Player("John", PlayerTypeEnum.FIRST_SERVING);
		player.point();
		Assert.assertEquals(1, player.getPoints());
		player.point();
		Assert.assertEquals(2, player.getPoints());
	}
	
	

}
