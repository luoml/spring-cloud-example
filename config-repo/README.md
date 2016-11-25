# config-repo
config-repo为远程Git仓库，用于集中管理服务的配置信息，与config-server配合使用。

_仓库中的资源信息遵循以下规则_  

``` 
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```

|variable|value|desc|  
|:---|:---|:---|   
|{application}|spring.application.name|客户端服务名|  
|{profile}|spring.active.profiles|环境变量，多个可用逗号分隔| 
|{label}|eg: master/trunk/branchs...|仓库分支，eg: master(git)、trunk(svn)|  