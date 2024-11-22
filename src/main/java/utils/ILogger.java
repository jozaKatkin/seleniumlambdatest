package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ILogger {
    Logger logger = LogManager.getLogger(ILogger.class);

    default Logger log() {
        return logger;
    }
}
