package com.lbk.service.observer;

import com.lbk.activeMQ.ActiveMQ_Sender;

public class LogWatcherImp implements LogWatcher {
	
	@Override
	public void addLog(String operation) throws Exception {
		// TODO Auto-generated method stub
		ActiveMQ_Sender logSender = new ActiveMQ_Sender();
		logSender.logSender("增加了一条微博的"+operation+"操作日志！");
	}
}
