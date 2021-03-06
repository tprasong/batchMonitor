package au.com.resillience.processor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.resillience.processor.model.JobInstance;
import au.com.resillience.processor.service.JobsService;

@RestController
@RequestMapping("/jobs")
public class JobsRestController {
	
	@Autowired
	private JobsService jobsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<JobInstance> getJobs(@RequestParam(value="id", required=false) Long id, @RequestParam(value="name", required=false) String name, @RequestParam(value="key", required=false) String key){
		List<JobInstance> jobInstanceList = new ArrayList<JobInstance>();
		if(id != null){
			jobInstanceList.add(jobsService.getJobs(id.longValue()));
		}
		else if(name != null || key != null){
			jobInstanceList = jobsService.getJobs(name, key);
		}else{
			jobInstanceList = jobsService.getJobs();
		}
		return jobInstanceList;
	}
}
