package com.lbk.service.observable;

import com.lbk.bean.WbArticle;

/** 
  * @author  LTC 
  * @date 创建时间：2017年12月10日 下午7:34:42 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public interface WbObservable {
	public WbArticle notifyUpdate(WbArticle wbArticle , Modifyenum modifyenum) throws Exception;
}
