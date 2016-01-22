package au.com.resillience.processor.rowmapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Column;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl<T> implements RowMapper<T> {
	private Class<T> genericType;

	public RowMapperImpl(Class<T> genericType) {
		this.genericType = genericType;
	}

	public T mapRow(ResultSet rs, int rownum) throws SQLException {
		T t = null;
		try {
			t = genericType.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final T finalT = t;
		List<Method> methodList = Arrays.asList(t.getClass().getMethods());
		Map<String, Field> fieldMap = Arrays.asList(t.getClass().getDeclaredFields())
				.stream()
				.collect(Collectors.toMap(
						(ff)->ff.getName().replaceFirst(
								ff.getName().substring(0, 1), ff.getName().substring(0, 1).toUpperCase()
								), (f)->f));
		methodList.stream()
		.filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1
				&& fieldMap.containsKey(m.getName().substring(3, m.getName().length())))
		.forEach(m -> {
			Column columnAnnotation = m.getAnnotation(Column.class);
			String dbColumnName = null;
			if(columnAnnotation == null){
				Field field = fieldMap.get(m.getName().substring(3, m.getName().length()));
				columnAnnotation = field.getAnnotation(Column.class);
				dbColumnName = columnAnnotation != null ? columnAnnotation.name() : null;
			}else{
				dbColumnName = columnAnnotation.name();
			}
			if(dbColumnName != null){
				Class<?> columnType = m.getParameterTypes()[0];
				try {
					m.invoke(finalT, rs.getObject(dbColumnName, columnType));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	});
		return finalT;
	}

}
