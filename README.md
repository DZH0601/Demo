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

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210628211927110.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)
如果输入错误，会像如图所示输出“用户名或密码输入不正确”的对话框：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210628212049624.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

我给出的代码为了方便调试，用户名和密码全是0，注意运行的是LoginGUI这个类。

（2）如果正确，则成功登录，进入学生信息管理界面，如图所示：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133319271.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

## 2、添加
（1）点击“添加”按钮，进入学生信息添加界面：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133330272.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（2）在以上界面输入要添加的学生信息，首先点击“上传照片”按钮，然后弹出如下窗口：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133343663.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（3）点击浏览选项，选择本地文件里需要上传的图片，这里我们选择Taylor Swift的图片，然后点击上传，会显示“上传成功”的对话框。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133405788.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（4）可以看到这张图片上传到了本地D:/Config，实现了图片的上传功能。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210701204901865.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（5）也可以点击“下载”这个按钮，会提示下载成功的对话框，如图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133511775.png)

（6）它会将你的头像下载到你指定的文件夹中，实现了文件的下载功能，如下图所示是将头像下载到E:/QQ浏览器文件这个文件夹里。
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020060113352915.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（7）然后添加其他的学生信息，如图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133546461.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（8）点击“确认”按钮，即可保存学生信息。我们再添加一个女学生的信息，如下图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133610989.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（9）然后单击“确定”按钮，此时学生信息添加成功。

## 3、查询
（1）在学生管理界面的学生信息列表中点击“查询”按钮，即可显示已经添加的学生信息记录，如图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133642859.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（2）也可以在“查询”的文本框内输入学号，然后点击“查询”按钮，会跳出所对应的学生记录，如图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133713114.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

## 4、修改
（1）点击所选的武则天学生记录，再点击“修改”按钮，弹出信息框，修改姓名为“花木兰”，修改手机号为“18816218888”，如图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133726735.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

（2）点击确认按钮，再点击“查询”按钮进行刷新，显示出修改后的信息，如下图所示：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133739672.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyMjU3NjY2,size_16,color_FFFFFF,t_70)

## 5、删除
（1）在学生信息管理系统界面选中某一学生记录，单击“删除”按钮，弹出删除确认界面。如果确认删除，单击“确定”按钮，否则单击“取消”按钮。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133756223.png)

（2）我们选择学生凯的记录，并点击“删除”按钮，再确定删除，会看到这条记录被删除，仅剩学生花木兰的记录，如图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200601133807985.png)

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
