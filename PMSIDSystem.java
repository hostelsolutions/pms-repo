package hostelsolutions;

import java.util.UUID;


public class PMSIDSystem {
	
	public String returnID(){
		UUID uuid = UUID.randomUUID();
		String randomUUID = uuid.toString();
		return randomUUID;
	}
	
}
