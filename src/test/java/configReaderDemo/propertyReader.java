package configReaderDemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class propertyReader extends globalVariables {

	static Properties prop = new Properties();

	public propertyReader() {
		File file = new File("./config.properties");

		try {
			FileInputStream fileinput = new FileInputStream(file);
			prop.load(fileinput);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// getproperty need parameter as String which defined as in config.properties		
		username = prop.getProperty("id");
		password = prop.getProperty("password");
	}
}
