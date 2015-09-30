package com.hc.jf.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.hc.jf.entity.Citys;
import com.hc.jf.entity.Provincials;
import com.jfinal.kit.JsonKit;

public class ProcityController extends BaseController {
	private static Logger logger = Logger.getLogger(ProcityController.class);
	
	public void initProcitys() {
		logger.info("获取所在地区");
		
		List<Provincials> provincials = Provincials.me.getProvincials();
		for (Provincials provincial : provincials) {
			List<Citys> citys = Citys.me.getCitysByProvincialId(provincial.getLong("id"));
			provincial.put("citys", JsonKit.toJson(citys));
		}
		
		setAttr("provincials", provincials);
		
		render("procity.jsp");
	}
}
