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


@Component("userDAO")
public class UserDAO {
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
	    
	 public void addUser(Integer id, String userName, String password, String fullName, String email, String phoneNumber, String address, Integer type) {		
		 String query = "insert into user value(?,?,?,?,?,?,?,?)";
		 jdbcTemplate.update(query, new Object[] {id, userName, password, fullName, email, phoneNumber, address, type});
	}
	 
	 public List<User> getAllUsers(){
		 String query = "select * from user";
		 return jdbcTemplate.query(query, new UserMapper());
	 }
	 
	 public String findFullNameUserByID(int id) {
		 try {
			String query = "select fullname from user where id = ?";
			return jdbcTemplate.queryForObject(query, new Object[] {id}, String.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	 }
	 
	 public String findEmailUserByID(int id) {
		 try {
			String query = "select email from user where id = ?";
			return jdbcTemplate.queryForObject(query, new Object[] {id}, String.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	 }
	 
	 public User findUserByID(int id) {
		 try {
			String query = "select * from user where id = ?";
			return jdbcTemplate.queryForObject(query, new Object[] {id}, new UserMapper());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	 }
	 
	 public void deleteUserById(int id) {
		String query = "delete from user where id = ?";
		jdbcTemplate.update(query, new Object[] {id});
	}
	 
	 public void updateUser(int id, String fullname, String password, String email) {
		String query = "update user set fullname = ?, password = ?, email = ? where id = ?";
		jdbcTemplate.update(query, new Object[] {fullname, password, email, id});
	}
	 
}

class UserMapper implements RowMapper<User>{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
				rs.getString("fullname"), rs.getString("email"),rs.getString("phone_number"),
				rs.getString("address"),rs.getInt("type"));
	}
}