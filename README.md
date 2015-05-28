# coding-online 
  在线生成系统原型，适合一般的管理系统（eg. sms,cms），帮助完成95%的基础代码。
  
  系统基础架构： 1. 开源框架 springmvc + hibernate ；
                 2. 系统缓存 redis; 
                 3. 前面页面 easyui + bootstrap + jquery + lhgdialog .
  
  

  
  系统还有部分没有开发完成，还需要一段时间。
  
  
  #系统界面
    由于时间原因，先将系统的基本功能做个介绍，如果有喜欢的朋友给个支持, 看有没有朋友需要，没有需要的话就不放代码出来了。 为看得清楚些图片为1366*768
    
    1. 系统主面
![image](/snapshot/home.png)
    
    2. 系统表
![image](/snapshot/design.png)
    
    3. 多对一关系表生成页面原型 （用户修改）
        表设计描述: 用户与部门是多对一，即一个用户只能在一个部门中，不具有跨部门功能。
![image](/snapshot/many2one.png)
    
    4. 一对多关系表生成页面原型 （部门管理员）
        表设计描述：部门与管理用户为一对多，即一个部门可以有多个管理员，不同部门可以添加同一管理员。
![image](/snapshot/one2many.png)
    
    5. 多对多关系表生成页面原型
       功能菜单添加角色， 表设计描述：功能菜单与系统角色间是多对多关系
![image](/snapshot/many2many.png)
       角色添加功能菜单， 表设计描述：功能菜单与系统角色间是多对多关系
![image](/snapshot/many2many2.png)
