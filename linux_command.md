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









