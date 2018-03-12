import java.sql.*;
import java.io.File;
public class Main{
    public static int count=1;
    public static int countF=0;
    public static String fatherpath ="E:";
    public static void main(String[] args){
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/javademo?useSSL=true";
        String user="root";
        String password="";


        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("连接成功");

                fileText filetext=new fileText();
                  filetext.getFiles(new File("E:\\CodeBlocks"),con,fatherpath);

            }
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
            System.out.println("SQLException:" + e.getMessage());

            return;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

	//dev branch test
	

    }
}