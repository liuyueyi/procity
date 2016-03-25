# procity
1.前端使用bootstrap集成组件，后端使用springMVC获取数据<br>
2.页面可以直接使用select组件，增加对应属性。
>

				<select name="province_code" class="form-control combox" ref="city_select" refUrl="${ctx}/procity?pro_code={value}&city_code=SAJC">
				</select>
		
				<select name="city_code" id="city_select" class="form-control">
				</select>
		
	
3.然后引入yunm.combox.js即可
	
