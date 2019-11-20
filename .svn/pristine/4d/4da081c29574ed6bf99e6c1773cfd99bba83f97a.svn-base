(function(win, undefined) {
	var $ = win.jQuery, is;

	if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
		QNR = {};
	}

	if (typeof QNR.btn === 'undefined' || !$.isPlainObject(QNR.btn)) {
		QNR.btn = {};
	}	
	// ---------------- Editor start------------------
	var init = function(){
		// 配置上传图片服务器端地址
	    editor.customConfig.uploadImgServer = '/blog/upload/img'
	    editor.customConfig.uploadFileName = 'img'
	    // 将图片大小限制为 3M
	    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
		// 限制一次最多上传 5 张图片
	    editor.customConfig.uploadImgMaxLength = 1
	    // 上传cookie
	    editor.customConfig.withCredentials = true
	    // 隐藏“网络图片”tab
	    editor.customConfig.showLinkImg = false
	    editor.customConfig.uploadImgHooks = {
				before: function (xhr, editor, files) {
					// 图片上传之前触发
					// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件
					return {
					    prevent: false,
					    msg: '放弃上传'
					}
				},
				success: function (xhr, editor, result) {
					// 图片上传并返回结果，图片插入成功之后触发
					// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
				},
				fail: function (xhr, editor, result) {
					// 图片上传并返回结果，但图片插入错误时触发
					// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
					errorTips("上传失败");
				},
				error: function (xhr, editor) {
					// 图片上传出错时触发
				    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
					errorTips("上传异常");
				},
				timeout: function (xhr, editor) {
					// 图片上传超时时触发
				    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
					errorTips("上传超时");
				},

				// 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
				// （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
				customInsert: function (insertImg, result, editor) {
					 // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
					 // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
					 // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
					 if (1 == result.errno) {
						errorTips(result.errmsg);
		             }  else {
		            	 successTips(result.message);
		            	 var url = result.data
						 insertImg(url)
		             }
					 // result 必须是一个 JSON 格式字符串！！！否则报错
			    }
		 };
	     editor.customConfig.linkImgCheck = function (src) {
	        //console.log(src) // 图片的链接

	        return true // 返回 true 表示校验成功
	        // return '验证失败' // 返回字符串，即校验失败的提示信息
	     };
	     
	     // 配置上传视频服务器端地址
		 editor.customConfig.uploadVideoServer = '/blog/upload/video'
		 editor.customConfig.uploadVideoFileName = 'video'
		 editor.customConfig.uploadVideoMaxSize = 10 * 1024 * 1024
		 editor.customConfig.uploadVideoMaxLength = 1
		 
		 editor.customConfig.uploadVideoHooks = {
					before: function (xhr, editor, files) {
						// 图片上传之前触发
						// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件
						return {
						    prevent: false,
						    msg: '放弃上传'
						}
					},
					success: function (xhr, editor, result) {
						// 视频上传并返回结果，图片插入成功之后触发
						// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
					},
					fail: function (xhr, editor, result) {
						// 视频上传并返回结果，但图片插入错误时触发
						// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
						errorTips("上传失败");
					},
					error: function (xhr, editor) {
						// 视频上传出错时触发
					    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
						errorTips("上传异常");
					},
					timeout: function (xhr, editor) {
						// 视频上传超时时触发
					    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
						errorTips("上传超时");
					},

					// 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
					// （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
					customInsert: function (insertVideo, result, editor) {
						 // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
						 // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

						 // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
						 if (1 == result.errno) {
							errorTips(result.errmsg);
			             }  else {
			            	 successTips(result.message);
			            	 var url = result.data
							 insertVideo(url)
			             }
						 // result 必须是一个 JSON 格式字符串！！！否则报错
				    }
			 };
		 	
		 	editor.customConfig.linkVideoCheck = function (src) {
		        //console.log(src) // 图片的链接

		        return true // 返回 true 表示校验成功
		        // return '验证失败' // 返回字符串，即校验失败的提示信息
		     };
		     
		 
		     // 配置上传视频封面服务器端地址
			 editor.customConfig.uploadVideoThumbServer = '/blog/upload/videoThumb'
			 editor.customConfig.uploadVideoThumbFileName = 'videoThumb'
			 editor.customConfig.uploadVideoThumbMaxSize = 10 * 1024 * 1024
			 editor.customConfig.uploadVideoThumbMaxLength = 1
			 
			 editor.customConfig.uploadVideoThumbHooks = {
						before: function (xhr, editor, files) {
							// 图片上传之前触发
							// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件
							return {
							    prevent: false,
							    msg: '放弃上传'
							}
						},
						success: function (xhr, editor, result) {
							// 视频上传并返回结果，图片插入成功之后触发
							// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
						},
						fail: function (xhr, editor, result) {
							// 视频上传并返回结果，但图片插入错误时触发
							// xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
							errorTips("上传失败");
						},
						error: function (xhr, editor) {
							// 视频上传出错时触发
						    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
							errorTips("上传异常");
						},
						timeout: function (xhr, editor) {
							// 视频上传超时时触发
						    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
							errorTips("上传超时");
						},
						// 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
						// （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
						customInsert: function (insertVideoThumb, result, editor) {
							 // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
							 // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

							 // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
							 if (1 == result.errno) {
								errorTips(result.errmsg);
				             }  else {
				            	 successTips("视频封面上传成功");
				            	 var url = result.data
								 insertVideoThumb(url);
				             }
							 // result 必须是一个 JSON 格式字符串！！！否则报错
					    }
				 };    
		 editor.create();
	    
	    
		 E.fullscreen.init('#editor');
		
	}
	var pageInit = function() {
		init();
	};
	$(pageInit);
	// ---------------- Editor end------------------
})(window);