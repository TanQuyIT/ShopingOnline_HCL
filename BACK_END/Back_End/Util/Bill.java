package Back_End.Util;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	Long id;
	
	@Column
	String name;
	
	@Column
	Long id_user;
	
	@Column
	String address;
	
	@Column
	String phoneNumber;
	
	@Column
	Long total;
	
	@Column
	Date date;
	
	@Column
	Integer status;
	
	public Bill() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Bill(Long id, String name, Long id_user, String address, String phoneNumber, Long total, Date date,
			Integer status) {
		this.id = id;
		this.name = name;
		this.id_user = id_user;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.total = total;
		this.date = date;
		this.status = status;
	}

}
