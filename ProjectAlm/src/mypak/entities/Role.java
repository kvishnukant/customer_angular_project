package mypak.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="role")
@XmlRootElement
public class Role 
{
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roleid;
	private String name;
	private String description;
	private String status;	
	private String roletype;
	
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role( String name, String description, String status,
			String roletype) {
		super();
		
		this.name = name;
		this.description = description;
		this.status = status;
		this.roletype = roletype;
	}

	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoletype() {
		return roletype;
	}
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", name=" + name + ", description="
				+ description + ", status=" + status + ", roletype=" + roletype
				+ "]";
	}


}
