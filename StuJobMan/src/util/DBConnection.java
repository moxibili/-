/**
 * ���ݿ������

 * 
 * 
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection conn = null;
	
	private static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";//mysql��������
	
	private static final String URL = "jdbc:mysql://localhost:3306/jiuyexinxi?useSSL=false&serverTimezone=UTC";//url
	
	private static final String USER = "root";//���ݿ��û���
	
	private static final String PASSWORD = "123456";//���ݿ�����
	
	public static Connection getConnection() {
	try {
			if (conn != null && !conn.isClosed())
					
				return conn;
			
			Class.forName(CLASSNAME);//������������
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);//�������ݿ�
			
			//System.out.println(conn);  ��Ϊnull��������ӳɹ�
			
			return conn;
		} catch (ClassNotFoundException e) {
			
			System.out.println("����������ʧ�ܣ�");
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			System.out.println("�������ݿ�ʧ�ܣ�");
			
			e.printStackTrace();
			
		}
	
		return null;
	}
	/*	public static void main(String[] args) {
			String driver="jdbc:mysql://localhost:3306/studentmanager?useSSL=false&serverTimezone=UTC";
			try {
				Class.forName(CLASSNAME);
				System.out.println("���������ɹ���");
			} catch (ClassNotFoundException e) {
				System.out.println("����������ʧ�ܣ�");
			}
			try {
				Connection con = DriverManager.getConnection(driver,"root","995325");
				System.out.println("�������ݿ�ɹ���");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("�������ݿ�ʧ�ܣ�");
			}
		}*/
}
