package au.com.resillience.processor.mysql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import au.com.resillience.processor.model.JobInstance;

public class JobInstanceRowMapper implements RowMapper<JobInstance> {

	public JobInstance mapRow(ResultSet rs, int rownum) throws SQLException {
		JobInstance jobInstance = new JobInstance();
		jobInstance.setId(rs.getLong("job_instance_id"));
		jobInstance.setKey(rs.getString("job_key"));
		jobInstance.setName(rs.getString("job_name"));
		jobInstance.setVersion(rs.getLong("version"));
		return jobInstance;
	}

}
