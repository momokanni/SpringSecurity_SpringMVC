(function(win, undefined) {
    var $ = win.jQuery, is;

    var isTime=function(time){
        var regu = /^([1-9]{1}[0-9]{3})-(([0]{1}[0-9]{1})|([1]{1}[0,1,2]{1})|[1-9]{1})-(([0,1,2]{1}[0-9]{1})|([3]{1}[0,1]{1})|[1-9]{1})(\s*)(([0,1]{1}[0-9]{1})|([2]{1}[0-3]{1})|([0-9]{1})):(([0-5]{1}[0-9]{1})):(([0-5]{1}[0-9]{1}))$/;
        return regu.test(time);
    }

    var initEditor = function(elm) {
        var url='/swfupload/richUpload.do';
        try {
            var editorObj = KindEditor.create('#'+ elm, {
                afterBlur: function() {
                    this.sync();
                },
                afterCreate: function() {
                    var h = $('body').height() + 110;
                    h = ($.browser.msie) ? h + 20 : h;
                    $(parent.document).find('#show_info').height(h);
                },
                resizeType: 0,
                allowPreviewEmoticons: false,
                uploadJson: url,
                allowFileManager : false,
                items : [
                    'source', '|', 'undo', 'redo', '|', 'preview', 'print', 'cut', 'copy', 'paste',
                    'plainpaste', 'wordpaste', '|', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                    'insertunorderedlist', 'indent', 'outdent', '|', 'image', 'table', 'hr', 'link', 'unlink', 'fullscreen', '|', 'about'],
                htmlTags: {
                    font : ['color', 'size', 'face', '.background-color'],
                    span : [
                        '.color', '.background-color', '.font-size', '.font-family', '.background',
                        '.font-weight', '.font-style', '.text-decoration', '.vertical-align', '.line-height'
                    ],
                    div : [
                        'align', '.border', '.margin', '.padding', '.text-align', '.color',
                        '.background-color', '.font-size', '.font-family', '.font-weight', '.background',
                        '.font-style', '.text-decoration', '.vertical-align', '.margin-left'
                    ],
                    table: [
                        'border', 'cellspacing', 'cellpadding', 'width', 'height', 'align', 'bordercolor',
                        '.padding', '.margin', '.border', 'bgcolor', '.text-align', '.color', '.background-color',
                        '.font-size', '.font-family', '.font-weight', '.font-style', '.text-decoration', '.background',
                        '.width', '.height'
                    ],
                    'td,th': [
                        'align', 'valign', 'width', 'height', 'colspan', 'rowspan', 'bgcolor',
                        '.text-align', '.color', '.background-color', '.font-size', '.font-family', '.font-weight',
                        '.font-style', '.text-decoration', '.vertical-align', '.background'
                    ],
                    a : ['href', 'target', 'name'],
                    embed : ['src', 'width', 'height', 'type', 'loop', 'autostart', 'quality', '.width', '.height', 'align', 'allowscriptaccess'],
                    img : ['src', 'width', 'height', 'border', 'alt', 'title', '.width','.height'],
                    'p,ol,ul,li,blockquote,h1,h2,h3,h4,h5,h6' : [
                        'align', '.text-align', '.color', '.background-color', '.font-size', '.font-family', '.background',
                        '.font-weight', '.font-style', '.text-decoration', '.vertical-align', '.text-indent', '.margin-left'
                    ],
                    pre : ['class'],
                    'hr,br,tbody,tr,strong,b,sub,sup,em,i,u,strike' : []
                }
            });
        } catch(ex) {}
    };

    var b = true;
    $("a[op=save]").click(function(){

        if (!b) {
            return false;
        }
        b = false;

        var title = $("#title").val();
        if (isEmpty(title)) {
            bootAlert("公告标题不能为空");
            b = true;
            return false;
        }


        var content = $("#content").val();
        if (isEmpty(content)) {
            bootAlert("公告内容不能为空");
            b = true;
            return false;
        }


        var type = $("[name=type]:checked").val();

        if(type == null){
            bootAlert("类型不能为空");
            canSub = true;
            return false;
        }

        var validType = $("[name=validType]:checked").val();

        if(validType == null){
            bootAlert("其他设置不可为空");
            canSub = true;
            return false;
        }


        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {

            if (update) {
                if (data.ret == 1) {
                    bootAlert("修改成功", function(){
                        location.href = "/manager/notice/noticeList";
                    });

                } else {
                    b = true;
                    if (data.errmsg == "") {
                        bootAlert("操作失败");
                    } else {
                        bootAlert(data.errmsg);
                    }
                }
            } else {
                if (data.ret == 1) {
                    bootAlert("添加成功", function(){
                        location.href = "/manager/notice/noticeList";
                    });
                } else {
                    b = true;
                    if (data.errmsg == "") {
                        bootAlert("操作失败");
                    } else {
                        bootAlert(data.errmsg);
                    }
                }
            }

        };
        _jsonSubmit(frm, opts);
        return false;
    });




    $("#inlin").delegate("[type=radio]","click",function(){

        var strs=$('input:radio[name="validType"]:checked').val();
        if(strs==1){
            $("#dateView").css("display","inline-block");
        }

    });

    var pageInit = function() {
        initEditor("content");
    };

    $(pageInit);
})(window);
