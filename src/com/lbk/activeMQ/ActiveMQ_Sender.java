package com.lbk.activeMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午9:09:05 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class ActiveMQ_Sender {
	//标明一个消息队列。  
    private final   String  MESSAGE_QUEUE="Wb_Log";  
      
    //默认的ActiveMQ服务器端绑定的端口。  
    private final   int PORT=61616;  
      
    //发送10条消息。  
    private final int COUNT = 10;  
  
    public void logSender(String message) {  
          
        // ConnectionFactory ：连接工厂，JMS 创建连接  
        ConnectionFactory connectionFactory;  
          
        // Connection ：JMS 客户端到JMS Provider 的连接  
        Connection connection = null;  
          
        // Session： 一个发送或接收消息的线程  
        Session session;  
          
        // Destination ：消息的目的地  
        Destination destination;  
          
        // MessageProducer：消息生产者。  
        MessageProducer producer;  
          
        // 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar  
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD, "tcp://127.0.0.1:"+PORT);  
          
        try {  
            // 构造从工厂得到连接对象  
            connection = connectionFactory.createConnection();  
              
            // 启动  
            connection.start();  
              
            // 获取操作连接  
            session = connection.createSession(Boolean.TRUE.booleanValue(), Session.AUTO_ACKNOWLEDGE);  
              
            // 获取session注意参数值 Wb_Log 是一个服务器的queue，须在在ActiveMq的console配置  
            destination = session.createQueue(MESSAGE_QUEUE);  
              
            // 得到消息生成者，发送者  
            producer = session.createProducer(destination);  
              
            // 设置不持久化  
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
              
            // 发送消息。  
            sendMessage(session, producer, message);  
              
            session.commit();  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (null != connection)  
                    connection.close();  
            } catch (Throwable ignore) {  
            }  
        }  
    }  
  
    public void sendMessage(Session session, MessageProducer producer, String string){   
	    TextMessage message = null;  
	    try {  
	        message = session.createTextMessage(string);  
	        } catch (JMSException e) {  
	            e.printStackTrace();  
	        }  
	        // 发送消息到目的地方  
	    try {  
	        producer.send(message);  
	        System.out.println("发送消息:"+message.getText());  
	    } catch (JMSException e) {  
	        e.printStackTrace();  
	    }  
    }  
}
