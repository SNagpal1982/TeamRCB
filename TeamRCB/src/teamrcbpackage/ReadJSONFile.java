package teamrcbpackage;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ReadJSONFile 
{
	public static int getForeignPlayerCount(String jsonFilePath) 
	{
		int foreignPlayerCount = 0;
		try 
		{
			FileReader fileReader = new FileReader(jsonFilePath);
			JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
			System.out.println("Team Name : " + jsonObject.get("name"));
			System.out.println("Team Location : " + jsonObject.get("location"));
			System.out.println("Original Player County : " + AutoConst.ORIGINAL_COUNTRY);
			JsonArray playerDetails = (JsonArray) jsonObject.get("player");
			System.out.println("Total Player : " + playerDetails.size());
			// Read Json file
			/*
			 * System.out.println("===================================================");
			 * System.out.println("Player Details");
			 * System.out.println("===================================================");
			 */
			for (int i =0; i<playerDetails.size(); i++)
			{
//				System.out.println("Player " + (i+1) + ":" + playerDetails.get(i));
				if (!(isPlayerForeigner ((JsonObject) playerDetails.get(i), AutoConst.ORIGINAL_COUNTRY)) )
					foreignPlayerCount = foreignPlayerCount+1;  
			}
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foreignPlayerCount;
	}
	
	public static boolean isPlayerForeigner (JsonObject jsonPlayerElement, String ownCountryName) throws FileNotFoundException 
	{
		String playerCountryName = jsonPlayerElement.get("country").toString();
		 if ( playerCountryName.equalsIgnoreCase(ownCountryName)) 
			 return true;
		 else
			 return false;
	}
	

	public static int getWicketKeeperCount(String jsonFilePath) throws FileNotFoundException {

		int wicketKeeperCount = 0;
		try 
		{
			FileReader fileReader = new FileReader(jsonFilePath);
			JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
			System.out.println("Team Name : " + jsonObject.get("name"));
			System.out.println("Team Location : " + jsonObject.get("location"));
			/*
			 * System.out.println("===================================================");
			 * System.out.println("Player Details");
			 * System.out.println("===================================================");
			 */			JsonArray playerDetails = (JsonArray) jsonObject.get("player");
			System.out.println("Total Player : " + playerDetails.size());
			// Read Json file
			for (int i =0; i<playerDetails.size(); i++)
			{
//				System.out.println("Player " + (i+1) + ":" + playerDetails.get(i));
				if ((isPlayerWicketKeeper ((JsonObject) playerDetails.get(i))) )
					wicketKeeperCount = wicketKeeperCount+1;  
			}
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wicketKeeperCount;
	}
	public static boolean isPlayerWicketKeeper (JsonObject jsonPlayerElement) throws FileNotFoundException 
	{
		String playerRole = jsonPlayerElement.get("role").toString();
		 if ( playerRole.equalsIgnoreCase(AutoConst.PLAYER_ROLE_WICKET_KEEPER)) 
			 return true;
		 else
			 return false;
	}
}