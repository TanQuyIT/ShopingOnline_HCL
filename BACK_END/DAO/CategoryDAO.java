import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    
    public List<Category> getCategory() throws SQLException, ClassNotFoundException{
        List<Category> categoryList = new ArrayList<Category>();

        Connection conn = DBConnection.getConnection();

        String sql =  "SELECT * FROM \"category\"";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.execute(sql);

        while (resultSet.next()){
            Category category = new Category(resultSet.getLong(1), resultSet.getString(2));
            categoryList.add(category);
        }
    }

    public void insertCategory(Category category) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getConnection();
        
        String sql = "INSERT INTO \"category\"(id, name) VALUES(?,?)";

		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.setLong(1, category.getId());
		preparedStatement.setString(2, category.getName());

		preparedStatement.executeUpdate();
    }

    public void updateCategory(Category category) throws ClassNotFoundException, SQLException{
		Connection conn = DBConnection.getConnection();

		String sql = "UPDATE \"category\" SET id = ?, name = ? WHERE id = ?";

		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.setLong(1, category.getId());
		preparedStatement.setString(2, category.getName());
		preparedStatement.setLong(3, category.getId());

		preparedStatement.executeUpdate();
	}

    public Boolean deleteCategory(long id) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getConnection();

		String sql = "DELETE FROM \"category\" WHERE id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);

		preparedStatement.setLong(1, id);
		int i = preparedStatement.executeUpdate();

		if (i != 0) {
			return true;
		}
		return false;
	}


}
