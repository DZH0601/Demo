package 学生信息管理系统;
class User{
	private String userId;
	private String password;
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
}
public class Student extends User{
 private String id;
 private String name;
 private String sex;
 private String age;
 private String phone;
 private String qq;
 private String major;
 private Object photo;
 public Object getPhoto(){
	 return photo;
 }
 public void setPhoto(Object photo){
	 this.photo=photo;
 }
 public String getId(){
	 return id;
 }
 public void setId(String id){
	 this.id=id;
 }
 public String getName(){
	 return name;
 }
 public void setName(String name){
	 this.name=name;
 }
 public String getSex(){
	 return sex;
 }
 public void setSex(String sex){
	 this.sex=sex;
 }
 public String getAge(){
	 return age;
 }
 public void setAge(String age){
	 this.age=age;
 }
 public String getPhone(){
	 return phone;
 }
 public void setPhone(String phone){
	 this.phone=phone;
 }
 public String getQq(){
	 return qq;
 }
 public void setQq(String qq){
	 this.qq=qq;
 }
 public String getMajor(){
	 return major;
 }
 public void setMajor(String major){
	 this.major=major;
 }
}
