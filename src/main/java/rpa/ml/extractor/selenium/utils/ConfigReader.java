package rpa.ml.extractor.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigReader {	
	
	private static Logger log = Logger.getLogger(ConfigReader.class);
	private static Properties properties;
	private static String configProperties = "resources\\config.properties";
	
	public ConfigReader() {
		try (InputStream fileInput = new FileInputStream(configProperties)) {
			properties = new Properties();
			properties.load(fileInput);
			log.info("loaded Properties");
		} catch (FileNotFoundException fnfe) {
			log.error("Exception: " + fnfe.getMessage());
		} catch (IOException io) {
			log.error("IOException: " + io.getMessage());
		} catch (Exception e) {
			log.error("Exception: " + e.getMessage());
		}
	}
	
	public static String read(String keyName) {
		if (null == properties) {
			new ConfigReader();
		}
		
		if (null == keyName) {
			log.error("Passed keyName is null");
		}
		
		return null != properties ? properties.getProperty(keyName) : null;
	}
}
