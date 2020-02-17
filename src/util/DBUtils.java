package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static String driver;
	private static String url;
	private static String encode;
	private static String user;
	private static String password;
	private static HashMap<String, BasicDataSource> DBPools = new HashMap<String, BasicDataSource>();
	static {
		Properties prop = new Properties();
		InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(is);
			driver = prop.getProperty("jdbc.driver");
			url = prop.getProperty("jdbc.url");
			encode = prop.getProperty("jdbc.encode");
			user = prop.getProperty("jdbc.user");
			password = prop.getProperty("jdbc.password", "");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn(String DBName) throws ClassNotFoundException, SQLException, IOException {
		if (!DBPools.containsKey(DBName)) {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setUrl(url + DBName + encode);
			dataSource.setUsername(user);
			dataSource.setPassword(password);
			DBPools.put(DBName, dataSource);
		}
		Connection conn = DBPools.get(DBName).getConnection();
		return conn;
	}
}
