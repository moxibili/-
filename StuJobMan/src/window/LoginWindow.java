/**
 * ��¼����
 */
package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.User;
import dao.UserDAO;

public class LoginWindow extends JFrame {
	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static LoginWindow frame;

	/**
	 * ������½����
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new LoginWindow();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
});
	}

	/**
	 * ��������
	 */
	public LoginWindow() {
		
		setTitle("��¼����");//���ô��ڱ���
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرշ�ʽ
		
		setBounds(100, 100, 450, 300);//����λ�ü���С
		
		JPanel pane = new JPanel();
				
		getContentPane().add(pane, BorderLayout.NORTH);
		
		JLabel labelbt = new JLabel("��Уѧ����ҵ��Ϣ����ϵͳ��½����");
		
		pane.setBackground(Color.yellow);
		
		pane.add(labelbt);
		
		
		
		
		contentPane = new JPanel();//����һ������
		
		
		getContentPane().add(contentPane, BorderLayout.CENTER);
		
		contentPane.setBackground(Color.green);
		
		
		
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//�����������ܾ���߿�Ŀհ�����
		
		//setContentPane(contentPane);//�������������
		
		
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));//���ò���
		
		JLabel label = new JLabel("�û�����");//�û���
		contentPane.add(label);
		
		textField = new JTextField();//�����û����������
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("���룺");//����
		contentPane.add(label_1);
		
		JPasswordField textField_1 = new JPasswordField();//���������
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEchoChar('*') ;//���û�д����������ʱ��ʾ*
		
		JButton button = new JButton("��¼");//��¼��ť
		button.addActionListener(new ActionListener() {//��Ӽ���
			
			public void actionPerformed(ActionEvent e) {
				
				UserDAO dao = new UserDAO();//�½�һ��**����
				
				User user = dao.check(textField.getText(), textField_1.getText());//��֤��¼��������
				
				if(textField.getText()==null) {
					JOptionPane.showMessageDialog(null, "�������û�����","��ʾ��Ϣ", 1);
				}
				
				else if(textField_1.getText() == null) {
					JOptionPane.showMessageDialog(null, "���������룡","��ʾ��Ϣ", 1);
				}
				
				else if(user==null) {//��֤ʧ�ܵ����
					
					JOptionPane.showMessageDialog(null, "�û��������������","��ʾ��Ϣ", 2);
					
				}
				
				else if (user != null) {//��֤�ɹ������
					
					EventQueue.invokeLater(new Runnable() {
						
						public void run() {
							
							try {
								
								Mainjm window = new Mainjm();//����һ��������
								window.go();
								
								//window.MainWindow();
								//window.setVisible(true);//���ô��ڿɼ�
								
							} catch (Exception e) {
								
								System.out.println("�������ȡʧ�ܣ�");
								
								e.printStackTrace();
								
							}
							
						}
						
					});
				
					frame.setVisible(false);//���õ�½���治�ɼ�
					
				}
				
			}
			
		});
		
		contentPane.add(button);
		
		
		JButton button_1 = new JButton("����");
		
		button_1.addActionListener(new ActionListener() {//Ϊ������Ӽ�������������
			
			public void actionPerformed(ActionEvent e) {
			
				textField_1.setText("");//��������
				
				textField.setText("");//��������
				
				
			}
		});
		
		contentPane.add(button_1);
		getRootPane().setDefaultButton(button);
		
	}

}
