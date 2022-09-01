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


@Component("CategogryDAO")
public class CategoryDAO {
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
	    
	public void addCategogry(int id, String name) {
		String query = "insert into categogry value(?,?)";
		jdbcTemplate.update(query, new Object[] {id, name});
	}
	
	public List<Categogry> findAllCategory() {
		String query = "select * from categogry";
		jdbcTemplate.query(query, new CategogryMapper());
	}
	
	public Categogry findCategogryById(int id) {
		try {
			String query = "select * from categogry where id = ?";
			return jdbcTemplate.queryForObject(query, new Object[] {id}, new CategogryMapper());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public Categogry findNameCategogryById(int id) {
		try {
			String query = "select name from categogry where id = ?";
			return jdbcTemplate.queryForObject(query, new Object[] {id}, String.class);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public void deleteCategogryById(int id) {
		String query = "delete from categogry where id = ?";
		jdbcTemplate.update(query, new Object[] {id});
	}
	 
	 public void updateUser(int id, String name) {
		String query = "update categogry set name = ? where id = ?";
		jdbcTemplate.update(query, new Object[] {name, id});
	}
	 
	 
}

class CategogryMapper implements RowMapper<Categogry>{
	@Override
	public Categogry mapRow(ResultSet rs, int rowNum) throws SQLException{
		return new Categogry(rs.getInt("id"), rs.getString("name"));
	}
}
