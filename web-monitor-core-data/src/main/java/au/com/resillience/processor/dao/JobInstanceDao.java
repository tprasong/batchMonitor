package au.com.resillience.processor.dao;

import java.util.List;

import au.com.resillience.processor.model.JobInstance;

public interface JobInstanceDao {
	public JobInstance get(Long id);
	public List<JobInstance> getAll();
	public List<JobInstance> getList(String name, String key);
	/*public Boolean update(JobInstance jobInstance);
	public Integer updateList(List<JobInstance> jobInstance);
	public Integer deleteIdList(List<Long> jobInstanceIds);
	public Integer deleteList(List<JobInstance> jobInstance);*/
}
