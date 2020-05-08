function txt_upload() {
	if ($("#filename").val() == "") {
		new TipBox({
			type : 'tip',
			str : '请选择需要导入的文本文件(B)',
			clickDomCancel : true,
			setTime : 0,
			hasBtn : true
		});
		return false;
	}
	var formData = new FormData($("#form_txt")[0]);
	var tipBox = new TipBox({
		type : 'load',
		str : "任务生成中...",
		setTime : 600000,
		callBack : function() {
		}
	});
	console.log(formData);
	$.ajax({
		type : "POST",
		url : "../FDfdiotsmsAction!FileUpload_txt.action",
		processData : false,
		contentType : false,
		data : formData,
		dataType : "json",
		success : function(json) {
			tipBox.close();
			if (json.state == "0000") {
				new TipBox({
					type : 'success',
					str : '任务生成成功',
					hasBtn : true
				});
				window.open('http://localhost:8080/sphonegather/main.html#6/611');
				window.history.back(-1);

				
			} else if (json.state == "0") {
				new TipBox({
					type : 'error',
					str : '导入的文件中未查询到数据,请核查后重新导入',
					hasBtn : true
				});
			} else if (json.state == "2") {
				new TipBox({
					type : 'error',
					str : '导入的文件中有重复号码或库中已存在,请核查后重新导入',
					hasBtn : true
				});
			} else if (json.state == "-1") {
				new TipBox({
					type : 'error',
					str : '文件格式不支持,请参照模板进行导入',
					hasBtn : true
				});
			}
			else {
				new TipBox({
					type : 'tip',
					str : '系统异常请联系管理员!',
					hasBtn : true
				});
			}
		},
		error : function(json) {
			tipBox.close();
			console.log(json.state);
			new TipBox({
				type : 'error',
				str : '系统异常请联系管理员!',
				hasBtn : true
			});
		}
	});

}


function exc_upload() {
	if ($("#file").val() == "") {
		new TipBox({
			type : 'tip',
			str : '请选择需要导入的文本文件(B)',
			clickDomCancel : true,
			setTime : 0,
			hasBtn : true
		});
		return false;
	}
	var formData = new FormData($("#form_exc")[0]);
	var tipBox = new TipBox({
		type : 'load',
		str : "任务生成中...",
		setTime : 600000,
		callBack : function() {
		}
	});
	console.log(formData);
	$.ajax({
		type : "POST",
		url : "../fdiotsmsAction!FileUpload_Exc.action",
		processData : false,
		contentType : false,
		data : formData,
		dataType : "json",
		success : function(json) {
			tipBox.close();
			if (json.state == "0000") {
				new TipBox({
					type : 'success',
					str : '任务生成成功',
					hasBtn : true
				});
				window.open('http://localhost:8080/sphonegather/main.html#6/611');
				window.history.back(-1);

				
			} else if (json.result == "-4") {
				new TipBox({
					type : 'error',
					str : 'xls表中无数据,请核查后重新导入',
					hasBtn : true
				});
			} else if (json.result == "-2") {
				new TipBox({
					type : 'error',
					str : '导入的文件中是否为xls文件,请核查后重新导入',
					hasBtn : true
				});
			} else if (json.result == "-3") {
				new TipBox({
					type : 'error',
					str : '文件格式不支持,请使用模板进行导入',
					hasBtn : true
				});
			}
			else {
				new TipBox({
					type : 'tip',
					str : '系统异常请联系管理员!',
					hasBtn : true
				});
			}
		},
		error : function(json) {
			tipBox.close();
			console.log(json.state);
			new TipBox({
				type : 'error',
				str : '系统异常请联系管理员!',
				hasBtn : true
			});
		}
	});

}
