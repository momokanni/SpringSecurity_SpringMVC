//浏览器判断
var ua  = window.navigator.userAgent.toLowerCase(),
    check = function(r){
        return r.test(ua);
    };
var isOpera  =  check(/opera/),
    isChrome = check(/\bchrome\b/),
    isWebKit = check(/webkit/),
    isSafari = !isChrome && isWebKit,
    isIE     = check(/msie/) && document.all && !isOpera,
    isIE7    = check(/msie 7/),
    isIE8    = check(/msie 8/),
    isIE9    = check(/msie 9/),
    isIE10    = check(/msie 10/),
    isIE6    = isIE && !isIE7 && !isIE8 && !isIE9 && !isIE10,
    isIE11   = check(/trident/) && ua.match(/rv:([\d.]+)/)?true:false,
    isGecko  = check(/gecko/) && !isWebKit,
    isMac    = check(/mac/);

var Browser = {
    isOpera : isOpera,
    isChrome : isChrome,
    isWebKit : isWebKit,
    isSafari : isSafari,
    isIE     : isIE,
    isIE7    : isIE7,
    isIE8    : isIE8,
    isIE9    : isIE9,
    isIE6    : isIE6,
    isIE11    :isIE11,
    isGecko  : isGecko,
    isMac    : isMac
};
