Redis start:

```shell
redis-server [redis.conf] [&]
```

Redis stop:

```shell
ctrl+c
```

查看进程下的线程：

```shell
ps p pid -L -o pcpu,pmem,pid,tid,time,tname,cmd
```

打印线程tid十进制转十六进制

```c
printf '%x\n' tid
```

查询某个进程

```shell
ps -ef|grep 名称
```

查看当前进程的状态

```shell
lsof| grep java|grep -v grep
```

Jdk keytool 生成证书

```shell
keytool -genkeypair -alias springtest -keyalg RSA -keysize 2048 -keypass springtest -validity 1000 -keystore ~/.keystore/springtest.jks -storepass springtest
```

Linux 用户切换

```shell
sudo su 或者 sudo sudo su 切换到root用户前提是先授权过命令
#二维火linux需要使用一下命令，前提是是应用机器的owner
sudo sudo su #跳过输入密码到root用户
```









