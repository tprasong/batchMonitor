package au.com.resillience.processor.dao;

import java.util.List;

import au.com.resillience.processor.model.JobExecutionParams;

public interface JobExecutionParamsDao {
	public List<JobExecutionParams> getList(Long jobExecutionId);
}
