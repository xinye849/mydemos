package xin.yuan.jdbc;

import java.sql.*;

/**
 * @authorknightx
 * @create2019/3/4
 * @since 1.0.0
 */
public class JdbcTest {
   public static  void main(String[] args){
       Connection connection =null;
       PreparedStatement preparedStatement =null;
       ResultSet resultSet = null;

       try {
           //加载数据库驱动
           Class.forName("com.mysql.jdbc.Driver");
           //获取数据库连接
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xiongyuanxin","root","xin123456");
           String sql = "select * from account where name= ?";
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1,"zs");
           resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){

               System.out.println(resultSet.getInt("money"));
           }
       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           if (resultSet!=null){
               try {
                   resultSet.close();
               }catch (SQLException e){
                   e.printStackTrace();
               }
           }
           if (preparedStatement!=null){
               try {
                   preparedStatement.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (connection!=null){
               try {
                   connection.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }
   }

}
