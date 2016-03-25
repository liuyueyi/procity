package com.honzh.biz.database.entity;

import java.util.List;


/**
 * 
 * @Description: 省份(这里用一句话描述这个类的作用)
 * 
 */
public class Provincial  {

	private Integer id;// ID

	private String proname;// 名称

	private String procode;// 编码

	private List<City> citys;// 下属市

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProcode() {
		return procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

}
