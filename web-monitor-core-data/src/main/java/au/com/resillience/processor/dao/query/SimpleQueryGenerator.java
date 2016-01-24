package au.com.resillience.processor.dao.query;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("simpleQueryGenerator")
public class SimpleQueryGenerator {
	private final Logger logger = LogManager.getLogger(this.getClass().getName());
	private final Marker marker = MarkerManager.getMarker("GENERATE_QUERY");
	private Map<Class<?>, String> queriesCache = new HashMap<Class<?>, String>();
	private final String schemaName;
	@Autowired
	public SimpleQueryGenerator(@Qualifier("schemaName")String schemaName){
		this.schemaName = schemaName;
	}
	public String getQueryStatement(Class<?> model){
		if(queriesCache.containsKey(model)){
			String statement = queriesCache.get(model);
			logger.debug(marker, "Query statement is found for class {} : {}", model.getName(), statement);
			return statement;
		}
		
		
		Table tableAnnotation = model.getAnnotation(Table.class);
		if(tableAnnotation == null || tableAnnotation.name() == null)
		{
			logger.error(marker, "Class {} doesn't not contain table annotation or table name to create a query statement.", model.getName());
			throw new IllegalArgumentException(model.getName()+" doesn't not contain table annotation or table name to create a query statement.");
		}
		
		String statement = "";
		boolean isAColumnPresent = false;
		List<Field> fieldList = Arrays.asList(model.getDeclaredFields());
		for(Field f : fieldList){
			Column columnAnnotation = f.getAnnotation(Column.class);
			if(columnAnnotation != null){
				if(statement.length() == 0){
					statement+= "SELECT " +columnAnnotation.name() + " ";
				}else
				{
					statement += ", " + columnAnnotation.name() + " ";
				}
				isAColumnPresent = true;
			}
		}
		if(!isAColumnPresent){
			logger.error(marker, "Class {} doesn't not contain column name to create a query statement.", model.getName());
			throw new IllegalArgumentException(model.getName()+" doesn't not contain column name to create a query statement.");
		}
		statement += "FROM " + schemaName + "." + tableAnnotation.name();
		logger.debug(marker, "Statement {} is generated", statement);
		synchronized(queriesCache){
			if(!queriesCache.containsKey(model)){
				queriesCache.put(model, statement);
				logger.debug(marker, "Statement {} for {} was added to queriesCache",statement, model.getName());
				
			}
		}
		
		return statement;
	}
}
