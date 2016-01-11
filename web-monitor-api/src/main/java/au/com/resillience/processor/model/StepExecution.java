package au.com.resillience.processor.model;

import java.util.Calendar;

public class StepExecution {
	private Long id;
	private Long version;
	private String name;
	private Long jobExecutionId;
	private Calendar startTime;
	private Calendar endTime;
	private String status;
	private Long commitCount;
	private Long readCount;
	private Long filterCount;
	private Long writeCount;
	private Long readSkipCount;
	private Long writeSkipCount;
	private Long processSkipCount;
	private Long rollbackCount;
	private String exitCode;
	private String exitMessage;
	private Calendar lastUpdated;
	private JobExecution jobExecution;
	private StepExecutionContext stepExecutionContext;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getJobExecutionId() {
		return jobExecutionId;
	}
	public void setJobExecutionId(Long jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
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
	public Long getCommitCount() {
		return commitCount;
	}
	public void setCommitCount(Long commitCount) {
		this.commitCount = commitCount;
	}
	public Long getReadCount() {
		return readCount;
	}
	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}
	public Long getFilterCount() {
		return filterCount;
	}
	public void setFilterCount(Long filterCount) {
		this.filterCount = filterCount;
	}
	public Long getWriteCount() {
		return writeCount;
	}
	public void setWriteCount(Long writeCount) {
		this.writeCount = writeCount;
	}
	public Long getReadSkipCount() {
		return readSkipCount;
	}
	public void setReadSkipCount(Long readSkipCount) {
		this.readSkipCount = readSkipCount;
	}
	public Long getWriteSkipCount() {
		return writeSkipCount;
	}
	public void setWriteSkipCount(Long writeSkipCount) {
		this.writeSkipCount = writeSkipCount;
	}
	public Long getProcessSkipCount() {
		return processSkipCount;
	}
	public void setProcessSkipCount(Long processSkipCount) {
		this.processSkipCount = processSkipCount;
	}
	public Long getRollbackCount() {
		return rollbackCount;
	}
	public void setRollbackCount(Long rollbackCount) {
		this.rollbackCount = rollbackCount;
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
	public JobExecution getJobExecution() {
		return jobExecution;
	}
	public void setJobExecution(JobExecution jobExecution) {
		this.jobExecution = jobExecution;
	}
	public StepExecutionContext getStepExecutionContext() {
		return stepExecutionContext;
	}
	public void setStepExecutionContext(StepExecutionContext stepExecutionContext) {
		this.stepExecutionContext = stepExecutionContext;
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
		StepExecution other = (StepExecution) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
