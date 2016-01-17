package au.com.resillience.processor.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class JobExecution {
	
	private Long id;
	private Long version;
	private Long jobInstanceId;
	private Calendar createTime;
	private Calendar startTime;
	private Calendar endTime;
	private String status;
	private String exitCode;
	private String exitMessage;
	private Calendar lastUpdated;
	private JobInstance jobInstance;
	private JobExecutionContext jobExecutionContext;
	
	private List<JobExecutionParams> jobExecutionParamsList = new ArrayList<JobExecutionParams>();
	private List<StepExecution> stepExecutionList = new ArrayList<StepExecution>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Long getJobInstanceId() {
		return jobInstanceId;
	}
	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public Calendar getEndTime() {
		return endTime;
	}
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExitCode() {
		return exitCode;
	}
	public void setExitCode(String exitCode) {
		this.exitCode = exitCode;
	}
	public String getExitMessage() {
		return exitMessage;
	}
	public void setExitMessage(String exitMessage) {
		this.exitMessage = exitMessage;
	}
	public Calendar getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Calendar lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public JobInstance getJobInstance() {
		return jobInstance;
	}
	public void setJobInstance(JobInstance jobInstance) {
		this.jobInstance = jobInstance;
	}
	public JobExecutionContext getJobExecutionContext() {
		return jobExecutionContext;
	}
	public void setJobExecutionContext(JobExecutionContext jobExecutionContext) {
		this.jobExecutionContext = jobExecutionContext;
	}
	
	public List<JobExecutionParams> getJobExecutionParamsList() {
		return jobExecutionParamsList;
	}
	public void setJobExecutionParamsList(List<JobExecutionParams> jobExecutionParamsList) {
		this.jobExecutionParamsList = jobExecutionParamsList;
	}
	public List<StepExecution> getStepExecutionList() {
		return stepExecutionList;
	}
	public void setStepExecutionList(List<StepExecution> stepExecutionList) {
		this.stepExecutionList = stepExecutionList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobExecution other = (JobExecution) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
