package hostelsolutions;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public abstract class DBConnection {
	protected ResultSet rs;
	
	public abstract ResultSetMetaData getMeta();
}
