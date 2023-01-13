package 学生信息管理系统;
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
	//水平box
	private Box center=Box.createVerticalBox();
	//学号的JPanel
	private JPanel idPanel=new JPanel();
	//密码的JPanel
	private JPanel passwordPanel=new JPanel();
	private JLabel lUserId=new JLabel("用户名");
	private JTextField tUserId=new JTextField(15);
	private JLabel lPassword=new JLabel("密   码");
	private JPasswordField tPassword=new JPasswordField(15);
	//按钮的JPanel
	private JPanel buttonPanel=new JPanel();
	private JButton bLogin=new JButton("登录");
	private JButton bCancel=new JButton("取消");
	//设置运行时窗口的大小
	Dimension faceSize=new Dimension(350,150);
	//获得屏幕的大小
	Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	public void init(){
		jf=new JFrame("学生信息管理系统");
		//设置JFrame的名称
		jf.setTitle("登录");
		//将lUserId,tUserId放在idPanel中，idPanel默认水平放置
		idPanel.add(lUserId);
		idPanel.add(tUserId);
		passwordPanel.add(lPassword);
		passwordPanel.add(tPassword);
		center.add(idPanel);
		center.add(passwordPanel);
		buttonPanel.add(bLogin);
		buttonPanel.add(bCancel);
		//登录按钮的监听器
		bLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String userId=tUserId.getText();
				String password=String.valueOf(tPassword.getPassword());
				//开启接受数据的线程
				if(userId.trim().equals("")||userId==null||password.trim().equals("")||password==null){
					JOptionPane.showMessageDialog(jf,"用户名或密码不能为空！","提示",JOptionPane.WARNING_MESSAGE);
				}else{
					if(userId.equals("0")&&password.equals("0")){//真正的账号密码
						new StudentManageView().init();
					}else{
						loginFailure();
					}
				}
			}
			
		});
		//取消按钮的监听器
		bCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		center.add(buttonPanel);
		jf.add(center);
		jf.pack();
		//设置JFame运行时的大小
		jf.setSize(faceSize);
		//设置JFame运行时的位置
		jf.setLocation((int)(screenSize.width-faceSize.getWidth())/2,(int)(screenSize.height-faceSize.getHeight())/2);
		//设置JFrame不可最大化
		jf.setResizable(false);
		//设置JFrame单机X时结束程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置JFrame可见
		jf.setVisible(true);
	}
	public void loginFailure(){
		JOptionPane.showMessageDialog(jf, "用户名或密码输入不正确！","提示",JOptionPane.WARNING_MESSAGE);
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
	//设置表格不可编辑
	public boolean isCellEditable(int rowIndex,int columnIndex){
		return false;
	}
}
class StudentService{
	private Student[] students=new Student[50];
	//添加学生信息
	public void insert(Student s){
		for(int i=0;i<students.length;i++){
			if(students[i]==null){
				students[i]=s;
				System.out.println("添加成功!");
				break;
			}
		}
	}
	//删除学生信息
	public int delete(String userId){
		int flag=0;
		for(int i=0;i<students.length;i++){
			if(students[i]!=null){
				if(students[i].getUserId().equals(userId)){
					students[i]=null;
					System.out.print("删除成功!");
					flag=1;
					break;
				}
			}
		}
		return flag;
	}
	//修改学生信息
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
	//按学号查询
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
	//查询所有学生信息
	public Student[] selectAll(){
		return students;
	}
}
  class StudentManageView {
	//设置上传照片的按钮
	private JButton upload=new JButton("上传照片");
	private JFrame jf=new JFrame("学生信息管理系统");
	Dimension faceSize=new Dimension(800,600);
	private Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	//按学号查询
	private JPanel pSelect=new JPanel();
	private JLabel lSelect=new JLabel("学号");
	private JTextField tSelect=new JTextField(15);
	private JButton bSelect=new JButton("查询");
	//查询结果放在一个JTable
	private MyJTable table;
	private DefaultTableModel tableModel;
	private JScrollPane tableScrollPane;
	private Object[] tableTitle={"学号","姓名","性别","年龄","手机号","QQ","专业"};
	private Object[][]tableData={new Object[]{""}};
	//对学生信息进行管理的添加、删除、修改按钮
	private JPanel buttonPanel=new JPanel();
	private JButton insert=new JButton("添加");
	private JButton delete=new JButton("删除");
	private JButton update=new JButton("修改");
	//单机添加、修改时弹出的对话框
	private JDialog dialog=new JDialog(jf,"学生管理");
	private Box box=Box.createVerticalBox();
	private JPanel pPhoto=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pId=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pName=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pSex=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pAge=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pPhone=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pQq=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel pMajor=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JLabel lPhoto=new JLabel("头 像");
	private JLabel lId=new JLabel("学 号");
	private JLabel lName=new JLabel("姓 名");
	private JLabel lSex=new JLabel("性 别");
	private JLabel lAge=new JLabel("年 龄");
	private JLabel lPhone=new JLabel("手 机");
	private JLabel lQq=new JLabel("Q Q");
	private JLabel lMajor=new JLabel("专 业");
	private ImageIcon icon=new ImageIcon(new ImageIcon("D:/Test/pic.jpg").getImage().getScaledInstance(30,30,3));
	private JLabel tPhoto=new JLabel(icon);
	private JTextField tId=new JTextField(15);
	private JTextField tName=new JTextField(15);
	private ButtonGroup bSex=new ButtonGroup();
	private JRadioButton boy=new JRadioButton("男");
	private JRadioButton girl=new JRadioButton("女");
	private JTextField tAge=new JTextField(15);
	private JTextField tPhone=new JTextField(15);
	private JTextField tQq=new JTextField(15);
	private JTextField tMajor=new JTextField(15);
	private JPanel pButton=new JPanel();
	private JButton confirm=new JButton("确认");
	private JButton cancel=new JButton("取消");
	private StudentService service=new StudentService();
	//用于标记是添加还是修改
	private String id;
	void init(){
		pSelect.add(lSelect);
		pSelect.add(tSelect);
		pSelect.add(bSelect);
		//查询按钮的监听器
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
		//添加按钮的监听器
		insert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//上传照片的监听器
				upload.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						new View().use();
						ImageIcon icon=new ImageIcon(new ImageIcon("fromFileName").getImage().getScaledInstance(30,30,3));
						 JLabel tPhoto=new JLabel(icon);
						 pPhoto.add(tPhoto);
					}
				});
				//如果是添加，则将id=null;
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
		//删除按钮的监听器
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//获得选择删除的行号数组
				int[] selected=table.getSelectedRows();
				//如果selected的长度为0，说明没有选择要删除的
				if(selected.length==0){
					JOptionPane.showMessageDialog(jf, "请选择要删除的信息！","提示",JOptionPane.WARNING_MESSAGE );
				}else{
					//提示是否要进行删除
					int flag=JOptionPane.showConfirmDialog(jf, "确认删除吗？","提示",JOptionPane.WARNING_MESSAGE );
					//如果选择是，则进行删除
					if(flag==JOptionPane.OK_OPTION ){
						for(int i=selected.length-1;i>=0;i--){
							service.delete((String)tableModel.getValueAt(selected[i], 0));
							tableModel.removeRow(selected[i]);
						}
					}
				}
			}
		});
		//修改按钮的监听器
		 update.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		    int row=table.getSelectedRow();
		    //如果要进行修改，就将id=要修改的学号
		    id=String.valueOf(table.getValueAt(row, 0));
		    //设置tId的内容
		    tId.setText(id);
		    //设置tId不可修改
		    tId.setEditable(false);
		    tName.setText(String.valueOf(table.getValueAt(row, 1)));
		    String sex=(String) table.getValueAt(row, 2);
		    //如果性别是"男",则将单选框中的男选中，否则选中女
		    if(sex.equals("男")){
		    	bSex.setSelected(boy.getModel(),true);
		    }else{
		    	bSex.setSelected(girl.getModel(),true);
		    }
		    tAge.setText(String.valueOf(table.getValueAt(row, 3)));
		    tPhone.setText(String.valueOf(table.getValueAt(row, 4)));
		    tQq.setText(String.valueOf(table.getValueAt(row, 5)));
		    tMajor.setText(String.valueOf(table.getValueAt(row, 6)));
		    //设置dialog可见
		    dialog.setVisible(true);
		    }
});
		jf.setLayout(new BorderLayout());
		//设置pSelect在jf的北面
		jf.add(pSelect,BorderLayout.NORTH);
		//设置pSelect在jf的中心
		jf.add(tableScrollPane,BorderLayout.CENTER );
		//设置pSelelct在jf的南面
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
		//确定按钮的监听器
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			Student student=new Student();
			student.setUserId(tId.getText());
			student.setPassword(tId.getText());
			student.setId(tId.getText());
			student.setName(tName.getText());
			String sex=null;
			if(boy.isSelected()){
				sex="男";
			}
			if(girl.isSelected()){
				sex="女";
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
		//取消按钮的监听器
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
			JOptionPane.showMessageDialog(jf,"不存在该学号的学生!","提示",JOptionPane.WARNING_MESSAGE );
		}
}

