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
@Table(name = "item")
public class Item {
	@Id
	Long id;
	
	@Colum
	String name;
	
	@Colum
	Long price;
	
	@Colum
	Integer saled;
	
	@Colum
	String describe;
	
	@Colum
	String img;
	
	@Colum
	Date releaseDate;
	
	@Colum
	Long id_category;
	
	@Colum
	Long id_producer;
	
	@Colum
	Long id_shop;
	
	public Item() {
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
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getSaled() {
		return saled;
	}
	public void setSaled(Integer saled) {
		this.saled = saled;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Long getId_category() {
		return id_category;
	}
	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}
	public Long getId_producer() {
		return id_producer;
	}
	public void setId_producer(Long id_producer) {
		this.id_producer = id_producer;
	}
	public Long getId_shop() {
		return id_shop;
	}
	public void setId_shop(Long id_shop) {
		this.id_shop = id_shop;
	}
	
	public Item(Long id, String name, Long price, Integer saled, String describe, String img, Date releaseDate,
			Long id_category, Long id_producer, Long id_shop) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.saled = saled;
		this.describe = describe;
		this.img = img;
		this.releaseDate = releaseDate;
		this.id_category = id_category;
		this.id_producer = id_producer;
		this.id_shop = id_shop;
	}
	
	
}
