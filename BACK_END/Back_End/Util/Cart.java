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
public class Cart {
	@Id
	Long id;
	
	@Column
	Date date;
	
	@Column
	Long id_user;
	
	@Column
	Integer count;
	
	public Cart() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getId_user() {
		return id_user;
	}
	
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public Cart(Long id, Date date, Long id_user, Integer count) {
		this.id = id;
		this.date = date;
		this.id_user = id_user;
		this.count = count;
	}
	
	
} 
