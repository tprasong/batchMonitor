package au.com.resillience.processor.rowmapper;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

import javax.persistence.Column;
import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl<T> implements RowMapper<T> {
	private Class<T> genericType;
	public RowMapperImpl(Class<T> genericType){
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
		List<Method> method = Arrays.asList(t.getClass().getMethods());
		method.stream()
			.filter(m -> m.getName().startsWith("set") && m.getParameterCount() == 1)
			.forEach(m -> {
				Column columnAnnotation = m.getAnnotation(Column.class);
				String dbColumnName = columnAnnotation.name();
				Class columnType = m.getParameterTypes()[0];
				try {
					m.invoke(finalT, rs.getObject(dbColumnName, columnType));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		});
		return finalT;
	}


}
