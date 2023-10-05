package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeData {
    
    public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> empList = null;
        try{
            tryGetEmployees();
        }   catch (SQLException e){
            System.err.println("Hiba! Az SQL lekérésénél");
            System.err.println(e.getMessage());
        }
        return empList;
    }
    public void tryGetEmployees() throws SQLException{
        Connection con = Mariadb.connectDB();
        String sql = "select * from employees";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        ArrayList<Employee> empList = new ArrayList<>();
        while(res.next()){
            Employee emp = new Employee();
            emp.setId(res.getInt("id"));
            emp.setName(res.getString("name"));
            emp.setCity(res.getString("city"));
            empList.add(emp);
            // System.out.printf(
            //     "%-20s %5.2f\n",
            //     res.getString("name"),
            //     res.getDouble("salary")
            //     );
        }
    }
}
