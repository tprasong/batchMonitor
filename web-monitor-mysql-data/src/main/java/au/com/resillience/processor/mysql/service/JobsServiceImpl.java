package au.com.resillience.processor.mysql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import au.com.resillience.processor.dao.JobInstanceDao;
import au.com.resillience.processor.model.JobInstance;
import au.com.resillience.processor.service.JobsService;

public class JobsServiceImpl implements JobsService {
	private JobInstanceDao jobInstanceDao;

	@Autowired
	public JobsServiceImpl(JobInstanceDao jobInstanceDao){
		this.jobInstanceDao = jobInstanceDao; 
	}
	public JobInstance getJobs(Long id) {
		JobInstance jobInstance = null;
		if(id > 0){
			jobInstance = this.jobInstanceDao.get(id);
		}
		return jobInstance;
	}

	public List<JobInstance> getJobs(String name, String key) {
		List<JobInstance> jobInstanceList = new ArrayList<JobInstance>();
		if(!(StringUtils.isEmpty(name) && StringUtils.isEmpty(key))){
			jobInstanceList = this.jobInstanceDao.getList(name, key);
		}
		return jobInstanceList;
	}

	public List<JobInstance> getJobs() {
		List<JobInstance> jobInstanceList = this.jobInstanceDao.getAll();
		return jobInstanceList;
	}
}
