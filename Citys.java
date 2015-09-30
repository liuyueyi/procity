package com.hc.jf.entity;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Citys extends Model<Citys> {
	public static final Citys me = new Citys();

	public Citys getCityByCode(String code) {
		Citys city = findFirst("select * from city where code=?", code);
		return city;
	}

	public List<Citys> getCitys() {
		List<Citys> list = find("select * from city");
		return list;
	}

	public List<Citys> getCitysByProvincialId(Long provincialId) {
		List<Citys> list = find("select * from city c where c.proid = ?", provincialId);
		return list;
	}
}
