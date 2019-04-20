import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExpenseDao {
public static int save(String name,String expense_type,int amount,String remarks,String expense_date){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Expenses(name,expense_type,amount,remarks,expense_date) values(?,?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,expense_type);
		ps.setInt(3,amount);
		ps.setString(4,remarks);
		ps.setString(5,expense_date);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
