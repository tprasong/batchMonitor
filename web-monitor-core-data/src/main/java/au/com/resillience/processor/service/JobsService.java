package au.com.resillience.processor.service;

import java.util.List;

import au.com.resillience.processor.model.JobInstance;

public interface JobsService {
	public JobInstance getJobs(Long id);
	public List<JobInstance> getJobs(String name, String key);
	public List<JobInstance> getJobs();
}
