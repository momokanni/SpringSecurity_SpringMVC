var initwx = function(func){
    wx.config({
        debug: false,
        appId: appId ,
        timestamp: timestamp ,
        nonceStr: nonceStr,
        signature: signature,
        jsApiList: ['onMenuShareTimeline',
            'onMenuShareAppMessage',
            'onMenuShareQQ',
            'onMenuShareQZone',
            'onMenuShareWeibo',
            'hideOptionMenu',
            'showOptionMenu',
            'hideMenuItems',
            'showMenuItems',
            'hideAllNonBaseMenuItem',
            'showAllNonBaseMenuItem'
        ]
    });

    wx.ready(function(){
        wx.onMenuShareTimeline({
            title: appTitleTL ,
            desc : appDesc,
            link: appUrl ,
            imgUrl: appImgUrl ,
            success: function (obj) {
                shareComplete("timeline",appTitleTL,appDesc,func);
                addDn();
            },
            cancel: function () {
                addDn();
            },
            complete:function(){
                addDn();
            }
        });

        wx.onMenuShareAppMessage({
            title: appTitleF ,
            desc: appDesc ,
            link: appUrl ,
            imgUrl: appImgUrl ,
            type: 'link', // 分享类型,music、video或link，不填默认为link
            success: function (obj) {
                shareComplete("friend",appTitleF,appDesc,func);
            },
            cancel: function () {
                addDn();
            },
            complete : function(){
                addDn();
            }
        });

        wx.onMenuShareQQ({
            title: appTitleF ,
            desc: appDesc ,
            link: appUrl ,
            imgUrl: appImgUrl ,
            success: function (obj) {
                shareComplete("qq",appTitleF,appDesc,func);
            },
            cancel: function () {
                addDn();
            },
            complete : function(){
                addDn();
            }
        });

        wx.onMenuShareQZone({
            title: appTitleF ,
            desc: appDesc ,
            link: appUrl ,
            imgUrl: appImgUrl ,
            success: function (obj) {
                shareComplete("qqzone",appTitleF,appDesc,func);
            },
            cancel: function () {
                addDn();
            },
            complete : function(){
                addDn();
            }
        });

        wx.onMenuShareWeibo({
            title: appTitleF,
            desc: appDesc,
            link: appUrl,
            imgUrl: appImgUrl,
            success: function (obj) {
                shareComplete("weibo",appTitleF,appDesc,func);
            },
            cancel: function () {
                addDn();
            },
            complete : function(){
                addDn();
            }
        });

        wx.hideMenuItems({
            menuList: hideMenuList
        });

    });

    var shareComplete = function(shareto,realTitle, realContent,funct){
        $.ajax({
            url: "/mobile/shareComplete",
            type: "POST",
            dateType: "json",
            data: {
                id : $("#shareInfoId").html(),
                shareTo : shareto,
                shareType : type,
                realTitle : realTitle,
                realContent : realContent
            }
        });

        //$("#shake_tip_btn_a").addClass("needToo");
    };

    if(null != func){
        func();
    }

    var addDn = function(){
        $("#wx_share_cover").addClass("dn");
        $("#zhezhao").addClass("dn");
    };

}





