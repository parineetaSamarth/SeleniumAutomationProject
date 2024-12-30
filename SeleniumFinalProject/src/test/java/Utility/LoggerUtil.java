package Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import step.definition.DemoBlazeAppSteps;

public class LoggerUtil {
	public static Logger getLogger(Class<DemoBlazeAppSteps> class1) {
		Logger log = Logger.getLogger(class1);
		PropertyConfigurator.configure("log4j.properties");
		return log;
	}

}
