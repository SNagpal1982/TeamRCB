package teamrcbpackage;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

public class TeamRCB 
{
	 @Test
	  public void foreignPlayerCount() throws FileNotFoundException
	  {
		  int foreignPlayerCount = ReadJSONFile.getForeignPlayerCount(AutoConst.TEAM_RCB); 
		  System.out.println("===================================================");
		  System.out.println("Foreign Player Count in Team: " + foreignPlayerCount);
		  System.out.println("===================================================");
		  assertEquals(foreignPlayerCount, AutoConst.EXPECTED_FOREIGN_PLAYER_COUNT);
	  } 
	  @Test
	  public void wicketKeeperCount() throws FileNotFoundException
	  {
		  int wicketKeeperCount = ReadJSONFile.getWicketKeeperCount(AutoConst.TEAM_RCB); 
		  boolean isWicketKeeperCountMatch = false;
		  System.out.println("===================================================");
		  System.out.println("Wicket Keeper Count: " + wicketKeeperCount);
		  System.out.println("===================================================");
		  
		  if (wicketKeeperCount >= 1)
			  isWicketKeeperCountMatch = true;
		  
		 assertEquals(isWicketKeeperCountMatch, true); 
	  } 
}
