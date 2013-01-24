package aston.test;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

/**
 * A HelloScheduler class
 * 
 * Original source: http://quartz-scheduler.org/documentation/quartz-2.x/quick-start
 */
public class HelloScheduler {
	
    public static void main(String[] args) throws InterruptedException {

        try {
            // Get a Scheduler instance from the factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            // Define the job and tie it to our HelloJob class
            JobDetail job = newJob(HelloJob.class)
            		.withIdentity("job1", "group1")
            		.build();
            
            // Trigger the job to run now, and then repeat every 2 seconds
            Trigger trigger = newTrigger()
            		.withIdentity("trigger1", "group1")
            		.startNow()
            		.withSchedule(simpleSchedule()
            				.withIntervalInSeconds(2)
            				.repeatForever())            
            		.build();

            // Schedule the job with the trigger just created
            scheduler.scheduleJob(job, trigger);
            
            // Wait a bit until shutdown
            Thread.sleep(6000);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
