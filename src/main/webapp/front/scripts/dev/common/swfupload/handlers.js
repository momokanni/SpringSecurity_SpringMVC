if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
    QNR = {};
}

var issuper;

if(typeof window.isSuper === 'undefined')
    issuper=window.isSuper;
else
    issuper=false;
function fileQueueError(file, errorCode, message) {
	try {
		var imageName = "error.gif";
		var errorName = "";
		if (errorCode === SWFUpload.errorCode_QUEUE_LIMIT_EXCEEDED) {
			errorName = "有太多的文件在上传队列内了。";
		}

		if (errorName !== "") {
			alert(errorName);
			return;
		}

		switch (errorCode) {
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
			imageName = "zerobyte.gif";
			break;
		case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
            alert('请上传小于等于2MB的图片文件');
			break;
		case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
		case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
		default:
			alert(message);
			break;
		}
	} catch (ex) {
		this.debug(ex);
	}

}

function fileDialogComplete(numFilesSelected, numFilesQueued) {
	try {
		if (numFilesQueued > 0) {
			this.startUpload();
		}
	} catch (ex) {
		this.debug(ex);
	}
}
function uploadProgress(file, bytesLoaded) {
	try {
    if ($('#divFileProgressContainer').css('display') == 'none') {
        $('#divFileProgressContainer').show();
    }
    if ($('#divFileProgressContainer_2').css('display') == 'none') {
        $('#divFileProgressContainer_2').show();
    }
    if ($('#divFileProgressContainer_3').css('display') == 'none') {
        $('#divFileProgressContainer_3').show();
    }
		var percent = Math.ceil((bytesLoaded / file.size) * 100);

		var progress = new FileProgress(file,  this.customSettings.upload_target);
		progress.setProgress(percent);
		if (percent === 100) {
			progress.setStatus("正在创建图片...");
			progress.toggleCancel(false, this);
		} else {
			progress.setStatus("正在上传...");
			progress.toggleCancel(true, this);
		}
	} catch (ex) {
		this.debug(ex);
	}
}

function uploadSuccess(file, serverData) {
  var container, productType;
	try {
     if ($('#freesingle_content').css('display') == 'block') {
          container = '#frm_2';
          productType = 'freesingle';
     }else if ($('#groupTravel_content').css('display') == 'block') {
          container = '#frm';
          productType = 'groupTravel';
     }else  if ($('#scenery_content').css('display') == 'block') {
          container = '#frm_3';
          productType = 'scenery';
     }
      if ($('#divFileProgressContainer').css('display') == 'block') {
          setTimeout(function() {
              $('#divFileProgressContainer').hide();
          }, 1000);
      }
      if ($('#divFileProgressContainer_2').css('display') == 'block') {
          setTimeout(function() {
              $('#divFileProgressContainer_2').hide();
          }, 1000);
      }
      if ($('#divFileProgressContainer_3').css('display') == 'block') {
          setTimeout(function() {
              $('#divFileProgressContainer_3').hide();
          }, 1000);
      }

      if(typeof QNR.productPage._type==="undefined"){
            if($("#frm").length){
                container = "#frm";
                productType = 'groupTravel';
            }
            if($("#frm_2").length){
                container = "#frm_2";
                productType = 'freesingle';
            }
            if($("#frm_3").length){
                container = "#frm_3";
                productType = 'scenery';
            }
      }else{
          container = "#"+QNR.productPage._type;
      }
  	  var target=$(container + ' .imgLists > .pic_list'),
		  list=$("#"+productType+"_images"),
		  id=$(container+" :hidden[name='id']").val();
      //建立滚动条
	  var progress = new FileProgress(file,  this.customSettings.upload_target);

        if(serverData && serverData != 'failed') {
          if (update) {
            var url=(issuper)?"/admin/product.do":"/supplier/product.do";
            $.ajax({
              url: url,
              dataType: 'json',
              data: {
                'method': 'addProductImage',
                'id':$('input[name="id"]').val(),
                'imgId': serverData
              },
              success: function(data) {
                if (data) {
                  if (parseInt(data.ret, 10)) {
					addImages(target,{"data":serverData,"hidden":list,"id":id},true);
                  } else {
                    alert(data.message);
                  }
                }
              }
            });
          } else {
    		addImages(target,{"data":serverData,"hidden":list,"id":id},false);
          }
        } else {
			//addImage("images/error.gif");
			progress.setStatus("Error.");
			progress.toggleCancel(false);
			alert('图片上传失败，请重试');

		}


	} catch (ex) {
		this.debug(ex);
	}
}
function addImages(target,args,bool){
	  var len=target.find("dl").length,list,html=[],newURL = "/p/tts";
	   if(args["hidden"])
			  list=args['hidden'];
	   if(args["data"])
			 serverData=args["data"];
       html.push('<dl list='+len+'>');
       if(serverData.indexOf(newURL)==0){
           var host = (typeof QNR.updhost!=="undefined"&&QNR.updhost!="")?QNR.updhost:"http://img1.qunarzz.com";
            html.push('<dt><img alt="图片" src="'+host+serverData+'" style="width:120px;height:82px;"></dt>');
       }else{
            html.push('<dt><img alt="图片" src="http://userimg.qunar.com/imgs/'+serverData+'normal.jpg" style="width:120px;height:82px;"></dt>'); 
       }
	   html.push('<dd class="delete"><a title="删除"  href="javascript:void(0);"><img l="'+len+'" sid="'+serverData+'" src="http://source.qunar.com/site/images/travel/tts/delete.png"  class="addpic_button" alt="删除" title="删除"></a></dd>');
	   html.push('</dl>');
       target.append(html.join(""));
	   var val=list.val();
	   if(typeof val!=="undefined"&&val=="")
	    	list.val(serverData);
	   else if(list.val()!="")
	    	list.val(val+","+serverData);
       bindDelete(target,args ,list,bool);
}

function bindDelete(target,args,list,bool){
	 target.find(".addpic_button").each(function(i){
		 $(this).unbind('click').bind("click",function(){
			  var l=$(this).attr("l"),si=$(this).attr("sid"),t=$(this).closest("dl");				
              if(bool){
		        ajaxforDelete(t,{"data":si,"did":args["id"],"hidden":args["hidden"]},"deleteProductImage");
              }else{
                 t.remove();
                 var val=list.val();
                 if(val!=""&&val.indexOf(",")!=-1)
                    val=val.split(",");
                 for(var j=0,len=val.length;j<len;j++){
                     if(val[j]==si){
                        val.splice(j,1);
                        args["hidden"].val(val);
                     }
                 }
              }
		 })
	})
}
function ajaxforDelete(t,args,method){
    var url=(typeof isSuper !== 'undefined')?"/admin":"/supplier";
	var target=args["hidden"], val=target.val().split(",");
	$.ajax({
		url     :  url+"/product.do?method="+method+"&id="+args["did"]+"&imgId="+args["data"],
    dataType: 'json',
		success :  function(data){
      if (data) {
			  if(parseInt(data.ret, 10)){
			      if(args["hidden"]){
				   	for(var m=0,len=val.length;m<len;m++)
						if(val[m]==args["data"]){
						     val.splice(m,1);
							 target.val(val.join(","))
						}
						t.remove();
				  }
			  } else {
			    alert("出错了");
        }
      }
		}
	});
}
function uploadComplete(file) {
	try {
		/*  I want the next upload to continue automatically so I'll call startUpload here */
		if (this.getStats().files_queued > 0) {
			this.startUpload();
		} else {
			var progress = new FileProgress(file,  this.customSettings.upload_target);
			progress.setComplete();
			progress.setStatus("上传成功。");
			progress.toggleCancel(false);
		}
	} catch (ex) {
		this.debug(ex);
	}
}

function uploadError(file, errorCode, message) {
	var imageName =  "error.gif";
	var progress;
	try {
		switch (errorCode) {
		case SWFUpload.UPLOAD_ERROR.FILE_CANCELLED:
			try {
				progress = new FileProgress(file,  this.customSettings.upload_target);
				progress.setCancelled();
				progress.setStatus("已取消");
				progress.toggleCancel(false);
			}
			catch (ex1) {
				this.debug(ex1);
			}
			break;
		case SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED:
			try {
				progress = new FileProgress(file,  this.customSettings.upload_target);
				progress.setCancelled();
				progress.setStatus("已中止");
				progress.toggleCancel(true);
			}
			catch (ex2) {
				this.debug(ex2);
			}
		case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
			imageName = "uploadlimit.gif";
			break;
		default:
			alert(message);
			break;
		}

	} catch (ex3) {
		this.debug(ex3);
	}

}



function fadeIn(element, opacity) {
	var reduceOpacityBy = 5;
	var rate = 30;	// 15 fps

	if (opacity < 100) {
		opacity += reduceOpacityBy;
		if (opacity > 100) {
			opacity = 100;
		}

		if (element.filters) {
			try {
				element.filters.item("DXImageTransform.Microsoft.Alpha").opacity = opacity;
			} catch (e) {
				// If it is not set initially, the browser will throw an error.  This will set it if it is not set yet.
				element.style.filter = 'progid:DXImageTransform.Microsoft.Alpha(opacity=' + opacity + ')';
			}
		} else {
			element.style.opacity = opacity / 100;
		}
	}

	if (opacity < 100) {
		setTimeout(function () {
			fadeIn(element, opacity);
		}, rate);
	}
}



/* ******************************************
 *	FileProgress Object
 *	Control object for displaying file info
 * ****************************************** */

function FileProgress(file, targetID) {
	this.fileProgressID = "divFileProgress";

	this.fileProgressWrapper = document.getElementById(this.fileProgressID);
	if (!this.fileProgressWrapper) {
		this.fileProgressWrapper = document.createElement("div");
		this.fileProgressWrapper.className = "progressWrapper";
		this.fileProgressWrapper.id = this.fileProgressID;

		this.fileProgressElement = document.createElement("div");
		this.fileProgressElement.className = "progressContainer";

		var progressCancel = document.createElement("a");
		progressCancel.className = "progressCancel";
		progressCancel.href = "#";
		progressCancel.style.visibility = "hidden";
		progressCancel.appendChild(document.createTextNode(" "));

		var progressText = document.createElement("div");
		progressText.className = "progressName";
		progressText.appendChild(document.createTextNode(file.name));

		var progressBar = document.createElement("div");
		progressBar.className = "progressBarInProgress";

		var progressStatus = document.createElement("div");
		progressStatus.className = "progressBarStatus";
		progressStatus.innerHTML = "&nbsp;";

		this.fileProgressElement.appendChild(progressCancel);
		this.fileProgressElement.appendChild(progressText);
		this.fileProgressElement.appendChild(progressStatus);
		this.fileProgressElement.appendChild(progressBar);

		this.fileProgressWrapper.appendChild(this.fileProgressElement);

		document.getElementById(targetID).appendChild(this.fileProgressWrapper);
		fadeIn(this.fileProgressWrapper, 0);

	} else {
		this.fileProgressElement = this.fileProgressWrapper.firstChild;
		this.fileProgressElement.childNodes[1].firstChild.nodeValue = file.name;
	}

	this.height = this.fileProgressWrapper.offsetHeight;

}
FileProgress.prototype.setProgress = function (percentage) {
	this.fileProgressElement.className = "progressContainer green";
	this.fileProgressElement.childNodes[3].className = "progressBarInProgress";
	this.fileProgressElement.childNodes[3].style.width = percentage + "%";
};
FileProgress.prototype.setComplete = function () {
	this.fileProgressElement.className = "progressContainer blue";
	this.fileProgressElement.childNodes[3].className = "progressBarComplete";
	this.fileProgressElement.childNodes[3].style.width = "";

};
FileProgress.prototype.setError = function () {
	this.fileProgressElement.className = "progressContainer red";
	this.fileProgressElement.childNodes[3].className = "progressBarError";
	this.fileProgressElement.childNodes[3].style.width = "";

};
FileProgress.prototype.setCancelled = function () {
	this.fileProgressElement.className = "progressContainer";
	this.fileProgressElement.childNodes[3].className = "progressBarError";
	this.fileProgressElement.childNodes[3].style.width = "";

};
FileProgress.prototype.setStatus = function (status) {
	this.fileProgressElement.childNodes[2].innerHTML = status;
};

FileProgress.prototype.toggleCancel = function (show, swfuploadInstance) {
	this.fileProgressElement.childNodes[0].style.visibility = show ? "visible" : "hidden";
	if (swfuploadInstance) {
		var fileID = this.fileProgressID;
		this.fileProgressElement.childNodes[0].onclick = function () {
			swfuploadInstance.cancelUpload(fileID);
			return false;
		};
	}
};
