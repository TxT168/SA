package com.lbk.test;

import com.lbk.activeMQ.ActiveMQ_Receiver;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午9:56:35 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class ActiveMQTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActiveMQ_Receiver logReceiver = new ActiveMQ_Receiver();
		logReceiver.logRecevier();
	}

}
