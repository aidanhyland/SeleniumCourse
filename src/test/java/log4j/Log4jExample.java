package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {

    private static final Logger log = LogManager.getLogger(Log4jExample.class.getName());

    public static void main(String[] args) {
        log.trace("Trace message log");
        log.debug("Debug message log");
        log.info("Info message log");
        log.error("Error message log");
        log.fatal("Fatal message log");
    }
}