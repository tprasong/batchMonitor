package au.com.resillience.processor.model;

import java.util.Calendar;

public class JobExecutionParams {
	
	private Long jobExecutionId;
	private JobParameterType typeCode;
	private String keyName;
	private String stringValue;
	private Calendar dateValue;
	private Long longValue;
	private Double doubleValue;
	private Boolean identifying;
	private JobExecution jobExecution;
	public Long getJobExecutionId() {
		return jobExecutionId;
	}
	public void setJobExecutionId(Long jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}
	public JobParameterType getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(JobParameterType typeCode) {
		this.typeCode = typeCode;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	public Calendar getDateValue() {
		return dateValue;
	}
	public void setDateValue(Calendar dateValue) {
		this.dateValue = dateValue;
	}
	public Long getLongValue() {
		return longValue;
	}
	public void setLongValue(Long longValue) {
		this.longValue = longValue;
	}
	public Double getDoubleValue() {
		return doubleValue;
	}
	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}
	public Boolean getIdentifying() {
		return identifying;
	}
	public void setIdentifying(Boolean identifying) {
		this.identifying = identifying;
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
		result = prime * result + ((keyName == null) ? 0 : keyName.hashCode());
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
		JobExecutionParams other = (JobExecutionParams) obj;
		if (jobExecutionId == null) {
			if (other.jobExecutionId != null)
				return false;
		} else if (!jobExecutionId.equals(other.jobExecutionId))
			return false;
		if (keyName == null) {
			if (other.keyName != null)
				return false;
		} else if (!keyName.equals(other.keyName))
			return false;
		return true;
	}
	
	
	
}
