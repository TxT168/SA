package com.lbk.service;

import java.util.Vector;

import com.lbk.bean.WbArticle;
import com.lbk.dao.WbarticleDao;


public class WbarticleServiceImp implements WbarticleService {

	private WbarticleDao wbarticleDao = new WbarticleDao();
	
	@Override
	public WbArticle readWbarticle(int c_id) {
		// TODO Auto-generated method stub
		return wbarticleDao.read(c_id);
	}

	@Override
	public int addWbarticle(WbArticle wb_article) {
		// TODO Auto-generated method stub
		int c_id = wbarticleDao.add(wb_article);
		return c_id;
	}

	@Override
	public void deleteWbarticle(int c_id) {
		// TODO Auto-generated method stub
		wbarticleDao.delete(c_id);
	}

	@Override
	public void updateWbarticle(WbArticle wb_article) {
		// TODO Auto-generated method stub
		wbarticleDao.update(wb_article);
	}

	@Override
	public Vector<WbArticle> readRecentWbarticle() {
		// TODO Auto-generated method stub
		return wbarticleDao.getWbArticleVector();
	}

}
