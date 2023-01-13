package ѧ����Ϣ����ϵͳ;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class LoginGUI{
	private JFrame jf;
	//ˮƽbox
	private Box center=Box.createVerticalBox();
	//ѧ�ŵ�JPanel
	private JPanel idPanel=new JPanel();
	//�����JPanel
	private JPanel passwordPanel=new JPanel();
	private JLabel lUserId=new JLabel("�û���");
	private JTextField tUserId=new JTextField(15);
	private JLabel lPassword=new JLabel("��   ��");
	private JPasswordField tPassword=new JPasswordField(15);
	//��ť��JPanel
	private JPanel buttonPanel=new JPanel();
	private JButton bLogin=new JButton("��¼");
	private JButton bCancel=new JButton("ȡ��");
	//��������ʱ���ڵĴ�С
	Dimension faceSize=new Dimension(350,150);
	//�����Ļ�Ĵ�С
	Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	public void init(){
		jf=new JFrame("ѧ����Ϣ����ϵͳ");
		//����JFrame������
		jf.setTitle("��¼");
		//��lUserId,tUserId����idPanel�У�idPanelĬ��ˮƽ����
		idPanel.add(lUserId);
		idPanel.add(tUserId);
		passwordPanel.add(lPassword);
		passwordPanel.add(tPassword);
		center.add(idPanel);
		center.add(passwordPanel);
		buttonPanel.add(bLogin);
		buttonPanel.add(bCancel);
		//��¼��ť�ļ�����
		bLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String userId=tUserId.getText();
				String password=String.valueOf(tPassword.getPassword());
				//�����������ݵ��߳�
				if(userId.trim().equals("")||userId==null||password.trim().equals("")||password==null){
					JOptionPane.showMessageDialog(jf,"�û��������벻��Ϊ�գ�","��ʾ",JOptionPane.WARNING_MESSAGE);
				}else{
					if(userId.equals("0")&&password.equals("0")){//�������˺�����
						new StudentManageView().init();
					}else{
						loginFailure();
					}
				}
			}
			
		});
		//ȡ����ť�ļ�����
		bCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		center.add(buttonPanel);
		jf.add(center);
		jf.pack();
		//����JFame����ʱ�Ĵ�С
		jf.setSize(faceSize);
		//����JFame����ʱ��λ��
		jf.setLocation((int)(screenSize.width-faceSize.getWidth())/2,(int)(screenSize.height-faceSize.getHeight())/2);
		//����JFrame�������
		jf.setResizable(false);
		//����JFrame����Xʱ��������
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����JFrame�ɼ�
		jf.setVisible(true);
	}
	public void loginFailure(){
		JOptionPane.showMessageDialog(jf, "�û������������벻��ȷ��","��ʾ",JOptionPane.WARNING_MESSAGE);
	}
	public static void main(String args[])throws Exception{
		new LoginGUI().init();
	}
}
class MyJTable extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3083638370004874364L;
	public MyJTable(TableModel dm){
		super(dm);
	}
	//���ñ�񲻿ɱ༭
	public boolean isCellEditable(int rowIndex,int columnIndex){
		return false;
	}
}
class StudentService{
	private Student[] students=new Student[50];
	//���ѧ����Ϣ
	public void insert(Student s){
		for(int i=0;i<students.length;i++){
			if(students[i]==null){
				students[i]=s;
				System.out.println("��ӳɹ�!");
				break;
			}
		}
	}
	//ɾ��ѧ����Ϣ
	public int delete(String userId){
		int flag=0;
		for(int i=0;i<students.length;i++){
			if(students[i]!=null){
				if(students[i].getUserId().equals(userId)){
					students[i]=null;
					System.out.print("ɾ���ɹ�!");
					flag=1;
					break;
				}
			}
		}
		return flag;
	}
	//�޸�ѧ����Ϣ
	public void update(Student s){
		String userId=s.getUserId();
		for(int i=0;i<students.length;i++){
			if(students[i]!=null){
				if(students[i].getUserId().equals(userId)){
					students[i].setId(s.getId());
					students[i].setName(s.getName());
					students[i].setSex(s.getSex());
					students[i].setAge(s.getAge());
					students[i].setPhone(s.getPhone());
					students[i].setQq(s.getQq());
					students[i].setMajor(s.getMajor());
				}
			}
		}
	}
	//��ѧ�Ų�ѯ
	public Student selectById(String userId){
		for(Student s:students){
			if(s!=null){
				if(s.getUserId().equals(userId)){
					return s;
				}
			}
		}
		return null;
	}
	//��ѯ����ѧ����Ϣ
	public Student[] selectAll(){
		return students;
	}
}
  class StudentManageView {
	//�����ϴ���Ƭ�İ�ť
	private JButton upload=new JButton("�ϴ���Ƭ");
	private JFrame jf=new JFrame("ѧ����Ϣ����ϵͳ");
	Dimension faceSize=new Dimension(800,600);
	private Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	//��ѧ�Ų�ѯ
	private JPanel pSelect=new JPanel();
	private JLabel lSelect=new JLabel("ѧ��");
	private JTextField tSelect=new JTextField(15);
	private JButton bSelect=new JButton("��ѯ");
	//��ѯ�������һ��JTable
	private MyJTable table;
	private DefaultTableModel tableModel;
	private JScrollPane tableScrollPane;
	private Object[] tableTitle={"ѧ��","����","�Ա�","����","�ֻ���","QQ","רҵ"};
	private Object[][]tableData={new Object[]{""}};
	//��ѧ����Ϣ���й������ӡ�ɾ�����޸İ�ť
	private JPanel buttonPanel=new JPanel();
	private JButton insert=new JButton("���");
	private JButton delete=new JButton("ɾ��");
	private JButton update=new JButton("�޸�");
	//������ӡ��޸�ʱ�����ĶԻ���
	private JDialog dialog=new JDialog(jf,"ѧ������");
	private Box box=Box.createVerticalBox();
	private JPanel pPhoto=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pId=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pName=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pSex=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pAge=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pPhone=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pQq=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pMajor=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JLabel lPhoto=new JLabel("ͷ ��");
	private JLabel lId=new JLabel("ѧ ��");
	private JLabel lName=new JLabel("�� ��");
	private JLabel lSex=new JLabel("�� ��");
	private JLabel lAge=new JLabel("�� ��");
	private JLabel lPhone=new JLabel("�� ��");
	private JLabel lQq=new JLabel("Q Q");
	private JLabel lMajor=new JLabel("ר ҵ");
	private ImageIcon icon=new ImageIcon(new ImageIcon("D:/Test/pic.jpg").getImage().getScaledInstance(30,30,3));
	private JLabel tPhoto=new JLabel(icon);
	private JTextField tId=new JTextField(15);
	private JTextField tName=new JTextField(15);
	private ButtonGroup bSex=new ButtonGroup();
	private JRadioButton boy=new JRadioButton("��");
	private JRadioButton girl=new JRadioButton("Ů");
	private JTextField tAge=new JTextField(15);
	private JTextField tPhone=new JTextField(15);
	private JTextField tQq=new JTextField(15);
	private JTextField tMajor=new JTextField(15);
	private JPanel pButton=new JPanel();
	private JButton confirm=new JButton("ȷ��");
	private JButton cancel=new JButton("ȡ��");
	private StudentService service=new StudentService();
	//���ڱ������ӻ����޸�
	private String id;
	void init(){
		pSelect.add(lSelect);
		pSelect.add(tSelect);
		pSelect.add(bSelect);
		//��ѯ��ť�ļ�����
		bSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String userId=tSelect.getText().trim();
				if(userId.equals("")){
					Student[] student=service.selectAll();
					clearTable();
					for(Student s:student){
						insertTable(s);
					}
				}else{
					Student s=service.selectById(userId);
					if(s!=null){
						clearTable();
						insertTable(s);
					}else{
						selectFailure();
					}
				}
			}
		
	});
		//table
		tableModel=new DefaultTableModel(tableData,tableTitle);
		table=new MyJTable(tableModel);
		tableScrollPane=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED  );
		//button
		buttonPanel.add(insert);
		buttonPanel.add(delete);
		buttonPanel.add(update);
		//��Ӱ�ť�ļ�����
		insert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//�ϴ���Ƭ�ļ�����
				upload.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						new View().use();
						ImageIcon icon=new ImageIcon(new ImageIcon("fromFileName").getImage().getScaledInstance(30,30,3));
						 JLabel tPhoto=new JLabel(icon);
						 pPhoto.add(tPhoto);
					}
				});
				//�������ӣ���id=null;
				id=null;
				tId.setText("");
				tId.setEditable(true);
				tName.setText("");
				bSex.clearSelection();
				tAge.setText("");
				tPhone.setText("");
				tQq.setText("");
				tMajor.setText("");
				dialog.setVisible(true);
				
			}
		});
		//ɾ����ť�ļ�����
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//���ѡ��ɾ�����к�����
				int[] selected=table.getSelectedRows();
				//���selected�ĳ���Ϊ0��˵��û��ѡ��Ҫɾ����
				if(selected.length==0){
					JOptionPane.showMessageDialog(jf, "��ѡ��Ҫɾ������Ϣ��","��ʾ",JOptionPane.WARNING_MESSAGE );
				}else{
					//��ʾ�Ƿ�Ҫ����ɾ��
					int flag=JOptionPane.showConfirmDialog(jf, "ȷ��ɾ����","��ʾ",JOptionPane.WARNING_MESSAGE );
					//���ѡ���ǣ������ɾ��
					if(flag==JOptionPane.OK_OPTION ){
						for(int i=selected.length-1;i>=0;i--){
							service.delete((String)tableModel.getValueAt(selected[i], 0));
							tableModel.removeRow(selected[i]);
						}
					}
				}
			}
		});
		//�޸İ�ť�ļ�����
		 update.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		    int row=table.getSelectedRow();
		    //���Ҫ�����޸ģ��ͽ�id=Ҫ�޸ĵ�ѧ��
		    id=String.valueOf(table.getValueAt(row, 0));
		    //����tId������
		    tId.setText(id);
		    //����tId�����޸�
		    tId.setEditable(false);
		    tName.setText(String.valueOf(table.getValueAt(row, 1)));
		    String sex=(String) table.getValueAt(row, 2);
		    //����Ա���"��",�򽫵�ѡ���е���ѡ�У�����ѡ��Ů
		    if(sex.equals("��")){
		    	bSex.setSelected(boy.getModel(),true);
		    }else{
		    	bSex.setSelected(girl.getModel(),true);
		    }
		    tAge.setText(String.valueOf(table.getValueAt(row, 3)));
		    tPhone.setText(String.valueOf(table.getValueAt(row, 4)));
		    tQq.setText(String.valueOf(table.getValueAt(row, 5)));
		    tMajor.setText(String.valueOf(table.getValueAt(row, 6)));
		    //����dialog�ɼ�
		    dialog.setVisible(true);
		    }
});
		jf.setLayout(new BorderLayout());
		//����pSelect��jf�ı���
		jf.add(pSelect,BorderLayout.NORTH);
		//����pSelect��jf������
		jf.add(tableScrollPane,BorderLayout.CENTER );
		//����pSelelct��jf������
		jf.add(buttonPanel,BorderLayout.SOUTH);
		jf.pack();
		jf.setSize(faceSize);
		jf.setLocation((int)(screenSize.width-faceSize.getWidth())/2,(int)(screenSize.height-faceSize.getHeight())/2);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		pPhoto.add(lPhoto);
		pPhoto.add(tPhoto);
		pPhoto.add(upload);
		pId.add(lId);
		pId.add(tId);
		pName.add(lName);
		pName.add(tName);
		pSex.add(lSex);
		bSex.add(boy);
		bSex.add(girl);
		pSex.add(boy);
		pSex.add(girl);
		pAge.add(lAge);
		pAge.add(tAge);
		pPhone.add(lPhone);
		pPhone.add(tPhone);
		pQq.add(lQq);
		pQq.add(tQq);
		pMajor.add(lMajor);
		pMajor.add(tMajor);
		pButton.add(confirm);
		pButton.add(cancel);
		//ȷ����ť�ļ�����
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			Student student=new Student();
			student.setUserId(tId.getText());
			student.setPassword(tId.getText());
			student.setId(tId.getText());
			student.setName(tName.getText());
			String sex=null;
			if(boy.isSelected()){
				sex="��";
			}
			if(girl.isSelected()){
				sex="Ů";
			}
			student.setSex(sex);
			student.setAge(tAge.getText());
			student.setPhone(tPhone.getText());
			student.setQq(tQq.getText());
			student.setMajor(tMajor.getText());
			if(id!=null){
				service.update(student);
			}else{
				service.insert(student);
			}
			dialog.dispose();
			}
		});
		//ȡ����ť�ļ�����
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dialog.dispose();
			}
		});
		box.add(pPhoto);
		box.add(pId);
		box.add(pName);
		box.add(pPhone);
		box.add(pSex);
		box.add(pAge);
		box.add(pPhone);
		box.add(pQq);
		box.add(pMajor);
		box.add(pButton);
		box.add(pButton);
		dialog.add(box);
		dialog.setBounds((int)(screenSize.width-280)/2,(int)(screenSize.height-300)/2,280,350);
	}
		public void insertTable(Student student){
			if(student!=null){
				String[]newCell=new String[7];
				newCell[0]=student.getId();
				newCell[1]=student.getName();
				newCell[2]=student.getSex();
				newCell[3]=student.getAge();
				newCell[4]=student.getPhone();
				newCell[5]=student.getQq();
				newCell[6]=student.getMajor();
				tableModel.addRow(newCell);
			}
		}
		public void clearTable(){
			int rows=tableModel.getRowCount();
			for(int i=rows-1;i>=0;i++){
				tableModel.removeRow(i);
			}
		}
		public void selectFailure(){
			JOptionPane.showMessageDialog(jf,"�����ڸ�ѧ�ŵ�ѧ��!","��ʾ",JOptionPane.WARNING_MESSAGE );
		}
}

