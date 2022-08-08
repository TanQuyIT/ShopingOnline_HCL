import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO{
    public List<User> getUser() throws SQLException, ClassNotFoundException{
        List<User> userList = new ArrayList<>();

        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM \"user\"";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            User user = new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
            resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
            resultSet.getString(7), resultSet.getInt(8));

            userList.add(user);
        }

        return userList;
    }

    public void insertUser(User user) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getConnection();
        String sql = "Insert into \"user\"(id, username, password, fullName, email, phoneNumber, address, type) Values (?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = conn.createStatement(sql);
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getFullName());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getPhoneNumber());
        preparedStatement.setString(7, user.getAddress());
        preparedStatement.setInt(8, user.getType());

        preparedStatement.executeUpdate();
    }

    public void updateUser(User user) throws ClassNotFoundException, SQLException{
        Connection conn = DBConnection.getConnection();

        String sql = "UPDATE \"user\" SET id = ?, username = ?, password = ?, fullName = ?, email = ?, phoneNumber = ?, address = ?, type = ? WHERE id = ?";

        PreparedStatement preparedStatement = conn.createStatement(sql);

        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getFullName());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getPhoneNumber());
        preparedStatement.setString(7, user.getAddress());
        preparedStatement.setInt(8, user.getType());
        preparedStatement.setLong(9, user.getId());

        preparedStatement.executeQuery();
    }

    public Boolean deleteUser(long id) throws ClassNotFoundException, SQLException {
		Connection conn = DBConnection.getConnection();

		String sql = "DELETE FROM \"user\" WHERE id = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setLong(1, id);
		
		int i = preparedStatement.executeUpdate();

		if (i != 0) {
			return true;
		}
		return false;

	}
}