package ѧ����Ϣ����ϵͳ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
 // ������δ�������ݿ�
 class DatebaseConnection {
	//���ݿ����ӳɹ�
	public final String DBDRIVER="net.sourceforge.jtds.jdbc.Driver";
	//���ݿ����ӵ�URL
	public  final String DBURL="jdbc:jtds:sqlserver://127.0.0.1:3606/Competition";
	//���ݿ��¼��
	public final String DBUSER="root";
	//���ݿ��¼����
	public final String DBPASS="123456";
	private Connection conn=null;
	public DatebaseConnection(){
		try{
			//�������ݿ�����
			Class.forName(DBDRIVER);
			//��ȡ���ݿ�����
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"���ݿ�����ʧ��","�쳣",JOptionPane.ERROR_MESSAGE );
			System.exit(0);
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, "��������ʧ��","�쳣",JOptionPane.ERROR_MESSAGE );
			System.exit(0);
		}
	}
	public Connection getConnection(){
		return this.conn;
	}
	public void close(){
		//�ر����ݿ�����
		if(this.conn!=null){
			try{
				this.conn.close();
			}catch(SQLException e){}
		}
	}
 }
	public class ConnectSQLServer{
	public static void main(String[] args) {
		try{
			Connection con=new DatebaseConnection().getConnection();
			if(con!=null){
				JOptionPane.showMessageDialog(null,"���ݿ����ӳɹ�","ף��",JOptionPane.INFORMATION_MESSAGE );
				System.exit(0);
			}else{
				JOptionPane.showMessageDialog(null, "���ݿ�����ʧ��","����",JOptionPane.ERROR_MESSAGE );
				System.exit(0);
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();  
			}

	}
	}
