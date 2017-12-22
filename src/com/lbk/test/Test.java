package com.lbk.test;

import java.sql.Timestamp;
import java.util.Date;

import com.lbk.bean.WbArticle;
import com.lbk.service.observable.Modifyenum;
import com.lbk.service.observable.WbObservableImp;
import com.lbk.util.XMLMapping;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*WbArticle wb_article1 = new WbArticle(1100,"uzi!",new Timestamp(System.currentTimeMillis()),0);
		WbArticle wb_article = new WbArticle();
		wb_article.setC_id(1599745);
		wb_article.setC_content("chiduole!");
		WbObservableImp wbObservableImp = new WbObservableImp();*/
		
		//测试4  删除微博
		//wbObservableImp.notifyUpdate(wb_article,Modifyenum.delete);
		
		//测试3  增加微博
		//wbObservableImp.notifyUpdate(wb_article1, Modifyenum.add);
				
		//测试1 查看微博
		//wbObservableImp.notifyUpdate(wb_article, Modifyenum.read);
		
		//测试2  修改微博
		//wbObservableImp.notifyUpdate(wb_article,Modifyenum.update);
		
		/*String path = XMLMapping.class.getClassLoader().getResource("resources/api-config.xml").getPath();
		System.out.println(path);*/
	}

}
