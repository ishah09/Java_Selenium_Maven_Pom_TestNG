package configReaderDemo;

import configReaderDemo.propertyReader;

public class useCaseDemo extends propertyReader {

	public static void main(String args[]) {
		
		propertyReader objReader = new propertyReader();

		String id = objReader.username;
		String pwd = objReader.password;

		System.out.println("Id=" + id);
		System.out.println("Password=" + pwd);
	}
}
