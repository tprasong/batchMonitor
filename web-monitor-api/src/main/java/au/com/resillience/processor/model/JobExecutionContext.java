package au.com.resillience.processor.model;

import java.sql.Clob;

public class JobExecutionContext {
	private Long jobExecutionId;
	private String shortContext;
	private Clob serializedContext;
	private JobExecution jobExecution;
	
	public Long getJobExecutionId() {
		return jobExecutionId;
	}
	public void setJobExecutionId(Long jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}
	public String getShortContext() {
		return shortContext;
	}
	public void setShortContext(String shortContext) {
		this.shortContext = shortContext;
	}
	public Clob getSerializedContext() {
		return serializedContext;
	}
	public void setSerializedContext(Clob serializedContext) {
		this.serializedContext = serializedContext;
	}
	public JobExecution getJobExecution() {
		return jobExecution;
	}
	public void setJobExecution(JobExecution jobExecution) {
		this.jobExecution = jobExecution;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobExecutionId == null) ? 0 : jobExecutionId.hashCode());
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
		JobExecutionContext other = (JobExecutionContext) obj;
		if (jobExecutionId == null) {
			if (other.jobExecutionId != null)
				return false;
		} else if (!jobExecutionId.equals(other.jobExecutionId))
			return false;
		return true;
	}
	
	
}
