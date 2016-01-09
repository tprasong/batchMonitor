package au.com.temp.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	@Override
	public void onStartup(javax.servlet.ServletContext servletContext) throws javax.servlet.ServletException {
		super.onStartup(servletContext);
		org.eclipse.jetty.util.log.Log.setLog();
	}
	
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HelloWorldConfiguration.class };
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
     
    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CORSFilter()};
        return singleton;
    }

}
