package com.hc.jf.entity;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Provincials extends Model<Provincials> {
	public static final Provincials me = new Provincials();

	public Provincials getProvincialByCode(String code) {
		Provincials provincial = findFirst("select * from provincial where procode=?", code);
		return provincial;
	}

	public List<Provincials> getProvincials() {
		List<Provincials> list = find("select * from provincial");
		return list;
	}
}
