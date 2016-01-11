package au.com.resillience.processor.dao;

import java.util.List;

import au.com.resillience.processor.model.JobExecution;

public interface JobExecutionDao {
	public JobExecution get(Long id);
	public List<JobExecution> getList(Long jobInstanceId);
}
