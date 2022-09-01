package Spring.dao;

import Spring.entity.*;
import java.sql.ResultSet;
import java.sql.Types;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import javax.sql.DataSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("ShopDAO")
public class ShopDAO {
	private DataSource datasource;
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	    
	 public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	 }
	    
	 public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	 }
	    
	 public DataSource getDataSource(){
	    return datasource;
	 }
	 public void setDataSource(DataSource dataSource){
		 this.jdbcTemplate= new JdbcTemplate(dataSource);
	 }
	 
	 public void addShop(Long id, String name, String address, String phoneNumber, String describe, String img) {
		String query = "insert into shop value(?,?,?,?,?,?)";
		jdbcTemplate.update(query, new Object[] {id, name,address, phoneNumber, describe, img});
	 }
	    
	 public List<User> getAllUsers(){
		 String query = "select * from shop";
		 return jdbcTemplate.query(query, new ShopMapper());
	 }
	 
	 public String findNameShopByID(int id) {
		 try {
			String query = "select name from shop where id = ?";
			return jdbcTemplate.queryForObject(query, new Object[] {id}, String.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	 }
	 
	 public String findNameShopByPhonNumber(int phoneNumber) {
		 try {
			String query = "select name from shop where phone_number = ?";
			return jdbcTemplate.queryForObject(query, new Object[] {phoneNumber}, String.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	 } 
	 
	 public Shop findShopByID(int id) {
		 try {
			String query = "select name from shop where id = ?";
			return jdbcTemplate.queryForObject(query, new Object[] {id}, new ShopMapper());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	 }
	 public void deleteShopById(int id) {
		String query = "delete from shop where id = ?";
		jdbcTemplate.update(query, new Object[] {id});
	 }
		 
	 public void updateUser(int id, String name, String phoneNumber, String img) {
		String query = "update shop set name = ?, phone_number = ?, img = ? where id = ?";
		jdbcTemplate.update(query, new Object[] {name, phoneNumber, img, id});
	}
}
class ShopMapper implements RowMapper<User>{
	@Override
	public Shop mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Shop(rs.getLong("id"), rs.getString("name"), rs.getString("address"), rs.getString("phone_number"), rs.getString("describe"), rs.getString("img"));
	}
}