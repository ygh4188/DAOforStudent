package bean;

public class Student {
	
	private long iD;
	private String name;
	  
	public long getiD() {
		return iD;
	}
	public void setiD(long iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "student [iD=" + iD + ", name=" + name + "]";
	}
	
	
}
