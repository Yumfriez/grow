package com.budaev.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:budaevqwerty@gmail.com">Ivan Budayeu</a>
 */
@Component
public class JobCompletionListener extends JobExecutionListenerSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobCompletionListener.class);

	@Override
	public void afterJob(JobExecution jobExecution) {
		final BatchStatus jobExecutionStatus = jobExecution.getStatus();
		if (jobExecutionStatus == BatchStatus.COMPLETED) {
			LOGGER.info(jobExecution.getJobInstance().getJobName() + " job finished");
		} else {
			LOGGER.warn("Job execution status: " + jobExecutionStatus);
		}
	}
}
