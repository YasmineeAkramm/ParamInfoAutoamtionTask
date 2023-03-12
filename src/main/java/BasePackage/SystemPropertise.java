package BasePackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * SystemPropertise class file scope is to load the data which exists in runPropertise file which includes the run propertise like
 * Browser and entrypoint url
 *
 * @author yakram
 */

public class SystemPropertise {

    private static final Logger logger = Logger.getLogger(SystemPropertise.class.getName());
    private static final Properties SYSTEM_PROPS = loadRunPropertiesFile();

    /**
     * Get the propertise file Stream which contains key, value pair for each attribute exists in runPropertise file
     *
     * @return Object of Propertise file stream contains the data of runPropertise file attribures
     */
    private static Properties loadRunPropertiesFile() {
        Properties systemProps = new Properties();
        try {
            InputStream appConfigIn = SystemPropertise.class.getClassLoader().getResourceAsStream("run.properties");
            if (appConfigIn == null) {
                throw new IllegalArgumentException("run.properties file is not found");
            }
            systemProps.load(appConfigIn);
            systemProps.forEach((key, value) -> logger.info(key + ": " + value));
        } catch (IOException e) {
            logger.error(e);
            throw new IllegalArgumentException(e);
        }
        return systemProps;
    }

    /**
     * Get the browser attribute value from the run.propertise file stream
     *
     * @return browser name
     */

    public static String getSeleniumBrowser() {
        String seleniumBrowser = SYSTEM_PROPS.getProperty("selenium.browser");
        if (seleniumBrowser == null) {
            throw new IllegalArgumentException("selenium.browser configuration is not found in run.properties");
        } else {
            return seleniumBrowser;
        }
    }

    /**
     * Get the url attribute value from the run.propertise file stream
     *
     * @return url value
     */
    public static String getUrl() {
        String serverUrl = SYSTEM_PROPS.getProperty("selenium.server.url");
        if (serverUrl == null) {
            throw new IllegalArgumentException("selenium.server.url configuration not found in run.properties");
        } else {
            return serverUrl;
        }
    }

}
