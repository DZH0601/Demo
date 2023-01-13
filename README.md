# 一、问题描述
如何实现一个功能简单的学生信息管理系统，能够对学生信息（包括照片）进行添加、删除、修改和查询等操作。

# 二、基本要求
实现一个功能简单的学生信息管理系统，该系统具有按照账户名密码登录功能，登录后，可以添加，删除，修改、查询（显示学生相片）学生信息，添加学生信息时，要求能添加学生的相片信息（实现相片文件的上传和下载功能）。

# 三、需求分析
程序设计的任务是实现对学生信息的管理。用户名和密码都默认设置为0，用户名或密码输入错误会弹出“用户名或密码输入不正确”的对话框。在用户名和密码输入正确后进入学生信息管理系统，然后进行添加、修改、删除等操作。在添加操作里面可以上传和下载照片，这是File类型的。输入的其他学号、姓名、性别、电话、QQ和专业都是String类型，输出的也是String类型。点击确认后会弹出“添加成功”。

# 四、概要设计
 ## 1、类之间的调用关系
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601132042714.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)
##  2、学生信息模块
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601132126126.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)
## 3、系统管理模块
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601132238345.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

# 五、调试分析
在一开始调试的时候，发现虽然没有错误，但无法运行，找了很久发现是自己在main方法里没有去调用init（）方法，然后填上了之后程序可以运行。然后在成功登录后进入学生信息管理系统界面。在里面没有上传照片和下载图片这一选项。我在View这个程序里面首先添加了本地的图片作为图标可供下载，然后选定一个文件夹Config作为上传的路径。这样，我就在LoginGUI类里面的添加按钮监听器里面再增加了调用View类的use（）方法的监听器，实现了图片上传和下载的功能。
总之，从一开始参考书上例题打出来的程序作为基石，在上面进行雕刻。从设计转化为实现，打基础这一步很困难，因为要花很长时间查资料、看书和看代码来理解程序，然后才能自己灵活进行优化。同学之间也相互讨论帮助，都能给出自己的想法，然后交流之后会得出更好的创意，从第一个星期开始，我已经规划好要怎样做，许多同学也参考了我的规划。我一直按照计划实施并且很顺利地完成了程序设计。

# 六、用户使用说明
## 1、登录
（1）程序设计的任务是先设计出一个登录窗口，输入用户名和密码。

![在这里插入图片描述](https://img-blog.csdnimg.cn/ea953ded13c747efb823a5cee41b2c21.png)

如果输入错误，会像如图所示输出“用户名或密码输入不正确”的对话框。

![在这里插入图片描述](https://img-blog.csdnimg.cn/927e23a666304dfdac54ac60ccce214b.png)


==我给出的代码为了方便调试，用户名和密码全是0，注意程序入口是LoginGUI类。==

（2）如果正确，则成功登录，进入学生信息管理界面，如图所示：

![在这里插入图片描述](https://img-blog.csdnimg.cn/4bbebdd807b54ebe86a346f463f0ba64.png)

## 2、添加
（1）点击“添加”按钮，进入学生信息添加界面：
![在这里插入图片描述](https://img-blog.csdnimg.cn/636daf70b23f4a81827572c043302191.png)

（2）在以上界面输入要添加的学生信息，首先点击“上传照片”按钮，然后弹出具有上传照片和下载照片功能的窗口：

![在这里插入图片描述](https://img-blog.csdnimg.cn/6648a84fcbfe4829b6cb018365d714f7.png)

（3）点击浏览选项，选择本地文件里需要上传的图片，这里我们选择Taylor Swift的图片，然后点击上传，会显示“上传成功”的对话框。

![在这里插入图片描述](https://img-blog.csdnimg.cn/130904522d1f4ea6a49c7d10b8768b3b.png)

（4）可以看到这张图片上传到了本地D:/Test目录下，实现了图片的上传功能。

```java
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
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/686c9bb6531646a185bd3d7e4e85fa78.png)



（5）点击“下载”按钮，先选择电脑上的一个目录，然后输入保存的文件名，这里我依然是打开到D:/Test目录，然后文件名写的是123.png，最后点击打开。

![在这里插入图片描述](https://img-blog.csdnimg.cn/546c777a883f41f3bed1a51ea9f12c4c.png)



（6）它会将显示的头像以你指定的文件名，下载到你指定的目录中，实现了文件的下载功能。

![在这里插入图片描述](https://img-blog.csdnimg.cn/a2990ad2853d4c36b1d78e1b23ad9bc1.png)



（7）然后添加其他的学生信息，如图所示：

![在这里插入图片描述](https://img-blog.csdnimg.cn/55a6f6e2693e432e9d9f38d916b366af.png)


（8）点击“确认”按钮，即可保存学生信息。我们再添加一个学生的信息，输入完信息后，点击确认按钮添加成功，如下图所示：

![在这里插入图片描述](https://img-blog.csdnimg.cn/5511652db4fc4e318f1ddcccca9c1802.png)


## 3、查询
（1）在学生管理界面的学生信息列表中点击“查询”按钮，即可显示已经添加的学生信息记录。第一次点查询是查询学号为空的学生，自然是不存在，第二次查点询则显示所有的学生。这是将全查和查询单个学生的功能放到一起。

![在这里插入图片描述](https://img-blog.csdnimg.cn/1c3ce23e5b024d17ba115e4f45f793c7.png)

（2）也可以在“查询”的文本框内输入学号，然后点击“查询”按钮，会跳出所对应的学生记录，如图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/944fd66f0a754814ad24445512829846.png)

## 4、修改
（1）选择张韶涵这条记录，再点击“修改”按钮，弹出对话框，这里我们可以修改除了学号之外的其他学生信息，修改完成后点击确认按钮即可。

![在这里插入图片描述](https://img-blog.csdnimg.cn/1a913727052e4259a8fc66fcda01ecf3.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/3a52f1e0d6f34de49e52249c61e24841.png)



（2）再次点击“查询”按钮刷新窗口数据，显示出修改后的信息，如下图所示：

![在这里插入图片描述](https://img-blog.csdnimg.cn/fa65c14fea3f48fc8d319be00fbb14df.png)

## 5、删除
（1）在学生信息管理系统界面选中某一学生记录，单击“删除”按钮，弹出删除确认界面。如果确认删除，单击“确定”按钮，否则单击“取消”按钮。

![在这里插入图片描述](https://img-blog.csdnimg.cn/8561b8a815f5489b9483d8b9d515406b.png)

（2）我们点击确定按钮，这条学生数据就被删除了。

![在这里插入图片描述](https://img-blog.csdnimg.cn/deb3d1cf4d194afe88f3f54b84eeaf40.png)


## 6、退出
点击右上角的X，将关闭所有程序窗口。

# 七、测试结果
测试数据和测试结果在用户使用说明选项中已经详细介绍过，这里不再重复介绍。

# 八、课程设计总结
这次课程设计总体来说是一次非常有意义的任务，因为在这次课程设计中我学会了很多GUI编程和流类的知识，提高了编程的能力，也增加了对编程的兴趣。虽然这是一个小项目，但是能把它做好也是有很大的满足感。虽然一开始遇到很多问题，但自己都咬牙克服、迎难而上，每天都在钻研程序，然后将自己的思想与同学们交流。可以说，没有付出就没有回报，只要你肯付出，就会有收获。一件事，你只要用心去做了，将它做好，无论结果如何，你都不会留有遗憾的。课程设计让我对所学知识有了更深刻的理解，也让我明白如今对程序员的要求是多么严格，需要掌握各种编程知识，才能够在职场上游刃有余。

# 九、参考文献
《JAVA核心技术》               马志强 张然 李雷孝著
《JAVA API文档》               Oracle官网文件
《JAVA编程思想》             【美】Bruce Eckel著
《JAVA数据库技术详解》    李刚  著
