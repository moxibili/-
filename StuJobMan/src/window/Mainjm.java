package window;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Mainjm {
    JFrame jFrame = new JFrame("��У��ҵ��Ϣ����ϵͳ������");
    Container contentPane;
    JTabbedPane jTabbedPane;
    int jPanelLabNum = 6;

    JPanel[] jPanels = new JPanel[5];

    public void go(){
        contentPane = jFrame.getContentPane();
        jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(jTabbedPane);

        designPanel();

        jFrame.setDefaultCloseOperation(3);
        jFrame.setVisible(true);
        jFrame.setBounds(500, 50, 700, 550);
    }

    protected void designPanel(){
        //�������
        jPanels[0] = new JPanel();
        jPanels[1] = new JPanel();
        jPanels[2] = new JPanel();
        jPanels[3] = new JPanel();
        jPanels[4] = new JPanel();

        //�������ı���ɫ
       /* jPanels[0].setBackground(Color.RED);
        jPanels[1].setBackground(Color.BLUE);
        jPanels[2].setBackground(Color.GREEN);
        jPanels[3].setBackground(Color.YELLOW);*/

        //��������jTabbedPanel��
        XIugai xiugai = new XIugai();
        Chaxun chaxun = new Chaxun();
        Dengji dengji = new Dengji();
        Dengji1 dengji1 = new Dengji1();
        Chaxun1 chaxun1 = new Chaxun1();
        jTabbedPane.add("����ѧ����Ϣ",xiugai);
        jTabbedPane.add("��ҵ����Ǽ�",  dengji1 );
        jTabbedPane.add("��ҵ��Ϣ�Ǽ�", dengji);
        jTabbedPane.add("��ѯ��ҵ��Ϣ",  chaxun);  
        jTabbedPane.add("��ѯѧ����Ϣ", chaxun1);
        Font font = new Font("���Ĳ���", Font.BOLD, 15);

        //���ñ�ǩҳ���ֵ�����
      jTabbedPane.setFont(font);

 /*       //���ñ�ǩҳ�ı���ɫ
        jTabbedPane.setBackground(Color.yellow);
        
        //���ñ�ǩҳ��ǰ��ɫ
        jTabbedPane.setForegroundAt(0, Color.RED);
        jTabbedPane.setForegroundAt(1, Color.BLUE);
        jTabbedPane.setForegroundAt(2, Color.GREEN);
        jTabbedPane.setForegroundAt(3, Color.YELLOW);*/

        
        //���ñ�ǩ����changeListener,ע���¼�
     /*   jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("���ǵڣ�" + (jTabbedPane.getSelectedIndex() + 1) + "  ����ǩҳ: " );
            }
        });*/
    
    }
}
