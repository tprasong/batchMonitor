package au.com.resillience.processor.mysql.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import au.com.resillience.processor.dao.JobInstanceDao;
import au.com.resillience.processor.dao.query.SimpleQueryGenerator;
import au.com.resillience.processor.model.JobInstance;
import au.com.resillience.processor.mysql.rowmapper.JobInstanceRowMapper;
import au.com.resillience.processor.rowmapper.RowMapperImpl;

public class JobInstanceDaoImpl implements JobInstanceDao {

	private JdbcTemplate jdbcTemplate;	
	//private String schemaName; 
	//private final String TABLE_NAME = "BATCH_JOB_INSTANCE";
	private String SQL_TEMPLATE;
	@Autowired
	private SimpleQueryGenerator simpleQueryGenerator;
	@Autowired
	public JobInstanceDaoImpl(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@PostConstruct
	public void setSqlTemplate(){
		this.SQL_TEMPLATE = simpleQueryGenerator.getQueryStatement(JobInstance.class);//"SELECT job_instance_id, version, job_name, job_key FROM "+this.schemaName+"."+TABLE_NAME;
	}
	
	public JobInstance get(Long id) {
		String sql =  SQL_TEMPLATE + " WHERE job_instance_id = ?";
		List<JobInstance> jobInstanceList = jdbcTemplate.query(sql, new Object[]{id}, new RowMapperImpl<JobInstance>(JobInstance.class));
		if(jobInstanceList != null && jobInstanceList.size() > 0)
		{
			return jobInstanceList.get(0);
		}
		return null;
	}

	public List<JobInstance> getAll() {
		String sql =  SQL_TEMPLATE;
		List<JobInstance> jobInstanceList = jdbcTemplate.query(sql, new RowMapperImpl<JobInstance>(JobInstance.class));				
		return jobInstanceList;
	}

	public List<JobInstance> getList(String name, String key) {
		String sql;
		List<Object> parameters = new ArrayList<Object>(); 
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(key)){
			sql = SQL_TEMPLATE;
		}else if(!StringUtils.isEmpty(name)){			
			sql = SQL_TEMPLATE + " WHERE job_name = ?";
			parameters.add(name);
		}else if(!StringUtils.isEmpty(key)){
			sql = SQL_TEMPLATE + " WHERE job_key = ?";
			parameters.add(key);
		}else{
			sql = SQL_TEMPLATE + " WHERE job_name = ? and job_key = ?";
			parameters.add(name);
			parameters.add(key);
		}
		List<JobInstance> jobInstanceList = jdbcTemplate.query(sql, parameters.toArray(), new RowMapperImpl<JobInstance>(JobInstance.class));
		return jobInstanceList;
	}

}
