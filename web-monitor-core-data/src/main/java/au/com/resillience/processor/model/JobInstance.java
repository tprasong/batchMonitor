package au.com.resillience.processor.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class JobInstance {
	@Column(name="JOB_INSTANCE_ID", nullable=false, precision=20, unique=true)
	private Long id;
	@Column(name="VERSION", nullable=false, precision=20)
	private Long version;
	@Column(name="JOB_NAME", nullable=false, length=100)
	private String name;
	@Column(name="JOB_KEY", nullable=true, length=32)
	private String key;
	
	private List<JobExecution> jobExecutionList = new ArrayList<JobExecution>();
	
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<JobExecution> getJobExecutionList() {
		return jobExecutionList;
	}
	public void setJobExecutionList(List<JobExecution> jobExecutionList) {
		this.jobExecutionList = jobExecutionList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		JobInstance other = (JobInstance) obj;
		
		if(id==null){
			if(other.id != null){
				return false;
			}
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
		}else if(id != other.id){
			return false;
		}
		
		return true;
	}
	
	
}
