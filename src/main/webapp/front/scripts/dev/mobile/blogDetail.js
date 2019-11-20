(function(win, undefined) {
    var $ = win.jQuery, is;


    $("a[op=qb]").click(function(){

        $("#lable").removeClass("dn");
    });


    $("a[op=back]").click(function(){

        window.history.back();
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














    var pageInit = function() {

    }


    $(pageInit);
})(window);

