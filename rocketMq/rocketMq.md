## RocketMq 

#### 一、组成部分

RocketMq主要由生产者(producer)、命名空间(NameSvr)、节点(Broker)、消费者(Consumer)组成.生成者主要生产、发送消息.命名空间协调生产者、broker、消费者之间的关系、剔除已下线的Broker、维护Broker心跳等(具体后面分析).Broker存储MessageQueue、持久化消息等.消费者更具订阅信息消费Broker中的消息.

#### 二、整体设计

