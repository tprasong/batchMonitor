package au.com.resillience.processor.model;

public enum JobParameterType {
	STRING("string"), DATE("date"), LONG("long"), DOUBLE("double");
	private String name;
	private JobParameterType(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
