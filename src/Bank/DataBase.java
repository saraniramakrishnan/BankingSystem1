package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

    public class DataBase {
        public DataBase(String text, int text1, int text2) throws Exception {
            String url="jdbc:mysql://localhost:3307/bank";
            String username="root";
            String password="root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established SuccessFully");
            String qu="insert into banks(name,acct_no,amount)values('"+text+"',"+text1+","+text2+");";
            Statement smt=con.createStatement();
            smt.execute(qu);
            con.close();
            System.out.println("Connection Closed..");
        }
    }