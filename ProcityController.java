package com.honzh.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.honzh.biz.database.entity.City;
import com.honzh.biz.database.entity.Option;
import com.honzh.biz.database.entity.Provincial;
import com.honzh.common.util.JsonUtil;
import com.honzh.spring.service.CityService;
import com.honzh.spring.service.ProvincialService;

@Controller
@RequestMapping(value = "/procity")
public class ProcityController extends BaseController {
	private static Logger logger = Logger.getLogger(ProcityController.class);

	/**
	 * 当传递city_code，则表明下拉框要被选中，否则不选中
	 */
	@RequestMapping("")
	public void index(@RequestParam(value = "city_code", required = false) String city_code,
			@RequestParam(value = "pro_code", required = false) String pro_code, HttpServletResponse response) {
		try {
			logger.debug("获取所在地区" + city_code + ", 省" + pro_code);

			// 如果pro_code为””，则表明要获取城市菜单，否则获取市级菜单
			if (!pro_code.equals("")) {
				Integer pro_id = ProvincialService.getInstance().getByProvincialcode(pro_code).getId();
				List<City> citys = CityService.getInstance().getCitysByProvincialId(pro_id);
				List<Option> coptions = new ArrayList<Option>(citys.size());

				for (City city : citys) {
					Option coption = new Option();
					coption.setId(city.getId());
					coption.setName(city.getCname());
					coption.setValue(city.getCode());

					// 市级菜单被选中
					if (city_code != null && !city_code.equals("")) {
						if (city.getCode().equals(city_code)) {
							coption.setSelected("selected");
						}
					}
					coptions.add(coption);
				}
				renderJson(response, JsonUtil.toJson(coptions));
			} else {
				List<Provincial> provincials = ProvincialService.getInstance().getProvincials();

				// 转换成标准的option属性（name,value,selected）
				List<Option> options = new ArrayList<Option>(provincials.size());

				// 被选中的省市
				// 则说明是展示页面，此时需要为省级菜单和市级菜单设置选择项
				if (city_code != null && !city_code.equals("")) {
					Provincial selected_provincial = ProvincialService.getInstance().getProvincialByCitycode(city_code);

					pro_code = selected_provincial.getProcode();
				} else {
					pro_code = provincials.get(0) == null ? "" : provincials.get(0).getProcode();
				}

				for (Provincial provincial : provincials) {
					Option option = new Option();
					option.setId(provincial.getId());
					option.setName(provincial.getProname());
					option.setValue(provincial.getProcode());

					if (!pro_code.equals("") && provincial.getProcode().equals(pro_code)) {
						option.setSelected("selected");
					}

					options.add(option);
				}

				renderJson(response, JsonUtil.toJson(options));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error(e.getMessage(), e);

			renderJson(response, null);
		}
	}

}
