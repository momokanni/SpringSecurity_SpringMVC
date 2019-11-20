(function(win, undefined) {
    var $ = win.jQuery, is;
    
    $("a[op=back]").click(function(){
        window.history.back();
    });

    $("a[op=fx]").click(function(){
        $("#appFx").removeClass("dn")
    });

    $("a[op=gz]").click(function(){
        if(!$(this).hasClass("a_follow_ok")){

            $.ajax({
                url : "/mobile/blog/blogFocus",
                type : "post",
                data : {
                    id:id,
                    userId:userId
                },
                dataType : "json",
                async : false,
                success:function(data){
                    if (1 == data.ret) {
                        $("#gz").addClass("a_follow_ok");
                        $("#gz").text("已关注");
                    }
                }
            });
        }
    });

    $("a[op=dz]").click(function(){
        if(!$(this).hasClass("art_fab_in")){

            $.ajax({
                url : "/mobile/article/articleLaud",
                type : "post",
                data : {
                    articleId:articleId,
                    userId:userId
                },
                dataType : "json",
                async : false,
                success:function(data){
                    if (1 == data.ret) {
                        $("#dz").addClass("art_fab_in");
                        var laudStr = $("#laud").html();
                        if(laudStr==""){
                            $("#laud").html(1);
                        }else{
                            var result = parseInt(laudStr) + 1;
                            $("#laud").html(result);
                        }
                    }
                }
            });
        }else{
            //取消点赞
            $.ajax({
                url : "/mobile/article/editArticleLaud",
                type : "post",
                data : {
                    articleId:articleId,
                    userId:userId
                },
                dataType : "json",
                async : false,
                success:function(data){
                    if (1 == data.ret) {
                        $("#dz").removeClass("art_fab_in");
                        var laudStr = $("#laud").html();
                        if(laudStr==1){
                            $("#laud").html("");
                        }else{
                            var result = parseInt(laudStr) -1;
                            $("#laud").html(result);
                        }
                    }
                }
            });
        }
    });

    $("a[op=sc]").click(function(){
        if(!$(this).hasClass("art_col_in")){
            $.ajax({
                url : "/mobile/article/clickArticleCollection",
                type : "post",
                data : {
                    articleId:articleId,
                    userId:userId
                },
                dataType : "json",
                async : false,
                success:function(data){
                    if (1 == data.ret) {
                        $("#sc").addClass("art_col_in");
                    }
                }
            });
        }else {
            $.ajax({
                url : "/mobile/article/editArticleCollection",
                type : "post",
                data : {
                    articleId:articleId,
                    userId:userId
                },
                dataType : "json",
                async : false,
                success:function(data){
                    if (1 == data.ret) {
                        $("#sc").removeClass("art_col_in");
                    }
                }
            });
        }
    });

    var pageInit = function() {
    	
    }
    $(pageInit);
})(window);

