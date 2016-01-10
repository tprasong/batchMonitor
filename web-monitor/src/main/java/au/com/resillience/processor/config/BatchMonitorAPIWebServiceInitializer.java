package au.com.resillience.processor.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import Jetty2Log4j2Bridge.Jetty2Log4j2Bridge;

public class BatchMonitorAPIWebServiceInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(javax.servlet.ServletContext servletContext) throws javax.servlet.ServletException {
		super.onStartup(servletContext);
		org.eclipse.jetty.util.log.Log.setLog(new Jetty2Log4j2Bridge("jettyLog"));
	}
	
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { BatchMonitorConfiguration.class };
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
