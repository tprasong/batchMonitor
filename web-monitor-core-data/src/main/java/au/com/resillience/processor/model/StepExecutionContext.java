package au.com.resillience.processor.model;

import java.sql.Clob;

public class StepExecutionContext {
	private Long stepExecutionId;
	private String shortContext;
	private Clob serializedContext;
	private StepExecution stepExecution;
	public Long getStepExecutionId() {
		return stepExecutionId;
	}
	public void setStepExecutionId(Long stepExecutionId) {
		this.stepExecutionId = stepExecutionId;
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
	public StepExecution getStepExecution() {
		return stepExecution;
	}
	public void setStepExecution(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stepExecutionId == null) ? 0 : stepExecutionId.hashCode());
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
		StepExecutionContext other = (StepExecutionContext) obj;
		if (stepExecutionId == null) {
			if (other.stepExecutionId != null)
				return false;
		} else if (!stepExecutionId.equals(other.stepExecutionId))
			return false;
		return true;
	}
	
	
}
