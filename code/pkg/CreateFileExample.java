package pkg;


import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFileExample {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreateFileExample.class);
	
	public static void main(String[] args) {
		createFile();
	}
	
	public static void createFile() {
		File file = new File("E:/language-concepts/Java-IO1/resource/sample.txt");
		try {
			if (file.createNewFile()) {
				
				LOGGER.info("File is created !!");
			} else {
				LOGGER.info("File is already exist");
			}
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}
}