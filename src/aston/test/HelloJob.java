package aston.test;

import java.util.Date;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	static Logger log = Logger.getLogger(HelloJob.class);
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
	    log.info("Hello World! - " + new Date());
	}
	
}
