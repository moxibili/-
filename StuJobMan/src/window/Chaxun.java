package window;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.CallableStatement;

import bean.Company;
import bean.Student;
import dao.DAO;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Chaxun extends JPanel {
	
	//String[][] datas = new String[100][7];
	private String[] headers = new String[] { "ְҵ��", "���ͺ�", "��������", "Ƹ������", "���˵�λ" };
	private String[] headers1 = new String[] { "ѧ��", "����", "�Ա�", "��������", "����", "רҵ", "ѧԺ����" ,"�Ƿ��ҵ"};
	private String[] headers2 = new String[] { "ѧ��", "����", "�Ա�", "��������", "����", "רҵ", "ѧԺ����" ,"�Ƿ��ҵ","ְҵ���","ְλ����","��˾����"};
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	/**
	 * Create the panel.
	 */
	
	
	public Chaxun() {
		
		JPanel  j0 = new JPanel();
		JPanel  j1 = new JPanel();
		JPanel  j2 = new JPanel();
		JPanel  j3 = new JPanel();
		 setLayout(new BorderLayout(0, 0));
		 JTabbedPane j = new JTabbedPane(JTabbedPane.TOP);
		 add(j);
		  j.add("��ҵ��",j0);
		  j0.setLayout(new GridLayout(6, 0, 0, 0));
		  
		  JPanel panel_1 = new JPanel();
		  j0.add(panel_1);
		  panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		  
		  JLabel lblNewLabel = new JLabel("��ҵ������");
		  panel_1.add(lblNewLabel);
		  
		  TextField textField = new TextField(10);
		  panel_1.add(textField);
		  
		  JButton btnNewButton_3 = new JButton("��ѯ");
		  btnNewButton_3.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		DAO d = new DAO();
		  		try {
					textField.setText(d.ccgc1());
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}	
		  	}
		  });
		  
		  panel_1.add(btnNewButton_3);
		  
		  JPanel panel_2 = new JPanel();
		  j0.add(panel_2);
		  
		  JLabel lblNewLabel_1 = new JLabel("����ҵ����");
		  panel_2.add(lblNewLabel_1);
		  
		  TextField textField_1 = new TextField(10);
		  panel_2.add(textField_1);
		  
		  JButton btnNewButton_4 = new JButton("��ѯ");
		  panel_2.add(btnNewButton_4);
		  btnNewButton_4.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		DAO d = new DAO();
			  		try {
						textField_1.setText(d.ccgc2());
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}	
			  	}
			  });
		  
		  JPanel panel_3 = new JPanel();
		  j0.add(panel_3);
		  
		  JLabel lblNewLabel_2 = new JLabel("��ҵ����");
		  panel_3.add(lblNewLabel_2);
		  
		  TextField textField_2 = new TextField(10);
		  panel_3.add(textField_2);
		  
		  JButton btnNewButton_5 = new JButton("��ѯ");
		  panel_3.add(btnNewButton_5);
		  btnNewButton_5.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		DAO d = new DAO();
			  		try {
						textField_2.setText(d.ccgc3());
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}	
			  	}
			  });
		  
		  JPanel panel_4 = new JPanel();
		  j0.add(panel_4);
		  
		  JLabel lblNewLabel_3 = new JLabel("��ҵ��");
		  panel_4.add(lblNewLabel_3);
		  
		  TextField textField_3 = new TextField(10);
		  panel_4.add(textField_3);
		  
		  JButton btnNewButton_6 = new JButton("��ѯ");
		  panel_4.add(btnNewButton_6);
		  btnNewButton_6.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		DAO d = new DAO();
			  		try {
			  			 textField_3.setText(d.ccgc5());
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}

			  	}
			  });
		  
		  
		  
		  
		  JPanel panel_5 = new JPanel();
		  j0.add(panel_5);
		  
		  JLabel lblNewLabel_4 = new JLabel("רҵ����");
		  panel_5.add(lblNewLabel_4);
		  
		  JComboBox comboBox = new JComboBox();
		  panel_5.add(comboBox);
		  {
			  DAO dd= new DAO();
			  ResultSet re =  dd.duqu("college.collegename", "college");
			  try {
				while(re.next()) {
					comboBox.addItem(re.getString("collegename"));
					 System.out.println(re.getString("collegename"));
				  }
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		  }
		  
		  
		  JPanel panel = new JPanel();
		  j0.add(panel);
		  
		  JLabel lblNewLabel_5 = new JLabel("רҵ�����ҵ��");
		  panel.add(lblNewLabel_5);
		  
		  TextField textField_4 = new TextField(10);
		  panel.add(textField_4);
		  
		  JButton btnNewButton = new JButton("��ѯ");
		  panel.add(btnNewButton);
		  btnNewButton.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		DAO d = new DAO();
			  		try {
			  			 textField_4.setText(d.ccgc4((String)comboBox.getSelectedItem()));
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}

			  	}
			  });
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	       j.add("�Ѿ�ҵ��Ϣ", j1);
	       j1.setLayout(new BorderLayout(0, 0));
	       
	       JPanel panel_6 = new JPanel();
	       j1.add(panel_6, BorderLayout.NORTH);
	       panel_6.setLayout(new GridLayout(2, 0, 0, 0));
	       
	       JPanel panel_7 = new JPanel();
	       panel_6.add(panel_7);
	       
	       JLabel lblNewLabel_6 = new JLabel("ѧԺ");
	       panel_7.add(lblNewLabel_6);
	       
	       	       JComboBox comboBox_1 = new JComboBox();
	       panel_7.add(comboBox_1);
	       
	       {
				  DAO dd= new DAO();
				  ResultSet re =  dd.duqu("college.collegename", "college");
				  try {
					while(re.next()) {
						comboBox_1.addItem(re.getString("collegename"));
						 System.out.println(re.getString("collegename"));
					  }
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			  }
	       
	       JButton btnNewButton_1 = new JButton("ȷ��");
	       panel_7.add(btnNewButton_1);
	
	       
	       JPanel panel_8 = new JPanel();
	       panel_6.add(panel_8);
	       
	       JLabel lblNewLabel_7 = new JLabel("רҵ");
	       panel_8.add(lblNewLabel_7);
	       	       JComboBox comboBox_2 = new JComboBox();
	       panel_8.add(comboBox_2);
	       
	       {
				  DAO dd= new DAO();
				  ResultSet re =  dd.duqu("major.majorname", "major");
				  try {
					while(re.next()) {
						comboBox_2.addItem(re.getString("majorname"));
						 System.out.println(re.getString("majorname"));
					  }
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			  }
	       

	       
	       
	       JButton btnNewButton_2 = new JButton("ȷ��");
	       panel_8.add(btnNewButton_2);
	       
	       JPanel panel_9 = new JPanel();
	       j1.add(panel_9, BorderLayout.CENTER);
	       
	     
	       table = new JTable();
	       JScrollPane jp2 = new JScrollPane(table);
	       panel_9.add(jp2);
	       jp2.setPreferredSize(new Dimension(600,300));
	      
	       
	      
	       /**
	        * �����ʾ�Ѿ�ҵ��ѧ����Ϣ
	        **/
	      
	       btnNewButton_2.addActionListener(new ActionListener() {
	    	   @Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					DAO d = new DAO();
					String sql = "SELECT * FROM student WHERE majorno ='" +comboBox_2.getSelectedItem()+"' AND collegeno ='" +comboBox_1.getSelectedItem()+"' and isjob='�Ѿ�ҵ'";
					System.out.println(sql);
				      ArrayList<Student> students = d.list(sql);
				       String[][] datas = new String[students.size()][11];
						for (int i = 0; i < students.size(); i++) {
							datas[i][0] = students.get(i).getNo();
							datas[i][1] = students.get(i).getName();
							datas[i][2] = students.get(i).getSex();
							datas[i][3] = students.get(i).getBirth();
							datas[i][4] = students.get(i).getFrom();
							datas[i][5] = students.get(i).getMajorno();
							datas[i][6] = students.get(i).getCollegeno();	
							datas[i][7] = students.get(i).getIsjob();
							datas[i][8] = students.get(i).getJobno();
							System.out.println(students.get(i).getJobno());
							datas[i][9] = students.get(i).getJobname();
							System.out.println(students.get(i).getJobname());
							datas[i][10] = students.get(i).getJobfrom();
							System.out.println(students.get(i).getJobfrom());
						}
						table.setModel(new DefaultTableModel(datas, headers2));
	    	   }
				
				});
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       j.add("δ��ҵ��Ϣ",j2);
	       j2.setLayout(new BorderLayout(0, 0));
	       
	       JPanel panel_6_1 = new JPanel();
	       j2.add(panel_6_1, BorderLayout.NORTH);
	       panel_6_1.setLayout(new GridLayout(2, 0, 0, 0));
	       
	       JPanel panel_7_1 = new JPanel();
	       panel_6_1.add(panel_7_1);
	       
	       JLabel lblNewLabel_6_1 = new JLabel("ѧԺ��");
	       panel_7_1.add(lblNewLabel_6_1);
	       
	       JComboBox comboBox_3 = new JComboBox();
	       panel_7_1.add(comboBox_3);
	       {
				  DAO dd= new DAO();
				  ResultSet re =  dd.duqu("college.collegename", "college");
				  try {
					while(re.next()) {
						comboBox_3.addItem(re.getString("collegename"));
						 System.out.println(re.getString("collegename"));
					  }
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			  }
	       
	       
	       
	       
	       JButton btnNewButton_1_1 = new JButton("ȷ��");
	       panel_7_1.add(btnNewButton_1_1);
	       
	       JPanel panel_8_1 = new JPanel();
	       panel_6_1.add(panel_8_1);
	       
	       JLabel lblNewLabel_7_1 = new JLabel("רҵ��");
	       panel_8_1.add(lblNewLabel_7_1);
	       
	       JComboBox comboBox_4 = new JComboBox();
	       panel_8_1.add(comboBox_4);
	       {
				  DAO dd= new DAO();
				  ResultSet re =  dd.duqu("major.majorname", "major");
				  try {
					while(re.next()) {
						comboBox_4.addItem(re.getString("majorname"));
						 System.out.println(re.getString("majorname"));
					  }
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			  }
	       
	       
	       
	       
	       JButton btnNewButton_2_1 = new JButton("ȷ��");
	       panel_8_1.add(btnNewButton_2_1);
	       
	       JPanel panel_11 = new JPanel();
	       j2.add(panel_11, BorderLayout.CENTER);
	       
	       table_1 = new JTable();
	       //panel_11.add(table_1);
	       
	       
	       
	       //table = new JTable();
	       JScrollPane jp3 = new JScrollPane(table_1);
	       panel_11.add(jp3);
	       jp3.setPreferredSize(new Dimension(600,300));
	      
	       /**
	        * �����ʾδ��ҵ��ѧ����Ϣ
	        **/
	      
	       btnNewButton_2_1.addActionListener(new ActionListener() {
	    	   @Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					DAO d = new DAO();
					String sql = "SELECT * FROM student WHERE majorno ='" +comboBox_4.getSelectedItem()+"' AND collegeno ='" +comboBox_3.getSelectedItem()+"' and isjob='��ҵ'";
					System.out.println(sql);
				      ArrayList<Student> students = d.list(sql);
				       String[][] datas = new String[students.size()][8];
						for (int i = 0; i < students.size(); i++) {
							datas[i][0] = students.get(i).getNo();
							datas[i][1] = students.get(i).getName();
							datas[i][2] = students.get(i).getSex();
							datas[i][3] = students.get(i).getBirth();
							datas[i][4] = students.get(i).getFrom();
							datas[i][5] = students.get(i).getMajorno();
							datas[i][6] = students.get(i).getCollegeno();	
							datas[i][7] = students.get(i).getIsjob();				
						}
						table_1.setModel(new DefaultTableModel(datas, headers1));
	    	   }
				
				});
	       
	       
	       
	       
	       
	       j.add("��˾��Ϣ", j3);
	       j3.setLayout(new BorderLayout(0, 0));
	       
	       Panel panel_10 = new Panel();
	       j3.add(panel_10, BorderLayout.NORTH);
	       
	       JLabel lblNewLabel_8 = new JLabel("��У��˾��Ϣ");
	       panel_10.add(lblNewLabel_8);
	       
	       JPanel panel_12 = new JPanel();
	       j3.add(panel_12, BorderLayout.CENTER);
	       
	       table_2 = new JTable();
	       
	       
	       JScrollPane jp1 = new JScrollPane(table_2);
	     
	       panel_12.add(jp1);
	       
	       String sql = "select * from company where 1=1 ";
	       DAO da2 = new DAO();
	       ArrayList<Company> company = da2.list1(sql);
	       String[][] datas = new String[company.size()][5];
			for (int i = 0; i <company.size(); i++) {
				datas[i][0] = company.get(i).getJobno();
				datas[i][1] =company.get(i).getJobtype();
				datas[i][2] = company.get(i).getNeed();
				datas[i][3] = company.get(i).getInneed();
				datas[i][4] = company.get(i).getJobfrom();
			}
			table_2.setModel(new DefaultTableModel(datas, headers));
	              
	}

}
