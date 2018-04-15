package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

    private static final Logger log = LogManager.getLogger(Log4jDemo.class.getName());

    public static void main(String[] args) {
        log.error("Error message log");
        log.fatal("Fatal message log");
    }
}