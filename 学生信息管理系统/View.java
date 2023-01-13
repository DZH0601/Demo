package 学生信息管理系统;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class View {
private JFrame jf=new JFrame();
//页面的总JPanel
private JPanel total=new JPanel(new BorderLayout());
//上传
private JPanel pUpload=new JPanel(new FlowLayout(FlowLayout.LEFT));
private JLabel lFileName=new JLabel("请选择上传的照片");
private JTextField tFileName=new JTextField(15);
private JButton bBrowse=new JButton("浏   览");
private JFileChooser uploadChooser=new JFileChooser();
private JButton bUpload=new JButton("上  传");
private JPanel pDownload=new JPanel(new FlowLayout(FlowLayout.LEFT));
private JLabel lDownload=new JLabel("下载下面的图片:");
private JFileChooser downloadChooser=new JFileChooser();
private JButton bDownload=new JButton("下  载");
private JPanel pIcon=new JPanel(new FlowLayout(FlowLayout.LEFT));
// 显示的头像图片路径
private ImageIcon icon=new ImageIcon(new ImageIcon("D:/Test/pic.jpg").getImage().getScaledInstance(400,320,0));
private JLabel lIcon=new JLabel(icon);
Dimension faceSize=new Dimension(500,450);
//设置运行时窗口的位置
Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
public void use(){
	pUpload.add(lFileName);
	pUpload.add(tFileName);
	pUpload.add(bBrowse);
	pUpload.add(bUpload);
	//浏览按钮的监听器
	bBrowse.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			downloadChooser.setCurrentDirectory(new File("."));
			int result=downloadChooser.showOpenDialog(jf);
			if(result==JFileChooser.APPROVE_OPTION ){
				String path=downloadChooser.getSelectedFile().getPath();
				tFileName.setText(path);
			}
		}
	});
	//上传按钮的监听器
	bUpload.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String fromFileName=tFileName.getText();
			// 上传的目标目录
			String toFileName="D:/Test/" + System.currentTimeMillis() + ".png";
			write(fromFileName, toFileName);
			JOptionPane.showMessageDialog(jf, "上传成功！", "提示", JOptionPane.WARNING_MESSAGE );
		}
	});
	pDownload.add(lDownload);
	pDownload.add(bDownload);
	//下载按钮的监听器
	bDownload.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			downloadChooser.setCurrentDirectory(new File("."));
			int result=uploadChooser.showOpenDialog(jf);
			if(result==JFileChooser.APPROVE_OPTION ){
			String path=uploadChooser.getSelectedFile().getPath();
			// 下载的文件路径
			String fromFileName="D:/Test/pic.jpg";
			write(fromFileName,path);
			JOptionPane.showMessageDialog(jf, "下载成功！", "提示", JOptionPane.WARNING_MESSAGE );
		}
	  }
	});
    pIcon.add(lIcon);
	total.add(pUpload,BorderLayout.NORTH);
	total.add(pDownload,BorderLayout.CENTER);
	total.add(pIcon,BorderLayout.SOUTH);
	jf.add(total);
	jf.setSize(faceSize);
	jf.setLocation((int)(screenSize.width-faceSize.getWidth())/2,(int)(screenSize.height-faceSize.getHeight())/2);
	jf.setResizable(false);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	jf.setVisible(true);
}
//fromFile是源文件，toFile是目的文件
public void write(String fromFile,String toFile){
	FileInputStream fis=null;
	FileOutputStream fos=null;
	try{
		fis=new FileInputStream(fromFile);
		fos=new FileOutputStream(toFile);
		byte[] buf=new byte[1024];
		int hasRead=0;
		while((hasRead=fis.read(buf))>0){
			fos.write(buf,0,hasRead);
		}
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}catch(IOException e){
		e.printStackTrace();  
	}finally{
		try{
			fis.close();
			fos.close();
		}catch(IOException e){
			e.printStackTrace();  
		}
	}
}
public static void main(String args[]){
	new View().use();
}
}
