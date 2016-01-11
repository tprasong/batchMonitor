package au.com.resillience.processor.dao;


import au.com.resillience.processor.model.JobExecutionContext;

public interface JobExecutionContextDao {
	public JobExecutionContext get(Long jobExecutionId);
}
