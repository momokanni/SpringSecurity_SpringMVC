/* eslint-disable */ 
! function(e, t) {
    "object" == typeof exports && "undefined" != typeof module ? module.exports = t() : "function" == typeof define && define.amd ? define(t) : e.mobiscroll = t()
}(this, function() {
    "use strict";

    function e(e) {
        return "function" == typeof e
    }

    function t(e) {
        return "object" === (void 0 === e ? "undefined" : he(e))
    }

    function a(e) {
        return "number" == typeof e.length
    }

    function n(e) {
        return e.replace(/-+(.)?/g, function(e, t) {
            return t ? t.toUpperCase() : ""
        })
    }

    function s(e, t, a) {
        for (var n in t) a && (Me.isPlainObject(t[n]) || Me.isArray(t[n])) ? ((Me.isPlainObject(t[n]) && !Me.isPlainObject(e[n]) || Me.isArray(t[n]) && !Me.isArray(e[n])) && (e[n] = {}), s(e[n], t[n], a)) : void 0 !== t[n] && (e[n] = t[n])
    }

    function r(e) {
        return e.replace(/::/g, "/").replace(/([A-Z]+)([A-Z][a-z])/g, "$1_$2").replace(/([a-z\d])([A-Z])/g, "$1_$2").replace(/_/g, "-").toLowerCase()
    }

    function i(e, t) {
        return "number" != typeof t || xe[r(e)] ? t : t + "px"
    }

    function o() {}

    function l(e) {
        var t, a = [];
        for (t in e) a.push(e[t]);
        return a
    }

    function c(e) {
        var t, a = {};
        if (e)
            for (t = 0; t < e.length; t++) a[e[t]] = e[t];
        return a
    }

    function d(e) {
        return e - parseFloat(e) >= 0
    }

    function m(e) {
        return "string" == typeof e
    }

    function u(e, t, a) {
        return Math.max(t, Math.min(e, a))
    }

    function h(e, t) {
        var a, n;
        return t = t || 100,
            function() {
                var s = this,
                    r = +new Date,
                    i = arguments;
                a && r < a + t ? (clearTimeout(n), n = setTimeout(function() {
                    a = r, e.apply(s, i)
                }, t)) : (a = r, e.apply(s, i))
            }
    }

    function f(e) {
        "vibrate" in navigator && navigator.vibrate(e || 50)
    }

    function p() {
        Pe++, setTimeout(function() {
            Pe--
        }, 500)
    }

    function b(e, t) {
        var a = (e.originalEvent || e).changedTouches[0],
            n = document.createEvent("MouseEvents");
        n.initMouseEvent("click", !0, !0, window, 1, a.screenX, a.screenY, a.clientX, a.clientY, !1, !1, !1, !1, 0, null), n.tap = !0, t.mbscChange = !0, t.dispatchEvent(n), p()
    }

    function v(e, t, a) {
        var n = e.originalEvent || e,
            s = (a ? "page" : "client") + t;
        return n.targetTouches && n.targetTouches[0] ? n.targetTouches[0][s] : n.changedTouches && n.changedTouches[0] ? n.changedTouches[0][s] : e[s]
    }

    function g(e, t, a, n, s, r) {
        function i(e) {
            u || (n && e.preventDefault(), u = this, d = v(e, "X"), m = v(e, "Y"), h = !1, f = new Date)
        }

        function o(e) {
            u && !h && (Math.abs(v(e, "X") - d) > s || Math.abs(v(e, "Y") - m) > s) && (h = !0)
        }

        function l(t) {
            u && ((r && new Date - f < 100 || !h) && (t.preventDefault(), a.call(u, t, e)), u = !1, p())
        }

        function c() {
            u = !1
        }
        var d, m, u, h, f, b = ue.$,
            g = b(t);
        s = s || 9, e.settings.tap && g.on("touchstart.mbsc", i).on("touchcancel.mbsc", c).on("touchmove.mbsc", o).on("touchend.mbsc", l), g.on("click.mbsc", function(t) {
            n && t.preventDefault(), a.call(this, t, e)
        })
    }

    function x(e) {
        if (Pe && !e.tap && ("TEXTAREA" != e.target.nodeName || "mousedown" != e.type)) return e.stopPropagation(), e.preventDefault(), !1
    }


    function _(e, t, a, n, s, r, i) {
        var o = new Date(e, t, a, n || 0, s || 0, r || 0, i || 0);
        return 23 == o.getHours() && 0 === (n || 0) && o.setHours(o.getHours() + 2), o
    }

    function w(e, t, a) {
        if (!t) return null;
        var n, s, r = ze({}, We, a),
            i = function(t) {
                for (var a = 0; n + 1 < e.length && e.charAt(n + 1) == t;) a++, n++;
                return a
            },
            o = function(e, t, a) {
                var n = "" + t;
                if (i(e))
                    for (; n.length < a;) n = "0" + n;
                return n
            },
            l = function(e, t, a, n) {
                return i(e) ? n[t] : a[t]
            },
            c = "",
            d = !1;
        for (n = 0; n < e.length; n++)
            if (d) "'" != e.charAt(n) || i("'") ? c += e.charAt(n) : d = !1;
            else switch (e.charAt(n)) {
                case "d":
                    c += o("d", r.getDay(t), 2);
                    break;
                case "D":
                    c += l("D", t.getDay(), r.dayNamesShort, r.dayNames);
                    break;
                case "o":
                    c += o("o", (t.getTime() - new Date(t.getFullYear(), 0, 0).getTime()) / 864e5, 3);
                    break;
                case "m":
                    c += o("m", r.getMonth(t) + 1, 2);
                    break;
                case "M":
                    c += l("M", r.getMonth(t), r.monthNamesShort, r.monthNames);
                    break;
                case "y":
                    s = r.getYear(t), c += i("y") ? s : (s % 100 < 10 ? "0" : "") + s % 100;
                    break;
                case "h":
                    var m = t.getHours();
                    c += o("h", m > 12 ? m - 12 : 0 === m ? 12 : m, 2);
                    break;
                case "H":
                    c += o("H", t.getHours(), 2);
                    break;
                case "i":
                    c += o("i", t.getMinutes(), 2);
                    break;
                case "s":
                    c += o("s", t.getSeconds(), 2);
                    break;
                case "a":
                    c += t.getHours() > 11 ? r.pmText : r.amText;
                    break;
                case "A":
                    c += t.getHours() > 11 ? r.pmText.toUpperCase() : r.amText.toUpperCase();
                    break;
                case "'":
                    i("'") ? c += "'" : d = !0;
                    break;
                default:
                    c += e.charAt(n)
            }
        return c
    }

    function M(e, t, a) {
        var n = ze({}, We, a),
            s = n.defaultValue && n.defaultValue.getTime ? n.defaultValue : new Date;
        if (!e || !t) return s;
        if (t.getTime) return t;
        t = "object" == (void 0 === t ? "undefined" : he(t)) ? t.toString() : t + "";
        var r, i = n.shortYearCutoff,
            o = n.getYear(s),
            l = n.getMonth(s) + 1,
            c = n.getDay(s),
            d = -1,
            m = s.getHours(),
            u = s.getMinutes(),
            h = 0,
            f = -1,
            p = !1,
            b = function(t) {
                var a = r + 1 < e.length && e.charAt(r + 1) == t;
                return a && r++, a
            },
            v = function(e) {
                b(e);
                var a = "@" == e ? 14 : "!" == e ? 20 : "y" == e ? 4 : "o" == e ? 3 : 2,
                    n = new RegExp("^\\d{1," + a + "}"),
                    s = t.substr(T).match(n);
                return s ? (T += s[0].length, parseInt(s[0], 10)) : 0
            },
            g = function(e, a, n) {
                var s, r = b(e) ? n : a;
                for (s = 0; s < r.length; s++)
                    if (t.substr(T, r[s].length).toLowerCase() == r[s].toLowerCase()) return T += r[s].length, s + 1;
                return 0
            },
            x = function() {
                T++
            },
            T = 0;
        for (r = 0; r < e.length; r++)
            if (p) "'" != e.charAt(r) || b("'") ? x() : p = !1;
            else switch (e.charAt(r)) {
                case "d":
                    c = v("d");
                    break;
                case "D":
                    g("D", n.dayNamesShort, n.dayNames);
                    break;
                case "o":
                    d = v("o");
                    break;
                case "m":
                    l = v("m");
                    break;
                case "M":
                    l = g("M", n.monthNamesShort, n.monthNames);
                    break;
                case "y":
                    o = v("y");
                    break;
                case "H":
                    m = v("H");
                    break;
                case "h":
                    m = v("h");
                    break;
                case "i":
                    u = v("i");
                    break;
                case "s":
                    h = v("s");
                    break;
                case "a":
                    f = g("a", [n.amText, n.pmText], [n.amText, n.pmText]) - 1;
                    break;
                case "A":
                    f = g("A", [n.amText, n.pmText], [n.amText, n.pmText]) - 1;
                    break;
                case "'":
                    b("'") ? x() : p = !0;
                    break;
                default:
                    x()
            }
        if (o < 100 && (o += (new Date).getFullYear() - (new Date).getFullYear() % 100 + (o <= ("string" != typeof i ? i : (new Date).getFullYear() % 100 + parseInt(i, 10)) ? 0 : -100)), d > -1)
            for (l = 1, c = d;;) {
                var y = 32 - new Date(o, l - 1, 32, 12).getDate();
                if (c <= y) break;
                l++, c -= y
            }
        m = -1 == f ? m : f && m < 12 ? m + 12 : f || 12 != m ? m : 0;
        var _ = n.getDate(o, l - 1, c, m, u, h);
        return n.getYear(_) != o || n.getMonth(_) + 1 != l || n.getDay(_) != c ? s : _
    }

    function S(e) {
        var t;
        for (t in e)
            if (void 0 !== Re[e[t]]) return !0;
        return !1
    }

    function C(e, t) {
        if ("touchstart" == e.type) Le(t).attr("data-touch", "1");
        else if (Le(t).attr("data-touch")) return Le(t).removeAttr("data-touch"), !1;
        return !0
    }

    function k(e, t) {
        var a, n = getComputedStyle(e[0]);
        return Le.each(["t", "webkitT", "MozT", "OT", "msT"], function(e, t) {
            if (void 0 !== n[t + "ransform"]) return a = n[t + "ransform"], !1
        }), a = a.split(")")[0].split(", "), t ? a[13] || a[5] : a[12] || a[4]
    }

    function D(e) {
        if (e) {
            if (Be[e]) return Be[e];
            var t = Le('<div style="background-color:' + e + ';"></div>').appendTo("body"),
                a = getComputedStyle(t[0]),
                n = a.backgroundColor.replace(/rgb|rgba|\(|\)|\s/g, "").split(","),
                s = .299 * n[0] + .587 * n[1] + .114 * n[2],
                r = s > 130 ? "#000" : "#fff";
            return t.remove(), Be[e] = r, r
        }
    }

    function N(e, t) {
        function a(e) {
            var t;
            o = Le(this), u = +o.attr("data-step"), l = !1, "mousedown" == e.type && e.preventDefault(), "keydown" != e.type ? (d = v(e, "X"), m = v(e, "Y"), t = C(e, this)) : t = 32 === e.keyCode, c || !t || o.hasClass("mbsc-fr-btn-d") || (c = !0, setTimeout(i, 100), "mousedown" == e.type && Le(document).on("mousemove", n).on("mouseup", s))
        }

        function n(e) {
            (Math.abs(d - v(e, "X")) > 7 || Math.abs(m - v(e, "Y")) > 7) && r()
        }

        function s(e) {
            "touchend" == e.type && e.preventDefault(), l || i(), r(), "mouseup" == e.type && Le(document).off("mousemove", n).off("mouseup", s)
        }

        function r() {
            c = !1, o && o.removeClass("mbsc-fr-btn-a")
        }

        function i() {
            c && !o.hasClass("mbsc-fr-btn-d") && (l = !0, t(u, i))
        }
        var o, l, c, d, m, u;
        e.on("touchstart mousedown keydown", a).on("touchmove", n).on("touchend touchcancel keyup", s)
    }

    function A(e) {
        return e[0].innerWidth || e.innerWidth()
    }

    function V(e, t) {
        var a = {},
            n = e.parent(),
            s = n.find(".mbsc-err-msg"),
            r = e.attr("data-icon-align") || "left",
            i = e.attr("data-icon");
        n.hasClass(vt) ? n = n.parent() : Le('<span class="' + vt + '"></span>').insertAfter(e).append(e), s && n.find("." + vt).append(s), i && (-1 !== i.indexOf("{") ? a = JSON.parse(i) : a[r] = i), (i || t) && (ze(a, t), n.addClass((a.right ? "mbsc-ic-right " : "") + (a.left ? " mbsc-ic-left" : "")).find("." + vt).append(a.left ? '<span class="mbsc-input-ic mbsc-left-ic mbsc-ic mbsc-ic-' + a.left + '"></span>' : "").append(a.right ? '<span class="mbsc-input-ic mbsc-right-ic mbsc-ic mbsc-ic-' + a.right + '"></span>' : ""))
    }

    function I(e, t, a) {
        var n = {},
            s = a[0],
            r = a.attr("data-password-toggle"),
            i = a.attr("data-icon-show") || "eye",
            o = a.attr("data-icon-hide") || "eye-blocked";
        r && (n.right = "password" == s.type ? i : o), V(a, n), r && g(e, t.find(".mbsc-right-ic").addClass("mbsc-input-toggle"), function() {
            "text" == s.type ? (s.type = "password", Le(this).addClass("mbsc-ic-" + i).removeClass("mbsc-ic-" + o)) : (s.type = "text", Le(this).removeClass("mbsc-ic-" + i).addClass("mbsc-ic-" + o))
        })
    }

    function F(e, t) {
        "button" != t && "submit" != t && "segmented" != t && (e.addClass("mbsc-control-w").find("label").addClass("mbsc-label"), e.contents().filter(function() {
            return 3 == this.nodeType && this.nodeValue && /\S/.test(this.nodeValue)
        }).each(function() {
            Le('<span class="mbsc-label"></span>').insertAfter(this).append(this)
        }))
    }

    function H(e) {
        var t = [Math.round(e.r).toString(16), Math.round(e.g).toString(16), Math.round(e.b).toString(16)];
        return Le.each(t, function(e, a) {
            1 == a.length && (t[e] = "0" + a)
        }), "#" + t.join("")
    }

    function P(e) {
        return e = parseInt(e.indexOf("#") > -1 ? e.substring(1) : e, 16), {
            r: e >> 16,
            g: (65280 & e) >> 8,
            b: 255 & e,
            toString: function() {
                return "rgb(" + this.r + "," + this.g + "," + this.b + ")"
            }
        }
    }

    function O(e) {
        var t, a, n, s = e.h,
            r = 255 * e.s / 100,
            i = 255 * e.v / 100;
        if (0 === r) t = a = n = i;
        else {
            var o = i,
                l = (255 - r) * i / 255,
                c = s % 60 * (o - l) / 60;
            360 == s && (s = 0), s < 60 ? (t = o, n = l, a = l + c) : s < 120 ? (a = o, n = l, t = o - c) : s < 180 ? (a = o, t = l, n = l + c) : s < 240 ? (n = o, t = l, a = o - c) : s < 300 ? (n = o, a = l, t = l + c) : s < 360 ? (t = o, a = l, n = o - c) : t = a = n = 0
        }
        return {
            r: t,
            g: a,
            b: n,
            toString: function() {
                return "rgb(" + this.r + "," + this.g + "," + this.b + ")"
            }
        }
    }

    function L(e) {
        var t, a, n = 0,
            s = Math.min(e.r, e.g, e.b),
            r = Math.max(e.r, e.g, e.b),
            i = r - s;
        return a = r, t = r ? 255 * i / r : 0, n = t ? e.r == r ? (e.g - e.b) / i : e.g == r ? 2 + (e.b - e.r) / i : 4 + (e.r - e.g) / i : -1, n *= 60, n < 0 && (n += 360), t *= 100 / 255, a *= 100 / 255, {
            h: n,
            s: t,
            v: a,
            toString: function() {
                return "hsv(" + Math.round(this.h) + "," + Math.round(this.s) + "%," + Math.round(this.v) + "%)"
            }
        }
    }

    function E(e) {
        var t, a, n = e.r / 255,
            s = e.g / 255,
            r = e.b / 255,
            i = Math.max(n, s, r),
            o = Math.min(n, s, r),
            l = (i + o) / 2;
        if (i == o) t = a = 0;
        else {
            var c = i - o;
            switch (a = l > .5 ? c / (2 - i - o) : c / (i + o), i) {
                case n:
                    t = (s - r) / c + (s < r ? 6 : 0);
                    break;
                case s:
                    t = (r - n) / c + 2;
                    break;
                case r:
                    t = (n - s) / c + 4
            }
            t /= 6
        }
        return {
            h: Math.round(360 * t),
            s: Math.round(100 * a),
            l: Math.round(100 * l),
            toString: function() {
                return "hsl(" + this.h + "," + this.s + "%," + this.l + "%)"
            }
        }
    }

    function Y(e) {
        var t, a, n, s, r, i, o = e.h,
            l = e.s,
            c = e.l;
        return isFinite(o) || (o = 0), isFinite(l) || (l = 0), isFinite(c) || (c = 0), o /= 60, o < 0 && (o = 6 - -o % 6), o %= 6, l = Math.max(0, Math.min(1, l / 100)), c = Math.max(0, Math.min(1, c / 100)), r = (1 - Math.abs(2 * c - 1)) * l, i = r * (1 - Math.abs(o % 2 - 1)), o < 1 ? (t = r, a = i, n = 0) : o < 2 ? (t = i, a = r, n = 0) : o < 3 ? (t = 0, a = r, n = i) : o < 4 ? (t = 0, a = i, n = r) : o < 5 ? (t = i, a = 0, n = r) : (t = r, a = 0, n = i), s = c - r / 2, {
            r: Math.round(255 * (t + s)),
            g: Math.round(255 * (a + s)),
            b: Math.round(255 * (n + s)),
            toString: function() {
                return "rgb(" + this.r + "," + this.g + "," + this.b + ")"
            }
        }
    }

    function z(e) {
        return E(P(e))
    }

    function j(e) {
        return H(Y(e))
    }

    function W(e) {
        return H(O(e))
    }

    function $(e) {
        return L(P(e))
    }

    function R(e) {
        Nt.length || e.show(), Nt.push(e)
    }

    function J(e) {
        var t = At.length;
        At.push(e), Nt.length || (t ? At[0].hide() : e.show(!1, !0))
    }

    function K(e, t, a, n) {
        return ze({
            display: t.display || "center",
            cssClass: "mbsc-alert",
            okText: t.okText,
            cancelText: t.cancelText,
            context: t.context,
            theme: t.theme,
            closeOnOverlayTap: !1,
            onBeforeClose: function() {
                e.shift()
            },
            onBeforeShow: function() {
                ue.activeInstance = null
            },
            onHide: function(e, n) {
                a && a(n._resolve), t.callback && t.callback(n._resolve), n && n.destroy(), Nt.length ? Nt[0].show() : At.length && At[0].show(!1, !0)
            }
        }, n)
    }

    function B(e) {
        return (e.title ? "<h2>" + e.title + "</h2>" : "") + "<p>" + (e.message || "") + "</p>"
    }

    function U(e, t, a) {
        R(new kt(e, K(Nt, t, a)))
    }

    function q(e, t, a) {
        var n = new kt(e, K(Nt, t, a, {
            buttons: ["cancel", "ok"],
            onSet: function() {
                n._resolve = !0
            }
        }));
        n._resolve = !1, R(n)
    }

    function G(e, t, a) {
        var n = void 0,
            s = new kt(e, K(Nt, t, a, {
                buttons: ["cancel", "ok"],
                onShow: function() {
                    n = s._markup.find("input")[0], setTimeout(function() {
                        n.focus()
                    }, 300)
                },
                onSet: function() {
                    s._resolve = n.value
                }
            }));
        s._resolve = null, R(s)
    }

    function X(e, t, a, n, s) {
        var r = void 0;
        J(new kt(e, K(At, t, a, {
            display: "bottom",
            animate: s,
            cssClass: n || "mbsc-snackbar",
            scrollLock: !1,
            focusTrap: !1,
            buttons: [],
            onShow: function(e, a) {
                !1 !== t.duration && (r = setTimeout(function() {
                    a && a.hide()
                }, t.duration || 3e3)), t.button && a.tap(Le(".mbsc-snackbar-btn", e.target), function() {
                    a.hide(), t.button.action && t.button.action.call(this)
                })
            },
            onClose: function() {
                clearTimeout(r)
            }
        })))
    }

    function Z(e, t, a) {
        X(e, t, a, "mbsc-toast", "fade")
    }

    function Q(e, t, a) {
        var n = void 0;
        return Dt ? n = new Promise(function(n) {
            e(t, a, n)
        }) : e(t, a), n
    }

    function ee(e) {
        var t = e[0],
            a = e.attr("data-role"),
            n = e.attr("type") || t.nodeName.toLowerCase();
        return /(switch|range|segmented|stepper)/.test(a) && (n = a), n
    }

    function te(e) {
        var t = ue.themes.form[e];
        return t && t.addRipple ? t : null
    }

    function ae() {
        clearTimeout(jt), jt = setTimeout(function() {
            Le("textarea.mbsc-control").each(function() {
                ne(this)
            })
        }, 100)
    }

    function ne(e) {
        var t = void 0,
            a = void 0,
            n = void 0,
            s = Le(e).attr("rows") || 6;
        e.offsetHeight && (e.style.height = "", n = e.scrollHeight - e.offsetHeight, t = e.offsetHeight + (n > 0 ? n : 0), a = Math.round(t / 24), a > s ? (e.scrollTop = t, t = 24 * s + (t - 24 * a), Le(e).addClass("mbsc-textarea-scroll")) : Le(e).removeClass("mbsc-textarea-scroll"), t && (e.style.height = t + "px"))
    }

    function se(e) {
        if (!Le(e).hasClass("mbsc-textarea-scroll")) {
            var t = e.scrollHeight - e.offsetHeight,
                a = e.offsetHeight + t;
            e.scrollTop = 0, e.style.height = a + "px"
        }
    }

    function re(e) {
        for (var t = 0, a = 1, n = 0; e.length;) t > 3 ? a = 3600 : t > 1 && (a = 60), n += e.pop() * a * (t % 2 ? 10 : 1), t++;
        return n
    }

  

    function oe(e, t) {
        var a = new XMLHttpRequest;
        a.open("GET", e, !0), a.onload = function() {
            this.status >= 200 && this.status < 400 && t(JSON.parse(this.response))
        }, a.onerror = function() {}, a.send()
    }

    function le(e, t, a) {
        "jsonp" == a ? ie(e, t) : oe(e, t)
    }

    function ce(e, t) {
        var a = v(t, "X", !0),
            n = v(t, "Y", !0),
            s = e.offset(),
            r = a - s.left,
            i = n - s.top,
            o = Math.max(r, e[0].offsetWidth - r),
            l = Math.max(i, e[0].offsetHeight - i),
            c = 2 * Math.sqrt(Math.pow(o, 2) + Math.pow(l, 2));
        de(za), za = Le('<span class="mbsc-ripple"></span>').css({
            width: c,
            height: c,
            top: n - s.top - c / 2,
            left: a - s.left - c / 2
        }).appendTo(e), setTimeout(function() {
            za.addClass("mbsc-ripple-scaled mbsc-ripple-visible")
        }, 10)
    }

    function de(e) {
        setTimeout(function() {
            e && (e.removeClass("mbsc-ripple-visible"), setTimeout(function() {
                e.remove()
            }, 2e3))
        }, 100)
    }

    function me(e, t, a, n) {
        var s, r;
        e.off(".mbsc-ripple").on("touchstart.mbsc-ripple mousedown.mbsc-ripple", t, function(e) {
            C(e, this) && (s = v(e, "X"), r = v(e, "Y"), Ya = Le(this), Ya.hasClass(a) || Ya.hasClass(n) ? Ya = null : ce(Ya, e))
        }).on("touchmove.mbsc-ripple mousemove.mbsc-ripple", t, function(e) {
            (Ya && Math.abs(v(e, "X") - s) > 9 || Math.abs(v(e, "Y") - r) > 9) && (de(za), Ya = null)
        }).on("touchend.mbsc-ripple touchcancel.mbsc-ripple mouseleave.mbsc-ripple mouseup.mbsc-ripple", t, function() {
            Ya && (setTimeout(function() {
                de(za)
            }, 100), Ya = null)
        })
    }
    var ue = ue || {},
        he = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function(e) {
            return typeof e
        } : function(e) {
            return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
        },
        fe = function(e, t) {
            if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function")
        },
        pe = function() {
            function e(e, t) {
                for (var a = 0; a < t.length; a++) {
                    var n = t[a];
                    n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), Object.defineProperty(e, n.key, n)
                }
            }
            return function(t, a, n) {
                return a && e(t.prototype, a), n && e(t, n), t
            }
        }(),
        be = function e(t, a, n) {
            null === t && (t = Function.prototype);
            var s = Object.getOwnPropertyDescriptor(t, a);
            if (void 0 === s) {
                var r = Object.getPrototypeOf(t);
                return null === r ? void 0 : e(r, a, n)
            }
            if ("value" in s) return s.value;
            var i = s.get;
            if (void 0 !== i) return i.call(n)
        },
        ve = function(e, t) {
            if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
            e.prototype = Object.create(t && t.prototype, {
                constructor: {
                    value: e,
                    enumerable: !1,
                    writable: !0,
                    configurable: !0
                }
            }), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t)
        },
        ge = function(e, t) {
            if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
            return !t || "object" != typeof t && "function" != typeof t ? e : t
        },
        xe = {
            "column-count": 1,
            columns: 1,
            "font-weight": 1,
            "line-height": 1,
            opacity: 1,
            "z-index": 1,
            zoom: 1
        },
        Te = {
            readonly: "readOnly"
        },
        ye = [],
        _e = Array.prototype.slice,
        we = function() {
            var s = function(e) {
                    var t = this,
                        a = 0;
                    for (a = 0; a < e.length; a++) t[a] = e[a];
                    return t.length = e.length, o(this)
                },
                o = function t(a, n) {
                    var r = [],
                        i = 0;
                    if (a && !n && a instanceof s) return a;
                    if (e(a)) return t(document).ready(a);
                    if (a)
                        if ("string" == typeof a) {
                            var o, l, c;
                            if (a = c = a.trim(), c.indexOf("<") >= 0 && c.indexOf(">") >= 0) {
                                var d = "div";
                                for (0 === c.indexOf("<li") && (d = "ul"), 0 === c.indexOf("<tr") && (d = "tbody"), 0 !== c.indexOf("<td") && 0 !== c.indexOf("<th") || (d = "tr"), 0 === c.indexOf("<tbody") && (d = "table"), 0 === c.indexOf("<option") && (d = "select"), l = document.createElement(d), l.innerHTML = c, i = 0; i < l.childNodes.length; i++) r.push(l.childNodes[i])
                            } else
                                for (n || "#" !== a[0] || a.match(/[ .<>:~]/) ? (n instanceof s && (n = n[0]), o = (n || document).querySelectorAll(a)) : o = [document.getElementById(a.split("#")[1])], i = 0; i < o.length; i++) o[i] && r.push(o[i])
                        } else if (a.nodeType || a === window || a === document) r.push(a);
                    else if (a.length > 0 && a[0].nodeType)
                        for (i = 0; i < a.length; i++) r.push(a[i]);
                    else t.isArray(a) && (r = a);
                    return new s(r)
                };
            return s.prototype = {
                ready: function(e) {
                    return (document.attachEvent ? "complete" == document.readyState : "loading" != document.readyState) ? e(o) : document.addEventListener("DOMContentLoaded", function() {
                        e(o)
                    }, !1), this
                },
                concat: ye.concat,
                empty: function() {
                    return this.each(function() {
                        this.innerHTML = ""
                    })
                },
                map: function(e) {
                    return o(o.map(this, function(t, a) {
                        return e.call(t, a, t)
                    }))
                },
                slice: function() {
                    return o(_e.apply(this, arguments))
                },
                addClass: function(e) {
                    if (void 0 === e) return this;
                    for (var t = e.split(" "), a = 0; a < t.length; a++)
                        for (var n = 0; n < this.length; n++) void 0 !== this[n].classList && "" !== t[a] && this[n].classList.add(t[a]);
                    return this
                },
                removeClass: function(e) {
                    if (void 0 === e) return this;
                    for (var t = e.split(" "), a = 0; a < t.length; a++)
                        for (var n = 0; n < this.length; n++) void 0 !== this[n].classList && "" !== t[a] && this[n].classList.remove(t[a]);
                    return this
                },
                hasClass: function(e) {
                    return !!this[0] && this[0].classList.contains(e)
                },
                toggleClass: function(e) {
                    for (var t = e.split(" "), a = 0; a < t.length; a++)
                        for (var n = 0; n < this.length; n++) void 0 !== this[n].classList && this[n].classList.toggle(t[a]);
                    return this
                },
                closest: function(e, a) {
                    var n = this[0],
                        s = !1;
                    for (t(e) && (s = o(e)); n && !(s ? s.indexOf(n) >= 0 : o.matches(n, e));) n = n !== a && n.nodeType !== n.DOCUMENT_NODE && n.parentNode;
                    return o(n)
                },
                attr: function(e, t) {
                    var a;
                    if (1 !== arguments.length || "string" != typeof e) {
                        for (var n = 0; n < this.length; n++)
                            if (2 === arguments.length) this[n].setAttribute(e, t);
                            else
                                for (var s in e) this[n][s] = e[s], this[n].setAttribute(s, e[s]);
                        return this
                    }
                    if (this.length) return a = this[0].getAttribute(e), a || "" === a ? a : void 0
                },
                removeAttr: function(e) {
                    for (var t = 0; t < this.length; t++) this[t].removeAttribute(e);
                    return this
                },
                prop: function(e, t) {
                    if (e = Te[e] || e, 1 === arguments.length && "string" == typeof e) return this[0] ? this[0][e] : void 0;
                    for (var a = 0; a < this.length; a++) this[a][e] = t;
                    return this
                },
                val: function(e) {
                    if (void 0 === e) return this.length && this[0].multiple ? o.map(this.find("option:checked"), function(e) {
                        return e.value
                    }) : this[0] ? this[0].value : void 0;
                    if (this.length && this[0].multiple) o.each(this[0].options, function() {
                        this.selected = -1 != e.indexOf(this.value)
                    });
                    else
                        for (var t = 0; t < this.length; t++) this[t].value = e;
                    return this
                },
                on: function(t, a, n, s) {
                    function r(e) {
                        var t, s, r = e.target;
                        if (o(r).is(a)) n.call(r, e);
                        else
                            for (s = o(r).parents(), t = 0; t < s.length; t++) o(s[t]).is(a) && n.call(s[t], e)
                    }

                    function i(e, t, a, n) {
                        var s = t.split(".");
                        e.DomNameSpaces || (e.DomNameSpaces = []), e.DomNameSpaces.push({
                            namespace: s[1],
                            event: s[0],
                            listener: a,
                            capture: n
                        }), e.addEventListener(s[0], a, n)
                    }
                    var l, c, d = t.split(" ");
                    for (l = 0; l < this.length; l++)
                        if (e(a) || !1 === a)
                            for (e(a) && (s = n || !1, n = a), c = 0; c < d.length; c++) - 1 != d[c].indexOf(".") ? i(this[l], d[c], n, s) : this[l].addEventListener(d[c], n, s);
                        else
                            for (c = 0; c < d.length; c++) this[l].DomLiveListeners || (this[l].DomLiveListeners = []), this[l].DomLiveListeners.push({
                                listener: n,
                                liveListener: r
                            }), -1 != d[c].indexOf(".") ? i(this[l], d[c], r, s) : this[l].addEventListener(d[c], r, s);
                    return this
                },
                off: function(t, a, n, s) {
                    function r(e) {
                        var t, a, n, s = e.split("."),
                            r = s[0],
                            i = s[1];
                        for (t = 0; t < d.length; ++t)
                            if (d[t].DomNameSpaces) {
                                for (a = 0; a < d[t].DomNameSpaces.length; ++a) n = d[t].DomNameSpaces[a], n.namespace != i || n.event != r && r || (d[t].removeEventListener(n.event, n.listener, n.capture), n.removed = !0);
                                for (a = d[t].DomNameSpaces.length - 1; a >= 0; --a) d[t].DomNameSpaces[a].removed && d[t].DomNameSpaces.splice(a, 1)
                            }
                    }
                    var i, o, l, c, d = this;
                    for (i = t.split(" "), o = 0; o < i.length; o++)
                        for (l = 0; l < this.length; l++)
                            if (e(a) || !1 === a) e(a) && (s = n || !1, n = a), 0 === i[o].indexOf(".") ? r(i[o].substr(1)) : this[l].removeEventListener(i[o], n, s);
                            else {
                                if (this[l].DomLiveListeners)
                                    for (c = 0; c < this[l].DomLiveListeners.length; c++) this[l].DomLiveListeners[c].listener === n && this[l].removeEventListener(i[o], this[l].DomLiveListeners[c].liveListener, s);
                                this[l].DomNameSpaces && this[l].DomNameSpaces.length && i[o] && r(i[o])
                            }
                    return this
                },
                trigger: function(e, t) {
                    for (var a = e.split(" "), n = 0; n < a.length; n++)
                        for (var s = 0; s < this.length; s++) {
                            var r;
                            try {
                                r = new CustomEvent(a[n], {
                                    detail: t,
                                    bubbles: !0,
                                    cancelable: !0
                                })
                            } catch (e) {
                                r = document.createEvent("Event"), r.initEvent(a[n], !0, !0), r.detail = t
                            }
                            this[s].dispatchEvent(r)
                        }
                    return this
                },
                width: function(e) {
                    return void 0 !== e ? this.css("width", e) : this[0] === window ? window.innerWidth : this[0] === document ? document.documentElement.scrollWidth : this.length > 0 ? parseFloat(this.css("width")) : null
                },
                height: function(e) {
                    if (void 0 !== e) return this.css("height", e);
                    if (this[0] === window) return window.innerHeight;
                    if (this[0] === document) {
                        var t = document.body,
                            a = document.documentElement;
                        return Math.max(t.scrollHeight, t.offsetHeight, a.clientHeight, a.scrollHeight, a.offsetHeight)
                    }
                    return this.length > 0 ? parseFloat(this.css("height")) : null
                },
                innerWidth: function() {
                    var e = this;
                    if (this.length > 0) {
                        if (this[0].innerWidth) return this[0].innerWidth;
                        var t = this[0].offsetWidth;
                        return ["left", "right"].forEach(function(a) {
                            t -= parseInt(e.css(n("border-" + a + "-width")) || 0, 10)
                        }), t
                    }
                },
                innerHeight: function() {
                    var e = this;
                    if (this.length > 0) {
                        if (this[0].innerHeight) return this[0].innerHeight;
                        var t = this[0].offsetHeight;
                        return ["top", "bottom"].forEach(function(a) {
                            t -= parseInt(e.css(n("border-" + a + "-width")) || 0, 10)
                        }), t
                    }
                },
                offset: function() {
                    if (this.length > 0) {
                        var e = this[0],
                            t = e.getBoundingClientRect(),
                            a = document.documentElement;
                        return {
                            top: t.top + window.pageYOffset - a.clientTop,
                            left: t.left + window.pageXOffset - a.clientLeft
                        }
                    }
                },
                hide: function() {
                    for (var e = 0; e < this.length; e++) this[e].style.display = "none";
                    return this
                },
                show: function() {
                    for (var e = 0; e < this.length; e++) "none" == this[e].style.display && (this[e].style.display = ""), "none" == getComputedStyle(this[e], "").getPropertyValue("display") && (this[e].style.display = "block");
                    return this
                },
                clone: function() {
                    return this.map(function() {
                        return this.cloneNode(!0)
                    })
                },
                styles: function() {
                    return this[0] ? window.getComputedStyle(this[0], null) : void 0
                },
                css: function(e, t) {
                    var a, n, s = this[0],
                        o = "";
                    if (arguments.length < 2) {
                        if (!s) return;
                        if ("string" == typeof e) return s.style[e] || getComputedStyle(s, "").getPropertyValue(e)
                    }
                    if ("string" == typeof e) t || 0 === t ? o = r(e) + ":" + i(e, t) : this.each(function() {
                        this.style.removeProperty(r(e))
                    });
                    else
                        for (n in e)
                            if (e[n] || 0 === e[n]) o += r(n) + ":" + i(n, e[n]) + ";";
                            else
                                for (a = 0; a < this.length; a++) this[a].style.removeProperty(r(n));
                    return this.each(function() {
                        this.style.cssText += ";" + o
                    })
                },
                each: function(e) {
                    for (var t = 0; t < this.length && !1 !== e.apply(this[t], [t, this[t]]); t++);
                    return this
                },
                filter: function(t) {
                    for (var a = [], n = 0; n < this.length; n++) e(t) ? t.call(this[n], n, this[n]) && a.push(this[n]) : o.matches(this[n], t) && a.push(this[n]);
                    return new s(a)
                },
                html: function(e) {
                    if (void 0 === e) return this[0] ? this[0].innerHTML : void 0;
                    this.empty();
                    for (var t = 0; t < this.length; t++) this[t].innerHTML = e;
                    return this
                },
                text: function(e) {
                    if (void 0 === e) return this[0] ? this[0].textContent.trim() : null;
                    for (var t = 0; t < this.length; t++) this[t].textContent = e;
                    return this
                },
                is: function(e) {
                    return this.length > 0 && o.matches(this[0], e)
                },
                not: function(n) {
                    var s = [];
                    if (e(n) && void 0 !== n.call) this.each(function(e) {
                        n.call(this, e) || s.push(this)
                    });
                    else {
                        var r = "string" == typeof n ? this.filter(n) : a(n) && e(n.item) ? _e.call(n) : o(n);
                        t(r) && (r = o.map(r, function(e) {
                            return e
                        })), this.each(function(e, t) {
                            r.indexOf(t) < 0 && s.push(t)
                        })
                    }
                    return o(s)
                },
                indexOf: function(e) {
                    for (var t = 0; t < this.length; t++)
                        if (this[t] === e) return t
                },
                index: function(e) {
                    return e ? this.indexOf(o(e)[0]) : this.parent().children().indexOf(this[0])
                },
                get: function(e) {
                    return void 0 === e ? _e.call(this) : this[e >= 0 ? e : e + this.length]
                },
                eq: function(e) {
                    if (void 0 === e) return this;
                    var t, a = this.length;
                    return e > a - 1 ? new s([]) : e < 0 ? (t = a + e, new s(t < 0 ? [] : [this[t]])) : new s([this[e]])
                },
                append: function(e) {
                    var t, a;
                    for (t = 0; t < this.length; t++)
                        if ("string" == typeof e) {
                            var n = document.createElement("div");
                            for (n.innerHTML = e; n.firstChild;) this[t].appendChild(n.firstChild)
                        } else if (e instanceof s)
                        for (a = 0; a < e.length; a++) this[t].appendChild(e[a]);
                    else this[t].appendChild(e);
                    return this
                },
                appendTo: function(e) {
                    return o(e).append(this), this
                },
                prepend: function(e) {
                    var t, a;
                    for (t = 0; t < this.length; t++)
                        if ("string" == typeof e) {
                            var n = document.createElement("div");
                            for (n.innerHTML = e, a = n.childNodes.length - 1; a >= 0; a--) this[t].insertBefore(n.childNodes[a], this[t].childNodes[0])
                        } else if (e instanceof s)
                        for (a = 0; a < e.length; a++) this[t].insertBefore(e[a], this[t].childNodes[0]);
                    else this[t].insertBefore(e, this[t].childNodes[0]);
                    return this
                },
                prependTo: function(e) {
                    return o(e).prepend(this), this
                },
                insertBefore: function(e) {
                    for (var t = o(e), a = 0; a < this.length; a++)
                        if (1 === t.length) t[0].parentNode.insertBefore(this[a], t[0]);
                        else if (t.length > 1)
                        for (var n = 0; n < t.length; n++) t[n].parentNode.insertBefore(this[a].cloneNode(!0), t[n]);
                    return this
                },
                insertAfter: function(e) {
                    for (var t = o(e), a = 0; a < this.length; a++)
                        if (1 === t.length) t[0].parentNode.insertBefore(this[a], t[0].nextSibling);
                        else if (t.length > 1)
                        for (var n = 0; n < t.length; n++) t[n].parentNode.insertBefore(this[a].cloneNode(!0), t[n].nextSibling);
                    return this
                },
                next: function(e) {
                    return new s(this.length > 0 ? e ? this[0].nextElementSibling && o(this[0].nextElementSibling).is(e) ? [this[0].nextElementSibling] : [] : this[0].nextElementSibling ? [this[0].nextElementSibling] : [] : [])
                },
                nextAll: function(e) {
                    var t = [],
                        a = this[0];
                    if (!a) return new s([]);
                    for (; a.nextElementSibling;) {
                        var n = a.nextElementSibling;
                        e ? o(n).is(e) && t.push(n) : t.push(n), a = n
                    }
                    return new s(t)
                },
                prev: function(e) {
                    return new s(this.length > 0 ? e ? this[0].previousElementSibling && o(this[0].previousElementSibling).is(e) ? [this[0].previousElementSibling] : [] : this[0].previousElementSibling ? [this[0].previousElementSibling] : [] : [])
                },
                prevAll: function(e) {
                    var t = [],
                        a = this[0];
                    if (!a) return new s([]);
                    for (; a.previousElementSibling;) {
                        var n = a.previousElementSibling;
                        e ? o(n).is(e) && t.push(n) : t.push(n), a = n
                    }
                    return new s(t)
                },
                parent: function(e) {
                    for (var t = [], a = 0; a < this.length; a++) null !== this[a].parentNode && (e ? o(this[a].parentNode).is(e) && t.push(this[a].parentNode) : t.push(this[a].parentNode));
                    return o(o.unique(t))
                },
                parents: function(e) {
                    for (var t = [], a = 0; a < this.length; a++)
                        for (var n = this[a].parentNode; n;) e ? o(n).is(e) && t.push(n) : t.push(n), n = n.parentNode;
                    return o(o.unique(t))
                },
                find: function(e) {
                    for (var t = [], a = 0; a < this.length; a++)
                        for (var n = this[a].querySelectorAll(e), r = 0; r < n.length; r++) t.push(n[r]);
                    return new s(t)
                },
                children: function(e) {
                    for (var t = [], a = 0; a < this.length; a++)
                        for (var n = this[a].childNodes, r = 0; r < n.length; r++) e ? 1 === n[r].nodeType && o(n[r]).is(e) && t.push(n[r]) : 1 === n[r].nodeType && t.push(n[r]);
                    return new s(o.unique(t))
                },
                remove: function() {
                    for (var e = 0; e < this.length; e++) this[e].parentNode && this[e].parentNode.removeChild(this[e]);
                    return this
                },
                add: function() {
                    var e, t, a = this;
                    for (e = 0; e < arguments.length; e++) {
                        var n = o(arguments[e]);
                        for (t = 0; t < n.length; t++) a[a.length] = n[t], a.length++
                    }
                    return a
                },
                before: function(e) {
                    return o(e).insertBefore(this), this
                },
                after: function(e) {
                    return o(e).insertAfter(this), this
                },
                scrollTop: function(e) {
                    if (this.length) {
                        var t = "scrollTop" in this[0];
                        return void 0 === e ? t ? this[0].scrollTop : this[0].pageYOffset : this.each(t ? function() {
                            this.scrollTop = e
                        } : function() {
                            this.scrollTo(this.scrollX, e)
                        })
                    }
                },
                scrollLeft: function(e) {
                    if (this.length) {
                        var t = "scrollLeft" in this[0];
                        return void 0 === e ? t ? this[0].scrollLeft : this[0].pageXOffset : this.each(t ? function() {
                            this.scrollLeft = e
                        } : function() {
                            this.scrollTo(e, this.scrollY)
                        })
                    }
                },
                contents: function() {
                    return this.map(function(e, t) {
                        return _e.call(t.childNodes)
                    })
                },
                nextUntil: function(e) {
                    for (var t = this, a = []; t.length && !t.filter(e).length;) a.push(t[0]), t = t.next();
                    return o(a)
                },
                prevUntil: function(e) {
                    for (var t = this, a = []; t.length && !o(t).filter(e).length;) a.push(t[0]), t = t.prev();
                    return o(a)
                },
                detach: function() {
                    return this.remove()
                }
            }, o.fn = s.prototype, o
        }(),
        Me = we;
    ue.$ = we, Me.inArray = function(e, t, a) {
        return ye.indexOf.call(t, e, a)
    }, Me.extend = function(e) {
        var t, a = _e.call(arguments, 1);
        return "boolean" == typeof e && (t = e, e = a.shift()), e = e || {}, a.forEach(function(a) {
            s(e, a, t)
        }), e
    }, Me.isFunction = e, Me.isArray = function(e) {
        return "[object Array]" === Object.prototype.toString.apply(e)
    }, Me.isPlainObject = function(e) {
        return t(e) && null !== e && e !== e.window && Object.getPrototypeOf(e) == Object.prototype
    }, Me.each = function(e, a) {
        var n, s;
        if (t(e) && a) {
            if (Me.isArray(e) || e instanceof we)
                for (n = 0; n < e.length && !1 !== a.call(e[n], n, e[n]); n++);
            else
                for (s in e)
                    if (e.hasOwnProperty(s) && "length" !== s && !1 === a.call(e[s], s, e[s])) break;
            return this
        }
    }, Me.unique = function(e) {
        for (var t = [], a = 0; a < e.length; a++) - 1 === t.indexOf(e[a]) && t.push(e[a]);
        return t
    }, Me.map = function(e, t) {
        var n, s, r, i = [];
        if (a(e))
            for (s = 0; s < e.length; s++) null !== (n = t(e[s], s)) && i.push(n);
        else
            for (r in e) null !== (n = t(e[r], r)) && i.push(n);
        return i.length > 0 ? Me.fn.concat.apply([], i) : i
    }, Me.matches = function(e, t) {
        return !(!t || !e || 1 !== e.nodeType) && (e.matchesSelector || e.webkitMatchesSelector || e.mozMatchesSelector || e.msMatchesSelector).call(e, t)
    }, ue.presetShort = function(e, t, a) {
        ue[e] = function(n, s) {
            var r, i, o = {},
                l = s || {};
            return Me.extend(l, {
                preset: !1 === a ? void 0 : e
            }), Me(n).each(function() {
                r = new ue.classes[t || "Scroller"](this, l), o[this.id] = r
            }), i = Object.keys(o), 1 == i.length ? o[i[0]] : o
        }
    };
    var Se, Ce, ke, De, Ne = [],
        Ae = "undefined" != typeof window,
        Ve = Ae ? navigator.userAgent : "",
        Ie = Ve.match(/Android|iPhone|iPad|iPod|Windows Phone|Windows|MSIE/i),
        Fe = Ae && window.requestAnimationFrame || function(e) {
            e()
        },
        He = Ae && window.cancelAnimationFrame || function() {};
    /Android/i.test(Ie) ? (Se = "android", (Ce = Ve.match(/Android\s+([\d\.]+)/i)) && (Ne = Ce[0].replace("Android ", "").split("."))) : /iPhone|iPad|iPod/i.test(Ie) ? (Se = "ios", (Ce = Ve.match(/OS\s+([\d\_]+)/i)) && (Ne = Ce[0].replace(/_/g, ".").replace("OS ", "").split("."))) : /Windows Phone/i.test(Ie) ? Se = "wp" : /Windows|MSIE/i.test(Ie) && (Se = "windows"), ke = Ne[0], De = Ne[1];
    var Pe = 0;
    Ae && (["mouseover", "mousedown", "mouseup", "click"].forEach(function(e) {
        document.addEventListener(e, x, !0)
    }), "android" == Se && ke < 5 && document.addEventListener("change", function(e) {
        Pe && "checkbox" == e.target.type && !e.target.mbscChange && (e.stopPropagation(), e.preventDefault()), delete e.target.mbscChange
    }, !0));
    var Oe, Le = ue.$,
        Ee = +new Date,
        Ye = {},
        ze = Le.extend;
    Oe = ze(ue, {
        $: Le,
        version: "4.0.0-beta",
        util: {
            getCoord: v,
            preventClick: p,
            vibrate: f
        },
        autoTheme: "mobiscroll",
        presets: {
            scroller: {},
            numpad: {}
        },
        themes: {
            form: {},
            page: {},
            frame: {},
            scroller: {},
            listview: {},
            navigation: {},
            progress: {}
        },
        platform: {
            name: Se,
            majorVersion: ke,
            minorVersion: De
        },
        i18n: {},
        instances: Ye,
        classes: {},
        components: {},
        settings: {},
        setDefaults: function(e) {
            ze(this.settings, e)
        },
        customTheme: function(e, t) {
            var a, n = ue.themes,
                s = ["frame", "scroller", "listview", "navigation", "form", "page", "progress"];
            for (a = 0; a < s.length; a++) n[s[a]][e] = ze({}, n[s[a]][t], {
                baseTheme: t
            })
        }
    }), Oe.presetShort = Oe.presetShort || function() {};
    var je = function(e, t) {
        var a, n, s, r, i, l, c, d = this;
        d.settings = {}, d._init = o, d._destroy = o, d._processSettings = o, d.init = function(o) {
            var m;
            for (m in d.settings) delete d.settings[m];
            s = d.settings, ze(t, o), d._hasDef && (c = Oe.settings), ze(s, d._defaults, c, t), d._hasTheme && (i = s.theme, "auto" != i && i || (i = Oe.autoTheme), "default" == i && (i = "mobiscroll"), t.theme = i, r = Oe.themes[d._class] ? Oe.themes[d._class][i] : {}), d._hasLang && (a = Oe.i18n[s.lang]), d._hasTheme && l("onThemeLoad", {
                lang: a,
                settings: t
            }), ze(s, r, a, c, t), d._processSettings();
            var u = {
                form: !0,
                page: !0,
                progress: !0,
                switch: !0,
                slider: !0,
                stepper: !0
            };
            if (!d._class || u[d._class]) d._init(o), l("onInit");
            else {
                var h, f, p = {
                        className: d._class,
                        buttons: d.buttons,
                        platform: Oe.platform,
                        userAgent: navigator.userAgent,
                        defSortHandle: Le(e).find(s.listSelector || "ul,ol").length ? "left" : "right",
                        settings: {
                            activeClass: s.activeClass,
                            ampmText: s.ampmText,
                            amText: s.amText,
                            animateIcons: s.animateIcons,
                            backText: s.backText,
                            baseTheme: s.baseTheme,
                            buttons: s.buttons,
                            btnClass: s.btnClass,
                            btnWidth: s.btnWidth,
                            btnReverse: s.btnReverse,
                            closeIcon: s.closeIcon,
                            context: "body" == s.context ? "body" : "",
                            controls: s.controls,
                            cssClass: s.cssClass,
                            dateDisplay: s.dateDisplay,
                            dateFormat: s.dateFormat,
                            dateWheels: s.dateWheels,
                            dayNames: s.dayNames,
                            dayNamesShort: s.dayNamesShort,
                            daySuffix: s.daySuffix,
                            display: s.display,
                            dayText: s.dayText,
                            endYear: s.endYear,
                            fixedHeader: s.fixedHeader,
                            handleClass: s.handleClass,
                            handleMarkup: s.handleMarkup,
                            hideText: s.hideText,
                            hourText: s.hourText,
                            itemNode: s.itemNode,
                            itemWidth: s.itemWidth,
                            lang: s.lang,
                            lapIcon: s.lapIcon,
                            lapText: s.lapText,
                            layout: s.layout,
                            leftArrowClass: s.leftArrowClass,
                            max: s.max,
                            min: s.min,
                            minuteText: s.minuteText,
                            monthNames: s.monthNames,
                            monthNamesShort: s.monthNamesShort,
                            monthSuffix: s.monthSuffix,
                            monthText: s.monthText,
                            nowIcon: s.nowIcon,
                            nowText: s.nowText,
                            pmText: s.pmText,
                            preset: s.preset,
                            resetIcon: s.resetIcon,
                            resetText: s.resetText,
                            rightArrowClass: s.rightArrowClass,
                            rtl: s.rtl,
                            secText: s.secText,
                            select: s.select,
                            snap: s.snap,
                            sort: s.sort,
                            sortable: s.sortable,
                            sortHandle: s.sortHandle,
                            startIcon: s.startIcon,
                            startText: s.startText,
                            startYear: s.startYear,
                            stepHour: s.stepHour,
                            stepMinute: s.stepMinute,
                            stepSecond: s.stepSecond,
                            steps: s.steps,
                            stopIcon: s.stopIcon,
                            stopText: s.stopText,
                            striped: s.striped,
                            theme: s.theme,
                            timeFormat: s.timeFormat,
                            timeWheels: s.timeWheels,
                            todayText: s.todayText,
                            type: s.type,
                            variant: s.variant,
                            wrapperClass: s.wrapperClass,
                            yearSuffix: s.yearSuffix,
                            yearText: s.yearText
                        }
                    },
                    b = [],
                    v = {},
                    g = ["refresh", "redraw", "navigate", "changeTab", "getDate", "setDate", "addEvent", "removeEvent", "getEvents", "setEvents", "setActiveDate", "start", "stop", "reset", "lap", "resetlap", "getTime", "setTime", "getEllapsedTime", "setEllapsedTime"],
                    x = {
                        jsonp: 1,
                        getInst: 1,
                        init: 1,
                        destroy: 1
                    },
                    T = function(e) {
                        d[e] = function() {
                            b.push({
                                func: e,
                                args: arguments
                            })
                        }
                    };
                for (f in d) "function" != typeof d[f] || x[f] || (v[f] = d[f], T(f));
                for (h = 0; h < g.length; h++) T(g[h]);
                "timer" != s.preset || t.buttons || (p.settings.buttons = ["toggle", "resetlap"], "inline" !== s.display && p.settings.buttons.push("hide")), "eventcalendar" != s.preset || t.buttons || "inline" == s.display || (p.settings.buttons = ["close"]), 
			
                    d.zone.run(function() {
                        if (d) {
                            for (f in v) d[f] = v[f];
                            var r = ze({}, t);
                            for (delete r.data, d._hasPreset && (n = Oe.presets[d._class][s.preset]) && (n = n.call(e, d), ze(s, n, r)), d._init(o), l("onInit"), h = 0; h < b.length; h++) d[b[h].func].apply(d, b[h].args);
                            b = null, v = null
                        }
                    })

            }
        },
		 d.destroy = function() {
            d && (d._destroy(), l("onDestroy"), delete Ye[e.id], d = null)
        }, d.tap = function(e, t, a, n, s) {
            g(d, e, t, a, n, s)
        }, d.trigger = function(a, s) {
            var i, o, l, m = [c, r, n, t];
            for (o = 0; o < 4; o++)(l = m[o]) && l[a] && (i = l[a].call(e, s || {}, d));
            return i
        }, d.option = function(e, t) {
            var a = {};
            "object" === (void 0 === e ? "undefined" : he(e)) ? a = e: a[e] = t, d.init(a)
        }, d.getInst = function() {
            return d
        }, d.zone = {
            run: function(e) {
                e()
            }
        }, t = t || {}, l = d.trigger, d.__ready || function() {
            Le(e).addClass("mbsc-comp"), e.id ? Ye[e.id] && Ye[e.id].destroy() : e.id = "mobiscroll" + ++Ee, Ye[e.id] = d, d.__ready = !0
        }()
    };
    Ae && Le(function() {
        (document.cookie.replace(/(?:(?:^|.*;\s*)mobiscrollClientError\s*\=\s*([^;]*).*$)|^.*$/, "$1") || /mobiscrollClientError/.test(window.name || "")) && ""
    });
    var We = {
        shortYearCutoff: "+10",
        monthNames: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
        monthNamesShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        dayNames: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
        dayNamesShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
        dayNamesMin: ["S", "M", "T", "W", "T", "F", "S"],
        amText: "am",
        pmText: "pm",
        getYear: function(e) {
            return e.getFullYear()
        },
        getMonth: function(e) {
            return e.getMonth()
        },
        getDay: function(e) {
            return e.getDate()
        },
        getDate: _,
        getMaxDayOfMonth: function(e, t) {
            return 32 - new Date(e, t, 32, 12).getDate()
        },
        getWeekNumber: function(e) {
            e = new Date(e), e.setHours(0, 0, 0), e.setDate(e.getDate() + 4 - (e.getDay() || 7));
            var t = new Date(e.getFullYear(), 0, 1);
            return Math.ceil(((e - t) / 864e5 + 1) / 7)
        }
    };
    ue.util.datetime = {
        formatDate: w,
        parseDate: M,
		adjustedDate : _,
		defaults : We
    };
    var $e, Re, Je, Ke, Be = {};
    Ae && (Re = document.createElement("modernizr").style, Je = function() {
        var e, t = ["Webkit", "Moz", "O", "ms"];
        for (e in t)
            if (S([t[e] + "Transform"])) return "-" + t[e].toLowerCase() + "-";
        return ""
    }(), Ke = Je.replace(/^\-/, "").replace(/\-$/, "").replace("moz", "Moz"), $e = void 0 !== Re.animation ? "animationend" : "webkitAnimationEnd");
    var Ue, qe, Ge = ue.classes,
        Xe = ue.themes,
        Ze = /(iphone|ipod)/i.test(Ve) && ke >= 7,
        Qe = "android" == Se,
        et = "ios" == Se,
        tt = et && 8 == ke,
        at = et && ke > 7,
        nt = function(e) {
            e.preventDefault()
        },
        st = function(e, t, a) {
            function n(e) {
                A && A.removeClass("mbsc-fr-btn-a"), A = Le(this), A.hasClass("mbsc-fr-btn-d") || A.hasClass("mbsc-fr-btn-nhl") || A.addClass("mbsc-fr-btn-a"), "mousedown" === e.type ? Le(document).on("mouseup", s) : "pointerdown" === e.type && Le(document).on("pointerup", s)
            }

            function s(e) {
                A && (A.removeClass("mbsc-fr-btn-a"), A = null), "mouseup" === e.type ? Le(document).off("mouseup", s) : "pointerup" === e.type && Le(document).off("pointerup", s)
            }

            function r(e) {
                13 == e.keyCode ? Q.select() : 27 == e.keyCode && Q.cancel()
            }

            function i(e) {
                e || Qe || j.focus(), Q.ariaMessage(J.ariaMessage)
            }

            function l(e) {
                var t = Ue,
                    a = J.focusOnClose;
                Q._markupRemove(), w.remove(), H && (V.mbscModals--, J.scrollLock && V.mbscLock--, V.mbscLock || _.removeClass("mbsc-fr-lock"), V.mbscModals || (_.removeClass("mbsc-fr-lock-ios mbsc-fr-lock-ctx"), z && (T.css({
                    top: "",
                    left: ""
                }), k.scrollLeft(K), k.scrollTop(U)), e || (t || (t = ee), setTimeout(function() {
                    void 0 === a || !0 === a ? (qe = !0, t[0].focus()) : a && Le(a)[0].focus()
                }, 200)))), Q._isVisible = !1, P = !1, G("onHide")
            }

            function c(e) {
                clearTimeout(ae[e.type]), ae[e.type] = setTimeout(function() {
                    var t = "scroll" == e.type;
                    t && !B || (Q.position(!t), "orientationchange" == e.type && (W.style.display = "none", W.offsetHeight, W.style.display = ""))
                }, 200)
            }

            function d(e) {
                e.target.nodeType && !j.contains(e.target) && j.focus()
            }

            function h(e, t) {
                e && e(), !1 !== Q.show() && (Ue = t)
            }

            function f() {
                Q._fillValue(), G("onSet", {
                    valueText: Q._value
                })
            }

            function b() {
                G("onCancel", {
                    valueText: Q._value
                })
            }

            function g() {
                Q.setVal(null, !0)
            }
            var x, T, y, _, w, M, S, C, k, D, N, A, V, I, F, H, P, O, L, E, Y, z, j, W, $, R, J, K, B, U, q, G, X, Z, Q = this,
                ee = Le(e),
                te = [],
                ae = {};
            je.call(this, e, t, !0), Q.position = function(e) {
                var t, a, n, s, r, i, o, l, c, d, m, h, f, p, b, v, g, x = {},
                    y = 0,
                    _ = 0,
                    M = 0,
                    N = 0;
                !R && P && (Q._position(w), f = O.offsetHeight, p = O.offsetWidth, X === p && Z === f && e || (Q._isFullScreen || /top|bottom/.test(J.display) ? C.width(p) : D.width(""), Le(".mbsc-comp", w).each(function() {
                    var e = ue.instances[this.id];
                    e && e !== Q && e.position && e.position()
                }), !Q._isFullScreen && /center|bubble/.test(J.display) && (Le(".mbsc-w-p", w).each(function() {
                    b = this.getBoundingClientRect().width, N += b, M = b > M ? b : M
                }), h = N > p - 16 || !0 === J.tabs, D.css({
                    width: Q._isLiquid ? Math.min(J.maxPopupWidth, p - 16) : Math.ceil(h ? M : N),
                    "white-space": h ? "" : "nowrap"
                })), !1 !== G("onPosition", {
                    target: O,
                    popup: W,
                    hasTabs: h,
                    windowWidth: p,
                    windowHeight: f
                }) && H && (L = W.offsetWidth, E = W.offsetHeight, B = E <= f && L <= p, Y && (y = k.scrollLeft(), _ = k.scrollTop()), "center" == J.display ? (g = Math.max(0, y + (p - L) / 2), v = Math.max(0, _ + (f - E) / 2)) : "bubble" == J.display ? (t = void 0 === J.anchor ? ee : Le(J.anchor), o = Le(".mbsc-fr-arr-i", w)[0], s = t.offset(), r = s.top + (F ? _ - T.offset().top : 0), i = s.left + (F ? y - T.offset().left : 0), a = t[0].offsetWidth, n = t[0].offsetHeight, l = o.offsetWidth, c = o.offsetHeight, g = u(i - (L - a) / 2, y + 3, y + p - L - 3), v = r - E - c / 2, v < _ || r > _ + f ? (C.removeClass("mbsc-fr-bubble-top").addClass("mbsc-fr-bubble-bottom"), v = r + n + c / 2) : C.removeClass("mbsc-fr-bubble-bottom").addClass("mbsc-fr-bubble-top"), Le(".mbsc-fr-arr", w).css({
                    left: u(i + a / 2 - (g + (L - l) / 2), 0, l)
                }), B = v > _ && g > y && v + E <= _ + f && g + L <= y + p) : (g = y, v = "top" == J.display ? _ : Math.max(0, _ + f - E)), Y && (d = Math.max(v + E, F ? V.scrollHeight : Le(document).height()), m = Math.max(g + L, F ? V.scrollWidth : Le(document).width()), S.css({
                    width: m,
                    height: d
                }), J.scroll && "bubble" == J.display && (v + E + 8 > _ + f || r > _ + f || r + n < _) && (R = !0, setTimeout(function() {
                    R = !1
                }, 300), k.scrollTop(Math.min(r, v + E - f + 8, d - f)))), x.top = Math.floor(v), x.left = Math.floor(g), C.css(x), X = p, Z = f)))
            }, Q.attachShow = function(e, t) {
                var a, n = Le(e),
                    s = n.prop("readonly");
                if ("inline" !== J.display) {
                    if ((J.showOnFocus || J.showOnTap) && n.is("input,select") && (n.prop("readonly", !0).on("mousedown.mbsc", function(e) {
                            e.preventDefault()
                        }).on("focus.mbsc", function() {
                            Q._isVisible && this.blur()
                        }), a = Le('label[for="' + n.attr("id") + '"]'), a.length || (a = n.closest("label"))), n.is("select")) return;
                    J.showOnFocus && n.on("focus.mbsc", function() {
                        qe ? qe = !1 : h(t, n)
                    }), J.showOnTap && (n.on("keydown.mbsc", function(e) {
                        32 != e.keyCode && 13 != e.keyCode || (e.preventDefault(), e.stopPropagation(), h(t, n))
                    }), Q.tap(n, function() {
                        h(t, n)
                    }), a && a.length && Q.tap(a, function() {
                        h(t, n)
                    })), te.push({
                        readOnly: s,
                        el: n,
                        lbl: a
                    })
                }
            }, Q.select = function() {
                H ? Q.hide(!1, "set", !1, f) : f()
            }, Q.cancel = function() {
                H ? Q.hide(!1, "cancel", !1, b) : b()
            }, Q.clear = function() {
                Q._clearValue(), G("onClear"), H && Q._isVisible && !Q.live ? Q.hide(!1, "clear", !1, g) : g()
            }, Q.enable = function() {
                J.disabled = !1, Q._isInput && ee.prop("disabled", !1)
            }, Q.disable = function() {
                J.disabled = !0, Q._isInput && ee.prop("disabled", !0)
            }, Q.html4 = function(){
				var html = '</div>';
				if (N.length > 0) {
					html += '<div class="mbsc-fr-btn-cont">';
					Le.each(N, function (i, b) {
						b = m(b) ? Q.buttons[b] : b;
		
						if (b.handler === 'set') {
							b.parentClass = 'mbsc-fr-btn-s';
						}
		
						if (b.handler === 'cancel') {
							b.parentClass = 'mbsc-fr-btn-c';
						}
		
						html += '<div' + (J.btnWidth ? ' style="width:' + (100 / N.length) + '%"' : '') + ' class="mbsc-fr-btn-w ' + (b.parentClass || '') + '"><div tabindex="0" role="button" class="mbsc-fr-btn' + i + ' mbsc-fr-btn-e ' + (b.cssClass === undefined ? J.btnClass : b.cssClass) + (b.icon ? ' mbsc-ic mbsc-ic-' + b.icon : '') + '">' + (b.text || '') + '</div></div>';
					});
					html += '</div>';
				}
				html += '</div></div></div></div>' + (H ? '</div></div>' : '');
				return html;
				
			}, Q.show = function(e, t) {
                function a() {
                    w.off($e, a).removeClass("mbsc-anim-in mbsc-anim-trans mbsc-anim-trans-" + I).find(".mbsc-fr-popup").removeClass("mbsc-anim-" + I), i(t)
                }
                var o;
                if (!J.disabled && !Q._isVisible) {
                    if (Q._readValue(), !1 === G("onBeforeShow")) return !1;
                    if (Ue = null, I = J.animate, N = J.buttons || [], Y = F || "bubble" == J.display, z = Ze && !Y && J.scrollLock, N.length > 0, q = !1, !1 !== I && ("top" == J.display ? I = I || "slidedown" : "bottom" == J.display ? I = I || "slideup" : "center" != J.display && "bubble" != J.display || (I = I || "pop")), H && (U = Math.max(0, k.scrollTop()), K = Math.max(0, k.scrollLeft()), X = 0, Z = 0, z && !_.hasClass("mbsc-fr-lock-ios") && T.css({
                            top: -U + "px",
                            left: -K + "px"
                        }),_.addClass((J.scrollLock ? "mbsc-fr-lock" : "") + (z ? " mbsc-fr-lock-ios" : "") + (F ? " mbsc-fr-lock-ctx" : "")), Le(document.activeElement).is("input,textarea") && document.activeElement.blur(), ue.activeInstance && ue.activeInstance.hide(), ue.activeInstance = Q, V.mbscModals = V.mbscModals || 0, V.mbscLock = V.mbscLock || 0, V.mbscModals++, J.scrollLock && V.mbscLock++), o = '<div lang="' + J.lang + '" class="mbsc-fr mbsc-no-touch mbsc-' + J.theme + (J.baseTheme ? ' mbsc-' + J.baseTheme : '') + ' mbsc-fr-' + J.display + ' ' + (J.cssClass || "") + " " + (J.compClass || "") + (Q._isLiquid ? " mbsc-fr-liq" : "") + (at ? " mbsc-fr-hb" : "") + 
						
						(z ? ' mbsc-platform-ios' : '') +
            (N.length > 0 ? (N.length >= 3 ? ' mbsc-fr-btn-block ' : '') : ' mbsc-fr-nobtn') + '">' +
            (H ? '<div class="mbsc-fr-persp"><div class="mbsc-fr-overlay"></div><div role="dialog" tabindex="-1" class="mbsc-fr-scroll">' : '') + // Overlay
            '<div class="mbsc-fr-popup' +
            (J.rtl ? ' mbsc-rtl' : ' mbsc-ltr') +
					
						(J.headerText ? " mbsc-fr-has-hdr" : "") + '">' + ("bubble" === J.display ? '<div class="mbsc-fr-arr-w"><div class="mbsc-fr-arr-i"><div class="mbsc-fr-arr"></div></div></div>' : "") + 
						'<div class="mbsc-fr-w">' + // Popup content
            '<div aria-live="assertive" class="mbsc-fr-aria mbsc-fr-hdn"></div>' + 
			(J.headerText ? '<div class="mbsc-fr-hdr">' + (m(J.headerText) ? J.headerText : "") + "</div>" : "") + '<div class="mbsc-fr-c">', o += Q._generateContent(), o += Q.html4(), 
			w = Le(o), S = Le(".mbsc-fr-persp", w), M = Le(".mbsc-fr-scroll", w), D = Le(".mbsc-fr-w", w), y = Le(".mbsc-fr-hdr", w), C = Le(".mbsc-fr-popup", w), x = Le(".mbsc-fr-aria", w), O = w[0], j = M[0], W = C[0], Q._markup = w, Q._header = y, Q._isVisible = !0, $ = "orientationchange resize", Q._markupReady(w), G("onMarkupReady", {
                            target: O
                        }), H) {
                        if (Le(window).on("keydown", r), J.scrollLock && w.on("touchmove mousewheel wheel", function(e) {
                                B && e.preventDefault()
                            }), J.focusTrap && k.on("focusin", d), J.closeOnOverlayTap) {
                            var l, u, h, f;
                            M.on("touchstart mousedown", function(e) {
                                u || e.target != M[0] || (u = !0, l = !1, h = v(e, "X"), f = v(e, "Y"))
                            }).on("touchmove mousemove", function(e) {
                                u && !l && (Math.abs(v(e, "X") - h) > 9 || Math.abs(v(e, "Y") - f) > 9) && (l = !0)
                            }).on("touchcancel", function() {
                                u = !1
                            }).on("touchend touchcancel mouseup", function(e) {
                                u && !l && (Q.cancel(), "mouseup" != e.type && p()), u = !1
                            })
                        }
                        Y && ($ += " scroll")
                    }
                    setTimeout(function() {
                        if (H) w.appendTo(T);
                        else if (ee.is("div") && !Q._hasContent) ee.empty().append(w);
                        else if (ee.hasClass("mbsc-control")) {
                            var r = ee.closest(".mbsc-control-w");
                            w.insertAfter(r), r.hasClass("mbsc-select") && r.addClass("mbsc-select-inline")
                        } else w.insertAfter(ee);
                        P = !0, Q._markupInserted(w), G("onMarkupInserted", {
                            target: O
                        }), w.on("selectstart mousedown", nt).on("click", ".mbsc-fr-btn-e", nt).on("keydown", ".mbsc-fr-btn-e", function(e) {
                            32 == e.keyCode && (e.preventDefault(), e.stopPropagation(), this.click())
                        }).on("keydown", function(e) {
                            if (32 == e.keyCode) e.preventDefault();
                            else if (9 == e.keyCode && H && J.focusTrap) {
                                var t = w.find('[tabindex="0"]').filter(function() {
                                        return this.offsetWidth > 0 || this.offsetHeight > 0
                                    }),
                                    a = t.index(Le(":focus", w)),
                                    n = t.length - 1,
                                    s = 0;
                                e.shiftKey && (n = 0, s = -1), a === n && (t.eq(s)[0].focus(), e.preventDefault())
                            }
                        }).on("touchstart mousedown pointerdown", ".mbsc-fr-btn-e", n).on("touchend", ".mbsc-fr-btn-e", s), Le("input,select,textarea", w).on("selectstart mousedown", function(e) {
                            e.stopPropagation()
                        }).on("keydown", function(e) {
                            32 == e.keyCode && e.stopPropagation()
                        }), O.addEventListener("touchstart", function() {
                            q || (q = !0, T.find(".mbsc-no-touch").removeClass("mbsc-no-touch"))
                        }, !0), Le.each(N, function(e, t) {
                            Q.tap(Le(".mbsc-fr-btn" + e, w), function(e) {
                                t = m(t) ? Q.buttons[t] : t, (m(t.handler) ? Q.handlers[t.handler] : t.handler).call(this, e, Q)
                            }, !0)
                        }), Q._attachEvents(w), Q.position(), k.on($, c), H && (I && !e ? w.addClass("mbsc-anim-in mbsc-anim-trans mbsc-anim-trans-" + I).on($e, a).find(".mbsc-fr-popup").addClass("mbsc-anim-" + I) : i(t)), G("onShow", {
                            target: O,
                            valueText: Q._tempValue
                        })
                    }, z ? 100 : 0)
                }
            }, Q.hide = function(e, t, a, n) {
                function s() {
                    w.off($e, s), l(e)
                }
                if (!Q._isVisible || !a && !Q._isValid && "set" == t || !a && !1 === G("onBeforeClose", {
                        valueText: Q._tempValue,
                        button: t
                    })) return !1;
                H && (Le(document.activeElement).is("input,textarea") && W.contains(document.activeElement) && document.activeElement.blur(), Le(window).off("keydown", r), delete ue.activeInstance), w && (H && I && !e ? w.addClass("mbsc-anim-out mbsc-anim-trans mbsc-anim-trans-" + I).on($e, s).find(".mbsc-fr-popup").addClass("mbsc-anim-" + I) : l(e), Q._detachEvents(w), k.off($, c).off("focusin", d)), n && n(), ee.trigger("blur"), G("onClose", {
                    valueText: Q._value
                })
            }, Q.ariaMessage = function(e) {
                x.html(""), setTimeout(function() {
                    x.html(e)
                }, 100)
            }, Q.isVisible = function() {
                return Q._isVisible
            }, Q.setVal = o, Q.getVal = o, Q._generateContent = o, Q._attachEvents = o, Q._detachEvents = o, Q._readValue = o, Q._clearValue = o, Q._fillValue = o, Q._markupReady = o, Q._markupInserted = o, Q._markupRemove = o, Q._position = o, Q.__processSettings = o, Q.__init = o, Q.__destroy = o, Q._destroy = function() {
                Q.hide(!0, !1, !0), ee.off(".mbsc"), Le.each(te, function(e, t) {
                    t.el.off(".mbsc").prop("readonly", t.readOnly), t.lbl && t.lbl.off(".mbsc")
                }), Q.__destroy()
            }, Q._processSettings = function() {
                var e, t;
                for (Q.__processSettings(), J.buttons = J.buttons || ("inline" !== J.display ? ["cancel", "set"] : []), J.headerText = void 0 === J.headerText ? "inline" !== J.display && "{value}" : J.headerText, N = J.buttons || [], H = "inline" !== J.display, F = "body" != J.context, T = Le(J.context), _ = F ? T : Le("body,html"), V = T[0], Q._$window = k = Le(F ? J.context : window), Q.live = !0, t = 0; t < N.length; t++) "ok" != (e = N[t]) && "set" != e && "set" != e.handler || (Q.live = !1);
                Q.buttons.set = {
                    text: J.setText,
                    icon: J.setIcon,
                    handler: "set"
                }, Q.buttons.cancel = {
                    text: J.cancelText,
                    icon: J.cancelIcon,
                    handler: "cancel"
                }, Q.buttons.close = {
                    text: J.closeText,
                    icon: J.closeIcon,
                    handler: "cancel"
                }, Q.buttons.clear = {
                    text: J.clearText,
                    icon: J.clearIcon,
                    handler: "clear"
                }, Q._isInput = ee.is("input")
            }, Q._init = function() {
                Q._isVisible && Q.hide(!0, !1, !0), ee.off(".mbsc"), Q.__init(), Q._isLiquid = "liquid" == J.layout, H ? (Q._readValue(), Q._hasContent || Q.attachShow(ee)) : Q.show(), ee.on("change.mbsc", function() {
                    Q._preventChange || Q.setVal(ee.val(), !0, !1), Q._preventChange = !1
                })
            }, Q.buttons = {}, Q.handlers = {
                set: Q.select,
                cancel: Q.cancel,
                clear: Q.clear
            }, Q._value = null, Q._isValid = !0, Q._isVisible = !1, J = Q.settings, G = Q.trigger, a || Q.init(t)
        };
    st.prototype._defaults = {
        lang: "en",
        setText: "Set",
        selectedText: "{count} selected",
        closeText: "Close",
        cancelText: "Cancel",
        clearText: "Clear",
        context: "body",
        maxPopupWidth: 600,
        disabled: !1,
        closeOnOverlayTap: !0,
        showOnFocus: Qe || et,
        showOnTap: !0,
        display: "center",
        scroll: !0,
        scrollLock: !0,
        tap: !0,
        btnClass: "mbsc-fr-btn",
        btnWidth: !0,
        focusTrap: !0,
        focusOnClose: !tt
    }, Ge.Frame = st, Xe.frame.mobiscroll = {
        headerText: !1,
        btnWidth: !1
    }, Xe.scroller.mobiscroll = ze({}, Xe.frame.mobiscroll, {
        rows: 5,
        showLabel: !1,
        selectedLineBorder: 1,
        weekDays: "min",
        checkIcon: "ion-ios7-checkmark-empty",
        btnPlusClass: "mbsc-ic mbsc-ic-arrow-down5",
        btnMinusClass: "mbsc-ic mbsc-ic-arrow-up5",
        btnCalPrevClass: "mbsc-ic mbsc-ic-arrow-left5",
        btnCalNextClass: "mbsc-ic mbsc-ic-arrow-right5"
    }), Ae && Le(window).on("focus", function() {
        Ue && (qe = !0)
    });
    var rt = "ios" == Se,
        it = function(e, t, a) {
            function n(e) {
                G("onStart", {
                    domEvent: e
                }), ae.stopProp && e.stopPropagation(), ae.prevDef && e.preventDefault(), ae.readonly || ae.lock && F || C(e, this) && !I  && (h && h.removeClass("mbsc-btn-a"), D = !1, F || (h = Le(e.target).closest(".mbsc-btn-e", this), h.length && !h.hasClass("mbsc-btn-d") && (D = !0, f = setTimeout(function() {
                    h.addClass("mbsc-btn-a")
                }, 100))), I = !0, L = !1, H = !1, Q.scrolled = F, R = v(e, "X"), J = v(e, "Y"), w = R, b = 0, g = 0, x = 0, $ = new Date, W = +k(B, X) || 0, F && c(W, rt ? 0 : 1), "mousedown" === e.type && Le(document).on("mousemove", s).on("mouseup", i))
            }

            function s(e) {
                I && (ae.stopProp && e.stopPropagation(), w = v(e, "X"), M = v(e, "Y"), b = w - R, g = M - J, x = X ? g : b, D && (Math.abs(g) > ae.thresholdY || Math.abs(b) > ae.thresholdX) && (clearTimeout(f), h.removeClass("mbsc-btn-a"), D = !1), (Q.scrolled || !H && Math.abs(x) > q) && (L || G("onGestureStart", S), Q.scrolled = L = !0, O || (O = !0, P = Fe(r))), X || ae.scrollLock ? e.preventDefault() : Q.scrolled ? e.preventDefault() : Math.abs(g) > 7 && (H = !0, Q.scrolled = !0, ne.trigger("touchend")))
            }

            function r() {
                A && (x = u(x, -z * A, z * A)), c(u(W + x, V - _, N + _)), O = !1
            }

            function i(e) {
                if (I) {
                    var t, a = new Date - $;
                    ae.stopProp && e.stopPropagation(), He(P), O = !1, !H && Q.scrolled && (ae.momentum && a < 300 && (t = x / a, x = Math.max(Math.abs(x), t * t / ae.speedUnit) * (x < 0 ? -1 : 1)), l(x)), D && (clearTimeout(f), h.addClass("mbsc-btn-a"), setTimeout(function() {
                        h.removeClass("mbsc-btn-a")
                    }, 100), H || Q.scrolled || G("onBtnTap", {
                        target: h[0],
                        domEvent: e
                    })), "mouseup" == e.type && Le(document).off("mousemove", s).off("mouseup", i), I = !1
                }
            }

            function o(e) {
                if (e = e.originalEvent || e, x = X ? e.deltaY || e.wheelDelta || e.detail : e.deltaX, G("onStart", {
                        domEvent: e
                    }), ae.stopProp && e.stopPropagation(), x ) {
                    if (e.preventDefault(), e.deltaMode && 1 == e.deltaMode && (x *= 5), x = u(-x, -20, 20), W = Z, ae.readonly || W + x < V || W + x > N) return;
                    L || (S = {
                        posX: X ? 0 : Z,
                        posY: X ? Z : 0,
                        originX: X ? 0 : W,
                        originY: X ? W : 0,
                        direction: x > 0 ? X ? 270 : 360 : X ? 90 : 180
                    }, G("onGestureStart", S)), O || (O = !0, P = Fe(r)), L = !0, clearTimeout(E), E = setTimeout(function() {
                        He(P), O = !1, L = !1, l(x)
                    }, 200)
                }
            }

            function l(e) {
                var t, a, n;
                if (A && (e = u(e, -z * A, z * A)), n = u(Math.round((W + e) / z) * z, V, N), ee = Math.round(n / z), j) {
                    if (e < 0) {
                        for (t = j.length - 1; t >= 0; t--)
                            if (Math.abs(n) + p >= j[t].breakpoint) {
                                ee = t, te = 2, n = j[t].snap2;
                                break
                            }
                    } else if (e >= 0)
                        for (t = 0; t < j.length; t++)
                            if (Math.abs(n) <= j[t].breakpoint) {
                                ee = t, te = 1, n = j[t].snap1;
                                break
                            }
                    n = u(n, V, N)
                }
                a = ae.time || (Z < V || Z > N ? 1e3 : Math.max(1e3, Math.abs(n - Z) * ae.timeUnit)), S.destinationX = X ? 0 : n, S.destinationY = X ? n : 0, S.duration = a, S.transitionTiming = y, G("onGestureEnd", S), c(n, a)
            }

            function c(e, t, a, n) {
                var s = e != Z,
                    r = t > 1,
                    i = function() {
                        clearInterval(Y), clearTimeout(U), F = !1, Z = e, S.posX = X ? 0 : e, S.posY = X ? e : 0, s && G("onMove", S), r && G("onAnimationEnd", S), n && n()
                    };
                S = {
                    posX: X ? 0 : Z,
                    posY: X ? Z : 0,
                    originX: X ? 0 : W,
                    originY: X ? W : 0,
                    direction: e - Z > 0 ? X ? 270 : 360 : X ? 90 : 180
                }, Z = e, r && (S.destinationX = X ? 0 : e, S.destinationY = X ? e : 0, S.duration = t, S.transitionTiming = y, G("onAnimationStart", S)), K[Ke + "Transition"] = t ? Je + "transform " + Math.round(t) + "ms " + y : "", K[Ke + "Transform"] = "translate3d(" + (X ? "0," + e + "px," : e + "px,0,") + "0)", !s && !F || !t || t <= 1 ? i() : t && (F = !a, clearInterval(Y), Y = setInterval(function() {
                    var t = +k(B, X) || 0;
                    S.posX = X ? 0 : t, S.posY = X ? t : 0, G("onMove", S), Math.abs(t - e) < 2 && i()
                }, 100), clearTimeout(U), U = setTimeout(function() {
                    i()
                }, t)), ae.sync && ae.sync(e, t, y)
            }
            var h, f, p, b, g, x, T, y, _, w, M, S, D, N, A, V, I, F, H, P, O, L, E, Y, z, j, W, $, R, J, K, B, U, q, G, X, Z, Q = this,
                ee = 0,
                te = 1,
                ae = t,
                ne = Le(e);
            je.call(this, e, t, !0), Q.scrolled = !1, Q.scroll = function(t, a, n, s) {
                t = d(t) ? Math.round(t / z) * z : Math.ceil((Le(t, e).length ? Math.round(B.offset()[T] - Le(t, e).offset()[T]) : Z) / z) * z, t = u(t, V, N), ee = Math.round(t / z), W = Z, c(t, a, n, s)
            }, Q.refresh = function(e) {
                var t;
                p = void 0 === ae.contSize ? X ? ne.height() : ne.width() : ae.contSize, V = void 0 === ae.minScroll ? Math.min(0, X ? p - B.height() : p - B.width()) : ae.minScroll, N = void 0 === ae.maxScroll ? 0 : ae.maxScroll, j = null, !X && ae.rtl && (t = N, N = -V, V = -t), m(ae.snap) && (j = [], B.find(ae.snap).each(function() {
                    var e = X ? this.offsetTop : this.offsetLeft,
                        t = X ? this.offsetHeight : this.offsetWidth;
                    j.push({
                        breakpoint: e + t / 2,
                        snap1: -e,
                        snap2: p - e - t
                    })
                })), z = d(ae.snap) ? ae.snap : 1, A = ae.snap ? ae.maxSnapScroll : 0, y = ae.easing, _ = ae.elastic ? d(ae.snap) ? z : d(ae.elastic) ? ae.elastic : 0 : 0, void 0 === Z && (Z = ae.initialPos, ee = Math.round(Z / z)), e || Q.scroll(ae.snap ? j ? j[ee]["snap" + te] : ee * z : Z)
            }, Q._processSettings = function() {
                X = "Y" == ae.axis, T = X ? "top" : "left", B = ae.moveElement || ne.children().eq(0), K = B[0].style, q = X ? ae.thresholdY : ae.thresholdX
            }, Q._init = function() {
                Q.refresh(), ne.on("touchstart mousedown", n).on("touchmove", s).on("touchend touchcancel", i), ae.mousewheel && ne.on("wheel mousewheel", o), e.addEventListener && e.addEventListener("click", function(e) {
                    Q.scrolled && (Q.scrolled = !1, e.stopPropagation(), e.preventDefault())
                }, !0)
            }, Q._destroy = function() {
                clearInterval(Y), ne.off("touchstart mousedown", n).off("touchmove", s).off("touchend touchcancel", i).off("wheel mousewheel", o)
            }, ae = Q.settings, G = Q.trigger, a || Q.init(t)
        };
    it.prototype = {
        _defaults: {
            speedUnit: .0022,
            timeUnit: 3,
            initialPos: 0,
            axis: "Y",
            thresholdX: 10,
            thresholdY: 5,
            easing: "cubic-bezier(0.190, 1.000, 0.220, 1.000)",
            stopProp: !0,
            momentum: !0,
            mousewheel: !0,
            elastic: !0
        }
    };
    var ot = Ae ? window.CSS : null,
        lt = ot && ot.supports && ot.supports("(transform-style: preserve-3d)"),
        ct = !lt || "wp" == Se || "android" == Se;
    ue.presetShort("scroller", "Scroller", !1);
    var dt = function(e, t, a) {
        function n(e) {
            var t = +Le(this).attr("data-index");
            e.stopPropagation(), "mousedown" === e.type && e.preventDefault(), C(e, this) && !T(t) && (V = Le(this).addClass("mbsc-sc-btn-a"), z = v(e, "X"), j = v(e, "Y"), E = !0, Y = !1, setTimeout(function() {
                b(t, "inc" == V.attr("data-dir") ? 1 : -1)
            }, 100), "mousedown" === e.type && Le(document).on("mousemove", s).on("mouseup", r))
        }

        function s(e) {
            (Math.abs(z - v(e, "X")) > 7 || Math.abs(j - v(e, "Y")) > 7) && g(!0)
        }

        function r(e) {
            g(), e.preventDefault(), "mouseup" === e.type && Le(document).off("mousemove", s).off("mouseup", r)
        }

        function i(e) {
            var t, a, n = Le(this).attr("data-index");
            38 == e.keyCode ? (t = !0, a = -1) : 40 == e.keyCode ? (t = !0, a = 1) : 32 == e.keyCode && (t = !0, c(n, q[n]._$markup.find('.mbsc-sc-itm[data-val="' + W[n] + '"]'))), t && (e.stopPropagation(), e.preventDefault(), a && !E && (E = !0, Y = !1, b(n, a)))
        }

        function o() {
            g()
        }

        function c(e, t) {
            var a = q[e],
                n = t.attr("data-index"),
                s = p(a, n),
                r = Q._tempSelected[e],
                i = d(a.multiple) ? a.multiple : 1 / 0;
            !1 !== B("onItemTap", {
                target: t[0],
                index: e,
                value: s,
                selected: t.hasClass("mbsc-sc-itm-sel")
            }) && (a.multiple && !a._disabled[s] && (void 0 !== r[s] ? (t.removeClass(P).removeAttr("aria-selected"), delete r[s]) : (1 == i && (Q._tempSelected[e] = r = {}, a._$markup.find(".mbsc-sc-itm-sel").removeClass(P).removeAttr("aria-selected")), l(r).length < i && (t.addClass(P).attr("aria-selected", "true"), r[s] = s))), D(a, e, n, Z, !0, !0, a.multiple), !Q.live || a.multiple || !0 !== K.setOnTap && !K.setOnTap[e] || setTimeout(function() {
                Q.select()
            }, 200))
        }

        function m(e, t) {
            return (e._array ? e._map[t] : e.getIndex(t, Q)) || 0
        }

        function u(e, t) {
            var a = e.data;
            if (t >= e.min && t <= e.max) return e._array ? e.circular ? Le(a).get(t % e._length) : a[t] : Le.isFunction(a) ? a(t, Q) : ""
        }

        function h(e) {
            return Le.isPlainObject(e) ? void 0 !== e.value ? e.value : e.display : e
        }

        function f(e) {
            var t = Le.isPlainObject(e) ? e.display : e;
            return void 0 === t ? "" : t ;
        }

        function p(e, t) {
            return h(u(e, t))
        }

        function b(e, t) {
            Y || x(e, t), E  && (clearInterval(L), L = setInterval(function() {
                x(e, t)
            }, K.delay))
        }

        function g(e) {
            clearInterval(L), Y = e, E = !1, V && V.removeClass("mbsc-sc-btn-a")
        }

        function x(e, t) {
            var a = q[e];
            D(a, e, a._current + t, Z, 1 == t ? 1 : 2)
        }

        function T(e) {
            return Le.isArray(K.readonly) ? K.readonly[e] : K.readonly
        }

        function y(e, t, a) {
            var n = e._index - e._batch;
            return e.data = e.data || [], e.key = void 0 !== e.key ? e.key : t, e.label = void 0 !== e.label ? e.label : t, e._map = {}, e._array = Le.isArray(e.data), e._array && (e._length = e.data.length, Le.each(e.data, function(t, a) {
                e._map[h(a)] = t
            })), e.circular = void 0 === K.circular ? void 0 === e.circular ? e._array && e._length > K.rows : e.circular : Le.isArray(K.circular) ? K.circular[t] : K.circular, e.min = e._array ? e.circular ? -1 / 0 : 0 : void 0 === e.min ? -1 / 0 : e.min, e.max = e._array ? e.circular ? 1 / 0 : e._length - 1 : void 0 === e.max ? 1 / 0 : e.max, e._nr = t, e._index = m(e, W[t]), e._disabled = {}, e._batch = 0, e._current = e._index, e._first = e._index - X, e._last = e._index + X, e._offset = e._first, a ? (e._offset -= e._margin / $ + (e._index - n), e._margin += (e._index - n) * $) : e._margin = 0, e._refresh = function(t) {
                var a = -(e.min - e._offset + (e.multiple && !H ? Math.floor(K.rows / 2) : 0)) * $,
                    n = Math.min(a, -(e.max - e._offset - (e.multiple && !H ? Math.floor(K.rows / 2) : 0)) * $);
                ze(e._scroller.settings, {
                    minScroll: n,
                    maxScroll: a
                }), e._scroller.refresh(t)
            }, G[e.key] = e, e
        }

        function _(e, t, a, n, s) {
            var r, i, o, l, c, d, m, p, b = "",
                v = Q._tempSelected[t],
                g = e._disabled || {};
            for (r = a; r <= n; r++) o = u(e, r), c = f(o), l = h(o), i = o && void 0 !== o.cssClass ? o.cssClass : "", d = o && void 0 !== o.label ? o.label : "", m = o && o.invalid, p = void 0 !== l && l == W[t] && !e.multiple, b += '<div role="option" aria-selected="' + !!v[l] + '" class="mbsc-sc-itm ' + (s ? "mbsc-sc-itm-3d " : "") + i + " " + (p ? "mbsc-sc-itm-sel " : "") + (v[l] ? P : "") + (void 0 === l ? " mbsc-sc-itm-ph" : " mbsc-btn-e") + (m ? " mbsc-sc-itm-inv-h mbsc-btn-d" : "") + (g[l] ? " mbsc-sc-itm-inv mbsc-btn-d" : "") + '" data-index="' + r + '" data-val="' + l + '"' + (d ? ' aria-label="' + d + '"' : "") + (p ? ' aria-selected="true"' : "") + ' style="height:' + $ + "px;line-height:" + $ + "px;" + (s ? Je + "transform:rotateX(" + (e._offset - r) * F % 360 + "deg) translateZ(" + $ * K.rows / 2 + "px);" : "") + '">' + (U > 1 ? '<div class="mbsc-sc-itm-ml" style="line-height:' + Math.round($ / U) + "px;font-size:" + Math.round($ / U * .8) + 'px;">' : "") + c + (U > 1 ? "</div>" : "") + "</div>";
            return b
        }

        function w(t) {
            var a = K.headerText;
            return a ? "function" == typeof a ? a.call(e, t) : a.replace(/\{value\}/i, t) : ""
        }

        function M(e, t, a) {
            var n = Math.round(-a / $) + e._offset,
                s = n - e._current,
                r = e._first,
                i = e._last,
                o = r + X - I + 1,
                l = i - X + I;
            s && (e._first += s, e._last += s, e._current = n, s > 0 ? (e._$scroller.append(_(e, t, Math.max(i + 1, r + s), i + s)), Le(".mbsc-sc-itm", e._$scroller).slice(0, Math.min(s, i - r + 1)).remove(), H && (e._$3d.append(_(e, t, Math.max(l + 1, o + s), l + s, !0)), Le(".mbsc-sc-itm", e._$3d).slice(0, Math.min(s, l - o + 1)).attr("class", "mbsc-sc-itm-del"))) : s < 0 && (e._$scroller.prepend(_(e, t, r + s, Math.min(r - 1, i + s))), Le(".mbsc-sc-itm", e._$scroller).slice(Math.max(s, r - i - 1)).remove(), H && (e._$3d.prepend(_(e, t, o + s, Math.min(o - 1, l + s), !0)), Le(".mbsc-sc-itm", e._$3d).slice(Math.max(s, o - l - 1)).attr("class", "mbsc-sc-itm-del"))), e._margin += s * $, e._$scroller.css("margin-top", e._margin + "px"))
        }

        function S(e, t, a, n) {
            var s, r = q[e],
                i = n || r._disabled,
                o = m(r, t),
                l = t,
                c = t,
                d = 0,
                u = 0;
            if (void 0 === t && (t = p(r, o)), !0 === i[t]) {
                for (s = 0; o - d >= r.min && i[l] && s < 100;) s++, d++, l = p(r, o - d);
                for (s = 0; o + u < r.max && i[c] && s < 100;) s++, u++, c = p(r, o + u);
                t = (u < d && u && 2 !== a || !d || o - d < 0 || 1 == a) && !i[c] ? c : l
            }
            return t
        }

        function k(t, a, n, s, r, i) {
            var o, l, c, d, u = Q._isVisible;
            J = !0, d = K.validate.call(e, {
                values: W.slice(0),
                index: a,
                direction: n
            }, Q) || {}, J = !1, d.valid && (Q._tempWheelArray = W = d.valid.slice(0)), i || Le.each(q, function(e, s) {
                if (u && s._$markup.find(".mbsc-sc-itm-inv").removeClass("mbsc-sc-itm-inv mbsc-btn-d"), s._disabled = {}, d.disabled && d.disabled[e] && Le.each(d.disabled[e], function(e, t) {
                        s._disabled[t] = !0, u && s._$markup.find('.mbsc-sc-itm[data-val="' + t + '"]').addClass("mbsc-sc-itm-inv mbsc-btn-d")
                    }), W[e] = s.multiple ? W[e] : S(e, W[e], n), u) {
                    if (s.multiple && void 0 !== a || s._$markup.find(".mbsc-sc-itm-sel").removeClass(P).removeAttr("aria-selected"), s.multiple) {
                        if (void 0 === a)
                            for (var i in Q._tempSelected[e]) s._$markup.find('.mbsc-sc-itm[data-val="' + i + '"]').addClass(P).attr("aria-selected", "true")
                    } else s._$markup.find('.mbsc-sc-itm[data-val="' + W[e] + '"]').addClass("mbsc-sc-itm-sel").attr("aria-selected", "true");
                    l = m(s, W[e]), o = l - s._index + s._batch, Math.abs(o) > 2 * X + 1 && (c = o + (2 * X + 1) * (o > 0 ? -1 : 1), s._offset += c, s._margin -= c * $, s._refresh()), s._index = l + s._batch, s._scroller.scroll(-(l - s._offset + s._batch) * $, a === e || void 0 === a ? t : Z, r)
                }
            }), B("onValidated"), Q._tempValue = K.formatValue(W, Q), u && Q._header.html(w(Q._tempValue)), Q.live && (Q._hasValue = s || Q._hasValue, N(s, s, 0, !0), s && B("onSet", {
                valueText: Q._value
            })), s && B("onChange", {
                valueText: Q._tempValue
            })
        }

        function D(e, t, a, n, s, r, i) {
            var o = p(e, a);
            void 0 !== o && (W[t] = o, e._batch = e._array ? Math.floor(a / e._length) * e._length : 0, setTimeout(function() {
                k(n, t, s, !0, r, i)
            }, 10))
        }

        function N(e, t, a, n, s) {
            if (n ? Q._tempValue = K.formatValue(Q._tempWheelArray, Q) : k(a), !s) {
                Q._wheelArray = [];
                for (var r = 0; r < W.length; r++) Q._wheelArray[r] = q[r] && q[r].multiple ? Object.keys(Q._tempSelected[r])[0] : W[r];
                Q._value = Q._hasValue ? Q._tempValue : null, Q._selected = ze(!0, {}, Q._tempSelected)
            }
            e && (Q._isInput && ee.val(Q._hasValue ? Q._tempValue : ""), B("onFill", {
                valueText: Q._hasValue ? Q._tempValue : "",
                change: t
            }), t && (Q._preventChange = !0, ee.trigger("change")))
        }
        var A, V, I, F, H, P, O, L, E, Y, z, j, W, $, R, J, K, B, U, q, G, X = 40,
            Z = 1e3,
            Q = this,
            ee = Le(e);
        st.call(this, e, t, !0), Q.setVal = Q._setVal = function(t, a, n, s, r) {
            Q._hasValue = null !== t && void 0 !== t, Q._tempWheelArray = W = Le.isArray(t) ? t.slice(0) : K.parseValue.call(e, t, Q) || [], N(a, void 0 === n ? a : n, r, !1, s)
        }, Q.getVal = Q._getVal = function(e) {
            var t = Q._hasValue || e ? Q[e ? "_tempValue" : "_value"] : null;
            return d(t) ? +t : t
        }, Q.setArrayVal = Q.setVal, Q.getArrayVal = function(e) {
            return e ? Q._tempWheelArray : Q._wheelArray
        }, Q.changeWheel = function(e, t, a) {
            var n, s;
            Le.each(e, function(e, t) {
                (s = G[e]) && (n = s._nr, ze(s, t), y(s, n, !0), Q._isVisible && (H && s._$3d.html(_(s, n, s._first + X - I + 1, s._last - X + I, !0)), s._$scroller.html(_(s, n, s._first, s._last)).css("margin-top", s._margin + "px"), s._refresh(J)))
            }), !Q._isVisible || Q._isLiquid || J || Q.position(), J || k(t, void 0, void 0, a)
        }, Q.getValidValue = S, Q._generateContent = function() {
            var e, t = 0,
                a = "",
                n = H ? Je + "transform: translateZ(" + ($ * K.rows / 2 + 3) + "px);" : "",
                s = '<div class="mbsc-sc-whl-l" style="' + n + "height:" + $ + "px;margin-top:-" + ($ / 2 + (K.selectedLineBorder || 0)) + 'px;"></div>',
                r = 0;
            return Le.each(K.wheels, function(i, o) {
                a += '<div class="mbsc-w-p mbsc-sc-whl-gr-c' + (H ? " mbsc-sc-whl-gr-3d-c" : "") + (K.showLabel ? " mbsc-sc-lbl-v" : "") + '">' + s + '<div class="mbsc-sc-whl-gr' + (H ? " mbsc-sc-whl-gr-3d" : "") + (O ? " mbsc-sc-cp" : "") + (K.width || K.maxWidth ? '"' : '" style="max-width:' + K.maxPopupWidth + 'px;"') + ">", Le.each(o, function(i, o) {
                    Q._tempSelected[r] = ze({}, Q._selected[r]), q[r] = y(o, r), t += K.maxWidth ? K.maxWidth[r] || K.maxWidth : K.width ? K.width[r] || K.width : 0, e = void 0 !== o.label ? o.label : i,
                        a += '<div class="mbsc-sc-whl-w ' + (o.cssClass || "") + (o.multiple ? " mbsc-sc-whl-multi" : "") + '" style="' + (K.width ? "width:" + (K.width[r] || K.width) + "px;" : (K.minWidth ? "min-width:" + (K.minWidth[r] || K.minWidth) + "px;" : "") + (K.maxWidth ? "max-width:" + (K.maxWidth[r] || K.maxWidth) + "px;" : "")) + '"><div class="mbsc-sc-whl-o" style="' + n + '"></div>' + s + '<div tabindex="0" aria-live="off" aria-label="' + e + '"' + (o.multiple ? ' aria-multiselectable="true"' : "") + ' role="listbox" data-index="' + r + '" class="mbsc-sc-whl" style="height:' + K.rows * $ * (H ? 1.1 : 1) + 'px;">' + (O ? '<div data-index="' + r + '" data-dir="inc" class="mbsc-sc-btn mbsc-sc-btn-plus ' + (K.btnPlusClass || "") + '" style="height:' + $ + "px;line-height:" + $ + 'px;"></div><div data-index="' + r + '" data-dir="dec" class="mbsc-sc-btn mbsc-sc-btn-minus ' + (K.btnMinusClass || "") + '" style="height:' + $ + "px;line-height:" + $ + 'px;"></div>' : "") + '<div class="mbsc-sc-lbl">' + e + '</div><div class="mbsc-sc-whl-c" style="height:' + R + "px;margin-top:-" + (R / 2 + 1) + "px;" + n + '"><div class="mbsc-sc-whl-sc" style="top:' + (R - $) / 2 + 'px;">', a += _(o, r, o._first, o._last) + "</div></div>", H && (a += '<div class="mbsc-sc-whl-3d" style="height:' + $ + "px;margin-top:-" + $ / 2 + 'px;">', a += _(o, r, o._first + X - I + 1, o._last - X + I, !0), a += "</div>"), a += "</div></div>", r++
                }), a += "</div></div>"
            }), t && (K.maxPopupWidth = t), a
        }, Q._attachEvents = function(e) {
            Le(".mbsc-sc-btn", e).on("touchstart mousedown", n).on("touchmove", s).on("touchend touchcancel", r), Le(".mbsc-sc-whl", e).on("keydown", i).on("keyup", o)
        }, Q._detachEvents = function() {
            for (var e = 0; e < q.length; e++) q[e]._scroller.destroy()
        }, Q._markupReady = function(e) {
            A = e, Le(".mbsc-sc-whl-w", A).each(function(e) {
                var t, a = Le(this),
                    n = q[e],
                    s = -(n.min - n._offset + (n.multiple && !H ? Math.floor(K.rows / 2) : 0)) * $,
                    r = Math.min(s, -(n.max - n._offset - (n.multiple && !H ? Math.floor(K.rows / 2) : 0)) * $);
                n._$markup = a, n._$scroller = Le(".mbsc-sc-whl-sc", this), n._$3d = Le(".mbsc-sc-whl-3d", this), n._scroller = new it(this, {
                    mousewheel: K.mousewheel,
                    moveElement: n._$scroller,
                    initialPos: (n._first - n._index) * $,
                    contSize: 0,
                    snap: $,
                    minScroll: r,
                    maxScroll: s,
                    maxSnapScroll: X,
                    prevDef: !0,
                    stopProp: !0,
                    timeUnit: 3,
                    easing: "cubic-bezier(0.190, 1.000, 0.220, 1.000)",
                    sync: function(e, t, a) {
                        H && (n._$3d[0].style[Ke + "Transition"] = t ? Je + "transform " + Math.round(t) + "ms " + a : "", n._$3d[0].style[Ke + "Transform"] = "rotateX(" + -e / $ * F + "deg)")
                    },
                    onStart: function(t, a) {
                        a.settings.readonly = T(e)
                    },
                    onGestureStart: function() {
                        a.addClass("mbsc-sc-whl-a mbsc-sc-whl-anim"), B("onWheelGestureStart", {
                            index: e
                        })
                    },
                    onGestureEnd: function(a) {
                        var s = 90 == a.direction ? 1 : 2,
                            r = a.duration,
                            i = a.destinationY;
                        t = Math.round(-i / $) + n._offset, D(n, e, t, r, s)
                    },
                    onAnimationStart: function() {
                        a.addClass("mbsc-sc-whl-anim")
                    },
                    onAnimationEnd: function() {
                        a.removeClass("mbsc-sc-whl-a mbsc-sc-whl-anim"), B("onWheelAnimationEnd", {
                            index: e
                        }), n._$3d.find(".mbsc-sc-itm-del").remove()
                    },
                    onMove: function(t) {
                        M(n, e, t.posY)
                    },
                    onBtnTap: function(t) {
                        c(e, Le(t.target))
                    }
                })
            }), k()
        }, Q._fillValue = function() {
            Q._hasValue = !0, N(!0, !0, 0, !0)
        }, Q._clearValue = function() {
            Le(".mbsc-sc-whl-multi .mbsc-sc-itm-sel", A).removeClass(P).removeAttr("aria-selected")
        }, Q._readValue = function() {
            var t = ee.val() || "",
                a = 0;
            "" !== t && (Q._hasValue = !0), Q._tempWheelArray = W = Q._hasValue && Q._wheelArray ? Q._wheelArray.slice(0) : K.parseValue.call(e, t, Q) || [], Q._tempSelected = ze(!0, {}, Q._selected), Le.each(K.wheels, function(e, t) {
                Le.each(t, function(e, t) {
                    q[a] = y(t, a), a++
                })
            }), N(!1, !1, 0, !0), B("onRead")
        }, Q.__processSettings = function() {
            K = Q.settings, B = Q.trigger, U = K.multiline, P = "mbsc-sc-itm-sel mbsc-ic mbsc-ic-" + K.checkIcon, q = [], G = {}
        }, Q.__init = function() {
            O = K.showScrollArrows, H = K.scroll3d && !ct && !O, $ = K.height, R = H ? 2 * Math.round(($ - .03 * ($ * K.rows / 2 + 3)) / 2) : $, I = Math.round(1.8 * K.rows), F = 360 / (2 * I), O && (K.rows = Math.max(3, K.rows)), K.cssClass = (K.cssClass || "") + " mbsc-sc"
        }, Q._getItemValue = h, Q._tempSelected = {}, Q._selected = {}, a || Q.init(t)
    };
    dt.prototype = {
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _hasPreset: !0,
        _class: "scroller",
        _defaults: ze({}, st.prototype._defaults, {
            minWidth: 80,
            height: 40,
            rows: 3,
            multiline: 1,
            delay: 300,
            readonly: !1,
            showLabel: !0,
            setOnTap: !1,
            wheels: [],
            preset: "",
            speedUnit: .0012,
            timeUnit: .08,
            checkIcon: "checkmark",
            validate: function() {},
            formatValue: function(e) {
                return e.join(" ")
            },
            parseValue: function(e, t) {
                var a, n, s = [],
                    r = [],
                    i = 0;
                return null !== e && void 0 !== e && (s = (e + "").split(" ")), Le.each(t.settings.wheels, function(e, o) {
                    Le.each(o, function(e, o) {
                        n = o.data, a = t._getItemValue(n[0]), Le.each(n, function(e, n) {
                            if (s[i] == t._getItemValue(n)) return a = t._getItemValue(n), !1
                        }), r.push(a), i++
                    })
                }), r
            }
        })
    }, ue.classes.Scroller = dt;
   
   
   (function(a) {
    var d = ue,
        b = d.$,
        c = d.util.datetime,
        e = c.adjustedDate,
        f = new Date(),
        g = {
            startYear: f.getFullYear() - 100,
            endYear: f.getFullYear() + 1,
            separator: ' ',
            dateFormat: 'mm/dd/yy',
            dateDisplay: 'MMddyy',
            timeFormat: 'h:ii A',
            dayText: 'Day',
            monthText: 'Month',
            yearText: 'Year',
            hourText: 'Hours',
            minuteText: 'Minutes',
            ampmText: '&nbsp;',
            secText: 'Seconds',
            nowText: 'Now',
            todayText: 'Today'
        },
        h = function(i) {
            function m(b, a, c, d) {
                return Math.min(d, Math.floor(b / a) * a + c);
            }
            function v(a) {
                return a < 10 ? '0' + a : a;
            }
            function a4(c) {
                var d, b, a, f = [];
                if (c) {
                    for (d = 0; d < c.length; d++) {
                        b = c[d];
                        if (b.start && b.start.getTime) {
                            a = new Date(b.start);
                            while (a <= b.end) {
                                f.push(e(a.getFullYear(), a.getMonth(), a.getDate()));
                                a.setDate(a.getDate() + 1);
                            }
                        } else {
                            f.push(b);
                        }
                    }
                    return f;
                }
                return c;
            }
            function X(a, b, c) {
                return Math.floor((c - b) / a) * a + b;
            }
            function ai(a) {
                return {
                    value: a,
                    display: (/yy/i.test(y) ? a : (a + '').substr(2, 2)) + (f.yearSuffix || '')
                };
            }
            function ad(a) {
                return a;
            }
            function ac(a) {
                return f.getYear(a);
            }
            function aa(a) {
                return f.getMonth(a);
            }
            function a9(a) {
                return f.getDay(a);
            }
            function a8(b) {
                var a = b.getHours();
                a = r && a >= 12 ? a - 12 : a;
                return m(a, u, C, U);
            }
            function a7(a) {
                return m(a.getMinutes(), q, x, V);
            }
            function al(a) {
                return m(a.getSeconds(), z, O, W);
            }
            function aj(a) {
                return a.getMilliseconds();
            }
            function ah(a) {
                return a.getHours() > 11 ? 1 : 0;
            }
            function M(a) {
                return a.getFullYear() + '-' + v(a.getMonth() + 1) + '-' + v(a.getDate());
            }
            function ae(a) {
                return m(Math.round((a.getTime() - new Date(a).setHours(0, 0, 0, 0)) / 1000), L, 0, 86400);
            }
            function p(e, b, d, f) {
                var c;
                if (h[b] !== a) {
                    c = +e[h[b]];
                    if (!isNaN(c)) {
                        return c;
                    }
                }
                if (d) {
                    return l[b](d);
                }
                if (D[b] !== a) {
                    return D[b];
                }
                return l[b](f);
            }
            function A(c) {
                var b, d = new Date(new Date().setHours(0, 0, 0, 0));
                if (c === null) {
                    return c;
                }
                if (h.dd !== a) {
                    b = c[h.dd].split('-');
                    b = new Date(b[0], b[1] - 1, b[2]);
                }
                if (h.tt !== a) {
                    b = b || d;
                    b = new Date(b.getTime() + c[h.tt] % 86400 * 1000);
                }
                var e = p(c, 'y', b, d),
                    g = p(c, 'm', b, d),
                    j = Math.min(p(c, 'd', b, d), f.getMaxDayOfMonth(e, g)),
                    i = p(c, 'h', b, d);
                return f.getDate(e, g, j, r && p(c, 'a', b, d) ? i + 12 : i, p(c, 'i', b, d), p(c, 's', b, d), p(c, 'u', b, d));
            }
            function F(b, g) {
                var c, d, e = ['y', 'm', 'd', 'a', 'h', 'i', 's', 'u', 'dd', 'tt'],
                    f = [];
                if (b === null || b === a) {
                    return b;
                }
                for (c = 0; c < e.length; c++) {
                    d = e[c];
                    if (h[d] !== a) {
                        f[h[d]] = l[d](b);
                    }
                    if (g) {
                        D[c] = l[d](b);
                    }
                }
                return f;
            }
            function Q(a, b) {
                return b ? Math.floor(new Date(a) / 8.64e7) : a.getMonth() + 12 * (a.getFullYear() - 1970);
            }
            function ak(b) {
                var a = /d/i.test(b);
                return {
                    label: '',
                    cssClass: 'mbsc-dt-whl-date',
                    min: Q(M(j), a),
                    max: Q(M(k), a),
                    data: function(e) {
                        var g = new Date(new Date().setHours(0, 0, 0, 0)),
                            d = a ? new Date(e * 8.64e7) : new Date(1970, e, 1);
                        if (a) {
                            d = new Date(d.getUTCFullYear(), d.getUTCMonth(), d.getUTCDate());
                        }
                        return {
                            invalid: a && !B(d, true),
                            value: M(d),
                            display: g.getTime() == d.getTime() ? f.todayText : c.formatDate(b, d, f)
                        };
                    },
                    getIndex: function(b) {
                        return Q(b, a);
                    }
                };
            }
            function ab(d) {
                var a, b, g, e = [];
                if (/s/i.test(d)) {
                    b = z;
                } else if (/i/i.test(d)) {
                    b = q * 60;
                } else if (/h/i.test(d)) {
                    b = u * 3600;
                }
                L = o.tt = b;
                for (a = 0; a < 86400; a += b) {
                    g = new Date(new Date().setHours(0, 0, 0, 0) + a * 1000);
                    e.push({
                        value: a,
                        display: c.formatDate(d, g, f)
                    });
                }
                return {
                    label: '',
                    cssClass: 'mbsc-dt-whl-time',
                    data: e
                };
            }
            function a6() {
                var p, s, c, l, b, g, e, n, d = 0,
                    o = [],
                    m = [],
                    i = [];
                if (w.match(/date/i)) {
                    p = S.split(/\|/.test(S) ? '|' : '');
                    for (l = 0; l < p.length; l++) {
                        c = p[l];
                        g = 0;
                        if (c.length) {
                            if (/y/i.test(c)) {
                                g++;
                            }
                            if (/m/i.test(c)) {
                                g++;
                            }
                            if (/d/i.test(c)) {
                                g++;
                            }
                            if (g > 1 && h.dd === a) {
                                h.dd = d;
                                d++;
                                m.push(ak(c));
                                i = m;
                                a2 = true;
                            } else if (/y/i.test(c) && h.y === a) {
                                h.y = d;
                                d++;
                                m.push({
                                    cssClass: 'mbsc-dt-whl-y',
                                    label: f.yearText,
                                    min: f.getYear(j),
                                    max: f.getYear(k),
                                    data: ai,
                                    getIndex: ad
                                });
                            } else if (/m/i.test(c) && h.m === a) {
                                h.m = d;
                                e = [];
                                d++;
                                for (b = 0; b < 12; b++) {
                                    n = y.replace(/[dy]/gi, '').replace(/mm/, v(b + 1) + (f.monthSuffix || '')).replace(/m/, b + 1 + (f.monthSuffix || ''));
                                    e.push({
                                        value: b,
                                        display: /MM/.test(n) ? n.replace(/MM/, '<span class="mbsc-dt-month">' + f.monthNames[b] + '</span>') : n.replace(/M/, '<span class="mbsc-dt-month">' + f.monthNamesShort[b] + '</span>')
                                    });
                                }
                                m.push({
                                    cssClass: 'mbsc-dt-whl-m',
                                    label: f.monthText,
                                    data: e
                                });
                            } else if (/d/i.test(c) && h.d === a) {
                                h.d = d;
                                e = [];
                                d++;
                                for (b = 1; b < 32; b++) {
                                    e.push({
                                        value: b,
                                        display: (/dd/i.test(y) ? v(b) : b) + (f.daySuffix || '')
                                    });
                                }
                                m.push({
                                    cssClass: 'mbsc-dt-whl-d',
                                    label: f.dayText,
                                    data: e
                                });
                            }
                        }
                    }
                    o.push(m);
                }
                if (w.match(/time/i)) {
                    s = H.split(/\|/.test(H) ? '|' : '');
                    for (l = 0; l < s.length; l++) {
                        c = s[l];
                        g = 0;
                        if (c.length) {
                            if (/h/i.test(c)) {
                                g++;
                            }
                            if (/i/i.test(c)) {
                                g++;
                            }
                            if (/s/i.test(c)) {
                                g++;
                            }
                            if (/a/i.test(c)) {
                                g++;
                            }
                        }
                        if (g > 1 && h.tt === a) {
                            h.tt = d;
                            d++;
                            i.push(ab(c));
                        } else if (/h/i.test(c) && h.h === a) {
                            e = [];
                            h.h = d;
                            d++;
                            for (b = C; b < (r ? 12 : 24); b += u) {
                                e.push({
                                    value: b,
                                    display: r && b === 0 ? 12 : /hh/i.test(G) ? v(b) : b
                                });
                            }
                            i.push({
                                cssClass: 'mbsc-dt-whl-h',
                                label: f.hourText,
                                data: e
                            });
                        } else if (/i/i.test(c) && h.i === a) {
                            e = [];
                            h.i = d;
                            d++;
                            for (b = x; b < 60; b += q) {
                                e.push({
                                    value: b,
                                    display: /ii/i.test(G) ? v(b) : b
                                });
                            }
                            i.push({
                                cssClass: 'mbsc-dt-whl-i',
                                label: f.minuteText,
                                data: e
                            });
                        } else if (/s/i.test(c) && h.s === a) {
                            e = [];
                            h.s = d;
                            d++;
                            for (b = O; b < 60; b += z) {
                                e.push({
                                    value: b,
                                    display: /ss/i.test(G) ? v(b) : b
                                });
                            }
                            i.push({
                                cssClass: 'mbsc-dt-whl-s',
                                label: f.secText,
                                data: e
                            });
                        } else if (/a/i.test(c) && h.a === a) {
                            h.a = d;
                            d++;
                            i.push({
                                cssClass: 'mbsc-dt-whl-a',
                                label: f.ampmText,
                                data: /A/.test(c) ? [{
                                    value: 0,
                                    display: f.amText.toUpperCase()
                                }, {
                                    value: 1,
                                    display: f.pmText.toUpperCase()
                                }] : [{
                                    value: 0,
                                    display: f.amText
                                }, {
                                    value: 1,
                                    display: f.pmText
                                }]
                            });
                        }
                    }
                    if (i != m) {
                        o.push(i);
                    }
                }
                return o;
            }
            function ag(d) {
                var a, e, f, b = {};
                if (d.is('input')) {
                    switch (d.attr('type')) {
                        case 'date':
                            a = 'yy-mm-dd';
                            break;
                        case 'datetime':
                            a = 'yy-mm-ddTHH:ii:ssZ';
                            break;
                        case 'datetime-local':
                            a = 'yy-mm-ddTHH:ii:ss';
                            break;
                        case 'month':
                            a = 'yy-mm';
                            b.dateOrder = 'mmyy';
                            break;
                        case 'time':
                            a = 'HH:ii:ss';
                            break;
                    }
                    b.format = a;
                    e = d.attr('min');
                    f = d.attr('max');
                    if (e) {
                        b.min = c.parseDate(a, e);
                    }
                    if (f) {
                        b.max = c.parseDate(a, f);
                    }
                }
                return b;
            }
            function af(a, f) {
                var b, c, e = false,
                    d = false,
                    g = 0,
                    h = 0;
                j = A(F(j));
                k = A(F(k));
                if (B(a)) {
                    return a;
                }
                if (a < j) {
                    a = j;
                }
                if (a > k) {
                    a = k;
                }
                b = a;
                c = a;
                if (f !== 2) {
                    e = B(b);
                    while (!e && b < k) {
                        b = new Date(b.getTime() + 1000 * 60 * 60 * 24);
                        e = B(b);
                        g++;
                    }
                }
                if (f !== 1) {
                    d = B(c);
                    while (!d && c > j) {
                        c = new Date(c.getTime() - 1000 * 60 * 60 * 24);
                        d = B(c);
                        h++;
                    }
                }
                if (f === 1 && e) {
                    return b;
                }
                if (f === 2 && d) {
                    return c;
                }
                return h <= g && d ? c : b;
            }
            function B(a, b) {
                if (!b && a < j) {
                    return false;
                }
                if (!b && a > k) {
                    return false;
                }
                if (a3(a, J)) {
                    return true;
                }
                if (a3(a, I)) {
                    return false;
                }
                return true;
            }
            function a3(b, e) {
                var c, d, a;
                if (e) {
                    for (d = 0; d < e.length; d++) {
                        c = e[d];
                        a = c + '';
                        if (!c.start) {
                            if (c.getTime) {
                                if (b.getFullYear() == c.getFullYear() && b.getMonth() == c.getMonth() && b.getDate() == c.getDate()) {
                                    return true;
                                }
                            } else if (!a.match(/w/i)) {
                                a = a.split('/');
                                if (a[1]) {
                                    if (a[0] - 1 == b.getMonth() && a[1] == b.getDate()) {
                                        return true;
                                    }
                                } else if (a[0] == b.getDate()) {
                                    return true;
                                }
                            } else {
                                a = +a.replace('w', '');
                                if (a == b.getDay()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            function a0(h, l, i, k, j, e, g) {
                var b, d, c, a;
                if (h) {
                    for (d = 0; d < h.length; d++) {
                        b = h[d];
                        a = b + '';
                        if (!b.start) {
                            if (b.getTime) {
                                if (f.getYear(b) == l && f.getMonth(b) == i) {
                                    e[f.getDay(b)] = g;
                                }
                            } else if (!a.match(/w/i)) {
                                a = a.split('/');
                                if (a[1]) {
                                    if (a[0] - 1 == i) {
                                        e[a[1]] = g;
                                    }
                                } else {
                                    e[a[0]] = g;
                                }
                            } else {
                                a = +a.replace('w', '');
                                for (c = a - k; c < j; c += 7) {
                                    if (c >= 0) {
                                        e[c + 1] = g;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            function _(x, y, e, M, I, B, N, K) {
                var H, D, k, F, E, C, i, A, z, b, g, d, c, p, v, G, w, l, q, u, J = {},
                    j = f.getDate(M, I, B),
                    h = ['a', 'h', 'i', 's'];
                if (x) {
                    for (i = 0; i < x.length; i++) {
                        g = x[i];
                        if (g.start) {
                            g.apply = false;
                            k = g.d;
                            w = k + '';
                            l = w.split('/');
                            if (k && (k.getTime && M == f.getYear(k) && I == f.getMonth(k) && B == f.getDay(k) || !w.match(/w/i) && (l[1] && B == l[1] && I == l[0] - 1 || !l[1] && B == l[0]) || w.match(/w/i) && j.getDay() == +w.replace('w', ''))) {
                                g.apply = true;
                                J[j] = true;
                            }
                        }
                    }
                    for (i = 0; i < x.length; i++) {
                        g = x[i];
                        H = 0;
                        G = 0;
                        A = s[e];
                        z = n[e];
                        p = true;
                        v = true;
                        D = false;
                        if (g.start && (g.apply || !g.d && !J[j])) {
                            d = g.start.split(':');
                            c = g.end.split(':');
                            for (b = 0; b < 3; b++) {
                                if (d[b] === a) {
                                    d[b] = 0;
                                }
                                if (c[b] === a) {
                                    c[b] = 59;
                                }
                                d[b] = +d[b];
                                c[b] = +c[b];
                            }
                            if (e == 'tt') {
                                A = m(Math.round((new Date(j).setHours(d[0], d[1], d[2]) - new Date(j).setHours(0, 0, 0, 0)) / 1000), L, 0, 86400);
                                z = m(Math.round((new Date(j).setHours(c[0], c[1], c[2]) - new Date(j).setHours(0, 0, 0, 0)) / 1000), L, 0, 86400);
                            } else {
                                d.unshift(d[0] > 11 ? 1 : 0);
                                c.unshift(c[0] > 11 ? 1 : 0);
                                if (r) {
                                    if (d[1] >= 12) {
                                        d[1] = d[1] - 12;
                                    }
                                    if (c[1] >= 12) {
                                        c[1] = c[1] - 12;
                                    }
                                }
                                for (b = 0; b < y; b++) {
                                    if (t[b] !== a) {
                                        q = m(d[b], o[h[b]], s[h[b]], n[h[b]]);
                                        u = m(c[b], o[h[b]], s[h[b]], n[h[b]]);
                                        F = 0;
                                        E = 0;
                                        C = 0;
                                        if (r && b == 1) {
                                            F = d[0] ? 12 : 0;
                                            E = c[0] ? 12 : 0;
                                            C = t[0] ? 12 : 0;
                                        }
                                        if (!p) {
                                            q = 0;
                                        }
                                        if (!v) {
                                            u = n[h[b]];
                                        }
                                        if ((p || v) && (q + F < t[b] + C && t[b] + C < u + E)) {
                                            D = true;
                                        }
                                        if (t[b] != q) {
                                            p = false;
                                        }
                                        if (t[b] != u) {
                                            v = false;
                                        }
                                    }
                                }
                                if (!K) {
                                    for (b = y + 1; b < 4; b++) {
                                        if (d[b] > 0) {
                                            H = o[e];
                                        }
                                        if (c[b] < n[h[b]]) {
                                            G = o[e];
                                        }
                                    }
                                }
                                if (!D) {
                                    q = m(d[y], o[e], s[e], n[e]) + H;
                                    u = m(c[y], o[e], s[e], n[e]) - G;
                                    if (p) {
                                        A = q;
                                    }
                                    if (v) {
                                        z = u;
                                    }
                                }
                            }
                            if (p || v || D) {
                                for (b = A; b <= z; b += o[e]) {
                                    N[b] = !K;
                                }
                            }
                        }
                    }
                }
            }
            var L, a2, Y, h = {},
                D = {},
                t = [],
                P = ag(b(this)),
                $ = b.extend({}, i.settings),
                f = b.extend(i.settings, d.util.datetime.defaults, g, P, $),
                I = a4(f.invalid),
                J = a4(f.valid),
                w = f.preset,
                K = w == 'datetime' ? f.dateFormat + f.separator + f.timeFormat : w == 'time' ? f.timeFormat : f.dateFormat,
                T = P.format || K,
                S = f.dateWheels || f.dateFormat,
                H = f.timeWheels || f.timeFormat,
                y = f.dateWheels || f.dateDisplay,
                G = H,
                a1 = f.baseTheme || f.theme,
                j = f.min || e(f.startYear, 0, 1),
                k = f.max || e(f.endYear, 11, 31, 23, 59, 59),
                R = /time/i.test(w),
                r = /h/.test(G),
                Z = /D/.test(y),
                E = f.steps || {},
                u = E.hour || f.stepHour || 1,
                q = E.minute || f.stepMinute || 1,
                z = E.second || f.stepSecond || 1,
                N = E.zeroBased,
                C = N ? 0 : j.getHours() % u,
                x = N ? 0 : j.getMinutes() % q,
                O = N ? 0 : j.getSeconds() % z,
                U = X(u, C, r ? 11 : 23),
                V = X(q, x, 59),
                W = X(q, x, 59),
                s = {
                    y: j.getFullYear(),
                    m: 0,
                    d: 1,
                    h: C,
                    i: x,
                    s: O,
                    a: 0,
                    tt: 0
                },
                n = {
                    y: k.getFullYear(),
                    m: 11,
                    d: 31,
                    h: U,
                    i: V,
                    s: W,
                    a: 1,
                    tt: 86400
                },
                o = {
                    y: 1,
                    m: 1,
                    d: 1,
                    h: u,
                    i: q,
                    s: z,
                    a: 1,
                    tt: 1
                },
                a5 = {
                    'android-holo': 40,
                    bootstrap: 46,
                    ios: 50,
                    jqm: 46,
                    material: 46,
                    mobiscroll: 46,
                    wp: 50
                },
                l = {
                    y: ac,
                    m: aa,
                    d: a9,
                    h: a8,
                    i: a7,
                    s: al,
                    u: aj,
                    a: ah,
                    dd: M,
                    tt: ae
                };
            i.getDate = i.getVal = function(a) {
                return i._hasValue || a ? A(i.getArrayVal(a)) : null;
            };
            i.setDate = function(a, b, c, d, e) {
                i.setArrayVal(F(a), b, e, d, c);
            };
            Y = a6();
            i.format = K;
            i.order = h;
            i.handlers.now = function() {
                i.setDate(new Date(), i.live, 1000, true, true);
            };
            i.buttons.now = {
                text: f.nowText,
                handler: 'now'
            };
            return {
                minWidth: a2 && R ? a5[a1] : a,
                compClass: 'mbsc-dt',
                wheels: Y,
                headerText: f.headerText ? function() {
                    return c.formatDate(K, A(i.getArrayVal(true)), f);
                } : false,
                formatValue: function(a) {
                    return c.formatDate(T, A(a), f);
                },
                parseValue: function(a) {
                    if (!a) {
                        D = {};
                    }
                    return F(a ? c.parseDate(T, a, f) : f.defaultValue && f.defaultValue.getTime ? f.defaultValue : new Date(), !!a && !!a.getTime);
                },
                validate: function(C) {
                    var c, p, u, E, G = C.values,
                        x = C.index,
                        D = C.direction,
                        m = i.settings.wheels[0][h.d],
                        g = af(A(G), D),
                        z = F(g),
                        q = [],
                        B = {},
                        e = l.y(g),
                        d = l.m(g),
                        r = f.getMaxDayOfMonth(e, d),
                        v = true,
                        w = true;
                    b.each(['dd', 'y', 'm', 'd', 'tt', 'a', 'h', 'i', 's'], function(y, c) {
                        if (h[c] !== a) {
                            var m = s[c],
                                t = n[c],
                                i = l[c](g);
                            q[h[c]] = [];
                            if (v && j) {
                                m = l[c](j);
                            }
                            if (w && k) {
                                t = l[c](k);
                            }
                            if (c != 'y' && c != 'dd') {
                                for (p = s[c]; p <= n[c]; p += o[c]) {
                                    if (p < m || p > t) {
                                        q[h[c]].push(p);
                                    }
                                }
                            }
                            if (i < m) {
                                i = m;
                            }
                            if (i > t) {
                                i = t;
                            }
                            if (v) {
                                v = i == m;
                            }
                            if (w) {
                                w = i == t;
                            }
                            if (c == 'd') {
                                var x = f.getDate(e, d, 1).getDay(),
                                    u = {};
                                a0(I, e, d, x, r, u, 1);
                                a0(J, e, d, x, r, u, 0);
                                b.each(u, function(a, b) {
                                    if (b) {
                                        q[h[c]].push(a);
                                    }
                                });
                            }
                        }
                    });
                    if (R) {
                        b.each(['a', 'h', 'i', 's', 'tt'], function(j, c) {
                            var m = l[c](g),
                                k = l.d(g),
                                f = {};
                            if (h[c] !== a) {
                                _(I, j, c, e, d, k, f, 0);
                                _(J, j, c, e, d, k, f, 1);
                                b.each(f, function(a, b) {
                                    if (b) {
                                        q[h[c]].push(a);
                                    }
                                });
                                t[j] = i.getValidValue(h[c], m, D, f);
                            }
                        });
                    }
                    if (m && (m._length !== r || Z && (x === a || x === h.y || x === h.m))) {
                        B[h.d] = m;
                        m.data = [];
                        for (c = 1; c <= r; c++) {
                            E = f.getDate(e, d, c).getDay();
                            u = y.replace(/[my]/gi, '').replace(/dd/, (c < 10 ? '0' + c : c) + (f.daySuffix || '')).replace(/d/, c + (f.daySuffix || ''));
                            m.data.push({
                                value: c,
                                display: u.match(/DD/) ? u.replace(/DD/, '<span class="mbsc-dt-day">' + f.dayNames[E] + '</span>') : u.replace(/D/, '<span class="mbsc-dt-day">' + f.dayNamesShort[E] + '</span>')
                            });
                        }
                        i._tempWheelArray[h.d] = z[h.d];
                        i.changeWheel(B);
                    }
                    return {
                        disabled: q,
                        valid: z
                    };
                }
            };
        };
    b.each(['date', 'time', 'datetime'], function(b, a) {
        ue.presets.scroller[a] = h;
    });
}());
   
   
   
   
    var ht = {
            controls: ["calendar"],
            firstDay: 0,
            weekDays: "short",
            maxMonthWidth: 170,
            months: 1,
            pageBuffer: 1,
            weeks: 6,
            highlight: !0,
            outerMonthChange: !0,
            quickNav: !0,
            yearChange: !0,
            tabs: "auto",
            todayClass: "mbsc-cal-today",
            btnCalPrevClass: "mbsc-ic mbsc-ic-arrow-left6",
            btnCalNextClass: "mbsc-ic mbsc-ic-arrow-right6",
            dateText: "Date",
            timeText: "Time",
            calendarText: "Calendar",
            todayText: "Today",
            prevMonthText: "Previous Month",
            nextMonthText: "Next Month",
            prevYearText: "Previous Year",
            nextYearText: "Next Year"
        },
        ft = function(e) {
            function t(t) {
                t.hasClass("mbsc-cal-h") && (t.removeClass("mbsc-cal-h"), e._onSelectShow())
            }

            function a(e) {
                e.hasClass("mbsc-cal-h") || e.addClass("mbsc-cal-h")
            }

            function n(e) {
                e.hasClass("mbsc-cal-h") ? t(e) : a(e)
            }

            function s(e, t, a) {
                var n, s, r, i, o, l = {},
                    c = Fe + He;
                return e && Le.each(e, function(e, d) {
                    if (n = d.d || d.start || d, r = n + "", d.start && d.end)
                        for (i = new Date(d.start); i <= d.end;) o = _(i.getFullYear(), i.getMonth(), i.getDate()), l[o] = l[o] || [], l[o].push(d), i.setDate(i.getDate() + 1);
                    else if (n.getTime) o = _(n.getFullYear(), n.getMonth(), n.getDate()), l[o] = l[o] || [], l[o].push(d);
                    else if (r.match(/w/i)) {
                        var m = +r.replace("w", ""),
                            u = 0,
                            h = je.getDate(t, a - Fe - Oe, 1).getDay();
                        for (je.firstDay - h + 1 > 1 && (u = 7), s = 0; s < 5 * Ee; s++) o = je.getDate(t, a - Fe - Oe, 7 * s - u - h + 1 + m), l[o] = l[o] || [], l[o].push(d)
                    } else if (r = r.split("/"), r[1]) a + c >= 11 && (o = je.getDate(t + 1, r[0] - 1, r[1]), l[o] = l[o] || [], l[o].push(d)), a - c <= 1 && (o = je.getDate(t - 1, r[0] - 1, r[1]), l[o] = l[o] || [], l[o].push(d)), o = je.getDate(t, r[0] - 1, r[1]), l[o] = l[o] || [], l[o].push(d);
                    else
                        for (s = 0; s < Ee; s++) o = je.getDate(t, a - Fe - Oe + s, r[0]), je.getDay(o) == r[0] && (l[o] = l[o] || [], l[o].push(d))
                }), l
            }

            function r(e) {
                return !(e < Me) && (!(e > xe) && (void 0 === me[e] || void 0 !== Re[e]))
            }

            function i(t) {
                var a, n, s, r, i = !!ve[t] && ve[t],
                    o = "";
                if (i) {
                    for (r = '<div class="mbsc-cal-marks">', a = 0; a < i.length; a++) r += '<div class="mbsc-cal-mark"' + (i[a].color ? ' style="background:' + i[a].color + ';"' : "") + "></div>", i[a].icon && (o += '<span class="mbsc-ic mbsc-ic-' + i[a].icon + '"' + (i[a].text ? "" : i[a].color ? ' style="color:' + i[a].color + ';"' : "") + "></span>\n");
                    r += "</div>", ce && (je.showEventCount ? n = ve[t].length + " " + (ve[t].length > 1 ? je.eventsText : je.eventText) : i[0] && (n = i[0].text, s = i[0].color), n ? r = '<div class="mbsc-cal-txt" title="' + Le("<div>" + n + "</div>").text() + '"' + (s ? ' style="background:' + s + ";color:" + D(s) + ';"' : "") + ">" + o + n + "</div>" : o && (r = '<div class="mbsc-cal-txt mbsc-cal-icons">' + o + "</div>"))
                }
                return ze({
                    marked: i,
                    cssClass: i ? "mbsc-cal-day-marked" : "",
                    ariaLabel: ce ? n : "",
                    markup: r
                }, e._getDayProps(t))
            }

            function l(e) {
                return ' style="' + (be ? "transform: translateY(" + 100 * e + "%)" : "left:" + 100 * e * Ye + "%") + '"'
            }

            function c() {
                Pe = "auto" == je.months ? Math.max(1, Math.min(3, Math.floor((Z || A(Q)) / 280))) : je.months, Ee = Pe + 2 * Fe, He = Math.floor(Pe / 2), Oe = Math.round(Pe / 2) - 1, We = void 0 === je.showOuterDays ? Pe < 2 : je.showOuterDays, be = be && Pe < 2, X = Z || 280 * Pe
            }

            function d(t, a) {
                me = s(je.invalid, t, a), Re = s(je.valid, t, a), ve = s(e._events || je.events || je.marked, t, a)
            }

            function m(e) {
                var t = je.getYear(e),
                    a = je.getMonth(e);
                se = e, $e("onMonthChange", {
                    year: t,
                    month: a
                }), $e("onMonthLoading", {
                    year: t,
                    month: a
                }), d(t, a), M(e)
            }

            function u(e) {
                var t = je.getYear(e),
                    a = je.getMonth(e);
                void 0 !== Ie ? g(e, Ie, !0) : $e("onMonthLoaded", {
                    year: t,
                    month: a
                })
            }

            function h() {
                var e;
                return e = '<div class="mbsc-cal-tabs-c"><ul class="mbsc-cal-tabs" role="tablist">', je.controls.forEach(function(t, a) {
                    ee[t] && (e += '<li role="tab" aria-controls="' + Ze.id + "-mbsc-pnl-" + a + '" class="mbsc-cal-tab mbsc-fr-btn-e ' + (a ? "" : ne) + '" data-control="' + t + '">' + (je.tabLink ? '<a href="#">' + je[t + "Text"] + "</a>" : je[t + "Text"]) + "</li>")
                }), e += "</ul></div>"
            }

            function f() {
                var e, t, a, n, s = "",
                    r = pe ? je.btnCalNextClass : je.btnCalPrevClass,
                    i = pe ? je.btnCalPrevClass : je.btnCalNextClass;
                for (n = '<div class="mbsc-cal-btn-w"><div data-step="-1" role="button" tabindex="0" aria-label="' + je.prevMonthText + '" class="' + r + ' mbsc-cal-prev mbsc-cal-prev-m mbsc-cal-btn mbsc-fr-btn mbsc-fr-btn-e"></div>', t = 0; t < Pe; t++) n += '<div role="button" class="mbsc-cal-month"></div>';
                for (n += '<div data-step="1" role="button" tabindex="0" aria-label="' + je.nextMonthText + '" class="' + i + ' mbsc-cal-next mbsc-cal-next-m mbsc-cal-btn mbsc-fr-btn mbsc-fr-btn-e"></div></div>', Ue && (s = '<div class="mbsc-cal-btn-w"><div data-step="-12" role="button" tabindex="0" aria-label="' + je.prevYearText + '" class="' + r + ' mbsc-cal-prev mbsc-cal-prev-y mbsc-cal-btn mbsc-fr-btn mbsc-fr-btn-e"></div><div role="button" class="mbsc-cal-year"></div><div data-step="12" role="button" tabindex="0" aria-label="' + je.nextYearText + '" class="' + i + ' mbsc-cal-next mbsc-cal-next-y mbsc-cal-btn mbsc-fr-btn mbsc-fr-btn-e"></div></div>'), e = '<div class="mbsc-w-p mbsc-cal-c"><div class="mbsc-cal ' + (Pe > 1 ? " mbsc-cal-multi " : "") + (Ke ? " mbsc-cal-weeks " : "") + (be ? " mbsc-cal-vertical" : "") + (le ? " mbsc-cal-has-marks" : "") + (ce ? " mbsc-cal-has-txt" : "") + (We ? "" : " mbsc-cal-hide-diff ") + (je.calendarClass || "") + '"' + (fe ? "" : ' style="width:' + (Z || 280 * Pe) + 'px;"') + '><div class="mbsc-cal-hdr">' + (qe < De || Pe > 1 ? s + n : n + s) + '</div><div class="mbsc-cal-body"><div class="mbsc-cal-day-picker"><div class="mbsc-cal-days-c">', a = 0; a < Pe; a++) {
                    for (e += '<div class="mbsc-cal-days">', t = 0; t < 7; t++) e += "<div>" + je["dayNames" + Be][(t + je.firstDay) % 7] + "</div>";
                    e += "</div>"
                }
                if (e += '</div><div class="mbsc-cal-scroll-c mbsc-cal-day-scroll-c ' + (je.calendarClass || "") + '"><div class="mbsc-cal-scroll" style="width:' + 100 / Pe + '%">' + g(se) + "</div></div></div>", de) {
                    for (e += '<div class="mbsc-cal-month-picker mbsc-cal-picker mbsc-cal-h"><div class="mbsc-cal-scroll-c ' + (je.calendarClass || "") + '"><div class="mbsc-cal-scroll">', t = 0; t < 3; t++) {
                        for (e += '<div class="mbsc-cal-slide"' + l(t - 1) + '><div role="grid" class="mbsc-cal-table"><div class="mbsc-cal-row">', a = 0; a < 12; a++) a && a % 3 == 0 && (e += '</div><div class="mbsc-cal-row">'), e += '<div role="gridcell"' + (1 == t ? ' tabindex="-1" aria-label="' + je.monthNames[a] + '" data-val="' + a + '"' : "") + ' class="mbsc-cal-cell' + (1 == t ? " mbsc-btn-e" : "") + '"><div class="mbsc-cal-cell-i mbsc-cal-cell-txt">' + (1 == t ? je.monthNamesShort[a] : "&nbsp;") + "</div></div>";
                        e += "</div></div></div>"
                    }
                    for (e += "</div></div></div>", e += '<div class="mbsc-cal-year-picker mbsc-cal-picker mbsc-cal-h"><div class="mbsc-cal-scroll-c ' + (je.calendarClass || "") + '"><div class="mbsc-cal-scroll">', t = -1; t < 2; t++) e += b(F(se, t), t);
                    e += "</div></div></div>"
                }
                return e += "</div></div></div>"
            }

            function b(e, t) {
                var a, n = je.getYear(e),
                    s = '<div class="mbsc-cal-slide"' + l(t) + '><div role="grid" class="mbsc-cal-table"><div class="mbsc-cal-row">';
                for (a = 0; a < 12; a++) a && a % 3 == 0 && (s += '</div><div class="mbsc-cal-row">'), s += '<div role="gridcell" tabindex="-1" aria-label="' + n + '" data-val="' + n + '" class="mbsc-cal-cell mbsc-btn-e ' + (n < ke || n > _e ? " mbsc-btn-d mbsc-fr-btn-d " : "") + (n == je.getYear(se) ? ae : "") + '"><div class="mbsc-cal-cell-i mbsc-cal-cell-txt">' + n + Xe + "</div></div>", n++;
                return s += "</div></div></div>"
            }

            function v(t, a) {
                var n, s, o, c, d, m, u, h, f, p, b, v, g, x, T, y, _ = 1,
                    w = 0,
                    M = je.getYear(t),
                    S = je.getMonth(t),
                    C = je.getDay(t),
                    k = null !== je.defaultValue || e._hasValue ? e.getDate(!0) : null,
                    D = je.getDate(M, S, C).getDay(),
                    N = '<div class="mbsc-cal-slide"' + l(a) + '><div role="grid" class="mbsc-cal-table"><div class="mbsc-cal-row">';
                for (je.firstDay - D > 0 && (w = 7), y = 0; y < 7 * G; y++) T = y + je.firstDay - w, n = je.getDate(M, S, T - D + C), o = n.getFullYear(), c = n.getMonth(), d = n.getDate(), m = je.getMonth(n), u = je.getDay(n), x = je.getMaxDayOfMonth(o, c), h = o + "-" + (c + 1) + "-" + d, f = ze({
                    valid: r(n),
                    selected: k && k.getFullYear() === o && k.getMonth() === c && k.getDate() === d
                }, i(n)), p = f.valid, b = f.selected, s = f.cssClass, v = new Date(n).setHours(12, 0, 0, 0) === (new Date).setHours(12, 0, 0, 0), g = m !== S, re[h] = f, y && y % 7 == 0 && (N += '</div><div class="mbsc-cal-row">'), Ke && y % 7 == 0 && ("month" == Ke && g && _ > 1 ? _ = 1 == d ? 1 : 2 : "year" == Ke && (_ = je.getWeekNumber(je.getDate(o, c, d + (7 - je.firstDay + 1) % 7))), N += '<div role="gridcell" class="mbsc-cal-cell mbsc-cal-week-nr">' + _ + "</div>", _++), N += '<div role="gridcell" tabindex="-1" aria-label="' + (v ? je.todayText + ", " : "") + je.dayNames[n.getDay()] + ", " + je.monthNames[m] + " " + u + " " + (f.ariaLabel ? ", " + f.ariaLabel : "") + '"' + (g && !We ? ' aria-hidden="true"' : "") + (b ? ' aria-selected="true"' : "") + (p ? "" : ' aria-disabled="true"') + ' data-full="' + h + '"class="mbsc-cal-cell mbsc-cal-day mbsc-cal-day' + T % 7 + " " + (je.dayClass || "") + " " + (b ? ae : "") + (v ? " " + je.todayClass : "") + (s ? " " + s : "") + (1 == u ? " mbsc-cal-day-first" : "") + (u == x ? " mbsc-cal-day-last" : "") + (g ? " mbsc-cal-day-diff" : "") + (p ? " mbsc-btn-e" : " mbsc-btn-d") + '"><div class="mbsc-cal-cell-i mbsc-cal-day-i"><div class="mbsc-cal-day-date mbsc-cal-cell-txt">' + u + "</div>" + (f.markup || "") + "</div></div>";
                return N += "</div></div></div>"
            }

            function g(e, t, a) {
                var n, s = je.getYear(e),
                    r = je.getMonth(e),
                    i = ie ? ie.pos : 0,
                    o = "";
                for (t || $e("onMonthLoading", {
                        year: s,
                        month: r
                    }), d(s, r), n = 0; n < Ee; n++) o += v(I(e, n - Oe - Fe), i + n - Fe);
                return Ie = void 0, a && ie && (ie.$scroller.html(o), $e("onMonthLoaded", {
                    year: s,
                    month: r
                })), o
            }

            function x(t) {
                var a = ie && ie.$scroller;
                je.highlight && ie && (Le(".mbsc-selected", a).removeClass(ae).removeAttr("aria-selected"), (null !== je.defaultValue || e._hasValue) && Le('.mbsc-cal-day[data-full="' + t.getFullYear() + "-" + (t.getMonth() + 1) + "-" + t.getDate() + '"]', a).addClass(ae).attr("aria-selected", "true"))
            }

            function T(e, t) {
                Le(".mbsc-selected", t).removeClass(ae).removeAttr("aria-selected"), Le('.mbsc-cal-cell[data-val="' + e + '"]', t).addClass(ae).attr("aria-selected", "true")
            }

            function y(e) {
                var t = e.getDay(),
                    a = 0;
                return je.firstDay - t > 0 && (a = 7), e = je.getDate(je.getYear(e), je.getMonth(e), je.firstDay - a - t + je.getDay(e)), je.getWeekNumber(e)
            }

            function w(e, t, a) {
                var n, s, r;
                e < Me && (e = Me), e > xe && (e = xe), oe && ("calendar" === Je || t) && (s = je.getYear(e), r = je.getMonth(e), Ve && (n = 6 == G ? r - je.getMonth(se) + 12 * (s - je.getYear(se)) : Math.floor((y(e) - y(se)) / G), se = 6 == G ? je.getDate(s, r, 1) : e, H(ie, n, a)), t || x(e), Ve = !0)
            }

            function M(e) {
                var t, a, n, s = je.getYear(e),
                    r = je.getMonth(e),
                    i = s + Xe;
                if (de) {
                    if (T(r, Ae.$scroller), T(s, Ge.$scroller), H(Ge, Math.floor(s / 12) - Math.floor(je.getYear(Ge.first) / 12)), Le(".mbsc-cal-cell", Ae.$scroller).removeClass("mbsc-btn-d mbsc-fr-btn-d"), s === ke)
                        for (t = 0; t < Ce; t++) Le('.mbsc-cal-cell[data-val="' + t + '"]', Ae.$scroller).addClass("mbsc-btn-d mbsc-fr-btn-d");
                    if (s === _e)
                        for (t = ye + 1; t <= 12; t++) Le('.mbsc-cal-cell[data-val="' + t + '"]', Ae.$scroller).addClass("mbsc-btn-d mbsc-fr-btn-d")
                }
                for (S(Le(".mbsc-cal-prev-m", W), je.getDate(s, r - Oe - 1, 1) < we), S(Le(".mbsc-cal-next-m", W), je.getDate(s, r + Pe - Oe, 1) > ge), S(Le(".mbsc-cal-prev-y", W), je.getDate(s - 1, r, 1) < we), S(Le(".mbsc-cal-next-y", W), je.getDate(s + 1, r, 1) > ge), B.attr("aria-label", s).html(i), t = 0; t < Pe; t++) e = je.getDate(s, r - Oe + t, 1), a = je.getYear(e), n = je.getMonth(e), i = a + Xe, $.eq(t).attr("aria-label", je.monthNames[n] + (Ue ? "" : " " + s)).html((!Ue && qe < De ? i + " " : "") + Ne[n] + (!Ue && qe > De ? " " + i : ""))
            }

            function S(e, t) {
                t ? e.addClass(te).attr("aria-disabled", "true") : e.removeClass(te).removeAttr("aria-disabled")
            }

            function C(t) {
                var a = e.live,
                    n = e.getDate(!0),
                    s = t.attr("data-full"),
                    r = s.split("-"),
                    i = _(r[0], r[1] - 1, r[2]),
                    o = _(i.getFullYear(), i.getMonth(), i.getDate(), n.getHours(), n.getMinutes(), n.getSeconds()),
                    l = t.hasClass("mbsc-selected");
                je.readonly || !We && t.hasClass("mbsc-cal-day-diff") || !1 !== $e("onDayChange", ze(re[s], {
                    date: o,
                    target: t[0],
                    selected: l
                })) && (Ve = je.outerMonthChange, he = !0, e.setDate(o, a, 0, !a, !0), a && $e("onSet", {
                    valueText: e._value
                }))
            }

            function k(e) {
                a(R), w(je.getDate(je.getYear(ie.first), e.attr("data-val"), 1), !0)
            }

            function V(e) {
                a(U), w(je.getDate(e.attr("data-val"), je.getMonth(ie.first), 1), !0)
            }

            function I(e, t) {
                var a = je.getYear(e),
                    n = je.getMonth(e),
                    s = je.getDay(e);
                return 6 == G ? je.getDate(a, n + t, 1) : je.getDate(a, n, s + t * G * 7)
            }

            function F(e, t) {
                var a = 12 * Math.floor(je.getYear(e) / 12);
                return je.getDate(a + 12 * t, 0, 1)
            }

            function H(t, a, n) {
                a && e._isVisible && (t.queue.push(arguments), 1 == t.queue.length && P(t, a, n))
            }

            function P(e, t, a) {
                var n, s, r = "",
                    i = e.$scroller,
                    o = e.buffer,
                    l = e.offset,
                    c = e.pages,
                    d = e.total,
                    m = e.first,
                    u = e.genPage,
                    h = e.getFirst,
                    f = t > 0 ? Math.min(t, o) : Math.max(t, -o),
                    p = e.pos * Ye + f - t + l,
                    b = Math.abs(t) > o;
                if (e.first = h(m, t), e.pos += f * Ye, e.changing = !0, e.onBeforeChange(e.first), b) {
                    for (n = 0; n < c; n++) s = t + n - l, r += u(h(m, s), p + s);
                    t > 0 ? (Le(".mbsc-cal-slide", i).slice(-c).remove(), i.append(r)) : t < 0 && (Le(".mbsc-cal-slide", i).slice(0, c).remove(), i.prepend(r))
                }
                e.scroller.scroll(-e.pos * e.size, 200, !1, function() {
                    var r = Math.abs(f),
                        c = "";
                    for (n = 0; n < r; n++) s = t + n - l - o + (t > 0 ? d - r : 0), c += u(h(m, s), p + s);
                    if (t > 0 ? (i.append(c), Le(".mbsc-cal-slide", i).slice(0, f).remove()) : t < 0 && (i.prepend(c), Le(".mbsc-cal-slide", i).slice(f).remove()), b) {
                        for (c = "", n = 0; n < r; n++) s = t + n - l - o + (t > 0 ? 0 : d - r), c += u(h(m, s), p + s);
                        t > 0 ? (Le(".mbsc-cal-slide", i).slice(0, f).remove(), i.prepend(c)) : t < 0 && (Le(".mbsc-cal-slide", i).slice(f).remove(), i.append(c))
                    }
                    L(e), a && a(), e.queue.shift(), e.queue.length ? P.apply(this, e.queue[0]) : (e.changing = !1, e.onAfterChange(e.first))
                })
            }

            function O(e, t, a, n, s, r, i, o, l, c, d, m, u) {
                var h = be ? "Y" : "X",
                    f = {
                        $scroller: Le(".mbsc-cal-scroll", e),
                        queue: [],
                        buffer: n,
                        offset: s,
                        pages: r,
                        first: o,
                        total: i,
                        pos: 0,
                        min: t,
                        max: a,
                        genPage: m,
                        getFirst: u,
                        onBeforeChange: c,
                        onAfterChange: d
                    };
                return f.scroller = new it(e, {
                    axis: h,
                    easing: "",
                    contSize: 0,
                    maxSnapScroll: n,
                    mousewheel: je.mousewheel,
                    time: 200,
                    lock: !0,
                    rtl: pe,
                    stopProp: !1,
                    minScroll: 0,
                    maxScroll: 0,
                    onBtnTap: function(e) {
                        "touchend" == e.domEvent.type && p(), l(Le(e.target))
                    },
                    onAnimationEnd: function(e) {
                        m && H(f, Math.round((-f.pos * f.size - e["pos" + h]) / f.size) * Ye)
                    }
                }), f
            }

            function L(e) {
                var t = 0,
                    a = 0,
                    n = e.first;
                if (e.getFirst) {
                    for (t = e.buffer, a = e.buffer; a && e.getFirst(n, a + e.pages - e.offset - 1) > e.max;) a--;
                    for (; t && e.getFirst(n, -t - e.offset) < e.min;) t--
                }
                e.size = Math.round(X / e.pages), ze(e.scroller.settings, {
                    snap: e.size,
                    minScroll: (-e.pos * Ye - a) * e.size,
                    maxScroll: (-e.pos * Ye + t) * e.size
                }), e.scroller.refresh()
            }

            function E(t) {
                e._isVisible && oe && (ie && ie.changing ? Ie = t : g(se, t, !0))
            }

            function Y() {
                if (oe) {
                    var t = Le(".mbsc-cal-scroll-c", W);
                    ie = O(t[0], we, ge, Fe, Oe, Pe, Ee, se, C, m, u, v, I), de && (Ae = O(t[1], null, null, 1, 0, 1, 3, se, k), Ge = O(t[2], Se, Te, 1, 0, 1, 3, se, V, o, o, b, F), e.tap($, function() {
                        n(R), a(U)
                    }), e.tap(B, function() {
                        n(U), a(R)
                    })), N(Le(".mbsc-cal-btn", W), function(e, t) {
                        var a = 6 == G ? je.getDate(je.getYear(se), je.getMonth(se) + e, 1) : je.getDate(je.getYear(se), je.getMonth(se), je.getDay(se) + e * G * 7);
                        a < we || a > ge || w(a, !0, t)
                    }), u(se)
                }
                e.tap(Le(".mbsc-cal-tab", W), function() {
                    e.changeTab(Le(this).attr("data-control"))
                })
            }
            var z, j, W, $, R, J, K, B, U, q, G, X, Z, Q, ee, te, ae, ne, se, re, ie, oe, le, ce, de, me, he, fe, pe, be, ve, ge, xe, Te, ye, _e, we, Me, Se, Ce, ke, De, Ne, Ae, Ve, Ie, Fe, He, Pe, Oe, Ee, Ye, je, We, $e, Re, Je, Ke, Be, Ue, qe, Ge, Xe, Ze = this;
            return function() {
            	//console.log(ue..presets.scroller.call(this, e))
                    var t, a, n;
                    ee = {}, $e = e.trigger, z = Le(Ze), n = ze({}, e.settings), je = ze(e.settings, ht, n), t = je.controls.join(","), pe = je.rtl, Fe = je.pageBuffer, Ke = je.weekCounter, G = je.weeks, be = "vertical" == je.calendarScroll, Q = "inline" == je.display ? z.is("div") ? z : z.parent() : e._$window, Be = "full" == je.weekDays ? "" : "min" == je.weekDays ? "Min" : "Short", a = je.layout || (/top|bottom|inline/.test(je.display) ? "liquid" : ""), fe = "liquid" == a, Z = fe ? null : je.calendarWidth, Ye = pe && !be ? -1 : 1, te = "mbsc-fr-btn-d " + (je.disabledClass || ""), ne = "mbsc-selected " + (je.selectedTabClass || ""), ae = "mbsc-selected " + (je.selectedClass || ""), le = !!(e._events || je.events || je.marked), ce = je.showEventCount || !!je.events, t.match(/date/) && (ee.date = 1), t.match(/time/) && (ee.time = 1), t.match(/calendar/) && (ee.calendar = 1, oe = !0), de = je.quickNav && oe && 6 == G, Ue = je.yearChange && 6 == G, fe && oe && "center" == je.display && (e._isFullScreen = !0), je.layout = a, je.preset = (ee.date || oe ? "date" : "") + (ee.time ? "time" : "")
                }(), q = Xt.datetime.call(this, e),
                function() {
                    Ne = Ue ? je.monthNamesShort : je.monthNames, Xe = je.yearSuffix || "", 
                    De = (je.dateWheels || je.dateFormat).search(/m/i), 
                    qe = (je.dateWheels || je.dateFormat).search(/y/i), 
                    je.min && (we = _(je.min.getFullYear(), 
                    je.min.getMonth(), 1), 
                    Me = _(je.min.getFullYear(), je.min.getMonth(), je.min.getDate()),
                    ke = je.getYear(we), 
                    Ce = je.getMonth(we), 
                    Se = je.getDate(12 * Math.floor(ke / 12), 0, 1)), 
                    je.max && (ge = _(je.max.getFullYear(), je.max.getMonth(), 1), 
                    xe = _(je.max.getFullYear(), je.max.getMonth(), je.max.getDate()), 
                    _e = je.getYear(ge), ye = je.getMonth(ge), 
                    Te = je.getDate(12 * Math.floor(_e / 12), 0, 1))
                }(), e.refresh = function() {
                    E(!1)
                }, e.redraw = function() {
                    E(!0)
                }, e.navigate = function(e) {
                    w(e, !0)
                }, e.changeTab = function(t) {
                    e._isVisible && ee[t] && Je != t && (Je = t, Le(".mbsc-cal-tab", W).removeClass(ne).removeAttr("aria-selected"), Le('.mbsc-cal-tab[data-control="' + t + '"]', W).addClass(ne).attr("aria-selected", "true"), K.addClass("mbsc-cal-h"), ee[Je].removeClass("mbsc-cal-h"), "calendar" == Je && w(e.getDate(!0)), e._showDayPicker(), e.trigger("onTabChange", {
                        tab: Je
                    }))
                }, e._onSelectShow = o, e._getDayProps = o, e._prepareObj = s, e._showDayPicker = function() {
                    de && (a(U, !0), a(R, !0))
                }, ze(q, {
                    compClass: "mbsc-calendar mbsc-dt",
                    onMarkupReady: function(t) {
                        var a, n, s, r = 0;
                        W = Le(t.target), J = Le(".mbsc-fr-c", W), re = {}, s = e.getDate(!0), a = je.getYear(s), n = je.getMonth(s), se = 6 == G ? je.getDate(a, n, 1) : s, oe && (Ve = !0, Je = "calendar", c(), J.append(f()), $ = Le(".mbsc-cal-month", W), B = Le(".mbsc-cal-year", W), j = Le(".mbsc-cal-day-scroll-c", W)), de && (U = Le(".mbsc-cal-year-picker", W), R = Le(".mbsc-cal-month-picker", W)), K = Le(".mbsc-w-p", W), je.controls.length > 1 && J.before(h()), ["date", "time", "calendar"].forEach(function(e) {
                            ee[e] ? ee[e] = K.eq(r).addClass("mbsc-cal-h") : "date" == e && !ee.date && oe && K.eq(r).remove(), r++
                        }), je.controls.forEach(function(e) {
                            J.append(ee[e])
                        }), oe && ee.date && (je.tabs = !0), !oe && ee.date && ee.date.css("position", "relative"), Y()
                    },
                    onShow: function() {
                        oe && M(se)
                    },
                    onHide: function() {
                        oe && (ie.scroller.destroy(), de && (Ae.scroller.destroy(), Ge.scroller.destroy()), ie = null, Ae = null, Ge = null, Je = null)
                    },
                    onValidated: function(t) {
                        var a, n, s = e.order;
                        n = e.getDate(!0), 
                        he ? a = "calendar" : void 0 !== t && (a = s.dd == t || s.d == t || s.m == t || s.y == t ? "date" : "time"), 
                        $e("onSetDate", {
                            date: n,
                            control: a
                        }), 
                        w(n),
                        he = !1
                    },
                    onPosition: function(t) {
                        var a, n = t.windowHeight,
                            s = (t.hasTabs || !0 === je.tabs || !1 !== je.tabs && fe) && je.controls.length > 1;
                        s ? (W.addClass("mbsc-cal-tabbed"), Je = Le(".mbsc-cal-tab.mbsc-selected", W).attr("data-control"), K.addClass("mbsc-cal-h"), ee[Je].removeClass("mbsc-cal-h")) : (Je = "calendar", W.removeClass("mbsc-cal-tabbed"), K.removeClass("mbsc-cal-h")), e._isFullScreen && (j.height(""), a = t.popup.offsetHeight, n >= a && j.height(n - a + j[0].offsetHeight)), oe && ((fe || be || s) && (X = j[0][be ? "offsetHeight" : "offsetWidth"]), L(ie)), de && (L(Ae), L(Ge))
                    }
                })
        },
        pt = {};
    ue.presetShort("calendar"), ue.presets.scroller.calendar = function(e) {
        function t(e) {
            return _(e.getFullYear(), e.getMonth(), e.getDate())
        }

        function a(e) {
            if (b = {}, e && e.length)
                for (o = 0; o < e.length; o++) b[t(e[o])] = e[o]
        }

        function n() {
            e.redraw()
        }
        var s, r, i, o, c, m = ze({}, e.settings),
            u = ze(e.settings, pt, m),
            h = u.defaultValue,
            f = "multiple" == u.select || u.select > 1 || "week" == u.selectType,
            p = d(u.select) ? u.select : 1 / 0,
            b = {};
        if (s = ft.call(this, e), i = void 0 === u.firstSelectDay ? u.firstDay : u.firstSelectDay, f && h && h.length)
            for (o = 0; o < h.length; o++) b[t(h[o])] = h[o];
        return e._getDayProps = function(e) {
            return {
                selected: f ? void 0 !== b[e] : void 0
            }
        }, e.setVal = function(t, s, r, i, o) {
            f && (a(t), t = t ? t[0] : null), e._setVal(t, s, r, i, o), n()
        }, e.getVal = function(t) {
            return f ? l(b) : e.getDate(t)
        }, ze({}, s, {
            highlight: !f,
            outerMonthChange: !f,
            parseValue: function(a) {
                var n, r;
                if (f && a && "string" == typeof a) {
                    for (b = {}, a = a.split(","), n = 0; n < a.length; n++) r = M(e._format, a[n].replace(/^\s+|\s+$/g, ""), u), b[t(r)] = r;
                    a = a[0]
                }
                return f && h && h.length && (u.defaultValue = h[0]), s.parseValue.call(this, a)
            },
            formatValue: function(t) {
                var a, n = [];
                if (f) {
                    for (a in b) n.push(w(e.format, b[a], u));
                    return n.join(", ")
                }
                return s.formatValue.call(this, t)
            },
            onClear: function() {
                f && (b = {}, n())
            },
            onBeforeShow: function() {
                void 0 !== u.setOnDayTap || u.buttons && u.buttons.length || (u.setOnDayTap = !0), u.setOnDayTap && "inline" != u.display && (u.outerMonthChange = !1), u.counter && f && (u.headerText = function() {
                    var e = 0,
                        t = "week" == u.selectType ? 7 : 1;
                    return Le.each(b, function() {
                        e++
                    }), e = Math.round(e / t), (e > 1 ? u.selectedPluralText || u.selectedText : u.selectedText).replace(/{count}/, e)
                })
            },
            onMarkupReady: function(e) {
                s.onMarkupReady.call(this, e), r = Le(e.target), f && (Le(".mbsc-fr-hdr", r).attr("aria-live", "off"), c = ze({}, b))
            },
            onDayChange: function(a) {
                var s = a.date,
                    o = t(s),
                    c = Le(a.target),
                    d = a.selected;
                if (f)
                    if ("week" == u.selectType) {
                        var m, h, v = o.getDay() - i;
                        for (v = v < 0 ? 7 + v : v, "multiple" != u.select && (b = {}), m = 0; m < 7; m++) h = _(o.getFullYear(), o.getMonth(), o.getDate() - v + m), d ? delete b[h] : l(b).length / 7 < p && (b[h] = h);
                        n()
                    } else {
                        var g = Le('.mbsc-cal-day[data-full="' + c.attr("data-full") + '"]', r);
                        d ? (g.removeClass("mbsc-selected").removeAttr("aria-selected"), delete b[o]) : l(b).length < p && (g.addClass("mbsc-selected").attr("aria-selected", "true"), b[o] = o)
                    }
                if (u.setOnDayTap && "multiple" != u.select && "inline" != u.display) return e.setDate(s), e.select(), !1
            },
            onCancel: function() {
                !e.live && f && (b = ze({}, c))
            }
        })
    };
    var bt = function(e, t, a) {
            var n, s, r, i, l = this;
            je.call(this, e, t, !0), l.__init = o, l.__destroy = o, l._init = function(t) {
                var a;
                i = l.settings, n = Le(e), a = !!s, s = n.parent(), s = s.hasClass("mbsc-input-wrap") ? s.parent() : s, l._$parent = s, r && s.removeClass(r), r = l._css + " mbsc-progress-w mbsc-control-w mbsc-" + i.theme + (i.baseTheme ? " mbsc-" + i.baseTheme : "") + (i.rtl ? " mbsc-rtl" : " mbsc-ltr"), s.addClass(r), n.addClass("mbsc-control"), l.__init(t), a || l._attachChange(), l.refresh()
            }, l._destroy = function() {
                l.__destroy(), s.removeClass(r), n.removeClass("mbsc-control")
            }, a || l.init(t)
        },
        vt = "mbsc-input-wrap",
        gt = function(e, t, a) {
            function n() {
                var e = s("value", u);
                e !== b && r(e)
            }

            function s(e, t) {
                var a = o.attr(e);
                return void 0 === a || "" === a ? t : +a
            }

            function r(e, t, a, n) {
                e = Math.min(h, Math.max(e, u)), c.css("width", 100 * (e - u) / (h - u) + "%"), void 0 === a && (a = !0), void 0 === n && (n = a), (e !== b || t) && g._display(e), e !== b && (b = e, a && o.attr("value", b), n && o.trigger("change"))
            }
            var i, o, l, c, d, m, u, h, f, p, b, v, g = this;
            bt.call(this, e, t, !0), g._display = function(e) {
                v = p && f.returnAffix ? p.replace(/\{value\}/, e).replace(/\{max\}/, h) : e, d && d.html(v), i && i.html(v)
            }, g._attachChange = function() {
                o.on("change", n)
            }, g.__init = function(t) {
                var a, n, r, v;
                if (f = g.settings, o = Le(e), v = !!l, l = g._$parent, u = g._min = void 0 === t.min ? s("min", f.min) : t.min, h = g._max = void 0 === t.max ? s("max", f.max) : t.max, b = s("value", u), a = o.attr("data-val") || f.val, r = o.attr("data-step-labels"), r = r ? JSON.parse(r) : f.stepLabels, p = o.attr("data-template") || (100 != h || f.template ? f.template : "{value}%"), v ? (a && (i.remove(), l.removeClass("mbsc-progress-value-" + ("right" == a ? "right" : "left"))), r && Le(".mbsc-progress-step-label", m).remove()) : (F(l), V(o), l.find(".mbsc-input-wrap").append('<span class="mbsc-progress-cont"><span class="mbsc-progress-track mbsc-progress-anim"><span class="mbsc-progress-bar"></span></span></span>'), c = g._$progress = l.find(".mbsc-progress-bar"), m = g._$track = l.find(".mbsc-progress-track")), o.attr("min", u).attr("max", h), a && (i = Le('<span class="mbsc-progress-value"></span>'), l.addClass("mbsc-progress-value-" + ("right" == a ? "right" : "left")).find(".mbsc-input-wrap").append(i)), r)
                    for (n = 0; n < r.length; ++n) m.append('<span class="mbsc-progress-step-label" style="' + (f.rtl ? "right" : "left") + ": " + 100 * (r[n] - u) / (h - u) + '%" >' + r[n] + "</span>");
                d = Le(o.attr("data-target") || f.target)
            }, g.__destroy = function() {
                l.removeClass("mbsc-ic-left mbsc-ic-right").find(".mbsc-progress-cont").remove(), l.find(".mbsc-input-ic").remove(), o.off("change", n)
            }, g.refresh = function() {
                r(s("value", u), !0, !1)
            }, g.getVal = function() {
                return b
            }, g.setVal = function(e, t, a) {
                r(e, !0, t, a)
            }, a || g.init(t)
        };
    gt.prototype = {
        _class: "progress",
        _css: "mbsc-progress",
        _hasTheme: !0,
        _hasLang: !0,
        _hasDef: !0,
        _defaults: {
            min: 0,
            max: 100,
            returnAffix: !0
        }
    }, ue.classes.Progress = gt, ue.presetShort("progress", "Progress");
    var xt = function(e, t, a) {
            function n(t) {
                !C(t, this) || k || e.disabled || ($.stopProp && t.stopPropagation(), k = !0, Y = !1, D = !1, J = v(t, "X"), K = v(t, "Y"), I = J, S.removeClass("mbsc-progress-anim"), T = z ? Le(".mbsc-slider-handle", this) : _, y && y.removeClass("mbsc-handle-curr"), y = T.parent().addClass("mbsc-active mbsc-handle-curr"), H = +T.attr("data-index"), q = S[0].offsetWidth, V = S[0].getBoundingClientRect().left, "mousedown" === t.type && (t.preventDefault(), Le(document).on("mousemove", s).on("mouseup", r)))
            }

            function s(e) {
                k && (I = v(e, "X"), F = v(e, "Y"), N = I - J, A = F - K, (Math.abs(N) > 5 || Y) && (Y = !0, Math.abs(Z - new Date) > 50 && (Z = new Date, f(I, $.round, O))), Y ? e.preventDefault() : Math.abs(A) > 7 && h())
            }

            function r(e) {
                k && (e.preventDefault(), z || S.addClass("mbsc-progress-anim"), f(I, !0, !0), Y || D || ("touchend" == e.type && p(), X._onTap(G[H])), h())
            }

            function i() {
                k && h()
            }

            function l() {
                var e = X._readValue(Le(this)),
                    t = +Le(this).attr("data-index");
                e !== G[t] && (G[t] = e, j[t] = e, g(e, t))
            }

            function c(e) {
                e.stopPropagation()
            }

            function d(e) {
                e.preventDefault()
            }

            function m(t) {
                var a;
                if (!e.disabled) {
                    switch (t.keyCode) {
                        case 38:
                        case 39:
                            a = 1;
                            break;
                        case 40:
                        case 37:
                            a = -1
                    }
                    a && (t.preventDefault(), U || (H = +Le(this).attr("data-index"), g(G[H] + W * a, H, !0), U = setInterval(function() {
                        g(G[H] + W * a, H, !0)
                    }, 200)))
                }
            }

            function u(e) {
                e.preventDefault(), clearInterval(U), U = null
            }

            function h() {
                k = !1, y.removeClass("mbsc-active"), Le(document).off("mousemove", s).off("mouseup", r)
            }

            function f(e, t, a) {
                var n = t ? Math.min(Math.round(Math.max(100 * (e - V) / q, 0) / R / W) * W * 100 / (L - E), 100) : Math.max(0, Math.min(100 * (e - V) / q, 100));
                P && (n = 100 - n), g(Math.round((E + n / R) * B) / B, H, a, n)
            }

            function b(e) {
                return 100 * (e - E) / (L - E)
            }

            function g(e, t, a, n, s, r) {
                var i = _.eq(t),
                    o = i.parent();
                e = Math.min(L, Math.max(e, E)), void 0 === r && (r = a), X._update ? e = X._update(e, G, t, n, z, s, o) : o.css({
                    left: P ? "auto" : (n || b(e)) + "%",
                    right: P ? (n || b(e)) + "%" : "auto"
                }), e > E ? o.removeClass("mbsc-slider-start") : (G[t] > E || s) && o.addClass("mbsc-slider-start"), a && j[t] != e && (D = !0, j[t] = e, G[t] = e, X._fillValue(e, t, r)), i.attr("aria-valuenow", e)
            }
            var x, T, y, _, w, M, S, k, D, N, A, V, I, F, H, P, O, L, E, Y, z, j, W, $, R, J, K, B, U, q, G, X = this,
                Z = new Date;
            bt.call(this, e, t, !0), X._onTap = o, X.___init = o, X.___destroy = o, X._attachChange = function() {
                x.on($.changeEvent, l)
            }, X.__init = function(e) {
                var t;
                _ && (t = !0, _.parent().remove()), X.___init(e), M = X._$parent, S = X._$track, x = M.find("input"), $ = X.settings, E = X._min, L = X._max, W = X._step, O = X._live, B = W % 1 != 0 ? 100 / (100 * +(W % 1).toFixed(2)) : 1, R = 100 / (L - E) || 100, z = x.length > 1, P = $.rtl, G = [], j = [], x.each(function(e) {
                    G[e] = X._readValue(Le(this)), Le(this).attr("data-index", e)
                }), _ = M.find(".mbsc-slider-handle"), w = M.find(z ? ".mbsc-slider-handle-cont" : ".mbsc-progress-cont"), _.on("keydown", m).on("keyup", u).on("blur", u), w.on("touchstart mousedown", n).on("touchmove", s).on("touchend touchcancel", r).on("pointercancel", i), t || (x.on("click", c), M.on("click", d))
            }, X.__destroy = function() {
                M.off("click", d), x.off($.changeEvent, l).off("click", c), _.off("keydown", m).off("keyup", u).off("blur", u), w.off("touchstart mousedown", n).off("touchmove", s).off("touchend touchcancel", r).off("pointercancel", i), X.___destroy()
            }, X.refresh = function() {
                x.each(function(e) {
                    g(X._readValue(Le(this)), e, !0, !1, !0, !1)
                })
            }, X.getVal = function() {
                return z ? G.slice(0) : G[0]
            }, X.setVal = X._setVal = function(e, t, a) {
                Le.isArray(e) || (e = [e]), Le.each(e, function(e, t) {
                    G[e] = t
                }), Le.each(e, function(e, t) {
                    g(t, e, !0, !1, !0, a)
                })
            }, a || X.init(t)
        },
        Tt = function(e, t, a) {
            function n(e) {
                return 100 * (e - p) / (f - p)
            }

            function s(e, t) {
                var a = r.attr(e);
                return void 0 === a || "" === a ? t : "true" === a
            }
            var r, i, o, l, c, d, m, u, h, f, p, b, v, g = this;
            gt.call(this, e, t, !0);
            var x = g.__init,
                T = g.__destroy;
            xt.call(this, e, t, !0);
            var y = g.__init,
                _ = g.__destroy;
            g.__init = function(e) {
                x(e), y(e)
            }, g.__destroy = function() {
                T(), _()
            }, g._update = function(e, t, a, s, r, i, c) {
                return u ? 0 === a ? (e = Math.min(e, t[1]), o.css({
                    width: n(t[1]) - n(e) + "%",
                    left: h ? "auto" : n(e) + "%",
                    right: h ? n(e) + "%" : "auto"
                })) : (e = Math.max(e, t[0]), o.css({
                    width: n(e) - n(t[0]) + "%"
                })) : r || !d ? c.css({
                    left: h ? "auto" : (s || n(e)) + "%",
                    right: h ? (s || n(e)) + "%" : "auto"
                }) : o.css("width", (s || n(e)) + "%"), m && l.eq(a).html(e), r || t[a] == e && !i || g._display(e), e
            }, g._readValue = function(e) {
                return +e.val()
            }, g._fillValue = function(e, t, a) {
                r.eq(t).val(e), a && r.eq(t).trigger("change")
            }, g.___init = function(e) {
                var t, a;
                if (i && (i.removeClass("mbsc-slider-has-tooltip"), 1 != b && Le(".mbsc-slider-step", c).remove()), i = g._$parent, c = g._$track, o = g._$progress, r = i.find("input"), v = g.settings, p = g._min, f = g._max, g._step = b = void 0 === e.step ? +r.attr("step") || v.step : e.step, g._live = s("data-live", v.live), m = s("data-tooltip", v.tooltip), d = s("data-highlight", v.highlight) && r.length < 3, u = d && 2 == r.length, h = v.rtl, m && i.addClass("mbsc-slider-has-tooltip"), 1 != b)
                    for (a = (f - p) / b, t = 0; t <= a; ++t) c.append('<span class="mbsc-slider-step" style="' + (h ? "right" : "left") + ":" + 100 / a * t + '%"></span>');
                r.each(function(e) {
                    "range" == this.type && Le(this).attr("min", p).attr("max", f).attr("step", b), (d ? o : c).append('<span class="mbsc-slider-handle-cont' + (u && !e ? " mbsc-slider-handle-left" : "") + '"><span tabindex="0" class="mbsc-slider-handle" aria-valuemin="' + p + '" aria-valuemax="' + f + '" data-index="' + e + '"></span>' + (m ? '<span class="mbsc-slider-tooltip"></span>' : "") + "</span>")
                }), l = i.find(".mbsc-slider-tooltip")
            }, a || g.init(t)
        };
    Tt.prototype = {
        _class: "progress",
        _css: "mbsc-progress mbsc-slider",
        _hasTheme: !0,
        _hasLang: !0,
        _hasDef: !0,
        _defaults: {
            changeEvent: "change",
            stopProp: !0,
            min: 0,
            max: 100,
            step: 1,
            live: !0,
            highlight: !0,
            round: !0,
            returnAffix: !0
        }
    }, ue.classes.Slider = Tt, ue.presetShort("slider", "Slider");
    var yt = ue.util,
        _t = ue.classes,
        wt = function(e, t, a) {
            function n(e, t, a) {
                if (!a) {
                    G._value = G._hasValue ? G._tempValue.slice(0) : null;
                    for (var n = 0; n < y.length; ++n) y[n].tempChangedColor && G._value && -1 != G._value.indexOf(y[n].tempChangedColor) && (y[n].changedColor = y[n].tempChangedColor), delete y[n].tempChangedColor
                }
                e && (G._isInput && X.val(G._hasValue ? G._tempValue : ""), _("onFill", {
                    valueText: G._hasValue ? G._tempValue : "",
                    change: t
                }), t && (Q = ze(!0, {}, ee), G._preventChange = !0, X.trigger("change")), u(G._value, !0))
            }

            function s(e, t) {
                return t = void 0 !== t ? t : i(e), '<div class="mbsc-color-input-item" data-color="' + (void 0 !== t ? t : e) + '" style="background: ' + e + ';">' + (E ? "" : '<div class="mbsc-color-input-item-close mbsc-ic mbsc-ic-material-close"></div>') + "</div>"
            }

            function r(e) {
                A[0].style.background = e ? Je + "linear-gradient(left, " + (x.rtl ? "#000000" : "#FFFFFF") + " 0%, " + e + " 50%, " + (x.rtl ? "#FFFFFF" : "#000000") + " 100%)" : ""
            }

            function i(e) {
                if (Object.keys(ee).length && !isNaN(e)) return e;
                for (var t in y)
                    if (e == y[t].color || e == y[t].changedColor) return t
            }

            function o() {
                if (L) {
                    var e, t = "";
                    if (J.empty(), G._value) {
                        if (E) t += s(G._value, O);
                        else
                            for (e = 0; e < G._value.length; ++e) t += s(G._value[e], Object.keys(ee).length && ee[e].colorIndex ? ee[e].colorIndex : i(G._value[e]));
                        J.append(t), G.tap(Le(".mbsc-color-input-item", J), function(e) {
                            if (Le(e.target).hasClass("mbsc-color-input-item-close")) {
                                var t = Le(this).index();
                                e.stopPropagation(), e.preventDefault(), void 0 === O && (O = Le(e.target).parent().attr("data-color")), N && (Z = y[O].previewInd, B.eq(Z).parent().removeClass("mbsc-color-active"), Q[t] = {}, ee[t] = {}), G._value.splice(t, 1), G.setVal(G._value, !0, !0)
                            } else V && "inline" !== x.display && (O = Le(e.target).attr("data-color"), isNaN(O) && (O = i(O)), O && (y[O].selected = !0, Z = y[O].previewInd, setTimeout(function() {
                                w.scroll(K.eq(O), 400), N && M.scroll(B.eq(Z), 400)
                            }, 200)))
                        })
                    }
                }
            }

            function l(e, t) {
                var a, n = e.match(/\d+/gim);
                switch (!0) {
                    case e.indexOf("rgb") > -1:
                        a = H({
                            r: n[0],
                            g: n[1],
                            b: n[2]
                        });
                        break;
                    case e.indexOf("hsl") > -1:
                        a = j({
                            h: n[0],
                            s: n[1],
                            l: n[2]
                        });
                        break;
                    case e.indexOf("hsv") > -1:
                        a = W({
                            h: n[0],
                            s: n[1],
                            v: n[2]
                        });
                        break;
                    case e.indexOf("#") > -1:
                        a = e
                }
                return c(a, t || x.format)
            }

            function c(e, t) {
                switch (t) {
                    case "rgb":
                        return P(e);
                    case "hsl":
                        return z(e);
                    case "hsv":
                        return $(e);
                    default:
                        return e
                }
            }

            function d() {
                var e;
                for (e = 0; e < x.select; ++e)
                    if (void 0 === ee[e].colorIndex) return e
            }

            function m(e, t) {
                Le(".mbsc-color-active", t).removeClass("mbsc-color-active"), V && (e.parent().addClass("mbsc-color-active"), N && e && void 0 !== Z && B.eq(Z).parent().addClass("mbsc-color-active"))
            }

            function u(e, t) {
                var a, n, s = [],
                    r = 0,
                    i = Le.map(y, function(e) {
                        return e.changedColor || e.color
                    });
                if (E) {
                    if (e = Le.isArray(e) ? e[0] : e, n = i.indexOf(e), n > -1 && s.push(n), e && !s.length) {
                        var l = +Le(".mbsc-color-input-item", J).attr("data-color");
                        isNaN(l) || s.push(l), O = l
                    }
                } else if (e)
                    if (N && V)
                        for (var c in Q) void 0 !== Q[c].colorIndex && s.push(+Q[c].colorIndex);
                    else
                        for (a = 0; a < e.length; ++a)(n = i.indexOf(e[a])) > -1 && (s.push(n), i[n] = "temp" + a);
                for (a = 0; a < s.length; ++a) f(!0, s[a], r++, y[s[a]].changedColor || y[s[a]].color, !0);
                for (a = 0; a < y.length; ++a) - 1 == s.indexOf(a) && f(!1, a, void 0, y[a].changedColor || y[a].color, !1);
                if (N)
                    for (a = r; a < x.select; ++a) ee[a] = {}, B && B.eq(a).addClass("mbsc-color-preview-item-empty").css({
                        background: "transparent"
                    });
                Q = ze(!0, {}, ee), !1 !== t && o()
            }

            function f(e, t, a, n, s, r) {
                if (N && s && (ee[a].colorIndex = e ? t : void 0, ee[a].color = e ? n : void 0, B)) {
                    var i = B.eq(a);
                    i.removeClass("mbsc-color-preview-item-empty").css({
                        background: e ? n : "transparent"
                    }), e || i.addClass("mbsc-color-preview-item-empty").parent().removeClass("mbsc-color-active")
                }
                r && (e ? G._tempValue.splice(a, 0, n) : G._tempValue.splice(G._tempValue.indexOf(n), 1)), K && (e ? K.eq(t).addClass("mbsc-color-selected") : K.eq(t).removeClass("mbsc-color-selected").parent().removeClass("mbsc-color-active")), y[t].previewInd = e ? a : void 0, y[t].selected = e
            }

            function p(e, t) {
                void 0 !== e && (E || y[e].selected) ? (O = e, C = y[e].changedColor || y[e].color, U = K.eq(e), V && (m(K.eq(e), t || ""), k = l(y[e].color, "hsl"), k.l = l(C, "hsl").l, r(y[e].color), F.setVal(100 - k.l, !1, !1))) : V && r()
            }

            function b() {
                var e, t = [];
                for (e = 0; e < y.length; ++e) y[e].selected && t.push(y[e]);
                return t
            }

            function v(e, t) {
                var a = Le(e.target).index();
                O = ee[a].colorIndex, U = K.eq(O), Z = a, p(O, t), w.scroll(U, 250), _("onPreviewItemTap", {
                    target: e.target,
                    value: ee[a].color,
                    index: a
                })
            }

            function g(e, t) {
                var a = !1,
                    n = Le(".mbsc-color-selected", t);
                if (U = Le(e.target), U.hasClass("mbsc-color-clear-item")) return C = "", void G.clear();
                (E || Y > +n.length || U.hasClass("mbsc-color-selected"))  && (O = U.attr("data-index"), N && (Z = void 0 !== y[O].previewInd ? y[O].previewInd : d(), a = V && U.hasClass("mbsc-color-selected") && !U.parent().hasClass("mbsc-color-active"), B.length > 6 && M.scroll(B.eq(Z))), C = y[O].changedColor || y[O].color, E ? (n.removeClass("mbsc-color-selected"), G._tempValue = C, C && U.toggleClass("mbsc-color-selected"), m(U, t)) : (m(U, t), a || f(!y[O].selected, O, Z, C, !0, !0)), p(O, t), G.live && (G._fillValue(), _("onSet", {
                    value: G._value
                })), _("onItemTap", {
                    target: e.target,
                    value: C,
                    selected: y[O].selected,
                    index: O
                }))
            }
            var x, T, y, _, w, M, S, C, k, D, N, A, V, I, F, O, L, E, Y, R, J, K, B, U, q, G = this,
                X = Le(e),
                Z = 0,
                Q = {},
                ee = {};
            st.call(this, e, t, !0), G.setVal = G._setVal = function(e, t, a, s) {
                G._hasValue = null !== e && void 0 !== e, G._tempValue = E ? Le.isArray(e) ? e[0] : e : Le.isArray(e) ? e : [e], n(t, void 0 === a ? t : a, s)
            }, G.getVal = G._getVal = function(e) {
                return G._hasValue || e ? R ? b() : G[e ? "_tempValue" : "_value"] : null
            }, G._readValue = function() {
                var e = X.val() || "";
                G._hasValue = !1, 0 !== e.length && "" !== e && (G._hasValue = !0), G._hasValue ? (G._tempValue = E ? e : "hex" == x.format ? e.split(",") : e.match(/[a-z]{3}\((\d+\.?\d{0,}?),\s*([\d.]+)%{0,},\s*([\d.]+)%{0,}\)/gim), n(!0)) : G._tempValue = [], u(G._tempValue, G._hasValue)
            }, G._fillValue = function() {
                G._hasValue = !0, n(!0, !0)
            }, G._generateContent = function() {
                var e, t, a, n = S ? 1 : 0;
                for (I = D ? Math.ceil((y.length + n) / x.rows) : x.rows, t = '<div class="mbsc-color-scroll-cont mbsc-w-p ' + (D ? "" : "mbsc-color-vertical") + '"><div class="mbsc-color-cont">' + (D ? '<div class="mbsc-color-row">' : ""), e = 0; e < y.length; ++e) a = y[e].changedColor || y[e].color, S && 0 === e && (t += '<div class="mbsc-color-item-c"><div tabindex="0" class="mbsc-color-clear-item mbsc-btn-e mbsc-color-selected"><div class="mbsc-color-clear-cross"></div></div></div>'), 0 !== e && (e + n) % I == 0 && (t += D ? '</div><div class="mbsc-color-row">' : ""), t += '<div class="mbsc-color-item-c"><div tabindex="0" data-index="' + e + '" class="mbsc-color-item mbsc-btn-e mbsc-ic mbsc-ic-material-check mbsc-color-btn-e ' + (y[e].selected ? "mbsc-color-selected" : "") + '"  style="background:' + a + '"></div>' + "</div>";
                if (t += "</div></div>" + (D ? "</div>" : ""), V && (t += '<div class="mbsc-color-slider-cont"><input class="mbsc-color-slider" type="range" data-highlight="false" value="50" min="0" max="100"/></div>'), N) {
                    t += '<div class="mbsc-color-preview-cont"><div class="mbsc-color-refine-preview">';
                    for (var s in Q) t += '<div class="mbsc-color-preview-item-c mbsc-btn-e mbsc-color-btn-e" tabindex="0"><div class="mbsc-color-preview-item ' + (Q[s].color ? "" : "mbsc-color-preview-item-empty") + '" style="background: ' + (Q[s].color || "initial") + ';"></div></div>';
                    t += "</div></div>"
                }
                return t
            }, G._position = function(e) {
                var t, a;
                D || (t = e.find(".mbsc-color-cont"), a = Math.ceil(t.find(".mbsc-color-item-c")[0].offsetWidth), t.width(Math.min(Math.floor(e.find(".mbsc-fr-c").width() / a), Math.round(y.length / x.rows)) * a + 1)), w && w.refresh(), M && M.refresh()
            }, G._markupInserted = function(e) {
                D || e.find(".mbsc-color-scroll-cont").css("max-height", e.find(".mbsc-color-item-c")[0].offsetHeight * x.rows), w = new it(e.find(".mbsc-color-scroll-cont")[0], {
                    axis: D ? "X" : "Y",
                    rtl: x.rtl,
                    elastic: 60,
                    stopProp: !1,
                    mousewheel: x.mousewheel,
                    onBtnTap: function(t) {
                        g(t, e)
                    }
                })
            }, G._attachEvents = function(e) {
                var t;
                K = Le(".mbsc-color-item", e), e.on("keydown", ".mbsc-color-btn-e", function(t) {
                    t.stopPropagation(), 32 == t.keyCode && (t.target.classList.contains("mbsc-color-item") ? g(t, e) : v(t, e))
                }), N && (B = Le(".mbsc-color-preview-item", e)), V && (e.addClass("mbsc-color-refine"), q = Le(".mbsc-color-slider", e), F = new _t.Slider(q[0], {
                    theme: x.theme,
                    rtl: x.rtl
                }), A = e.find(".mbsc-progress-track"), O && G._value && p(O, e), q.on("change", function() {
                    void 0 !== O && (E || y[O].selected) && (k.l = 100 - this.value, t = l(k.toString()).toString(), E ? G._tempValue = t : G._tempValue[void 0 !== Z ? Z : G._tempValue.length] = t, y[O].tempChangedColor = t, K.eq(O).css("background", t), N && (ee[Z].color = t, B.eq(Z).removeClass("mbsc-color-preview-item-empty").css({
                        background: t
                    })), G.live && h(G._fillValue()))
                })), N && (M = new it(e.find(".mbsc-color-preview-cont")[0], {
                    axis: "X",
                    rtl: x.rtl,
                    mousewheel: x.mousewheel,
                    onBtnTap: function(t) {
                        v(t, e)
                    }
                }))
            }, G._detachEvents = function() {
                w && w.destroy(), F && F.destroy(), M && M.destroy()
            }, G.__processSettings = function() {
                var t, a;
                if (x = G.settings, _ = G.trigger, D = "horizontal" == x.navigation, G._value = [], G._tempValue = [], E = "single" == x.select, S = void 0 !== x.clear ? x.clear : E, a = x.data || [], !a.length) switch (x.format) {
                    case "rgb":
                        a = ["rgb(255,235,60)", "rgb(255,153,0)", "rgb(244,68,55)", "rgb(234,30,99)", "rgb(156,38,176)", "rgb(104,58,183)", "rgb(63,81,181)", "rgb(33,150,243)", "rgb(0,151,136)", "rgb(75,175,79)", "rgb(126,93,78)", "rgb(158,158,158)"], S && a.splice(10, 0, "rgb(83, 71, 65)");
                        break;
                    case "hsl":
                        a = ["hsl(54,100%,62%)", "hsl(36,100%,50%)", "hsl(4,90%,59%)", "hsl(340,83%,52%)", "hsl(291,64%,42%)", "hsl(262,52%,47%)", "hsl(231,48%,48%)", "hsl(207,90%,54%)", "hsl(174,100%,30%)", "hsl(122,40%,49%)", "hsl(19,24%,40%)", "hsl(0,0%,62%)"], S && a.splice(10, 0, "hsl(20, 12%, 29%)");
                        break;
                    default:
                        a = ["#ffeb3c", "#ff9900", "#f44437", "#ea1e63", "#9c26b0", "#683ab7", "#3f51b5", "#2196f3", "#009788", "#4baf4f", "#7e5d4e", "#9e9e9e"], S && a.splice(10, 0, "#534741")
                }
                if (V = "refine" == x.mode, N = !isNaN(x.select), Y = isNaN(x.select) ? E ? 2 : a.length : x.select, R = Le.isPlainObject(a[0]), N && !Object.keys(Q).length)
                    for (t = 0; t < x.select; ++t) Q[t] = {}, ee[t] = {};
                if (!y)
                    for (y = a.slice(0), t = 0; t < y.length; ++t) Le.isPlainObject(a[t]) ? y[t].color = a[t].color : (a[t] = a[t].toLowerCase(), y[t] = {
                        key: t,
                        name: a[t],
                        color: a[t]
                    });
                T = x.defaultValue || y[0].color, C = T, k = l(C, "hsl"), (L = x.enhance && X.is("input")) && (X.hasClass("mbsc-color-input-hdn") ? J = X.prev() : (J = Le("<div " + (e.placeholder ? 'data-placeholder="' + e.placeholder + '"' : "") + ' class="mbsc-control mbsc-color-input ' + (x.inputClass || "") + '" readonly ></div>'), J.insertBefore(X), X.addClass("mbsc-color-input-hdn").attr("tabindex", -1)), x.anchor = J, G.attachShow(J))
            }, G.__init = function() {
                x.cssClass = (x.cssClass || "") + " mbsc-color"
            }, G.__destroy = function() {
                L && (X.removeClass("mbsc-color-input-hdn"), J.remove())
            }, a || G.init(t)
        };
    wt.prototype = {
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _class: "color",
        _defaults: ze({}, _t.Frame.prototype._defaults, {
            headerText: !1,
            validate: o,
            parseValue: o,
            enhance: !0,
            rows: 2,
            select: "single",
            format: "hex",
            navigation: "horizontal"
        })
    }, ue.classes.Color = wt, ue.themes.color = ue.themes.frame, ue.presetShort("color", "Color", !1), yt.color = {
        hsv2hex: W,
        hsv2rgb: O,
        rgb2hsv: L,
        rgb2hex: H,
        rgb2hsl: E,
        hex2rgb: P,
        hex2hsv: $,
        hex2hsl: z
    }, ["date", "time", "datetime"].forEach(function(e) {
        ue.presetShort(e)
    });
    var Mt = {
        eventBubble: !0,
        labelsShort: ["Yrs", "Mths", "Days", "Hrs", "Mins", "Secs"],
        eventText: "event",
        eventsText: "events"
    };
    ue.presetShort("eventcalendar"), ue.presets.scroller.eventcalendar = function(e) {
        function t(e) {
            var t = v.labelsShort,
                a = Math.abs(e) / 1e3,
                n = a / 60,
                s = n / 60,
                r = s / 24,
                i = r / 365;
            return a < 45 && Math.round(a) + " " + t[5].toLowerCase() || n < 45 && Math.round(n) + " " + t[4].toLowerCase() || s < 24 && Math.round(s) + " " + t[3].toLowerCase() || r < 30 && Math.round(r) + " " + t[2].toLowerCase() || r < 365 && Math.round(r / 30) + " " + t[1].toLowerCase() || Math.round(i) + " " + t[0].toLowerCase()
        }

        function a(e) {
            return e.sort(function(e, t) {
                var a = e.d || e.start,
                    n = t.d || t.start;
                return (a.getTime ? e.start && e.end && e.start.toDateString() !== e.end.toDateString() ? 1 : a.getTime() : 0) - (n.getTime ? t.start && t.end && t.start.toDateString() !== t.end.toDateString() ? 1 : n.getTime() : 0)
            })
        }

        function n(e) {
            var t, a = Le(".mbsc-cal-c", c)[0].offsetHeight,
                n = Le(e),
                s = e.offsetHeight,
                r = e.offsetWidth,
                i = n.offset().top - Le(".mbsc-cal-c", c).offset().top,
                o = n.closest(".mbsc-cal-row").index() < 2;
            t = d.addClass("mbsc-cal-events-t").css({
                top: o ? i + s : "0",
                bottom: o ? "0" : a - i
            }).addClass("mbsc-cal-events-v").height(), d.css(o ? "bottom" : "top", "auto").removeClass("mbsc-cal-events-t"), h.css("max-height", t), u.refresh(), u.scroll(0), o ? d.addClass("mbsc-cal-events-b") : d.removeClass("mbsc-cal-events-b"), Le(".mbsc-cal-events-arr", d).css("left", n.offset().left - d.offset().left + r / 2)
        }

        function s(s, r, i) {
            if (s) {
                var o, l, c, h, b, g = '<ul class="mbsc-cal-event-list">';
                m = i, a(s), Le.each(s, function(e, a) {
                    h = a.d || a.start, b = a.start && a.end && a.start.toDateString() !== a.end.toDateString(), c = a.color, o = "", l = "", h.getTime && (o = w((b ? "MM d yy " : "") + v.timeFormat, h)), a.end && (l = w((b ? "MM d yy " : "") + v.timeFormat, a.end)), g += '<li role="button" aria-label="' + a.text + (o ? ", " + v.fromText + " " + o : "") + (l ? ", " + v.toText + " " + l : "") + '" class="mbsc-cal-event"><div class="mbsc-cal-event-color" style="' + (c ? "background:" + c + ";" : "") + '"></div><div class="mbsc-cal-event-text">' + (h.getTime && !b ? '<div class="mbsc-cal-event-time">' + w(v.timeFormat, h) + "</div>" : "") + a.text + "</div>" + (a.start && a.end ? '<div class="mbsc-cal-event-dur">' + t(a.end - a.start) + "</div>" : "") + "</li>"
                }), g += "</ul>", f.html(g), e.trigger("onEventBubbleShow", {
                    target: m,
                    eventList: d[0]
                }), n(m), e.tap(Le(".mbsc-cal-event", f), function(t) {
                    u.scrolled || e.trigger("onEventSelect", {
                        domEvent: t,
                        event: s[Le(this).index()],
                        date: r
                    })
                }), p = !0
            }
        }

        function r() {
            d && d.removeClass("mbsc-cal-events-v"), m = null, p = !1
        }

        function i() {
            r(), e.redraw()
        }

        function o(e) {
            return _(e.getFullYear(), e.getMonth(), e.getDate())
        }
        var l, c, d, m, u, h, f, p, b = ze({}, e.settings),
            v = ze(e.settings, Mt, b),
            g = (v.selectedClass, 0),
            x = ze(!0, [], v.data);
        return Le.each(x, function(e, t) {
            void 0 === t._id && (t._id = g++)
        }), e._events = x, l = ft.call(this, e), e._onSelectShow = function() {
            r()
        }, e.addEvent = function(e) {
            var t = [];
            return e = ze(!0, [], Le.isArray(e) ? e : [e]), Le.each(e, function(e, a) {
                void 0 === a._id && (a._id = g++), x.push(a), t.push(a._id)
            }), i(), t
        }, e.removeEvent = function(e) {
            e = Le.isArray(e) ? e : [e], Le.each(e, function(e, t) {
                Le.each(x, function(e, a) {
                    if (a._id === t) return x.splice(e, 1), !1
                })
            }), i()
        }, e.getEvents = function(t) {
            var n;
            return t ? (t.setHours(0, 0, 0, 0), n = e._prepareObj(x, t.getFullYear(), t.getMonth()), n[t] ? a(n[t]) : []) : ze(!0, [], x)
        }, e.setEvents = function(t) {
            var a = [];
            return e._events = x = ze(!0, [], t), Le.each(x, function(e, t) {
                void 0 === t._id && (t._id = g++), a.push(t._id)
            }), i(), a
        }, ze({}, l, {
            outerMonthChange: !1,
            headerText: !1,
            buttons: "inline" !== v.display ? ["close"] : v.buttons,
            onMarkupReady: function(t) {
                l.onMarkupReady.call(this, t), c = Le(t.target), d = Le('<div class="mbsc-cal-events ' + (v.eventBubbleClass || "") + '"><div class="mbsc-cal-events-arr"></div><div class="mbsc-cal-events-i"><div class="mbsc-cal-events-sc"></div></div></div>').appendTo(Le(".mbsc-cal-c", c)), h = Le(".mbsc-cal-events-i", d), f = Le(".mbsc-cal-events-sc", d), u = new it(h[0]), p = !1, e.tap(h, function() {
                    u.scrolled || r()
                })
            },
            onMonthChange: function() {
                r()
            },
            onDayChange: function(e) {
                var t = o(e.date),
                    a = e.target,
                    n = v.eventBubble && m !== a;
                r(), n && s(e.marked, t, a)
            },
            onPosition: function(e) {
                l.onPosition.call(this, e), p && n(m)
            },
            onHide: function() {
                l.onHide.call(this), u && u.destroy()
            }
        })
    };
    var St = ue.classes,
        Ct = function(e, t) {
            var a = "",
                n = Le(e),
                s = this,
                r = s.settings;
            je.call(this, e, t, !0), s._init = function() {
                var e = r.context,
                    t = Le(e),
                    s = t.find(".mbsc-ms-top .mbsc-ms"),
                    i = t.find(".mbsc-ms-bottom .mbsc-ms"),
                    o = {};
                "body" == e ? Le("body,html").addClass("mbsc-page-ctx") : t.addClass("mbsc-page-ctx"), a && n.removeClass(a), s.length && (o.paddingTop = s[0].offsetHeight), i.length && (o.paddingBottom = i[0].offsetHeight), a = "mbsc-page mbsc-" + r.theme + (r.baseTheme ? " mbsc-" + r.baseTheme : "") + (r.rtl ? " mbsc-rtl" : " mbsc-ltr"), n.addClass(a).css(o)
            }, s._destroy = function() {
                n.removeClass(a)
            }, r = s.settings, s.init(t)
        };
    Ct.prototype = {
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _class: "page",
        _defaults: {
            context: "body"
        }
    }, St.Page = Ct, ue.themes.page.mobiscroll = {}, ue.presetShort("page", "Page"), Ae && Le(function() {
        Le("[mbsc-page]").each(function() {
            new St.Page(this)
        }), Le(document).on("mbsc-enhance", function(e, t) {
            Le(e.target).is("[mbsc-page]") ? new St.Page(e.target, t) : Le("[mbsc-page]", e.target).each(function() {
                new St.Page(this, t)
            })
        })
    });
    var kt = function(e, t, a) {
        function n(e) {
            !Le(".mbsc-fr-c", e).hasClass("mbsc-wdg-c")  && (Le(".mbsc-fr-c", e).addClass("mbsc-wdg-c").append(o.show()), Le(".mbsc-w-p", e).length || Le(".mbsc-fr-c", e).addClass("mbsc-w-p"))
        }
        var s, r, i, o = Le(e),
            l = this;
        st.call(this, e, t, !0), l._generateContent = function() {
            return ""
        }, l._markupReady = function(e) {
            "inline" != s.display && n(e)
        }, l._markupInserted = function(e) {
            "inline" == s.display && n(e), e.trigger("mbsc-enhance", [{
                theme: s.theme,
                lang: s.lang
            }])
        }, l._markupRemove = function() {
            o.hide(), r ? r.prepend(o) : i.after(o)
        }, l.__processSettings = function() {
            s = l.settings, l.buttons.ok = {
                text: s.okText,
                icon: s.okIcon,
                handler: "set"
            }, s.buttons = s.buttons || ("inline" == s.display ? [] : ["ok"]), r || i || (i = o.prev(), i.length || (r = o.parent())), o.hide()
        }, l.__init = function() {
            s.cssClass = (s.cssClass || "") + " mbsc-wdg"
        }, a || l.init(t)
    };
    kt.prototype = {
        _hasDef: !0,
        _hasTheme: !0,
        _hasContent: !0,
        _hasLang: !0,
        _class: "widget",
        _defaults: ze({}, st.prototype._defaults, {
            okText: "OK",
            headerText: !1
        })
    }, ue.classes.Widget = kt, ue.themes.widget = ue.themes.frame, ue.presetShort("widget", "Widget", !1);
    var Dt = Ae && !!window.Promise,
        Nt = [],
        At = [];
    ue.alert = function(e) {
        var t = document.createElement("div");
        return t.innerHTML = B(e), Q(U, t, e)
    }, ue.confirm = function(e) {
        var t = document.createElement("div");
        return t.innerHTML = B(e), Q(q, t, e)
    }, ue.prompt = function(e) {
        var t = document.createElement("div");
        return t.innerHTML = B(e) + '<label class="mbsc-input">' + (e.label ? '<span class="mbsc-label">' + e.label + "</span>" : "") + '<input tabindex="0" type="' + (e.inputType || "text") + '" placeholder="' + (e.placeholder || "") + '" value="' + (e.value || "") + '"></label>', Q(G, t, e)
    }, ue.snackbar = function(e) {
        var t = document.createElement("div");
        return t.innerHTML = '<div class="mbsc-snackbar-cont"><div class="mbsc-snackbar-msg">' + (e.message || "") + "</div>" + (e.button ? '<button class="mbsc-snackbar-btn mbsc-btn mbsc-btn-flat">' + (e.button.text || "") + "</button>" : "") + "</div>", Q(X, t, e)
    }, ue.toast = function(e) {
        var t = document.createElement("div");
        return t.innerHTML = '<div class="mbsc-toast-msg">' + (e.message || "") + "</div>", Q(Z, t, e)
    };
    var Vt = ["touchstart", "touchmove", "touchend", "touchcancel", "mousedown", "mousemove", "mouseup", "mouseleave"],
        It = {
            tap: !0
        },
        Ft = void 0,
        Ht = function() {
            function e(t, a) {
                var n = this;
                fe(this, e);
                var s = ze({}, It, ue.settings, a),
                    r = Le(t),
                    i = r.parent(),
                    o = i.hasClass("mbsc-input-wrap") ? i.parent() : i,
                    l = r.next().hasClass("mbsc-fr") ? r.next() : null,
                    c = ee(r);
                l && l.insertAfter(o), F(o, c), r.addClass("mbsc-control"), Vt.forEach(function(e) {
                    t.addEventListener(e, n)
                }), this.settings = s, this._type = c, this._elm = t, this._$elm = r, this._$parent = o, this._$frame = l, this._ripple = te(s.theme)
            }
            return pe(e, [{
                key: "destroy",
                value: function() {
                    var e = this;
                    this._$elm.removeClass("mbsc-control"), Vt.forEach(function(t) {
                        e._elm.removeEventListener(t, e)
                    })
                }
            }, {
                key: "option",
                value: function(e) {
                    ze(this.settings, e), this._ripple = te(this.settings.theme)
                }
            }, {
                key: "handleEvent",
                value: function(e) {
                    switch (e.type) {
                        case "touchstart":
                        case "mousedown":
                            this._onStart(e);
                            break;
                        case "touchmove":
                        case "mousemove":
                            this._onMove(e);
                            break;
                        case "touchend":
                        case "touchcancel":
                        case "mouseup":
                        case "mouseleave":
                            this._onEnd(e)
                    }
                }
            }, {
                key: "_addRipple",
                value: function(e) {
                    this._ripple && this._$rippleElm && this._ripple.addRipple(this._$rippleElm, e)
                }
            }, {
                key: "_removeRipple",
                value: function() {
                    this._ripple && this._$rippleElm && this._ripple.removeRipple()
                }
            }, {
                key: "_onStart",
                value: function(e) {
                    var t = this._elm;
                    C(e, t) && (this._startX = v(e, "X"), this._startY = v(e, "Y"), Ft && Ft.removeClass("mbsc-active"), t.disabled || (this._isActive = !0, Ft = this._$elm, Ft.addClass("mbsc-active"), this._addRipple(e)))
                }
            }, {
                key: "_onMove",
                value: function(e) {
                    (this._isActive && Math.abs(v(e, "X") - this._startX) > 9 || Math.abs(v(e, "Y") - this._startY) > 9) && (this._$elm.removeClass("mbsc-active"), this._removeRipple(), this._isActive = !1)
                }
            }, {
                key: "_onEnd",
                value: function(e) {
                    var t = this,
                        a = this._elm,
                        n = this._type;
                    this._isActive && this.settings.tap && "touchend" == e.type && !a.readOnly && (a.focus(), /(button|submit|checkbox|switch|radio)/.test(n) && e.preventDefault(), /select/.test(n) || b(e, a)), this._isActive && setTimeout(function() {
                        t._$elm.removeClass("mbsc-active"), t._removeRipple()
                    }, 100), this._isActive = !1, Ft = null
                }
            }]), e
        }(),
        Pt = function(e) {
            function t(e, a) {
                fe(this, t);
                var n = ge(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e, a));
                return I(n, n._$parent, n._$elm), n._$parent.addClass("mbsc-input"), n
            }
            return ve(t, e), pe(t, [{
                key: "destroy",
                value: function() {
                    be(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "destroy", this).call(this), this._$parent.removeClass("mbsc-ic-left mbsc-ic-right").find(".mbsc-input-ic").remove()
                }
            }]), t
        }(Ht),
        Ot = function(e) {
            function t(e, a) {
                fe(this, t);
                var n = ge(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e, a)),
                    s = n._$elm,
                    r = s.attr("data-icon");
                return s.addClass("mbsc-btn").find(".mbsc-btn-ic").remove(), r && (s.prepend('<span class="mbsc-btn-ic mbsc-ic mbsc-ic-' + r + '"></span>'), "" === s.text() && s.addClass("mbsc-btn-icon-only")), n._$rippleElm = s, n
            }
            return ve(t, e), t
        }(Ht),
        Lt = function(e) {
            function t(e, a) {
                fe(this, t);
                var n = ge(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e, a));
                return n._$parent.prepend(n._$elm).addClass("mbsc-checkbox mbsc-control-w").find(".mbsc-checkbox-box").remove(), n._$elm.after('<span class="mbsc-checkbox-box"></span>'), n
            }
            return ve(t, e), t
        }(Ht),
        Et = function(e) {
            function t(e, a) {
                fe(this, t);
                var n = ge(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e, a));
                return n._$parent.addClass("mbsc-radio mbsc-control-w").find(".mbsc-radio-box").remove(), n._$elm.after('<span class="mbsc-radio-box"><span></span></span>'), n
            }
            return ve(t, e), t
        }(Ht),
        Yt = function(e) {
            function t(e, a) {
                fe(this, t);
                var n = ge(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e, a)),
                    s = n._$elm,
                    r = n._$parent,
                    i = r.find("input.mbsc-control"),
                    o = i.length ? i : Le('<input tabindex="-1" class="mbsc-control" readonly>');
                return n._$input = o, r.addClass("mbsc-select" + (n._$frame ? " mbsc-select-inline" : "")), s.after(o), o.after('<span class="mbsc-select-ic mbsc-ic mbsc-ic-arrow-down5"></span>'), s.hasClass("mbsc-comp") || (e.addEventListener("change", n), n._setText()), n
            }
            return ve(t, e), pe(t, [{
                key: "destroy",
                value: function() {
                    be(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "destroy", this).call(this), this._$elm.after(this._$input), this._elm.removeEventListener("change", this)
                }
            }, {
                key: "handleEvent",
                value: function(e) {
                    be(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "handleEvent", this).call(this, e), "change" == e.type && this._setText()
                }
            }, {
                key: "_setText",
                value: function() {
                    var e = this._elm;
                    this._$elm.hasClass("mbsc-comp") || this._$input.val(-1 != e.selectedIndex ? e.options[e.selectedIndex].text : "")
                }
            }]), t
        }(Pt),
        zt = ["keydown", "input", "scroll"],
        jt = void 0;
    Ae && Le(window).on("resize orientationchange", ae);
    var Wt = function(e) {
            function t(e, a) {
                fe(this, t);
                var n = ge(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e, a));
                return n._$parent.addClass("mbsc-textarea"), zt.forEach(function(e) {
                    n._elm.addEventListener(e, n)
                }), ne(e), n
            }
            return ve(t, e), pe(t, [{
                key: "destroy",
                value: function() {
                    var e = this;
                    be(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "destroy", this).call(this), zt.forEach(function(t) {
                        e._elm.removeEventListener(t, e)
                    })
                }
            }, {
                key: "handleEvent",
                value: function(e) {
                    switch (be(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "handleEvent", this).call(this, e), e.type) {
                        case "keydown":
                        case "input":
                            this._onInput(e);
                            break;
                        case "scroll":
                            se(this._elm)
                    }
                }
            }, {
                key: "_onInput",
                value: function() {
                    var e = this;
                    clearTimeout(this._debounce), this._debounce = setTimeout(function() {
                        ne(e._elm)
                    }, 100)
                }
            }]), t
        }(Pt),
        $t = function(e) {
            function t(e, a) {
                fe(this, t);
                var n = ge(this, (t.__proto__ || Object.getPrototypeOf(t)).call(this, e, a)),
                    s = void 0,
                    r = void 0,
                    i = n._$elm,
                    o = n._$parent;
                return o.hasClass("mbsc-segmented-item-ready") || (s = Le('<div class="mbsc-segmented"></div>'), o.after(s), o.parent().find('input[name="' + i.attr("name") + '"]').each(function() {
                    var e = Le(this);
                    r = e.parent().addClass("mbsc-segmented-item mbsc-segmented-item-ready"), Le('<span class="mbsc-segmented-content">' + (e.attr("data-icon") ? '<span class="mbsc-ic mbsc-ic-' + e.attr("data-icon") + '"></span>' : "") + "</span>").append(r.contents()).appendTo(r), r.prepend(e), s.append(r)
                })), n._$rippleElm = i.next(), n
            }
            return ve(t, e), t
        }(Ht),
        Rt = function(e, t) {
            function a(t) {
                32 == t.keyCode && (t.preventDefault(), b || e.disabled || (u = Le(this).addClass("mbsc-active"), c(t)))
            }

            function n(e) {
                b && (e.preventDefault(), d(!0))
            }

            function s(t) {
                C(t, this) && !e.disabled && (u = Le(this).addClass("mbsc-active").trigger("focus"), D && !u.hasClass("mbsc-step-disabled") && D.addRipple(u.find(".mbsc-segmented-content"), t), c(t), "mousedown" === t.type && Le(document).on("mousemove", i).on("mouseup", r))
            }

            function r(e) {
                b && (e.preventDefault(), d(!0), "mouseup" === e.type && Le(document).off("mousemove", i).off("mouseup", r))
            }

            function i(e) {
                b && (_ = v(e, "X"), w = v(e, "Y"), x = _ - V, T = w - I, (Math.abs(x) > 7 || Math.abs(T) > 7) && d())
            }

            function o() {
                var t;
                e.disabled || (t = parseFloat(Le(this).val()), l(isNaN(t) ? H : t))
            }

            function l(e, t, a) {
                Y = H, void 0 === t && (t = !0), void 0 === a && (a = t), H = void 0 !== e ? Math.min(S, Math.max(Math.round(e / N) * N, k)) : Math.min(S, Math.max(H + (u.hasClass("mbsc-stepper-minus") ? -N : N), k)), g = !0, p.removeClass("mbsc-step-disabled"), t && E.val(H), H == k ? f.addClass("mbsc-step-disabled") : H == S && h.addClass("mbsc-step-disabled"), H !== Y && a && E.trigger("change")
            }

            function c(e) {
                b || (b = !0, g = !1, V = v(e, "X"), I = v(e, "Y"), clearInterval(M), clearTimeout(M), M = setTimeout(function() {
                    l(), M = setInterval(function() {
                        l()
                    }, 150)
                }, 300))
            }

            function d(e) {
                clearInterval(M), clearTimeout(M), !g && e && l(), b = !1, g = !1, u.removeClass("mbsc-active"), D && setTimeout(function() {
                    D.removeRipple()
                }, 100)
            }

            function m(e, t) {
                var a = E.attr(e);
                return void 0 === a || "" === a ? t : +a
            }
            var u, h, f, p, b, g, x, T, y, _, w, M, S, k, D, N, A, V, I, F, H, P, O, L = this,
                E = Le(e),
                Y = H;
            je.call(this, e, t, !0), L.getVal = function() {
                var e = parseFloat(E.val());
                return e = isNaN(e) ? H : e, Math.min(S, Math.max(Math.round(e / N) * N, k))
            }, L.setVal = function(e, t, a) {
                e = parseFloat(e), l(isNaN(e) ? H : e, t, a)
            }, L._init = function(t) {
                P = E.parent().hasClass("mbsc-stepper"), O = P ? E.closest(".mbsc-stepper-cont") : E.parent(), A = L.settings, k = void 0 === t.min ? m("min", A.min) : t.min, S = void 0 === t.max ? m("max", A.max) : t.max, N = void 0 === t.step ? m("step", A.step) : t.step, y = E.attr("data-val") || A.val, H = Math.min(S, Math.max(Math.round(+e.value / N) * N || 0, k)), F = ue.themes.form[A.theme], D = F && F.addRipple ? F : null, P || O.addClass("mbsc-stepper-cont mbsc-control-w").append('<span class="mbsc-segmented mbsc-stepper"></span>').find(".mbsc-stepper").append('<span class="mbsc-segmented-item mbsc-stepper-control mbsc-stepper-minus ' + (H == k ? "mbsc-step-disabled" : "") + '"  tabindex="0"><span class="mbsc-segmented-content"><span class="mbsc-ic mbsc-ic-minus"></span></span></span>').append('<span class="mbsc-segmented-item mbsc-stepper-control mbsc-stepper-plus ' + (H == S ? "mbsc-step-disabled" : "") + '"  tabindex="0"><span class="mbsc-segmented-content"> <span class="mbsc-ic mbsc-ic-plus"></span> </span></span>').prepend(E), f = Le(".mbsc-stepper-minus", O), h = Le(".mbsc-stepper-plus", O), P || ("left" == y ? (O.addClass("mbsc-stepper-val-left"), E.after('<span class="mbsc-segmented-item"><span class="mbsc-segmented-content"></span></span>')) : "right" == y ? (O.addClass("mbsc-stepper-val-right"), h.after('<span class="mbsc-segmented-item"><span class="mbsc-segmented-content"></span></span>')) : f.after('<span class="mbsc-segmented-item"><span class="mbsc-segmented-content mbsc-stepper-val"></span></span>')), E.val(H).attr("data-role", "stepper").attr("min", k).attr("max", S).attr("step", N).on("change", o), p = Le(".mbsc-stepper-control", O).on("keydown", a).on("keyup", n).on("mousedown touchstart", s).on("touchmove", i).on("touchend touchcancel", r), E.addClass("mbsc-stepper-ready mbsc-control")
            }, L._destroy = function() {
                E.removeClass("mbsc-control").off("change", o), p.off("keydown", a).off("keyup", n).off("mousedown touchstart", s).off("touchmove", i).off("touchend touchcancel", r)
            }, L.init(t)
        };
    Rt.prototype = {
        _class: "stepper",
        _hasDef: !0,
        _defaults: {
            min: 0,
            max: 100,
            step: 1
        }
    }, ue.classes.Stepper = Rt, ue.presetShort("stepper", "Stepper");
    var Jt = function(e, t) {
        var a, n, s, r, i = this;
        t = t || {}, ze(t, {
            changeEvent: "click",
            round: !1
        }), xt.call(this, e, t, !0), i._readValue = function() {
            return e.checked ? 1 : 0
        }, i._fillValue = function(e, t, n) {
            a.prop("checked", !!e), n && a.trigger("change")
        }, i._onTap = function(e) {
            i._setVal(e ? 0 : 1)
        }, i.___init = function() {
            s = i.settings, a = Le(e), n = a.parent(), n.find(".mbsc-switch-track").remove(), n.prepend(a), a.attr("data-role", "switch").after('<span class="mbsc-progress-cont mbsc-switch-track"><span class="mbsc-progress-track mbsc-progress-anim"><span class="mbsc-slider-handle-cont"><span class="mbsc-slider-handle mbsc-switch-handle" data-index="0"><span class="mbsc-switch-txt-off">' + s.offText + '</span><span class="mbsc-switch-txt-on">' + s.onText + "</span></span></span></span></span>"), r && r.destroy(), r = new Ht(e, s), i._$track = n.find(".mbsc-progress-track"), i._min = 0, i._max = 1, i._step = 1
        }, i.___destroy = function() {
            r.destroy()
        }, i.getVal = function() {
            return e.checked
        }, i.setVal = function(e, t, a) {
            i._setVal(e ? 1 : 0, t, a)
        }, i.init(t)
    };
    Jt.prototype = {
        _class: "switch",
        _css: "mbsc-switch",
        _hasTheme: !0,
        _hasLang: !0,
        _hasDef: !0,
        _defaults: {
            stopProp: !0,
            offText: "Off",
            onText: "On"
        }
    }, ue.classes.Switch = Jt, ue.presetShort("switch", "Switch");
    var Kt = 0,
        Bt = "ios" == Se && ke > 7,
        Ut = ue.instances,
        qt = function(e, t) {
            function a() {
                r.removeClass("mbsc-no-touch")
            }
            var n, s = "",
                r = Le(e),
                i = {},
                o = this;
            je.call(this, e, t, !0), o.refresh = function(e) {
                Le("input,select,textarea,progress,button", r).each(function() {
                    var e, t = this,
                        a = Le(t),
                        s = ee(a);
                    if ("false" != a.attr("data-enhance") )
                        if (a.hasClass("mbsc-control"))(e = Ut[t.id] || i[t.id]) && e.option && e.option({
                            theme: n.theme,
                            lang: n.lang,
                            rtl: n.rtl,
                            onText: n.onText,
                            offText: n.offText,
                            stopProp: n.stopProp
                        });
                        else switch (t.id || (t.id = "mbsc-form-control-" + ++Kt), s) {
                            case "button":
                            case "submit":
                                i[t.id] = new Ot(t, {
                                    theme: n.theme,
                                    tap: n.tap
                                });
                                break;
                            case "switch":
                                i[t.id] = new Jt(t, {
                                    theme: n.theme,
                                    lang: n.lang,
                                    rtl: n.rtl,
                                    tap: n.tap,
                                    onText: n.onText,
                                    offText: n.offText,
                                    stopProp: n.stopProp
                                });
                                break;
                            case "checkbox":
                                i[t.id] = new Lt(t, {
                                    tap: n.tap
                                });
                                break;
                            case "range":
                                Le(t).parent().hasClass("mbsc-slider") || (i[t.id] = new Tt(t, {
                                    theme: n.theme,
                                    lang: n.lang,
                                    rtl: n.rtl,
                                    stopProp: n.stopProp
                                }));
                                break;
                            case "progress":
                                i[t.id] = new gt(t, {
                                    theme: n.theme,
                                    lang: n.lang,
                                    rtl: n.rtl
                                });
                                break;
                            case "radio":
                                i[t.id] = new Et(t, {
                                    tap: n.tap
                                });
                                break;
                            case "select":
                            case "select-one":
                            case "select-multiple":
                                i[t.id] = new Yt(t, {
                                    tap: n.tap
                                });
                                break;
                            case "textarea":
                                i[t.id] = new Wt(t, {
                                    tap: n.tap
                                });
                                break;
                            case "segmented":
                                i[t.id] = new $t(t, {
                                    theme: n.theme,
                                    tap: n.tap
                                });
                                break;
                            case "stepper":
                                i[t.id] = new Rt(t, {
                                    theme: n.theme
                                });
                                break;
                            case "hidden":
                                return;
                            default:
                                i[t.id] = new Pt(t, {
                                    tap: n.tap
                                })
                        }
                }), e || ae()
            }, o._init = function() {
                ue.themes.form[n.theme] || (n.theme = "mobiscroll"), r.hasClass("mbsc-form") || r.on("touchstart", a).show(), s && r.removeClass(s), s = "mbsc-form mbsc-no-touch mbsc-" + n.theme + (Bt ? " mbsc-form-hb" : "") + (n.baseTheme ? " mbsc-" + n.baseTheme : "") + (n.rtl ? " mbsc-rtl" : " mbsc-ltr"), r.addClass(s), o.refresh()
            }, o._destroy = function() {
                r.removeClass(s).off("touchstart", a);
                for (var e in i) i[e].destroy()
            }, n = o.settings, o.init(t)
        };
    qt.prototype = {
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _class: "form",
        _defaults: {
            tap: !0,
            stopProp: !0,
            lang: "en"
        }
    }, ue.themes.form.mobiscroll = {}, ue.classes.Form = qt, ue.presetShort("form", "Form"), Ae && Le(function() {
        var e = "[mbsc-enhance],[mbsc-form]";
        Le(e).each(function() {
            new qt(this)
        }), Le(document).on("mbsc-enhance", function(t, a) {
            Le(t.target).is(e) ? new qt(t.target, a) : Le(e, t.target).each(function() {
                new qt(this, a)
            })
        }), Le(document).on("mbsc-refresh", function(t) {
            var a;
            Le(t.target).is(e) ? (a = Ut[t.target.id]) && a.refresh() : Le(e, t.target).each(function() {
                (a = Ut[this.id]) && a.refresh()
            })
        })
    });
    var Gt = {
        invalid: [],
        showInput: !0,
        inputClass: "",
        itemSelector: "li"
    };
    ue.presets.scroller.list = function(e) {
        function t(e, t, n) {
            for (var s = 0, r = []; s < e;) r[s] = a(n, s, t), s++;
            return r
        }

        function a(e, t, a) {
            for (var n, s = 0, r = a, i = []; s < t;) {
                var o = e[s];
                for (n in r)
                    if (r[n].key == o) {
                        r = r[n].children;
                        break
                    }
                s++
            }
            for (s = 0; s < r.length;) r[s].invalid && i.push(r[s].key), s++;
            return i
        }

        function n(e, t) {
            for (var a = []; e;) a[--e] = !0;
            return a[t] = !1, a
        }

        function s(e, t, a) {
            var n, s, o, l = 0,
                c = [
                    []
                ],
                d = M;
            if (t)
                for (n = 0; n < t; n++) v ? c[0][n] = {} : c[n] = [{}];
            for (; l < e.length;) {
                for (v ? c[0][l] = i(d, S[l]) : c[l] = [i(d, S[l])], n = 0, o = void 0; n < d.length && void 0 === o;) d[n].key == e[l] && (void 0 !== a && l <= a || void 0 === a) && (o = n), n++;
                if (void 0 !== o && d[o].children) l++, d = d[o].children;
                else {
                    if (!(s = r(d)) || !s.children) return c;
                    l++, d = s.children
                }
            }
            return c
        }

        function r(e, t) {
            if (!e) return !1;
            for (var a, n = 0; n < e.length;)
                if (!(a = e[n++]).invalid) return t ? n - 1 : a;
            return !1
        }

        function i(e, t) {
            for (var a = {
                    data: [],
                    label: t
                }, n = 0; n < e.length;) a.data.push({
                value: e[n].key,
                display: e[n].value
            }), n++;
            return a
        }

        function o(t) {
            e._isVisible && Le(".mbsc-sc-whl-w", e._markup).css("display", "").slice(t).hide()
        }

        function l(e, t) {
            var a, n, s, i = [],
                o = M,
                l = 0,
                c = !1;
            if (void 0 !== e[l] && l <= t)
                for (a = 0, n = e[l], s = void 0; a < o.length && void 0 === s;) o[a].key != e[l] || o[a].invalid || (s = a), a++;
            else s = r(o, !0), n = o[s].key;
            for (c = void 0 !== s && o[s].children, i[l] = n; c;) {
                if (o = o[s].children, l++, c = !1, s = void 0, void 0 !== e[l] && l <= t)
                    for (a = 0, n = e[l], s = void 0; a < o.length && void 0 === s;) o[a].key != e[l] || o[a].invalid || (s = a), a++;
                else s = r(o, !0), s = !1 === s ? void 0 : s, n = o[s].key;
                c = !(void 0 === s || !r(o[s].children)) && o[s].children, i[l] = n
            }
            return {
                lvl: l + 1,
                nVector: i
            }
        }

        function c(t) {
            var a = [];
            return y = y > _++ ? y : _, (t.length > 1 ? t : t.children(p.itemSelector)).each(function(t) {
                var n = Le(this),
                    s = n.clone();
                s.children("ul,ol").remove(), s.children(p.itemSelector).remove();
                var r = e._processMarkup ? e._processMarkup(s) : s.html().replace(/^\s\s*/, "").replace(/\s\s*$/, ""),
                    i = !!n.attr("data-invalid"),
                    o = {
                        key: void 0 === n.attr("data-val") || null === n.attr("data-val") ? t : n.attr("data-val"),
                        value: r,
                        invalid: i,
                        children: null
                    },
                    l = "li" === p.itemSelector ? n.children("ul,ol") : n.children(p.itemSelector);
                l.length && (o.children = c(l)), a.push(o)
            }), _--, a
        }

        function d(t, a, n) {
            var r, i = (a || 0) + 1,
                l = [],
                c = {},
                d = {};
            for (c = s(t, null, a), r = 0; r < t.length; r++) e._tempWheelArray[r] = t[r] = n.nVector[r] || 0;
            for (; i < n.lvl;) d[i] = v ? c[0][i] : c[i][0], l.push(i++);
            o(n.lvl), w = t.slice(0), l.length && (u = !0, e.changeWheel(d))
        }
        var m, u, h, f = ze({}, e.settings),
            p = ze(e.settings, Gt, f),
            b = p.layout || (/top|bottom/.test(p.display) ? "liquid" : ""),
            v = "liquid" == b,
            g = p.readonly,
            x = Le(this),
            T = this.id + "_dummy",
            y = 0,
            _ = 0,
            w = [],
            M = p.wheelArray || c(x),
            S = function(e) {
                var t, a = [];
                for (t = 0; t < e; t++) a[t] = p.labels && p.labels[t] ? p.labels[t] : t;
                return a
            }(y),
            C = function(e) {
                for (var t, a = [], n = e, s = !0, i = 0; s;) t = r(n), a[i++] = t.key, (s = t.children) && (n = s);
                return a
            }(M),
            k = s(C, y);
        return Le("#" + T).remove(), p.input ? m = Le(p.input) : p.showInput && (m = Le('<input type="text" id="' + T + '" value="" class="' + p.inputClass + '" placeholder="' + (p.placeholder || "") + '" readonly />').insertBefore(x)), m && e.attachShow(m), p.wheelArray || x.hide(), {
            wheels: k,
            anchor: m,
            layout: b,
            headerText: !1,
            setOnTap: 1 == y,
            formatValue: function(e) {
                return void 0 === h && (h = l(e, e.length).lvl), e.slice(0, h).join(" ")
            },
            parseValue: function(e) {
                return e ? (e + "").split(" ") : (p.defaultValue || C).slice(0)
            },
            onBeforeShow: function() {
                var t = e.getArrayVal(!0);
                w = t.slice(0), p.wheels = s(t, y, y), u = !0
            },
            onWheelGestureStart: function(e) {
                p.readonly = n(y, e.index)
            },
            onWheelAnimationEnd: function(t) {
                var a = t.index,
                    n = e.getArrayVal(!0),
                    s = l(n, a);
                h = s.lvl, p.readonly = g, n[a] != w[a] && d(n, a, s)
            },
            onFill: function(e) {
                h = void 0, m && m.val(e.valueText)
            },
            validate: function(e) {
                var a = e.values,
                    n = e.index,
                    s = l(a, a.length);
                return h = s.lvl, void 0 === n && (o(s.lvl), u || d(a, n, s)), u = !1, {
                    disabled: t(h, M, a)
                }
            },
            onDestroy: function() {
                m && Le("#" + T).remove(), x.show()
            }
        }
    };
    var Xt = ue.presets.scroller;
    ue.presetShort("image"), Xt.image = function(e) {
        return e.settings.enhance && (e._processMarkup = function(e) {
            var t = e.attr("data-icon");
            return e.children().each(function(e, t) {
                t = Le(t), t.is("img") ? Le('<div class="mbsc-img-c"></div>').insertAfter(t).append(t.addClass("mbsc-img")) : t.is("p") && t.addClass("mbsc-img-txt")
            }), t && e.prepend('<div class="mbsc-ic mbsc-ic-' + t + '"></div'), e.html('<div class="mbsc-img-w">' + e.html() + "</div>"), e.html()
        }), Xt.list.call(this, e)
    };
    var Zt, Qt = ue.classes,
        ea = 1,
        ta = "transparent",
        aa = function(e, t) {
            function a() {
                Mt = !1, bt = !1, ee = 0, Ft = 0, Ht = new Date, Qe = ie.width(), ce = E(ie), at = ce.index(et), tt = et[0].offsetHeight, ia = et[0].offsetTop, Rt = Jt[et.attr("data-type") || "defaults"], It = Rt.stages
            }

            function n(e) {
                var t;
                "touchstart" === e.type && (vt = !0, clearTimeout(gt)), !C(e, this) || X || sa || Zt || da || (X = !0, te = !0, Pt = v(e, "X"), Ot = v(e, "Y"), ve = 0, ge = 0, et = Le(this), t = et, a(), jt = kt.onItemTap || Rt.tap || et.hasClass("mbsc-lv-parent") || et.hasClass("mbsc-lv-back"), rt = et.offset().top, jt && (Q = setTimeout(function() {
                    t.addClass("mbsc-lv-item-active"), Ce("onItemActivate", {
                        target: t[0],
                        domEvent: e
                    })
                }, 120)), Qt.sortable && !et.hasClass("mbsc-lv-back") && (Qt.sortable.group || (ft = et.nextUntil(".mbsc-lv-gr-title").filter(".mbsc-lv-item"), xt = et.prevUntil(".mbsc-lv-gr-title").filter(".mbsc-lv-item")), ct = (Qt.sortable.group ? ie.children(st).eq(0) : xt.length ? xt.eq(-1) : et)[0].offsetTop - ia, lt = (Qt.sortable.group ? ie.children(st).eq(-1) : ft.length ? ft.eq(-1) : et)[0].offsetTop - ia, Qt.sortable.handle ? Le(e.target).hasClass("mbsc-lv-handle") && (clearTimeout(Q), "Moz" === Ke ? (e.preventDefault(), m()) : $t = setTimeout(function() {
                    m()
                }, 100)) : $t = setTimeout(function() {
                    ke.appendTo(et), ke[0].style[Ke + "Animation"] = "mbsc-lv-fill " + (kt.sortDelay - 100) + "ms linear", clearTimeout(we), clearTimeout(Q), te = !1, $t = setTimeout(function() {
                        ke[0].style[Ke + "Animation"] = "", m()
                    }, kt.sortDelay - 80)
                }, 80)), "mousedown" == e.type && Le(document).on("mousemove", s).on("mouseup", r))
            }

            function s(e) {
                var t = !1,
                    a = !0;
                if (X)
                    if (Me = v(e, "X"), Se = v(e, "Y"), ve = Me - Pt, ge = Se - Ot, clearTimeout(we), ye || Et || Dt || et.hasClass("mbsc-lv-back") || (Math.abs(ge) > 10 ? (Dt = !0, r(ze({}, e, {
                            type: "mousemove" == e.type ? "mouseup" : "touchend"
                        })), clearTimeout(Q)) : Math.abs(ve) > 7 && i()), Et) e.preventDefault(), ee = ve / Qe * 100, l();
                    else if (ye) {
                    e.preventDefault();
                    var n, s = Ut.scrollTop(),
                        o = Math.max(ct, Math.min(ge + Gt, lt)),
                        c = Ie ? rt - Xt + s - Gt : rt;
                    qt + s < c + o + tt ? (Ut.scrollTop(c + o - qt + tt), n = !0) : c + o < s && (Ut.scrollTop(c + o), n = !0), n && (Gt += Ut.scrollTop() - s), ut && (Qt.sortable.multiLevel && mt.hasClass("mbsc-lv-parent") ? ia + tt / 4 + o > ut ? t = !0 : ia + tt - tt / 4 + o > ut && (xe = mt.addClass("mbsc-lv-item-hl"), a = !1) : ia + tt / 2 + o > ut && (mt.hasClass("mbsc-lv-back") ? Qt.sortable.multiLevel && (Te = mt.addClass("mbsc-lv-item-hl"), a = !1) : t = !0), t && (Tt.insertAfter(mt), yt = mt, mt = j(mt, "next"), _t = ut, ut = mt.length && mt[0].offsetTop, re++)), !t && _t && (Qt.sortable.multiLevel && yt.hasClass("mbsc-lv-parent") ? ia + tt - tt / 4 + o < _t ? t = !0 : ia + tt / 4 + o < _t && (xe = yt.addClass("mbsc-lv-item-hl"), a = !1) : ia + tt / 2 + o < _t && (yt.hasClass("mbsc-lv-back") ? Qt.sortable.multiLevel && (Te = yt.addClass("mbsc-lv-item-hl"), a = !1) : t = !0), t && (Tt.insertBefore(yt), mt = yt, yt = j(yt, "prev"), ut = _t, _t = yt.length && yt[0].offsetTop + yt[0].offsetHeight, re--)), a && (xe && (xe.removeClass("mbsc-lv-item-hl"), xe = !1), Te && (Te.removeClass("mbsc-lv-item-hl"), Te = !1)), t && Ce("onSortChange", [et, re]), N(et, o), Ce("onSort", [et, re])
                } else(Math.abs(ve) > 5 || Math.abs(ge) > 5) && A()
            }

            function r(e) {
                var t, a, n, i = et;
                X && (X = !1, A(), "mouseup" == e.type && Le(document).off("mousemove", s).off("mouseup", r), Dt || (gt = setTimeout(function() {
                    vt = !1
                }, 300)), (Et || Dt || ye) && (bt = !0), Et ? c() : ye ? (n = ie, xe ? (H(et.detach()), a = ca[xe.attr("data-ref")], re = E(a.child).length, xe.removeClass("mbsc-lv-item-hl"), kt.navigateOnDrop ? B(xe, function() {
                    Qt.add(null, et, null, null, xe, !0), J(et), u(et, at, n, !0)
                }) : (Qt.add(null, et, null, null, xe, !0), u(et, at, n, !0))) : Te ? (H(et.detach()), a = ca[Te.attr("data-back")], re = E(a.parent).index(a.item) + 1, Te.removeClass("mbsc-lv-item-hl"), kt.navigateOnDrop ? B(Te, function() {
                    Qt.add(null, et, re, null, ie, !0), J(et), u(et, at, n, !0)
                }) : (Qt.add(null, et, re, null, a.parent, !0), u(et, at, n, !0))) : (t = Tt[0].offsetTop - ia, N(et, t, 6 * Math.abs(t - Math.max(ct, Math.min(ge + Gt, lt))), function() {
                    H(et), et.insertBefore(Tt), u(et, at, n, re !== at)
                })), ye = !1) : !Dt && Math.abs(ve) < 5 && Math.abs(ge) < 5 && (Rt.tap && Rt.tap.call(aa, {
                    target: et,
                    index: at,
                    domEvent: e
                }, Qt), jt && ("touchend" === e.type && p(), et.addClass("mbsc-lv-item-active"), Ce("onItemActivate", {
                    target: et[0],
                    domEvent: e
                })), !1 !== Ce("onItemTap", {
                    target: et[0],
                    index: at,
                    domEvent: e
                }) && B(et)), clearTimeout(Q), setTimeout(function() {
                    i.removeClass("mbsc-lv-item-active"), Ce("onItemDeactivate", {
                        target: i[0]
                    })
                }, 100), Dt = !1, de = null)
            }

            function i() {
                (Et = P(Rt.swipe, {
                    target: et[0],
                    index: at,
                    direction: ve > 0 ? "right" : "left"
                })) && (A(), clearTimeout(Q), Rt.actions ? (Z = R(Rt, ve), dt.html(Rt.icons).show().children().css("width", Z + "%"), Xe.hide(), Le(".mbsc-lv-ic-m", Ze).removeClass("mbsc-lv-ic-disabled"), Le(Rt.leftMenu).each(y), Le(Rt.rightMenu).each(y)) : (Xe.show(), dt.hide(), me = Rt.start + (ve > 0 ? 0 : 1), wt = It[me - 1], ht = It[me]), et.addClass("mbsc-lv-item-swiping").removeClass("mbsc-lv-item-active"), Wt.css("line-height", tt + "px"), Ze.css({
                    top: ia,
                    height: tt,
                    backgroundColor: W(ve)
                }).addClass("mbsc-lv-stage-c-v").appendTo(ie.parent()), kt.iconSlide && et.append(Xe), Ce("onSlideStart", {
                    target: et[0],
                    index: at
                }))
            }

            function l() {
                var e = !1;
                Ct || (Rt.actions ? Ze.attr("class", "mbsc-lv-stage-c-v mbsc-lv-stage-c mbsc-lv-" + (ee < 0 ? "right" : "left")) : (wt && ee <= wt.percent ? (me--, ht = wt, wt = It[me], e = !0) : ht && ee >= ht.percent && (me++, wt = ht, ht = It[me], e = !0), e && (de = ee > 0 ? wt : ht) && (V(de, kt.iconSlide), Ce("onStageChange", {
                    target: et[0],
                    index: at,
                    stage: de
                }))), Nt || (Ct = !0, St = Fe(M)))
            }

            function c(e) {
                var t, a, n, s = !1;
                He(St), Ct = !1, Nt || M(), Rt.actions ? Math.abs(ee) > 10 && Z && (D(et, ee < 0 ? -Z : Z, 200), s = !0, Zt = !0, ae = et, ne = at, Le(document).on("touchstart.mbsc-lv-conf mousedown.mbsc-lv-conf", function(t) {
                    t.preventDefault(), S(et, !0, e)
                })) : ee && (kt.quickSwipe && !Nt && (n = new Date - Ht, t = n < 300 && ve < -50, a = n < 300 && ve > 50, t ? (Mt = !0, de = Rt.left, V(de, kt.iconSlide)) : a && (Mt = !0, de = Rt.right, V(de, kt.iconSlide))), de && de.action && ((be = P(de.disabled, {
                    target: et[0],
                    index: at
                })) || (s = !0, Zt = Nt || P(de.confirm, {
                    target: et[0],
                    index: at
                }), Zt ? (D(et, (ee < 0 ? -1 : 1) * Xe[0].offsetWidth * 100 / Qe, 200, !0), w(de, et, at, !1, e)) : _(de, et, at, e)))), s || S(et, !0, e), Et = !1
            }

            function m() {
                ye = !0, xe = !1, Te = !1, Gt = 0, re = at, kt.vibrate && f(), mt = j(et, "next"), ut = mt.length && mt[0].offsetTop, yt = j(et, "prev"), _t = yt.length && yt[0].offsetTop + yt[0].offsetHeight, Tt.height(tt).insertAfter(et), et.css({
                    top: ia
                }).addClass("mbsc-lv-item-dragging").removeClass("mbsc-lv-item-active").appendTo(_e), Ce("onSortStart", {
                    target: et[0],
                    index: re
                })
            }

            function u(e, t, a, n) {
                e.removeClass("mbsc-lv-item-dragging"), Tt.remove(), Ce("onSortEnd", {
                    target: e[0],
                    index: re
                }), kt.vibrate && f(), n && (Qt.addUndoAction(function(n) {
                    Qt.move(e, t, null, n, a, !0)
                }, !0), Ce("onSortUpdate", {
                    target: e[0],
                    index: re
                }))
            }

            function b() {
                vt || (clearTimeout(Be), Zt && Le(document).trigger("touchstart"), Ye && (Qt.close(Ee, We), Ye = !1, Ee = null))
            }

            function g() {
                clearTimeout(fe), fe = setTimeout(function() {
                    qt = Ut[0].innerHeight || Ut.innerHeight(), Xt = Ie ? Ut.offset().top : 0, X && (ia = et[0].offsetTop, tt = et[0].offsetHeight, Ze.css({
                        top: ia,
                        height: tt
                    }))
                }, 200)
            }

            function x(e) {
                bt && (e.stopPropagation(), e.preventDefault(), bt = !1)
            }

            function T(){
                if (ye || !X) {
                    var e, t = Ut.scrollTop(),
                        a = na.offset().top,
                        n = na[0].offsetHeight,
                        s = Ie ? Ut.offset().top : t;
                    Le(".mbsc-lv-gr-title", na).each(function(t, a) {
                        Le(a).offset().top < s && (e = a)
                    }), a < s && a + n > s ? Ne.show().empty().append(Le(e).clone()) : Ne.hide()
                }
            }

            function y(e, t) {
                P(t.disabled, {
                    target: et[0],
                    index: at
                }) && Le(".mbsc-ic-" + t.icon, Ze).addClass("mbsc-lv-ic-disabled")
            }

            function _(e, t, a, n) {
                var s, r = {
                    icon: "undo2",
                    text: kt.undoText,
                    color: "#b1b1b1",
                    action: function() {
                        Qt.undo()
                    }
                };
                e.undo && (Qt.startActionTrack(), Le.isFunction(e.undo) && Qt.addUndoAction(function() {
                    e.undo.call(aa, {
                        target: t[0],
                        index: a
                    }, Qt)
                }), Kt = t.attr("data-ref")), s = e.action.call(aa, {
                    target: t[0],
                    index: a
                }, Qt), e.undo ? (Qt.endActionTrack(), !1 !== s && D(t, +t.attr("data-pos") < 0 ? -100 : 100, 200), Tt.height(tt).insertAfter(t), t.css("top", ia).addClass("mbsc-lv-item-undo"), dt.hide(), Xe.show(), Ze.append(Xe), V(r), w(r, t, a, !0, n)) : S(t, s, n)
            }

            function w(e, t, a, n, s) {
                var r, i;
                Zt = !0, Le(document).off(".mbsc-lv-conf").on("touchstart.mbsc-lv-conf mousedown.mbsc-lv-conf", function(e) {
                    e.preventDefault(), n && F(t), S(t, !0, s)
                }), pe || Xe.off(".mbsc-lv-conf").on("touchstart.mbsc-lv-conf mousedown.mbsc-lv-conf", function(e) {
                    e.stopPropagation(), r = v(e, "X"), i = v(e, "Y")
                }).on("touchend.mbsc-lv-conf mouseup.mbsc-lv-conf", function(o) {
                    o.preventDefault(), "touchend" === o.type && p(), Math.abs(v(o, "X") - r) < 10 && Math.abs(v(o, "Y") - i) < 10 && (_(e, t, a, s), n && (Bt = null, F(t)))
                })
            }

            function M() {
                D(et, Ft + 100 * ve / Qe), Ct = !1
            }

            function S(e, t, a) {
                Le(document).off(".mbsc-lv-conf"), Xe.off(".mbsc-lv-conf"), !1 !== t ? D(e, 0, "0" !== e.attr("data-pos") ? 200 : 0, !1, function() {
                    I(e, a), H(e)
                }) : I(e, a), Zt = !1
            }

            function D(e, t, a, n, s) {
                t = Math.max("right" == Et ? 0 : -100, Math.min(t, "left" == Et ? 0 : 100)), Lt = e[0].style, e.attr("data-pos", t), Lt[Ke + "Transform"] = "translate3d(" + (n ? Qe * t / 100 + "px" : t + "%") + ",0,0)", Lt[Ke + "Transition"] = Je + "transform " + (a || 0) + "ms", s && (sa++, setTimeout(function() {
                    s(), sa--
                }, a)), ee = t
            }

            function N(e, t, a, n) {
                t = Math.max(ct, Math.min(t, lt)), Lt = e[0].style, Lt[Ke + "Transform"] = "translate3d(0," + t + "px,0)", Lt[Ke + "Transition"] = Je + "transform " + (a || 0) + "ms ease-out", n && (sa++, setTimeout(function() {
                    n(), sa--
                }, a))
            }

            function A() {
                clearTimeout($t), !te && Qt.sortable && (te = !0, ke.remove())
            }

            function V(e, t) {
                var a = P(e.text, {
                    target: et[0],
                    index: at
                }) || "";
                P(e.disabled, {
                    target: et[0],
                    index: at
                }) ? Ze.addClass("mbsc-lv-ic-disabled") : Ze.removeClass("mbsc-lv-ic-disabled"), Ze.css("background-color", e.color || (0 === e.percent ? W(ee) : ta)), Xe.attr("class", "mbsc-lv-ic-c mbsc-lv-ic-" + (t ? "move-" : "") + (ee < 0 ? "right" : "left")), Ge.attr("class", " mbsc-lv-ic-s mbsc-lv-ic mbsc-ic mbsc-ic-" + (e.icon || "none")), Wt.attr("class", "mbsc-lv-ic-text" + (e.icon ? "" : " mbsc-lv-ic-text-only") + (a ? "" : " mbsc-lv-ic-only")).html(a || "&nbsp;"), kt.animateIcons && (Mt ? Ge.addClass("mbsc-lv-ic-v") : setTimeout(function() {
                    Ge.addClass("mbsc-lv-ic-a")
                }, 10))
            }

            function I(e, t) {
                X || (Ge.attr("class", "mbsc-lv-ic-s mbsc-lv-ic mbsc-ic mbsc-ic-none"), Ze.attr("style", "").removeClass("mbsc-lv-stage-c-v"), Wt.html("")), Ze.removeClass("mbsc-lv-left mbsc-lv-right"), e && (Ce("onSlideEnd", {
                    target: e[0],
                    index: at
                }), t && t())
            }

            function F(e) {
                e.css("top", "").removeClass("mbsc-lv-item-undo"), Bt ? Qt.animate(Tt, "collapse", function() {
                    Tt.remove()
                }) : Tt.remove(), I(), Kt = null, Bt = null
            }

            function H(e) {
                Lt = e[0].style, Lt[Ke + "Transform"] = "", Lt[Ke + "Transition"] = "", Lt.top = "", e.removeClass("mbsc-lv-item-swiping")
            }

            function P(e, t) {
                return Le.isFunction(e) ? e.call(this, t, Qt) : e
            }

            function O(e) {
                var t, a = e.attr("data-role");
                if (e.attr("data-ref") || (t = ea++, e.attr("data-ref", t), ca[t] = {
                        item: e,
                        child: e.children(ot),
                        parent: e.parent(),
                        ref: e.parent()[0] === aa ? null : e.parent().parent().attr("data-ref")
                    }), e.addClass("list-divider" == a ? "mbsc-lv-gr-title" : "mbsc-lv-item"), Qt.sortable.handle && "list-divider" != a && !e.children(".mbsc-lv-handle-c").length && e.append(Pe), kt.enhance && !e.hasClass("mbsc-lv-item-enhanced")) {
                    var n = e.attr("data-icon"),
                        s = e.find("img").eq(0).addClass("mbsc-lv-img");
                    s.is(":first-child") ? e.addClass("mbsc-lv-img-" + (kt.rtl ? "right" : "left")) : s.length && e.addClass("mbsc-lv-img-" + (kt.rtl ? "left" : "right")), e.addClass("mbsc-lv-item-enhanced").children().each(function(e, t) {
                        t = Le(t), t.is("p, h1, h2, h3, h4, h5, h6") && t.addClass("mbsc-lv-txt")
                    }), n && e.addClass("mbsc-lv-item-ic-" + (e.attr("data-icon-align") || (kt.rtl ? "right" : "left"))).append('<div class="mbsc-lv-item-ic mbsc-ic mbsc-ic-' + n + '"></div>')
                }
            }

            function L(e) {
                Le(st, e).not(".mbsc-lv-item").each(function() {
                    O(Le(this))
                }), Le(ot, e).not(".mbsc-lv").addClass("mbsc-lv").prepend(Ue).parent().addClass("mbsc-lv-parent").prepend(qe), Le(".mbsc-lv-back", e).each(function() {
                    Le(this).attr("data-back", Le(this).parent().parent().attr("data-ref"))
                })
            }

            function E(e) {
                return e.children(st).not(".mbsc-lv-back").not(".mbsc-lv-removed").not(".mbsc-lv-ph")
            }

            function Y(e) {
                return "object" !== (void 0 === e ? "undefined" : he(e)) && (e = Le(st, se).filter('[data-id="' + e + '"]')), Le(e)
            }

            function z(e) {
                for (var t = 0, a = ca[e.attr("data-ref")]; a && a.ref;) t++, a = ca[a.ref];
                return t
            }

            function j(e, t) {
                for (e = e[t](); e.length && (!e.hasClass("mbsc-lv-item") || e.hasClass("mbsc-lv-ph") || e.hasClass("mbsc-lv-item-dragging"));) {
                    if (!Qt.sortable.group && e.hasClass("mbsc-lv-gr-title")) return !1;
                    e = e[t]()
                }
                return e
            }

            function W(e) {
                return (e > 0 ? Rt.right : Rt.left).color || ta
            }

            function $(e) {
                return d(e) ? e + "" : 0
            }

            function R(e, t) {
                return +(t < 0 ? $((e.actionsWidth || 0).right) || $(e.actionsWidth) || $(kt.actionsWidth.right) || $(kt.actionsWidth) : $((e.actionsWidth || 0).left) || $(e.actionsWidth) || $(kt.actionsWidth.left) || $(kt.actionsWidth))
            }

            function J(e, t) {
                if (e) {
                    var a = Ut.scrollTop(),
                        n = e.is(".mbsc-lv-item") ? e[0].offsetHeight : 0,
                        s = e.offset().top + (Ie ? a - Xt : 0);
                    t ? (s < a || s + n > a + qt) && Ut.scrollTop(s) : s < a ? Ut.scrollTop(s) : s + n > a + qt && Ut.scrollTop(Math.min(s, s + n - qt / 2))
                }
            }

            function K(e, t, a, n, s) {
                var r = t.parent(),
                    i = t.prev();
                n = n || o, i[0] === Xe[0] && (i = Xe.prev()), ie[0] !== t[0] ? (Ce("onNavStart", {
                    level: ra,
                    direction: e,
                    list: t[0]
                }), At.prepend(t.addClass("mbsc-lv-v mbsc-lv-sl-new")), J(se), U(At, "mbsc-lv-sl-" + e, function() {
                    ie.removeClass("mbsc-lv-sl-curr"), t.removeClass("mbsc-lv-sl-new").addClass("mbsc-lv-sl-curr"), oe && oe.length ? ie.removeClass("mbsc-lv-v").insertAfter(oe) : le.append(ie.removeClass("mbsc-lv-v")), oe = i, le = r, ie = t, J(a, s), n.call(aa, a), Ce("onNavEnd", {
                        level: ra,
                        direction: e,
                        list: t[0]
                    })
                })) : (J(a, s), n.call(aa, a))
            }

            function B(e, t) {
                sa || (e.hasClass("mbsc-lv-parent") ? (ra++, K("r", ca[e.attr("data-ref")].child, null, t)) : e.hasClass("mbsc-lv-back") && (ra--, K("l", ca[e.attr("data-back")].parent, ca[e.attr("data-back")].item, t)))
            }

            function U(e, t, a) {
                function n() {
                    clearTimeout(s), sa--, e.off($e, n).removeClass(t), a.call(aa, e)
                }
                var s;
                a = a || o, kt.animation && "mbsc-lv-item-none" !== t ? (sa++, e.on($e, n).addClass(t), s = setTimeout(n, 500)) : a.call(aa, e)
            }

            function q(e, t) {
                var a, n = e.attr("data-ref");
                a = la[n] = la[n] || [], t && a.push(t), e.attr("data-action") || (t = a.shift(), e.attr("data-action", 1), t(function() {
                    e.removeAttr("data-action"), a.length ? q(e) : delete la[n]
                }))
            }

            function G(e, t, a) {
                var n, s;
                e && e.length && (n = 100 / (e.length + 2), Le.each(e, function(r, i) {
                    void 0 === i.key && (i.key = Vt++), void 0 === i.percent && (i.percent = t * n * (r + 1), a && (s = ze({}, i), s.key = Vt++, s.percent = -n * (r + 1), e.push(s), oa[s.key] = s)), oa[i.key] = i
                }))
            }
            var X, Z, Q, ee, te, ae, ne, se, re, ie, oe, le, ce, de, me, fe, pe, be, ve, ge, xe, Te, ye, _e, we, Me, Se, Ce, ke, De, Ne, Ae, Ve, Ie, Pe, Oe, Ee, Ye, We, Re, Be, Ue, qe, Ge, Xe, Ze, Qe, et, tt, at, nt, st, rt, it, ot, lt, ct, dt, mt, ut, ht, ft, pt, bt, vt, gt, xt, Tt, yt, _t, wt, Mt, St, Ct, kt, Dt, Nt, At, Vt, It, Ft, Ht, Pt, Ot, Lt, Et, Yt, zt, jt, Wt, $t, Rt, Jt, Kt, Bt, Ut, qt, Gt, Xt, Qt = this,
                aa = e,
                na = Le(aa),
                sa = 0,
                ra = 0,
                ia = 0,
                oa = {},
                la = {},
                ca = {};
            je.call(this, e, t, !0), Qt.animate = function(e, t, a) {
                U(e, "mbsc-lv-item-" + t, a)
            }, Qt.add = function(e, t, a, n, s, r) {
                var i, l, c, d, m, u, h = "",
                    f = void 0 === s ? na : Y(s),
                    p = f,
                    b = Le("object" !== (void 0 === t ? "undefined" : he(t)) ? "<" + nt + ' data-ref="' + ea++ + '" data-id="' + e + '">' + t + "</" + nt + ">" : t),
                    v = b.attr("data-pos") < 0 ? "left" : "right",
                    g = b.attr("data-ref");
                n = n || o, g || (g = ea++, b.attr("data-ref", g)), O(b), r || Qt.addUndoAction(function(e) {
                    d ? Qt.navigate(f, function() {
                        p.remove(), f.removeClass("mbsc-lv-parent").children(".mbsc-lv-arr").remove(), m.child = f.children(ot), Qt.remove(b, null, e, !0)
                    }) : Qt.remove(b, null, e, !0)
                }, !0), q(b, function(e) {
                    H(b.css("top", "").removeClass("mbsc-lv-item-undo")), f.is(st) ? (u = f.attr("data-ref"), f.children(ot).length || (d = !0, f.append("<" + it + "></" + it + ">"))) : u = f.children(".mbsc-lv-back").attr("data-back"), m = ca[u], m && (m.child.length ? p = m.child : (f.addClass("mbsc-lv-parent").prepend(qe), p = f.children(ot).prepend(Ue).addClass("mbsc-lv"), m.child = p, Le(".mbsc-lv-back", f).attr("data-back", u))), ca[g] = {
                        item: b,
                        child: b.children(ot),
                        parent: p,
                        ref: u
                    }, c = E(p), l = c.length, void 0 !== a && null !== a || (a = l), r && (h = "mbsc-lv-item-new-" + (r ? v : "")), L(b.addClass(h)), !1 !== a && (l ? a < l ? b.insertBefore(c.eq(a)) : b.insertAfter(c.eq(l - 1)) : (i = Le(".mbsc-lv-back", p), i.length ? b.insertAfter(i) : p.append(b))), p.hasClass("mbsc-lv-v") ? Qt.animate(b.height(b[0].offsetHeight), r && Kt === g ? "none" : "expand", function(t) {
                        Qt.animate(t.height(""), r ? "add-" + v : "pop-in", function(t) {
                            n.call(aa, t.removeClass(h)), e()
                        })
                    }) : (n.call(aa, b.removeClass(h)), e()), se.trigger("mbsc-refresh"), Ce("onItemAdd", {
                        target: b[0]
                    })
                })
            }, Qt.swipe = function(e, t, n, s, r) {
                e = Y(e), et = e, pe = s, Nt = !0, X = !0, n = void 0 === n ? 300 : n, ve = t > 0 ? 1 : -1, a(), i(), D(e, t, n), clearTimeout(zt), clearInterval(Yt), Yt = setInterval(function() {
                    ee = k(e) / Qe * 100, l()
                }, 10), zt = setTimeout(function() {
                    clearInterval(Yt), ee = t, l(), c(r), pe = !1, Nt = !1, X = !1
                }, n)
            }, Qt.openStage = function(e, t, a, n) {
                oa[t] && Qt.swipe(e, oa[t].percent, a, n)
            }, Qt.openActions = function(e, t, a, n) {
                e = Y(e);
                var s = R(Jt[e.attr("data-type") || "defaults"], "left" == t ? -1 : 1);
                Qt.swipe(e, "left" == t ? -s : s, a, n)
            }, Qt.close = function(e, t) {
                Qt.swipe(e, 0, t)
            }, Qt.remove = function(e, t, a, n) {
                var s, r, i;
                a = a || o, e = Y(e), e.length && (r = e.parent(), s = E(r).index(e), i = e[0].style, n || (e.attr("data-ref") === Kt && (Bt = !0), Qt.addUndoAction(function(t) {
                    Qt.add(null, e, s, t, r, !0)
                }, !0)), q(e, function(s) {
                    t = t || (e.attr("data-pos") < 0 ? "left" : "right"), r.hasClass("mbsc-lv-v") ? Qt.animate(e.addClass("mbsc-lv-removed"), n ? "pop-out" : "remove-" + t, function(e) {
                        i.height = e[0].offsetHeight + "px", Qt.animate(e, "collapse", function(e) {
                            i.height = "", H(e.removeClass("mbsc-lv-removed")), !1 !== a.call(aa, e) && e.remove(), s()
                        })
                    }) : (!1 !== a.call(aa, e) && e.remove(), s()), Ce("onItemRemove", {
                        target: e[0]
                    })
                }))
            }, Qt.move = function(e, t, a, n, s, r) {
                e = Y(e), r || Qt.startActionTrack(), Ze.append(Xe), Qt.remove(e, a, null, r), Qt.add(null, e, t, n, s, r), r || Qt.endActionTrack()
            }, Qt.navigate = function(e, t) {
                var a, n;
                e = Y(e), a = ca[e.attr("data-ref")], n = z(e), a && (K(n >= ra ? "r" : "l", a.parent, e, t, !0), ra = n)
            }, Qt._processSettings = function() {
                na.is("[mbsc-enhance]") && (Ae = !0, na.removeAttr("mbsc-enhance"))
            }, 
            Qt._init = function() {
                var e, t, a, i = 0, p = na.find('ul,ol').length ? 'left' : 'right',
                    o = "",
                    l = "",
                    c = "";
                a = kt.sort || kt.sortable;
                    "group" === a && (a = {
                        group: !1,
                        multiLevel: !0
                    });
                    !0 === a && (a = {
                        group: !0,
                        multiLevel: !0,
                        handle: kt.sortHandle
                    });
                    a && a.handle === undefined && (a.handle = kt.sortHandle);
                    Qt.sortable = a || !1;
	            
	            var Za = !0 === Qt.sortable.handle ? p : Qt.sortable.handle;
	            
                it = kt.listNode, 
                ot = kt.listSelector, 
                nt = kt.itemNode, 
                st = kt.itemSelector,
                Ve = Za || '', 
                Ue = '<li class="mbsc-lv-item mbsc-lv-back">' + kt.backText + '<div class="mbsc-lv-arr mbsc-lv-ic mbsc-ic ' + kt.leftArrowClass + '"></div></li>';
                qe = '<div class="mbsc-lv-arr mbsc-lv-ic mbsc-ic ' + kt.rightArrowClass + '"></div>',
                e = 'mbsc-lv-cont '+( Za && 'mbsc-lv-handle-'+Za )+' mbsc-lv-' + kt.theme + (kt.rtl ? ' mbsc-lv-rtl' : '') + (kt.baseTheme ? ' mbsc-lv-' + kt.baseTheme : '') + (kt.animateIcons ? ' mbsc-lv-ic-anim' : '') + (kt.striped ? ' mbsc-lv-alt-row ' : '') + (kt.fixedHeader ? ' mbsc-lv-has-fixed-header ' : '');
                if (Qt.sortable.handle) {
	                Pe = '<div class="mbsc-lv-handle-c mbsc-lv-item-h-' + Za + ' mbsc-lv-handle"><div class="' + kt.handleClass + ' mbsc-lv-handle-bar-c mbsc-lv-handle">' + kt.handleMarkup + '</div></div>';
	            }
                
                se ? (se.attr("class", e), a.handle && Le(".mbsc-lv-handle-c", se).remove(), Le(st, se).not(".mbsc-lv-back").removeClass("mbsc-lv-item")) : (o += '<div class="mbsc-lv-multi-c"></div>', o += '<div class="mbsc-lv-ic-c"><div class="mbsc-lv-ic-s mbsc-lv-ic mbsc-ic mbsc-ic-none"></div><div class="mbsc-lv-ic-text"></div></div>', na.addClass("mbsc-lv mbsc-lv-v mbsc-lv-root").show(), Ze = Le('<div class="mbsc-lv-stage-c">' + o + "</div>"), Xe = Le(".mbsc-lv-ic-c", Ze), dt = Le(".mbsc-lv-multi-c", Ze), Ge = Le(".mbsc-lv-ic-s", Ze), Wt = Le(".mbsc-lv-ic-text", Ze), Tt = Le("<" + nt + ' class="mbsc-lv-item mbsc-lv-ph"></' + nt + ">"), ke = Le('<div class="mbsc-lv-fill-item"></div>'), se = Le('<div class="' + e + '"><' + it + ' class="mbsc-lv mbsc-lv-dummy"></' + it + '><div class="mbsc-lv-sl-c"></div></div>'), Ie = "body" !== kt.context, Ut = Le(Ie ? kt.context : window), _e = Le(".mbsc-lv-dummy", se), se.insertAfter(na), Ut.on("orientationchange resize", g), g(), se.on("touchstart mousedown", ".mbsc-lv-item", n).on("touchmove", ".mbsc-lv-item", s).on("touchend touchcancel", ".mbsc-lv-item", r), aa.addEventListener("click", x, !0), se.on("touchstart mousedown", ".mbsc-lv-ic-m", function(e) {
                        pe || (e.stopPropagation(), e.preventDefault()), Pt = v(e, "X"), Ot = v(e, "Y")
                    }).on("touchend mouseup", ".mbsc-lv-ic-m", function(e) {
                        pe || ("touchend" === e.type && p(), Zt && !Le(this).hasClass("mbsc-lv-ic-disabled") && Math.abs(v(e, "X") - Pt) < 10 && Math.abs(v(e, "Y") - Ot) < 10 && _((ee < 0 ? Rt.rightMenu : Rt.leftMenu)[Le(this).index()], ae, ne))
                    }), At = Le(".mbsc-lv-sl-c", se).append(na.addClass("mbsc-lv-sl-curr")).attr("data-ref", ea++), ie = na, le = se), L(na), Vt = 0, Jt = kt.itemGroups || {}, Jt.defaults = {
                        swipeleft: kt.swipeleft,
                        swiperight: kt.swiperight,
                        stages: kt.stages,
                        actions: kt.actions,
                        actionsWidth: kt.actionsWidth
                    }, Le.each(Jt, function(e, t) {
                        if (t.swipe = void 0 !== t.swipe ? t.swipe : kt.swipe, t.stages = t.stages || [], G(t.stages, 1, !0), G(t.stages.left, 1), G(t.stages.right, -1), (t.stages.left || t.stages.right) && (t.stages = [].concat(t.stages.left || [], t.stages.right || [])), De = !1, t.stages.length || (t.swipeleft && t.stages.push({
                                percent: -30,
                                action: t.swipeleft
                            }), t.swiperight && t.stages.push({
                                percent: 30,
                                action: t.swiperight
                            })), Le.each(t.stages, function(e, t) {
                                if (0 === t.percent) return De = !0, !1
                            }), De || t.stages.push({
                                percent: 0
                            }), t.stages.sort(function(e, t) {
                                return e.percent - t.percent
                            }), Le.each(t.stages, function(e, a) {
                                if (0 === a.percent) return t.start = e, !1
                            }), De ? t.left = t.right = t.stages[t.start] : (t.left = t.stages[t.start - 1] || {}, t.right = t.stages[t.start + 1] || {}), t.actions) {
                            for (t.leftMenu = t.actions.left || t.actions, t.rightMenu = t.actions.right || t.leftMenu, l = "", c = "", i = 0; i < t.leftMenu.length; i++) l += "<div " + (t.leftMenu[i].color ? 'style="background-color: ' + t.leftMenu[i].color + '"' : "") + ' class="mbsc-lv-ic-m mbsc-lv-ic mbsc-ic mbsc-ic-' + t.leftMenu[i].icon + '">' + (t.leftMenu[i].text || "") + "</div>";
                            for (i = 0; i < t.rightMenu.length; ++i) c += "<div " + (t.rightMenu[i].color ? 'style="background-color: ' + t.rightMenu[i].color + '"' : "") + ' class="mbsc-lv-ic-m mbsc-lv-ic mbsc-ic mbsc-ic-' + t.rightMenu[i].icon + '">' + (t.rightMenu[i].text || "") + "</div>";
                            t.actions.left && (t.swipe = t.actions.right ? t.swipe : "right"), t.actions.right && (t.swipe = t.actions.left ? t.swipe : "left"), t.icons = '<div class="mbsc-lv-multi mbsc-lv-multi-ic-left">' + l + '</div><div class="mbsc-lv-multi mbsc-lv-multi-ic-right">' + c + "</div>"
                        }
                    }),
                    kt.fixedHeader && (t = "mbsc-lv-fixed-header" + (Ie ? " mbsc-lv-fixed-header-ctx mbsc-lv-" + kt.theme + (kt.baseTheme ? " mbsc-lv-" + kt.baseTheme : "") : ""), Ne ? Ne.attr("class", t) : (Ne = Le('<div class="' + t + '"></div>'), Ie ? Ut.before(Ne) : se.prepend(Ne), pt = h(T, 200), Ut.on("scroll touchmove", pt))), kt.hover && (We || se.on("mouseover.mbsc-lv", ".mbsc-lv-item", function() {
                        Ee && Ee[0] == this || (b(), Ee = Le(this), Jt[Ee.attr("data-type") || "defaults"].actions && (Be = setTimeout(function() {
                            vt ? Ee = null : (Ye = !0, Qt.openActions(Ee, Oe, We, !1))
                        }, Re)))
                    }).on("mouseleave.mbsc-lv", b), We = kt.hover.time || 200, Re = kt.hover.timeout || 200, Oe = kt.hover.direction || kt.hover || "right"), Ae && se.attr("mbsc-enhance", ""), se.trigger("mbsc-enhance", [{
                        theme: kt.theme,
                        lang: kt.lang
                    }])
            }, Qt._destroy = function() {
                var e;
                le.append(ie), Ie && Ne && Ne.remove(), Ae && (na.attr("mbsc-enhance", ""), (e = ue.instances[se[0].id]) && e.destroy()), aa.removeEventListener("click", x, !0), se.find(".mbsc-lv-txt,.mbsc-lv-img").removeClass("mbsc-lv-txt mbsc-lv-img"), se.find(ot).removeClass("mbsc-lv mbsc-lv-v mbsc-lv-root mbsc-lv-sl-curr").find(st).removeClass("mbsc-lv-gr-title mbsc-lv-item mbsc-lv-item-enhanced mbsc-lv-parent mbsc-lv-img-left mbsc-lv-img-right mbsc-lv-item-ic-left mbsc-lv-item-ic-right").removeAttr("data-ref"), Le(".mbsc-lv-back,.mbsc-lv-handle-c,.mbsc-lv-arr,.mbsc-lv-item-ic", se).remove(), na.insertAfter(se), se.remove(), Ze.remove(), Ut.off("orientationchange resize", g), pt && Ut.off("scroll touchmove", pt)
            };
            var da, ma = [],
                ua = [],
                ha = [],
                fa = 0;
            Qt.startActionTrack = function() {
                fa || (ha = []), fa++
            }, Qt.endActionTrack = function() {
                --fa || ua.push(ha)
            }, Qt.addUndoAction = function(e, t) {
                var a = {
                    action: e,
                    async: t
                };
                fa ? ha.push(a) : (ua.push([a]), ua.length > kt.undoLimit && ua.shift())
            }, Qt.undo = function() {
                function e() {
                    n < 0 ? (da = !1, t()) : (a = s[n], n--, a.async ? a.action(e) : (a.action(), e()))
                }

                function t() {
                    (s = ma.shift()) && (da = !0, n = s.length - 1, e())
                }
                var a, n, s;
                ua.length && ma.push(ua.pop()), da || t()
            }, kt = Qt.settings, Ce = Qt.trigger, Qt.init(t)
        };
    aa.prototype = {
        _class: "listview",
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _defaults: {
            context: "body",
            actionsWidth: 90,
            sortDelay: 250,
            undoLimit: 10,
            swipe: !0,
            quickSwipe: !0,
            animateIcons: !0,
            animation: !0,
            revert: !0,
            vibrate: !0,
            handleClass: "",
            handleMarkup: '<div class="mbsc-lv-handle-bar mbsc-lv-handle"></div><div class="mbsc-lv-handle-bar mbsc-lv-handle"></div><div class="mbsc-lv-handle-bar mbsc-lv-handle"></div>',
            listNode: "ul",
            listSelector: "ul,ol",
            itemNode: "li",
            itemSelector: "li",
            leftArrowClass: "mbsc-ic-arrow-left4",
            rightArrowClass: "mbsc-ic-arrow-right4",
            backText: "Back",
            undoText: "Undo",
            stages: []
        }
    }, Qt.ListView = aa, ue.themes.listview.mobiscroll = {
        leftArrowClass: "mbsc-ic-arrow-left5",
        rightArrowClass: "mbsc-ic-arrow-right5"
    }, ue.presetShort("listview", "ListView");
    var na = {
        batch: 50,
        min: 0,
        max: 100,
        defaultUnit: "",
        units: null,
        unitNames: null,
        invalid: [],
        sign: !1,
        step: .05,
        scale: 2,
        convert: function(e) {
            return e
        },
        signText: "&nbsp;",
        wholeText: "Whole",
        fractionText: "Fraction",
        unitText: "Unit"
    };
    ue.presets.scroller.measurement = function(e) {
        function t(e) {
            return Math.max(g, Math.min(x, O ? e < 0 ? Math.ceil(e) : Math.floor(e) : r(Math.round(e - j), z) + j))
        }

        function a(e) {
            return O ? r((Math.abs(e) - Math.abs(t(e))) * Y - W, z) + W : 0
        }

        function n(e) {
            var n = t(e),
                s = a(e),
                r = e < 0 ? "-" : "+";
            return s >= Y && (e < 0 ? n-- : n++, s = 0), [r, n, s]
        }

        function s(e) {
            var t = +e[f],
                a = O ? e[h] / Y * (t < 0 ? -1 : 1) : 0;
            return (I && "-" == e[0] ? -1 : 1) * (t + a)
        }

        function r(e, t) {
            return Math.round(e / t) * t
        }

        function i(e, t, a) {
            return t !== a && S.convert ? S.convert.call(this, e, t, a) : e
        }

        function o(e) {
            var t, n;
            b = i(S.min, H, e), v = i(S.max, H, e), O ? (g = b < 0 ? Math.ceil(b) : Math.floor(b), x = v < 0 ? Math.ceil(v) : Math.floor(v), T = a(b), y = a(v)) : (g = Math.round(b), x = Math.round(v), x = g + Math.floor((x - g) / z) * z, j = g % z), t = g, n = x, I && (n = Math.abs(t) > Math.abs(n) ? Math.abs(t) : Math.abs(n), t = t < 0 ? 0 : t), N.min = t < 0 ? Math.ceil(t / L) : Math.floor(t / L), N.max = n < 0 ? Math.ceil(n / L) : Math.floor(n / L)
        }

        function l(e) {
            return s(e).toFixed(O ? E : 0) + (F ? " " + P[e[p]] : "")
        }
        var c, d, m, h, f, p, b, v, g, x, T, y, _, w, M = ze({}, e.settings),
            S = ze(e.settings, na, M),
            C = {},
            k = [
                []
            ],
            D = {},
            N = {},
            A = {},
            V = [],
            I = S.sign,
            F = S.units && S.units.length,
            H = F ? S.defaultUnit || S.units[0] : "",
            P = [],
            O = S.step < 1,
            L = S.step > 1 ? S.step : 1,
            E = O ? Math.max(S.scale, (S.step + "").split(".")[1].length) : 1,
            Y = Math.pow(10, E),
            z = Math.round(O ? S.step * Y : S.step),
            j = 0,
            W = 0,
            $ = 0;
        if (e.setVal = function(t, a, n, s, r) {
                e._setVal(Le.isArray(t) ? l(t) : t, a, n, s, r)
            }, S.units)
            for (w = 0; w < S.units.length; ++w) _ = S.units[w], P.push(S.unitNames ? S.unitNames[_] || _ : _);
        if (I)
            if (I = !1, F)
                for (w = 0; w < S.units.length; w++) i(S.min, H, S.units[w]) < 0 && (I = !0);
            else I = S.min < 0;
        if (I && (k[0].push({
                data: ["-", "+"],
                label: S.signText
            }), $++), N = {
                label: S.wholeText,
                data: function(e) {
                    return g % L + e * L
                },
                getIndex: function(e) {
                    return Math.round((e - g % L) / L)
                }
            }, k[0].push(N), f = $++, o(H), O) {
            for (k[0].push(A), A.data = [], A.label = S.fractionText, w = W; w < Y; w += z) V.push(w), A.data.push({
                value: w,
                display: "." + function(e, t) {
                    for (e += ""; e.length < t;) e = "0" + e;
                    return e
                }(w, E)
            });
            h = $++, c = Math.ceil(100 / z), S.invalid && S.invalid.length && (Le.each(S.invalid, function(e, t) {
                var a = t > 0 ? Math.floor(t) : Math.ceil(t);
                0 === a && (a = t <= 0 ? -.001 : .001), D[a] = (D[a] || 0) + 1, 0 === t && (a = .001, D[a] = (D[a] || 0) + 1)
            }), Le.each(D, function(e, t) {
                t < c ? delete D[e] : D[e] = e
            }))
        }
        if (F) {
            for (C = {
                    data: [],
                    label: S.unitText,
                    cssClass: "mbsc-msr-whl-unit",
                    circular: !1
                }, w = 0; w < S.units.length; w++) C.data.push({
                value: w,
                display: P[w]
            });
            k[0].push(C)
        }
        return p = $, {
            wheels: k,
            minWidth: I && O ? 70 : 80,
            showLabel: !1,
            formatValue: l,
            compClass: "mbsc-msr",
            parseValue: function(e) {
                var t, a = ("number" == typeof e ? e + "" : e) || S.defaultValue,
                    s = (a + "").split(" "),
                    r = +s[0],
                    i = [],
                    l = "";
                return F && (l = Le.inArray(s[1], P), l = -1 == l ? Le.inArray(H, S.units) : l, l = -1 == l ? 0 : l), m = F ? S.units[l] : "", o(m), r = isNaN(r) ? 0 : r, r = u(r, b, v), t = n(r), t[1] = u(t[1], g, x), d = r, I && (i[0] = t[0], t[1] = Math.abs(t[1])), i[f] = t[1], O && (i[h] = t[2]), F && (i[p] = l), i
            },
            onCancel: function() {
                d = void 0
            },
            validate: function(t) {
                var a, l, c, _, w, M = t.values,
                    C = t.index,
                    k = t.direction,
                    A = {},
                    P = [],
                    E = {},
                    Y = F ? S.units[M[p]] : "";
                if (I && 0 === C && (d = Math.abs(d) * ("-" == M[0] ? -1 : 1)), (C === f || C === h && O || void 0 === d || void 0 === C) && (d = s(M), m = Y), (F && C === p && m !== Y || void 0 === C) && (o(Y), d = i(d, m, Y), m = Y, l = n(d), void 0 !== C && (E[f] = N, e.changeWheel(E)), I && (M[0] = l[0])), P[f] = [], I)
                    for (P[0] = [], b > 0 && (P[0].push("-"), M[0] = "+"), v < 0 && (P[0].push("+"), M[0] = "-"), w = Math.abs("-" == M[0] ? g : x), $ = w + L; $ < w + 20 * L; $ += L) P[f].push($), A[$] = !0;
                if (d = u(d, b, v), l = n(d), c = I ? Math.abs(l[1]) : l[1], a = I ? "-" == M[0] : d < 0, M[f] = c, a && (l[0] = "-"), O && (M[h] = l[2]), Le.each(O ? D : S.invalid, function(e, t) {
                        if (I && a) {
                            if (!(t <= 0)) return;
                            t = Math.abs(t)
                        }
                        t = r(i(t, H, Y), O ? 1 : z), A[t] = !0, P[f].push(t)
                    }), M[f] = e.getValidValue(f, c, k, A), l[1] = M[f] * (I && a ? -1 : 1), O) {
                    P[h] = [];
                    var j = I ? M[0] + M[1] : (d < 0 ? "-" : "+") + Math.abs(l[1]),
                        W = (b < 0 ? "-" : "+") + Math.abs(g),
                        R = (v < 0 ? "-" : "+") + Math.abs(x);
                    j === W && Le(V).each(function(e, t) {
                        (a ? t > T : t < T) && P[h].push(t)
                    }), j === R && Le(V).each(function(e, t) {
                        (a ? t < y : t > y) && P[h].push(t)
                    }), Le.each(S.invalid, function(e, t) {
                        _ = n(i(t, H, Y)), (l[0] === _[0] || 0 === l[1] && 0 === _[1] && 0 === _[2]) && l[1] === _[1] && P[h].push(_[2])
                    })
                }
                return {
                    disabled: P,
                    valid: M
                }
            }
        }
    }, ue.presetShort("measurement");
    var sa = ue.presets.scroller,
        ra = {
            min: 0,
            max: 100,
            defaultUnit: "km",
            units: ["m", "km", "in", "ft", "yd", "mi"]
        },
        ia = {
            mm: .001,
            cm: .01,
            dm: .1,
            m: 1,
            dam: 10,
            hm: 100,
            km: 1e3,
            in: .0254,
            ft: .3048,
            yd: .9144,
            ch: 20.1168,
            fur: 201.168,
            mi: 1609.344,
            lea: 4828.032
        };
    ue.presetShort("distance"), sa.distance = function(e) {
        var t = ze({}, ra, e.settings);
        return ze(e.settings, t, {
            sign: !1,
            convert: function(e, t, a) {
                return e * ia[t] / ia[a]
            }
        }), sa.measurement.call(this, e)
    };
    var oa = ue.presets.scroller,
        la = {
            min: 0,
            max: 100,
            defaultUnit: "N",
            units: ["N", "kp", "lbf", "pdl"]
        },
        ca = {
            N: 1,
            kp: 9.80665,
            lbf: 4.448222,
            pdl: .138255
        };
    ue.presetShort("force"), oa.force = function(e) {
        var t = ze({}, la, e.settings);
        return ze(e.settings, t, {
            sign: !1,
            convert: function(e, t, a) {
                return e * ca[t] / ca[a]
            }
        }), oa.measurement.call(this, e)
    };
    var da = ue.presets.scroller,
        ma = {
            min: 0,
            max: 1e3,
            defaultUnit: "kg",
            units: ["g", "kg", "oz", "lb"],
            unitNames: {
                tlong: "t (long)",
                tshort: "t (short)"
            }
        },
        ua = {
            mg: .001,
            cg: .01,
            dg: .1,
            g: 1,
            dag: 10,
            hg: 100,
            kg: 1e3,
            t: 1e6,
            drc: 1.7718452,
            oz: 28.3495,
            lb: 453.59237,
            st: 6350.29318,
            qtr: 12700.58636,
            cwt: 50802.34544,
            tlong: 1016046.9088,
            tshort: 907184.74
        };
    ue.presetShort("mass"), da.mass = function(e) {
        var t = ze({}, ma, e.settings);
        return ze(e.settings, t, {
            sign: !1,
            convert: function(e, t, a) {
                return e * ua[t] / ua[a]
            }
        }), da.measurement.call(this, e)
    };
    var ha = ue.presets.scroller,
        fa = {
            min: 0,
            max: 100,
            defaultUnit: "kph",
            units: ["kph", "mph", "mps", "fps", "knot"],
            unitNames: {
                kph: "km/h",
                mph: "mi/h",
                mps: "m/s",
                fps: "ft/s",
                knot: "knot"
            }
        },
        pa = {
            kph: 1,
            mph: 1.60934,
            mps: 3.6,
            fps: 1.09728,
            knot: 1.852
        };
    ue.presetShort("speed"), ha.speed = function(e) {
        var t = ze({}, fa, e.settings);
        return ze(e.settings, t, {
            sign: !1,
            convert: function(e, t, a) {
                return e * pa[t] / pa[a]
            }
        }), ha.measurement.call(this, e)
    };
    var ba = ue.presets.scroller,
        va = {
            min: -20,
            max: 40,
            defaultUnit: "c",
            units: ["c", "k", "f", "r"],
            unitNames: {
                c: "°C",
                k: "K",
                f: "°F",
                r: "°R"
            }
        },
        ga = {
            c2k: function(e) {
                return e + 273.15
            },
            c2f: function(e) {
                return 9 * e / 5 + 32
            },
            c2r: function(e) {
                return 9 * (e + 273.15) / 5
            },
            k2c: function(e) {
                return e - 273.15
            },
            k2f: function(e) {
                return 9 * e / 5 - 459.67
            },
            k2r: function(e) {
                return 9 * e / 5
            },
            f2c: function(e) {
                return 5 * (e - 32) / 9
            },
            f2k: function(e) {
                return 5 * (e + 459.67) / 9
            },
            f2r: function(e) {
                return e + 459.67
            },
            r2c: function(e) {
                return 5 * (e - 491.67) / 9
            },
            r2k: function(e) {
                return 5 * e / 9
            },
            r2f: function(e) {
                return e - 459.67
            }
        };
    ue.presetShort("temperature"), ba.temperature = function(e) {
        var t = ze({}, va, e.settings);
        return ze(e.settings, t, {
            sign: !0,
            convert: function(e, t, a) {
                return ga[t + "2" + a](e)
            }
        }), ba.measurement.call(this, e)
    };
    var xa = 1,
        Ta = function(e, t, a) {
            function n(e) {
                clearTimeout(v), v = setTimeout(function() {
                    i("load" !== e.type)
                }, 200)
            }

            function s(t, a) {
                if (t.length) {
                    if (a = k._onItemTap(t, a), l = t, t.parent()[0] == e) {
                        var n = t.offset().left,
                            s = t[0].offsetLeft,
                            r = t[0].offsetWidth,
                            i = c.offset().left;
                        g && (s = _ - s - r), "a" == y.variant ? n < i ? x.scroll(g ? s + r - h : -s, C, !0) : n + r > i + h && x.scroll(g ? s : h - s - r, C, !0) : x.scroll(h / 2 - s - r / 2, C, !0)
                    }
                    a && M("onItemTap", {
                        target: t[0]
                    })
                }
            }

            function r() {
                var e, t;
                k._initMarkup(c), D.find(".mbsc-ripple").remove(), 
                k._$items = D.children(), 
                k._$items.each(function(a) {
                    var n, s = Le(this),
                        r = s.attr("data-ref");
                    r || (r = xa++), 0 === a && (e = s), l || (l = k._getActiveItem(s)),
                    t = k._getItemProps(s) || {},
                    n = "mbsc-scv-item " + (t.cssClass || ""), 
                    s.attr("data-ref", r).removeClass(S[r]).addClass(n), S[r] = n
                }),
                l || (l = e),
                k._markupReady(c)
            }

            function i(t, a) {
                var n = y.itemWidth,
                    s = y.layout;
                k.contWidth = h = c.width(), t && p === h || !h || (p = h, d(s) && (f = h ? h / s : n) < n && (s = "liquid"), n && ("liquid" == s ? f = h ? h / Math.min(Math.floor(h / n), k._$items.length) : n : "fixed" == s && (f = n)), k._size(h, f), f && D.children().css("width", f + "px"), k.totalWidth = _ = e.offsetWidth, ze(x.settings, {
                    contSize: h,
                    maxSnapScroll: !!y.paging && 1,
                    maxScroll: 0,
                    minScroll: _ > h ? h - _ : 0,
                    snap: y.paging ? h : !!T && (f || ".mbsc-scv-item"),
                    elastic: _ > h && (f || h)
                }), x.refresh(a))
            }
            var l, c, m, u, h, f, p, v, g, x, T, y, _, w, M, S = {},
                C = 1e3,
                k = this,
                D = Le(e);
            je.call(this, e, t, !0), 
            k.navigate = function(e, t) {
                s(k._getItem(e), t)
            },
            k.next = function(e) {
                if (l) {
                    var t = l.next();
                    t.length && (l = t, s(l, e))
                }
            },
            k.prev = function(e) {
                if (l) {
                    var t = l.prev();
                    t.length && (l = t, s(l, e))
                }
            },
            k.refresh = k.position = function(e) {
                r(), i(!1, e)
            },
            k._init = function() {
                var e;
                if(y.itemWidth && y.snap == undefined){
                	y.snap = true;
                }
                m = Le(y.context), u = Le("body" == y.context ? window : y.context), k.__init(), 
                g = y.rtl, 
                T = y.snap, 
                e = "mbsc-scv-c mbsc-"+y.theme+" "+(y.cssClass || '') +" "+ (g ? 'mbsc-rtl':'') + " mbsc-ltr" + (k._getContClass() || ""), c ? (c.attr("class", e), D.off(".mbsc-ripple")) : (c = Le('<div class="' + e + '"><div class="mbsc-scv-sc"></div></div>').insertAfter(D), c.find(".mbsc-scv-sc").append(D), x = new it(c[0], {
                    axis: "X",
                    contSize: 0,
                    maxScroll: 0,
                    maxSnapScroll: 1,
                    minScroll: 0,
                    snap: 1,
                    elastic: 1,
                    rtl: g,
                    mousewheel: y.mousewheel,
                    thresholdX: y.threshold,
                    onStart: function(e) {
                        w || "touchstart" != e.domEvent.type || (w = !0, m.find(".mbsc-no-touch").removeClass("mbsc-no-touch"))
                    },
                    onBtnTap: function(e) {
                        "touchend" === e.domEvent.type && b(e.domEvent, e.target), s(Le(e.target), !0)
                    },
                    onGestureStart: function(e) {
                        M("onGestureStart", e)
                    },
                    onGestureEnd: function(e) {
                        M("onGestureEnd", e)
                    },
                    onMove: function(e) {
                        M("onMove", e)
                    },
                    onAnimationStart: function(e) {
                        M("onAnimationStart", e)
                    },
                    onAnimationEnd: function(e) {
                        M("onAnimationEnd", e)
                    }
                })), D.css("display", "").addClass("mbsc-scv"), r(), M("onMarkupReady", {
                    target: c[0]
                }), i(), c.find("img").on("load", n), u.on("orientationchange resize", n)
            }, k._size = o, k._initMarkup = o, k._markupReady = o, k._onItemTap = o, k._getContClass = o, k._getItemProps = o, k._getActiveItem = o, k.__init = o, k.__destroy = o, k._destroy = function() {
                k.__destroy(), u.off("orientationchange resize", n), D.removeClass("mbsc-scv").insertAfter(c).find(".mbsc-scv-item").each(function() {
                    var e = Le(this);
                    e.width("").removeClass(S[e.attr("data-ref")])
                }), c.remove(), x.destroy()
            }, k._getItem = function(e) {
                return "object" !== (void 0 === e ? "undefined" : he(e)) && (e = k._$items.filter('[data-id="' + e + '"]')), Le(e)
            }, y = k.settings, M = k.trigger, a || k.init(t)
        };
    Ta.prototype = {
        _class: "scrollview",
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _defaults: {
            tap: !0,
            context: "body",
            layout: "liquid"
        }
    }, 
    ue.classes.ScrollView = Ta,
    ue.presetShort("scrollview", "ScrollView");
    var ya = function(e, t, a) {
        function n() {
            l && "inline" != l && i.find(".mbsc-page").css("padding-" + l, "")
        }

        function s(e) {
            e.addClass(m).attr("data-selected", "true").attr("aria-selected", "true")
        }

        function r(e) {
            e.removeClass(m).removeAttr("data-selected").removeAttr("aria-selected")
        }
        var i, l, c, d, m, u, h = Le(e),
            f = this;
        Ta.call(this, e, t, !0),
        f.select = function(e) {
            c || r(f._$items.filter(".mbsc-ms-item-sel")), s(f._getItem(e))
        },
        f.deselect = function(e) {
            r(f._getItem(e))
        },
        f.enable = function(e) {
            f._getItem(e).removeClass("mbsc-btn-d mbsc-fr-btn-d").removeAttr("data-disabled").removeAttr("aria-disabled")
        },
        f.disable = function(e) {
            f._getItem(e).addClass("mbsc-btn-d mbsc-fr-btn-d").attr("data-disabled", "true").attr("aria-disabled", "true")
        },
        f.setBadge = function(e, t) {
            var a;
            e = f._getItem(e).attr("data-badge", t), a = Le(".mbsc-ms-badge", e), a.length ? t ? a.html(t) : a.remove() : t && e.append('<span class="mbsc-ms-badge">' + t + "</span>")
        },
        f._markupReady = function(e) {
            f._hasIcons ? e.addClass("mbsc-ms-icons") : e.removeClass("mbsc-ms-icons"), f._hasText ? e.addClass("mbsc-ms-txt") : e.removeClass("mbsc-ms-txt"), f.__markupReady(e)
        },
        f._size = function(t, a) {
            f.__size(t, a), "inline" != l && i.find(".mbsc-page").css("padding-" + l, e.offsetHeight + "px")
        },
        f._onItemTap = function(e, t) {
            return !1 !== f.__onItemTap(e, t) && (void 0 === t && (t = !c), d && t && !e.hasClass("mbsc-btn-d") && (c ? "true" == e.attr("data-selected") ? r(e) : s(e) : (r(f._$items.filter(".mbsc-ms-item-sel")), s(e))), t)
        },
        f._getActiveItem = function(e) {
            var t = "true" == e.attr("data-selected");
            if (d && !c && t) return e
        },
        f._getItemProps = function(e) {
            var t = "true" == e.attr("data-selected"),
                a = "true" == e.attr("data-disabled"),
                n = e.attr("data-icon"),
                s = e.attr("data-badge");
            return e.attr("data-role", "button").attr("aria-selected", t ? "true" : "false").attr("aria-disabled", a ? "true" : "false"), s && e.append('<span class="mbsc-ms-badge">' + s + "</span>"), n && (f._hasIcons = !0), e.text() && (f._hasText = !0), {
                cssClass: "mbsc-ms-item mbsc-btn-e " + (u.itemClass || "") + " " + (t ? m : "") + (a ? " mbsc-btn-d mbsc-fr-btn-d " + (u.disabledClass || "") : "") + (n ? " mbsc-ms-ic mbsc-ic mbsc-ic-" + n : "")
            }
        },
        f._getContClass = function() {
            return " mbsc-ms-c mbsc-ms-" + u.variant + " mbsc-ms-" + l + (d ? "" : " mbsc-ms-nosel") + (f.__getContClass() || "")
        },
        f.__init = function() {
            f.___init(), i = Le(u.context), n(), l = u.display, c = "multiple" == u.select, d = "off" != u.select, m = " mbsc-ms-item-sel " + (u.activeClass || ""), h.addClass("mbsc-ms mbsc-ms-base " + (u.groupClass || ""))
        },
        f.__destroy = function() {
            h.removeClass("mbsc-ms mbsc-ms-base " + (u.groupClass || "")), 
            n(),
            f.___destroy()
        },
        f.__onItemTap = o, 
        f.__getContClass = o, 
        f.__markupReady = o, 
        f.__size = o, 
        f.___init = o, 
        f.___destroy = o, 
        u = f.settings, a || f.init(t);
    };
    ya.prototype = {
        _defaults: ze({}, Ta.prototype._defaults)
    };
    var _a = function(e, t) {
        var a = this;
        ya.call(this, e, t, !0), a.___init = function() {}, a.settings, a.init(t)
    };
    _a.prototype = {
        _class: "optionlist",
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _defaults: ze({}, ya.prototype._defaults, {
            select: "multiple",
            variant: "a",
            display: "inline"
        })
    }, ue.classes.Optionlist = _a, ue.themes.optionlist = ue.themes.navigation, ue.presetShort("optionlist", "Optionlist");
    var wa = function(e, t) {
        var a, n, s, r, i, o = Le(e),
            l = o.is("ul,ol"),
            c = this;
        ya.call(this, e, t, !0), c._initMarkup = function() {
            a && a.remove(), n && o.append(n.children())
        }, c.__size = function(e, t) {
            var l, d = t || 72,
                m = c._$items.length,
                u = 0;
            i.hide(), "bottom" == r.type && (o.removeClass("mbsc-scv-liq"), a.remove(), c._$items.remove().each(function(a) {
                var s = Le(this);
                o.append(s), u += t || this.offsetWidth || 0, Math.round(u + (a < m - 1 ? d : 0)) > e && (l = !0, n.append(s.css("width", "").addClass("mbsc-fr-btn-e")))
            }), a.attr("class", s + (r.moreIcon ? " mbsc-menu-item-ic mbsc-ms-ic mbsc-ic mbsc-ic-" + r.moreIcon : "")).html(c._hasIcons && c._hasText ? r.moreText : ""), l && o.append(a)), "liquid" == r.layout && o.addClass("mbsc-scv-liq")
        }, c.__onItemTap = function(e) {
            if (e.hasClass("mbsc-menu-item")) return i.show(!1, !0), !1
        }, c.__getContClass = function() {
            return "hamburger" == r.type ? " mbsc-ms-hamburger" : ""
        }, c.__markupReady = function(e) {
            "hamburger" == r.type && (n.append(c._$items.addClass("mbsc-fr-btn-e")), a.attr("class", s + (r.menuIcon ? " mbsc-menu-item-ic mbsc-ms-ic mbsc-ic mbsc-ic-" + r.menuIcon : "")).html(r.menuText || ""), o.append(a), r.menuText && r.menuIcon || e.removeClass("mbsc-ms-icons"), r.menuText ? e.addClass("mbsc-ms-txt") : e.removeClass("mbsc-ms-txt"))
        }, c.___init = function() {
            "tab" == r.type ? (r.display = r.display || "top", r.variant = r.variant || "b") : "bottom" == r.type ? (r.display = r.display || "bottom", r.variant = r.variant || "a") : "hamburger" == r.type && (r.display = r.display || "inline", r.variant = r.variant || "a"), s = "mbsc-scv-item mbsc-ms-item mbsc-btn-e mbsc-menu-item " + (r.itemClass || ""), a || (a = Le(l ? "<li></li>" : "<div></div>"), n = Le(l ? "<ul></ul>" : "<div></div>").addClass("mbsc-scv mbsc-ms")), i = new kt(n[0], {
                display: "bubble",
                theme: r.theme,
                lang: r.lang,
                context: r.context,
                buttons: [],
                anchor: a,
                onBeforeShow: function(e, t) {
                    t.settings.cssClass = "mbsc-wdg mbsc-ms-a mbsc-ms-more" + (c._hasText ? "" : " mbsc-ms-more-icons")
                },
                onMarkupReady: function(e, t) {
                    c.tap(t._markup.find(".mbsc-fr-c"), function(e) {
                        var t = Le(e.target).closest(".mbsc-ms-item");
                        t.length && !t.hasClass("mbsc-btn-d") && (c.navigate(t, !0), i.hide())
                    })
                }
            })
        }, c.___destroy = function() {
            i.destroy(), o.append(c._$items), a.remove()
        }, r = c.settings, c.init(t)
    };
    wa.prototype = {
        _class: "navigation",
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _defaults: ze({}, ya.prototype._defaults, {
            type: "bottom",
            moreText: "More",
            moreIcon: "material-more-horiz",
            menuIcon: "material-menu"
        })
    }, ue.classes.Navigation = wa, ue.presetShort("nav", "Navigation"), ue.presets.scroller.number = ue.presets.scroller.measurement, ue.presetShort("number");
    var Ma = ue.presets.numpad,
        Sa = function(e, t, a) {
            function n(t) {
                var a, n = T.validate.call(e, {
                        values: V.slice(0),
                        variables: z
                    }, L) || [],
                    r = n && n.disabled || [];
                if (L._isValid = !n.invalid, L._tempValue = T.formatValue.call(e, V.slice(0), z, L), x = V.length, I = n.length || H, L._isVisible ) {
                    if (Le(".mbsc-np-ph", p).each(function(e) {
                            Le(this).html("ltr" == T.fill ? e >= x ? g : y || V[e] : e >= H - I ? e + x < H ? g : y || V[e + x - H] : "")
                        }), Le(".mbsc-np-cph", p).each(function() {
                            Le(this).html(z[Le(this).attr("data-var")] || Le(this).attr("data-ph"))
                        }), x === H)
                        for (a = 0; a <= 9; a++) r.push(a);
                    for (Le(".mbsc-np-btn", p).removeClass(b), a = 0; a < r.length; a++) Le('.mbsc-np-btn[data-val="' + r[a] + '"]', p).addClass(b);
                    L._isValid ? Le(".mbsc-fr-btn-s .mbsc-fr-btn", p).removeClass(b) : Le(".mbsc-fr-btn-s .mbsc-fr-btn", p).addClass(b), L.live && (L._hasValue = t || L._hasValue, s(t, !1, t), t && F("onSet", {
                        valueText: L._value
                    }))
                }
            }

            function s(e, t, a, s) {
                t && n(), s || (P = V.slice(0), j = ze({}, z), E = Y.slice(0), L._value = L._hasValue ? L._tempValue : null), e && (L._isInput && O.val(L._hasValue && L._isValid ? L._value : ""), F("onFill", {
                    valueText: L._hasValue ? L._tempValue : "",
                    change: a
                }), a && (L._preventChange = !0, O.trigger("change")))
            }

            function r(e) {
                var t, a, n = e || [],
                    s = [];
                for (Y = [], z = {}, t = 0; t < n.length; t++) /:/.test(n[t]) ? (a = n[t].split(":"), z[a[0]] = a[1], Y.push(a[0])) : (s.push(n[t]), Y.push("digit"));
                return s
            }

            function i(e, t) {
                !(x || t || T.allowLeadingZero) || e.hasClass("mbsc-fr-btn-d") || e.hasClass("mbsc-np-btn-empty") || x < H  && (Y.push("digit"), V.push(t), n(!0))
            }

            function o(e) {
                var t, a, s = e.attr("data-val"),
                    r = "false" !== e.attr("data-track"),
                    i = e.attr("data-var");
                if (!e.hasClass("mbsc-fr-btn-d")) {
                    if (i && (a = i.split(":"), r && Y.push(a[0]), z[a[0]] = void 0 === a[2] ? a[1] : z[a[0]] == a[1] ? a[2] : a[1]), s.length + x <= I)
                        for (t = 0; t < s.length; ++t) a = d(s[t]) ? +s[t] : s[t], (T.allowLeadingZero || x || a) && (Y.push("digit"), V.push(a), x = V.length);
                    n(!0)
                }
            }

            function l() {
                var e, t, a = Y.pop();
                if (x || "digit" !== a) {
                    if ("digit" !== a && z[a])
                        for (delete z[a], t = Y.slice(0), Y = [], e = 0; e < t.length; e++) t[e] !== a && Y.push(t[e]);
                    else V.pop();
                    n(!0)
                }
            }

            function c(e) {
                N = !0, _ = v(e, "X"), w = v(e, "Y"), clearInterval(A), clearTimeout(A), l(), A = setInterval(function() {
                    l()
                }, 150)
            }

            function m() {
                clearInterval(A), N = !1
            }

            function u(e) {
                if (C(e, this)) {
                    if ("keydown" == e.type && 32 != e.keyCode) return;
                    c(e), "mousedown" == e.type && Le(document).on("mousemove", h).on("mouseup", f)
                }
            }

            function h(e) {
                N && (M = v(e, "X"), S = v(e, "Y"), k = M - _, D = S - w, (Math.abs(k) > 7 || Math.abs(D) > 7) && m())
            }

            function f(e) {
                N && (e.preventDefault(), m(), "mouseup" == e.type && Le(document).off("mousemove", h).off("mouseup", f))
            }
            var p, b, g, x, T, y, _, w, M, S, k, D, N, A, V, I, F, H, P, O = Le(e),
                L = this,
                E = [],
                Y = [],
                z = {},
                j = {},
                W = {
                    107: "+",
                    109: "-"
                },
                $ = {
                    48: 0,
                    49: 1,
                    50: 2,
                    51: 3,
                    52: 4,
                    53: 5,
                    54: 6,
                    55: 7,
                    56: 8,
                    57: 9,
                    96: 0,
                    97: 1,
                    98: 2,
                    99: 3,
                    100: 4,
                    101: 5,
                    102: 6,
                    103: 7,
                    104: 8,
                    105: 9
                };
            st.call(this, e, t, !0), L.setVal = L._setVal = function(t, a, n, i) {
                L._hasValue = null !== t && void 0 !== t, V = r(Le.isArray(t) ? t.slice(0) : T.parseValue.call(e, t, L)), s(a, !0, void 0 === n ? a : n, i)
            }, L.getVal = L._getVal = function(e) {
                return L._hasValue || e ? L[e ? "_tempValue" : "_value"] : null
            }, L.setArrayVal = L.setVal, L.getArrayVal = function(e) {
                return e ? V.slice(0) : L._hasValue ? P.slice(0) : null
            }, L._readValue = function() {
                var t = O.val() || "";
                "" !== t && (L._hasValue = !0), y ? (z = {}, Y = [], V = []) : (z = L._hasValue ? j : {}, Y = L._hasValue ? E : [], V = L._hasValue && P ? P.slice(0) : r(T.parseValue.call(e, t, L)), s(!1, !0))
            }, L._fillValue = function() {
                L._hasValue = !0, s(!0, !1, !0)
            }, L._generateContent = function() {
                var e, t, a, n = 1,
                    s = "",
                    r = "";
                for (r += '<div class="mbsc-np-hdr"><div role="button" tabindex="0" aria-label="' + T.deleteText + '" class="mbsc-np-del mbsc-fr-btn-e mbsc-ic mbsc-ic-' + T.deleteIcon + '"></div><div class="mbsc-np-dsp">', s = T.template.replace(/d/g, '<span class="mbsc-np-ph">' + g + "</span>").replace(/&#100;/g, "d"), s = s.replace(/{([a-zA-Z0-9]*)\:?([a-zA-Z0-9\-\_]*)}/g, '<span class="mbsc-np-cph" data-var="$1" data-ph="$2">$2</span>'), r += s, r += "</div></div>", r += '<div class="mbsc-np-tbl-c mbsc-w-p"><div class="mbsc-np-tbl">', e = 0; e < 4; e++) {
                    for (r += '<div class="mbsc-np-row">', t = 0; t < 3; t++) a = n, 10 == n || 12 == n ? a = "" : 11 == n && (a = 0), "" === a ? 10 == n && T.leftKey ? r += '<div role="button" tabindex="0" class="mbsc-np-btn mbsc-np-btn-custom mbsc-fr-btn-e" ' + (T.leftKey.variable ? 'data-var="' + T.leftKey.variable + '"' : "") + ' data-val="' + (T.leftKey.value || "") + '" ' + (void 0 !== T.leftKey.track ? ' data-track="' + T.leftKey.track + '"' : "") + ">" + T.leftKey.text + "</div>" : 12 == n && T.rightKey ? r += '<div role="button" tabindex="0" class="mbsc-np-btn mbsc-np-btn-custom mbsc-fr-btn-e" ' + (T.rightKey.variable ? 'data-var="' + T.rightKey.variable + '"' : "") + ' data-val="' + (T.rightKey.value || "") + '" ' + (void 0 !== T.rightKey.track ? ' data-track="' + T.rightKey.track + '"' : "") + " >" + T.rightKey.text + "</div>" : r += '<div class="mbsc-np-btn mbsc-np-btn-empty"></div>' : r += '<div tabindex="0" role="button" class="mbsc-np-btn mbsc-fr-btn-e" data-val="' + a + '">' + a + "</div>", n++;
                    r += "</div>"
                }
                return r += "</div></div>"
            }, L._markupReady = function() {
                p = L._markup, n()
            }, L._attachEvents = function(e) {
                e.on("keydown", function(t) {
                    var a;
                    void 0 !== W[t.keyCode] ? (a = Le('.mbsc-np-btn[data-var="sign:-:"]', e), a.length && (z.sign = 107 == t.keyCode ? "-" : "", o(a))) : void 0 !== $[t.keyCode] ? i(Le('.mbsc-np-btn[data-val="' + $[t.keyCode] + '"]', e), $[t.keyCode]) : 8 == t.keyCode && (t.preventDefault(), l())
                }), L.tap(Le(".mbsc-np-btn", e), function() {
                    var e = Le(this);
                    e.hasClass("mbsc-np-btn-custom") ? o(e) : i(e, +e.attr("data-val"))
                }, !1, 30, !0), Le(".mbsc-np-del", e).on("touchstart mousedown keydown", u).on("touchmove mousemove", h).on("touchend mouseup keyup", f)
            }, L.__init = function() {
                T = L.settings, T.cssClass = (T.cssClass || "") + " mbsc-np", T.template = T.template.replace(/\\d/, "&#100;"), g = T.placeholder, H = (T.template.match(/d/g) || []).length, b = "mbsc-fr-btn-d " + (T.disabledClass || ""), y = T.mask, F = L.trigger, y && O.is("input") && O.attr("type", "password")
            }, L._indexOf = function(e, t) {
                var a;
                for (a = 0; a < e.length; ++a)
                    if (e[a].toString() === t.toString()) return a;
                return -1
            }, a || L.init(t)
        };
    Sa.prototype = {
        _hasDef: !0,
        _hasTheme: !0,
        _hasLang: !0,
        _hasPreset: !0,
        _class: "numpad",
        _defaults: ze({}, st.prototype._defaults, {
            template: "dd.dd",
            placeholder: "0",
            deleteIcon: "backspace",
            allowLeadingZero: !1,
            headerText: !1,
            fill: "rtl",
            deleteText: "Delete",
            decimalSeparator: ".",
            thousandsSeparator: ",",
            validate: o,
            parseValue: o,
            formatValue: function(e, t, a) {
                var n, s = 1,
                    r = a.settings,
                    i = r.placeholder,
                    o = r.template,
                    l = e.length,
                    c = o.length,
                    d = "";
                for (n = 0; n < c; n++) "d" == o[c - n - 1] ? (d = s <= l ? e[l - s] + d : i + d, s++) : d = o[c - n - 1] + d;
                return Le.each(t, function(e, t) {
                    d = d.replace("{" + e + "}", t)
                }), Le("<div>" + d + "</div>").text()
            }
        })
    }, ue.classes.Numpad = Sa, ue.themes.numpad = ue.themes.frame, ue.presetShort("numpad", "Numpad", !1);
    var Ca = {
        min: 0,
        max: 99.99,
        scale: 2,
        prefix: "",
        suffix: "",
        returnAffix: !1
    };
    Ma.decimal = function(e) {
        function t(e, t) {
            for (var a, n = e.slice(0), r = 0; n.length;) r = 10 * r + n.shift();
            for (a = 0; a < s.scale; a++) r /= 10;
            return t ? -1 * r : r
        }

        function a(e) {
            return t(e).toFixed(s.scale).replace(".", s.decimalSeparator).replace(/\B(?=(\d{3})+(?!\d))/g, s.thousandsSeparator)
        }
        var n = ze({}, e.settings),
            s = ze(e.settings, Ca, n),
            r = s.min < 0;
        return e.getVal = function(t) {
            var a = e._getVal(t),
                n = (a + "").replace(s.decimalSeparator, ".").replace(s.thousandsSeparator, "");
            return d(n) ? +n : a
        }, {
            template: (r ? "{sign}" : "") + s.prefix.replace(/d/g, "\\d") + Array((Math.floor(Math.max(s.max, Math.abs(s.min))) + "").length + 1).join("d") + (s.scale ? "." + Array(s.scale + 1).join("d") : "") + s.suffix.replace(/d/g, "\\d"),
            leftKey: r ? {
                text: "-/+",
                variable: "sign:-:",
                track: !1
            } : void 0,
            parseValue: function(e) {
                var t, a, n = e || s.defaultValue,
                    r = [];
                if (n && (n = (n + "").replace(s.decimalSeparator, ".").replace(s.thousandsSeparator, ""), a = n.match(/\d+\.?\d*/g)))
                    for (a = (+a[0]).toFixed(s.scale), t = 0; t < a.length; t++) "." != a[t] && (+a[t] ? r.push(+a[t]) : r.length && r.push(0));
                return e < 0 && r.push("sign:-"), r
            },
            formatValue: function(e, n) {
                var r = a(e);
                return (t(e, n && "-" == n.sign) < 0 ? "-" : "") + (s.returnAffix ? s.prefix + r + s.suffix : r)
            },
            validate: function(n) {
                var r = n.values,
                    i = a(r),
                    o = t(r, n.variables && "-" == n.variables.sign),
                    l = [];
                return r.length || s.allowLeadingZero || l.push(0), e.isVisible() && Le(".mbsc-np-dsp", e._markup).html((n.variables.sign || "") + s.prefix + i + s.suffix), {
                    disabled: l,
                    invalid: o > s.max || o < s.min || !!s.invalid && -1 != e._indexOf(s.invalid, o)
                }
            }
        }
    };
    var ka = ["h", "m", "s"],
        Da = {
            min: 0,
            max: 362439,
            defaultValue: 0,
            hourTextShort: "h",
            minuteTextShort: "m",
            secTextShort: "s"
        };
    Ma.timespan = function(e) {
        function t(e) {
            var t, a = "",
                n = 3600;
            return Le(ka).each(function(r, i) {
                t = Math.floor(e / n), e -= t * n, n /= 60, (t > 0 || "s" == i && !a) && (a = a + (a ? " " : "") + t + s[i])
            }), a
        }
        var a = ze({}, e.settings),
            n = ze(e.settings, Da, a),
            s = {
                h: n.hourTextShort.replace(/d/g, "\\d"),
                m: n.minuteTextShort.replace(/d/g, "\\d"),
                s: n.secTextShort.replace(/d/g, "\\d")
            },
            r = 'd<span class="mbsc-np-sup mbsc-np-time">' + s.s + "</span>";
        return n.max > 9 && (r = "d" + r), n.max > 99 && (r = '<span class="mbsc-np-ts-m">' + (n.max > 639 ? "d" : "") + 'd</span><span class="mbsc-np-sup mbsc-np-time">' + s.m + "</span>" + r), n.max > 6039 && (r = '<span class="mbsc-np-ts-h">' + (n.max > 38439 ? "d" : "") + 'd</span><span class="mbsc-np-sup mbsc-np-time">' + s.h + "</span>" + r), e.setVal = function(a, n, s, r) {
            return d(a) && (a = t(a)), e._setVal(a, n, s, r)
        }, e.getVal = function(t) {
            return e._hasValue || t ? re(e.getArrayVal(t)) : null
        }, {
            template: r,
            parseValue: function(e) {
                var a, r = e || t(n.defaultValue),
                    i = [];
                return r && Le(ka).each(function(e, t) {
                    a = new RegExp("(\\d+)" + s[t], "gi").exec(r), a ? (a = +a[1], a > 9 ? (i.push(Math.floor(a / 10)), i.push(a % 10)) : (i.length && i.push(0), (a || i.length) && i.push(a))) : i.length && (i.push(0), i.push(0))
                }), i
            },
            formatValue: function(e) {
                return t(re(e))
            },
            validate: function(t) {
                var a = t.values,
                    s = re(a.slice(0)),
                    r = [];
                return a.length || r.push(0), {
                    disabled: r,
                    invalid: s > n.max || s < n.min || !!n.invalid && -1 != e._indexOf(n.invalid, +s)
                }
            }
        }
    };
    var Na = {
        timeFormat: "hh:ii A",
        amText: "am",
        pmText: "pm"
    };
    Ma.time = function(e) {
        function t(e, t) {
            var a, n = "";
            for (a = 0; a < e.length; ++a) n += e[a] + (a % 2 == (e.length % 2 == 1 ? 0 : 1) && a != e.length - 1 ? ":" : "");
            return Le.each(t, function(e, t) {
                n += " " + t
            }), n
        }

        function a(e) {
            var t, a, n, o, l, b, v, g, x, T, y = [],
                _ = 2 * r.length;
            if (c = _, e.length || (i && (y.push(0), y.push(s.leftKey.value)), y.push(s.rightKey.value)), !i && (_ - e.length < 2 || 1 != e[0] && (e[0] > 2 || e[1] > 3) && _ - e.length <= 2) && (y.push("30"), y.push("00")), (i ? e[0] > 1 || e[1] > 2 : 1 != e[0] && (e[0] > 2 || e[1] > 3)) && e[0] && (e.unshift(0), c = _ - 1), e.length == _)
                for (t = 0; t <= 9; ++t) y.push(t);
            else if (1 == e.length && i && 1 == e[0] || e.length && e.length % 2 == 0 || !i && 2 == e[0] && e[1] > 3 && e.length % 2 == 1)
                for (t = 6; t <= 9; ++t) y.push(t);
            if (x = void 0 !== e[1] ? "" + e[0] + e[1] : "", T = +h == +(void 0 !== e[3] ? "" + e[2] + e[3] : ""), s.invalid)
                for (t = 0; t < s.invalid.length; ++t)
                    if (b = s.invalid[t].getHours(), v = s.invalid[t].getMinutes(), g = s.invalid[t].getSeconds(), b == +x) {
                        if (2 == r.length && (v < 10 ? 0 : +("" + v)[0]) == +e[2]) {
                            y.push(v < 10 ? v : +("" + v)[1]);
                            break
                        }
                        if ((g < 10 ? 0 : +("" + g)[0]) == +e[4]) {
                            y.push(g < 10 ? g : +("" + g)[1]);
                            break
                        }
                    }
            if (s.min || s.max) {
                if (a = +d == +x, n = +m == +x, l = n && T, o = a && T, 0 === e.length) {
                    for (t = i ? 2 : d > 19 ? d[0] : 3; t <= (1 == d[0] ? 9 : d[0] - 1); ++t) y.push(t);
                    if (d >= 10 && (y.push(0), 2 == d[0]))
                        for (t = 3; t <= 9; ++t) y.push(t);
                    if (m && m < 10 || d && d >= 10)
                        for (t = m && m < 10 ? +m[0] + 1 : 0; t < (d && d >= 10 ? d[0] : 10); ++t) y.push(t)
                }
                if (1 == e.length) {
                    if (0 === e[0])
                        for (t = 0; t < d[0]; ++t) y.push(t);
                    if (d && 0 !== e[0] && (i ? 1 == e[0] : 2 == e[0]))
                        for (t = i ? 3 : 4; t <= 9; ++t) y.push(t);
                    if (e[0] == d[0])
                        for (t = 0; t < d[1]; ++t) y.push(t);
                    if (e[0] == m[0] && !i)
                        for (t = +m[1] + 1; t <= 9; ++t) y.push(t)
                }
                if (2 == e.length && (a || n))
                    for (t = n ? +h[0] + 1 : 0; t < (a ? +u[0] : 10); ++t) y.push(t);
                if (3 == e.length && (n && e[2] == h[0] || a && e[2] == u[0]))
                    for (t = n && e[2] == h[0] ? +h[1] + 1 : 0; t < (a && e[2] == u[0] ? +u[1] : 10); ++t) y.push(t);
                if (4 == e.length && (o || l))
                    for (t = l ? +p[0] + 1 : 0; t < (o ? +f[0] : 10); ++t) y.push(t);
                if (5 == e.length && (o && e[4] == f[0] || l && e[4] == p[0]))
                    for (t = l && e[4] == p[0] ? +p[1] + 1 : 0; t < (o && e[4] == f[0] ? +f[1] : 10); ++t) y.push(t)
            }
            return y
        }
        var n = ze({}, e.settings),
            s = ze(e.settings, Na, n),
            r = s.timeFormat.split(":"),
            i = s.timeFormat.match(/a/i),
            o = i ? "a" == i[0] ? s.amText : s.amText.toUpperCase() : "",
            l = i ? "a" == i[0] ? s.pmText : s.pmText.toUpperCase() : "",
            c = 0,
            d = s.min ? "" + s.min.getHours() : "",
            m = s.max ? "" + s.max.getHours() : "",
            u = s.min ? "" + (s.min.getMinutes() < 10 ? "0" + s.min.getMinutes() : s.min.getMinutes()) : "",
            h = s.max ? "" + (s.max.getMinutes() < 10 ? "0" + s.max.getMinutes() : s.max.getMinutes()) : "",
            f = s.min ? "" + (s.min.getSeconds() < 10 ? "0" + s.min.getSeconds() : s.min.getSeconds()) : "",
            p = s.max ? "" + (s.max.getSeconds() < 10 ? "0" + s.max.getSeconds() : s.max.getSeconds()) : "";
        return s.min && s.min.setFullYear(2014, 7, 20), s.max && s.max.setFullYear(2014, 7, 20), {
            placeholder: "-",
            allowLeadingZero: !0,
            template: (3 == r.length ? "dd:dd:dd" : 2 == r.length ? "dd:dd" : "dd") + (i ? '<span class="mbsc-np-sup">{ampm:--}</span>' : ""),
            leftKey: i ? {
                text: o,
                variable: "ampm:" + o,
                value: "00"
            } : {
                text: ":00",
                value: "00"
            },
            rightKey: i ? {
                text: l,
                variable: "ampm:" + l,
                value: "00"
            } : {
                text: ":30",
                value: "30"
            },
            parseValue: function(e) {
                var t, a, n = e || s.defaultValue,
                    r = [];
                if (n) {
                    if (n += "", a = n.match(/\d/g))
                        for (t = 0; t < a.length; t++) r.push(+a[t]);
                    i && r.push("ampm:" + (n.match(new RegExp(s.pmText, "gi")) ? l : o))
                }
                return r
            },
            formatValue: function(e, a) {
                return t(e, a)
            },
            validate: function(n) {
                var r = n.values,
                    o = n.variables,
                    l = t(r, o),
                    d = r.length >= 3 ? new Date(2014, 7, 20, "" + r[0] + (r.length % 2 == 0 ? r[1] : ""), "" + r[r.length % 2 == 0 ? 2 : 1] + r[r.length % 2 == 0 ? 3 : 2]) : "";
                return {
                    disabled: a(r),
                    length: c,
                    invalid: (i ? !new RegExp("^(0?[1-9]|1[012])(:[0-5]\\d)?(:[0-5][0-9]) (?:" + s.amText + "|" + s.pmText + ")$", "i").test(l) : !/^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$/.test(l)) || !!s.invalid && -1 != e._indexOf(s.invalid, d) || !((!s.min || s.min <= d) && (!s.max || d <= s.max))
                }
            }
        }
    };
    var Aa = {
        dateOrder: "mdy",
        dateFormat: "mm/dd/yy",
        delimiter: "/"
    };
    Ma.date = function(e) {
        function t(e) {
            return e % 4 == 0 && e % 100 != 0 || e % 400 == 0
        }

        function a(e) {
            var a, n, o, l, c, m = [],
                g = void 0 !== e[s + 3] ? "" + e[s] + e[s + 1] + e[s + 2] + e[s + 3] : "",
                x = void 0 !== e[r + 1] ? "" + e[r] + e[r + 1] : "",
                T = void 0 !== e[i + 1] ? "" + e[i] + e[i + 1] : "",
                y = "" + d.getMaxDayOfMonth(g || 2012, x - 1 || 0),
                _ = b === g && +u == +x,
                w = v === g && +h == +x;
            if (d.invalid)
                for (a = 0; a < d.invalid.length; ++a) {
                    if (o = d.getYear(d.invalid[a]), l = d.getMonth(d.invalid[a]), c = d.getDay(d.invalid[a]), o == +g && l + 1 == +x && (c < 10 ? 0 : +("" + c)[0]) == +e[i]) {
                        m.push(c < 10 ? c : +("" + c)[1]);
                        break
                    }
                    if (l + 1 == +x && c == +T && ("" + o).substring(0, 3) == "" + e[s] + e[s + 1] + e[s + 2]) {
                        m.push(("" + o)[3]);
                        break
                    }
                    if (o == +g && c == +T && (l < 10 ? 0 : +("" + (l + 1))[0]) == +e[r]) {
                        m.push(l < 10 ? l : +("" + (l + 1))[1]);
                        break
                    }
                }
            if ("31" != T || e.length != r && e.length != r + 1 || (1 != e[r] ? m.push(2, 4, 6, 9, 11) : m.push(1)), "30" == T && 0 === e[r] && e.length <= r + 1 && m.push(2), e.length == r) {
                for (a = v === g && +h < 10 ? 1 : 2; a <= 9; ++a) m.push(a);
                b === g && +u >= 10 && m.push(0)
            }
            if (e.length == r + 1) {
                if (1 == e[r]) {
                    for (a = v === g ? +h[1] + 1 : 3; a <= 9; ++a) m.push(a);
                    if (b == g)
                        for (a = 0; a < +u[1]; ++a) m.push(a)
                }
                if (0 === e[r] && (m.push(0), v === g || b === g))
                    for (a = v === g ? +T > +p ? +h : +h + 1 : 0; a <= (b === g ? +u - 1 : 9); ++a) m.push(a)
            }
            if (e.length == i) {
                for (a = w ? 1 + (+p > 10 ? +p[0] : 0) : +y[0] + 1; a <= 9; ++a) m.push(a);
                if (_)
                    for (a = 0; a < (+f < 10 ? 0 : f[0]); ++a) m.push(a)
            }
            if (e.length == i + 1) {
                if (e[i] >= 3 || "02" == x)
                    for (a = +y[1] + 1; a <= 9; ++a) m.push(a);
                if (w && +p[0] == e[i])
                    for (a = +p[1] + 1; a <= 9; ++a) m.push(a);
                if (_ && f[0] == e[i])
                    for (a = 0; a < +f[1]; ++a) m.push(a);
                if (0 === e[i] && (m.push(0), w || _))
                    for (a = w ? +p + 1 : 1; a <= (_ ? +f - 1 : 9); ++a) m.push(a)
            }
            if (void 0 !== e[s + 2] && "02" == x && "29" == T)
                for (n = +("" + e[s] + e[s + 1] + e[s + 2] + 0); n <= +("" + e[s] + e[s + 1] + e[s + 2] + 9); ++n) m.push(t(n) ? "" : n % 10);
            if (e.length == s) {
                if (d.min)
                    for (a = 0; a < +b[0]; ++a) m.push(a);
                if (d.max)
                    for (a = +v[0] + 1; a <= 9; ++a) m.push(a);
                m.push(0)
            }
            if (d.min || d.max)
                for (n = 1; n < 4; ++n)
                    if (e.length == s + n) {
                        if (e[s + n - 1] == +b[n - 1] && (3 != n || e[s + n - 2] == +b[n - 2]))
                            for (a = 0; a < +b[n] + (3 == n && e[r + 1] && +u > +x ? 1 : 0); ++a) m.push(a);
                        if (e[s + n - 1] == +v[n - 1] && (3 != n || e[s + n - 2] == +v[n - 2]))
                            for (a = +v[n] + (3 == n && +h < +x ? 0 : 1); a <= 9; ++a) m.push(a)
                    }
            return m
        }

        function n(e) {
            return new Date(+("" + e[s] + e[s + 1] + e[s + 2] + e[s + 3]), +("" + e[r] + e[r + 1]) - 1, +("" + e[i] + e[i + 1]))
        }
        var s, r, i, o, l = [],
            c = ze({}, e.settings),
            d = ze(e.settings, We, Aa, c),
            m = d.dateOrder,
            u = d.min ? "" + (d.getMonth(d.min) + 1) : 0,
            h = d.max ? "" + (d.getMonth(d.max) + 1) : 0,
            f = d.min ? "" + d.getDay(d.min) : 0,
            p = d.max ? "" + d.getDay(d.max) : 0,
            b = d.min ? "" + d.getYear(d.min) : 0,
            v = d.max ? "" + d.getYear(d.max) : 0;
        for (m = m.replace(/y+/gi, "yyyy"), m = m.replace(/m+/gi, "mm"), m = m.replace(/d+/gi, "dd"), s = m.toUpperCase().indexOf("Y"), r = m.toUpperCase().indexOf("M"), i = m.toUpperCase().indexOf("D"), m = "", l.push({
                val: s,
                n: "yyyy"
            }, {
                val: r,
                n: "mm"
            }, {
                val: i,
                n: "dd"
            }), l.sort(function(e, t) {
                return e.val - t.val
            }), Le.each(l, function(e, t) {
                m += t.n
            }), s = m.indexOf("y"), r = m.indexOf("m"), i = m.indexOf("d"), m = "", o = 0; o < 8; ++o) m += "d", o + 1 != s && o + 1 != r && o + 1 != i || (m += d.delimiter);
        return e.getVal = function(t) {
            return e._hasValue || t ? n(e.getArrayVal(t)) : null
        }, {
            placeholder: "-",
            fill: "ltr",
            allowLeadingZero: !0,
            template: m,
            parseValue: function(e) {
                var t, a = [],
                    n = e || d.defaultValue,
                    s = M(d.dateFormat, n, d);
                if (n)
                    for (t = 0; t < l.length; ++t) a = /m/i.test(l[t].n) ? a.concat(((d.getMonth(s) < 9 ? "0" : "") + (d.getMonth(s) + 1)).split("")) : /d/i.test(l[t].n) ? a.concat(((d.getDay(s) < 10 ? "0" : "") + d.getDay(s)).split("")) : a.concat((d.getYear(s) + "").split(""));
                return a
            },
            formatValue: function(e) {
                return w(d.dateFormat, n(e), d)
            },
            validate: function(t) {
                var s = t.values,
                    r = n(s);
                return {
                    disabled: a(s),
                    invalid: !("Invalid Date" != r && (!d.min || d.min <= r) && (!d.max || r <= d.max)) || !!d.invalid && -1 != e._indexOf(d.invalid, r)
                }
            }
        }
    };
    var Va = {
        autoCorrect: !0,
        showSelector: !0,
        minRange: 1,
        rangeTap: !0,
        fromText: "Start",
        toText: "End"
    };
    ue.presetShort("range"), ue.presets.scroller.range = function(e) {
        function t(e, t) {
            e && (e.setFullYear(t.getFullYear()), e.setMonth(t.getMonth()), e.setDate(t.getDate()))
        }

        function a(t) {
            e._startDate = D = v, e._endDate = N = x, F.startInput && (Le(F.startInput).val(p), t && Le(F.startInput).trigger("change")), F.endInput && (Le(F.endInput).val(b), t && Le(F.endInput).trigger("change"))
        }

        function n(e, t) {
            var a = !0;
            return e && v && x && (x - v > F.maxRange - 1 && (A ? v = new Date(x - F.maxRange + 1) : x = new Date(+v + F.maxRange - 1)), x - v < F.minRange - 1 && (A ? v = new Date(x - F.minRange + 1) : x = new Date(+v + F.minRange - 1))), v && x || (a = !1), t && o(), a
        }

        function s() {
            return v && x ? Math.max(1, Math.round((new Date(x).setHours(0, 0, 0, 0) - new Date(v).setHours(0, 0, 0, 0)) / 864e5) + 1) : 0
        }

        function r(e) {
            e.addClass(L).attr("aria-checked", "true")
        }

        function i() {
            k && d && (Le(".mbsc-range-btn", d).removeClass(L).removeAttr("aria-checked"), r(Le(".mbsc-range-btn", d).eq(A)))
        }

        function o() {
            var e, t, a, n, s, r = 0,
                i = P || !A ? " mbsc-cal-day-hl mbsc-cal-sel-start" : " mbsc-cal-sel-start",
                o = P || A ? " mbsc-cal-day-hl mbsc-cal-sel-end" : " mbsc-cal-sel-end";
            if (p = v ? w(u, v, F) : "", b = x ? w(u, x, F) : "", d && (Le(".mbsc-range-btn-v-start", d).html(p || "&nbsp;"), Le(".mbsc-range-btn-v-end", d).html(b || "&nbsp;"), e = v ? new Date(v) : null, a = x ? new Date(x) : null, !e && a && (e = new Date(a)), !a && e && (a = new Date(e)), s = A ? a : e, Le(".mbsc-cal-day-picker .mbsc-cal-day-hl", d).removeClass(E), Le(".mbsc-cal-day-picker .mbsc-selected", d).removeClass("mbsc-cal-sel-start mbsc-cal-sel-end " + L).removeAttr("aria-selected"), e && a))
                for (t = e.setHours(0, 0, 0, 0), n = a.setHours(0, 0, 0, 0); a >= e && r < 84;) Le('.mbsc-cal-day[data-full="' + s.getFullYear() + "-" + (s.getMonth() + 1) + "-" + s.getDate() + '"]', d).addClass(L + " " + (s.getTime() === t ? i : "") + (s.getTime() === n ? o : "")).attr("aria-selected", "true"), s.setDate(s.getDate() + (A ? -1 : 1)), r++
        }

        function l(e, t) {
            return {
                h: e ? e.getHours() : t ? 23 : 0,
                i: e ? e.getMinutes() : t ? 59 : 0,
                s: e ? e.getSeconds() : t ? 59 : 0
            }
        }
        var c, d, m, u, h, f, p, b, v, g, x, T, y, _, S, k, D = e._startDate,
            N = e._endDate,
            A = 0,
            V = new Date,
            I = ze({}, e.settings),
            F = ze(e.settings, Va, I),
            H = F.anchor,
            P = F.rangeTap,
            O = "mbsc-fr-btn-d " + (F.disabledClass || ""),
            L = "mbsc-selected " + (F.selectedClass || ""),
            E = "mbsc-cal-day-hl",
            Y = null === F.defaultValue ? [] : F.defaultValue || [new Date(V.setHours(0, 0, 0, 0)), new Date(V.getFullYear(), V.getMonth(), V.getDate() + 6, 23, 59, 59, 999)];
        return P && (F.tabs = !0), c = ft.call(this, e), u = e._format, y = "time" === F.controls.join(""), k = 1 != F.controls.length || "calendar" != F.controls[0] || F.showSelector, F.startInput && (_ = Le(F.startInput).prop("readonly"), e.attachShow(Le(F.startInput).prop("readonly", !0), function() {
            A = 0, F.anchor = H || Le(F.startInput)
        })), F.endInput && (S = Le(F.endInput).prop("readonly"), e.attachShow(Le(F.endInput).prop("readonly", !0), function() {
            A = 1, F.anchor = H || Le(F.endInput)
        })), e._getDayProps = function(e) {
            var t = v ? new Date(v.getFullYear(), v.getMonth(), v.getDate()) : null,
                a = x ? new Date(x.getFullYear(), x.getMonth(), x.getDate()) : null;
            return {
                selected: t && a && e >= t && e <= x,
                cssClass: ((P || !A) && t && t.getTime() === e.getTime() || (P || A) && a && a.getTime() === e.getTime() ? E : "") + (t && t.getTime() === e.getTime() ? " mbsc-cal-sel-start" : "") + (a && a.getTime() === e.getTime() ? " mbsc-cal-sel-end" : "")
            }
        }, e.setVal = function(t, a, n, s, r) {
            var i = t || [],
                o = t;
            (void 0 === i[0] || null === i[0] || i[0].getTime) && (f = !0, v = i[0] || null, p = v ? w(u, v, F) : "", A || (o = c.parseValue(p, e))), (void 0 === i[1] || null === i[1] || i[1].getTime) && (f = !0, x = i[1] || null, b = x ? w(u, x, F) : "", A && (o = c.parseValue(b, e))), s || (e._startDate = D = v, e._endDate = N = x), e._setVal(o, a, n, s, r)
        }, e.getVal = function(t) {
            return t ? [v, x] : e._hasValue ? [D, N] : null
        }, e.setActiveDate = function(t) {
            var a;
            A = "start" == t ? 0 : 1, a = "start" == t ? v : x, e.isVisible() && (i(), P || (Le(".mbsc-cal-table .mbsc-cal-day-hl", d).removeClass(E), a && Le('.mbsc-cal-day[data-full="' + a.getFullYear() + "-" + (a.getMonth() + 1) + "-" + a.getDate() + '"]', d).addClass(E)), a && (h = !0, e.setDate(a, !1, 1e3, !0)))
        }, e.getValue = e.getVal, ze({}, c, {
            highlight: !1,
            outerMonthChange: !1,
            formatValue: function() {
                return p + (F.endInput ? "" : b ? " - " + b : "")
            },
            parseValue: function(t) {
                var a = t ? t.split(" - ") : [];
                return F.defaultValue = Y[1], N = F.endInput ? Le(F.endInput).val() ? M(u, Le(F.endInput).val(), F) : Y[1] : a[1] ? M(u, a[1], F) : Y[1], F.defaultValue = Y[0], D = F.startInput ? Le(F.startInput).val() ? M(u, Le(F.startInput).val(), F) : Y[0] : a[0] ? M(u, a[0], F) : Y[0], F.defaultValue = Y[A], p = D ? w(u, D, F) : "", b = N ? w(u, N, F) : "", e._startDate = D, e._endDate = N, c.parseValue(A ? b : p, e)
            },
            onFill: function(e) {
                a(e.change)
            },
            onBeforeClose: function(t) {
                if ("set" === t.button && !n(!0, !0)) return e.setActiveDate(A ? "start" : "end"), !1
            },
            onHide: function() {
                c.onHide.call(e), A = 0, d = null, F.anchor = H
            },
            onClear: function() {
                P && (A = 0)
            },
            onBeforeShow: function() {
                F.headerText = !1, v = D || Y[0], x = N || Y[1], g = l(v, 0), T = l(x, 1), F.counter && (F.headerText = function() {
                    var e = s();
                    return (e > 1 ? F.selectedPluralText || F.selectedText : F.selectedText).replace(/{count}/, e)
                }), f = !0
            },
            onMarkupReady: function(t) {
                var a;
                v && (h = !0, e.setDate(v, !1, 0, !0), v = e.getDate(!0)), x && (h = !0, e.setDate(x, !1, 0, !0), x = e.getDate(!0)), (A && x || !A && v) && (h = !0, e.setDate(A ? x : v, !1, 0, !0)), o(), c.onMarkupReady.call(this, t), d = Le(t.target), d.addClass("mbsc-range"), k && (a = '<div class="mbsc-range-btn-t" role="radiogroup"><div class="mbsc-range-btn-c mbsc-range-btn-start"><div role="radio" data-select="start" class="mbsc-fr-btn-e mbsc-fr-btn-nhl mbsc-range-btn">' + F.fromText + '<div class="mbsc-range-btn-v mbsc-range-btn-v-start">' + (p || "&nbsp;") + '</div></div></div><div class="mbsc-range-btn-c mbsc-range-btn-end"><div role="radio" data-select="end" class="mbsc-fr-btn-e mbsc-fr-btn-nhl mbsc-range-btn">' + F.toText + '<div class="mbsc-range-btn-v mbsc-range-btn-v-end">' + (b || "&nbsp;") + "</div></div></div></div>", Le(F.headerText ? ".mbsc-fr-hdr" : ".mbsc-fr-aria", d).after(a), i()), Le(".mbsc-range-btn", d).on("touchstart click", function(t) {
                    C(t, this) && (e._showDayPicker(), e.setActiveDate(Le(this).attr("data-select")))
                })
            },
            onDayChange: function(e) {
                e.active = A ? "end" : "start", m = !0
            },
            onSetDate: function(a) {
                var s = a.date,
                    r = e._order;
                h || (void 0 === r.h && s.setHours(A ? 23 : 0), void 0 === r.i && s.setMinutes(A ? 59 : 0), void 0 === r.s && s.setSeconds(A ? 59 : 0), s.setMilliseconds(A ? 999 : 0), f && !m || (P && m && (1 == A && s < v && (A = 0), A ? s.setHours(T.h, T.i, T.s, 999) : s.setHours(g.h, g.i, g.s, 0)), A ? (x = new Date(s), T = l(x)) : (v = new Date(s), g = l(v)), y && F.autoCorrect && (t(v, s), t(x, s)), P && m && !A && (x = null))), y && !F.autoCorrect && x < v && (x = new Date(x.setDate(x.getDate() + 1))), e._isValid = n(f || m || F.autoCorrect, !h), a.active = A ? "end" : "start", !h && P && (m && (A = A ? 0 : 1), i()), e.isVisible() && (e._isValid ? Le(".mbsc-fr-btn-s .mbsc-fr-btn", e._markup).removeClass(O) : Le(".mbsc-fr-btn-s .mbsc-fr-btn", e._markup).addClass(O)), m = !1, f = !1, h = !1
            },
            onTabChange: function(t) {
                "calendar" != t.tab && e.setDate(A ? x : v, !1, 1e3, !0), n(!0, !0)
            },
            onDestroy: function() {
                Le(F.startInput).prop("readonly", _), Le(F.endInput).prop("readonly", S)
            }
        })
    };
    var Ia = 0;
    ue.util.getJson = le;
    var Fa = {
        inputClass: "",
        invalid: [],
        rtl: !1,
        showInput: !0,
        groupLabel: "Groups",
        dataHtml: "html",
        dataText: "text",
        dataValue: "value",
        dataGroup: "group",
        dataDisabled: "disabled",
        filterPlaceholderText: "Type to filter",
        filterEmptyText: "No results",
        filterClearIcon: "material-close"
    };
    ue.presetShort("select"), ue.presets.scroller.select = function(e) {
        function t(e) {
            var t, a, n, s, r, i, o = 0,
                l = 0,
                c = {};
            if (Y = {}, C = {}, A = [], S = [], ee.length = 0, B) Le.each(T, function(o, d) {
                r = d[O.dataText], a = d[O.dataHtml], i = d[O.dataValue], n = d[O.dataGroup], s = {
                    value: i,
                    html: a,
                    text: r,
                    index: o
                }, Y[i] = s, e && !b(r, e) || (A.push(s), U && (void 0 === c[n] ? (t = {
                    text: n,
                    value: l,
                    options: [],
                    index: l
                }, C[l] = t, c[n] = l, S.push(t), l++) : t = C[c[n]], X && (s.index = t.options.length), s.group = c[n], t.options.push(s)), d[O.dataDisabled] && ee.push(i))
            });
            else if (U) {
                var d = !0;
                Le("optgroup", H).each(function(t) {
                    C[t] = {
                        text: this.label,
                        value: t,
                        options: [],
                        index: t
                    }, d = !0, Le("option", this).each(function(a) {
                        s = {
                            value: this.value,
                            text: this.text,
                            index: X ? a : o++,
                            group: t
                        }, Y[this.value] = s, e && !b(this.text, e) || (d && (S.push(C[t]), d = !1), A.push(s), C[t].options.push(s), this.disabled && ee.push(this.value))
                    })
                })
            } else Le("option", H).each(function(t) {
                s = {
                    value: this.value,
                    text: this.text,
                    index: t
                }, Y[this.value] = s, e && !b(this.text, e) || (A.push(s), this.disabled && ee.push(this.value))
            });
            O.defaultValue ? y = O.defaultValue : A.length && (y = A[0].value), Z && (A = [], o = 0, Le.each(C, function(e, t) {
                t.options.length && (i = "__group" + e, s = {
                    text: t.text,
                    value: i,
                    group: e,
                    index: o++,
                    cssClass: "mbsc-sel-gr"
                }, Y[i] = s, A.push(s), ee.push(s.value), Le.each(t.options, function(e, t) {
                    t.index = o++, A.push(t)
                }))
            })), L && (A.length ? L.removeClass("mbsc-sel-empty-v") : L.addClass("mbsc-sel-empty-v"))
        }

        function a(e, t, a) {
            var n, s = [];
            for (n = 0; n < e.length; n++) s.push({
                value: e[n].value,
                display: e[n].html || e[n].text,
                cssClass: e[n].cssClass
            });
            return {
                circular: !1,
                multiple: t,
                data: s,
                label: a
            }
        }

        function n() {
            return a(S, !1, O.groupLabel)
        }

        function s() {
            return a(X ? C[M].options : A, $, K)
        }

        function r() {
            var e, t, a = [
                []
            ];
            return G && (e = n(), j ? a[0][k] = e : a[k] = [e]), t = s(), j ? a[0][V] = t : a[V] = [t], a
        }

        function i(e) {
            W && (e && m(e) && (e = e.split(",")), Le.isArray(e) && (e = e[0])), N = void 0 === e || null === e || "" === e ? y : e, G && (M = Y[N] ? Y[N].group : null)
        }

        function u(e) {
            return F[e] || (Y[e] ? Y[e].text : "")
        }

        function h(t) {
            var a, n, s = [];
            if ($) {
                for (a in e._tempSelected[V]) s.push(u(a));
                return s.join(", ")
            }
            return n = t[V], u(n)
        }

        function f() {
            var t, a = "",
                n = e.getVal(),
                s = h(e.getArrayVal());
            if (O.filter && "inline" == O.display || x.val(s), H.is("select") && B) {
                if (W)
                    for (t = 0; t < n.length; t++) a += '<option value="' + n[t] + '">' + u(n[t]) + "</option>";
                else a = '<option value="' + n + '">' + s + "</option>";
                H.html(a)
            }
            H[0] !== x[0] && H.val(n)
        }

        function p() {
            var t = {};
            t[V] = s(), I = !0, e.changeWheel(t)
        }

        function b(e, t) {
            return t = t.replace(/[-\/\\^$*+?.()|[\]{}]/g, "\\$&"), e.match(new RegExp(t, "ig"))
        }

        function v(e) {
            return O.data.dataField ? e[O.data.dataField] : O.data.processResponse ? O.data.processResponse(e) : e
        }

        function g(a) {
            var o = {};
            t(a), O.wheels = r(), i(N), o[V] = s(), e._tempWheelArray[V] = N, G && (o[k] = n(), e._tempWheelArray[k] = M), e._isVisible && e.changeWheel(o, 0, !0)
        }
        var x, T, y, _, w, M, S, C, k, D, N, A, V, I, F = {},
            H = Le(this),
            P = ze({}, e.settings),
            O = ze(e.settings, Fa, P),
            L = Le('<div class="mbsc-sel-empty">' + O.filterEmptyText + "</div>"),
            E = O.readonly,
            Y = {},
            z = O.layout || (/top|bottom|inline/.test(O.display) || O.filter ? "liquid" : ""),
            j = "liquid" == z,
            W = d(O.select) ? O.select : "multiple" == O.select || H.prop("multiple"),
            $ = W || !!O.filter && 1,
            R = this.id + "_dummy",
            J = Le('label[for="' + this.id + '"]').attr("for", R),
            K = void 0 !== O.label ? O.label : J.length ? J.text() : H.attr("name"),
            B = !!O.data,
            U = B ? !!O.group : Le("optgroup", H).length,
            q = O.group,
            G = U && q && !1 !== q.groupWheel,
            X = U && q && G && !0 === q.clustered,
            Z = U && (!q || !1 !== q.header && !X),
            Q = H.val() || (W ? [] : [""]),
            ee = [];
        return e.setVal = function(t, a, n, s, r) {
            $ && (t && !W && (t = [t]), t && m(t) && (t = t.split(",")), e._tempSelected[V] = c(t), s || (e._selected[V] = c(t)), t = t ? t[0] : null), e._setVal(t, a, n, s, r)
        }, e.getVal = function(t, a) {
            var n;
            return $ ? (n = l(t ? e._tempSelected[V] : e._selected[V]), n = W ? n : n.length ? n[0] : null) : (n = t ? e._tempWheelArray : e._hasValue ? e._wheelArray : null, n = n ? n[V] : null), W ? n : n ? U && a ? [Y[n] ? Y[n].group : null, n] : n : null
        }, e.refresh = function(e, t, a) {
            a = a || o, e ? T = e : Le.isArray(O.data) && (T = O.data), !e && D && void 0 === t ? le(O.data.url, function(e) {
                T = v(e), g(), a()
            }, O.data.dataType) : (g(t), a())
        }, O.invalid.length || (O.invalid = ee), G ? (k = 0, V = 1) : (k = -1, V = 0), $ && (W && H.prop("multiple", !0), Q && m(Q) && (Q = Q.split(",")), e._selected[V] = c(Q)), e._$input && e._$input.remove(), H.next().is("input.mbsc-control") ? x = H.next().removeAttr("tabindex") : O.input ? x = Le(O.input) : (O.filter && "inline" == O.display ? e._$input = Le('<div class="mbsc-sel-input-wrap"><input type="text" id="' + R + '" class="mbsc-control ' + O.inputClass + '" readonly /></div>') : (x = Le('<input type="text" id="' + R + '" class="mbsc-control ' + O.inputClass + '" readonly />'), e._$input = x), O.showInput && (e._$input.insertBefore(H), x || (x = e._$input.find("#" + R)))), e.attachShow(x.attr("placeholder", O.placeholder || "")), x[0] !== H[0] && H.addClass("mbsc-sel-hdn").attr("tabindex", -1), O.filter && (_ = O.filter.minLength || 0), D = O.data && O.data.url, D ? e.refresh(void 0, void 0, f) : (B && (T = O.data), t(), i(H.val())), {
            layout: z,
            headerText: !1,
            anchor: x,
            compClass: "mbsc-sel" + (G ? " mbsc-sel-gr-whl" : "") + ($ ? " mbsc-sel-multi" : ""),
            setOnTap: !G || [!1, !0],
            formatValue: h,
            parseValue: function(e) {
                return i(void 0 === e ? H.val() : e), G ? [M, N] : [N]
            },
            validate: function(e) {
                var t = e.index,
                    a = [];
                return a[V] = O.invalid, X && !I && void 0 === t && p(), I = !1, {
                    disabled: a
                }
            },
            onRead: f,
            onFill: f,
            onMarkupReady: function(e, t) {
                if (O.filter) {
                    var a, n, s, r = Le(".mbsc-fr-w", e.target),
                        i = Le('<span class="mbsc-sel-filter-clear mbsc-ic mbsc-ic-' + O.filterClearIcon + '"></span>');
                    "inline" == O.display ? (a = x, x.parent().find(".mbsc-sel-filter-clear").remove()) : (r.prepend('<div class="mbsc-input mbsc-sel-filter-cont mbsc-control-w"><span class="mbsc-input-wrap"><input type="text" class="mbsc-sel-filter-input mbsc-control"/></span></div>'), a = r.find(".mbsc-sel-filter-input")), w = null, s = a[0], a.prop("readonly", !1).attr("placeholder", O.filterPlaceholderText).parent().append(i), r.find(".mbsc-fr-c").prepend(L), t.tap(i, function() {
                        s.value = "", t.refresh(), i.removeClass("mbsc-sel-filter-show-clear")
                    }), a.on("keydown", function(e) {
                        13 != e.keyCode && 27 != e.keyCode || (e.stopPropagation(), s.blur())
                    }).on("keyup", function() {
                        clearTimeout(n), s.value.length ? i.addClass("mbsc-sel-filter-show-clear") : i.removeClass("mbsc-sel-filter-show-clear"), n = setTimeout(function() {
                            w !== s.value && !1 !== t.trigger("onFilter", {
                                filterText: s.value
                            }) && (w = s.value, (w.length >= _ || !w.length) && (D && O.data.remoteFilter ? le(O.data.url + encodeURIComponent(w), function(e) {
                                t.refresh(v(e))
                            }, O.data.dataType) : t.refresh(void 0, w)))
                        }, 500)
                    })
                }
            },
            onBeforeShow: function() {
                W && O.counter && (O.headerText = function() {
                    var t = 0;
                    return Le.each(e._tempSelected[V], function() {
                        t++
                    }), (t > 1 ? O.selectedPluralText || O.selectedText : O.selectedText).replace(/{count}/, t)
                }), i(H.val()), O.filter && t(void 0), e.settings.wheels = r(), I = !0
            },
            onWheelGestureStart: function(e) {
                e.index == k && (O.readonly = [!1, !0])
            },
            onWheelAnimationEnd: function(t) {
                var a = e.getArrayVal(!0);
                t.index == k ? (O.readonly = E, a[k] != M && (M = a[k], N = C[M].options[0].value, a[V] = N, X ? p() : e.setArrayVal(a, !1, !1, !0, 1e3))) : t.index == V && a[V] != N && (N = a[V], G && Y[N] && Y[N].group != M && (M = Y[N].group, a[k] = M, e.setArrayVal(a, !1, !1, !0, 1e3)))
            },
            onItemTap: function(e) {
                if (e.index == V && (F[e.value] = Y[e.value].text, $ && !W && e.selected)) return !1
            },
            onClose: function() {
                D && O.data.remoteFilter && w && e.refresh()
            },
            onDestroy: function() {
                e._$input && e._$input.remove(), H.removeClass("mbsc-sel-hdn").removeAttr("tabindex")
            }
        }
    };
    var Ha = {
        autostart: !1,
        step: 1,
        useShortLabels: !1,
        labels: ["Years", "Months", "Days", "Hours", "Minutes", "Seconds", ""],
        labelsShort: ["Yrs", "Mths", "Days", "Hrs", "Mins", "Secs", ""],
        startText: "Start",
        stopText: "Stop",
        resetText: "Reset",
        lapText: "Lap",
        hideText: "Hide"
    };
    ue.presetShort("timer"), ue.presets.scroller.timer = function(e) {
        function t(e) {
            return new Date(e.getUTCFullYear(), e.getUTCMonth(), e.getUTCDate(), e.getUTCHours(), e.getUTCMinutes(), e.getUTCSeconds(), e.getUTCMilliseconds())
        }

        function a(e) {
            var a = {};
            if (P && M[I].index > M.days.index) {
                var n, s, r, i, o = new Date,
                    l = b ? o : H,
                    c = b ? H : o;
                for (c = t(c), l = t(l), a.years = l.getFullYear() - c.getFullYear(), a.months = l.getMonth() - c.getMonth(), a.days = l.getDate() - c.getDate(), a.hours = l.getHours() - c.getHours(), a.minutes = l.getMinutes() - c.getMinutes(), a.seconds = l.getSeconds() - c.getSeconds(), a.fract = (l.getMilliseconds() - c.getMilliseconds()) / 10, n = w.length; n > 0; n--) s = w[n - 1], r = M[s], i = w[Le.inArray(s, w) - 1], M[i] && a[s] < 0 && (a[i]--, a[s] += "months" == i ? 32 - new Date(l.getFullYear(), l.getMonth(), 32).getDate() : r.until + 1);
                "months" == I && (a.months += 12 * a.years, delete a.years)
            } else Le(w).each(function(t, n) {
                M[n].index <= M[I].index && (a[n] = Math.floor(e / M[n].limit), e -= a[n] * M[n].limit)
            });
            return a
        }

        function n(e) {
            var t = 1,
                a = M[e],
                n = a.wheel,
                r = a.prefix,
                i = a.until,
                o = M[w[Le.inArray(e, w) - 1]];
            if (a.index <= M[I].index && (!o || o.limit > V))
                if (S[e] || O[0].push(n), S[e] = 1, n.data = [], n.label = a.label || "", n.cssClass = "mbsc-timer-whl-" + e, V >= a.limit && (t = Math.max(Math.round(V / a.limit), 1), d = t * a.limit), e == I) n.min = 0, n.data = function(e) {
                    return {
                        value: e,
                        display: s(e, r, a.label)
                    }
                }, n.getIndex = function(e) {
                    return e
                };
                else
                    for (l = 0; l <= i; l += t) n.data.push({
                        value: l,
                        display: s(l, r, a.label)
                    })
        }

        function s(e, t, a) {
            return (t || "") + (e < 10 ? "0" : "") + e + '<span class="mbsc-timer-lbl">' + a + "</span>"
        }

        function r(e) {
            var t, n = [],
                s = a(e);
            return Le(w).each(function(e, a) {
                S[a] && (t = Math.max(Math.round(V / M[a].limit), 1), n.push(Math.round(s[a] / t) * t))
            }), n
        }

        function i(e) {
            P ? (f = H - new Date, f < 0 ? (f *= -1, b = !0) : b = !1, p = 0, A = !0) : void 0 !== H ? (A = !1, f = 1e3 * H, b = "countdown" != T.mode, e && (p = 0)) : (f = 0, b = "countdown" != T.mode, A = b, e && (p = 0))
        }

        function o() {
            D ? (Le(".mbsc-fr-w", v).addClass("mbsc-timer-running mbsc-timer-locked"), Le(".mbsc-timer-btn-toggle-c > div", v).text(T.stopText), e.buttons.start.icon && Le(".mbsc-timer-btn-toggle-c > div", v).removeClass("mbsc-ic-" + e.buttons.start.icon), e.buttons.stop.icon && Le(".mbsc-timer-btn-toggle-c > div", v).addClass("mbsc-ic-" + e.buttons.stop.icon), "stopwatch" == T.mode && (Le(".mbsc-timer-btn-resetlap-c > div", v).text(T.lapText), e.buttons.reset.icon && Le(".mbsc-timer-btn-resetlap-c > div", v).removeClass("mbsc-ic-" + e.buttons.reset.icon), e.buttons.lap.icon && Le(".mbsc-timer-btn-resetlap-c > div", v).addClass("mbsc-ic-" + e.buttons.lap.icon))) : (Le(".mbsc-fr-w", v).removeClass("mbsc-timer-running"), Le(".mbsc-timer-btn-toggle-c > div", v).text(T.startText), e.buttons.start.icon && Le(".mbsc-timer-btn-toggle-c > div", v).addClass("mbsc-ic-" + e.buttons.start.icon), e.buttons.stop.icon && Le(".mbsc-timer-btn-toggle-c > div", v).removeClass("mbsc-ic-" + e.buttons.stop.icon), "stopwatch" == T.mode && (Le(".mbsc-timer-btn-resetlap-c > div", v).text(T.resetText), e.buttons.reset.icon && Le(".mbsc-timer-btn-resetlap-c > div", v).addClass("mbsc-ic-" + e.buttons.reset.icon), e.buttons.lap.icon && Le(".mbsc-timer-btn-resetlap-c > div", v).removeClass("mbsc-ic-" + e.buttons.lap.icon)))
        }
        var l, c, d, m, u, h, f, p, b, v, g, x = ze({}, e.settings),
            T = ze(e.settings, Ha, x),
            y = T.useShortLabels ? T.labelsShort : T.labels,
            _ = ["resetlap", "toggle"],
            w = ["years", "months", "days", "hours", "minutes", "seconds", "fract"],
            M = {
                years: {
                    index: 6,
                    until: 10,
                    limit: 31536e6,
                    label: y[0],
                    wheel: {}
                },
                months: {
                    index: 5,
                    until: 11,
                    limit: 2592e6,
                    label: y[1],
                    wheel: {}
                },
                days: {
                    index: 4,
                    until: 31,
                    limit: 864e5,
                    label: y[2],
                    wheel: {}
                },
                hours: {
                    index: 3,
                    until: 23,
                    limit: 36e5,
                    label: y[3],
                    wheel: {}
                },
                minutes: {
                    index: 2,
                    until: 59,
                    limit: 6e4,
                    label: y[4],
                    wheel: {}
                },
                seconds: {
                    index: 1,
                    until: 59,
                    limit: 1e3,
                    label: y[5],
                    wheel: {}
                },
                fract: {
                    index: 0,
                    until: 99,
                    limit: 10,
                    label: y[6],
                    prefix: ".",
                    wheel: {}
                }
            },
            S = {},
            C = [],
            k = 0,
            D = !1,
            N = !0,
            A = !1,
            V = Math.max(10, 1e3 * T.step),
            I = T.maxWheel,
            F = "stopwatch" == T.mode || P,
            H = T.targetTime,
            P = H && void 0 !== H.getTime,
            O = [
                []
            ];
        return e.start = function() {
            if (N && e.reset(), !D) {
                if (i(), !A && p >= f) return;
                D = !0, N = !1, u = new Date, m = p, T.readonly = !0, e.setVal(r(b ? p : f - p), !0, !0, !1, 100), c = setInterval(function() {
                    p = new Date - u + m, e.setVal(r(b ? p : f - p), !0, !0, !1, Math.min(100, d - 10)), !A && p + d >= f && (clearInterval(c), setTimeout(function() {
                        e.stop(), p = f, e.setVal(r(b ? p : 0), !0, !0, !1, 100), e.trigger("onFinish", {
                            time: f
                        }), N = !0
                    }, f - p))
                }, d), o(), e.trigger("onStart")
            }
        }, e.stop = function() {
            D && (D = !1, clearInterval(c), p = new Date - u + m, o(), e.trigger("onStop", {
                ellapsed: p
            }))
        }, e.toggle = function() {
            D ? e.stop() : e.start()
        }, e.reset = function() {
            e.stop(), p = 0, C = [], k = 0, e.setVal(r(b ? 0 : f), !0, !0, !1, 100), e.settings.readonly = F, N = !0, F || Le(".mbsc-fr-w", v).removeClass("mbsc-timer-locked"), e.trigger("onReset")
        }, e.lap = function() {
            D && (h = new Date - u + m, g = h - k, k = h, C.push(h), e.trigger("onLap", {
                ellapsed: h,
                lap: g,
                laps: C
            }))
        }, e.resetlap = function() {
            D && "stopwatch" == T.mode ? e.lap() : e.reset()
        }, e.getTime = function() {
            return f
        }, e.setTime = function(e) {
            H = e / 1e3, f = e
        }, e.getEllapsedTime = function() {
            return D ? new Date - u + m : 0
        }, e.setEllapsedTime = function(t, a) {
            N || (m = p = t, u = new Date, e.setVal(r(b ? p : f - p), !0, a, !1, 100))
        }, i(!0), I || f || (I = "minutes"), "inline" !== T.display && _.unshift("hide"), I || Le(w).each(function(e, t) {
            if (!I && f >= M[t].limit) return I = t, !1
        }), Le(w).each(function(e, t) {
            n(t)
        }), d = Math.max(87, d), T.autostart && setTimeout(function() {
            e.start()
        }, 0), e.handlers.toggle = e.toggle, e.handlers.start = e.start, e.handlers.stop = e.stop, e.handlers.resetlap = e.resetlap, e.handlers.reset = e.reset, e.handlers.lap = e.lap, e.buttons.toggle = {
            parentClass: "mbsc-timer-btn-toggle-c",
            text: T.startText,
            icon: T.startIcon,
            handler: "toggle"
        }, e.buttons.start = {
            text: T.startText,
            icon: T.startIcon,
            handler: "start"
        }, e.buttons.stop = {
            text: T.stopText,
            icon: T.stopIcon,
            handler: "stop"
        }, e.buttons.reset = {
            text: T.resetText,
            icon: T.resetIcon,
            handler: "reset"
        }, e.buttons.lap = {
            text: T.lapText,
            icon: T.lapIcon,
            handler: "lap"
        }, e.buttons.resetlap = {
            parentClass: "mbsc-timer-btn-resetlap-c",
            text: T.resetText,
            icon: T.resetIcon,
            handler: "resetlap"
        }, e.buttons.hide = {
            parentClass: "mbsc-timer-btn-hide-c",
            text: T.hideText,
            icon: T.closeIcon,
            handler: "cancel"
        }, {
            wheels: O,
            headerText: !1,
            readonly: F,
            buttons: _,
            mode: "countdown",
            compClass: "mbsc-timer",
            parseValue: function() {
                return r(b ? 0 : f)
            },
            formatValue: function(e) {
                var t = "",
                    a = 0;
                return Le(w).each(function(n, s) {
                    "fract" != s && S[s] && (t += e[a] + ("seconds" == s && S.fract ? "." + e[a + 1] : "") + " " + y[n] + " ", a++)
                }), t
            },
            validate: function(e) {
                var t = e.values,
                    a = e.index,
                    n = 0;
                N && void 0 !== a && (H = 0, Le(w).each(function(e, a) {
                    S[a] && (H += M[a].limit * t[n], n++)
                }), H /= 1e3, i(!0))
            },
            onBeforeShow: function() {
                T.showLabel = !0
            },
            onMarkupReady: function(e) {
                v = Le(e.target), o(), F && Le(".mbsc-fr-w", v).addClass("mbsc-timer-locked")
            },
            onPosition: function(e) {
                Le(".mbsc-fr-w", e.target).css("min-width", 0).css("min-width", Le(".mbsc-fr-btn-cont", e.target)[0].offsetWidth)
            },
            onDestroy: function() {
                clearInterval(c)
            }
        }
    };
    var Pa = {
        wheelOrder: "hhiiss",
        useShortLabels: !1,
        min: 0,
        max: 1 / 0,
        labels: ["Years", "Months", "Days", "Hours", "Minutes", "Seconds"],
        labelsShort: ["Yrs", "Mths", "Days", "Hrs", "Mins", "Secs"]
    };
    ue.presetShort("timespan"), ue.presets.scroller.timespan = function(e) {
        function t(e) {
            var t = {};
            return Le(b).each(function(a, n) {
                t[n] = T[n] ? Math.floor(e / v[n].limit) : 0, e -= t[n] * v[n].limit
            }), t
        }

        function a(e) {
            var t = !1,
                a = x[T[e] - 1] || 1,
                s = v[e],
                r = s.label,
                o = s.wheel;
            if (o.data = [], o.label = s.label, f.match(new RegExp(s.re + s.re, "i")) && (t = !0), e == y) o.min = c[e], o.max = m[e], o.data = function(e) {
                return {
                    value: e * a,
                    display: n(e * a, t, r)
                }
            }, o.getIndex = function(e) {
                return Math.round(e / a)
            };
            else
                for (i = 0; i <= s.until; i += a) o.data.push({
                    value: i,
                    display: n(i, t, r)
                })
        }

        function n(e, t, a) {
            return (e < 10 && t ? "0" : "") + e + '<span class="mbsc-ts-lbl">' + a + "</span>"
        }

        function s(e) {
            var t = 0;
            return Le.each(g, function(a, n) {
                isNaN(+e[0]) || (t += v[n.v].limit * e[a])
            }), t
        }

        function r(e, t) {
            return Math.floor(e / t) * t
        }
        var i, o, l, c, m, u = ze({}, e.settings),
            h = ze(e.settings, Pa, u),
            f = h.wheelOrder,
            p = h.useShortLabels ? h.labelsShort : h.labels,
            b = ["years", "months", "days", "hours", "minutes", "seconds"],
            v = {
                years: {
                    ord: 0,
                    index: 6,
                    until: 10,
                    limit: 31536e6,
                    label: p[0],
                    re: "y",
                    wheel: {}
                },
                months: {
                    ord: 1,
                    index: 5,
                    until: 11,
                    limit: 2592e6,
                    label: p[1],
                    re: "m",
                    wheel: {}
                },
                days: {
                    ord: 2,
                    index: 4,
                    until: 31,
                    limit: 864e5,
                    label: p[2],
                    re: "d",
                    wheel: {}
                },
                hours: {
                    ord: 3,
                    index: 3,
                    until: 23,
                    limit: 36e5,
                    label: p[3],
                    re: "h",
                    wheel: {}
                },
                minutes: {
                    ord: 4,
                    index: 2,
                    until: 59,
                    limit: 6e4,
                    label: p[4],
                    re: "i",
                    wheel: {}
                },
                seconds: {
                    ord: 5,
                    index: 1,
                    until: 59,
                    limit: 1e3,
                    label: p[5],
                    re: "s",
                    wheel: {}
                }
            },
            g = [],
            x = h.steps || [],
            T = {},
            y = "seconds",
            _ = h.defaultValue || Math.max(h.min, Math.min(0, h.max)),
            w = [
                []
            ];
        return Le(b).each(function(e, t) {
            (o = f.search(new RegExp(v[t].re, "i"))) > -1 && (g.push({
                o: o,
                v: t
            }), v[t].index > v[y].index && (y = t))
        }), g.sort(function(e, t) {
            return e.o > t.o ? 1 : -1
        }), Le.each(g, function(e, t) {
            T[t.v] = e + 1, w[0].push(v[t.v].wheel)
        }), c = t(h.min), m = t(h.max), Le.each(g, function(e, t) {
            a(t.v)
        }), e.getVal = function(t, a) {
            return a ? e._getVal(t) : e._hasValue || t ? s(e.getArrayVal(t)) : null
        }, {
            showLabel: !0,
            wheels: w,
            compClass: "mbsc-ts",
            parseValue: function(e) {
                var a, n = [];
                return d(e) || !e ? (l = t(e || _), Le.each(g, function(e, t) {
                    n.push(l[t.v])
                })) : Le.each(g, function(t, s) {
                    a = new RegExp("(\\d+)\\s?(" + h.labels[v[s.v].ord] + "|" + h.labelsShort[v[s.v].ord] + ")", "gi").exec(e), n.push(a ? a[1] : 0)
                }), Le(n).each(function(e, t) {
                    n[e] = r(t, x[e] || 1)
                }), n
            },
            formatValue: function(e) {
                var t = "";
                return Le.each(g, function(a, n) {
                    t += +e[a] ? e[a] + " " + v[n.v].label + " " : ""
                }), t ? t.replace(/\s+$/g, "") : 0
            },
            validate: function(a) {
                var n, r, i, o, l = a.values,
                    d = a.direction,
                    u = [],
                    h = !0,
                    f = !0;
                return Le(b).each(function(a, p) {
                    if (void 0 !== T[p]) {
                        if (i = T[p] - 1, u[i] = [], o = {}, p != y) {
                            if (h)
                                for (r = m[p] + 1; r <= v[p].until; r++) o[r] = !0;
                            if (f)
                                for (r = 0; r < c[p]; r++) o[r] = !0
                        }
                        l[i] = e.getValidValue(i, l[i], d, o), n = t(s(l)), h = h && n[p] == m[p], f = f && n[p] == c[p], Le.each(o, function(e) {
                            u[i].push(e)
                        })
                    }
                }), {
                    disabled: u
                }
            }
        }
    }, ue.presets.scroller.treelist = ue.presets.scroller.list, ue.presetShort("list"), ue.presetShort("treelist"), 
     ue.i18n["en-GB"] = ue.i18n["en-UK"] = {
        dateFormat: "dd/mm/yy",
        timeFormat: "HH:ii"
    },
     ue.i18n.zh = {
        setText: "确定",
        cancelText: "取消",
        clearText: "明确",
        selectedText: "{count} 选",
        dateFormat: "yy/mm/dd",
        dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"],
        dayNamesShort: ["日", "一", "二", "三", "四", "五", "六"],
        dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"],
        dayText: "日",
        hourText: "时",
        minuteText: "分",
        monthNames: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
        monthNamesShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
        monthText: "月",
        secText: "秒",
        timeFormat: "HH:ii",
        yearText: "年",
        nowText: "当前",
        pmText: "下午",
        amText: "上午",
        todayText: "今天",
        dateText: "日",
        timeText: "时间",
        calendarText: "日历",
        closeText: "关闭",
        fromText: "开始时间",
        toText: "结束时间",
        wholeText: "合计",
        fractionText: "分数",
        unitText: "单位",
        labels: ["年", "月", "日", "小时", "分钟", "秒", ""],
        labelsShort: ["年", "月", "日", "点", "分", "秒", ""],
        startText: "开始",
        stopText: "停止",
        resetText: "重置",
        lapText: "圈",
        hideText: "隐藏",
        backText: "返回",
        undoText: "复原",
        offText: "关闭",
        onText: "开启",
        decimalSeparator: ",",
        thousandsSeparator: " "
    };
    var La = ue.themes;
    La.frame.bootstrap = {
        disabledClass: "disabled",
        selectedClass: "btn-primary",
        selectedTabClass: "active",
        tabLink: !0,
        todayClass: "text-primary",
        onMarkupInserted: function(e) {
            var t = Le(e.target);
            Le(".mbsc-fr-popup", t).addClass("popover"), Le(".mbsc-fr-w", t).addClass("popover-content"), Le(".mbsc-fr-hdr", t).addClass("popover-title popover-header"), Le(".mbsc-fr-arr-i", t).addClass("popover"), Le(".mbsc-fr-arr", t).addClass("arrow"), Le(".mbsc-fr-btn", t).addClass("btn btn-default btn-secondary"), Le(".mbsc-fr-btn-s .mbsc-fr-btn", t).removeClass("btn-default btn-secondary").addClass("btn btn-primary"), Le(".mbsc-sc-btn-plus", t).addClass("glyphicon glyphicon-chevron-down"), Le(".mbsc-sc-btn-minus", t).addClass("glyphicon glyphicon-chevron-up"), Le(".mbsc-cal-next", t).prepend('<i class="glyphicon glyphicon-chevron-right"></i>'), Le(".mbsc-cal-prev", t).prepend('<i class="glyphicon glyphicon-chevron-left"></i>'), Le(".mbsc-cal-tabs", t).addClass("nav nav-tabs"), Le(".mbsc-cal-picker", t).addClass("popover"), Le(".mbsc-cal-events", t).addClass("popover"), Le(".mbsc-cal-events-arr", t).addClass("arrow"), Le(".mbsc-range-btn", t).addClass("btn btn-sm btn-small btn-default"), Le(".mbsc-np-btn", t).addClass("btn btn-default"), Le(".mbsc-sel-filter-cont", t).removeClass("mbsc-input"), Le(".mbsc-sel-filter-input", t).addClass("form-control")
        },
        onPosition: function(e) {
            setTimeout(function() {
                Le(".mbsc-fr-bubble-top, .mbsc-fr-bubble-top .mbsc-fr-arr-i", e.target).removeClass("bottom").addClass("top"), Le(".mbsc-fr-bubble-bottom, .mbsc-fr-bubble-bottom .mbsc-fr-arr-i", e.target).removeClass("top").addClass("bottom")
            }, 10)
        }
    }, La.scroller.bootstrap = ze({}, La.frame.bootstrap, {
        dateDisplay: "Mddyy",
        btnCalPrevClass: "",
        btnCalNextClass: "",
        selectedLineHeight: !0,
        onEventBubbleShow: function(e) {
            var t = Le(e.eventList);
            Le(".mbsc-cal-event-list", t).addClass("list-group"), Le(".mbsc-cal-event", t).addClass("list-group-item"), setTimeout(function() {
                t.hasClass("mbsc-cal-events-b") ? t.removeClass("top").addClass("bottom") : t.removeClass("bottom").addClass("top")
            }, 10)
        }
    }), La.navigation.bootstrap = {
        wrapperClass: "popover panel panel-default",
        groupClass: "btn-group",
        activeClass: "btn-primary",
        disabledClass: "disabled",
        itemClass: "btn btn-default"
    };
    var Ea = ue.themes;
    Ea.frame.ios = {
        display: "bottom",
        headerText: !1,
        btnWidth: !1,
        deleteIcon: "ios-backspace",
        scroll3d: !0
    }, Ea.scroller.ios = ze({}, Ea.frame.ios, {
        rows: 5,
        height: 34,
        minWidth: 55,
        selectedLineHeight: !0,
        selectedLineBorder: 1,
        showLabel: !1,
        useShortLabels: !0,
        btnPlusClass: "mbsc-ic mbsc-ic-arrow-down5",
        btnMinusClass: "mbsc-ic mbsc-ic-arrow-up5",
        checkIcon: "ion-ios7-checkmark-empty",
        filterClearIcon: "ion-close-circled",
        dateDisplay: "MMdyy",
        btnCalPrevClass: "mbsc-ic mbsc-ic-arrow-left5",
        btnCalNextClass: "mbsc-ic mbsc-ic-arrow-right5"
    }), Ea.listview.ios = {
        leftArrowClass: "mbsc-ic-ion-ios7-arrow-back",
        rightArrowClass: "mbsc-ic-ion-ios7-arrow-forward"
    }, Ea.form.ios = {};
    var Ya, za, ja = ue.themes;
    ja.frame.material = {
        headerText: !1,
        btnWidth: !1,
        deleteIcon: "material-backspace",
        onMarkupReady: function(e) {
            me(Le(e.target), ".mbsc-fr-btn-e", "mbsc-fr-btn-d", "mbsc-fr-btn-nhl")
        }
    }, ja.scroller.material = ze({}, ja.frame.material, {
        showLabel: !1,
        selectedLineBorder: 2,
        weekDays: "min",
        icon: {
            filled: "material-star",
            empty: "material-star-outline"
        },
        checkIcon: "material-check",
        btnPlusClass: "mbsc-ic mbsc-ic-material-keyboard-arrow-down",
        btnMinusClass: "mbsc-ic mbsc-ic-material-keyboard-arrow-up",
        btnCalPrevClass: "mbsc-ic mbsc-ic-material-keyboard-arrow-left",
        btnCalNextClass: "mbsc-ic mbsc-ic-material-keyboard-arrow-right",
        onEventBubbleShow: function(e) {
            var t = Le(e.eventList),
                a = Le(e.target).closest(".mbsc-cal-row").index() < 2,
                n = Le(".mbsc-cal-event-color", t).eq(a ? 0 : -1).css("background-color");
            Le(".mbsc-cal-events-arr", t).css("border-color", a ? "transparent transparent " + n + " transparent" : n + "transparent transparent transparent")
        }
    }), ja.listview.material = {
        leftArrowClass: "mbsc-ic-material-keyboard-arrow-left",
        rightArrowClass: "mbsc-ic-material-keyboard-arrow-right",
        onItemActivate: function(e) {
            ce(Le(e.target), e.domEvent)
        },
        onItemDeactivate: function() {
            de(za)
        },
        onSlideStart: function(e) {
            Le(".mbsc-ripple", e.target).remove()
        },
        onSortStart: function(e) {
            Le(".mbsc-ripple", e.target).remove()
        }
    }, ja.navigation.material = {
        onInit: function() {
            me(Le(this), ".mbsc-ms-item.mbsc-btn-e", "mbsc-btn-d", "mbsc-btn-nhl")
        },
        onMarkupInit: function() {
            Le(".mbsc-ripple", this).remove()
        },
        onDestroy: function() {
            Le(this).off(".mbsc-ripple")
        }
    }, ja.form.material = {
        addRipple: function(e, t) {
            ce(e, t)
        },
        removeRipple: function() {
            de(za)
        }
    };
    var Wa = ue.themes;
    Wa.frame.windows = {
        headerText: !1,
        deleteIcon: "backspace4",
        setIcon: "checkmark",
        cancelIcon: "close",
        closeIcon: "close",
        clearIcon: "close",
        okIcon: "checkmark",
        nowIcon: "loop2",
        startIcon: "play3",
        stopIcon: "pause2",
        resetIcon: "stop2",
        lapIcon: "loop2",
        btnWidth: !1,
        btnReverse: !0
    }, Wa.scroller.windows = ze({}, Wa.frame.windows, {
        minWidth: 76,
        height: 76,
        dateDisplay: "mmMMddDDyy",
        showLabel: !1,
        icon: {
            filled: "star3",
            empty: "star"
        },
        btnCalPrevClass: "mbsc-ic mbsc-ic-arrow-left2",
        btnCalNextClass: "mbsc-ic mbsc-ic-arrow-right2",
        btnPlusClass: "mbsc-ic mbsc-ic-plus",
        btnMinusClass: "mbsc-ic mbsc-ic-minus"
    }), Wa.form.windows = {}, ue.customTheme("ios-dark", "ios"), ue.customTheme("material-dark", "material"), ue.customTheme("mobiscroll-dark", "mobiscroll"), ue.customTheme("windows-dark", "windows");
    var $a = ue.themes,
        Ra = void 0;
    return "android" == Se ? Ra = "material" : "ios" == Se ? Ra = "ios" : "wp" == Se && (Ra = "windows"), ue.setAutoTheme = function() {
        Le.each($a.frame, function(e, t) {
            if (Ra && t.baseTheme == Ra && "material-dark" != e && "windows-dark" != e && "ios-dark" != e) return ue.autoTheme = e, !1;
            e == Ra && (ue.autoTheme = e)
        })
    }, ue.setAutoTheme(), ue.apiKey = "58407021", ue.apiUrl = "https://trial.mobiscroll.com/", ue
});