package com.lbk.service;

import java.util.Vector;

import com.lbk.bean.WbArticle;

public interface WbarticleService {
	public WbArticle readWbarticle(int a_id);// 读
	public Vector<WbArticle> readRecentWbarticle();//读取点击率最高的前100名用户的最新100条微博
	public int addWbarticle(WbArticle wb_article);//增
	public void deleteWbarticle(int a_id);//删
	public void updateWbarticle(WbArticle wb_article);//改
}
