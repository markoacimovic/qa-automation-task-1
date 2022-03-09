package util;

import java.util.logging.Logger;

public class UtilClass {

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void logInfo(String message){
        LOGGER.info(message);
    }
}
