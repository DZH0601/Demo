package 学生信息管理系统;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
 
public class Main{
    public static void main (String []args){
 
        AFrame f = new AFrame("学生信息管理系统");
 
    }
}
 
 
class AFrame extends JFrame{
    JButton b1;
    JButton b2;
    JTextField t1;
    JTextField t2;
 
    public AFrame(String title){
        super(title);
        this.setLayout(null);
        Panel p = new Panel(); 
        b1 =new JButton("登陆");
        b2 =new JButton("取消");
    
        t1 =new JTextField(25);
        t1.setFont(new Font("宋体",Font.BOLD,25));
 
        t2 =new JPasswordField(25);
        t2.setFont(new Font("宋体",Font.BOLD,25));
 
        JLabel nameLabel = new JLabel("用户名");
        nameLabel.setFont(new Font("宋体",Font.BOLD,25));
        nameLabel.setHorizontalAlignment(JTextField.CENTER);
        JLabel pwdLabel = new JLabel("密码");
        pwdLabel.setFont(new Font("宋体",Font.BOLD,25));
        pwdLabel.setHorizontalAlignment(JTextField.CENTER);
 
        this.setBounds(300,300,1000,500);
        this.add(nameLabel);
        this.add(t1);
        this.add(pwdLabel);
        this.add(t2);
        this.add(b1);
        this.add(b2);
 
        nameLabel.setBounds(100,100,200,50);
        pwdLabel.setBounds(100,200,200,50);
        t1.setBounds(600,100,200,50);
        t2.setBounds(600,200,200,50);
        b1.setBounds(100,300,200,50);
        b2.setBounds(600,300,200,50);
 
        b1.addActionListener (new ResponseButton());
 
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null,"单击确定退出");
                System.exit(0);
            }
        });
 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
 
        getRootPane().setDefaultButton(b1);
        b1.addKeyListener (new KeyAdapter(){
 
			public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
                    AFrame2 f1 = new AFrame2("学生信息管理系统-123456");
                
				}else{
                    System.out.print(t1.getText());
                    JOptionPane.showMessageDialog(null, "账号或者密码错误", "Error.mxy",JOptionPane.ERROR_MESSAGE); 
            
                }
            }
        });
 
    }
 
    public class ResponseButton  implements ActionListener{
        public void actionPerformed(ActionEvent e){
                String str ="123";
                if(t1.getText().equals(str)&&t2.getText().equals(str) ){
 
                    AFrame2 f1 = new AFrame2("学生信息管理系统-123456");
 
                }else{
                    System.out.print(t1.getText());
                    JOptionPane.showMessageDialog(null, "账号或者密码错误", "Error.mxy",JOptionPane.ERROR_MESSAGE); 
            
                }
        }
    }
 
    class AFrame2 extends JFrame{
        JButton b3;
        JButton b4;
        JButton b5;
        JButton b6;
        public AFrame2(String title){
            super(title);
            b3 =new JButton("录入");
            b4 =new JButton("查询");
            b5 =new JButton("修改");
            b6 =new JButton("删除");
    
            this.add(b3);
            this.add(b4);
            this.add(b5);
            this.add(b6);
    
            b3.setBounds(100,80,160,100);
            b4.setBounds(100,290,160,100);
            b5.setBounds(300,80,160,100);
            b6.setBounds(300,290,160,100);
 
            b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AFrame3 f2 = new AFrame3("学生信息管理系统-录入");
            }
        });
            b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AFrame4 f3 = new AFrame4("学生信息管理系统-查询");
            }
        });
            b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AFrame5 f4 = new AFrame5("学生信息管理系统-修改");
                
            }
        });
            b6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AFrame6 f4 = new AFrame6("学生信息管理系统-删除");
                
            }
        });
    
            this.setLayout(null);
            this.setBounds(300,300,600,500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }
 
    class AFrame3 extends JFrame{
        JTextField t3;
        JTextField t4;
        JTextField t5;
        JTextField t6;
        JTextField t7;
        JLabel nameLabel2;
        JLabel studentnumber;
        JLabel major;
        JLabel age;
        JLabel sex;
        JButton b7;
        JButton b8;
        JLabel l1;
        public AFrame3(String title){
            super(title);
            this.setLayout(null);
 
            l1 = new JLabel("录入系统");
            l1.setForeground(Color.gray);
            l1.setFont(new Font("宋体",Font.BOLD,20));
            l1.setHorizontalAlignment(JTextField.CENTER);
            nameLabel2 =new JLabel("姓名：");
            nameLabel2.setFont(new Font("宋体",Font.BOLD,25));
            nameLabel2.setHorizontalAlignment(JTextField.CENTER);
            major =new JLabel("专业：");
            major.setFont(new Font("宋体",Font.BOLD,25));
            major.setHorizontalAlignment(JTextField.CENTER);
            age =new JLabel("年龄：");
            age.setFont(new Font("宋体",Font.BOLD,25));
            age.setHorizontalAlignment(JTextField.CENTER);
            sex =new JLabel("性别：");
            sex.setFont(new Font("宋体",Font.BOLD,25));
            sex.setHorizontalAlignment(JTextField.CENTER);
            studentnumber = new JLabel("学号：");
            studentnumber.setFont(new Font("宋体",Font.BOLD,25));
            studentnumber.setHorizontalAlignment(JTextField.CENTER);
 
            t3 =new JTextField(25);
            t3.setFont(new Font("宋体",Font.BOLD,25));
            t4 =new JTextField(25);
            t4.setFont(new Font("宋体",Font.BOLD,25));
            t5 =new JTextField(25);
            t5.setFont(new Font("宋体",Font.BOLD,25));
            t6 =new JTextField(25);
            t6.setFont(new Font("宋体",Font.BOLD,25));
            t7 =new JTextField(25);
            t7.setFont(new Font("宋体",Font.BOLD,25));
 
            b7 = new JButton("录入");
            b8 = new JButton("取消");
 
            b8.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null,"单击确定退出");
                    System.exit(0);
                }
            });
    
            this.add(t3);
            this.add(t4);
            this.add(t5);
            this.add(t6);
            this.add(t7);
            this.add(nameLabel2);
            this.add(major);
            this.add(age);
            this.add(sex);
            this.add(studentnumber);
            this.add(l1);
            this.add(b8);
            this.add(b7);
 
    
            t3.setBounds(180,40,180,50);
            t4.setBounds(180,100,180,50);
            t5.setBounds(180,160,180,50);
            t6.setBounds(180,220,180,50);
            t7.setBounds(180,280,180,50);
            nameLabel2.setBounds(0,40,180,50);
            age.setBounds(0,100,180,50);
            sex.setBounds(0,160,180,50);
            studentnumber.setBounds(0,220,180,50);
            major.setBounds(0,280,180,50);
            l1.setBounds(0,0,360,40);
            b7.setBounds(50,360,100,50);
            b8.setBounds(220,360,100,50);
            
            
            this.setBounds(900,300,400,500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//xiugai
            this.setVisible(true);
        }
    }
    class AFrame4 extends JFrame{
        JButton b9;
        JButton b10;
        JTextField t8;
        JLabel l2;
        JLabel l3;
        public AFrame4(String title){
            super(title);
            b9 = new JButton("查询");
            b10 = new JButton("取消");
            t8 = new JTextField(25);
            t8.setFont(new Font("宋体",Font.BOLD,25));
            l2 = new JLabel("输入学号：");
            l2.setFont(new Font("宋体",Font.BOLD,25));
            l2.setHorizontalAlignment(JTextField.CENTER);
            l3 = new JLabel("查询系统");
            l3.setForeground(Color.gray);
            l3.setFont(new Font("宋体",Font.BOLD,20));
            l3.setHorizontalAlignment(JTextField.CENTER);
    
            this.add(b9);
            this.add(b10);
            this.add(t8);
            this.add(l2);
            this.add(l3);
    
            b9.setBounds(50,300,100,50);
            b10.setBounds(200,300,100,50);
            t8.setBounds(180,160,180,50);
            l2.setBounds(0,160,180,50);
            l3.setBounds(0,0,360,40);
 
            b10.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null,"单击确定退出");
                    System.exit(0);
                }
            });
    
            this.setLayout(null);
            this.setBounds(900,300,400,500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }
    }
    class AFrame5 extends AFrame4{
        public AFrame5(String title){
            super(title);
            l3.setText("修改系统");
        }       
    }
    class AFrame6 extends AFrame4{
        public AFrame6(String title){
            super(title);
            l3.setText("删除系统");
        }
    }
}
