package com.honzh.biz.database.entity;


/**
 * 
 * @ClassName: City
 * @Description: 城市(这里用一句话描述这个类的作用)
 */
public class City {

	private Integer id;// id
	private Integer proid;// 省份ID
	private String cname;// 名称
	private String code;// 编码

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProid() {
		return proid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
