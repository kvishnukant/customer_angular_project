package mypak.entities;

import java.io.Serializable;

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
@Table(name="groups")
@XmlRootElement
public class Group implements Serializable
{
	
	
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int groupid;
	private String name;
	private String description;
	private String status;
	private String permission1;
	private String permission2;
	
	public Group() {
		super();
	}

	public Group(String name, String description, String status,
			String permission1, String permission2) {
		super();
		
		this.name = name;
		this.description = description;
		this.status = status;
		this.permission1 = permission1;
		this.permission2 = permission2;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
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

	public String getPermission1() {
		return permission1;
	}

	public void setPermission1(String permission1) {
		this.permission1 = permission1;
	}

	public String getPermission2() {
		return permission2;
	}

	public void setPermission2(String permission2) {
		this.permission2 = permission2;
	}

	
	
	
	


}
