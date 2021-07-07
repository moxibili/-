package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.xdevapi.Result;

import bean.Company;
import bean.Posion;
import bean.Student;
import util.DBConnection;

public class DAO {
	private Connection conn = null;
	private Statement st = null;
	
public DAO() {
		
		conn = DBConnection.getConnection();//�������ݿ�
		
		try {
			
			st = conn.createStatement();//������connection����statement����
			
		} catch (SQLException e) {
			
			System.out.println("���ӵ����ݿ�ʧ�ܣ�");
			
			e.printStackTrace();
		}
	}



public void close() {
	
	try {
		
		st.close();
		
		conn.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
	}
}


//���ѧ����Ϣ

public void add(Student stu) {
	String sql = "insert into student values('" + stu.getNo() + "','" + stu.getName() + "','" + stu.getSex()
			+ "','" + stu.getBirth() + "','" + stu.getFrom() + "','" + stu.getMajorno() + "','" + stu.getCollegeno() + "','" + stu.getIsjob() +"','"+stu.getJobno()+"','"+stu.getJobname()+"','"+stu.getJobfrom()+"')";
	String sql1 = "insert into student values('" + stu.getNo() + "','" + stu.getName() + "','" + stu.getSex()
	+ "','" + stu.getBirth() + "','" + stu.getFrom() + "','" + stu.getMajorno() + "','" + stu.getCollegeno() + "','" + stu.getIsjob() +"',Null,Null,Null)";
	
	
	System.out.println("insert into student values('" + stu.getNo() + "','" + stu.getName() + "','" + stu.getSex()
			+ "','" + stu.getBirth() + "','" + stu.getFrom() + "','" + stu.getMajorno() + "','" + stu.getCollegeno() + "','" + stu.getIsjob() +"','"+stu.getJobno()+"','"+stu.getJobname()+"','"+stu.getJobfrom()+"')");
	if(stu.getIsjob()=="��ҵ")
		try {
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "�������Ϣ��ʽ�������ʧ��!","��ʾ��Ϣ", 2);
			//e.printStackTrace();
		}
	else
	try {
		st.executeUpdate(sql);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "�������Ϣ��ʽ�������ʧ��!","��ʾ��Ϣ", 2);
		//e.printStackTrace();
	}
}
//�޸�ѧ����Ϣ
/*public void update(Student stu) {
	String sql = "update student set(no='" + stu.getNo() + "',name='" + stu.getName() + "',sex='" + stu.getSex()
			+ "',birth='" + stu.getBirth() + "',from='" + stu.getFrom() + "',majorno='" + stu.getMajorno() + "',collegeno='" + stu.getCollegeno() + "',isjob='" + stu.getIsjob() +"') where no = "+stu.getNo()+"";
	System.out.println( "update student set(no='" + stu.getNo() + "',name='" + stu.getName() + "',sex='" + stu.getSex()
	+ "',birth='" + stu.getBirth() + "',from='" + stu.getFrom() + "',majorno='" + stu.getMajorno() + "',collegeno='" + stu.getCollegeno() + "',isjob='" + stu.getIsjob() +"') where no = "+stu.getNo()+"");
	try {
		st.executeUpdate(sql);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "�������Ϣ��ʽ�������ʧ��!","��ʾ��Ϣ", 2);
		//e.printStackTrace();
	}
}*/

//ɾ��ѧ����Ϣ
public void delete(Student stu) {
	String sql = "delete from student where no = " + stu.getNo() + "";
	System.out.println("delete from student where no = " + stu.getNo() + "");
	try {
		st.executeUpdate(sql);
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "�������Ϣ��ʽ����ɾ��ʧ��!","��ʾ��Ϣ", 2);
		//e.printStackTrace();
	}
}

//���ְλ��Ϣ
public void add1(Posion po) {
	String sql = "insert into posion values('" + po.getStuno() + "','" + po.getJobno() +"')";
	System.out.println("insert into posion values('" + po.getStuno() + "','" + po.getJobno() +"')");
	
	try {
		st.executeUpdate(sql);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "�������Ϣ��ʽ�������ʧ��!","��ʾ��Ϣ", 2);
		//e.printStackTrace();
	}
}

public void add2(Posion po) throws SQLException {
	String sql = "select * from company where jobno='"+po.getJobno()+"'";
	System.out.println("select * from company where jobno='"+po.getJobno()+"'");
	
	String jobno = null;
	String jobtype = null;
	String need =null;
	String inneed =null;
	String jobfrom =null;
	String isjob="�Ѿ�ҵ";
	
	ResultSet rs = null;
	try {
		 rs = st.executeQuery(sql);
		
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	} 
	
	while (rs.next()) {
		
		 jobno=rs.getString("jobno");
		 jobtype=rs.getString("jobtype");
		 need=rs.getString("need");
		 inneed=rs.getString("inneed");
		 jobfrom=rs.getString("jobfrom");
		 
		
	}
	System.out.println(jobno);
	System.out.println(jobtype);
	System.out.println(need);
	System.out.println(inneed);
	System.out.println(jobfrom);
	String sql1 = "update student set jobno='"+jobno+"',isjob='"+isjob+"',jobtype='"+jobtype+"',jobfrom='"+jobfrom+"' where no='"+po.getStuno()+"'";
	System.out.println("update student set jobno='"+jobno+"',isjob='"+isjob+"',jobtype='"+jobtype+"',jobfrom='"+jobfrom+"'where no='"+po.getStuno()+"'");
	try {
		st.executeUpdate(sql1);
		JOptionPane.showMessageDialog(null, "�޸ľ�ҵ״̬�ɹ���","��ʾ��Ϣ", 2);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "�޸ľ�ҵ״̬ʧ�ܣ������ԣ�","��ʾ��Ϣ", 2);
		//e.printStackTrace();
	}
	rs.close();
	
	
	
	
	
	
	//String sql1 = "update student set jobno="++",jobtype=",++"jobfrom=";
	
}

//��ѯ
public ResultSet duqu(String n,String m) {
	String sql ="select "+ n +" from " + m ;
	System.out.println(sql);
	ResultSet rs = null;
	try {
		 rs = st.executeQuery(sql);
		
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	} 
	
	return rs;
}


//��ѯ1
public ResultSet duqu1(String n,String m,String x,String y) {
	String sql ="select "+ n +" from " + m +" where " + x +" = " + "'"+y+"'";
	System.out.println(sql);
	ResultSet rs = null;
	try {
		 rs = st.executeQuery(sql);
		
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	} 
	
	return rs;
}

//�Ѿ���ҵ��Ϣ
public ResultSet yijiuye(String st1,String st2) {
	ResultSet rs = null;
	try {
		java.sql.CallableStatement proc = conn.prepareCall("{ call yijiuye(?,?) }");
		proc.setString(1,st1);
		proc.setString(2,st2);
		boolean bl = proc.execute();//-----ִ�д洢����
		rs=proc.getResultSet();//----ȡ��һ���������
	} catch (SQLException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}

	return rs;
}


//δ��ҵ��Ϣ
public ResultSet weijiuye() {
	
	
	return null;
}



//�洢���̲�ѯ��������
public String ccgc1() throws SQLException {
	int s =0;
	String s1="";
	java.sql.CallableStatement proc = conn.prepareCall("{ call stuall() }");
	boolean bl = proc.execute();//-----ִ�д洢����
		if	(bl){//----���洢���̳ɹ�ִ���ˣ������н���������ˣ���ôbl����true
		ResultSet rs=proc.getResultSet();//----ȡ��һ���������
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- ������һ��ֵ��
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getInt(1);
	       break;
	       }
	    }
	}
	return s1+s;
}

//��ѯδ��ҵ����
public String ccgc2() throws SQLException {
	int s =0;
	String s1="";
	java.sql.CallableStatement proc = conn.prepareCall("{ call stunojob() }");
	boolean bl = proc.execute();//-----ִ�д洢����
		if	(bl){//----���洢���̳ɹ�ִ���ˣ������н���������ˣ���ôbl����true
		ResultSet rs=proc.getResultSet();//----ȡ��һ���������
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- ������һ��ֵ��
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getInt(1);
	       break;
	       }
	    }
	}
	return s1+s;
}

//��ѯ�Ѿ���ҵ����
public String ccgc3() throws SQLException {
	int s =0;
	String s1="";
	java.sql.CallableStatement proc = conn.prepareCall("{ call stuisjob() }");
	boolean bl = proc.execute();//-----ִ�д洢����
		if	(bl){//----���洢���̳ɹ�ִ���ˣ������н���������ˣ���ôbl����true
		ResultSet rs=proc.getResultSet();//----ȡ��һ���������
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- ������һ��ֵ��
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getInt(1);
	       break;
	       }
	    }
	}
	return s1+s;
}


public String ccgc4(String st1) throws SQLException {
	float s =0;
	float b =0;
	String s1="";
	 System.out.println(st1);
	/*java.sql.CallableStatement proc = conn.prepareCall("{ call dfjiuyelv(?,?) }");
	 proc.setString(1,st1);
	boolean bl = proc.execute();//-----ִ�д洢����
		if	(bl){//----���洢���̳ɹ�ִ���ˣ������н���������ˣ���ôbl����true
		ResultSet rs=proc.getResultSet();//----ȡ��һ���������
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- ������һ��ֵ��
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getFloat(1);
	       break;
	       }
	    }
	}*/
	 String sql ="select count(*) from student where collegeno ='"+st1+"'and isjob='�Ѿ�ҵ'" ;
	 System.out.println("select count(*) from student where collegeno ='"+st1+"'and isjob='�Ѿ�ҵ'");
		System.out.println(sql);
		ResultSet rs = null;
		try {
			 rs = st.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} 
		 while(rs.next()){
		       System.out.println(rs.getInt(1));//--- ������һ��ֵ��
		       if(rs.getInt(1) != 0)
		       {
		       b= rs.getFloat(1);
		       break;
		       }
		    }
		
		 String sql2 ="select count(*) from student where collegeno ='"+st1+"'" ;
		 System.out.println("select count(*) from student where collegeno ='"+st1+"'");
			System.out.println(sql2);
			ResultSet rs1 = null;
			try {
				 rs1 = st.executeQuery(sql2);
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} 
			 while(rs1.next()){
			       System.out.println(rs1.getInt(1));//--- ������һ��ֵ��
			       if(rs1.getInt(1) != 0)
			       {
			       s= rs1.getFloat(1);
			       break;
			       }
			    }
		 
		 
		
	 
	return b/s*100+"%";
	 
	 
}


public String ccgc5() throws SQLException {
	float s =0;
	float b =0;
	String s1="";
	java.sql.CallableStatement proc = conn.prepareCall("{ call stuisjob() }");
	boolean bl = proc.execute();//-----ִ�д洢����
		if	(bl){//----���洢���̳ɹ�ִ���ˣ������н���������ˣ���ôbl����true
		ResultSet rs=proc.getResultSet();//----ȡ��һ���������
	     while(rs.next()){
	       System.out.println(rs.getInt(1));//--- ������һ��ֵ��
	       if(rs.getInt(1) != 0)
	       {
	       s= rs.getFloat(1);
	       break;
	       }
	    }
	}
	java.sql.CallableStatement proc1 = conn.prepareCall("{ call stuall() }");
	boolean b2 = proc1.execute();//-----ִ�д洢����
			if	(b2){//----���洢���̳ɹ�ִ���ˣ������н���������ˣ���ôbl����true
			ResultSet rs=proc1.getResultSet();//----ȡ��һ���������
		     while(rs.next()){
		       System.out.println(rs.getInt(1));//--- ������һ��ֵ��
		       if(rs.getInt(1) != 0)
		       {
		       b= rs.getFloat(1);
		       break;
		       }
		    }
		}
			s=s/b*100;
	return s1+s+"%";
}

 



public void add2(Company com) {
	String sql = "insert into company values('" + com.getJobno() + "','" + com.getJobtype() +"','" + com.getNeed() +"','" + com.getInneed() +"','" + com.getJobfrom() +"')";
	System.out.println( "insert into posion values('" + com.getJobno() + "','" + com.getJobtype() +"','" + com.getNeed() +"','" + com.getInneed() +"','" + com.getJobfrom() +"')");
	
	try {
		st.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, "��ӳɹ���","��ʾ��Ϣ", 2);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "�������Ϣ��ʽ�������ʧ��!","��ʾ��Ϣ", 2);
		//e.printStackTrace();
	}
}



/**
 * ��sql������ѧ������Ϣ
 * 
 */
public ArrayList<Student> list(String sql) {
	
	ArrayList<Student> students = new ArrayList<>();//����һ��ѧ����Ϣ�ļ��ϣ����������ݷ���students��
	
	try {
		
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			
			Student stu = new Student();
			
			stu.setNo(rs.getString("no"));
			
			stu.setName(rs.getString("name"));
			
			stu.setSex(rs.getString("sex"));
			
			stu.setBirth(rs.getString("birth"));
			
			stu.setFrom(rs.getString("from"));
			
			stu.setMajorno(rs.getString("majorno"));
			
			stu.setCollegeno(rs.getString("collegeno"));
			
			stu.setIsjob(rs.getString("isjob"));
			
			stu.setJobno(rs.getString("jobno"));
			
			stu.setJobname(rs.getString("jobtype"));
			
			stu.setJobfrom(rs.getString("jobfrom"));
			
			students.add(stu);
			
		}
		
		rs.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
		
	}
	return students;
}




public ArrayList<Company> list1(String sql) {
	
	ArrayList<Company> company = new ArrayList<>();//����һ��ѧ����Ϣ�ļ��ϣ����������ݷ���company��
	
	try {
		
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			
			Company com = new Company();
			
			com.setJobno(rs.getString("jobno"));
			
			com.setJobtype(rs.getString("jobtype"));
			
			com.setNeed(rs.getString("need"));
			
			com.setInneed(rs.getString("inneed"));
			
			com.setJobfrom(rs.getString("jobfrom"));
			
			
			
			company.add(com);
			
		}
		
		rs.close();
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
		
	}
	return company;
}



}
