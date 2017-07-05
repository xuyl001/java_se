package lang.reflect;

public class User {
	private int id;
	String nam3;
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("in setId");
		this.id = id;
	}

	public String getNam3() {
		return nam3;
	}

	public void setNam3(String nam3) {
		this.nam3 = nam3;
	}
	
	
}
