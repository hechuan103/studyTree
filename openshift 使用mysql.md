#### openshift 使用mysql

oc login --token=4qV2_uqOi9rvlCAwY2UfWyYSvVta_5YnoefgN4oL66w --server=https://api.okd.us-east-1a.aws.2dfire.tech:6443

##### 终端连接 mysql数据
```mysql 
mysql -hX -uX -PX -pX
eg: mysql -hrdsdb1501.my.2dfire-inc.com -utrade_conf -P3306 -ptrade_conf@552208
```
```
dpush(消息中心): mysql -hdpush.cobar.2dfire-inc.com -udpush -pdpush@552208 -P8066

mysql -hmaster1101.mha.2dfire-inc.com -uoperation_config -poperation_config@552208 -P3306

cash-sync 数据库: mysql -hrdsdb1701.my.2dfire-inc.com -ucash_sync -pcash_sync@552208 -P3306
cash-sync order: mysql -horder_history.cobar.2dfire-inc.com -uorder_history -porder_history@552208 -P8066

trade_conf 数据库: mysql -hrdsdb1501.my.2dfire-inc.com -utrade_conf -ptrade_conf@552208 -P3306

member  mysql -hmember.cobar.2dfire-inc.com  -umember -pmember@552208 -P8066

item-soa mysql -hitem_center.cobar.2dfire-inc.com -uitem_center -pitem_center@552208 -P8066 

boss-soa mysql -hboss.cobar.2dfire-inc.com -uboss -P8066 -pboss@552208
boss-order  mysql -hboss_order.polar.2dfire-inc.com -uboss_order  -pboss_order@552208 -P3306

bps mysql -hbps.cobar.2dfire-inc.com -ubps -P8066 -pbps@552208
bps mysql -hmaster1201.mha.2dfire-inc.com -ubase_config -pbase_config@552208 -P3066 




shop-soa mysql -hmaster1201.mha.2dfire-inc.com -ushop -pshop@552208 -P3306 

item-platform mysql -hitem_center.cobar.2dfire-inc.com -uitem_center -pitem_center@552208 -P8066

supply-soa  mysql -hscmdb.cobar.2dfire-inc.com -uscmdb -pscmdb@552208 -P8066   scmdb

dmall-soa  mysql -hdmall.cobar.2dfire-inc.com -udmall -pdmall@552208 -P8066

cloudcash mysql -hrdsdb1701.my.2dfire-inc.com -ucash_cloud_print -pcash_cloud_print@552208 -P 3306
          mysql -hmaster1101.mha.2dfire-inc.com -ucash_config -pcash_config@552208 -P 3306



cashconfig mysql -hcustomized_field.cobar.2dfire-inc.com -ucustomized_field -pcustomized_field@552208 -P8066
 mysql -hmaster1201.my.2dfire-inc.com -ubase_config -pbase_config@552208 -P3306



operation_config mysql -hmaster1101.mha.2dfire-inc.com -uoperation_config -poperation_config@552208 -P3306

takeout-center mysql -hmaster1101.mha.2dfire-inc.com -utakeout_center -ptakeout_center@552208 -P3306


```

metadata :

```sql 
mysql -htidb1002.2dfire-inc.com -ureal_time_report -preal_time_report@552208 -P3306
mysql -hreal_time_report.cobar.2dfire-inc.com -ureal_time_report -preal_time_report@552208 -P8066
show columns from order_join_totalpay;
```
order:

```sql
mysql  -hcobar1105.2dfire-inc.com -uorder -porder@552208 -P8066
mysql  -horder.cobar.2dfire-inc.com
--美国
mysql  -horder.cobar.2dfire-inc.com -uorder -porder@552208 -P8066


mysql  -horderdb1215.my.2dfire-inc.com -P3306 -urdsreadonly -prdsreadonly@552208
```

cash-soa

``` shell
mysql  -hrdsdb1701.my.2dfire-inc.com -ucash_invoice -pcash_invoice@552208 -P3306
```

turtle-soa

```shell
mysql -hturtle.cobar.2dfire-inc.com -uturtle -pturtle@552208 -P8066
```

Market-data-soa: 掌柜首页会员数据

```sql
mysql -htidb1001.2dfire-inc.com -umarket -pmarket@552208 -P3306
```

matrix-soa:

~~myql -hmatrix.cobar.2dfire-inc.com -umatrix -pmatrix@552208 -P8066~~

```linux
mysql -hmatrix.polar.2dfire-inc.com -umatrix -pmatrix@552208 -P3306
```

pay-soa:

```linux
mysql -hpaycenter.cobar.2dfire-inc.com -upaycenter -ppaycenter@552208 -P8066
```

thirdpart-merchant-center：

```linux
mysql -hrdsdb1501.my.2dfire-inc.com -upayment_settings -ppayment_settings@552208 -P3306
payment_settings
```

third-internal-soa:

```sql

mysql -hthird_platform2.cobar.2dfire-inc.com -uthird_platform -pthird_platform@552208 -P8066
```





Merchant-manager-soa

```sql
mysql -hmerchant_config.cobar.2dfire-inc.com -umerchant_config -pmerchant_config@552208 -P8066
```



```sql
mysql -hrdsdb1701.my.2dfire-inc.com -ucash_cloud_print -pcash_cloud_print@552208 -P3306
```



app_log

```linux
mysql -hmaster1401.my.2dfire-inc.com -ulog -plog@552208 -P3306
log

```

shopconf

```linux
mysql -hmaster1101.mha.2dfire-inc.com -ushopconf -pshopconf@552208 -P3306
shopconf
```



MemberCardInService 需要国际化

美国零售店 beifengjun US retail    US304000013  餐店初始化密码fputdt Admin用户密码7f74w9

###### 查看数据库字符编码
```sql
show variables like 'character_set%'; 
```

###### 查看当前字符集编码
```sql
show variables like 'character%';
```

##### 展示结果
character_set_client：客户端请求数据的字符集

character_set_connection：客户机与服务器连接的字符集

character_set_database：默认数据库的字符集；如果没有默认数据库，就会使用 character_set_server指定的字符集（建议不要随意更改）

character_set_filesystem：把 character_set_client转换character_set_filesystem (默认为binary, 不做任何转换)

character_set_results：返回给客户端的字符集

character_set_server：数据库服务器的默认字符集

character_set_system：系统字符集，默认utf8。（用于数据库的表、列和存储在目录表中函数的名字）

character_sets_dir：mysql字符集文件的保存路径

##### 设置字符集解决乱码
```sql
set character_set_client = ‘utf8’;

set character_set_connection = ‘utf8’;

set character_set_results = ‘utf8’;
```

一次性解决:

```sql
set names utf8
```

##### 查看表结构和注释

```sql
show full columns from tablename
```



oc连接mysql
oc rsh mariadb-5-qrh62
oc 进入pod
oc exec -it mariadb-12 /bin/sh

oc 远程调试美国服务器

```shell
oc port-forward [order-search-soa-5fb77f5dc4-gngj6] 50000:5005
```

oc 复制

oc cp  api-gw-10-j68fj:/opt/logs/spring-boot/bak/alert_monitor.2019-12-23.0.log.zip ./


项目环境远程调试接口默认50000


boss 数据库常用查询：
select name,industry,country_id,function_id,inner_code from page where country_id ='000' and is_valid=1


git pull 需要输入密码: 控制台执行

``` shell
ssh-add .ssh/gitlab-rsa
```

