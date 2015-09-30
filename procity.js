$(function() {
	provincialChange();
	
	var $provincial = $("#province_select");
	$provincial.change(provincialChange);
});

function provincialChange() {
	var $provincial = $("#province_select");

	// 省级显示的code值
	var provincial_code = $provincial.val();

	var $selectedOption = $('#province_select option[value=' + provincial_code + ']');

	var city_data = YUNM.jsonEval($selectedOption.attr("cdata"));

	// 市级的菜单列表
	$city_select = $("#city_select");
	$city_select.empty();
	
	for (var i = 0; i < city_data.length;i++ ) {
		var code = city_data[i].code;
		var cname = city_data[i].cname;
		
		$city_select.append("<option value='"+code+"'>"+cname+"</option>");
	}
}
