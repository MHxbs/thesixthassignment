import java.io.File;
import java.lang.reflect.Parameter;
import java.sql.*;
public class fileText {
    public static void getFiles(File dir,Connection con,String fatherpath) throws SQLException {
        if (dir.exists()){
            if (dir.isDirectory()){//如果是目录直接存入数据库
                //int fileid=Main.count;
                //int fileFid=Main.countF;
                String name =dir.getName();
               String path=dir.getAbsolutePath();
                long  time=dir.lastModified();
                // insert into file(name, path, time) values('readme.txt', )

                String sql1="INSERT INTO file"+"(name,path,time,fathername) "+"VALUES('"+name+"','"+path+"',"+time+",'"+fatherpath+"')";
               // System.out.println(sql1);
                Statement statement=con.createStatement();
                statement.executeUpdate(sql1);

                File[] files=dir.listFiles();
                for (File file:files){
                    //Main.count=Main.count+1;
                    getFiles(file,con,path);
                }
            }
            else {//如果是文件
                String name1 =dir.getName();
                String path1=dir.getAbsolutePath();
                long time1=dir.lastModified();

                String sql1="INSERT INTO file"+"(name,path,time,fathername) "+"VALUES('"+name1+"','"+path1+"',"+time1+",'"+fatherpath+"')";
                System.out.println(sql1+"1");
                Statement statement=con.createStatement();
                statement.executeUpdate(sql1);
            }
        }
    }


}
