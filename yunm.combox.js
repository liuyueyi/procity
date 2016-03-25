(function($) {
	var _onchange = function(event) {
		var $ref = $("#" + event.data.ref);
		if ($ref.size() == 0)
			return false;

		var refUrl = event.data.refUrl;
		var value = encodeURIComponent(event.data.$this.val());
		YUNM.debug(value);

		$.ajax({
			type : 'POST',
			dataType : "json",
			url : refUrl.replace("{value}", value),
			cache : false,
			data : {},
			success : function(response) {
				$ref.empty();

				var json = YUNM.jsonEval(response);
				if (!json)
					return;

				var html = '';
				$.each(json, function(i) {
					if (json[i]) {

						html += '<option value="' + json[i].value + '"';

						if (json[i].selected) {
							html += ' selected="' + json[i].selected;
						}

						html += '">' + json[i].name + '</option>';
					}
				});

				$ref.html(html);

				$ref.trigger("change").combox();
			},
			error : YUNM.ajaxError
		});

	};

	$.extend($.fn, {
		combox : function() {

			return this.each(function(i) {
				var $this = $(this);

				var value = $this.val() || '';
				var ref = $this.attr("ref");

				var refUrl = $this.attr("refUrl") || "";
				if (refUrl) {
					refUrl = refUrl.replace("{value}", encodeURIComponent(value));
				}

				if (refUrl) {
					$.ajax({
						type : 'POST',
						dataType : "json",
						url : refUrl,
						cache : false,
						data : {},
						success : function(response) {
							var json = YUNM.jsonEval(response);
							if (!json)
								return;

							var html = '';
							$.each(json, function(i) {
								if (json[i]) {

									html += '<option value="' + json[i].value + '"';

									if (json[i].selected) {
										html += ' selected="' + json[i].selected;
										YUNM.debug(html);
									}

									html += '">' + json[i].name + '</option>';

								}
							});

							$this.html(html);

							if (ref && $this.attr("refUrl")) {
								$this.unbind("change", _onchange).bind("change", {
									ref : ref,
									refUrl : $this.attr("refUrl"),
									$this : $this,
								}, _onchange).trigger("change");
							}
						},
						error : YUNM.ajaxError
					});
				}

			});
		}
	});
})(jQuery);
