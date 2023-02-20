/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.EmpPojo;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sharm
 */
public class EmpDao {
    public static boolean addEmp(EmpPojo emp)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into employees values(?,?,?)");
        ps.setInt(1, emp.getEmpNo());
        ps.setString(2, emp.getEmpName());
        ps.setDouble(3, emp.getEmpSal());
        int ans=ps.executeUpdate();
        return ans==1;
    }
    public static EmpPojo findEmpByEmpNo(int eno)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from employees where empno=?");
        ps.setInt(1, eno);
        ResultSet rs=ps.executeQuery();
        EmpPojo emp=null;
        if(rs.next()==true){
            emp=new EmpPojo();
            emp.setEmpNo(rs.getInt(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpSal(rs.getDouble(3));
            
        }
        return emp;
    }
    public static List<EmpPojo> getAllEmployees()throws SQLException{
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select * from employees");
    List<EmpPojo>empList =new ArrayList<>();
    while(rs.next()){
        EmpPojo emp=new EmpPojo();
        emp.setEmpNo(rs.getInt(1));
        emp.setEmpName(rs.getString(2));
        emp.setEmpSal(rs.getDouble(3));
        empList.add(emp);
       }
     return empList;
    }  
}
