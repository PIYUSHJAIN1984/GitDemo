package beta;
import org.apache.logging.log4j.*;

public class Sec25_174_Log4J {
	
	private static Logger log =LogManager.getLogger(Sec25_174_Log4J.class.getName());
	
	public static void main(String[] args)  {
		log.debug("I am in debug mode");
		log.info("Info");
		log.error("Error log");
		log.fatal("fatal");
	}

}
