package mypak.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="user")
@XmlRootElement
public class User 
{
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	private String name;
	private String email;
	private String password;
	private String gender;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid, String name, String email, String password,
			String gender) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


}
