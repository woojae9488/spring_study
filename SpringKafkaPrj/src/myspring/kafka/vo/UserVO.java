package myspring.kafka.vo;

public class UserVO {
	private String id;
	private String name;
	private String gender;
	private String city;

	public UserVO() {
	}

	public UserVO(String id, String name, String gender, String city) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", city=" + city + "]";
	}
}
