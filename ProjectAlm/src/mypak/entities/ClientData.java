package mypak.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Client_data")
@XmlRootElement
public class ClientData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int clientid;
	private String name;
	private String address;
	private String email;

	
	
	//@JsonManagedReference
	private String domainList;
	private String description;
	private int revenue;
	private int noOfEmployees;
	private String presence;
	private String CEO;
	private String CTO;
	
	
	//@JsonManagedReference
	private String poc; 
	
	
	//@JsonManagedReference
	private String offices; 
	private String status;
	
	public ClientData()
	{
		
	}
	


	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDomainList() {
		return domainList;
	}

	@Override
	public String toString() {
		return "ClientData [clientid=" + clientid + ", name=" + name
				+ ", address=" + address + ", email=" + email + ", domainList="
				+ domainList + ", description=" + description + ", revenue="
				+ revenue + ", noOfEmployees=" + noOfEmployees + ", presence="
				+ presence + ", CEO=" + CEO + ", CTO=" + CTO + ", poc=" + poc
				+ ", offices=" + offices + ", status=" + status + "]";
	}



	public ClientData(String name, String address, String email,
			String domainList, String description, int revenue,
			int noOfEmployees, String presence, String cEO, String cTO,
			String poc, String offices, String status) {
		super();
		
		this.name = name;
		this.address = address;
		this.email = email;
		this.domainList = domainList;
		this.description = description;
		this.revenue = revenue;
		this.noOfEmployees = noOfEmployees;
		this.presence = presence;
		CEO = cEO;
		CTO = cTO;
		this.poc = poc;
		this.offices = offices;
		this.status = status;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setDomainList(String domainList) {
		this.domainList = domainList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public String getPresence() {
		return presence;
	}

	public void setPresence(String presence) {
		this.presence = presence;
	}

	public String getCEO() {
		return CEO;
	}

	public void setCEO(String cEO) {
		CEO = cEO;
	}

	public String getCTO() {
		return CTO;
	}

	public void setCTO(String cTO) {
		CTO = cTO;
	}

	public String getPoc() {
		return poc;
	}

	public void setPoc(String poc) {
		this.poc = poc;
	}

	public String getOffices() {
		return offices;
	}

	public void setOffices(String offices) {
		this.offices = offices;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
