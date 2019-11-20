/**
 * MobiscrollJquery For 4.0.0 beta
 * 
 * @author	https://www.mobiscroll.cn
 */
! function (e, t) {
	"object" == typeof exports && "undefined" != typeof module ? module.exports = t(require("jquery")) : "function" == typeof define && define.amd ? define(["jquery"], t) : e.mobiscroll = t(e.jQuery)
}(this, function (e) {
	"use strict";

	function t(e, t, a) {
		var n = e;
		return "object" === (void 0 === t ? "undefined" : le(t)) ? e.each(function () {
			new ie.classes[t.component || "Scroller"](this, t)
		}) : ("string" == typeof t && e.each(function () {
			var e, s = ie.instances[this.id];
			if (s && s[t] && void 0 !== (e = s[t].apply(this, Array.prototype.slice.call(a, 1)))) return n = e, !1
		}), n)
	}

	function a() {}

	function n(e) {
		var t, a = [];
		for (t in e) a.push(e[t]);
		return a
	}

	function s(e) {
		var t, a = {};
		if (e)
			for (t = 0; t < e.length; t++) a[e[t]] = e[t];
		return a
	}

	function r(e) {
		return e - parseFloat(e) >= 0
	}

	function o(e) {
		return "string" == typeof e
	}

	function i(e, t, a) {
		return Math.max(t, Math.min(e, a))
	}

	function l(e, t) {
		var a, n;
		return t = t || 100
			, function () {
				var s = this
					, r = +new Date
					, o = arguments;
				a && r < a + t ? (clearTimeout(n), n = setTimeout(function () {
					a = r, e.apply(s, o)
				}, t)) : (a = r, e.apply(s, o))
			}
	}

	function c(e) {
		"vibrate" in navigator && navigator.vibrate(e || 50)
	}

	function d() {
		Se++, setTimeout(function () {
			Se--
		}, 500)
	}

	function m(e, t) {
		var a = (e.originalEvent || e)
			.changedTouches[0]
			, n = document.createEvent("MouseEvents");
		n.initMouseEvent("click", !0, !0, window, 1, a.screenX, a.screenY, a.clientX, a.clientY, !1, !1, !1, !1, 0, null), n.tap = !0, t.mbscChange = !0, t.dispatchEvent(n), d()
	}

	function u(e, t, a) {
		var n = e.originalEvent || e
			, s = (a ? "page" : "client") + t;
		return n.targetTouches && n.targetTouches[0] ? n.targetTouches[0][s] : n.changedTouches && n.changedTouches[0] ? n.changedTouches[0][s] : e[s]
	}

	function h(e, t, a, n, s, r) {
		function o(e) {
			f || (n && e.preventDefault(), f = this, m = u(e, "X"), h = u(e, "Y"), p = !1, b = new Date)
		}

		function i(e) {
			f && !p && (Math.abs(u(e, "X") - m) > s || Math.abs(u(e, "Y") - h) > s) && (p = !0)
		}

		function l(t) {
			f && ((r && new Date - b < 100 || !p) && (t.preventDefault(), a.call(f, t, e)), f = !1, d())
		}

		function c() {
			f = !1
		}
		var m, h, f, p, b, v = ie.$
			, g = v(t);
		s = s || 9, e.settings.tap && g.on("touchstart.mbsc", o)
			.on("touchcancel.mbsc", c)
			.on("touchmove.mbsc", i)
			.on("touchend.mbsc", l), g.on("click.mbsc", function (t) {
				n && t.preventDefault(), a.call(this, t, e)
			})
	}

	function f(e) {
		if (Se && !e.tap && ("TEXTAREA" != e.target.nodeName || "mousedown" != e.type)) return e.stopPropagation(), e.preventDefault(), !1
	}

	function v(e, t, a, n, s, r, o) {
		var i = new Date(e, t, a, n || 0, s || 0, r || 0, o || 0);
		return 23 == i.getHours() && 0 === (n || 0) && i.setHours(i.getHours() + 2), i
	}

	function g(e, t, a) {
		if (!t) return null;
		var n, s, r = Ve({}, Ie, a)
			, o = function (t) {
				for (var a = 0; n + 1 < e.length && e.charAt(n + 1) == t;) a++, n++;
				return a
			}
			, i = function (e, t, a) {
				var n = "" + t;
				if (o(e))
					for (; n.length < a;) n = "0" + n;
				return n
			}
			, l = function (e, t, a, n) {
				return o(e) ? n[t] : a[t]
			}
			, c = ""
			, d = !1;
		for (n = 0; n < e.length; n++)
			if (d) "'" != e.charAt(n) || o("'") ? c += e.charAt(n) : d = !1;
			else switch (e.charAt(n)) {
			case "d":
				c += i("d", r.getDay(t), 2);
				break;
			case "D":
				c += l("D", t.getDay(), r.dayNamesShort, r.dayNames);
				break;
			case "o":
				c += i("o", (t.getTime() - new Date(t.getFullYear(), 0, 0)
					.getTime()) / 864e5, 3);
				break;
			case "m":
				c += i("m", r.getMonth(t) + 1, 2);
				break;
			case "M":
				c += l("M", r.getMonth(t), r.monthNamesShort, r.monthNames);
				break;
			case "y":
				s = r.getYear(t), c += o("y") ? s : (s % 100 < 10 ? "0" : "") + s % 100;
				break;
			case "h":
				var m = t.getHours();
				c += i("h", m > 12 ? m - 12 : 0 === m ? 12 : m, 2);
				break;
			case "H":
				c += i("H", t.getHours(), 2);
				break;
			case "i":
				c += i("i", t.getMinutes(), 2);
				break;
			case "s":
				c += i("s", t.getSeconds(), 2);
				break;
			case "a":
				c += t.getHours() > 11 ? r.pmText : r.amText;
				break;
			case "A":
				c += t.getHours() > 11 ? r.pmText.toUpperCase() : r.amText.toUpperCase();
				break;
			case "'":
				o("'") ? c += "'" : d = !0;
				break;
			default:
				c += e.charAt(n)
			}
		return c
	}

	function x(e, t, a) {
		var n = Ve({}, Ie, a)
			, s = n.defaultValue && n.defaultValue.getTime ? n.defaultValue : new Date;
		if (!e || !t) return s;
		if (t.getTime) return t;
		t = "object" == (void 0 === t ? "undefined" : le(t)) ? t.toString() : t + "";
		var r, o = n.shortYearCutoff
			, i = n.getYear(s)
			, l = n.getMonth(s) + 1
			, c = n.getDay(s)
			, d = -1
			, m = s.getHours()
			, u = s.getMinutes()
			, h = 0
			, f = -1
			, p = !1
			, b = function (t) {
				var a = r + 1 < e.length && e.charAt(r + 1) == t;
				return a && r++, a
			}
			, v = function (e) {
				b(e);
				var a = "@" == e ? 14 : "!" == e ? 20 : "y" == e ? 4 : "o" == e ? 3 : 2
					, n = new RegExp("^\\d{1," + a + "}")
					, s = t.substr(T)
					.match(n);
				return s ? (T += s[0].length, parseInt(s[0], 10)) : 0
			}
			, g = function (e, a, n) {
				var s, r = b(e) ? n : a;
				for (s = 0; s < r.length; s++)
					if (t.substr(T, r[s].length)
						.toLowerCase() == r[s].toLowerCase()) return T += r[s].length, s + 1;
				return 0
			}
			, x = function () {
				T++
			}
			, T = 0;
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
				i = v("y");
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
		if (i < 100 && (i += (new Date)
				.getFullYear() - (new Date)
				.getFullYear() % 100 + (i <= ("string" != typeof o ? o : (new Date)
					.getFullYear() % 100 + parseInt(o, 10)) ? 0 : -100)), d > -1)
			for (l = 1, c = d;;) {
				var y = 32 - new Date(i, l - 1, 32, 12)
					.getDate();
				if (c <= y) break;
				l++, c -= y
			}
		m = -1 == f ? m : f && m < 12 ? m + 12 : f || 12 != m ? m : 0;
		var _ = n.getDate(i, l - 1, c, m, u, h);
		return n.getYear(_) != i || n.getMonth(_) + 1 != l || n.getDay(_) != c ? s : _
	}

	function T(e) {
		var t;
		for (t in e)
			if (void 0 !== He[e[t]]) return !0;
		return !1
	}

	function y(e, t) {
		if ("touchstart" == e.type) ke(t)
			.attr("data-touch", "1");
		else if (ke(t)
			.attr("data-touch")) return ke(t)
			.removeAttr("data-touch"), !1;
		return !0
	}

	function _(e, t) {
		var a, n = getComputedStyle(e[0]);
		return ke.each(["t", "webkitT", "MozT", "OT", "msT"], function (e, t) {
			if (void 0 !== n[t + "ransform"]) return a = n[t + "ransform"], !1
		}), a = a.split(")")[0].split(", "), t ? a[13] || a[5] : a[12] || a[4]
	}

	function w(e) {
		if (e) {
			if (Le[e]) return Le[e];
			var t = ke('<div style="background-color:' + e + ';"></div>')
				.appendTo("body")
				, a = getComputedStyle(t[0])
				, n = a.backgroundColor.replace(/rgb|rgba|\(|\)|\s/g, "")
				.split(",")
				, s = .299 * n[0] + .587 * n[1] + .114 * n[2]
				, r = s > 130 ? "#000" : "#fff";
			return t.remove(), Le[e] = r, r
		}
	}

	function M(e, t) {
		function a(e) {
			var t;
			i = ke(this), h = +i.attr("data-step"), l = !1, "mousedown" == e.type && e.preventDefault(), "keydown" != e.type ? (d = u(e, "X"), m = u(e, "Y"), t = y(e, this)) : t = 32 === e.keyCode, c || !t || i.hasClass("mbsc-fr-btn-d") || (c = !0, setTimeout(o, 100), "mousedown" == e.type && ke(document)
				.on("mousemove", n)
				.on("mouseup", s))
		}

		function n(e) {
			(Math.abs(d - u(e, "X")) > 7 || Math.abs(m - u(e, "Y")) > 7) && r()
		}

		function s(e) {
			"touchend" == e.type && e.preventDefault(), l || o(), r(), "mouseup" == e.type && ke(document)
				.off("mousemove", n)
				.off("mouseup", s)
		}

		function r() {
			c = !1, i && i.removeClass("mbsc-fr-btn-a")
		}

		function o() {
			c && !i.hasClass("mbsc-fr-btn-d") && (l = !0, t(h, o))
		}
		var i, l, c, d, m, h;
		e.on("touchstart mousedown keydown", a)
			.on("touchmove", n)
			.on("touchend touchcancel keyup", s)
	}

	function S(e) {
		return e[0].innerWidth || e.innerWidth()
	}

	function C(e, t) {
		var a = {}
			, n = e.parent()
			, s = n.find(".mbsc-err-msg")
			, r = e.attr("data-icon-align") || "left"
			, o = e.attr("data-icon");
		n.hasClass(it) ? n = n.parent() : ke('<span class="' + it + '"></span>')
			.insertAfter(e)
			.append(e), s && n.find("." + it)
			.append(s), o && (-1 !== o.indexOf("{") ? a = JSON.parse(o) : a[r] = o), (o || t) && (Ve(a, t), n.addClass((a.right ? "mbsc-ic-right " : "") + (a.left ? " mbsc-ic-left" : ""))
				.find("." + it)
				.append(a.left ? '<span class="mbsc-input-ic mbsc-left-ic mbsc-ic mbsc-ic-' + a.left + '"></span>' : "")
				.append(a.right ? '<span class="mbsc-input-ic mbsc-right-ic mbsc-ic mbsc-ic-' + a.right + '"></span>' : ""))
	}

	function k(e, t, a) {
		var n = {}
			, s = a[0]
			, r = a.attr("data-password-toggle")
			, o = a.attr("data-icon-show") || "eye"
			, i = a.attr("data-icon-hide") || "eye-blocked";
		r && (n.right = "password" == s.type ? o : i), C(a, n), r && h(e, t.find(".mbsc-right-ic")
			.addClass("mbsc-input-toggle")
			, function () {
				"text" == s.type ? (s.type = "password", ke(this)
					.addClass("mbsc-ic-" + o)
					.removeClass("mbsc-ic-" + i)) : (s.type = "text", ke(this)
					.removeClass("mbsc-ic-" + o)
					.addClass("mbsc-ic-" + i))
			})
	}

	function D(e, t) {
		"button" != t && "submit" != t && "segmented" != t && (e.addClass("mbsc-control-w")
			.find("label")
			.addClass("mbsc-label"), e.contents()
			.filter(function () {
				return 3 == this.nodeType && this.nodeValue && /\S/.test(this.nodeValue)
			})
			.each(function () {
				ke('<span class="mbsc-label"></span>')
					.insertAfter(this)
					.append(this)
			}))
	}

	function N(e) {
		var t = [Math.round(e.r)
			.toString(16), Math.round(e.g)
			.toString(16), Math.round(e.b)
			.toString(16)];
		return ke.each(t, function (e, a) {
			1 == a.length && (t[e] = "0" + a)
		}), "#" + t.join("")
	}

	function V(e) {
		return e = parseInt(e.indexOf("#") > -1 ? e.substring(1) : e, 16), {
			r: e >> 16
			, g: (65280 & e) >> 8
			, b: 255 & e
			, toString: function () {
				return "rgb(" + this.r + "," + this.g + "," + this.b + ")"
			}
		}
	}

	function A(e) {
		var t, a, n, s = e.h
			, r = 255 * e.s / 100
			, o = 255 * e.v / 100;
		if (0 === r) t = a = n = o;
		else {
			var i = o
				, l = (255 - r) * o / 255
				, c = s % 60 * (i - l) / 60;
			360 == s && (s = 0), s < 60 ? (t = i, n = l, a = l + c) : s < 120 ? (a = i, n = l, t = i - c) : s < 180 ? (a = i, t = l, n = l + c) : s < 240 ? (n = i, t = l, a = i - c) : s < 300 ? (n = i, a = l, t = l + c) : s < 360 ? (t = i, a = l, n = i - c) : t = a = n = 0
		}
		return {
			r: t
			, g: a
			, b: n
			, toString: function () {
				return "rgb(" + this.r + "," + this.g + "," + this.b + ")"
			}
		}
	}

	function I(e) {
		var t, a, n = 0
			, s = Math.min(e.r, e.g, e.b)
			, r = Math.max(e.r, e.g, e.b)
			, o = r - s;
		return a = r, t = r ? 255 * o / r : 0, n = t ? e.r == r ? (e.g - e.b) / o : e.g == r ? 2 + (e.b - e.r) / o : 4 + (e.r - e.g) / o : -1, n *= 60, n < 0 && (n += 360), t *= 100 / 255, a *= 100 / 255, {
			h: n
			, s: t
			, v: a
			, toString: function () {
				return "hsv(" + Math.round(this.h) + "," + Math.round(this.s) + "%," + Math.round(this.v) + "%)"
			}
		}
	}

	function F(e) {
		var t, a, n = e.r / 255
			, s = e.g / 255
			, r = e.b / 255
			, o = Math.max(n, s, r)
			, i = Math.min(n, s, r)
			, l = (o + i) / 2;
		if (o == i) t = a = 0;
		else {
			var c = o - i;
			switch (a = l > .5 ? c / (2 - o - i) : c / (o + i), o) {
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
			h: Math.round(360 * t)
			, s: Math.round(100 * a)
			, l: Math.round(100 * l)
			, toString: function () {
				return "hsl(" + this.h + "," + this.s + "%," + this.l + "%)"
			}
		}
	}

	function H(e) {
		var t, a, n, s, r, o, i = e.h
			, l = e.s
			, c = e.l;
		return isFinite(i) || (i = 0), isFinite(l) || (l = 0), isFinite(c) || (c = 0), i /= 60, i < 0 && (i = 6 - -i % 6), i %= 6, l = Math.max(0, Math.min(1, l / 100)), c = Math.max(0, Math.min(1, c / 100)), r = (1 - Math.abs(2 * c - 1)) * l, o = r * (1 - Math.abs(i % 2 - 1)), i < 1 ? (t = r, a = o, n = 0) : i < 2 ? (t = o, a = r, n = 0) : i < 3 ? (t = 0, a = r, n = o) : i < 4 ? (t = 0, a = o, n = r) : i < 5 ? (t = o, a = 0, n = r) : (t = r, a = 0, n = o), s = c - r / 2, {
			r: Math.round(255 * (t + s))
			, g: Math.round(255 * (a + s))
			, b: Math.round(255 * (n + s))
			, toString: function () {
				return "rgb(" + this.r + "," + this.g + "," + this.b + ")"
			}
		}
	}

	function P(e) {
		return F(V(e))
	}

	function O(e) {
		return N(H(e))
	}

	function L(e) {
		return N(A(e))
	}

	function E(e) {
		return I(V(e))
	}

	function Y(e) {
		xt.length || e.show(), xt.push(e)
	}

	function z(e) {
		var t = Tt.length;
		Tt.push(e), xt.length || (t ? Tt[0].hide() : e.show(!1, !0))
	}

	function j(e, t, a, n) {
		return Ve({
			display: t.display || "center"
			, cssClass: "mbsc-alert"
			, okText: t.okText
			, cancelText: t.cancelText
			, context: t.context
			, theme: t.theme
			, closeOnOverlayTap: !1
			, onBeforeClose: function () {
				e.shift()
			}
			, onBeforeShow: function () {
				ie.activeInstance = null
			}
			, onHide: function (e, n) {
				a && a(n._resolve), t.callback && t.callback(n._resolve), n && n.destroy(), xt.length ? xt[0].show() : Tt.length && Tt[0].show(!1, !0)
			}
		}, n)
	}

	function W(e) {
		return (e.title ? "<h2>" + e.title + "</h2>" : "") + "<p>" + (e.message || "") + "</p>"
	}

	function $(e, t, a) {
		Y(new vt(e, j(xt, t, a)))
	}

	function R(e, t, a) {
		var n = new vt(e, j(xt, t, a, {
			buttons: ["cancel", "ok"]
			, onSet: function () {
				n._resolve = !0
			}
		}));
		n._resolve = !1, Y(n)
	}

	function J(e, t, a) {
		var n = void 0
			, s = new vt(e, j(xt, t, a, {
				buttons: ["cancel", "ok"]
				, onShow: function () {
					n = s._markup.find("input")[0], setTimeout(function () {
						n.focus()
					}, 300)
				}
				, onSet: function () {
					s._resolve = n.value
				}
			}));
		s._resolve = null, Y(s)
	}

	function K(e, t, a, n, s) {
		var r = void 0;
		z(new vt(e, j(Tt, t, a, {
			display: "bottom"
			, animate: s
			, cssClass: n || "mbsc-snackbar"
			, scrollLock: !1
			, focusTrap: !1
			, buttons: []
			, onShow: function (e, a) {
				!1 !== t.duration && (r = setTimeout(function () {
					a && a.hide()
				}, t.duration || 3e3)), t.button && a.tap(ke(".mbsc-snackbar-btn", e.target), function () {
					a.hide(), t.button.action && t.button.action.call(this)
				})
			}
			, onClose: function () {
				clearTimeout(r)
			}
		})))
	}

	function U(e, t, a) {
		K(e, t, a, "mbsc-toast", "fade")
	}

	function B(e, t, a) {
		var n = void 0;
		return gt ? n = new Promise(function (n) {
			e(t, a, n)
		}) : e(t, a), n
	}

	function q(e) {
		var t = e[0]
			, a = e.attr("data-role")
			, n = e.attr("type") || t.nodeName.toLowerCase();
		return /(switch|range|segmented|stepper)/.test(a) && (n = a), n
	}

	function G(e) {
		var t = ie.themes.form[e];
		return t && t.addRipple ? t : null
	}

	function X() {
		clearTimeout(At), At = setTimeout(function () {
			ke("textarea.mbsc-control")
				.each(function () {
					Z(this)
				})
		}, 100)
	}

	function Z(e) {
		var t = void 0
			, a = void 0
			, n = void 0
			, s = ke(e)
			.attr("rows") || 6;
		e.offsetHeight && (e.style.height = "", n = e.scrollHeight - e.offsetHeight, t = e.offsetHeight + (n > 0 ? n : 0), a = Math.round(t / 24), a > s ? (e.scrollTop = t, t = 24 * s + (t - 24 * a), ke(e)
				.addClass("mbsc-textarea-scroll")) : ke(e)
			.removeClass("mbsc-textarea-scroll"), t && (e.style.height = t + "px"))
	}

	function Q(e) {
		if (!ke(e)
			.hasClass("mbsc-textarea-scroll")) {
			var t = e.scrollHeight - e.offsetHeight
				, a = e.offsetHeight + t;
			e.scrollTop = 0, e.style.height = a + "px"
		}
	}

	function ee(e) {
		for (var t = 0, a = 1, n = 0; e.length;) t > 3 ? a = 3600 : t > 1 && (a = 60), n += e.pop() * a * (t % 2 ? 10 : 1), t++;
		return n
	}

	function te(e, t) {
		var a = document.createElement("script")
			, n = "mbscjsonp" + ++_a;
		window[n] = function (e) {
			a.parentNode.removeChild(a), delete window[n], e && t(e)
		}, a.src = e + (e.indexOf("?") >= 0 ? "&" : "?") + "callback=" + n, document.body.appendChild(a)
	}

	function ae(e, t) {
		var a = new XMLHttpRequest;
		a.open("GET", e, !0), a.onload = function () {
			this.status >= 200 && this.status < 400 && t(JSON.parse(this.response))
		}, a.onerror = function () {}, a.send()
	}

	function ne(e, t, a) {
		"jsonp" == a ? te(e, t) : ae(e, t)
	}

	function se(e, t) {
		var a = u(t, "X", !0)
			, n = u(t, "Y", !0)
			, s = e.offset()
			, r = a - s.left
			, o = n - s.top
			, i = Math.max(r, e[0].offsetWidth - r)
			, l = Math.max(o, e[0].offsetHeight - o)
			, c = 2 * Math.sqrt(Math.pow(i, 2) + Math.pow(l, 2));
		re(Va), Va = ke('<span class="mbsc-ripple"></span>')
			.css({
				width: c
				, height: c
				, top: n - s.top - c / 2
				, left: a - s.left - c / 2
			})
			.appendTo(e), setTimeout(function () {
				Va.addClass("mbsc-ripple-scaled mbsc-ripple-visible")
			}, 10)
	}

	function re(e) {
		setTimeout(function () {
			e && (e.removeClass("mbsc-ripple-visible"), setTimeout(function () {
				e.remove()
			}, 2e3))
		}, 100)
	}

	function oe(e, t, a, n) {
		var s, r;
		e.off(".mbsc-ripple")
			.on("touchstart.mbsc-ripple mousedown.mbsc-ripple", t, function (e) {
				y(e, this) && (s = u(e, "X"), r = u(e, "Y"), Na = ke(this), Na.hasClass(a) || Na.hasClass(n) ? Na = null : se(Na, e))
			})
			.on("touchmove.mbsc-ripple mousemove.mbsc-ripple", t, function (e) {
				(Na && Math.abs(u(e, "X") - s) > 9 || Math.abs(u(e, "Y") - r) > 9) && (re(Va), Na = null)
			})
			.on("touchend.mbsc-ripple touchcancel.mbsc-ripple mouseleave.mbsc-ripple mouseup.mbsc-ripple", t, function () {
				Na && (setTimeout(function () {
					re(Va)
				}, 100), Na = null)
			})
	}
	e = e && e.hasOwnProperty("default") ? e.default : e;
	var ie = ie || {}
		, le = "function" == typeof Symbol && "symbol" == typeof Symbol.iterator ? function (e) {
			return typeof e
		} : function (e) {
			return e && "function" == typeof Symbol && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e
		}
		, ce = function (e, t) {
			if (!(e instanceof t)) throw new TypeError("Cannot call a class as a function")
		}
		, de = function () {
			function e(e, t) {
				for (var a = 0; a < t.length; a++) {
					var n = t[a];
					n.enumerable = n.enumerable || !1, n.configurable = !0, "value" in n && (n.writable = !0), Object.defineProperty(e, n.key, n)
				}
			}
			return function (t, a, n) {
				return a && e(t.prototype, a), n && e(t, n), t
			}
		}()
		, me = function e(t, a, n) {
			null === t && (t = Function.prototype);
			var s = Object.getOwnPropertyDescriptor(t, a);
			if (void 0 === s) {
				var r = Object.getPrototypeOf(t);
				return null === r ? void 0 : e(r, a, n)
			}
			if ("value" in s) return s.value;
			var o = s.get;
			if (void 0 !== o) return o.call(n)
		}
		, ue = function (e, t) {
			if ("function" != typeof t && null !== t) throw new TypeError("Super expression must either be null or a function, not " + typeof t);
			e.prototype = Object.create(t && t.prototype, {
				constructor: {
					value: e
					, enumerable: !1
					, writable: !0
					, configurable: !0
				}
			}), t && (Object.setPrototypeOf ? Object.setPrototypeOf(e, t) : e.__proto__ = t)
		}
		, he = function (e, t) {
			if (!e) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
			return !t || "object" != typeof t && "function" != typeof t ? e : t
		}
		, fe = e.extend;
	ie.presetShort = function (e, a, n) {
		ie.components[e] = function (s) {
			return t(this, fe(s, {
				component: a
				, preset: !1 === n ? void 0 : e
			}), arguments)
		}
	}, ie.$ = e, e.mobiscroll = ie, e.fn.mobiscroll = function (e) {
		return fe(this, ie.components), t(this, e, arguments)
	};
	var pe, be, ve, ge, xe = []
		, Te = "undefined" != typeof window
		, ye = Te ? navigator.userAgent : ""
		, _e = ye.match(/Android|iPhone|iPad|iPod|Windows Phone|Windows|MSIE/i)
		, we = Te && window.requestAnimationFrame || function (e) {
			e()
		}
		, Me = Te && window.cancelAnimationFrame || function () {};
	/Android/i.test(_e) ? (pe = "android", (be = ye.match(/Android\s+([\d\.]+)/i)) && (xe = be[0].replace("Android ", "")
		.split("."))) : /iPhone|iPad|iPod/i.test(_e) ? (pe = "ios", (be = ye.match(/OS\s+([\d\_]+)/i)) && (xe = be[0].replace(/_/g, ".")
		.replace("OS ", "")
		.split("."))) : /Windows Phone/i.test(_e) ? pe = "wp" : /Windows|MSIE/i.test(_e) && (pe = "windows"), ve = xe[0], ge = xe[1];
	var Se = 0;
	Te && (["mouseover", "mousedown", "mouseup", "click"].forEach(function (e) {
		document.addEventListener(e, f, !0)
	}), "android" == pe && ve < 5 && document.addEventListener("change", function (e) {
		Se && "checkbox" == e.target.type && !e.target.mbscChange && (e.stopPropagation(), e.preventDefault()), delete e.target.mbscChange
	}, !0));
	var Ce, ke = ie.$
		, De = +new Date
		, Ne = {}
		, Ve = ke.extend;
	Ce = Ve(ie, {
		$: ke
		,
		version: "4.0.0-beta",
		Wodxy : true
		,util: {
			getCoord: u
			, preventClick: d
			, vibrate: c
		}
		, autoTheme: "mobiscroll"
		, presets: {
			scroller: {}
			, numpad: {}
		}
		, themes: {
			form: {}
			, page: {}
			, frame: {}
			, scroller: {}
			, listview: {}
			, navigation: {}
			, progress: {}
		}
		, platform: {
			name: pe
			, majorVersion: ve
			, minorVersion: ge
		}
		, i18n: {}
		, instances: Ne
		, classes: {}
		, components: {}
		, settings: {}
		, setDefaults: function (e) {
			Ve(this.settings, e)
		}
		, customTheme: function (e, t) {
			var a, n = ie.themes
				, s = ["frame", "scroller", "listview", "navigation", "form", "page", "progress"];
			for (a = 0; a < s.length; a++) n[s[a]][e] = Ve({}, n[s[a]][t], {
				baseTheme: t
			})
		}
	}), Ce.presetShort = Ce.presetShort || function () {};
	var Ae = function (e, t) {
		var n, s, r, o, i, l, c, d = this;
		d.settings = {}, d._init = a, d._destroy = a, d._processSettings = a, d.init = function (a) {
			var m;
			for (m in d.settings) delete d.settings[m];
			r = d.settings, Ve(t, a), d._hasDef && (c = Ce.settings), Ve(r, d._defaults, c, t), d._hasTheme && (i = r.theme, "auto" != i && i || (i = Ce.autoTheme), "default" == i && (i = "mobiscroll"), t.theme = i, o = Ce.themes[d._class] ? Ce.themes[d._class][i] : {}), d._hasLang && (n = Ce.i18n[r.lang]), d._hasTheme && l("onThemeLoad", {
				lang: n
				, settings: t
			}), Ve(r, o, n, c, t), d._processSettings();
			var u = {
				form: !0
				, page: !0
				, progress: !0
				, switch: !0
				, slider: !0
				, stepper: !0
			};
			if (!d._class || u[d._class]) d._init(a), l("onInit");
			else {
				var h, f, p = {
						className: d._class
						, buttons: d.buttons
						, platform: Ce.platform
						, userAgent: navigator.userAgent
						, defSortHandle: ke(e)
							.find(r.listSelector || "ul,ol")
							.length ? "left" : "right"
						, settings: {
							activeClass: r.activeClass
							, ampmText: r.ampmText
							, amText: r.amText
							, animateIcons: r.animateIcons
							, backText: r.backText
							, baseTheme: r.baseTheme
							, buttons: r.buttons
							, btnClass: r.btnClass
							, btnWidth: r.btnWidth
							, btnReverse: r.btnReverse
							, closeIcon: r.closeIcon
							, context: "body" == r.context ? "body" : ""
							, controls: r.controls
							, cssClass: r.cssClass
							, dateDisplay: r.dateDisplay
							, dateFormat: r.dateFormat
							, dateWheels: r.dateWheels
							, dayNames: r.dayNames
							, dayNamesShort: r.dayNamesShort
							, daySuffix: r.daySuffix
							, display: r.display
							, dayText: r.dayText
							, endYear: r.endYear
							, fixedHeader: r.fixedHeader
							, handleClass: r.handleClass
							, handleMarkup: r.handleMarkup
							, hideText: r.hideText
							, hourText: r.hourText
							, itemNode: r.itemNode
							, itemWidth: r.itemWidth
							, lang: r.lang
							, lapIcon: r.lapIcon
							, lapText: r.lapText
							, layout: r.layout
							, leftArrowClass: r.leftArrowClass
							, max: r.max
							, min: r.min
							, minuteText: r.minuteText
							, monthNames: r.monthNames
							, monthNamesShort: r.monthNamesShort
							, monthSuffix: r.monthSuffix
							, monthText: r.monthText
							, nowIcon: r.nowIcon
							, nowText: r.nowText
							, pmText: r.pmText
							, preset: r.preset
							, resetIcon: r.resetIcon
							, resetText: r.resetText
							, rightArrowClass: r.rightArrowClass
							, rtl: r.rtl
							, secText: r.secText
							, select: r.select
							, snap: r.snap
							, sort: r.sort
							, sortable: r.sortable
							, sortHandle: r.sortHandle
							, startIcon: r.startIcon
							, startText: r.startText
							, startYear: r.startYear
							, stepHour: r.stepHour
							, stepMinute: r.stepMinute
							, stepSecond: r.stepSecond
							, steps: r.steps
							, stopIcon: r.stopIcon
							, stopText: r.stopText
							, striped: r.striped
							, theme: r.theme
							, timeFormat: r.timeFormat
							, timeWheels: r.timeWheels
							, todayText: r.todayText
							, type: r.type
							, variant: r.variant
							, wrapperClass: r.wrapperClass
							, yearSuffix: r.yearSuffix
							, yearText: r.yearText
						}
					}
					, b = []
					, v = {}
					, g = ["refresh", "redraw", "navigate", "changeTab", "getDate", "setDate", "addEvent", "removeEvent", "getEvents", "setEvents", "setActiveDate", "start", "stop", "reset", "lap", "resetlap", "getTime", "setTime", "getEllapsedTime", "setEllapsedTime"]
					, x = {
						jsonp: 1
						, getInst: 1
						, init: 1
						, destroy: 1
					}
					, T = function (e) {
						d[e] = function () {
							b.push({
								func: e
								, args: arguments
							})
						}
					};
				for (f in d) "function" != typeof d[f] || x[f] || (v[f] = d[f], T(f));
				for (h = 0; h < g.length; h++) T(g[h]);
				"timer" != r.preset || t.buttons || (p.settings.buttons = ["toggle", "resetlap"], "inline" !== r.display && p.settings.buttons.push("hide")), "eventcalendar" != r.preset || t.buttons || "inline" == r.display || (p.settings.buttons = ["close"]), 
					d.zone.run(function () {
						if (d) {
							
							for (f in v) d[f] = v[f];
							var o = Ve({}, t);
							for (delete o.data, d._hasPreset && (s = Ce.presets[d._class][r.preset]) && (s = s.call(e, d), Ve(r, s, o)), d._init(a), l("onInit"), h = 0; h < b.length; h++) d[b[h].func].apply(d, b[h].args);
							b = null, v = null
						}
				})
			}
		}, d.destroy = function () {
			d && (d._destroy(), l("onDestroy"), delete Ne[e.id], d = null)
		}, d.tap = function (e, t, a, n, s) {
			h(d, e, t, a, n, s)
		}, d.trigger = function (a, n) {
			var r, i, l, m = [c, o, s, t];
			for (i = 0; i < 4; i++)(l = m[i]) && l[a] && (r = l[a].call(e, n || {}, d));
			return r
		}, d.option = function (e, t) {
			var a = {};
			"object" === (void 0 === e ? "undefined" : le(e)) ? a = e: a[e] = t, d.init(a)
		}, d.getInst = function () {
			return d
		}, d.zone = {
			run: function (e) {
				e()
			}
		}, t = t || {}, l = d.trigger, d.__ready || function () {
			ke(e)
				.addClass("mbsc-comp"), e.id ? Ne[e.id] && Ne[e.id].destroy() : e.id = "mobiscroll" + ++De, Ne[e.id] = d, d.__ready = !0
		}()
	};
	Te && ke(function () {
		(document.cookie.replace(/(?:(?:^|.*;\s*)mobiscrollClientError\s*\=\s*([^;]*).*$)|^.*$/, "$1") || /mobiscrollClientError/.test(window.name || "")) && ''
	});
	var Ie = {
		shortYearCutoff: "+10"
		, monthNames: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
		, monthNamesShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
		, dayNames: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
		, dayNamesShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"]
		, dayNamesMin: ["S", "M", "T", "W", "T", "F", "S"]
		, amText: "am"
		, pmText: "pm"
		, getYear: function (e) {
			return e.getFullYear()
		}
		, getMonth: function (e) {
			return e.getMonth()
		}
		, getDay: function (e) {
			return e.getDate()
		}
		, getDate: v
		, getMaxDayOfMonth: function (e, t) {
			return 32 - new Date(e, t, 32, 12)
				.getDate()
		}
		, getWeekNumber: function (e) {
			e = new Date(e), e.setHours(0, 0, 0), e.setDate(e.getDate() + 4 - (e.getDay() || 7));
			var t = new Date(e.getFullYear(), 0, 1);
			return Math.ceil(((e - t) / 864e5 + 1) / 7)
		}
	};
	ie.util.datetime = {
		formatDate: g
		, parseDate: x,
		adjustedDate : v,
		defaults : Ie
	};
	var Fe, He, Pe, Oe, Le = {};
	Te && (He = document.createElement("modernizr")
		.style, Pe = function () {
			var e, t = ["Webkit", "Moz", "O", "ms"];
			for (e in t)
				if (T([t[e] + "Transform"])) return "-" + t[e].toLowerCase() + "-";
			return ""
		}(), Oe = Pe.replace(/^\-/, "")
		.replace(/\-$/, "")
		.replace("moz", "Moz"), Fe = void 0 !== He.animation ? "animationend" : "webkitAnimationEnd");
	var Ee, Ye, ze = ie.classes
		, je = ie.themes
		, We = /(iphone|ipod)/i.test(ye) && ve >= 7
		, $e = "android" == pe
		, Re = "ios" == pe
		, Je = Re && 8 == ve
		, Ke = Re && ve > 7
		, Ue = function (e) {
			e.preventDefault()
		}
		, Be = function (e, t, n) {
			function s(e) {
				V && V.removeClass("mbsc-fr-btn-a"), V = ke(this), V.hasClass("mbsc-fr-btn-d") || V.hasClass("mbsc-fr-btn-nhl") || V.addClass("mbsc-fr-btn-a"), "mousedown" === e.type ? ke(document)
					.on("mouseup", r) : "pointerdown" === e.type && ke(document)
					.on("pointerup", r)
			}

			function r(e) {
				V && (V.removeClass("mbsc-fr-btn-a"), V = null), "mouseup" === e.type ? ke(document)
					.off("mouseup", r) : "pointerup" === e.type && ke(document)
					.off("pointerup", r)
			}

			function l(e) {
				13 == e.keyCode ? Q.select() : 27 == e.keyCode && Q.cancel()
			}

			function c(e) {
				e || $e || j.focus(), Q.ariaMessage(J.ariaMessage)
			}

			function m(e) {
				var t = Ee
					, a = J.focusOnClose;
				Q._markupRemove(), w.remove(), H && (A.mbscModals--, J.scrollLock && A.mbscLock--, A.mbscLock || _.removeClass("mbsc-fr-lock"), A.mbscModals || (_.removeClass("mbsc-fr-lock-ios mbsc-fr-lock-ctx"), z && (T.css({
					top: ""
					, left: ""
				}), k.scrollLeft(K), k.scrollTop(B)), e || (t || (t = ee), setTimeout(function () {
					void 0 === a || !0 === a ? (Ye = !0, t[0].focus()) : a && ke(a)[0].focus()
				}, 200)))), Q._isVisible = !1, P = !1, G("onHide")
			}

			function h(e) {
				clearTimeout(ae[e.type]), ae[e.type] = setTimeout(function () {
					var t = "scroll" == e.type;
					t && !U || (Q.position(!t), "orientationchange" == e.type && (W.style.display = "none", W.offsetHeight, W.style.display = ""))
				}, 200)
			}

			function f(e) {
				e.target.nodeType && !j.contains(e.target) && j.focus()
			}

			function p(e, t) {
				e && e(), !1 !== Q.show() && (Ee = t)
			}

			function b() {
				Q._fillValue(), G("onSet", {
					valueText: Q._value
				})
			}

			function v() {
				G("onCancel", {
					valueText: Q._value
				})
			}

			function g() {
				Q.setVal(null, !0)
			}
			var x, T, y, _, w, M, S, C, k, D, N, V, A, I, F, H, P, O, L, E, Y, z, j, W, $, R, J, K, U, B, q, G, X, Z, Q = this
				, ee = ke(e)
				, te = []
				, ae = {};
			Ae.call(this, e, t, !0), Q.position = function (e) {
				var t, a, n, s, r, o, l, c, d, m, u, h, f, p, b, v, g, x = {}
					, y = 0
					, _ = 0
					, M = 0
					, N = 0;
				!R && P && (Q._position(w), f = O.offsetHeight, p = O.offsetWidth, X === p && Z === f && e || (Q._isFullScreen || /top|bottom/.test(J.display) ? C.width(p) : D.width(""), ke(".mbsc-comp", w)
					.each(function () {
						var e = ie.instances[this.id];
						e && e !== Q && e.position && e.position()
					}), !Q._isFullScreen && /center|bubble/.test(J.display) && (ke(".mbsc-w-p", w)
						.each(function () {
							b = this.getBoundingClientRect()
								.width, N += b, M = b > M ? b : M
						}), h = N > p - 16 || !0 === J.tabs, D.css({
							width: Q._isLiquid ? Math.min(J.maxPopupWidth, p - 16) : Math.ceil(h ? M : N)
							, "white-space": h ? "" : "nowrap"
						})), !1 !== G("onPosition", {
						target: O
						, popup: W
						, hasTabs: h
						, windowWidth: p
						, windowHeight: f
					}) && H && (L = W.offsetWidth, E = W.offsetHeight, U = E <= f && L <= p, Y && (y = k.scrollLeft(), _ = k.scrollTop()), "center" == J.display ? (g = Math.max(0, y + (p - L) / 2), v = Math.max(0, _ + (f - E) / 2)) : "bubble" == J.display ? (t = void 0 === J.anchor ? ee : ke(J.anchor), l = ke(".mbsc-fr-arr-i", w)[0], s = t.offset(), r = s.top + (F ? _ - T.offset()
							.top : 0), o = s.left + (F ? y - T.offset()
							.left : 0), a = t[0].offsetWidth, n = t[0].offsetHeight, c = l.offsetWidth, d = l.offsetHeight, g = i(o - (L - a) / 2, y + 3, y + p - L - 3), v = r - E - d / 2, v < _ || r > _ + f ? (C.removeClass("mbsc-fr-bubble-top")
							.addClass("mbsc-fr-bubble-bottom"), v = r + n + d / 2) : C.removeClass("mbsc-fr-bubble-bottom")
						.addClass("mbsc-fr-bubble-top"), ke(".mbsc-fr-arr", w)
						.css({
							left: i(o + a / 2 - (g + (L - c) / 2), 0, c)
						}), U = v > _ && g > y && v + E <= _ + f && g + L <= y + p) : (g = y, v = "top" == J.display ? _ : Math.max(0, _ + f - E)), Y && (m = Math.max(v + E, F ? A.scrollHeight : ke(document)
						.height()), u = Math.max(g + L, F ? A.scrollWidth : ke(document)
						.width()), S.css({
						width: u
						, height: m
					}), J.scroll && "bubble" == J.display && (v + E + 8 > _ + f || r > _ + f || r + n < _) && (R = !0, setTimeout(function () {
						R = !1
					}, 300), k.scrollTop(Math.min(r, v + E - f + 8, m - f)))), x.top = Math.floor(v), x.left = Math.floor(g), C.css(x), X = p, Z = f)))
			}, Q.attachShow = function (e, t) {
				var a, n = ke(e)
					, s = n.prop("readonly");
				if ("inline" !== J.display) {
					if ((J.showOnFocus || J.showOnTap) && n.is("input,select") && (n.prop("readonly", !0)
							.on("mousedown.mbsc", function (e) {
								e.preventDefault()
							})
							.on("focus.mbsc", function () {
								Q._isVisible && this.blur()
							}), a = ke('label[for="' + n.attr("id") + '"]'), a.length || (a = n.closest("label"))), n.is("select")) return;
					J.showOnFocus && n.on("focus.mbsc", function () {
						Ye ? Ye = !1 : p(t, n)
					}), J.showOnTap && (n.on("keydown.mbsc", function (e) {
						32 != e.keyCode && 13 != e.keyCode || (e.preventDefault(), e.stopPropagation(), p(t, n))
					}), Q.tap(n, function () {
						p(t, n)
					}), a && a.length && Q.tap(a, function () {
						p(t, n)
					})), te.push({
						readOnly: s
						, el: n
						, lbl: a
					})
				}
			}, Q.select = function () {
				H ? Q.hide(!1, "set", !1, b) : b()
			}, Q.cancel = function () {
				H ? Q.hide(!1, "cancel", !1, v) : v()
			}, Q.clear = function () {
				Q._clearValue(), G("onClear"), H && Q._isVisible && !Q.live ? Q.hide(!1, "clear", !1, g) : g()
			}, Q.enable = function () {
				J.disabled = !1, Q._isInput && ee.prop("disabled", !1)
			}, Q.disable = function () {
				J.disabled = !0, Q._isInput && ee.prop("disabled", !0)
			}, Q.html4 = function(){
				var html = '</div>';
				if (N.length > 0) {
					html += '<div class="mbsc-fr-btn-cont">';
					ke.each(N, function (i, b) {
						b = o(b) ? Q.buttons[b] : b;
		
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
				
			}, Q.show = function (e, t) {
				function a() {
					w.off(Fe, a)
						.removeClass("mbsc-anim-in mbsc-anim-trans mbsc-anim-trans-" + I)
						.find(".mbsc-fr-popup")
						.removeClass("mbsc-anim-" + I), c(t)
				}
				var n;
				if (!J.disabled && !Q._isVisible) {
					if (Q._readValue(), !1 === G("onBeforeShow")) return !1;
					if (Ee = null, I = J.animate, N = J.buttons || [], Y = F || "bubble" == J.display, z = We && !Y && J.scrollLock, N.length > 0, q = !1, !1 !== I && ("top" == J.display ? I = I || "slidedown" : "bottom" == J.display ? I = I || "slideup" : "center" != J.display && "bubble" != J.display || (I = I || "pop")), H && (B = Math.max(0, k.scrollTop()), K = Math.max(0, k.scrollLeft()), X = 0, Z = 0, z && !_.hasClass("mbsc-fr-lock-ios") && T.css({
								top: -B + "px"
								, left: -K + "px"
							}), _.addClass((J.scrollLock ? "mbsc-fr-lock" : "") + (z ? " mbsc-fr-lock-ios" : "") + (F ? " mbsc-fr-lock-ctx" : "")), ke(document.activeElement)
							.is("input,textarea") && document.activeElement.blur(), ie.activeInstance && ie.activeInstance.hide(), ie.activeInstance = Q, A.mbscModals = A.mbscModals || 0, A.mbscLock = A.mbscLock || 0, A.mbscModals++, J.scrollLock && A.mbscLock++), 
							n = '<div lang="' + J.lang + '" class="mbsc-fr mbsc-no-touch mbsc-' + J.theme + (J.baseTheme ? ' mbsc-' + J.baseTheme : '') + " mbsc-fr-" + J.display + " " + (J.cssClass || "") + " " + (J.compClass || "") + (Q._isLiquid ? " mbsc-fr-liq" : "") + (Ke ? " mbsc-fr-hb" : "") + 
							
							(z ? ' mbsc-platform-ios' : '') +
            (N.length > 0 ? (N.length >= 3 ? ' mbsc-fr-btn-block ' : '') : ' mbsc-fr-nobtn') + '">' +
            (H ? '<div class="mbsc-fr-persp"><div class="mbsc-fr-overlay"></div><div role="dialog" tabindex="-1" class="mbsc-fr-scroll">' : '') + // Overlay
            '<div class="mbsc-fr-popup' +
            (J.rtl ? ' mbsc-rtl' : ' mbsc-ltr')
							
							+ (J.headerText ? " mbsc-fr-has-hdr" : "") + '">' + ("bubble" === J.display ? '<div class="mbsc-fr-arr-w"><div class="mbsc-fr-arr-i"><div class="mbsc-fr-arr"></div></div></div>' : "") + 
							'<div class="mbsc-fr-w">' + // Popup content
            '<div aria-live="assertive" class="mbsc-fr-aria mbsc-fr-hdn"></div>' + 
							
							(J.headerText ? '<div class="mbsc-fr-hdr">' + (o(J.headerText) ? J.headerText : "") + "</div>" : "") + '<div class="mbsc-fr-c">', n += Q._generateContent(), 
							n += Q.html4(), 
							w = ke(n), S = ke(".mbsc-fr-persp", w), M = ke(".mbsc-fr-scroll", w), D = ke(".mbsc-fr-w", w), y = ke(".mbsc-fr-hdr", w), C = ke(".mbsc-fr-popup", w), x = ke(".mbsc-fr-aria", w), O = w[0], j = M[0], W = C[0], Q._markup = w, Q._header = y, Q._isVisible = !0, $ = "orientationchange resize", Q._markupReady(w), G("onMarkupReady", {
							target: O
						}), H) {
						if (ke(window)
							.on("keydown", l), J.scrollLock && w.on("touchmove mousewheel wheel", function (e) {
								U && e.preventDefault()
							}), J.focusTrap && k.on("focusin", f), J.closeOnOverlayTap) {
							var i, m, p, b;
							M.on("touchstart mousedown", function (e) {
									m || e.target != M[0] || (m = !0, i = !1, p = u(e, "X"), b = u(e, "Y"))
								})
								.on("touchmove mousemove", function (e) {
									m && !i && (Math.abs(u(e, "X") - p) > 9 || Math.abs(u(e, "Y") - b) > 9) && (i = !0)
								})
								.on("touchcancel", function () {
									m = !1
								})
								.on("touchend touchcancel mouseup", function (e) {
									m && !i && (Q.cancel(), "mouseup" != e.type && d()), m = !1
								})
						}
						Y && ($ += " scroll")
					}
					setTimeout(function () {
						if (H) w.appendTo(T);
						else if (ee.is("div") && !Q._hasContent) ee.empty()
							.append(w);
						else if (ee.hasClass("mbsc-control")) {
							var n = ee.closest(".mbsc-control-w");
							w.insertAfter(n), n.hasClass("mbsc-select") && n.addClass("mbsc-select-inline")
						} else w.insertAfter(ee);
						P = !0, Q._markupInserted(w), G("onMarkupInserted", {
								target: O
							}), w.on("selectstart mousedown", Ue)
							.on("click", ".mbsc-fr-btn-e", Ue)
							.on("keydown", ".mbsc-fr-btn-e", function (e) {
								32 == e.keyCode && (e.preventDefault(), e.stopPropagation(), this.click())
							})
							.on("keydown", function (e) {
								if (32 == e.keyCode) e.preventDefault();
								else if (9 == e.keyCode && H && J.focusTrap) {
									var t = w.find('[tabindex="0"]')
										.filter(function () {
											return this.offsetWidth > 0 || this.offsetHeight > 0
										})
										, a = t.index(ke(":focus", w))
										, n = t.length - 1
										, s = 0;
									e.shiftKey && (n = 0, s = -1), a === n && (t.eq(s)[0].focus(), e.preventDefault())
								}
							})
							.on("touchstart mousedown pointerdown", ".mbsc-fr-btn-e", s)
							.on("touchend", ".mbsc-fr-btn-e", r), ke("input,select,textarea", w)
							.on("selectstart mousedown", function (e) {
								e.stopPropagation()
							})
							.on("keydown", function (e) {
								32 == e.keyCode && e.stopPropagation()
							}), O.addEventListener("touchstart", function () {
								q || (q = !0, T.find(".mbsc-no-touch")
									.removeClass("mbsc-no-touch"))
							}, !0), ke.each(N, function (e, t) {
								Q.tap(ke(".mbsc-fr-btn" + e, w), function (e) {
									t = o(t) ? Q.buttons[t] : t, (o(t.handler) ? Q.handlers[t.handler] : t.handler)
										.call(this, e, Q)
								}, !0)
							}), Q._attachEvents(w), Q.position(), k.on($, h), H && (I && !e ? w.addClass("mbsc-anim-in mbsc-anim-trans mbsc-anim-trans-" + I)
								.on(Fe, a)
								.find(".mbsc-fr-popup")
								.addClass("mbsc-anim-" + I) : c(t)), G("onShow", {
								target: O
								, valueText: Q._tempValue
							})
					}, z ? 100 : 0)
				}
			}, Q.hide = function (e, t, a, n) {
				function s() {
					w.off(Fe, s), m(e)
				}
				if (!Q._isVisible || !a && !Q._isValid && "set" == t || !a && !1 === G("onBeforeClose", {
						valueText: Q._tempValue
						, button: t
					})) return !1;
				H && (ke(document.activeElement)
					.is("input,textarea") && W.contains(document.activeElement) && document.activeElement.blur(), ke(window)
					.off("keydown", l), delete ie.activeInstance), w && (H && I && !e ? w.addClass("mbsc-anim-out mbsc-anim-trans mbsc-anim-trans-" + I)
					.on(Fe, s)
					.find(".mbsc-fr-popup")
					.addClass("mbsc-anim-" + I) : m(e), Q._detachEvents(w), k.off($, h)
					.off("focusin", f)), n && n(), ee.trigger("blur"), G("onClose", {
					valueText: Q._value
				})
			}, Q.ariaMessage = function (e) {
				x.html(""), setTimeout(function () {
					x.html(e)
				}, 100)
			}, Q.isVisible = function () {
				return Q._isVisible
			}, Q.setVal = a, Q.getVal = a, Q._generateContent = a, Q._attachEvents = a, Q._detachEvents = a, Q._readValue = a, Q._clearValue = a, Q._fillValue = a, Q._markupReady = a, Q._markupInserted = a, Q._markupRemove = a, Q._position = a, Q.__processSettings = a, Q.__init = a, Q.__destroy = a, Q._destroy = function () {
				Q.hide(!0, !1, !0), ee.off(".mbsc"), ke.each(te, function (e, t) {
					t.el.off(".mbsc")
						.prop("readonly", t.readOnly), t.lbl && t.lbl.off(".mbsc")
				}), Q.__destroy()
			}, Q._processSettings = function () {
				var e, t;
				for (Q.__processSettings(), J.buttons = J.buttons || ("inline" !== J.display ? ["cancel", "set"] : []), J.headerText = void 0 === J.headerText ? "inline" !== J.display && "{value}" : J.headerText, N = J.buttons || [], H = "inline" !== J.display, F = "body" != J.context, T = ke(J.context), _ = F ? T : ke("body,html"), A = T[0], Q._$window = k = ke(F ? J.context : window), Q.live = !0, t = 0; t < N.length; t++) "ok" != (e = N[t]) && "set" != e && "set" != e.handler || (Q.live = !1);
				Q.buttons.set = {
					text: J.setText
					, icon: J.setIcon
					, handler: "set"
				}, Q.buttons.cancel = {
					text: J.cancelText
					, icon: J.cancelIcon
					, handler: "cancel"
				}, Q.buttons.close = {
					text: J.closeText
					, icon: J.closeIcon
					, handler: "cancel"
				}, Q.buttons.clear = {
					text: J.clearText
					, icon: J.clearIcon
					, handler: "clear"
				}, Q._isInput = ee.is("input")
			}, Q._init = function () {
				Q._isVisible && Q.hide(!0, !1, !0), ee.off(".mbsc"), Q.__init(), Q._isLiquid = "liquid" == J.layout, H ? (Q._readValue(), Q._hasContent || Q.attachShow(ee)) : Q.show(), ee.on("change.mbsc", function () {
					Q._preventChange || Q.setVal(ee.val(), !0, !1), Q._preventChange = !1
				})
			}, Q.buttons = {}, Q.handlers = {
				set: Q.select
				, cancel: Q.cancel
				, clear: Q.clear
			}, Q._value = null, Q._isValid = !0, Q._isVisible = !1, J = Q.settings, G = Q.trigger, n || Q.init(t)
		};
	Be.prototype._defaults = {
			lang: "en"
			, setText: "Set"
			, selectedText: "{count} selected"
			, closeText: "Close"
			, cancelText: "Cancel"
			, clearText: "Clear"
			, context: "body"
			, maxPopupWidth: 600
			, disabled: !1
			, closeOnOverlayTap: !0
			, showOnFocus: $e || Re
			, showOnTap: !0
			, display: "center"
			, scroll: !0
			, scrollLock: !0
			, tap: !0
			, btnClass: "mbsc-fr-btn"
			, btnWidth: !0
			, focusTrap: !0
			, focusOnClose: !Je
		}, ze.Frame = Be, je.frame.mobiscroll = {
			headerText: !1
			, btnWidth: !1
		}, je.scroller.mobiscroll = Ve({}, je.frame.mobiscroll, {
			rows: 5
			, showLabel: !1
			, selectedLineBorder: 1
			, weekDays: "min"
			, checkIcon: "ion-ios7-checkmark-empty"
			, btnPlusClass: "mbsc-ic mbsc-ic-arrow-down5"
			, btnMinusClass: "mbsc-ic mbsc-ic-arrow-up5"
			, btnCalPrevClass: "mbsc-ic mbsc-ic-arrow-left5"
			, btnCalNextClass: "mbsc-ic mbsc-ic-arrow-right5"
		}), Te && ke(window)
		.on("focus", function () {
			Ee && (Ye = !0)
		});
	var qe = "ios" == pe
		, Ge = function (e, t, a) {
			function n(e) {
				G("onStart", {
					domEvent: e
				}), ae.stopProp && e.stopPropagation(), ae.prevDef && e.preventDefault(), ae.readonly || ae.lock && F || y(e, this) && !I && ie.Wodxy && (f && f.removeClass("mbsc-btn-a"), D = !1, F || (f = ke(e.target)
						.closest(".mbsc-btn-e", this), f.length && !f.hasClass("mbsc-btn-d") && (D = !0, p = setTimeout(function () {
							f.addClass("mbsc-btn-a")
						}, 100))), I = !0, L = !1, H = !1, Q.scrolled = F, R = u(e, "X"), J = u(e, "Y"), S = R, v = 0, g = 0, x = 0, $ = new Date, W = +_(U, X) || 0, F && h(W, qe ? 0 : 1), "mousedown" === e.type && ke(document)
					.on("mousemove", s)
					.on("mouseup", c))
			}

			function s(e) {
				I && (ae.stopProp && e.stopPropagation(), S = u(e, "X"), C = u(e, "Y"), v = S - R, g = C - J, x = X ? g : v, D && (Math.abs(g) > ae.thresholdY || Math.abs(v) > ae.thresholdX) && (clearTimeout(p), f.removeClass("mbsc-btn-a"), D = !1), (Q.scrolled || !H && Math.abs(x) > q) && (L || G("onGestureStart", k), Q.scrolled = L = !0, O || (O = !0, P = we(l))), X || ae.scrollLock ? e.preventDefault() : Q.scrolled ? e.preventDefault() : Math.abs(g) > 7 && (H = !0, Q.scrolled = !0, ne.trigger("touchend")))
			}

			function l() {
				V && (x = i(x, -z * V, z * V)), h(i(W + x, A - M, N + M)), O = !1
			}

			function c(e) {
				if (I) {
					var t, a = new Date - $;
					ae.stopProp && e.stopPropagation(), Me(P), O = !1, !H && Q.scrolled && (ae.momentum && a < 300 && (t = x / a, x = Math.max(Math.abs(x), t * t / ae.speedUnit) * (x < 0 ? -1 : 1)), m(x)), D && (clearTimeout(p), f.addClass("mbsc-btn-a"), setTimeout(function () {
							f.removeClass("mbsc-btn-a")
						}, 100), H || Q.scrolled || G("onBtnTap", {
							target: f[0]
							, domEvent: e
						})), "mouseup" == e.type && ke(document)
						.off("mousemove", s)
						.off("mouseup", c), I = !1
				}
			}

			function d(e) {
				if (e = e.originalEvent || e, x = X ? e.deltaY || e.wheelDelta || e.detail : e.deltaX, G("onStart", {
						domEvent: e
					}), ae.stopProp && e.stopPropagation(), x && ie.Wodxy) {
					if (e.preventDefault(), e.deltaMode && 1 == e.deltaMode && (x *= 5), x = i(-x, -20, 20), W = Z, ae.readonly || W + x < A || W + x > N) return;
					L || (k = {
						posX: X ? 0 : Z
						, posY: X ? Z : 0
						, originX: X ? 0 : W
						, originY: X ? W : 0
						, direction: x > 0 ? X ? 270 : 360 : X ? 90 : 180
					}, G("onGestureStart", k)), O || (O = !0, P = we(l)), L = !0, clearTimeout(E), E = setTimeout(function () {
						Me(P), O = !1, L = !1, m(x)
					}, 200)
				}
			}

			function m(e) {
				var t, a, n;
				if (V && (e = i(e, -z * V, z * V)), n = i(Math.round((W + e) / z) * z, A, N), ee = Math.round(n / z), j) {
					if (e < 0) {
						for (t = j.length - 1; t >= 0; t--)
							if (Math.abs(n) + b >= j[t].breakpoint) {
								ee = t, te = 2, n = j[t].snap2;
								break
							}
					} else if (e >= 0)
						for (t = 0; t < j.length; t++)
							if (Math.abs(n) <= j[t].breakpoint) {
								ee = t, te = 1, n = j[t].snap1;
								break
							}
					n = i(n, A, N)
				}
				a = ae.time || (Z < A || Z > N ? 1e3 : Math.max(1e3, Math.abs(n - Z) * ae.timeUnit)), k.destinationX = X ? 0 : n, k.destinationY = X ? n : 0, k.duration = a, k.transitionTiming = w, G("onGestureEnd", k), h(n, a)
			}

			function h(e, t, a, n) {
				var s = e != Z
					, r = t > 1
					, o = function () {
						clearInterval(Y), clearTimeout(B), F = !1, Z = e, k.posX = X ? 0 : e, k.posY = X ? e : 0, s && G("onMove", k), r && G("onAnimationEnd", k), n && n()
					};
				k = {
					posX: X ? 0 : Z
					, posY: X ? Z : 0
					, originX: X ? 0 : W
					, originY: X ? W : 0
					, direction: e - Z > 0 ? X ? 270 : 360 : X ? 90 : 180
				}, Z = e, r && (k.destinationX = X ? 0 : e, k.destinationY = X ? e : 0, k.duration = t, k.transitionTiming = w, G("onAnimationStart", k)), K[Oe + "Transition"] = t ? Pe + "transform " + Math.round(t) + "ms " + w : "", K[Oe + "Transform"] = "translate3d(" + (X ? "0," + e + "px," : e + "px,0,") + "0)", !s && !F || !t || t <= 1 ? o() : t && (F = !a, clearInterval(Y), Y = setInterval(function () {
					var t = +_(U, X) || 0;
					k.posX = X ? 0 : t, k.posY = X ? t : 0, G("onMove", k), Math.abs(t - e) < 2 && o()
				}, 100), clearTimeout(B), B = setTimeout(function () {
					o()
				}, t)), ae.sync && ae.sync(e, t, w)
			}
			var f, p, b, v, g, x, T, w, M, S, C, k, D, N, V, A, I, F, H, P, O, L, E, Y, z, j, W, $, R, J, K, U, B, q, G, X, Z, Q = this
				, ee = 0
				, te = 1
				, ae = t
				, ne = ke(e);
			Ae.call(this, e, t, !0), Q.scrolled = !1, Q.scroll = function (t, a, n, s) {
				t = r(t) ? Math.round(t / z) * z : Math.ceil((ke(t, e)
					.length ? Math.round(U.offset()[T] - ke(t, e)
						.offset()[T]) : Z) / z) * z, t = i(t, A, N), ee = Math.round(t / z), W = Z, h(t, a, n, s)
			}, Q.refresh = function (e) {
				var t;
				b = void 0 === ae.contSize ? X ? ne.height() : ne.width() : ae.contSize, A = void 0 === ae.minScroll ? Math.min(0, X ? b - U.height() : b - U.width()) : ae.minScroll, N = void 0 === ae.maxScroll ? 0 : ae.maxScroll, j = null, !X && ae.rtl && (t = N, N = -A, A = -t), o(ae.snap) && (j = [], U.find(ae.snap)
					.each(function () {
						var e = X ? this.offsetTop : this.offsetLeft
							, t = X ? this.offsetHeight : this.offsetWidth;
						j.push({
							breakpoint: e + t / 2
							, snap1: -e
							, snap2: b - e - t
						})
					})), z = r(ae.snap) ? ae.snap : 1, V = ae.snap ? ae.maxSnapScroll : 0, w = ae.easing, M = ae.elastic ? r(ae.snap) ? z : r(ae.elastic) ? ae.elastic : 0 : 0, void 0 === Z && (Z = ae.initialPos, ee = Math.round(Z / z)), e || Q.scroll(ae.snap ? j ? j[ee]["snap" + te] : ee * z : Z)
			}, Q._processSettings = function () {
				X = "Y" == ae.axis, T = X ? "top" : "left", U = ae.moveElement || ne.children()
					.eq(0), K = U[0].style, q = X ? ae.thresholdY : ae.thresholdX
			}, Q._init = function () {
				Q.refresh(), ne.on("touchstart mousedown", n)
					.on("touchmove", s)
					.on("touchend touchcancel", c), ae.mousewheel && ne.on("wheel mousewheel", d), e.addEventListener && e.addEventListener("click", function (e) {
						Q.scrolled && (Q.scrolled = !1, e.stopPropagation(), e.preventDefault())
					}, !0)
			}, Q._destroy = function () {
				clearInterval(Y), ne.off("touchstart mousedown", n)
					.off("touchmove", s)
					.off("touchend touchcancel", c)
					.off("wheel mousewheel", d)
			}, ae = Q.settings, G = Q.trigger, a || Q.init(t)
		};
	Ge.prototype = {
		_defaults: {
			speedUnit: .0022
			, timeUnit: 3
			, initialPos: 0
			, axis: "Y"
			, thresholdX: 10
			, thresholdY: 5
			, easing: "cubic-bezier(0.190, 1.000, 0.220, 1.000)"
			, stopProp: !0
			, momentum: !0
			, mousewheel: !0
			, elastic: !0
		}
	};
	var Xe = Te ? window.CSS : null
		, Ze = Xe && Xe.supports && Xe.supports("(transform-style: preserve-3d)")
		, Qe = !Ze || "wp" == pe || "android" == pe;
	ie.presetShort("scroller", "Scroller", !1);
	var et = function (e, t, a) {
		function s(e) {
			var t = +ke(this)
				.attr("data-index");
			e.stopPropagation(), "mousedown" === e.type && e.preventDefault(), y(e, this) && !T(t) && (A = ke(this)
				.addClass("mbsc-sc-btn-a"), z = u(e, "X"), j = u(e, "Y"), E = !0, Y = !1, setTimeout(function () {
					v(t, "inc" == A.attr("data-dir") ? 1 : -1)
				}, 100), "mousedown" === e.type && ke(document)
				.on("mousemove", o)
				.on("mouseup", i))
		}

		function o(e) {
			(Math.abs(z - u(e, "X")) > 7 || Math.abs(j - u(e, "Y")) > 7) && g(!0)
		}

		function i(e) {
			g(), e.preventDefault(), "mouseup" === e.type && ke(document)
				.off("mousemove", o)
				.off("mouseup", i)
		}

		function l(e) {
			var t, a, n = ke(this)
				.attr("data-index");
			38 == e.keyCode ? (t = !0, a = -1) : 40 == e.keyCode ? (t = !0, a = 1) : 32 == e.keyCode && (t = !0, d(n, q[n]._$markup.find('.mbsc-sc-itm[data-val="' + W[n] + '"]'))), t && (e.stopPropagation(), e.preventDefault(), a && !E && (E = !0, Y = !1, v(n, a)))
		}

		function c() {
			g()
		}

		function d(e, t) {
			var a = q[e]
				, s = t.attr("data-index")
				, o = b(a, s)
				, i = Q._tempSelected[e]
				, l = r(a.multiple) ? a.multiple : 1 / 0;
			!1 !== U("onItemTap", {
				target: t[0]
				, index: e
				, value: o
				, selected: t.hasClass("mbsc-sc-itm-sel")
			}) && (a.multiple && !a._disabled[o] && (void 0 !== i[o] ? (t.removeClass(P)
				.removeAttr("aria-selected"), delete i[o]) : (1 == l && (Q._tempSelected[e] = i = {}, a._$markup.find(".mbsc-sc-itm-sel")
					.removeClass(P)
					.removeAttr("aria-selected")), n(i)
				.length < l && (t.addClass(P)
					.attr("aria-selected", "true"), i[o] = o))), D(a, e, s, Z, !0, !0, a.multiple), !Q.live || a.multiple || !0 !== K.setOnTap && !K.setOnTap[e] || setTimeout(function () {
				Q.select()
			}, 200))
		}

		function m(e, t) {
			return (e._array ? e._map[t] : e.getIndex(t, Q)) || 0
		}

		function h(e, t) {
			var a = e.data;
			if (t >= e.min && t <= e.max) return e._array ? e.circular ? ke(a)
				.get(t % e._length) : a[t] : ke.isFunction(a) ? a(t, Q) : ""
		}

		function f(e) {
			return ke.isPlainObject(e) ? void 0 !== e.value ? e.value : e.display : e
		}

		function p(e) {
			var t = ke.isPlainObject(e) ? e.display : e;
			return void 0 === t ? "" : t 
		}

		function b(e, t) {
			return f(h(e, t))
		}

		function v(e, t) {
			Y || x(e, t), E && ie.Wodxy && (clearInterval(L), L = setInterval(function () {
				x(e, t)
			}, K.delay))
		}

		function g(e) {
			clearInterval(L), Y = e, E = !1, A && A.removeClass("mbsc-sc-btn-a")
		}

		function x(e, t) {
			var a = q[e];
			D(a, e, a._current + t, Z, 1 == t ? 1 : 2)
		}

		function T(e) {
			return ke.isArray(K.readonly) ? K.readonly[e] : K.readonly
		}

		function _(e, t, a) {
			var n = e._index - e._batch;
			return e.data = e.data || [], e.key = void 0 !== e.key ? e.key : t, e.label = void 0 !== e.label ? e.label : t, e._map = {}, e._array = ke.isArray(e.data), e._array && (e._length = e.data.length, ke.each(e.data, function (t, a) {
				e._map[f(a)] = t
			})), e.circular = void 0 === K.circular ? void 0 === e.circular ? e._array && e._length > K.rows : e.circular : ke.isArray(K.circular) ? K.circular[t] : K.circular, e.min = e._array ? e.circular ? -1 / 0 : 0 : void 0 === e.min ? -1 / 0 : e.min, e.max = e._array ? e.circular ? 1 / 0 : e._length - 1 : void 0 === e.max ? 1 / 0 : e.max, e._nr = t, e._index = m(e, W[t]), e._disabled = {}, e._batch = 0, e._current = e._index, e._first = e._index - X, e._last = e._index + X, e._offset = e._first, a ? (e._offset -= e._margin / $ + (e._index - n), e._margin += (e._index - n) * $) : e._margin = 0, e._refresh = function (t) {
				var a = -(e.min - e._offset + (e.multiple && !H ? Math.floor(K.rows / 2) : 0)) * $
					, n = Math.min(a, -(e.max - e._offset - (e.multiple && !H ? Math.floor(K.rows / 2) : 0)) * $);
				Ve(e._scroller.settings, {
					minScroll: n
					, maxScroll: a
				}), e._scroller.refresh(t)
			}, G[e.key] = e, e
		}

		function w(e, t, a, n, s) {
			var r, o, i, l, c, d, m, u, b = ""
				, v = Q._tempSelected[t]
				, g = e._disabled || {};
			for (r = a; r <= n; r++) i = h(e, r), c = p(i), l = f(i), o = i && void 0 !== i.cssClass ? i.cssClass : "", d = i && void 0 !== i.label ? i.label : "", m = i && i.invalid, u = void 0 !== l && l == W[t] && !e.multiple, b += '<div role="option" aria-selected="' + !!v[l] + '" class="mbsc-sc-itm ' + (s ? "mbsc-sc-itm-3d " : "") + o + " " + (u ? "mbsc-sc-itm-sel " : "") + (v[l] ? P : "") + (void 0 === l ? " mbsc-sc-itm-ph" : " mbsc-btn-e") + (m ? " mbsc-sc-itm-inv-h mbsc-btn-d" : "") + (g[l] ? " mbsc-sc-itm-inv mbsc-btn-d" : "") + '" data-index="' + r + '" data-val="' + l + '"' + (d ? ' aria-label="' + d + '"' : "") + (u ? ' aria-selected="true"' : "") + ' style="height:' + $ + "px;line-height:" + $ + "px;" + (s ? Pe + "transform:rotateX(" + (e._offset - r) * F % 360 + "deg) translateZ(" + $ * K.rows / 2 + "px);" : "") + '">' + (B > 1 ? '<div class="mbsc-sc-itm-ml" style="line-height:' + Math.round($ / B) + "px;font-size:" + Math.round($ / B * .8) + 'px;">' : "") + c + (B > 1 ? "</div>" : "") + "</div>";
			return b
		}

		function M(t) {
			var a = K.headerText;
			return a ? "function" == typeof a ? a.call(e, t) : a.replace(/\{value\}/i, t) : ""
		}

		function S(e, t, a) {
			var n = Math.round(-a / $) + e._offset
				, s = n - e._current
				, r = e._first
				, o = e._last
				, i = r + X - I + 1
				, l = o - X + I;
			s && (e._first += s, e._last += s, e._current = n, s > 0 ? (e._$scroller.append(w(e, t, Math.max(o + 1, r + s), o + s)), ke(".mbsc-sc-itm", e._$scroller)
				.slice(0, Math.min(s, o - r + 1))
				.remove(), H && (e._$3d.append(w(e, t, Math.max(l + 1, i + s), l + s, !0)), ke(".mbsc-sc-itm", e._$3d)
					.slice(0, Math.min(s, l - i + 1))
					.attr("class", "mbsc-sc-itm-del"))) : s < 0 && (e._$scroller.prepend(w(e, t, r + s, Math.min(r - 1, o + s))), ke(".mbsc-sc-itm", e._$scroller)
				.slice(Math.max(s, r - o - 1))
				.remove(), H && (e._$3d.prepend(w(e, t, i + s, Math.min(i - 1, l + s), !0)), ke(".mbsc-sc-itm", e._$3d)
					.slice(Math.max(s, i - l - 1))
					.attr("class", "mbsc-sc-itm-del"))), e._margin += s * $, e._$scroller.css("margin-top", e._margin + "px"))
		}

		function C(e, t, a, n) {
			var s, r = q[e]
				, o = n || r._disabled
				, i = m(r, t)
				, l = t
				, c = t
				, d = 0
				, u = 0;
			if (void 0 === t && (t = b(r, i)), !0 === o[t]) {
				for (s = 0; i - d >= r.min && o[l] && s < 100;) s++, d++, l = b(r, i - d);
				for (s = 0; i + u < r.max && o[c] && s < 100;) s++, u++, c = b(r, i + u);
				t = (u < d && u && 2 !== a || !d || i - d < 0 || 1 == a) && !o[c] ? c : l
			}
			return t
		}

		function k(t, a, n, s, r, o) {
			var i, l, c, d, u = Q._isVisible;
			J = !0, d = K.validate.call(e, {
				values: W.slice(0)
				, index: a
				, direction: n
			}, Q) || {}, J = !1, d.valid && (Q._tempWheelArray = W = d.valid.slice(0)), o || ke.each(q, function (e, s) {
				if (u && s._$markup.find(".mbsc-sc-itm-inv")
					.removeClass("mbsc-sc-itm-inv mbsc-btn-d"), s._disabled = {}, d.disabled && d.disabled[e] && ke.each(d.disabled[e], function (e, t) {
						s._disabled[t] = !0, u && s._$markup.find('.mbsc-sc-itm[data-val="' + t + '"]')
							.addClass("mbsc-sc-itm-inv mbsc-btn-d")
					}), W[e] = s.multiple ? W[e] : C(e, W[e], n), u) {
					if (s.multiple && void 0 !== a || s._$markup.find(".mbsc-sc-itm-sel")
						.removeClass(P)
						.removeAttr("aria-selected"), s.multiple) {
						if (void 0 === a)
							for (var o in Q._tempSelected[e]) s._$markup.find('.mbsc-sc-itm[data-val="' + o + '"]')
								.addClass(P)
								.attr("aria-selected", "true")
					} else s._$markup.find('.mbsc-sc-itm[data-val="' + W[e] + '"]')
						.addClass("mbsc-sc-itm-sel")
						.attr("aria-selected", "true");
					l = m(s, W[e]), i = l - s._index + s._batch, Math.abs(i) > 2 * X + 1 && (c = i + (2 * X + 1) * (i > 0 ? -1 : 1), s._offset += c, s._margin -= c * $, s._refresh()), s._index = l + s._batch, s._scroller.scroll(-(l - s._offset + s._batch) * $, a === e || void 0 === a ? t : Z, r)
				}
			}), U("onValidated"), Q._tempValue = K.formatValue(W, Q), u && Q._header.html(M(Q._tempValue)), Q.live && (Q._hasValue = s || Q._hasValue, N(s, s, 0, !0), s && U("onSet", {
				valueText: Q._value
			})), s && U("onChange", {
				valueText: Q._tempValue
			})
		}

		function D(e, t, a, n, s, r, o) {
			var i = b(e, a);
			void 0 !== i && (W[t] = i, e._batch = e._array ? Math.floor(a / e._length) * e._length : 0, setTimeout(function () {
				k(n, t, s, !0, r, o)
			}, 10))
		}

		function N(e, t, a, n, s) {
			if (n ? Q._tempValue = K.formatValue(Q._tempWheelArray, Q) : k(a), !s) {
				Q._wheelArray = [];
				for (var r = 0; r < W.length; r++) Q._wheelArray[r] = q[r] && q[r].multiple ? Object.keys(Q._tempSelected[r])[0] : W[r];
				Q._value = Q._hasValue ? Q._tempValue : null, Q._selected = Ve(!0, {}, Q._tempSelected)
			}
			e && (Q._isInput && ee.val(Q._hasValue ? Q._tempValue : ""), U("onFill", {
				valueText: Q._hasValue ? Q._tempValue : ""
				, change: t
			}), t && (Q._preventChange = !0, ee.trigger("change")))
		}
		var V, A, I, F, H, P, O, L, E, Y, z, j, W, $, R, J, K, U, B, q, G, X = 40
			, Z = 1e3
			, Q = this
			, ee = ke(e);
		Be.call(this, e, t, !0), Q.setVal = Q._setVal = function (t, a, n, s, r) {
			Q._hasValue = null !== t && void 0 !== t, Q._tempWheelArray = W = ke.isArray(t) ? t.slice(0) : K.parseValue.call(e, t, Q) || [], N(a, void 0 === n ? a : n, r, !1, s)
		}, Q.getVal = Q._getVal = function (e) {
			var t = Q._hasValue || e ? Q[e ? "_tempValue" : "_value"] : null;
			return r(t) ? +t : t
		}, Q.setArrayVal = Q.setVal, Q.getArrayVal = function (e) {
			return e ? Q._tempWheelArray : Q._wheelArray
		}, Q.changeWheel = function (e, t, a) {
			var n, s;
			ke.each(e, function (e, t) {
				(s = G[e]) && (n = s._nr, Ve(s, t), _(s, n, !0), Q._isVisible && (H && s._$3d.html(w(s, n, s._first + X - I + 1, s._last - X + I, !0)), s._$scroller.html(w(s, n, s._first, s._last))
					.css("margin-top", s._margin + "px"), s._refresh(J)))
			}), !Q._isVisible || Q._isLiquid || J || Q.position(), J || k(t, void 0, void 0, a)
		}, Q.getValidValue = C, Q._generateContent = function () {
			var e, t = 0
				, a = ""
				, n = H ? Pe + "transform: translateZ(" + ($ * K.rows / 2 + 3) + "px);" : ""
				, s = '<div class="mbsc-sc-whl-l" style="' + n + "height:" + $ + "px;margin-top:-" + ($ / 2 + (K.selectedLineBorder || 0)) + 'px;"></div>'
				, r = 0;
			return ke.each(K.wheels, function (o, i) {
				a += '<div class="mbsc-w-p mbsc-sc-whl-gr-c' + (H ? " mbsc-sc-whl-gr-3d-c" : "") + (K.showLabel ? " mbsc-sc-lbl-v" : "") + '">' + s + '<div class="mbsc-sc-whl-gr' + (H ? " mbsc-sc-whl-gr-3d" : "") + (O ? " mbsc-sc-cp" : "") + (K.width || K.maxWidth ? '"' : '" style="max-width:' + K.maxPopupWidth + 'px;"') + ">", ke.each(i, function (o, i) {
					Q._tempSelected[r] = Ve({}, Q._selected[r]), q[r] = _(i, r), t += K.maxWidth ? K.maxWidth[r] || K.maxWidth : K.width ? K.width[r] || K.width : 0, e = void 0 !== i.label ? i.label : o, a += '<div class="mbsc-sc-whl-w ' + (i.cssClass || "") + (i.multiple ? " mbsc-sc-whl-multi" : "") + '" style="' + (K.width ? "width:" + (K.width[r] || K.width) + "px;" : (K.minWidth ? "min-width:" + (K.minWidth[r] || K.minWidth) + "px;" : "") + (K.maxWidth ? "max-width:" + (K.maxWidth[r] || K.maxWidth) + "px;" : "")) + '"><div class="mbsc-sc-whl-o" style="' + n + '"></div>' + s + '<div tabindex="0" aria-live="off" aria-label="' + e + '"' + (i.multiple ? ' aria-multiselectable="true"' : "") + ' role="listbox" data-index="' + r + '" class="mbsc-sc-whl" style="height:' + K.rows * $ * (H ? 1.1 : 1) + 'px;">' + (O ? '<div data-index="' + r + '" data-dir="inc" class="mbsc-sc-btn mbsc-sc-btn-plus ' + (K.btnPlusClass || "") + '" style="height:' + $ + "px;line-height:" + $ + 'px;"></div><div data-index="' + r + '" data-dir="dec" class="mbsc-sc-btn mbsc-sc-btn-minus ' + (K.btnMinusClass || "") + '" style="height:' + $ + "px;line-height:" + $ + 'px;"></div>' : "") + '<div class="mbsc-sc-lbl">' + e + '</div><div class="mbsc-sc-whl-c" style="height:' + R + "px;margin-top:-" + (R / 2 + 1) + "px;" + n + '"><div class="mbsc-sc-whl-sc" style="top:' + (R - $) / 2 + 'px;">', a += w(i, r, i._first, i._last) + "</div></div>", H && (a += '<div class="mbsc-sc-whl-3d" style="height:' + $ + "px;margin-top:-" + $ / 2 + 'px;">', a += w(i, r, i._first + X - I + 1, i._last - X + I, !0), a += "</div>"), a += "</div></div>", r++
				}), a += "</div></div>"
			}), t && (K.maxPopupWidth = t), a
		}, Q._attachEvents = function (e) {
			ke(".mbsc-sc-btn", e)
				.on("touchstart mousedown", s)
				.on("touchmove", o)
				.on("touchend touchcancel", i), ke(".mbsc-sc-whl", e)
				.on("keydown", l)
				.on("keyup", c)
		}, Q._detachEvents = function () {
			for (var e = 0; e < q.length; e++) q[e]._scroller.destroy()
		}, Q._markupReady = function (e) {
			V = e, ke(".mbsc-sc-whl-w", V)
				.each(function (e) {
					var t, a = ke(this)
						, n = q[e]
						, s = -(n.min - n._offset + (n.multiple && !H ? Math.floor(K.rows / 2) : 0)) * $
						, r = Math.min(s, -(n.max - n._offset - (n.multiple && !H ? Math.floor(K.rows / 2) : 0)) * $);
					n._$markup = a, n._$scroller = ke(".mbsc-sc-whl-sc", this), n._$3d = ke(".mbsc-sc-whl-3d", this), n._scroller = new Ge(this, {
						mousewheel: K.mousewheel
						, moveElement: n._$scroller
						, initialPos: (n._first - n._index) * $
						, contSize: 0
						, snap: $
						, minScroll: r
						, maxScroll: s
						, maxSnapScroll: X
						, prevDef: !0
						, stopProp: !0
						, timeUnit: 3
						, easing: "cubic-bezier(0.190, 1.000, 0.220, 1.000)"
						, sync: function (e, t, a) {
							H && (n._$3d[0].style[Oe + "Transition"] = t ? Pe + "transform " + Math.round(t) + "ms " + a : "", n._$3d[0].style[Oe + "Transform"] = "rotateX(" + -e / $ * F + "deg)")
						}
						, onStart: function (t, a) {
							a.settings.readonly = T(e)
						}
						, onGestureStart: function () {
							a.addClass("mbsc-sc-whl-a mbsc-sc-whl-anim"), U("onWheelGestureStart", {
								index: e
							})
						}
						, onGestureEnd: function (a) {
							var s = 90 == a.direction ? 1 : 2
								, r = a.duration
								, o = a.destinationY;
							t = Math.round(-o / $) + n._offset, D(n, e, t, r, s)
						}
						, onAnimationStart: function () {
							a.addClass("mbsc-sc-whl-anim")
						}
						, onAnimationEnd: function () {
							a.removeClass("mbsc-sc-whl-a mbsc-sc-whl-anim"), U("onWheelAnimationEnd", {
									index: e
								}), n._$3d.find(".mbsc-sc-itm-del")
								.remove()
						}
						, onMove: function (t) {
							S(n, e, t.posY)
						}
						, onBtnTap: function (t) {
							d(e, ke(t.target))
						}
					})
				}), k()
		}, Q._fillValue = function () {
			Q._hasValue = !0, N(!0, !0, 0, !0)
		}, Q._clearValue = function () {
			ke(".mbsc-sc-whl-multi .mbsc-sc-itm-sel", V)
				.removeClass(P)
				.removeAttr("aria-selected")
		}, Q._readValue = function () {
			var t = ee.val() || ""
				, a = 0;
			"" !== t && (Q._hasValue = !0), Q._tempWheelArray = W = Q._hasValue && Q._wheelArray ? Q._wheelArray.slice(0) : K.parseValue.call(e, t, Q) || [], Q._tempSelected = Ve(!0, {}, Q._selected), ke.each(K.wheels, function (e, t) {
				ke.each(t, function (e, t) {
					q[a] = _(t, a), a++
				})
			}), N(!1, !1, 0, !0), U("onRead")
		}, Q.__processSettings = function () {
			K = Q.settings, U = Q.trigger, B = K.multiline, P = "mbsc-sc-itm-sel mbsc-ic mbsc-ic-" + K.checkIcon, q = [], G = {}
		}, Q.__init = function () {
			O = K.showScrollArrows, H = K.scroll3d && !Qe && !O, $ = K.height, R = H ? 2 * Math.round(($ - .03 * ($ * K.rows / 2 + 3)) / 2) : $, I = Math.round(1.8 * K.rows), F = 360 / (2 * I), O && (K.rows = Math.max(3, K.rows)), K.cssClass = (K.cssClass || "") + " mbsc-sc"
		}, Q._getItemValue = f, Q._tempSelected = {}, Q._selected = {}, a || Q.init(t)
	};
	et.prototype = {
		_hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _hasPreset: !0
		, _class: "scroller"
		, _defaults: Ve({}, Be.prototype._defaults, {
			minWidth: 80
			, height: 40
			, rows: 3
			, multiline: 1
			, delay: 300
			, readonly: !1
			, showLabel: !0
			, setOnTap: !1
			, wheels: []
			, preset: ""
			, speedUnit: .0012
			, timeUnit: .08
			, checkIcon: "checkmark"
			, validate: function () {}
			, formatValue: function (e) {
				return e.join(" ")
			}
			, parseValue: function (e, t) {
				var a, n, s = []
					, r = []
					, o = 0;
				return null !== e && void 0 !== e && (s = (e + "")
					.split(" ")), ke.each(t.settings.wheels, function (e, i) {
					ke.each(i, function (e, i) {
						n = i.data, a = t._getItemValue(n[0]), ke.each(n, function (e, n) {
							if (s[o] == t._getItemValue(n)) return a = t._getItemValue(n), !1
						}), r.push(a), o++
					})
				}), r
			}
		})
	}, ie.classes.Scroller = et;
	
	
	(function(a) {
    var d = ie,
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
        ie.presets.scroller[a] = h;
    });
}());
	
	
	var nt = {
			controls: ["calendar"]
			, firstDay: 0
			, weekDays: "short"
			, maxMonthWidth: 170
			, months: 1
			, pageBuffer: 1
			, weeks: 6
			, highlight: !0
			, outerMonthChange: !0
			, quickNav: !0
			, yearChange: !0
			, tabs: "auto"
			, todayClass: "mbsc-cal-today"
			, btnCalPrevClass: "mbsc-ic mbsc-ic-arrow-left6"
			, btnCalNextClass: "mbsc-ic mbsc-ic-arrow-right6"
			, dateText: "Date"
			, timeText: "Time"
			, calendarText: "Calendar"
			, todayText: "Today"
			, prevMonthText: "Previous Month"
			, nextMonthText: "Next Month"
			, prevYearText: "Previous Year"
			, nextYearText: "Next Year"
		}
		, st = function (e) {
			function t(t) {
				t.hasClass("mbsc-cal-h") && (t.removeClass("mbsc-cal-h"), e._onSelectShow())
			}

			function n(e) {
				e.hasClass("mbsc-cal-h") || e.addClass("mbsc-cal-h")
			}

			function s(e) {
				e.hasClass("mbsc-cal-h") ? t(e) : n(e)
			}

			function r(e, t, a) {
				var n, s, r, o, i, l = {}
					, c = Pe + Oe;
				return e && ke.each(e, function (e, d) {
					if (n = d.d || d.start || d, r = n + "", d.start && d.end)
						for (o = new Date(d.start); o <= d.end;) i = v(o.getFullYear(), o.getMonth(), o.getDate()), l[i] = l[i] || [], l[i].push(d), o.setDate(o.getDate() + 1);
					else if (n.getTime) i = v(n.getFullYear(), n.getMonth(), n.getDate()), l[i] = l[i] || [], l[i].push(d);
					else if (r.match(/w/i)) {
						var m = +r.replace("w", "")
							, u = 0
							, h = je.getDate(t, a - Pe - Ee, 1)
							.getDay();
						for (je.firstDay - h + 1 > 1 && (u = 7), s = 0; s < 5 * Ye; s++) i = je.getDate(t, a - Pe - Ee, 7 * s - u - h + 1 + m), l[i] = l[i] || [], l[i].push(d)
					} else if (r = r.split("/"), r[1]) a + c >= 11 && (i = je.getDate(t + 1, r[0] - 1, r[1]), l[i] = l[i] || [], l[i].push(d)), a - c <= 1 && (i = je.getDate(t - 1, r[0] - 1, r[1]), l[i] = l[i] || [], l[i].push(d)), i = je.getDate(t, r[0] - 1, r[1]), l[i] = l[i] || [], l[i].push(d);
					else
						for (s = 0; s < Ye; s++) i = je.getDate(t, a - Pe - Ee + s, r[0]), je.getDay(i) == r[0] && (l[i] = l[i] || [], l[i].push(d))
				}), l
			}

			function o(e) {
				return !(e < Me) && (!(e > xe) && (void 0 === ue[e] || void 0 !== Re[e]))
			}

			function i(t) {
				var a, n, s, r, o = !!ve[t] && ve[t]
					, i = "";
				if (o) {
					for (r = '<div class="mbsc-cal-marks">', a = 0; a < o.length; a++) r += '<div class="mbsc-cal-mark"' + (o[a].color ? ' style="background:' + o[a].color + ';"' : "") + "></div>", o[a].icon && (i += '<span class="mbsc-ic mbsc-ic-' + o[a].icon + '"' + (o[a].text ? "" : o[a].color ? ' style="color:' + o[a].color + ';"' : "") + "></span>\n");
					r += "</div>", de && (je.showEventCount ? n = ve[t].length + " " + (ve[t].length > 1 ? je.eventsText : je.eventText) : o[0] && (n = o[0].text, s = o[0].color), n ? r = '<div class="mbsc-cal-txt" title="' + ke("<div>" + n + "</div>")
						.text() + '"' + (s ? ' style="background:' + s + ";color:" + w(s) + ';"' : "") + ">" + i + n + "</div>" : i && (r = '<div class="mbsc-cal-txt mbsc-cal-icons">' + i + "</div>"))
				}
				return Ve({
					marked: o
					, cssClass: o ? "mbsc-cal-day-marked" : ""
					, ariaLabel: de ? n : ""
					, markup: r
				}, e._getDayProps(t))
			}

			function l(e) {
				return ' style="' + (be ? "transform: translateY(" + 100 * e + "%)" : "left:" + 100 * e * ze + "%") + '"'
			}

			function c() {
				Le = "auto" == je.months ? Math.max(1, Math.min(3, Math.floor((Z || S(Q)) / 280))) : je.months, Ye = Le + 2 * Pe, Oe = Math.floor(Le / 2), Ee = Math.round(Le / 2) - 1, We = void 0 === je.showOuterDays ? Le < 2 : je.showOuterDays, be = be && Le < 2, X = Z || 280 * Le
			}

			function m(t, a) {
				ue = r(je.invalid, t, a), Re = r(je.valid, t, a), ve = r(e._events || je.events || je.marked, t, a)
			}

			function u(e) {
				var t = je.getYear(e)
					, a = je.getMonth(e);
				se = e, $e("onMonthChange", {
					year: t
					, month: a
				}), $e("onMonthLoading", {
					year: t
					, month: a
				}), m(t, a), k(e)
			}

			function h(e) {
				var t = je.getYear(e)
					, a = je.getMonth(e);
				void 0 !== He ? x(e, He, !0) : $e("onMonthLoaded", {
					year: t
					, month: a
				})
			}

			function f() {
				var e;
				return e = '<div class="mbsc-cal-tabs-c"><ul class="mbsc-cal-tabs" role="tablist">', je.controls.forEach(function (t, a) {
					ee[t] && (e += '<li role="tab" aria-controls="' + Qe.id + "-mbsc-pnl-" + a + '" class="mbsc-cal-tab mbsc-fr-btn-e ' + (a ? "" : ne) + '" data-control="' + t + '">' + (je.tabLink ? '<a href="#">' + je[t + "Text"] + "</a>" : je[t + "Text"]) + "</li>")
				}), e += "</ul></div>"
			}

			function p() {
				var e, t, a, n, s = ""
					, r = pe ? je.btnCalNextClass : je.btnCalPrevClass
					, o = pe ? je.btnCalPrevClass : je.btnCalNextClass;
				for (n = '<div class="mbsc-cal-btn-w"><div data-step="-1" role="button" tabindex="0" aria-label="' + je.prevMonthText + '" class="' + r + ' mbsc-cal-prev mbsc-cal-prev-m mbsc-cal-btn mbsc-fr-btn mbsc-fr-btn-e"></div>', t = 0; t < Le; t++) n += '<div role="button" class="mbsc-cal-month"></div>';
				for (n += '<div data-step="1" role="button" tabindex="0" aria-label="' + je.nextMonthText + '" class="' + o + ' mbsc-cal-next mbsc-cal-next-m mbsc-cal-btn mbsc-fr-btn mbsc-fr-btn-e"></div></div>', Be && (s = '<div class="mbsc-cal-btn-w"><div data-step="-12" role="button" tabindex="0" aria-label="' + je.prevYearText + '" class="' + r + ' mbsc-cal-prev mbsc-cal-prev-y mbsc-cal-btn mbsc-fr-btn mbsc-fr-btn-e"></div><div role="button" class="mbsc-cal-year"></div><div data-step="12" role="button" tabindex="0" aria-label="' + je.nextYearText + '" class="' + o + ' mbsc-cal-next mbsc-cal-next-y mbsc-cal-btn mbsc-fr-btn mbsc-fr-btn-e"></div></div>'), e = '<div class="mbsc-w-p mbsc-cal-c"><div class="mbsc-cal ' + (Le > 1 ? " mbsc-cal-multi " : "") + (Ke ? " mbsc-cal-weeks " : "") + (be ? " mbsc-cal-vertical" : "") + (ce ? " mbsc-cal-has-marks" : "") + (de ? " mbsc-cal-has-txt" : "") + (We ? "" : " mbsc-cal-hide-diff ") + (je.calendarClass || "") + '"' + (fe ? "" : ' style="width:' + (Z || 280 * Le) + 'px;"') + '><div class="mbsc-cal-hdr">' + (qe < Ne || Le > 1 ? s + n : n + s) + '</div><div class="mbsc-cal-body"><div class="mbsc-cal-day-picker"><div class="mbsc-cal-days-c">', a = 0; a < Le; a++) {
					for (e += '<div class="mbsc-cal-days">', t = 0; t < 7; t++) e += "<div>" + je["dayNames" + Ue][(t + je.firstDay) % 7] + "</div>";
					e += "</div>"
				}
				if (e += '</div><div class="mbsc-cal-scroll-c mbsc-cal-day-scroll-c ' + (je.calendarClass || "") + '"><div class="mbsc-cal-scroll" style="width:' + 100 / Le + '%">' + x(se) + "</div></div></div>", me) {
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
				var a, n = je.getYear(e)
					, s = '<div class="mbsc-cal-slide"' + l(t) + '><div role="grid" class="mbsc-cal-table"><div class="mbsc-cal-row">';
				for (a = 0; a < 12; a++) a && a % 3 == 0 && (s += '</div><div class="mbsc-cal-row">'), s += '<div role="gridcell" tabindex="-1" aria-label="' + n + '" data-val="' + n + '" class="mbsc-cal-cell mbsc-btn-e ' + (n < De || n > _e ? " mbsc-btn-d mbsc-fr-btn-d " : "") + (n == je.getYear(se) ? ae : "") + '"><div class="mbsc-cal-cell-i mbsc-cal-cell-txt">' + n + Ze + "</div></div>", n++;
				return s += "</div></div></div>"
			}

			function g(t, a) {
				var n, s, r, c, d, m, u, h, f, p, b, v, g, x, T, y, _ = 1
					, w = 0
					, M = je.getYear(t)
					, S = je.getMonth(t)
					, C = je.getDay(t)
					, k = null !== je.defaultValue || e._hasValue ? e.getDate(!0) : null
					, D = je.getDate(M, S, C)
					.getDay()
					, N = '<div class="mbsc-cal-slide"' + l(a) + '><div role="grid" class="mbsc-cal-table"><div class="mbsc-cal-row">';
				for (je.firstDay - D > 0 && (w = 7), y = 0; y < 7 * G; y++) T = y + je.firstDay - w, n = je.getDate(M, S, T - D + C), r = n.getFullYear(), c = n.getMonth(), d = n.getDate(), m = je.getMonth(n), u = je.getDay(n), x = je.getMaxDayOfMonth(r, c), h = r + "-" + (c + 1) + "-" + d, f = Ve({
						valid: o(n)
						, selected: k && k.getFullYear() === r && k.getMonth() === c && k.getDate() === d
					}, i(n)), p = f.valid, b = f.selected, s = f.cssClass, v = new Date(n)
					.setHours(12, 0, 0, 0) === (new Date)
					.setHours(12, 0, 0, 0), g = m !== S, re[h] = f, y && y % 7 == 0 && (N += '</div><div class="mbsc-cal-row">'), Ke && y % 7 == 0 && ("month" == Ke && g && _ > 1 ? _ = 1 == d ? 1 : 2 : "year" == Ke && (_ = je.getWeekNumber(je.getDate(r, c, d + (7 - je.firstDay + 1) % 7))), N += '<div role="gridcell" class="mbsc-cal-cell mbsc-cal-week-nr">' + _ + "</div>", _++), N += '<div role="gridcell" tabindex="-1" aria-label="' + (v ? je.todayText + ", " : "") + je.dayNames[n.getDay()] + ", " + je.monthNames[m] + " " + u + " " + (f.ariaLabel ? ", " + f.ariaLabel : "") + '"' + (g && !We ? ' aria-hidden="true"' : "") + (b ? ' aria-selected="true"' : "") + (p ? "" : ' aria-disabled="true"') + ' data-full="' + h + '"class="mbsc-cal-cell mbsc-cal-day mbsc-cal-day' + T % 7 + " " + (je.dayClass || "") + " " + (b ? ae : "") + (v ? " " + je.todayClass : "") + (s ? " " + s : "") + (1 == u ? " mbsc-cal-day-first" : "") + (u == x ? " mbsc-cal-day-last" : "") + (g ? " mbsc-cal-day-diff" : "") + (p ? " mbsc-btn-e" : " mbsc-btn-d") + '"><div class="mbsc-cal-cell-i mbsc-cal-day-i"><div class="mbsc-cal-day-date mbsc-cal-cell-txt">' + u + "</div>" + (f.markup || "") + "</div></div>";
				return N += "</div></div></div>"
			}

			function x(e, t, a) {
				var n, s = je.getYear(e)
					, r = je.getMonth(e)
					, o = oe ? oe.pos : 0
					, i = "";
				for (t || $e("onMonthLoading", {
						year: s
						, month: r
					}), m(s, r), n = 0; n < Ye; n++) i += g(I(e, n - Ee - Pe), o + n - Pe);
				return He = void 0, a && oe && (oe.$scroller.html(i), $e("onMonthLoaded", {
					year: s
					, month: r
				})), i
			}

			function T(t) {
				var a = oe && oe.$scroller;
				je.highlight && oe && (ke(".mbsc-selected", a)
					.removeClass(ae)
					.removeAttr("aria-selected"), (null !== je.defaultValue || e._hasValue) && ke('.mbsc-cal-day[data-full="' + t.getFullYear() + "-" + (t.getMonth() + 1) + "-" + t.getDate() + '"]', a)
					.addClass(ae)
					.attr("aria-selected", "true"))
			}

			function y(e, t) {
				ke(".mbsc-selected", t)
					.removeClass(ae)
					.removeAttr("aria-selected"), ke('.mbsc-cal-cell[data-val="' + e + '"]', t)
					.addClass(ae)
					.attr("aria-selected", "true")
			}

			function _(e) {
				var t = e.getDay()
					, a = 0;
				return je.firstDay - t > 0 && (a = 7), e = je.getDate(je.getYear(e), je.getMonth(e), je.firstDay - a - t + je.getDay(e)), je.getWeekNumber(e)
			}

			function C(e, t, a) {
				var n, s, r;
				e < Me && (e = Me), e > xe && (e = xe), le && ("calendar" === Je || t) && (s = je.getYear(e), r = je.getMonth(e), Fe && (n = 6 == G ? r - je.getMonth(se) + 12 * (s - je.getYear(se)) : Math.floor((_(e) - _(se)) / G), se = 6 == G ? je.getDate(s, r, 1) : e, H(oe, n, a)), t || T(e), Fe = !0)
			}

			function k(e) {
				var t, a, n, s = je.getYear(e)
					, r = je.getMonth(e)
					, o = s + Ze;
				if (me) {
					if (y(r, Ie.$scroller), y(s, Xe.$scroller), H(Xe, Math.floor(s / 12) - Math.floor(je.getYear(Xe.first) / 12)), ke(".mbsc-cal-cell", Ie.$scroller)
						.removeClass("mbsc-btn-d mbsc-fr-btn-d"), s === De)
						for (t = 0; t < Ce; t++) ke('.mbsc-cal-cell[data-val="' + t + '"]', Ie.$scroller)
							.addClass("mbsc-btn-d mbsc-fr-btn-d");
					if (s === _e)
						for (t = ye + 1; t <= 12; t++) ke('.mbsc-cal-cell[data-val="' + t + '"]', Ie.$scroller)
							.addClass("mbsc-btn-d mbsc-fr-btn-d")
				}
				for (D(ke(".mbsc-cal-prev-m", W), je.getDate(s, r - Ee - 1, 1) < we), D(ke(".mbsc-cal-next-m", W), je.getDate(s, r + Le - Ee, 1) > ge), D(ke(".mbsc-cal-prev-y", W), je.getDate(s - 1, r, 1) < we), D(ke(".mbsc-cal-next-y", W), je.getDate(s + 1, r, 1) > ge), U.attr("aria-label", s)
					.html(o), t = 0; t < Le; t++) e = je.getDate(s, r - Ee + t, 1), a = je.getYear(e), n = je.getMonth(e), o = a + Ze, $.eq(t)
					.attr("aria-label", je.monthNames[n] + (Be ? "" : " " + s))
					.html((!Be && qe < Ne ? o + " " : "") + Ae[n] + (!Be && qe > Ne ? " " + o : ""))
			}

			function D(e, t) {
				t ? e.addClass(te)
					.attr("aria-disabled", "true") : e.removeClass(te)
					.removeAttr("aria-disabled")
			}

			function N(t) {
				var a = e.live
					, n = e.getDate(!0)
					, s = t.attr("data-full")
					, r = s.split("-")
					, o = v(r[0], r[1] - 1, r[2])
					, i = v(o.getFullYear(), o.getMonth(), o.getDate(), n.getHours(), n.getMinutes(), n.getSeconds())
					, l = t.hasClass("mbsc-selected");
				je.readonly || !We && t.hasClass("mbsc-cal-day-diff") || !1 !== $e("onDayChange", Ve(re[s], {
					date: i
					, target: t[0]
					, selected: l
				})) && (Fe = je.outerMonthChange, he = !0, e.setDate(i, a, 0, !a, !0), a && $e("onSet", {
					valueText: e._value
				}))
			}

			function V(e) {
				n(R), C(je.getDate(je.getYear(oe.first), e.attr("data-val"), 1), !0)
			}

			function A(e) {
				n(B), C(je.getDate(e.attr("data-val"), je.getMonth(oe.first), 1), !0)
			}

			function I(e, t) {
				var a = je.getYear(e)
					, n = je.getMonth(e)
					, s = je.getDay(e);
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
				var n, s, r = ""
					, o = e.$scroller
					, i = e.buffer
					, l = e.offset
					, c = e.pages
					, d = e.total
					, m = e.first
					, u = e.genPage
					, h = e.getFirst
					, f = t > 0 ? Math.min(t, i) : Math.max(t, -i)
					, p = e.pos * ze + f - t + l
					, b = Math.abs(t) > i;
				if (e.first = h(m, t), e.pos += f * ze, e.changing = !0, e.onBeforeChange(e.first), b) {
					for (n = 0; n < c; n++) s = t + n - l, r += u(h(m, s), p + s);
					t > 0 ? (ke(".mbsc-cal-slide", o)
						.slice(-c)
						.remove(), o.append(r)) : t < 0 && (ke(".mbsc-cal-slide", o)
						.slice(0, c)
						.remove(), o.prepend(r))
				}
				e.scroller.scroll(-e.pos * e.size, 200, !1, function () {
					var r = Math.abs(f)
						, c = "";
					for (n = 0; n < r; n++) s = t + n - l - i + (t > 0 ? d - r : 0), c += u(h(m, s), p + s);
					if (t > 0 ? (o.append(c), ke(".mbsc-cal-slide", o)
							.slice(0, f)
							.remove()) : t < 0 && (o.prepend(c), ke(".mbsc-cal-slide", o)
							.slice(f)
							.remove()), b) {
						for (c = "", n = 0; n < r; n++) s = t + n - l - i + (t > 0 ? 0 : d - r), c += u(h(m, s), p + s);
						t > 0 ? (ke(".mbsc-cal-slide", o)
							.slice(0, f)
							.remove(), o.prepend(c)) : t < 0 && (ke(".mbsc-cal-slide", o)
							.slice(f)
							.remove(), o.append(c))
					}
					L(e), a && a(), e.queue.shift(), e.queue.length ? P.apply(this, e.queue[0]) : (e.changing = !1, e.onAfterChange(e.first))
				})
			}

			function O(e, t, a, n, s, r, o, i, l, c, m, u, h) {
				var f = be ? "Y" : "X"
					, p = {
						$scroller: ke(".mbsc-cal-scroll", e)
						, queue: []
						, buffer: n
						, offset: s
						, pages: r
						, first: i
						, total: o
						, pos: 0
						, min: t
						, max: a
						, genPage: u
						, getFirst: h
						, onBeforeChange: c
						, onAfterChange: m
					};
				return p.scroller = new Ge(e, {
					axis: f
					, easing: ""
					, contSize: 0
					, maxSnapScroll: n
					, mousewheel: je.mousewheel
					, time: 200
					, lock: !0
					, rtl: pe
					, stopProp: !1
					, minScroll: 0
					, maxScroll: 0
					, onBtnTap: function (e) {
						"touchend" == e.domEvent.type && d(), l(ke(e.target))
					}
					, onAnimationEnd: function (e) {
						u && H(p, Math.round((-p.pos * p.size - e["pos" + f]) / p.size) * ze)
					}
				}), p
			}

			function L(e) {
				var t = 0
					, a = 0
					, n = e.first;
				if (e.getFirst) {
					for (t = e.buffer, a = e.buffer; a && e.getFirst(n, a + e.pages - e.offset - 1) > e.max;) a--;
					for (; t && e.getFirst(n, -t - e.offset) < e.min;) t--
				}
				e.size = Math.round(X / e.pages), Ve(e.scroller.settings, {
					snap: e.size
					, minScroll: (-e.pos * ze - a) * e.size
					, maxScroll: (-e.pos * ze + t) * e.size
				}), e.scroller.refresh()
			}

			function E(t) {
				e._isVisible && le && (oe && oe.changing ? He = t : x(se, t, !0))
			}

			function Y() {
				if (le) {
					var t = ke(".mbsc-cal-scroll-c", W);
					oe = O(t[0], we, ge, Pe, Ee, Le, Ye, se, N, u, h, g, I), me && (Ie = O(t[1], null, null, 1, 0, 1, 3, se, V), Xe = O(t[2], Se, Te, 1, 0, 1, 3, se, A, a, a, b, F), e.tap($, function () {
						s(R), n(B)
					}), e.tap(U, function () {
						s(B), n(R)
					})), M(ke(".mbsc-cal-btn", W), function (e, t) {
						var a = 6 == G ? je.getDate(je.getYear(se), je.getMonth(se) + e, 1) : je.getDate(je.getYear(se), je.getMonth(se), je.getDay(se) + e * G * 7);
						a < we || a > ge || C(a, !0, t)
					}), h(se)
				}
				e.tap(ke(".mbsc-cal-tab", W), function () {
					e.changeTab(ke(this)
						.attr("data-control"))
				})
			}
			var z, j, W, $, R, J, K, U, B, q, G, X, Z, Q, ee, te, ae, ne, se, re, oe, le, ce, de, me, ue, he, fe, pe, be, ve, ge, xe, Te, ye, _e, we, Me, Se, Ce, De, Ne, Ae, Ie, Fe, He, Pe, Oe, Le, Ee, Ye, ze, je, We, $e, Re, Je, Ke, Ue, Be, qe, Xe, Ze, Qe = this;
			return function () {
					var t, a, n;
					ee = {}, $e = e.trigger, z = ke(Qe), n = Ve({}, e.settings), je = Ve(e.settings, nt, n), t = je.controls.join(","), pe = je.rtl, Pe = je.pageBuffer, Ke = je.weekCounter, G = je.weeks, be = "vertical" == je.calendarScroll, Q = "inline" == je.display ? z.is("div") ? z : z.parent() : e._$window, Ue = "full" == je.weekDays ? "" : "min" == je.weekDays ? "Min" : "Short", a = je.layout || (/top|bottom|inline/.test(je.display) ? "liquid" : ""), fe = "liquid" == a, Z = fe ? null : je.calendarWidth, ze = pe && !be ? -1 : 1, te = "mbsc-fr-btn-d " + (je.disabledClass || ""), ne = "mbsc-selected " + (je.selectedTabClass || ""), ae = "mbsc-selected " + (je.selectedClass || ""), ce = !!(e._events || je.events || je.marked), de = je.showEventCount || !!je.events, t.match(/date/) && (ee.date = 1), t.match(/time/) && (ee.time = 1), t.match(/calendar/) && (ee.calendar = 1, le = !0), me = je.quickNav && le && 6 == G, Be = je.yearChange && 6 == G, fe && le && "center" == je.display && (e._isFullScreen = !0), je.layout = a, je.preset = (ee.date || le ? "date" : "") + (ee.time ? "time" : "")
				}(), q = jt.datetime.call(this, e)
				, function () {
					Ae = Be ? je.monthNamesShort : je.monthNames, Ze = je.yearSuffix || "", Ne = (je.dateWheels || je.dateFormat)
						.search(/m/i), qe = (je.dateWheels || je.dateFormat)
						.search(/y/i), je.min && (we = v(je.min.getFullYear(), je.min.getMonth(), 1), Me = v(je.min.getFullYear(), je.min.getMonth(), je.min.getDate()), De = je.getYear(we), Ce = je.getMonth(we), Se = je.getDate(12 * Math.floor(De / 12), 0, 1)), je.max && (ge = v(je.max.getFullYear(), je.max.getMonth(), 1), xe = v(je.max.getFullYear(), je.max.getMonth(), je.max.getDate()), _e = je.getYear(ge), ye = je.getMonth(ge), Te = je.getDate(12 * Math.floor(_e / 12), 0, 1))
				}(), e.refresh = function () {
					E(!1)
				}, e.redraw = function () {
					E(!0)
				}, e.navigate = function (e) {
					C(e, !0)
				}, e.changeTab = function (t) {
					e._isVisible && ee[t] && Je != t && (Je = t, ke(".mbsc-cal-tab", W)
						.removeClass(ne)
						.removeAttr("aria-selected"), ke('.mbsc-cal-tab[data-control="' + t + '"]', W)
						.addClass(ne)
						.attr("aria-selected", "true"), K.addClass("mbsc-cal-h"), ee[Je].removeClass("mbsc-cal-h"), "calendar" == Je && C(e.getDate(!0)), e._showDayPicker(), e.trigger("onTabChange", {
							tab: Je
						}))
				}, e._onSelectShow = a, e._getDayProps = a, e._prepareObj = r, e._showDayPicker = function () {
					me && (n(B, !0), n(R, !0))
				}, Ve(q, {
					compClass: "mbsc-calendar mbsc-dt"
					, onMarkupReady: function (t) {
						var a, n, s, r = 0;
						W = ke(t.target), J = ke(".mbsc-fr-c", W), re = {}, s = e.getDate(!0), a = je.getYear(s), n = je.getMonth(s), se = 6 == G ? je.getDate(a, n, 1) : s, le && (Fe = !0, Je = "calendar", c(), J.append(p()), $ = ke(".mbsc-cal-month", W), U = ke(".mbsc-cal-year", W), j = ke(".mbsc-cal-day-scroll-c", W)), me && (B = ke(".mbsc-cal-year-picker", W), R = ke(".mbsc-cal-month-picker", W)), K = ke(".mbsc-w-p", W), je.controls.length > 1 && J.before(f()), ["date", "time", "calendar"].forEach(function (e) {
							ee[e] ? ee[e] = K.eq(r)
								.addClass("mbsc-cal-h") : "date" == e && !ee.date && le && K.eq(r)
								.remove(), r++
						}), je.controls.forEach(function (e) {
							J.append(ee[e])
						}), le && ee.date && (je.tabs = !0), !le && ee.date && ee.date.css("position", "relative"), Y()
					}
					, onShow: function () {
						le && k(se)
					}
					, onHide: function () {
						le && (oe.scroller.destroy(), me && (Ie.scroller.destroy(), Xe.scroller.destroy()), oe = null, Ie = null, Xe = null, Je = null)
					}
					, onValidated: function (t) {
						var a, n, s = e.order;
						n = e.getDate(!0), he ? a = "calendar" : void 0 !== t && (a = s.dd == t || s.d == t || s.m == t || s.y == t ? "date" : "time"), $e("onSetDate", {
							date: n
							, control: a
						}), C(n), he = !1
					}
					, onPosition: function (t) {
						var a, n = t.windowHeight
							, s = (t.hasTabs || !0 === je.tabs || !1 !== je.tabs && fe) && je.controls.length > 1;
						s ? (W.addClass("mbsc-cal-tabbed"), Je = ke(".mbsc-cal-tab.mbsc-selected", W)
							.attr("data-control"), K.addClass("mbsc-cal-h"), ee[Je].removeClass("mbsc-cal-h")) : (Je = "calendar", W.removeClass("mbsc-cal-tabbed"), K.removeClass("mbsc-cal-h")), e._isFullScreen && (j.height(""), a = t.popup.offsetHeight, n >= a && j.height(n - a + j[0].offsetHeight)), le && ((fe || be || s) && (X = j[0][be ? "offsetHeight" : "offsetWidth"]), L(oe)), me && (L(Ie), L(Xe))
					}
				})
		}
		, rt = {};
	ie.presetShort("calendar"), ie.presets.scroller.calendar = function (e) {
		function t(e) {
			return v(e.getFullYear(), e.getMonth(), e.getDate())
		}

		function a(e) {
			if (b = {}, e && e.length)
				for (c = 0; c < e.length; c++) b[t(e[c])] = e[c]
		}

		function s() {
			e.redraw()
		}
		var o, i, l, c, d, m = Ve({}, e.settings)
			, u = Ve(e.settings, rt, m)
			, h = u.defaultValue
			, f = "multiple" == u.select || u.select > 1 || "week" == u.selectType
			, p = r(u.select) ? u.select : 1 / 0
			, b = {};
		if (o = st.call(this, e), l = void 0 === u.firstSelectDay ? u.firstDay : u.firstSelectDay, f && h && h.length)
			for (c = 0; c < h.length; c++) b[t(h[c])] = h[c];
		return e._getDayProps = function (e) {
			return {
				selected: f ? void 0 !== b[e] : void 0
			}
		}, e.setVal = function (t, n, r, o, i) {
			f && (a(t), t = t ? t[0] : null), e._setVal(t, n, r, o, i), s()
		}, e.getVal = function (t) {
			return f ? n(b) : e.getDate(t)
		}, Ve({}, o, {
			highlight: !f
			, outerMonthChange: !f
			, parseValue: function (a) {
				var n, s;
				if (f && a && "string" == typeof a) {
					for (b = {}, a = a.split(","), n = 0; n < a.length; n++) s = x(e._format, a[n].replace(/^\s+|\s+$/g, ""), u), b[t(s)] = s;
					a = a[0]
				}
				return f && h && h.length && (u.defaultValue = h[0]), o.parseValue.call(this, a)
			}
			, formatValue: function (t) {
				var a, n = [];
				if (f) {
					for (a in b) n.push(g(e.format, b[a], u));
					return n.join(", ")
				}
				return o.formatValue.call(this, t)
			}
			, onClear: function () {
				f && (b = {}, s())
			}
			, onBeforeShow: function () {
				void 0 !== u.setOnDayTap || u.buttons && u.buttons.length || (u.setOnDayTap = !0), u.setOnDayTap && "inline" != u.display && (u.outerMonthChange = !1), u.counter && f && (u.headerText = function () {
					var e = 0
						, t = "week" == u.selectType ? 7 : 1;
					return ke.each(b, function () {
							e++
						}), e = Math.round(e / t), (e > 1 ? u.selectedPluralText || u.selectedText : u.selectedText)
						.replace(/{count}/, e)
				})
			}
			, onMarkupReady: function (e) {
				o.onMarkupReady.call(this, e), i = ke(e.target), f && (ke(".mbsc-fr-hdr", i)
					.attr("aria-live", "off"), d = Ve({}, b))
			}
			, onDayChange: function (a) {
				var r = a.date
					, o = t(r)
					, c = ke(a.target)
					, d = a.selected;
				if (f)
					if ("week" == u.selectType) {
						var m, h, g = o.getDay() - l;
						for (g = g < 0 ? 7 + g : g, "multiple" != u.select && (b = {}), m = 0; m < 7; m++) h = v(o.getFullYear(), o.getMonth(), o.getDate() - g + m), d ? delete b[h] : n(b)
							.length / 7 < p && (b[h] = h);
						s()
					} else {
						var x = ke('.mbsc-cal-day[data-full="' + c.attr("data-full") + '"]', i);
						d ? (x.removeClass("mbsc-selected")
								.removeAttr("aria-selected"), delete b[o]) : n(b)
							.length < p && (x.addClass("mbsc-selected")
								.attr("aria-selected", "true"), b[o] = o)
					}
				if (u.setOnDayTap && "multiple" != u.select && "inline" != u.display) return e.setDate(r), e.select(), !1
			}
			, onCancel: function () {
				!e.live && f && (b = Ve({}, d))
			}
		})
	};
	var ot = function (e, t, n) {
			var s, r, o, i, l = this;
			Ae.call(this, e, t, !0), l.__init = a, l.__destroy = a, l._init = function (t) {
				var a;
				i = l.settings, s = ke(e), a = !!r, r = s.parent(), r = r.hasClass("mbsc-input-wrap") ? r.parent() : r, l._$parent = r, o && r.removeClass(o), o = l._css + " mbsc-progress-w mbsc-control-w mbsc-" + i.theme + (i.baseTheme ? " mbsc-" + i.baseTheme : "") + (i.rtl ? " mbsc-rtl" : " mbsc-ltr"), r.addClass(o), s.addClass("mbsc-control"), l.__init(t), a || l._attachChange(), l.refresh()
			}, l._destroy = function () {
				l.__destroy(), r.removeClass(o), s.removeClass("mbsc-control")
			}, n || l.init(t)
		}
		, it = "mbsc-input-wrap"
		, lt = function (e, t, a) {
			function n() {
				var e = s("value", u);
				e !== b && r(e)
			}

			function s(e, t) {
				var a = i.attr(e);
				return void 0 === a || "" === a ? t : +a
			}

			function r(e, t, a, n) {
				e = Math.min(h, Math.max(e, u)), c.css("width", 100 * (e - u) / (h - u) + "%"), void 0 === a && (a = !0), void 0 === n && (n = a), (e !== b || t) && g._display(e), e !== b && (b = e, a && i.attr("value", b), n && i.trigger("change"))
			}
			var o, i, l, c, d, m, u, h, f, p, b, v, g = this;
			ot.call(this, e, t, !0), g._display = function (e) {
				v = p && f.returnAffix ? p.replace(/\{value\}/, e)
					.replace(/\{max\}/, h) : e, d && d.html(v), o && o.html(v)
			}, g._attachChange = function () {
				i.on("change", n)
			}, g.__init = function (t) {
				var a, n, r, v;
				if (f = g.settings, i = ke(e), v = !!l, l = g._$parent, u = g._min = void 0 === t.min ? s("min", f.min) : t.min, h = g._max = void 0 === t.max ? s("max", f.max) : t.max, b = s("value", u), a = i.attr("data-val") || f.val, r = i.attr("data-step-labels"), r = r ? JSON.parse(r) : f.stepLabels, p = i.attr("data-template") || (100 != h || f.template ? f.template : "{value}%"), v ? (a && (o.remove(), l.removeClass("mbsc-progress-value-" + ("right" == a ? "right" : "left"))), r && ke(".mbsc-progress-step-label", m)
						.remove()) : (D(l), C(i), l.find(".mbsc-input-wrap")
						.append('<span class="mbsc-progress-cont"><span class="mbsc-progress-track mbsc-progress-anim"><span class="mbsc-progress-bar"></span></span></span>'), c = g._$progress = l.find(".mbsc-progress-bar"), m = g._$track = l.find(".mbsc-progress-track")), i.attr("min", u)
					.attr("max", h), a && (o = ke('<span class="mbsc-progress-value"></span>'), l.addClass("mbsc-progress-value-" + ("right" == a ? "right" : "left"))
						.find(".mbsc-input-wrap")
						.append(o)), r)
					for (n = 0; n < r.length; ++n) m.append('<span class="mbsc-progress-step-label" style="' + (f.rtl ? "right" : "left") + ": " + 100 * (r[n] - u) / (h - u) + '%" >' + r[n] + "</span>");
				d = ke(i.attr("data-target") || f.target)
			}, g.__destroy = function () {
				l.removeClass("mbsc-ic-left mbsc-ic-right")
					.find(".mbsc-progress-cont")
					.remove(), l.find(".mbsc-input-ic")
					.remove(), i.off("change", n)
			}, g.refresh = function () {
				r(s("value", u), !0, !1)
			}, g.getVal = function () {
				return b
			}, g.setVal = function (e, t, a) {
				r(e, !0, t, a)
			}, a || g.init(t)
		};
	lt.prototype = {
		_class: "progress"
		, _css: "mbsc-progress"
		, _hasTheme: !0
		, _hasLang: !0
		, _hasDef: !0
		, _defaults: {
			min: 0
			, max: 100
			, returnAffix: !0
		}
	}, ie.classes.Progress = lt, ie.presetShort("progress", "Progress");
	var ct = function (e, t, n) {
			function s(t) {
				!y(t, this) || k || e.disabled || ($.stopProp && t.stopPropagation(), k = !0, Y = !1, D = !1, J = u(t, "X"), K = u(t, "Y"), I = J, C.removeClass("mbsc-progress-anim"), T = z ? ke(".mbsc-slider-handle", this) : w, _ && _.removeClass("mbsc-handle-curr"), _ = T.parent()
					.addClass("mbsc-active mbsc-handle-curr"), H = +T.attr("data-index"), q = C[0].offsetWidth, A = C[0].getBoundingClientRect()
					.left, "mousedown" === t.type && (t.preventDefault(), ke(document)
						.on("mousemove", r)
						.on("mouseup", o)))
			}

			function r(e) {
				k && (I = u(e, "X"), F = u(e, "Y"), N = I - J, V = F - K, (Math.abs(N) > 5 || Y) && (Y = !0, Math.abs(Z - new Date) > 50 && (Z = new Date, b(I, $.round, O))), Y ? e.preventDefault() : Math.abs(V) > 7 && p())
			}

			function o(e) {
				k && (e.preventDefault(), z || C.addClass("mbsc-progress-anim"), b(I, !0, !0), Y || D || ("touchend" == e.type && d(), X._onTap(G[H])), p())
			}

			function i() {
				k && p()
			}

			function l() {
				var e = X._readValue(ke(this))
					, t = +ke(this)
					.attr("data-index");
				e !== G[t] && (G[t] = e, j[t] = e, g(e, t))
			}

			function c(e) {
				e.stopPropagation()
			}

			function m(e) {
				e.preventDefault()
			}

			function h(t) {
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
					a && (t.preventDefault(), B || (H = +ke(this)
						.attr("data-index"), g(G[H] + W * a, H, !0), B = setInterval(function () {
							g(G[H] + W * a, H, !0)
						}, 200)))
				}
			}

			function f(e) {
				e.preventDefault(), clearInterval(B), B = null
			}

			function p() {
				k = !1, _.removeClass("mbsc-active"), ke(document)
					.off("mousemove", r)
					.off("mouseup", o)
			}

			function b(e, t, a) {
				var n = t ? Math.min(Math.round(Math.max(100 * (e - A) / q, 0) / R / W) * W * 100 / (L - E), 100) : Math.max(0, Math.min(100 * (e - A) / q, 100));
				P && (n = 100 - n), g(Math.round((E + n / R) * U) / U, H, a, n)
			}

			function v(e) {
				return 100 * (e - E) / (L - E)
			}

			function g(e, t, a, n, s, r) {
				var o = w.eq(t)
					, i = o.parent();
				e = Math.min(L, Math.max(e, E)), void 0 === r && (r = a), X._update ? e = X._update(e, G, t, n, z, s, i) : i.css({
					left: P ? "auto" : (n || v(e)) + "%"
					, right: P ? (n || v(e)) + "%" : "auto"
				}), e > E ? i.removeClass("mbsc-slider-start") : (G[t] > E || s) && i.addClass("mbsc-slider-start"), a && j[t] != e && (D = !0, j[t] = e, G[t] = e, X._fillValue(e, t, r)), o.attr("aria-valuenow", e)
			}
			var x, T, _, w, M, S, C, k, D, N, V, A, I, F, H, P, O, L, E, Y, z, j, W, $, R, J, K, U, B, q, G, X = this
				, Z = new Date;
			ot.call(this, e, t, !0), X._onTap = a, X.___init = a, X.___destroy = a, X._attachChange = function () {
				x.on($.changeEvent, l)
			}, X.__init = function (e) {
				var t;
				w && (t = !0, w.parent()
						.remove()), X.___init(e), S = X._$parent, C = X._$track, x = S.find("input"), $ = X.settings, E = X._min, L = X._max, W = X._step, O = X._live, U = W % 1 != 0 ? 100 / (100 * +(W % 1)
						.toFixed(2)) : 1, R = 100 / (L - E) || 100, z = x.length > 1, P = $.rtl, G = [], j = [], x.each(function (e) {
						G[e] = X._readValue(ke(this)), ke(this)
							.attr("data-index", e)
					}), w = S.find(".mbsc-slider-handle"), M = S.find(z ? ".mbsc-slider-handle-cont" : ".mbsc-progress-cont"), w.on("keydown", h)
					.on("keyup", f)
					.on("blur", f), M.on("touchstart mousedown", s)
					.on("touchmove", r)
					.on("touchend touchcancel", o)
					.on("pointercancel", i), t || (x.on("click", c), S.on("click", m))
			}, X.__destroy = function () {
				S.off("click", m), x.off($.changeEvent, l)
					.off("click", c), w.off("keydown", h)
					.off("keyup", f)
					.off("blur", f), M.off("touchstart mousedown", s)
					.off("touchmove", r)
					.off("touchend touchcancel", o)
					.off("pointercancel", i), X.___destroy()
			}, X.refresh = function () {
				x.each(function (e) {
					g(X._readValue(ke(this)), e, !0, !1, !0, !1)
				})
			}, X.getVal = function () {
				return z ? G.slice(0) : G[0]
			}, X.setVal = X._setVal = function (e, t, a) {
				ke.isArray(e) || (e = [e]), ke.each(e, function (e, t) {
					G[e] = t
				}), ke.each(e, function (e, t) {
					g(t, e, !0, !1, !0, a)
				})
			}, n || X.init(t)
		}
		, dt = function (e, t, a) {
			function n(e) {
				return 100 * (e - p) / (f - p)
			}

			function s(e, t) {
				var a = r.attr(e);
				return void 0 === a || "" === a ? t : "true" === a
			}
			var r, o, i, l, c, d, m, u, h, f, p, b, v, g = this;
			lt.call(this, e, t, !0);
			var x = g.__init
				, T = g.__destroy;
			ct.call(this, e, t, !0);
			var y = g.__init
				, _ = g.__destroy;
			g.__init = function (e) {
				x(e), y(e)
			}, g.__destroy = function () {
				T(), _()
			}, g._update = function (e, t, a, s, r, o, c) {
				return u ? 0 === a ? (e = Math.min(e, t[1]), i.css({
						width: n(t[1]) - n(e) + "%"
						, left: h ? "auto" : n(e) + "%"
						, right: h ? n(e) + "%" : "auto"
					})) : (e = Math.max(e, t[0]), i.css({
						width: n(e) - n(t[0]) + "%"
					})) : r || !d ? c.css({
						left: h ? "auto" : (s || n(e)) + "%"
						, right: h ? (s || n(e)) + "%" : "auto"
					}) : i.css("width", (s || n(e)) + "%"), m && l.eq(a)
					.html(e), r || t[a] == e && !o || g._display(e), e
			}, g._readValue = function (e) {
				return +e.val()
			}, g._fillValue = function (e, t, a) {
				r.eq(t)
					.val(e), a && r.eq(t)
					.trigger("change")
			}, g.___init = function (e) {
				var t, a;
				if (o && (o.removeClass("mbsc-slider-has-tooltip"), 1 != b && ke(".mbsc-slider-step", c)
						.remove()), o = g._$parent, c = g._$track, i = g._$progress, r = o.find("input"), v = g.settings, p = g._min, f = g._max, g._step = b = void 0 === e.step ? +r.attr("step") || v.step : e.step, g._live = s("data-live", v.live), m = s("data-tooltip", v.tooltip), d = s("data-highlight", v.highlight) && r.length < 3, u = d && 2 == r.length, h = v.rtl, m && o.addClass("mbsc-slider-has-tooltip"), 1 != b)
					for (a = (f - p) / b, t = 0; t <= a; ++t) c.append('<span class="mbsc-slider-step" style="' + (h ? "right" : "left") + ":" + 100 / a * t + '%"></span>');
				r.each(function (e) {
					"range" == this.type && ke(this)
						.attr("min", p)
						.attr("max", f)
						.attr("step", b), (d ? i : c)
						.append('<span class="mbsc-slider-handle-cont' + (u && !e ? " mbsc-slider-handle-left" : "") + '"><span tabindex="0" class="mbsc-slider-handle" aria-valuemin="' + p + '" aria-valuemax="' + f + '" data-index="' + e + '"></span>' + (m ? '<span class="mbsc-slider-tooltip"></span>' : "") + "</span>")
				}), l = o.find(".mbsc-slider-tooltip")
			}, a || g.init(t)
		};
	dt.prototype = {
		_class: "progress"
		, _css: "mbsc-progress mbsc-slider"
		, _hasTheme: !0
		, _hasLang: !0
		, _hasDef: !0
		, _defaults: {
			changeEvent: "change"
			, stopProp: !0
			, min: 0
			, max: 100
			, step: 1
			, live: !0
			, highlight: !0
			, round: !0
			, returnAffix: !0
		}
	}, ie.classes.Slider = dt, ie.presetShort("slider", "Slider");
	var mt = ie.util
		, ut = ie.classes
		, ht = function (e, t, a) {
			function n(e, t, a) {
				if (!a) {
					G._value = G._hasValue ? G._tempValue.slice(0) : null;
					for (var n = 0; n < y.length; ++n) y[n].tempChangedColor && G._value && -1 != G._value.indexOf(y[n].tempChangedColor) && (y[n].changedColor = y[n].tempChangedColor), delete y[n].tempChangedColor
				}
				e && (G._isInput && X.val(G._hasValue ? G._tempValue : ""), _("onFill", {
					valueText: G._hasValue ? G._tempValue : ""
					, change: t
				}), t && (Q = Ve(!0, {}, ee), G._preventChange = !0, X.trigger("change")), h(G._value, !0))
			}

			function s(e, t) {
				return t = void 0 !== t ? t : o(e), '<div class="mbsc-color-input-item" data-color="' + (void 0 !== t ? t : e) + '" style="background: ' + e + ';">' + (W ? "" : '<div class="mbsc-color-input-item-close mbsc-ic mbsc-ic-material-close"></div>') + "</div>"
			}

			function r(e) {
				I[0].style.background = e ? Pe + "linear-gradient(left, " + (x.rtl ? "#000000" : "#FFFFFF") + " 0%, " + e + " 50%, " + (x.rtl ? "#FFFFFF" : "#000000") + " 100%)" : ""
			}

			function o(e) {
				if (Object.keys(ee)
					.length && !isNaN(e)) return e;
				for (var t in y)
					if (e == y[t].color || e == y[t].changedColor) return t
			}

			function i() {
				if (j) {
					var e, t = "";
					if (J.empty(), G._value) {
						if (W) t += s(G._value, z);
						else
							for (e = 0; e < G._value.length; ++e) t += s(G._value[e], Object.keys(ee)
								.length && ee[e].colorIndex ? ee[e].colorIndex : o(G._value[e]));
						J.append(t), G.tap(ke(".mbsc-color-input-item", J), function (e) {
							if (ke(e.target)
								.hasClass("mbsc-color-input-item-close")) {
								var t = ke(this)
									.index();
								e.stopPropagation(), e.preventDefault(), void 0 === z && (z = ke(e.target)
									.parent()
									.attr("data-color")), A && (Z = y[z].previewInd, U.eq(Z)
									.parent()
									.removeClass("mbsc-color-active"), Q[t] = {}, ee[t] = {}), G._value.splice(t, 1), G.setVal(G._value, !0, !0)
							} else F && "inline" !== x.display && (z = ke(e.target)
								.attr("data-color"), isNaN(z) && (z = o(z)), z && (y[z].selected = !0, Z = y[z].previewInd, setTimeout(function () {
									w.scroll(K.eq(z), 400), A && M.scroll(U.eq(Z), 400)
								}, 200)))
						})
					}
				}
			}

			function c(e, t) {
				var a, n = e.match(/\d+/gim);
				switch (!0) {
				case e.indexOf("rgb") > -1:
					a = N({
						r: n[0]
						, g: n[1]
						, b: n[2]
					});
					break;
				case e.indexOf("hsl") > -1:
					a = O({
						h: n[0]
						, s: n[1]
						, l: n[2]
					});
					break;
				case e.indexOf("hsv") > -1:
					a = L({
						h: n[0]
						, s: n[1]
						, v: n[2]
					});
					break;
				case e.indexOf("#") > -1:
					a = e
				}
				return d(a, t || x.format)
			}

			function d(e, t) {
				switch (t) {
				case "rgb":
					return V(e);
				case "hsl":
					return P(e);
				case "hsv":
					return E(e);
				default:
					return e
				}
			}

			function m() {
				var e;
				for (e = 0; e < x.select; ++e)
					if (void 0 === ee[e].colorIndex) return e
			}

			function u(e, t) {
				ke(".mbsc-color-active", t)
					.removeClass("mbsc-color-active"), F && (e.parent()
						.addClass("mbsc-color-active"), A && e && void 0 !== Z && U.eq(Z)
						.parent()
						.addClass("mbsc-color-active"))
			}

			function h(e, t) {
				var a, n, s = []
					, r = 0
					, o = ke.map(y, function (e) {
						return e.changedColor || e.color
					});
				if (W) {
					if (e = ke.isArray(e) ? e[0] : e, n = o.indexOf(e), n > -1 && s.push(n), e && !s.length) {
						var l = +ke(".mbsc-color-input-item", J)
							.attr("data-color");
						isNaN(l) || s.push(l), z = l
					}
				} else if (e)
					if (A && F)
						for (var c in Q) void 0 !== Q[c].colorIndex && s.push(+Q[c].colorIndex);
					else
						for (a = 0; a < e.length; ++a)(n = o.indexOf(e[a])) > -1 && (s.push(n), o[n] = "temp" + a);
				for (a = 0; a < s.length; ++a) f(!0, s[a], r++, y[s[a]].changedColor || y[s[a]].color, !0);
				for (a = 0; a < y.length; ++a) - 1 == s.indexOf(a) && f(!1, a, void 0, y[a].changedColor || y[a].color, !1);
				if (A)
					for (a = r; a < x.select; ++a) ee[a] = {}, U && U.eq(a)
						.addClass("mbsc-color-preview-item-empty")
						.css({
							background: "transparent"
						});
				Q = Ve(!0, {}, ee), !1 !== t && i()
			}

			function f(e, t, a, n, s, r) {
				if (A && s && (ee[a].colorIndex = e ? t : void 0, ee[a].color = e ? n : void 0, U)) {
					var o = U.eq(a);
					o.removeClass("mbsc-color-preview-item-empty")
						.css({
							background: e ? n : "transparent"
						}), e || o.addClass("mbsc-color-preview-item-empty")
						.parent()
						.removeClass("mbsc-color-active")
				}
				r && (e ? G._tempValue.splice(a, 0, n) : G._tempValue.splice(G._tempValue.indexOf(n), 1)), K && (e ? K.eq(t)
					.addClass("mbsc-color-selected") : K.eq(t)
					.removeClass("mbsc-color-selected")
					.parent()
					.removeClass("mbsc-color-active")), y[t].previewInd = e ? a : void 0, y[t].selected = e
			}

			function p(e, t) {
				void 0 !== e && (W || y[e].selected) ? (z = e, C = y[e].changedColor || y[e].color, B = K.eq(e), F && (u(K.eq(e), t || ""), k = c(y[e].color, "hsl"), k.l = c(C, "hsl")
					.l, r(y[e].color), Y.setVal(100 - k.l, !1, !1))) : F && r()
			}

			function b() {
				var e, t = [];
				for (e = 0; e < y.length; ++e) y[e].selected && t.push(y[e]);
				return t
			}

			function v(e, t) {
				var a = ke(e.target)
					.index();
				z = ee[a].colorIndex, B = K.eq(z), Z = a, p(z, t), w.scroll(B, 250), _("onPreviewItemTap", {
					target: e.target
					, value: ee[a].color
					, index: a
				})
			}

			function g(e, t) {
				var a = !1
					, n = ke(".mbsc-color-selected", t);
				if (B = ke(e.target), B.hasClass("mbsc-color-clear-item")) return C = "", void G.clear();
				(W || $ > +n.length || B.hasClass("mbsc-color-selected")) && ie.Wodxy && (z = B.attr("data-index"), A && (Z = void 0 !== y[z].previewInd ? y[z].previewInd : m(), a = F && B.hasClass("mbsc-color-selected") && !B.parent()
					.hasClass("mbsc-color-active"), U.length > 6 && M.scroll(U.eq(Z))), C = y[z].changedColor || y[z].color, W ? (n.removeClass("mbsc-color-selected"), G._tempValue = C, C && B.toggleClass("mbsc-color-selected"), u(B, t)) : (u(B, t), a || f(!y[z].selected, z, Z, C, !0, !0)), p(z, t), G.live && (G._fillValue(), _("onSet", {
					value: G._value
				})), _("onItemTap", {
					target: e.target
					, value: C
					, selected: y[z].selected
					, index: z
				}))
			}
			var x, T, y, _, w, M, S, C, k, D, A, I, F, H, Y, z, j, W, $, R, J, K, U, B, q, G = this
				, X = ke(e)
				, Z = 0
				, Q = {}
				, ee = {};
			Be.call(this, e, t, !0), G.setVal = G._setVal = function (e, t, a, s) {
				G._hasValue = null !== e && void 0 !== e, G._tempValue = W ? ke.isArray(e) ? e[0] : e : ke.isArray(e) ? e : [e], n(t, void 0 === a ? t : a, s)
			}, G.getVal = G._getVal = function (e) {
				return G._hasValue || e ? R ? b() : G[e ? "_tempValue" : "_value"] : null
			}, G._readValue = function () {
				var e = X.val() || "";
				G._hasValue = !1, 0 !== e.length && "" !== e && (G._hasValue = !0), G._hasValue ? (G._tempValue = W ? e : "hex" == x.format ? e.split(",") : e.match(/[a-z]{3}\((\d+\.?\d{0,}?),\s*([\d.]+)%{0,},\s*([\d.]+)%{0,}\)/gim), n(!0)) : G._tempValue = [], h(G._tempValue, G._hasValue)
			}, G._fillValue = function () {
				G._hasValue = !0, n(!0, !0)
			}, G._generateContent = function () {
				var e, t, a, n = S ? 1 : 0;
				for (H = D ? Math.ceil((y.length + n) / x.rows) : x.rows, t = '<div class="mbsc-color-scroll-cont mbsc-w-p ' + (D ? "" : "mbsc-color-vertical") + '"><div class="mbsc-color-cont">' + (D ? '<div class="mbsc-color-row">' : "")
					, e = 0; e < y.length; ++e) a = y[e].changedColor || y[e].color, S && 0 === e && (t += '<div class="mbsc-color-item-c"><div tabindex="0" class="mbsc-color-clear-item mbsc-btn-e mbsc-color-selected"><div class="mbsc-color-clear-cross"></div></div></div>'), 0 !== e && (e + n) % H == 0 && (t += D ? '</div><div class="mbsc-color-row">' : ""), t += '<div class="mbsc-color-item-c"><div tabindex="0" data-index="' + e + '" class="mbsc-color-item mbsc-btn-e mbsc-ic mbsc-ic-material-check mbsc-color-btn-e ' + (y[e].selected ? "mbsc-color-selected" : "") + '"  style="background:' + a + '"></div>' + "</div>";
				if (t += "</div></div>" + (D ? "</div>" : ""), F && (t += '<div class="mbsc-color-slider-cont"><input class="mbsc-color-slider" type="range" data-highlight="false" value="50" min="0" max="100"/></div>'), A) {
					t += '<div class="mbsc-color-preview-cont"><div class="mbsc-color-refine-preview">';
					for (var s in Q) t += '<div class="mbsc-color-preview-item-c mbsc-btn-e mbsc-color-btn-e" tabindex="0"><div class="mbsc-color-preview-item ' + (Q[s].color ? "" : "mbsc-color-preview-item-empty") + '" style="background: ' + (Q[s].color || "initial") + ';"></div></div>';
					t += "</div></div>"
				}
				return t
			}, G._position = function (e) {
				var t, a;
				D || (t = e.find(".mbsc-color-cont"), a = Math.ceil(t.find(".mbsc-color-item-c")[0].offsetWidth), t.width(Math.min(Math.floor(e.find(".mbsc-fr-c")
					.width() / a), Math.round(y.length / x.rows)) * a + 1)), w && w.refresh(), M && M.refresh()
			}, G._markupInserted = function (e) {
				D || e.find(".mbsc-color-scroll-cont")
					.css("max-height", e.find(".mbsc-color-item-c")[0].offsetHeight * x.rows), w = new Ge(e.find(".mbsc-color-scroll-cont")[0], {
						axis: D ? "X" : "Y"
						, rtl: x.rtl
						, elastic: 60
						, stopProp: !1
						, mousewheel: x.mousewheel
						, onBtnTap: function (t) {
							g(t, e)
						}
					})
			}, G._attachEvents = function (e) {
				var t;
				K = ke(".mbsc-color-item", e), e.on("keydown", ".mbsc-color-btn-e", function (t) {
					t.stopPropagation(), 32 == t.keyCode && (t.target.classList.contains("mbsc-color-item") ? g(t, e) : v(t, e))
				}), A && (U = ke(".mbsc-color-preview-item", e)), F && (e.addClass("mbsc-color-refine"), q = ke(".mbsc-color-slider", e), Y = new ut.Slider(q[0], {
					theme: x.theme
					, rtl: x.rtl
				}), I = e.find(".mbsc-progress-track"), z && G._value && p(z, e), q.on("change", function () {
					void 0 !== z && (W || y[z].selected) && (k.l = 100 - this.value, t = c(k.toString())
						.toString(), W ? G._tempValue = t : G._tempValue[void 0 !== Z ? Z : G._tempValue.length] = t, y[z].tempChangedColor = t, K.eq(z)
						.css("background", t), A && (ee[Z].color = t, U.eq(Z)
							.removeClass("mbsc-color-preview-item-empty")
							.css({
								background: t
							})), G.live && l(G._fillValue()))
				})), A && (M = new Ge(e.find(".mbsc-color-preview-cont")[0], {
					axis: "X"
					, rtl: x.rtl
					, mousewheel: x.mousewheel
					, onBtnTap: function (t) {
						v(t, e)
					}
				}))
			}, G._detachEvents = function () {
				w && w.destroy(), Y && Y.destroy(), M && M.destroy()
			}, G.__processSettings = function () {
				var t, a;
				if (x = G.settings, _ = G.trigger, D = "horizontal" == x.navigation, G._value = [], G._tempValue = [], W = "single" == x.select, S = void 0 !== x.clear ? x.clear : W, a = x.data || [], !a.length) switch (x.format) {
				case "rgb":
					a = ["rgb(255,235,60)", "rgb(255,153,0)", "rgb(244,68,55)", "rgb(234,30,99)", "rgb(156,38,176)", "rgb(104,58,183)", "rgb(63,81,181)", "rgb(33,150,243)", "rgb(0,151,136)", "rgb(75,175,79)", "rgb(126,93,78)", "rgb(158,158,158)"], S && a.splice(10, 0, "rgb(83, 71, 65)");
					break;
				case "hsl":
					a = ["hsl(54,100%,62%)", "hsl(36,100%,50%)", "hsl(4,90%,59%)", "hsl(340,83%,52%)", "hsl(291,64%,42%)", "hsl(262,52%,47%)", "hsl(231,48%,48%)", "hsl(207,90%,54%)", "hsl(174,100%,30%)", "hsl(122,40%,49%)", "hsl(19,24%,40%)", "hsl(0,0%,62%)"], S && a.splice(10, 0, "hsl(20, 12%, 29%)");
					break;
				default:
					a = ["#ffeb3c", "#ff9900", "#f44437", "#ea1e63", "#9c26b0", "#683ab7", "#3f51b5", "#2196f3", "#009788", "#4baf4f", "#7e5d4e", "#9e9e9e"], S && a.splice(10, 0, "#534741")
				}
				if (F = "refine" == x.mode, A = !isNaN(x.select), $ = isNaN(x.select) ? W ? 2 : a.length : x.select, R = ke.isPlainObject(a[0]), A && !Object.keys(Q)
					.length)
					for (t = 0; t < x.select; ++t) Q[t] = {}, ee[t] = {};
				if (!y)
					for (y = a.slice(0), t = 0; t < y.length; ++t) ke.isPlainObject(a[t]) ? y[t].color = a[t].color : (a[t] = a[t].toLowerCase(), y[t] = {
						key: t
						, name: a[t]
						, color: a[t]
					});
				T = x.defaultValue || y[0].color, C = T, k = c(C, "hsl"), (j = x.enhance && X.is("input")) && (X.hasClass("mbsc-color-input-hdn") ? J = X.prev() : (J = ke("<div " + (e.placeholder ? 'data-placeholder="' + e.placeholder + '"' : "") + ' class="mbsc-control mbsc-color-input ' + (x.inputClass || "") + '" readonly ></div>'), J.insertBefore(X), X.addClass("mbsc-color-input-hdn")
					.attr("tabindex", -1)), x.anchor = J, G.attachShow(J))
			}, G.__init = function () {
				x.cssClass = (x.cssClass || "") + " mbsc-color"
			}, G.__destroy = function () {
				j && (X.removeClass("mbsc-color-input-hdn"), J.remove())
			}, a || G.init(t)
		};
	ht.prototype = {
		_hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _class: "color"
		, _defaults: Ve({}, ut.Frame.prototype._defaults, {
			headerText: !1
			, validate: a
			, parseValue: a
			, enhance: !0
			, rows: 2
			, select: "single"
			, format: "hex"
			, navigation: "horizontal"
		})
	}, ie.classes.Color = ht, ie.themes.color = ie.themes.frame, ie.presetShort("color", "Color", !1), mt.color = {
		hsv2hex: L
		, hsv2rgb: A
		, rgb2hsv: I
		, rgb2hex: N
		, rgb2hsl: F
		, hex2rgb: V
		, hex2hsv: E
		, hex2hsl: P
	}, ["date", "time", "datetime"].forEach(function (e) {
		ie.presetShort(e)
	});
	var ft = {
		eventBubble: !0
		, labelsShort: ["Yrs", "Mths", "Days", "Hrs", "Mins", "Secs"]
		, eventText: "event"
		, eventsText: "events"
	};
	ie.presetShort("eventcalendar"), ie.presets.scroller.eventcalendar = function (e) {
		function t(e) {
			var t = x.labelsShort
				, a = Math.abs(e) / 1e3
				, n = a / 60
				, s = n / 60
				, r = s / 24
				, o = r / 365;
			return a < 45 && Math.round(a) + " " + t[5].toLowerCase() || n < 45 && Math.round(n) + " " + t[4].toLowerCase() || s < 24 && Math.round(s) + " " + t[3].toLowerCase() || r < 30 && Math.round(r) + " " + t[2].toLowerCase() || r < 365 && Math.round(r / 30) + " " + t[1].toLowerCase() || Math.round(o) + " " + t[0].toLowerCase()
		}

		function a(e) {
			return e.sort(function (e, t) {
				var a = e.d || e.start
					, n = t.d || t.start;
				return (a.getTime ? e.start && e.end && e.start.toDateString() !== e.end.toDateString() ? 1 : a.getTime() : 0) - (n.getTime ? t.start && t.end && t.start.toDateString() !== t.end.toDateString() ? 1 : n.getTime() : 0)
			})
		}

		function n(e) {
			var t, a = ke(".mbsc-cal-c", c)[0].offsetHeight
				, n = ke(e)
				, s = e.offsetHeight
				, r = e.offsetWidth
				, o = n.offset()
				.top - ke(".mbsc-cal-c", c)
				.offset()
				.top
				, i = n.closest(".mbsc-cal-row")
				.index() < 2;
			t = d.addClass("mbsc-cal-events-t")
				.css({
					top: i ? o + s : "0"
					, bottom: i ? "0" : a - o
				})
				.addClass("mbsc-cal-events-v")
				.height(), d.css(i ? "bottom" : "top", "auto")
				.removeClass("mbsc-cal-events-t"), h.css("max-height", t), u.refresh(), u.scroll(0), i ? d.addClass("mbsc-cal-events-b") : d.removeClass("mbsc-cal-events-b"), ke(".mbsc-cal-events-arr", d)
				.css("left", n.offset()
					.left - d.offset()
					.left + r / 2)
		}

		function s(s, r, o) {
			if (s) {
				var i, l, c, h, b, v = '<ul class="mbsc-cal-event-list">';
				m = o, a(s), ke.each(s, function (e, a) {
					h = a.d || a.start, b = a.start && a.end && a.start.toDateString() !== a.end.toDateString(), c = a.color, i = "", l = "", h.getTime && (i = g((b ? "MM d yy " : "") + x.timeFormat, h)), a.end && (l = g((b ? "MM d yy " : "") + x.timeFormat, a.end)), v += '<li role="button" aria-label="' + a.text + (i ? ", " + x.fromText + " " + i : "") + (l ? ", " + x.toText + " " + l : "") + '" class="mbsc-cal-event"><div class="mbsc-cal-event-color" style="' + (c ? "background:" + c + ";" : "") + '"></div><div class="mbsc-cal-event-text">' + (h.getTime && !b ? '<div class="mbsc-cal-event-time">' + g(x.timeFormat, h) + "</div>" : "") + a.text + "</div>" + (a.start && a.end ? '<div class="mbsc-cal-event-dur">' + t(a.end - a.start) + "</div>" : "") + "</li>"
				}), v += "</ul>", f.html(v), e.trigger("onEventBubbleShow", {
					target: m
					, eventList: d[0]
				}), n(m), e.tap(ke(".mbsc-cal-event", f), function (t) {
					u.scrolled || e.trigger("onEventSelect", {
						domEvent: t
						, event: s[ke(this)
							.index()]
						, date: r
					})
				}), p = !0
			}
		}

		function r() {
			d && d.removeClass("mbsc-cal-events-v"), m = null, p = !1
		}

		function o() {
			r(), e.redraw()
		}

		function i(e) {
			return v(e.getFullYear(), e.getMonth(), e.getDate())
		}
		var l, c, d, m, u, h, f, p, b = Ve({}, e.settings)
			, x = Ve(e.settings, ft, b)
			, T = (x.selectedClass, 0)
			, y = Ve(!0, [], x.data);
		return ke.each(y, function (e, t) {
			void 0 === t._id && (t._id = T++)
		}), e._events = y, l = st.call(this, e), e._onSelectShow = function () {
			r()
		}, e.addEvent = function (e) {
			var t = [];
			return e = Ve(!0, [], ke.isArray(e) ? e : [e]), ke.each(e, function (e, a) {
				void 0 === a._id && (a._id = T++), y.push(a), t.push(a._id)
			}), o(), t
		}, e.removeEvent = function (e) {
			e = ke.isArray(e) ? e : [e], ke.each(e, function (e, t) {
				ke.each(y, function (e, a) {
					if (a._id === t) return y.splice(e, 1), !1
				})
			}), o()
		}, e.getEvents = function (t) {
			var n;
			return t ? (t.setHours(0, 0, 0, 0), n = e._prepareObj(y, t.getFullYear(), t.getMonth()), n[t] ? a(n[t]) : []) : Ve(!0, [], y)
		}, e.setEvents = function (t) {
			var a = [];
			return e._events = y = Ve(!0, [], t), ke.each(y, function (e, t) {
				void 0 === t._id && (t._id = T++), a.push(t._id)
			}), o(), a
		}, Ve({}, l, {
			outerMonthChange: !1
			, headerText: !1
			, buttons: "inline" !== x.display ? ["close"] : x.buttons
			, onMarkupReady: function (t) {
				l.onMarkupReady.call(this, t), c = ke(t.target), d = ke('<div class="mbsc-cal-events ' + (x.eventBubbleClass || "") + '"><div class="mbsc-cal-events-arr"></div><div class="mbsc-cal-events-i"><div class="mbsc-cal-events-sc"></div></div></div>')
					.appendTo(ke(".mbsc-cal-c", c)), h = ke(".mbsc-cal-events-i", d), f = ke(".mbsc-cal-events-sc", d), u = new Ge(h[0]), p = !1, e.tap(h, function () {
						u.scrolled || r()
					})
			}
			, onMonthChange: function () {
				r()
			}
			, onDayChange: function (e) {
				var t = i(e.date)
					, a = e.target
					, n = x.eventBubble && m !== a;
				r(), n && s(e.marked, t, a)
			}
			, onPosition: function (e) {
				l.onPosition.call(this, e), p && n(m)
			}
			, onHide: function () {
				l.onHide.call(this), u && u.destroy()
			}
		})
	};
	var pt = ie.classes
		, bt = function (e, t) {
			var a = ""
				, n = ke(e)
				, s = this
				, r = s.settings;
			Ae.call(this, e, t, !0), s._init = function () {
				var e = r.context
					, t = ke(e)
					, s = t.find(".mbsc-ms-top .mbsc-ms")
					, o = t.find(".mbsc-ms-bottom .mbsc-ms")
					, i = {};
				"body" == e ? ke("body,html")
					.addClass("mbsc-page-ctx") : t.addClass("mbsc-page-ctx"), a && n.removeClass(a), s.length && (i.paddingTop = s[0].offsetHeight), o.length && (i.paddingBottom = o[0].offsetHeight), a = "mbsc-page mbsc-" + r.theme + (r.baseTheme ? " mbsc-" + r.baseTheme : "") + (r.rtl ? " mbsc-rtl" : " mbsc-ltr"), n.addClass(a)
					.css(i)
			}, s._destroy = function () {
				n.removeClass(a)
			}, r = s.settings, s.init(t)
		};
	bt.prototype = {
		_hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _class: "page"
		, _defaults: {
			context: "body"
		}
	}, pt.Page = bt, ie.themes.page.mobiscroll = {}, ie.presetShort("page", "Page"), Te && ke(function () {
		ke("[mbsc-page]")
			.each(function () {
				new pt.Page(this)
			}), ke(document)
			.on("mbsc-enhance", function (e, t) {
				ke(e.target)
					.is("[mbsc-page]") ? new pt.Page(e.target, t) : ke("[mbsc-page]", e.target)
					.each(function () {
						new pt.Page(this, t)
					})
			})
	});
	var vt = function (e, t, a) {
		function n(e) {
		!ke(".mbsc-fr-c", e)
				.hasClass("mbsc-wdg-c") && ie.Wodxy && (ke(".mbsc-fr-c", e)
					.addClass("mbsc-wdg-c")
					.append(i.show()), ke(".mbsc-w-p", e)
					.length || ke(".mbsc-fr-c", e)
					.addClass("mbsc-w-p"))
		}
		var s, r, o, i = ke(e)
			, l = this;
		Be.call(this, e, t, !0), l._generateContent = function () {
			return ""
		}, l._markupReady = function (e) {
			"inline" != s.display && n(e)
		}, l._markupInserted = function (e) {
			"inline" == s.display && n(e), e.trigger("mbsc-enhance", [{
				theme: s.theme
				, lang: s.lang
			}])
		}, l._markupRemove = function () {
			i.hide(), r ? r.prepend(i) : o.after(i)
		}, l.__processSettings = function () {
			s = l.settings, l.buttons.ok = {
				text: s.okText
				, icon: s.okIcon
				, handler: "set"
			}, s.buttons = s.buttons || ("inline" == s.display ? [] : ["ok"]), r || o || (o = i.prev(), o.length || (r = i.parent())), i.hide()
		}, l.__init = function () {
			s.cssClass = (s.cssClass || "") + " mbsc-wdg"
		}, a || l.init(t)
	};
	vt.prototype = {
		_hasDef: !0
		, _hasTheme: !0
		, _hasContent: !0
		, _hasLang: !0
		, _class: "widget"
		, _defaults: Ve({}, Be.prototype._defaults, {
			okText: "OK"
			, headerText: !1
		})
	}, ie.classes.Widget = vt, ie.themes.widget = ie.themes.frame, ie.presetShort("widget", "Widget", !1);
	var gt = Te && !!window.Promise
		, xt = []
		, Tt = [];
	ie.alert = function (e) {
		var t = document.createElement("div");
		return t.innerHTML = W(e), B($, t, e)
	}, ie.confirm = function (e) {
		var t = document.createElement("div");
		return t.innerHTML = W(e), B(R, t, e)
	}, ie.prompt = function (e) {
		var t = document.createElement("div");
		return t.innerHTML = W(e) + '<label class="mbsc-input">' + (e.label ? '<span class="mbsc-label">' + e.label + "</span>" : "") + '<input tabindex="0" type="' + (e.inputType || "text") + '" placeholder="' + (e.placeholder || "") + '" value="' + (e.value || "") + '"></label>', B(J, t, e)
	}, ie.snackbar = function (e) {
		var t = document.createElement("div");
		return t.innerHTML = '<div class="mbsc-snackbar-cont"><div class="mbsc-snackbar-msg">' + (e.message || "") + "</div>" + (e.button ? '<button class="mbsc-snackbar-btn mbsc-btn mbsc-btn-flat">' + (e.button.text || "") + "</button>" : "") + "</div>", B(K, t, e)
	}, ie.toast = function (e) {
		var t = document.createElement("div");
		return t.innerHTML = '<div class="mbsc-toast-msg">' + (e.message || "") + "</div>", B(U, t, e)
	};
	var yt = ["touchstart", "touchmove", "touchend", "touchcancel", "mousedown", "mousemove", "mouseup", "mouseleave"]
		, _t = {
			tap: !0
		}
		, wt = void 0
		, Mt = function () {
			function e(t, a) {
				var n = this;
				ce(this, e);
				var s = Ve({}, _t, ie.settings, a)
					, r = ke(t)
					, o = r.parent()
					, i = o.hasClass("mbsc-input-wrap") ? o.parent() : o
					, l = r.next()
					.hasClass("mbsc-fr") ? r.next() : null
					, c = q(r);
				l && l.insertAfter(i), D(i, c), r.addClass("mbsc-control"), yt.forEach(function (e) {
					t.addEventListener(e, n)
				}), this.settings = s, this._type = c, this._elm = t, this._$elm = r, this._$parent = i, this._$frame = l, this._ripple = G(s.theme)
			}
			return de(e, [{
				key: "destroy"
				, value: function () {
					var e = this;
					this._$elm.removeClass("mbsc-control"), yt.forEach(function (t) {
						e._elm.removeEventListener(t, e)
					})
				}
			}, {
				key: "option"
				, value: function (e) {
					Ve(this.settings, e), this._ripple = G(this.settings.theme)
				}
			}, {
				key: "handleEvent"
				, value: function (e) {
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
				key: "_addRipple"
				, value: function (e) {
					this._ripple && this._$rippleElm && this._ripple.addRipple(this._$rippleElm, e)
				}
			}, {
				key: "_removeRipple"
				, value: function () {
					this._ripple && this._$rippleElm && this._ripple.removeRipple()
				}
			}, {
				key: "_onStart"
				, value: function (e) {
					var t = this._elm;
					y(e, t) && (this._startX = u(e, "X"), this._startY = u(e, "Y"), wt && wt.removeClass("mbsc-active"), t.disabled || (this._isActive = !0, wt = this._$elm, wt.addClass("mbsc-active"), this._addRipple(e)))
				}
			}, {
				key: "_onMove"
				, value: function (e) {
					(this._isActive && Math.abs(u(e, "X") - this._startX) > 9 || Math.abs(u(e, "Y") - this._startY) > 9) && (this._$elm.removeClass("mbsc-active"), this._removeRipple(), this._isActive = !1)
				}
			}, {
				key: "_onEnd"
				, value: function (e) {
					var t = this
						, a = this._elm
						, n = this._type;
					this._isActive && this.settings.tap && "touchend" == e.type && !a.readOnly && (a.focus(), /(button|submit|checkbox|switch|radio)/.test(n) && e.preventDefault(), /select/.test(n) || m(e, a)), this._isActive && setTimeout(function () {
						t._$elm.removeClass("mbsc-active"), t._removeRipple()
					}, 100), this._isActive = !1, wt = null
				}
			}]), e
		}()
		, St = function (e) {
			function t(e, a) {
				ce(this, t);
				var n = he(this, (t.__proto__ || Object.getPrototypeOf(t))
					.call(this, e, a));
				return k(n, n._$parent, n._$elm), n._$parent.addClass("mbsc-input"), n
			}
			return ue(t, e), de(t, [{
				key: "destroy"
				, value: function () {
					me(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "destroy", this)
						.call(this), this._$parent.removeClass("mbsc-ic-left mbsc-ic-right")
						.find(".mbsc-input-ic")
						.remove()
				}
			}]), t
		}(Mt)
		, Ct = function (e) {
			function t(e, a) {
				ce(this, t);
				var n = he(this, (t.__proto__ || Object.getPrototypeOf(t))
						.call(this, e, a))
					, s = n._$elm
					, r = s.attr("data-icon");
				return s.addClass("mbsc-btn")
					.find(".mbsc-btn-ic")
					.remove(), r && (s.prepend('<span class="mbsc-btn-ic mbsc-ic mbsc-ic-' + r + '"></span>'), "" === s.text() && s.addClass("mbsc-btn-icon-only")), n._$rippleElm = s, n
			}
			return ue(t, e), t
		}(Mt)
		, kt = function (e) {
			function t(e, a) {
				ce(this, t);
				var n = he(this, (t.__proto__ || Object.getPrototypeOf(t))
					.call(this, e, a));
				return n._$parent.prepend(n._$elm)
					.addClass("mbsc-checkbox mbsc-control-w")
					.find(".mbsc-checkbox-box")
					.remove(), n._$elm.after('<span class="mbsc-checkbox-box"></span>'), n
			}
			return ue(t, e), t
		}(Mt)
		, Dt = function (e) {
			function t(e, a) {
				ce(this, t);
				var n = he(this, (t.__proto__ || Object.getPrototypeOf(t))
					.call(this, e, a));
				return n._$parent.addClass("mbsc-radio mbsc-control-w")
					.find(".mbsc-radio-box")
					.remove(), n._$elm.after('<span class="mbsc-radio-box"><span></span></span>'), n
			}
			return ue(t, e), t
		}(Mt)
		, Nt = function (e) {
			function t(e, a) {
				ce(this, t);
				var n = he(this, (t.__proto__ || Object.getPrototypeOf(t))
						.call(this, e, a))
					, s = n._$elm
					, r = n._$parent
					, o = r.find("input.mbsc-control")
					, i = o.length ? o : ke('<input tabindex="-1" class="mbsc-control" readonly>');
				return n._$input = i, r.addClass("mbsc-select" + (n._$frame ? " mbsc-select-inline" : "")), s.after(i), i.after('<span class="mbsc-select-ic mbsc-ic mbsc-ic-arrow-down5"></span>'), s.hasClass("mbsc-comp") || (e.addEventListener("change", n), n._setText()), n
			}
			return ue(t, e), de(t, [{
				key: "destroy"
				, value: function () {
					me(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "destroy", this)
						.call(this), this._$elm.after(this._$input), this._elm.removeEventListener("change", this)
				}
			}, {
				key: "handleEvent"
				, value: function (e) {
					me(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "handleEvent", this)
						.call(this, e), "change" == e.type && this._setText()
				}
			}, {
				key: "_setText"
				, value: function () {
					var e = this._elm;
					this._$elm.hasClass("mbsc-comp") || this._$input.val(-1 != e.selectedIndex ? e.options[e.selectedIndex].text : "")
				}
			}]), t
		}(St)
		, Vt = ["keydown", "input", "scroll"]
		, At = void 0;
	Te && ke(window)
		.on("resize orientationchange", X);
	var It = function (e) {
			function t(e, a) {
				ce(this, t);
				var n = he(this, (t.__proto__ || Object.getPrototypeOf(t))
					.call(this, e, a));
				return n._$parent.addClass("mbsc-textarea"), Vt.forEach(function (e) {
					n._elm.addEventListener(e, n)
				}), Z(e), n
			}
			return ue(t, e), de(t, [{
				key: "destroy"
				, value: function () {
					var e = this;
					me(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "destroy", this)
						.call(this), Vt.forEach(function (t) {
							e._elm.removeEventListener(t, e)
						})
				}
			}, {
				key: "handleEvent"
				, value: function (e) {
					switch (me(t.prototype.__proto__ || Object.getPrototypeOf(t.prototype), "handleEvent", this)
						.call(this, e), e.type) {
					case "keydown":
					case "input":
						this._onInput(e);
						break;
					case "scroll":
						Q(this._elm)
					}
				}
			}, {
				key: "_onInput"
				, value: function () {
					var e = this;
					clearTimeout(this._debounce), this._debounce = setTimeout(function () {
						Z(e._elm)
					}, 100)
				}
			}]), t
		}(St)
		, Ft = function (e) {
			function t(e, a) {
				ce(this, t);
				var n = he(this, (t.__proto__ || Object.getPrototypeOf(t))
						.call(this, e, a))
					, s = void 0
					, r = void 0
					, o = n._$elm
					, i = n._$parent;
				return i.hasClass("mbsc-segmented-item-ready") || (s = ke('<div class="mbsc-segmented"></div>'), i.after(s), i.parent()
					.find('input[name="' + o.attr("name") + '"]')
					.each(function () {
						var e = ke(this);
						r = e.parent()
							.addClass("mbsc-segmented-item mbsc-segmented-item-ready"), ke('<span class="mbsc-segmented-content">' + (e.attr("data-icon") ? '<span class="mbsc-ic mbsc-ic-' + e.attr("data-icon") + '"></span>' : "") + "</span>")
							.append(r.contents())
							.appendTo(r), r.prepend(e), s.append(r)
					})), n._$rippleElm = o.next(), n
			}
			return ue(t, e), t
		}(Mt)
		, Ht = function (e, t) {
			function a(t) {
				32 == t.keyCode && (t.preventDefault(), v || e.disabled || (h = ke(this)
					.addClass("mbsc-active"), c(t)))
			}

			function n(e) {
				v && (e.preventDefault(), d(!0))
			}

			function s(t) {
				y(t, this) && !e.disabled && (h = ke(this)
					.addClass("mbsc-active")
					.trigger("focus"), D && !h.hasClass("mbsc-step-disabled") && D.addRipple(h.find(".mbsc-segmented-content"), t), c(t), "mousedown" === t.type && ke(document)
					.on("mousemove", o)
					.on("mouseup", r))
			}

			function r(e) {
				v && (e.preventDefault(), d(!0), "mouseup" === e.type && ke(document)
					.off("mousemove", o)
					.off("mouseup", r))
			}

			function o(e) {
				v && (w = u(e, "X"), M = u(e, "Y"), x = w - A, T = M - I, (Math.abs(x) > 7 || Math.abs(T) > 7) && d())
			}

			function i() {
				var t;
				e.disabled || (t = parseFloat(ke(this)
					.val()), l(isNaN(t) ? H : t))
			}

			function l(e, t, a) {
				Y = H, void 0 === t && (t = !0), void 0 === a && (a = t), H = void 0 !== e ? Math.min(C, Math.max(Math.round(e / N) * N, k)) : Math.min(C, Math.max(H + (h.hasClass("mbsc-stepper-minus") ? -N : N), k)), g = !0, b.removeClass("mbsc-step-disabled"), t && E.val(H), H == k ? p.addClass("mbsc-step-disabled") : H == C && f.addClass("mbsc-step-disabled"), H !== Y && a && E.trigger("change")
			}

			function c(e) {
				v || (v = !0, g = !1, A = u(e, "X"), I = u(e, "Y"), clearInterval(S), clearTimeout(S), S = setTimeout(function () {
					l(), S = setInterval(function () {
						l()
					}, 150)
				}, 300))
			}

			function d(e) {
				clearInterval(S), clearTimeout(S), !g && e && l(), v = !1, g = !1, h.removeClass("mbsc-active"), D && setTimeout(function () {
					D.removeRipple()
				}, 100)
			}

			function m(e, t) {
				var a = E.attr(e);
				return void 0 === a || "" === a ? t : +a
			}
			var h, f, p, b, v, g, x, T, _, w, M, S, C, k, D, N, V, A, I, F, H, P, O, L = this
				, E = ke(e)
				, Y = H;
			Ae.call(this, e, t, !0), L.getVal = function () {
				var e = parseFloat(E.val());
				return e = isNaN(e) ? H : e, Math.min(C, Math.max(Math.round(e / N) * N, k))
			}, L.setVal = function (e, t, a) {
				e = parseFloat(e), l(isNaN(e) ? H : e, t, a)
			}, L._init = function (t) {
				P = E.parent()
					.hasClass("mbsc-stepper"), O = P ? E.closest(".mbsc-stepper-cont") : E.parent(), V = L.settings, k = void 0 === t.min ? m("min", V.min) : t.min, C = void 0 === t.max ? m("max", V.max) : t.max, N = void 0 === t.step ? m("step", V.step) : t.step, _ = E.attr("data-val") || V.val, H = Math.min(C, Math.max(Math.round(+e.value / N) * N || 0, k)), F = ie.themes.form[V.theme], D = F && F.addRipple ? F : null, P || O.addClass("mbsc-stepper-cont mbsc-control-w")
					.append('<span class="mbsc-segmented mbsc-stepper"></span>')
					.find(".mbsc-stepper")
					.append('<span class="mbsc-segmented-item mbsc-stepper-control mbsc-stepper-minus ' + (H == k ? "mbsc-step-disabled" : "") + '"  tabindex="0"><span class="mbsc-segmented-content"><span class="mbsc-ic mbsc-ic-minus"></span></span></span>')
					.append('<span class="mbsc-segmented-item mbsc-stepper-control mbsc-stepper-plus ' + (H == C ? "mbsc-step-disabled" : "") + '"  tabindex="0"><span class="mbsc-segmented-content"> <span class="mbsc-ic mbsc-ic-plus"></span> </span></span>')
					.prepend(E), p = ke(".mbsc-stepper-minus", O), f = ke(".mbsc-stepper-plus", O), P || ("left" == _ ? (O.addClass("mbsc-stepper-val-left"), E.after('<span class="mbsc-segmented-item"><span class="mbsc-segmented-content"></span></span>')) : "right" == _ ? (O.addClass("mbsc-stepper-val-right"), f.after('<span class="mbsc-segmented-item"><span class="mbsc-segmented-content"></span></span>')) : p.after('<span class="mbsc-segmented-item"><span class="mbsc-segmented-content mbsc-stepper-val"></span></span>')), E.val(H)
					.attr("data-role", "stepper")
					.attr("min", k)
					.attr("max", C)
					.attr("step", N)
					.on("change", i), b = ke(".mbsc-stepper-control", O)
					.on("keydown", a)
					.on("keyup", n)
					.on("mousedown touchstart", s)
					.on("touchmove", o)
					.on("touchend touchcancel", r), E.addClass("mbsc-stepper-ready mbsc-control")
			}, L._destroy = function () {
				E.removeClass("mbsc-control")
					.off("change", i), b.off("keydown", a)
					.off("keyup", n)
					.off("mousedown touchstart", s)
					.off("touchmove", o)
					.off("touchend touchcancel", r)
			}, L.init(t)
		};
	Ht.prototype = {
		_class: "stepper"
		, _hasDef: !0
		, _defaults: {
			min: 0
			, max: 100
			, step: 1
		}
	}, ie.classes.Stepper = Ht, ie.presetShort("stepper", "Stepper");
	var Pt = function (e, t) {
		var a, n, s, r, o = this;
		t = t || {}, Ve(t, {
			changeEvent: "click"
			, round: !1
		}), ct.call(this, e, t, !0), o._readValue = function () {
			return e.checked ? 1 : 0
		}, o._fillValue = function (e, t, n) {
			a.prop("checked", !!e), n && a.trigger("change")
		}, o._onTap = function (e) {
			o._setVal(e ? 0 : 1)
		}, o.___init = function () {
			s = o.settings, a = ke(e), n = a.parent(), n.find(".mbsc-switch-track")
				.remove(), n.prepend(a), a.attr("data-role", "switch")
				.after('<span class="mbsc-progress-cont mbsc-switch-track"><span class="mbsc-progress-track mbsc-progress-anim"><span class="mbsc-slider-handle-cont"><span class="mbsc-slider-handle mbsc-switch-handle" data-index="0"><span class="mbsc-switch-txt-off">' + s.offText + '</span><span class="mbsc-switch-txt-on">' + s.onText + "</span></span></span></span></span>"), r && r.destroy(), r = new Mt(e, s), o._$track = n.find(".mbsc-progress-track"), o._min = 0, o._max = 1, o._step = 1
		}, o.___destroy = function () {
			r.destroy()
		}, o.getVal = function () {
			return e.checked
		}, o.setVal = function (e, t, a) {
			o._setVal(e ? 1 : 0, t, a)
		}, o.init(t)
	};
	Pt.prototype = {
		_class: "switch"
		, _css: "mbsc-switch"
		, _hasTheme: !0
		, _hasLang: !0
		, _hasDef: !0
		, _defaults: {
			stopProp: !0
			, offText: "Off"
			, onText: "On"
		}
	}, ie.classes.Switch = Pt, ie.presetShort("switch", "Switch");
	var Ot = 0
		, Lt = "ios" == pe && ve > 7
		, Et = ie.instances
		, Yt = function (e, t) {
			function a() {
				r.removeClass("mbsc-no-touch")
			}
			var n, s = ""
				, r = ke(e)
				, o = {}
				, i = this;
			Ae.call(this, e, t, !0), i.refresh = function (e) {
				ke("input,select,textarea,progress,button", r)
					.each(function () {
						var e, t = this
							, a = ke(t)
							, s = q(a);
						if ("false" != a.attr("data-enhance") && ie.Wodxy)
							if (a.hasClass("mbsc-control"))(e = Et[t.id] || o[t.id]) && e.option && e.option({
								theme: n.theme
								, lang: n.lang
								, rtl: n.rtl
								, onText: n.onText
								, offText: n.offText
								, stopProp: n.stopProp
							});
							else switch (t.id || (t.id = "mbsc-form-control-" + ++Ot), s) {
							case "button":
							case "submit":
								o[t.id] = new Ct(t, {
									theme: n.theme
									, tap: n.tap
								});
								break;
							case "switch":
								o[t.id] = new Pt(t, {
									theme: n.theme
									, lang: n.lang
									, rtl: n.rtl
									, tap: n.tap
									, onText: n.onText
									, offText: n.offText
									, stopProp: n.stopProp
								});
								break;
							case "checkbox":
								o[t.id] = new kt(t, {
									tap: n.tap
								});
								break;
							case "range":
								ke(t)
									.parent()
									.hasClass("mbsc-slider") || (o[t.id] = new dt(t, {
										theme: n.theme
										, lang: n.lang
										, rtl: n.rtl
										, stopProp: n.stopProp
									}));
								break;
							case "progress":
								o[t.id] = new lt(t, {
									theme: n.theme
									, lang: n.lang
									, rtl: n.rtl
								});
								break;
							case "radio":
								o[t.id] = new Dt(t, {
									tap: n.tap
								});
								break;
							case "select":
							case "select-one":
							case "select-multiple":
								o[t.id] = new Nt(t, {
									tap: n.tap
								});
								break;
							case "textarea":
								o[t.id] = new It(t, {
									tap: n.tap
								});
								break;
							case "segmented":
								o[t.id] = new Ft(t, {
									theme: n.theme
									, tap: n.tap
								});
								break;
							case "stepper":
								o[t.id] = new Ht(t, {
									theme: n.theme
								});
								break;
							case "hidden":
								return;
							default:
								o[t.id] = new St(t, {
									tap: n.tap
								})
							}
					}), e || X()
			}, i._init = function () {
				ie.themes.form[n.theme] || (n.theme = "mobiscroll"), r.hasClass("mbsc-form") || r.on("touchstart", a)
					.show(), s && r.removeClass(s), s = "mbsc-form mbsc-no-touch mbsc-" + n.theme + (Lt ? " mbsc-form-hb" : "") + (n.baseTheme ? " mbsc-" + n.baseTheme : "") + (n.rtl ? " mbsc-rtl" : " mbsc-ltr"), r.addClass(s), i.refresh()
			}, i._destroy = function () {
				r.removeClass(s)
					.off("touchstart", a);
				for (var e in o) o[e].destroy()
			}, n = i.settings, i.init(t)
		};
	Yt.prototype = {
		_hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _class: "form"
		, _defaults: {
			tap: !0
			, stopProp: !0
			, lang: "en"
		}
	}, ie.themes.form.mobiscroll = {}, ie.classes.Form = Yt, ie.presetShort("form", "Form"), Te && ke(function () {
		var e = "[mbsc-enhance],[mbsc-form]";
		ke(e)
			.each(function () {
				new Yt(this)
			}), ke(document)
			.on("mbsc-enhance", function (t, a) {
				ke(t.target)
					.is(e) ? new Yt(t.target, a) : ke(e, t.target)
					.each(function () {
						new Yt(this, a)
					})
			}), ke(document)
			.on("mbsc-refresh", function (t) {
				var a;
				ke(t.target)
					.is(e) ? (a = Et[t.target.id]) && a.refresh() : ke(e, t.target)
					.each(function () {
						(a = Et[this.id]) && a.refresh()
					})
			})
	});
	var zt = {
		invalid: []
		, showInput: !0
		, inputClass: ""
		, itemSelector: "li"
	};
	ie.presets.scroller.list = function (e) {
		function t(e, t, n) {
			for (var s = 0, r = []; s < e;) r[s] = a(n, s, t), s++;
			return r
		}

		function a(e, t, a) {
			for (var n, s = 0, r = a, o = []; s < t;) {
				var i = e[s];
				for (n in r)
					if (r[n].key == i) {
						r = r[n].children;
						break
					}
				s++
			}
			for (s = 0; s < r.length;) r[s].invalid && o.push(r[s].key), s++;
			return o
		}

		function n(e, t) {
			for (var a = []; e;) a[--e] = !0;
			return a[t] = !1, a
		}

		function s(e, t, a) {
			var n, s, i, l = 0
				, c = [[]]
				, d = M;
			if (t)
				for (n = 0; n < t; n++) v ? c[0][n] = {} : c[n] = [{}];
			for (; l < e.length;) {
				for (v ? c[0][l] = o(d, S[l]) : c[l] = [o(d, S[l])], n = 0, i = void 0; n < d.length && void 0 === i;) d[n].key == e[l] && (void 0 !== a && l <= a || void 0 === a) && (i = n), n++;
				if (void 0 !== i && d[i].children) l++, d = d[i].children;
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
				if (!(a = e[n++])
					.invalid) return t ? n - 1 : a;
			return !1
		}

		function o(e, t) {
			for (var a = {
					data: []
					, label: t
				}, n = 0; n < e.length;) a.data.push({
				value: e[n].key
				, display: e[n].value
			}), n++;
			return a
		}

		function i(t) {
			e._isVisible && ke(".mbsc-sc-whl-w", e._markup)
				.css("display", "")
				.slice(t)
				.hide()
		}

		function l(e, t) {
			var a, n, s, o = []
				, i = M
				, l = 0
				, c = !1;
			if (void 0 !== e[l] && l <= t)
				for (a = 0, n = e[l], s = void 0; a < i.length && void 0 === s;) i[a].key != e[l] || i[a].invalid || (s = a), a++;
			else s = r(i, !0), n = i[s].key;
			for (c = void 0 !== s && i[s].children, o[l] = n; c;) {
				if (i = i[s].children, l++, c = !1, s = void 0, void 0 !== e[l] && l <= t)
					for (a = 0, n = e[l], s = void 0; a < i.length && void 0 === s;) i[a].key != e[l] || i[a].invalid || (s = a), a++;
				else s = r(i, !0), s = !1 === s ? void 0 : s, n = i[s].key;
				c = !(void 0 === s || !r(i[s].children)) && i[s].children, o[l] = n
			}
			return {
				lvl: l + 1
				, nVector: o
			}
		}

		function c(t) {
			var a = [];
			return y = y > _++ ? y : _, (t.length > 1 ? t : t.children(p.itemSelector))
				.each(function (t) {
					var n = ke(this)
						, s = n.clone();
					s.children("ul,ol")
						.remove(), s.children(p.itemSelector)
						.remove();
					var r = e._processMarkup ? e._processMarkup(s) : s.html()
						.replace(/^\s\s*/, "")
						.replace(/\s\s*$/, "")
						, o = !!n.attr("data-invalid")
						, i = {
							key: void 0 === n.attr("data-val") || null === n.attr("data-val") ? t : n.attr("data-val")
							, value: r
							, invalid: o
							, children: null
						}
						, l = "li" === p.itemSelector ? n.children("ul,ol") : n.children(p.itemSelector);
					l.length && (i.children = c(l)), a.push(i)
				}), _--, a
		}

		function d(t, a, n) {
			var r, o = (a || 0) + 1
				, l = []
				, c = {}
				, d = {};
			for (c = s(t, null, a), r = 0; r < t.length; r++) e._tempWheelArray[r] = t[r] = n.nVector[r] || 0;
			for (; o < n.lvl;) d[o] = v ? c[0][o] : c[o][0], l.push(o++);
			i(n.lvl), w = t.slice(0), l.length && (u = !0, e.changeWheel(d))
		}
		var m, u, h, f = Ve({}, e.settings)
			, p = Ve(e.settings, zt, f)
			, b = p.layout || (/top|bottom/.test(p.display) ? "liquid" : "")
			, v = "liquid" == b
			, g = p.readonly
			, x = ke(this)
			, T = this.id + "_dummy"
			, y = 0
			, _ = 0
			, w = []
			, M = p.wheelArray || c(x)
			, S = function (e) {
				var t, a = [];
				for (t = 0; t < e; t++) a[t] = p.labels && p.labels[t] ? p.labels[t] : t;
				return a
			}(y)
			, C = function (e) {
				for (var t, a = [], n = e, s = !0, o = 0; s;) t = r(n), a[o++] = t.key, (s = t.children) && (n = s);
				return a
			}(M)
			, k = s(C, y);
		return ke("#" + T)
			.remove(), p.input ? m = ke(p.input) : p.showInput && (m = ke('<input type="text" id="' + T + '" value="" class="' + p.inputClass + '" placeholder="' + (p.placeholder || "") + '" readonly />')
				.insertBefore(x)), m && e.attachShow(m), p.wheelArray || x.hide(), {
				wheels: k
				, anchor: m
				, layout: b
				, headerText: !1
				, setOnTap: 1 == y
				, formatValue: function (e) {
					return void 0 === h && (h = l(e, e.length)
							.lvl), e.slice(0, h)
						.join(" ")
				}
				, parseValue: function (e) {
					return e ? (e + "")
						.split(" ") : (p.defaultValue || C)
						.slice(0)
				}
				, onBeforeShow: function () {
					var t = e.getArrayVal(!0);
					w = t.slice(0), p.wheels = s(t, y, y), u = !0
				}
				, onWheelGestureStart: function (e) {
					p.readonly = n(y, e.index)
				}
				, onWheelAnimationEnd: function (t) {
					var a = t.index
						, n = e.getArrayVal(!0)
						, s = l(n, a);
					h = s.lvl, p.readonly = g, n[a] != w[a] && d(n, a, s)
				}
				, onFill: function (e) {
					h = void 0, m && m.val(e.valueText)
				}
				, validate: function (e) {
					var a = e.values
						, n = e.index
						, s = l(a, a.length);
					return h = s.lvl, void 0 === n && (i(s.lvl), u || d(a, n, s)), u = !1, {
						disabled: t(h, M, a)
					}
				}
				, onDestroy: function () {
					m && ke("#" + T)
						.remove(), x.show()
				}
			}
	};
	var jt = ie.presets.scroller;
	ie.presetShort("image"), jt.image = function (e) {
		return e.settings.enhance && (e._processMarkup = function (e) {
			var t = e.attr("data-icon");
			return e.children()
				.each(function (e, t) {
					t = ke(t), t.is("img") ? ke('<div class="mbsc-img-c"></div>')
						.insertAfter(t)
						.append(t.addClass("mbsc-img")) : t.is("p") && t.addClass("mbsc-img-txt")
				}), t && e.prepend('<div class="mbsc-ic mbsc-ic-' + t + '"></div'), e.html('<div class="mbsc-img-w">' + e.html() + "</div>"), e.html()
		}), jt.list.call(this, e)
	};
	var Wt, $t = ie.classes
		, Rt = 1
		, Jt = "transparent"
		, Kt = function (e, t) {
			function n() {
				Mt = !1, bt = !1, ee = 0, Ft = 0, Ht = new Date, Qe = oe.width(), me = E(oe), at = me.index(et), tt = et[0].offsetHeight, oa = et[0].offsetTop, Ut = Bt[et.attr("data-type") || "defaults"], It = Ut.stages
			}

			function s(e) {
				var t;
				"touchstart" === e.type && (vt = !0, clearTimeout(gt)), !y(e, this) || X || sa || Wt || da || !ie.Wodxy || (X = !0, te = !0, Pt = u(e, "X"), Ot = u(e, "Y"), ve = 0, ge = 0, et = ke(this), t = et, n(), jt = kt.onItemTap || Ut.tap || et.hasClass("mbsc-lv-parent") || et.hasClass("mbsc-lv-back"), rt = et.offset()
					.top, jt && (Q = setTimeout(function () {
						t.addClass("mbsc-lv-item-active"), Ne("onItemActivate", {
							target: t[0]
							, domEvent: e
						})
					}, 120)), ta.sortable && !et.hasClass("mbsc-lv-back") && (ta.sortable.group || (ft = et.nextUntil(".mbsc-lv-gr-title")
							.filter(".mbsc-lv-item"), xt = et.prevUntil(".mbsc-lv-gr-title")
							.filter(".mbsc-lv-item")), ct = (ta.sortable.group ? oe.children(st)
							.eq(0) : xt.length ? xt.eq(-1) : et)[0].offsetTop - oa, lt = (ta.sortable.group ? oe.children(st)
							.eq(-1) : ft.length ? ft.eq(-1) : et)[0].offsetTop - oa, ta.sortable.handle ? ke(e.target)
						.hasClass("mbsc-lv-handle") && (clearTimeout(Q), "Moz" === Oe ? (e.preventDefault(), p()) : Kt = setTimeout(function () {
							p()
						}, 100)) : Kt = setTimeout(function () {
							Ie.appendTo(et), Ie[0].style[Oe + "Animation"] = "mbsc-lv-fill " + (kt.sortDelay - 100) + "ms linear", clearTimeout(Se), clearTimeout(Q), te = !1, Kt = setTimeout(function () {
								Ie[0].style[Oe + "Animation"] = "", p()
							}, kt.sortDelay - 80)
						}, 80)), "mousedown" == e.type && ke(document)
					.on("mousemove", o)
					.on("mouseup", i))
			}

			function o(e) {
				var t = !1
					, a = !0;
				if (X)
					if (Ce = u(e, "X"), De = u(e, "Y"), ve = Ce - Pt, ge = De - Ot, clearTimeout(Se), ye || Et || Dt || et.hasClass("mbsc-lv-back") || (Math.abs(ge) > 10 ? (Dt = !0, i(Ve({}, e, {
							type: "mousemove" == e.type ? "mouseup" : "touchend"
						})), clearTimeout(Q)) : Math.abs(ve) > 7 && m()), Et) e.preventDefault(), ee = ve / Qe * 100, h();
					else if (ye) {
					e.preventDefault();
					var n, s = Xt.scrollTop()
						, r = Math.max(ct, Math.min(ge + Qt, lt))
						, o = ze ? rt - ea + s - Qt : rt;
					Zt + s < o + r + tt ? (Xt.scrollTop(o + r - Zt + tt), n = !0) : o + r < s && (Xt.scrollTop(o + r), n = !0), n && (Qt += Xt.scrollTop() - s), ut && (ta.sortable.multiLevel && mt.hasClass("mbsc-lv-parent") ? oa + tt / 4 + r > ut ? t = !0 : oa + tt - tt / 4 + r > ut && (xe = mt.addClass("mbsc-lv-item-hl"), a = !1) : oa + tt / 2 + r > ut && (mt.hasClass("mbsc-lv-back") ? ta.sortable.multiLevel && (Te = mt.addClass("mbsc-lv-item-hl"), a = !1) : t = !0), t && (Tt.insertAfter(mt), yt = mt, mt = j(mt, "next"), _t = ut, ut = mt.length && mt[0].offsetTop, re++)), !t && _t && (ta.sortable.multiLevel && yt.hasClass("mbsc-lv-parent") ? oa + tt - tt / 4 + r < _t ? t = !0 : oa + tt / 4 + r < _t && (xe = yt.addClass("mbsc-lv-item-hl"), a = !1) : oa + tt / 2 + r < _t && (yt.hasClass("mbsc-lv-back") ? ta.sortable.multiLevel && (Te = yt.addClass("mbsc-lv-item-hl"), a = !1) : t = !0), t && (Tt.insertBefore(yt)
						, mt = yt, yt = j(yt, "prev"), ut = _t, _t = yt.length && yt[0].offsetTop + yt[0].offsetHeight, re--)), a && (xe && (xe.removeClass("mbsc-lv-item-hl"), xe = !1), Te && (Te.removeClass("mbsc-lv-item-hl"), Te = !1)), t && Ne("onSortChange", [et, re]), N(et, r), Ne("onSort", [et, re])
				} else(Math.abs(ve) > 5 || Math.abs(ge) > 5) && V()
			}

			function i(e) {
				var t, a, n, s = et;
				X && (X = !1, V(), "mouseup" == e.type && ke(document)
					.off("mousemove", o)
					.off("mouseup", i), Dt || (gt = setTimeout(function () {
						vt = !1
					}, 300)), (Et || Dt || ye) && (bt = !0), Et ? f() : ye ? (n = oe, xe ? (H(et.detach()), a = ca[xe.attr("data-ref")], re = E(a.child)
						.length, xe.removeClass("mbsc-lv-item-hl"), kt.navigateOnDrop ? U(xe, function () {
							ta.add(null, et, null, null, xe, !0), J(et), b(et, at, n, !0)
						}) : (ta.add(null, et, null, null, xe, !0), b(et, at, n, !0))) : Te ? (H(et.detach()), a = ca[Te.attr("data-back")], re = E(a.parent)
						.index(a.item) + 1, Te.removeClass("mbsc-lv-item-hl"), kt.navigateOnDrop ? U(Te, function () {
							ta.add(null, et, re, null, oe, !0), J(et), b(et, at, n, !0)
						}) : (ta.add(null, et, re, null, a.parent, !0), b(et, at, n, !0))) : (t = Tt[0].offsetTop - oa, N(et, t, 6 * Math.abs(t - Math.max(ct, Math.min(ge + Qt, lt))), function () {
						H(et), et.insertBefore(Tt), b(et, at, n, re !== at)
					})), ye = !1) : !Dt && Math.abs(ve) < 5 && Math.abs(ge) < 5 && (Ut.tap && Ut.tap.call(aa, {
						target: et
						, index: at
						, domEvent: e
					}, ta), jt && ("touchend" === e.type && d(), et.addClass("mbsc-lv-item-active"), Ne("onItemActivate", {
						target: et[0]
						, domEvent: e
					})), !1 !== Ne("onItemTap", {
						target: et[0]
						, index: at
						, domEvent: e
					}) && U(et)), clearTimeout(Q), setTimeout(function () {
						s.removeClass("mbsc-lv-item-active"), Ne("onItemDeactivate", {
							target: s[0]
						})
					}, 100), Dt = !1, ue = null)
			}

			function m() {
				(Et = P(Ut.swipe, {
					target: et[0]
					, index: at
					, direction: ve > 0 ? "right" : "left"
				})) && (V(), clearTimeout(Q), Ut.actions ? (Z = R(Ut, ve), dt.html(Ut.icons)
						.show()
						.children()
						.css("width", Z + "%"), Xe.hide(), ke(".mbsc-lv-ic-m", Ze)
						.removeClass("mbsc-lv-ic-disabled"), ke(Ut.leftMenu)
						.each(w), ke(Ut.rightMenu)
						.each(w)) : (Xe.show(), dt.hide(), he = Ut.start + (ve > 0 ? 0 : 1), wt = It[he - 1], ht = It[he]), et.addClass("mbsc-lv-item-swiping")
					.removeClass("mbsc-lv-item-active"), $t.css("line-height", tt + "px"), Ze.css({
						top: oa
						, height: tt
						, backgroundColor: W(ve)
					})
					.addClass("mbsc-lv-stage-c-v")
					.appendTo(oe.parent()), kt.iconSlide && et.append(Xe), Ne("onSlideStart", {
						target: et[0]
						, index: at
					}))
			}

			function h() {
				var e = !1;
				Ct || (Ut.actions ? Ze.attr("class", "mbsc-lv-stage-c-v mbsc-lv-stage-c mbsc-lv-" + (ee < 0 ? "right" : "left")) : (wt && ee <= wt.percent ? (he--, ht = wt, wt = It[he], e = !0) : ht && ee >= ht.percent && (he++, wt = ht, ht = It[he], e = !0), e && (ue = ee > 0 ? wt : ht) && (A(ue, kt.iconSlide), Ne("onStageChange", {
					target: et[0]
					, index: at
					, stage: ue
				}))), Nt || (Ct = !0, St = we(C)))
			}

			function f(e) {
				var t, a, n, s = !1;
				Me(St), Ct = !1, Nt || C(), Ut.actions ? Math.abs(ee) > 10 && Z && (D(et, ee < 0 ? -Z : Z, 200), s = !0, Wt = !0, ae = et, ne = at, ke(document)
					.on("touchstart.mbsc-lv-conf mousedown.mbsc-lv-conf", function (t) {
						t.preventDefault(), k(et, !0, e)
					})) : ee && (kt.quickSwipe && !Nt && (n = new Date - Ht, t = n < 300 && ve < -50, a = n < 300 && ve > 50, t ? (Mt = !0, ue = Ut.left, A(ue, kt.iconSlide)) : a && (Mt = !0, ue = Ut.right, A(ue, kt.iconSlide))), ue && ue.action && ((be = P(ue.disabled, {
					target: et[0]
					, index: at
				})) || (s = !0, Wt = Nt || P(ue.confirm, {
					target: et[0]
					, index: at
				}), Wt ? (D(et, (ee < 0 ? -1 : 1) * Xe[0].offsetWidth * 100 / Qe, 200, !0), S(ue, et, at, !1, e)) : M(ue, et, at, e)))), s || k(et, !0, e), Et = !1
			}

			function p() {
				ye = !0, xe = !1, Te = !1, Qt = 0, re = at, kt.vibrate && c(), mt = j(et, "next"), ut = mt.length && mt[0].offsetTop, yt = j(et, "prev"), _t = yt.length && yt[0].offsetTop + yt[0].offsetHeight, Tt.height(tt)
					.insertAfter(et), et.css({
						top: oa
					})
					.addClass("mbsc-lv-item-dragging")
					.removeClass("mbsc-lv-item-active")
					.appendTo(_e), Ne("onSortStart", {
						target: et[0]
						, index: re
					})
			}

			function b(e, t, a, n) {
				e.removeClass("mbsc-lv-item-dragging"), Tt.remove(), Ne("onSortEnd", {
					target: e[0]
					, index: re
				}), kt.vibrate && c(), n && (ta.addUndoAction(function (n) {
					ta.move(e, t, null, n, a, !0)
				}, !0), Ne("onSortUpdate", {
					target: e[0]
					, index: re
				}))
			}

			function v() {
				vt || (clearTimeout(Ue), Wt && ke(document)
					.trigger("touchstart"), Re && (ta.close($e, Je), Re = !1, $e = null))
			}

			function g() {
				clearTimeout(fe), fe = setTimeout(function () {
					Zt = Xt[0].innerHeight || Xt.innerHeight(), ea = ze ? Xt.offset()
						.top : 0, X && (oa = et[0].offsetTop, tt = et[0].offsetHeight, Ze.css({
							top: oa
							, height: tt
						}))
				}, 200)
			}

			function x(e) {
				bt && (e.stopPropagation(), e.preventDefault(), bt = !1)
			}

			function T() {
				if (ye || !X) {
					var e, t = Xt.scrollTop()
						, a = na.offset()
						.top
						, n = na[0].offsetHeight
						, s = ze ? Xt.offset()
						.top : t;
					ke(".mbsc-lv-gr-title", na)
						.each(function (t, a) {
							ke(a)
								.offset()
								.top < s && (e = a)
						}), a < s && a + n > s ? Le.show()
						.empty()
						.append(ke(e)
							.clone()) : Le.hide()
				}
			}

			function w(e, t) {
				P(t.disabled, {
						target: et[0]
						, index: at
					}) && ke(".mbsc-ic-" + t.icon, Ze)
					.addClass("mbsc-lv-ic-disabled")
			}

			function M(e, t, a, n) {
				var s, r = {
					icon: "undo2"
					, text: kt.undoText
					, color: "#b1b1b1"
					, action: function () {
						ta.undo()
					}
				};
				e.undo && (ta.startActionTrack(), ke.isFunction(e.undo) && ta.addUndoAction(function () {
					e.undo.call(aa, {
						target: t[0]
						, index: a
					}, ta)
				}), qt = t.attr("data-ref")), s = e.action.call(aa, {
					target: t[0]
					, index: a
				}, ta), e.undo ? (ta.endActionTrack(), !1 !== s && D(t, +t.attr("data-pos") < 0 ? -100 : 100, 200), Tt.height(tt)
					.insertAfter(t), t.css("top", oa)
					.addClass("mbsc-lv-item-undo"), dt.hide(), Xe.show(), Ze.append(Xe), A(r), S(r, t, a, !0, n)) : k(t, s, n)
			}

			function S(e, t, a, n, s) {
				var r, o;
				Wt = !0, ke(document)
					.off(".mbsc-lv-conf")
					.on("touchstart.mbsc-lv-conf mousedown.mbsc-lv-conf", function (e) {
						e.preventDefault(), n && F(t), k(t, !0, s)
					}), pe || Xe.off(".mbsc-lv-conf")
					.on("touchstart.mbsc-lv-conf mousedown.mbsc-lv-conf", function (e) {
						e.stopPropagation(), r = u(e, "X"), o = u(e, "Y")
					})
					.on("touchend.mbsc-lv-conf mouseup.mbsc-lv-conf", function (i) {
						i.preventDefault(), "touchend" === i.type && d(), Math.abs(u(i, "X") - r) < 10 && Math.abs(u(i, "Y") - o) < 10 && (M(e, t, a, s), n && (Gt = null, F(t)))
					})
			}

			function C() {
				D(et, Ft + 100 * ve / Qe), Ct = !1
			}

			function k(e, t, a) {
				ke(document)
					.off(".mbsc-lv-conf"), Xe.off(".mbsc-lv-conf"), !1 !== t ? D(e, 0, "0" !== e.attr("data-pos") ? 200 : 0, !1, function () {
						I(e, a), H(e)
					}) : I(e, a), Wt = !1
			}

			function D(e, t, a, n, s) {
				t = Math.max("right" == Et ? 0 : -100, Math.min(t, "left" == Et ? 0 : 100)), Lt = e[0].style, e.attr("data-pos", t), Lt[Oe + "Transform"] = "translate3d(" + (n ? Qe * t / 100 + "px" : t + "%") + ",0,0)", Lt[Oe + "Transition"] = Pe + "transform " + (a || 0) + "ms", s && (sa++, setTimeout(function () {
					s(), sa--
				}, a)), ee = t
			}

			function N(e, t, a, n) {
				t = Math.max(ct, Math.min(t, lt)), Lt = e[0].style, Lt[Oe + "Transform"] = "translate3d(0," + t + "px,0)", Lt[Oe + "Transition"] = Pe + "transform " + (a || 0) + "ms ease-out", n && (sa++, setTimeout(function () {
					n(), sa--
				}, a))
			}

			function V() {
				clearTimeout(Kt), !te && ta.sortable && (te = !0, Ie.remove())
			}

			function A(e, t) {
				var a = P(e.text, {
					target: et[0]
					, index: at
				}) || "";
				P(e.disabled, {
						target: et[0]
						, index: at
					}) ? Ze.addClass("mbsc-lv-ic-disabled") : Ze.removeClass("mbsc-lv-ic-disabled"), Ze.css("background-color", e.color || (0 === e.percent ? W(ee) : Jt)), Xe.attr("class", "mbsc-lv-ic-c mbsc-lv-ic-" + (t ? "move-" : "") + (ee < 0 ? "right" : "left")), Ge.attr("class", " mbsc-lv-ic-s mbsc-lv-ic mbsc-ic mbsc-ic-" + (e.icon || "none")), $t.attr("class", "mbsc-lv-ic-text" + (e.icon ? "" : " mbsc-lv-ic-text-only") + (a ? "" : " mbsc-lv-ic-only"))
					.html(a || "&nbsp;"), kt.animateIcons && (Mt ? Ge.addClass("mbsc-lv-ic-v") : setTimeout(function () {
						Ge.addClass("mbsc-lv-ic-a")
					}, 10))
			}

			function I(e, t) {
				X || (Ge.attr("class", "mbsc-lv-ic-s mbsc-lv-ic mbsc-ic mbsc-ic-none"), Ze.attr("style", "")
					.removeClass("mbsc-lv-stage-c-v"), $t.html("")), Ze.removeClass("mbsc-lv-left mbsc-lv-right"), e && (Ne("onSlideEnd", {
					target: e[0]
					, index: at
				}), t && t())
			}

			function F(e) {
				e.css("top", "")
					.removeClass("mbsc-lv-item-undo"), Gt ? ta.animate(Tt, "collapse", function () {
						Tt.remove()
					}) : Tt.remove(), I(), qt = null, Gt = null
			}

			function H(e) {
				Lt = e[0].style, Lt[Oe + "Transform"] = "", Lt[Oe + "Transition"] = "", Lt.top = "", e.removeClass("mbsc-lv-item-swiping")
			}

			function P(e, t) {
				return ke.isFunction(e) ? e.call(this, t, ta) : e
			}

			function O(e) {
				var t, a = e.attr("data-role");
				if (e.attr("data-ref") || (t = Rt++, e.attr("data-ref", t), ca[t] = {
						item: e
						, child: e.children(it)
						, parent: e.parent()
						, ref: e.parent()[0] === aa ? null : e.parent()
							.parent()
							.attr("data-ref")
					}), e.addClass("list-divider" == a ? "mbsc-lv-gr-title" : "mbsc-lv-item"), ta.sortable.handle && "list-divider" != a && !e.children(".mbsc-lv-handle-c")
					.length && e.append(je), kt.enhance && !e.hasClass("mbsc-lv-item-enhanced")) {
					var n = e.attr("data-icon")
						, s = e.find("img")
						.eq(0)
						.addClass("mbsc-lv-img");
					s.is(":first-child") ? e.addClass("mbsc-lv-img-" + (kt.rtl ? "right" : "left")) : s.length && e.addClass("mbsc-lv-img-" + (kt.rtl ? "left" : "right")), e.addClass("mbsc-lv-item-enhanced")
						.children()
						.each(function (e, t) {
							t = ke(t), t.is("p, h1, h2, h3, h4, h5, h6") && t.addClass("mbsc-lv-txt")
						}), n && e.addClass("mbsc-lv-item-ic-" + (e.attr("data-icon-align") || (kt.rtl ? "right" : "left")))
						.append('<div class="mbsc-lv-item-ic mbsc-ic mbsc-ic-' + n + '"></div>')
				}
			}

			function L(e) {
				ke(st, e)
					.not(".mbsc-lv-item")
					.each(function () {
						O(ke(this))
					}), ke(it, e)
					.not(".mbsc-lv")
					.addClass("mbsc-lv")
					.prepend(Be)
					.parent()
					.addClass("mbsc-lv-parent")
					.prepend(qe), ke(".mbsc-lv-back", e)
					.each(function () {
						ke(this)
							.attr("data-back", ke(this)
								.parent()
								.parent()
								.attr("data-ref"))
					})
			}

			function E(e) {
				return e.children(st)
					.not(".mbsc-lv-back")
					.not(".mbsc-lv-removed")
					.not(".mbsc-lv-ph")
			}

			function Y(e) {
				return "object" !== (void 0 === e ? "undefined" : le(e)) && (e = ke(st, se)
					.filter('[data-id="' + e + '"]')), ke(e)
			}

			function z(e) {
				for (var t = 0, a = ca[e.attr("data-ref")]; a && a.ref;) t++, a = ca[a.ref];
				return t
			}

			function j(e, t) {
				for (e = e[t](); e.length && (!e.hasClass("mbsc-lv-item") || e.hasClass("mbsc-lv-ph") || e.hasClass("mbsc-lv-item-dragging"));) {
					if (!ta.sortable.group && e.hasClass("mbsc-lv-gr-title")) return !1;
					e = e[t]()
				}
				return e
			}

			function W(e) {
				return (e > 0 ? Ut.right : Ut.left)
					.color || Jt
			}

			function $(e) {
				return r(e) ? e + "" : 0
			}

			function R(e, t) {
				return +(t < 0 ? $((e.actionsWidth || 0)
					.right) || $(e.actionsWidth) || $(kt.actionsWidth.right) || $(kt.actionsWidth) : $((e.actionsWidth || 0)
					.left) || $(e.actionsWidth) || $(kt.actionsWidth.left) || $(kt.actionsWidth))
			}

			function J(e, t) {
				if (e) {
					var a = Xt.scrollTop()
						, n = e.is(".mbsc-lv-item") ? e[0].offsetHeight : 0
						, s = e.offset()
						.top + (ze ? a - ea : 0);
					t ? (s < a || s + n > a + Zt) && Xt.scrollTop(s) : s < a ? Xt.scrollTop(s) : s + n > a + Zt && Xt.scrollTop(Math.min(s, s + n - Zt / 2))
				}
			}

			function K(e, t, n, s, r) {
				var o = t.parent()
					, i = t.prev();
				s = s || a, i[0] === Xe[0] && (i = Xe.prev()), oe[0] !== t[0] ? (Ne("onNavStart", {
					level: ra
					, direction: e
					, list: t[0]
				}), Vt.prepend(t.addClass("mbsc-lv-v mbsc-lv-sl-new")), J(se), B(Vt, "mbsc-lv-sl-" + e, function () {
					oe.removeClass("mbsc-lv-sl-curr"), t.removeClass("mbsc-lv-sl-new")
						.addClass("mbsc-lv-sl-curr"), ce && ce.length ? oe.removeClass("mbsc-lv-v")
						.insertAfter(ce) : de.append(oe.removeClass("mbsc-lv-v")), ce = i, de = o, oe = t, J(n, r), s.call(aa, n), Ne("onNavEnd", {
							level: ra
							, direction: e
							, list: t[0]
						})
				})) : (J(n, r), s.call(aa, n))
			}

			function U(e, t) {
				sa || (e.hasClass("mbsc-lv-parent") ? (ra++, K("r", ca[e.attr("data-ref")].child, null, t)) : e.hasClass("mbsc-lv-back") && (ra--, K("l", ca[e.attr("data-back")].parent, ca[e.attr("data-back")].item, t)))
			}

			function B(e, t, n) {
				function s() {
					clearTimeout(r), sa--, e.off(Fe, s)
						.removeClass(t), n.call(aa, e)
				}
				var r;
				n = n || a, kt.animation && "mbsc-lv-item-none" !== t ? (sa++, e.on(Fe, s)
					.addClass(t), r = setTimeout(s, 500)) : n.call(aa, e)
			}

			function q(e, t) {
				var a, n = e.attr("data-ref");
				a = la[n] = la[n] || [], t && a.push(t), e.attr("data-action") || (t = a.shift(), e.attr("data-action", 1), t(function () {
					e.removeAttr("data-action"), a.length ? q(e) : delete la[n]
				}))
			}

			function G(e, t, a) {
				var n, s;
				e && e.length && (n = 100 / (e.length + 2), ke.each(e, function (r, o) {
					void 0 === o.key && (o.key = At++), void 0 === o.percent && (o.percent = t * n * (r + 1), a && (s = Ve({}, o), s.key = At++, s.percent = -n * (r + 1), e.push(s), ia[s.key] = s)), ia[o.key] = o
				}))
			}
			var X, Z, Q, ee, te, ae, ne, se, re, oe, ce, de, me, ue, he, fe, pe, be, ve, ge, xe, Te, ye, _e, Se, Ce, De, Ne, Ie, He, Le, Ee, Ye, ze, je, We, $e, Re, Je, Ke, Ue, Be, qe, Ge, Xe, Ze, Qe, et, tt, at, nt, st, rt, ot, it, lt, ct, dt, mt, ut, ht, ft, pt, bt, vt, gt, xt, Tt, yt, _t, wt, Mt, St, Ct, kt, Dt, Nt, Vt, At, It, Ft, Ht, Pt, Ot, Lt, Et, Yt, zt, jt, $t, Kt, Ut, Bt, qt, Gt, Xt, Zt, Qt, ea, ta = this
				, aa = e
				, na = ke(aa)
				, sa = 0
				, ra = 0
				, oa = 0
				, ia = {}
				, la = {}
				, ca = {};
			Ae.call(this, e, t, !0), ta.animate = function (e, t, a) {
				B(e, "mbsc-lv-item-" + t, a)
			}, ta.add = function (e, t, n, s, r, o) {
				var i, l, c, d, m, u, h = ""
					, f = void 0 === r ? na : Y(r)
					, p = f
					, b = ke("object" !== (void 0 === t ? "undefined" : le(t)) ? "<" + nt + ' data-ref="' + Rt++ + '" data-id="' + e + '">' + t + "</" + nt + ">" : t)
					, v = b.attr("data-pos") < 0 ? "left" : "right"
					, g = b.attr("data-ref");
				s = s || a, g || (g = Rt++, b.attr("data-ref", g)), O(b), o || ta.addUndoAction(function (e) {
					d ? ta.navigate(f, function () {
						p.remove(), f.removeClass("mbsc-lv-parent")
							.children(".mbsc-lv-arr")
							.remove(), m.child = f.children(it), ta.remove(b, null, e, !0)
					}) : ta.remove(b, null, e, !0)
				}, !0), q(b, function (e) {
					H(b.css("top", "")
							.removeClass("mbsc-lv-item-undo")), f.is(st) ? (u = f.attr("data-ref"), f.children(it)
							.length || (d = !0, f.append("<" + ot + "></" + ot + ">"))) : u = f.children(".mbsc-lv-back")
						.attr("data-back"), m = ca[u], m && (m.child.length ? p = m.child : (f.addClass("mbsc-lv-parent")
							.prepend(qe), p = f.children(it)
							.prepend(Be)
							.addClass("mbsc-lv"), m.child = p, ke(".mbsc-lv-back", f)
							.attr("data-back", u))), ca[g] = {
							item: b
							, child: b.children(it)
							, parent: p
							, ref: u
						}, c = E(p), l = c.length, void 0 !== n && null !== n || (n = l), o && (h = "mbsc-lv-item-new-" + (o ? v : "")), L(b.addClass(h)), !1 !== n && (l ? n < l ? b.insertBefore(c.eq(n)) : b.insertAfter(c.eq(l - 1)) : (i = ke(".mbsc-lv-back", p), i.length ? b.insertAfter(i) : p.append(b))), p.hasClass("mbsc-lv-v") ? ta.animate(b.height(b[0].offsetHeight), o && qt === g ? "none" : "expand", function (t) {
							ta.animate(t.height(""), o ? "add-" + v : "pop-in", function (t) {
								s.call(aa, t.removeClass(h)), e()
							})
						}) : (s.call(aa, b.removeClass(h)), e()), se.trigger("mbsc-refresh"), Ne("onItemAdd", {
							target: b[0]
						})
				})
			}, ta.swipe = function (e, t, a, s, r) {
				e = Y(e), et = e, pe = s, Nt = !0, X = !0, a = void 0 === a ? 300 : a, ve = t > 0 ? 1 : -1, n(), m(), D(e, t, a), clearTimeout(zt), clearInterval(Yt), Yt = setInterval(function () {
					ee = _(e) / Qe * 100, h()
				}, 10), zt = setTimeout(function () {
					clearInterval(Yt), ee = t, h(), f(r), pe = !1, Nt = !1, X = !1
				}, a)
			}, ta.openStage = function (e, t, a, n) {
				ia[t] && ta.swipe(e, ia[t].percent, a, n)
			}, ta.openActions = function (e, t, a, n) {
				e = Y(e);
				var s = R(Bt[e.attr("data-type") || "defaults"], "left" == t ? -1 : 1);
				ta.swipe(e, "left" == t ? -s : s, a, n)
			}, ta.close = function (e, t) {
				ta.swipe(e, 0, t)
			}, ta.remove = function (e, t, n, s) {
				var r, o, i;
				n = n || a, e = Y(e), e.length && (o = e.parent(), r = E(o)
					.index(e), i = e[0].style, s || (e.attr("data-ref") === qt && (Gt = !0), ta.addUndoAction(function (t) {
						ta.add(null, e, r, t, o, !0)
					}, !0)), q(e, function (a) {
						t = t || (e.attr("data-pos") < 0 ? "left" : "right"), o.hasClass("mbsc-lv-v") ? ta.animate(e.addClass("mbsc-lv-removed"), s ? "pop-out" : "remove-" + t, function (e) {
							i.height = e[0].offsetHeight + "px", ta.animate(e, "collapse", function (e) {
								i.height = "", H(e.removeClass("mbsc-lv-removed")), !1 !== n.call(aa, e) && e.remove(), a()
							})
						}) : (!1 !== n.call(aa, e) && e.remove(), a()), Ne("onItemRemove", {
							target: e[0]
						})
					}))
			}, ta.move = function (e, t, a, n, s, r) {
				e = Y(e), r || ta.startActionTrack(), Ze.append(Xe), ta.remove(e, a, null, r), ta.add(null, e, t, n, s, r), r || ta.endActionTrack()
			}, ta.navigate = function (e, t) {
				var a, n;
				e = Y(e), a = ca[e.attr("data-ref")], n = z(e), a && (K(n >= ra ? "r" : "l", a.parent, e, t, !0), ra = n)
			}, ta._processSettings = function () {
				na.is("[mbsc-enhance]") && (Ee = !0, na.removeAttr("mbsc-enhance"))
			}, ta._init = function () {
				var e, t, a, n = 0 , p = na.find('ul,ol').length ? 'left' : 'right'
					, r = ""
					, c = ""
					, m = "";
					
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
                    a && a.handle === undefined  && (a.handle = kt.sortHandle);
                    ta.sortable = a || !1;
	            
	            var Za = !0 === ta.sortable.handle ? p : ta.sortable.handle;
				
				ot = kt.listNode, 
				it = kt.listSelector, 
				nt = kt.itemNode, st = kt.itemSelector, 
				Ye = Za || '', 
				Be = '<li class="mbsc-lv-item mbsc-lv-back">' + kt.backText + '<div class="mbsc-lv-arr mbsc-lv-ic mbsc-ic ' + kt.leftArrowClass + '"></div></li>';
				qe = '<div class="mbsc-lv-arr mbsc-lv-ic mbsc-ic ' + kt.rightArrowClass + '"></div>',
				e = 'mbsc-lv-cont '+( Za && 'mbsc-lv-handle-'+Za )+' mbsc-lv-' + kt.theme + (kt.rtl ? ' mbsc-lv-rtl' : '') + (kt.baseTheme ? ' mbsc-lv-' + kt.baseTheme : '') + (kt.animateIcons ? ' mbsc-lv-ic-anim' : '') + (kt.striped ? ' mbsc-lv-alt-row ' : '') + (kt.fixedHeader ? ' mbsc-lv-has-fixed-header ' : '');
                if (ta.sortable.handle) {
	                je = '<div class="mbsc-lv-handle-c mbsc-lv-item-h-' + Za + ' mbsc-lv-handle"><div class="' + kt.handleClass + ' mbsc-lv-handle-bar-c mbsc-lv-handle">' + kt.handleMarkup + '</div></div>';
	            }

				se ? (se.attr("class", e), a.handle && ke(".mbsc-lv-handle-c", se)
					.remove(), ke(st, se)
					.not(".mbsc-lv-back")
					.removeClass("mbsc-lv-item")) : (r += '<div class="mbsc-lv-multi-c"></div>', r += '<div class="mbsc-lv-ic-c"><div class="mbsc-lv-ic-s mbsc-lv-ic mbsc-ic mbsc-ic-none"></div><div class="mbsc-lv-ic-text"></div></div>', na.addClass("mbsc-lv mbsc-lv-v mbsc-lv-root")
					.show(), Ze = ke('<div class="mbsc-lv-stage-c">' + r + "</div>"), Xe = ke(".mbsc-lv-ic-c", Ze), dt = ke(".mbsc-lv-multi-c", Ze), Ge = ke(".mbsc-lv-ic-s", Ze), $t = ke(".mbsc-lv-ic-text", Ze), Tt = ke("<" + nt + ' class="mbsc-lv-item mbsc-lv-ph"></' + nt + ">"), Ie = ke('<div class="mbsc-lv-fill-item"></div>'), se = ke('<div class="' + e + '"><' + ot + ' class="mbsc-lv mbsc-lv-dummy"></' + ot + '><div class="mbsc-lv-sl-c"></div></div>'), ze = "body" !== kt.context, Xt = ke(ze ? kt.context : window), _e = ke(".mbsc-lv-dummy", se), se.insertAfter(na), Xt.on("orientationchange resize", g), g(), se.on("touchstart mousedown", ".mbsc-lv-item", s)
					.on("touchmove", ".mbsc-lv-item", o)
					.on("touchend touchcancel", ".mbsc-lv-item", i), aa.addEventListener("click", x, !0), se.on("touchstart mousedown", ".mbsc-lv-ic-m", function (e) {
						pe || (e.stopPropagation(), e.preventDefault()), Pt = u(e, "X"), Ot = u(e, "Y")
					})
					.on("touchend mouseup", ".mbsc-lv-ic-m", function (e) {
						pe || ("touchend" === e.type && d(), Wt && !ke(this)
							.hasClass("mbsc-lv-ic-disabled") && Math.abs(u(e, "X") - Pt) < 10 && Math.abs(u(e, "Y") - Ot) < 10 && M((ee < 0 ? Ut.rightMenu : Ut.leftMenu)[ke(this)
								.index()], ae, ne))
					}), Vt = ke(".mbsc-lv-sl-c", se)
					.append(na.addClass("mbsc-lv-sl-curr"))
					.attr("data-ref", Rt++), oe = na, de = se), L(na), At = 0, Bt = kt.itemGroups || {}, Bt.defaults = {
					swipeleft: kt.swipeleft
					, swiperight: kt.swiperight
					, stages: kt.stages
					, actions: kt.actions
					, actionsWidth: kt.actionsWidth
				}, ke.each(Bt, function (e, t) {
					if (t.swipe = void 0 !== t.swipe ? t.swipe : kt.swipe, t.stages = t.stages || [], G(t.stages, 1, !0), G(t.stages.left, 1), G(t.stages.right, -1), (t.stages.left || t.stages.right) && (t.stages = [].concat(t.stages.left || [], t.stages.right || [])), He = !1, t.stages.length || (t.swipeleft && t.stages.push({
							percent: -30
							, action: t.swipeleft
						}), t.swiperight && t.stages.push({
							percent: 30
							, action: t.swiperight
						})), ke.each(t.stages, function (e, t) {
							if (0 === t.percent) return He = !0, !1
						}), He || t.stages.push({
							percent: 0
						}), t.stages.sort(function (e, t) {
							return e.percent - t.percent
						}), ke.each(t.stages, function (e, a) {
							if (0 === a.percent) return t.start = e, !1
						}), He ? t.left = t.right = t.stages[t.start] : (t.left = t.stages[t.start - 1] || {}, t.right = t.stages[t.start + 1] || {}), t.actions) {
						for (t.leftMenu = t.actions.left || t.actions, t.rightMenu = t.actions.right || t.leftMenu, c = "", m = "", n = 0; n < t.leftMenu.length; n++) c += "<div " + (t.leftMenu[n].color ? 'style="background-color: ' + t.leftMenu[n].color + '"' : "") + ' class="mbsc-lv-ic-m mbsc-lv-ic mbsc-ic mbsc-ic-' + t.leftMenu[n].icon + '">' + (t.leftMenu[n].text || "") + "</div>";
						for (n = 0; n < t.rightMenu.length; ++n) m += "<div " + (t.rightMenu[n].color ? 'style="background-color: ' + t.rightMenu[n].color + '"' : "") + ' class="mbsc-lv-ic-m mbsc-lv-ic mbsc-ic mbsc-ic-' + t.rightMenu[n].icon + '">' + (t.rightMenu[n].text || "") + "</div>";
						t.actions.left && (t.swipe = t.actions.right ? t.swipe : "right"), t.actions.right && (t.swipe = t.actions.left ? t.swipe : "left"), t.icons = '<div class="mbsc-lv-multi mbsc-lv-multi-ic-left">' + c + '</div><div class="mbsc-lv-multi mbsc-lv-multi-ic-right">' + m + "</div>"
					}
				}), kt.fixedHeader && (t = "mbsc-lv-fixed-header" + (ze ? " mbsc-lv-fixed-header-ctx mbsc-lv-" + kt.theme + (kt.baseTheme ? " mbsc-lv-" + kt.baseTheme : "") : ""), Le ? Le.attr("class", t) : (Le = ke('<div class="' + t + '"></div>'), ze ? Xt.before(Le) : se.prepend(Le), pt = l(T, 200), Xt.on("scroll touchmove", pt))), kt.hover && (Je || se.on("mouseover.mbsc-lv", ".mbsc-lv-item", function () {
						$e && $e[0] == this || (v(), $e = ke(this), Bt[$e.attr("data-type") || "defaults"].actions && (Ue = setTimeout(function () {
							vt ? $e = null : (Re = !0, ta.openActions($e, We, Je, !1))
						}, Ke)))
					})
					.on("mouseleave.mbsc-lv", v), Je = kt.hover.time || 200, Ke = kt.hover.timeout || 200, We = kt.hover.direction || kt.hover || "right"), Ee && se.attr("mbsc-enhance", ""), se.trigger("mbsc-enhance", [{
					theme: kt.theme
					, lang: kt.lang
				}])
			}, ta._destroy = function () {
				var e;
				de.append(oe), ze && Le && Le.remove(), Ee && (na.attr("mbsc-enhance", ""), (e = ie.instances[se[0].id]) && e.destroy()), aa.removeEventListener("click", x, !0), se.find(".mbsc-lv-txt,.mbsc-lv-img")
					.removeClass("mbsc-lv-txt mbsc-lv-img"), se.find(it)
					.removeClass("mbsc-lv mbsc-lv-v mbsc-lv-root mbsc-lv-sl-curr")
					.find(st)
					.removeClass("mbsc-lv-gr-title mbsc-lv-item mbsc-lv-item-enhanced mbsc-lv-parent mbsc-lv-img-left mbsc-lv-img-right mbsc-lv-item-ic-left mbsc-lv-item-ic-right")
					.removeAttr("data-ref"), ke(".mbsc-lv-back,.mbsc-lv-handle-c,.mbsc-lv-arr,.mbsc-lv-item-ic", se)
					.remove(), na.insertAfter(se), se.remove(), Ze.remove(), Xt.off("orientationchange resize", g), pt && Xt.off("scroll touchmove", pt)
			};
			var da, ma = []
				, ua = []
				, ha = []
				, fa = 0;
			ta.startActionTrack = function () {
				fa || (ha = []), fa++
			}, ta.endActionTrack = function () {
				--fa || ua.push(ha)
			}, ta.addUndoAction = function (e, t) {
				var a = {
					action: e
					, async: t
				};
				fa ? ha.push(a) : (ua.push([a]), ua.length > kt.undoLimit && ua.shift())
			}, ta.undo = function () {
				function e() {
					n < 0 ? (da = !1, t()) : (a = s[n], n--, a.async ? a.action(e) : (a.action(), e()))
				}

				function t() {
					(s = ma.shift()) && (da = !0, n = s.length - 1, e())
				}
				var a, n, s;
				ua.length && ma.push(ua.pop()), da || t()
			}, kt = ta.settings, Ne = ta.trigger, ta.init(t)
		};
	Kt.prototype = {
		_class: "listview"
		, _hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _defaults: {
			context: "body"
			, actionsWidth: 90
			, sortDelay: 250
			, undoLimit: 10
			, swipe: !0
			, quickSwipe: !0
			, animateIcons: !0
			, animation: !0
			, revert: !0
			, vibrate: !0
			, handleClass: ""
			, handleMarkup: '<div class="mbsc-lv-handle-bar mbsc-lv-handle"></div><div class="mbsc-lv-handle-bar mbsc-lv-handle"></div><div class="mbsc-lv-handle-bar mbsc-lv-handle"></div>'
			, listNode: "ul"
			, listSelector: "ul,ol"
			, itemNode: "li"
			, itemSelector: "li"
			, leftArrowClass: "mbsc-ic-arrow-left4"
			, rightArrowClass: "mbsc-ic-arrow-right4"
			, backText: "Back"
			, undoText: "Undo"
			, stages: []
		}
	}, $t.ListView = Kt, ie.themes.listview.mobiscroll = {
		leftArrowClass: "mbsc-ic-arrow-left5"
		, rightArrowClass: "mbsc-ic-arrow-right5"
	}, ie.presetShort("listview", "ListView");
	var Ut = {
		batch: 50
		, min: 0
		, max: 100
		, defaultUnit: ""
		, units: null
		, unitNames: null
		, invalid: []
		, sign: !1
		, step: .05
		, scale: 2
		, convert: function (e) {
			return e
		}
		, signText: "&nbsp;"
		, wholeText: "Whole"
		, fractionText: "Fraction"
		, unitText: "Unit"
	};
	ie.presets.scroller.measurement = function (e) {
		function t(e) {
			return Math.max(g, Math.min(x, O ? e < 0 ? Math.ceil(e) : Math.floor(e) : r(Math.round(e - j), z) + j))
		}

		function a(e) {
			return O ? r((Math.abs(e) - Math.abs(t(e))) * Y - W, z) + W : 0
		}

		function n(e) {
			var n = t(e)
				, s = a(e)
				, r = e < 0 ? "-" : "+";
			return s >= Y && (e < 0 ? n-- : n++, s = 0), [r, n, s]
		}

		function s(e) {
			var t = +e[f]
				, a = O ? e[h] / Y * (t < 0 ? -1 : 1) : 0;
			return (I && "-" == e[0] ? -1 : 1) * (t + a)
		}

		function r(e, t) {
			return Math.round(e / t) * t
		}

		function o(e, t, a) {
			return t !== a && S.convert ? S.convert.call(this, e, t, a) : e
		}

		function l(e) {
			var t, n;
			b = o(S.min, H, e), v = o(S.max, H, e), O ? (g = b < 0 ? Math.ceil(b) : Math.floor(b), x = v < 0 ? Math.ceil(v) : Math.floor(v), T = a(b), y = a(v)) : (g = Math.round(b), x = Math.round(v), x = g + Math.floor((x - g) / z) * z, j = g % z), t = g, n = x, I && (n = Math.abs(t) > Math.abs(n) ? Math.abs(t) : Math.abs(n), t = t < 0 ? 0 : t), N.min = t < 0 ? Math.ceil(t / L) : Math.floor(t / L), N.max = n < 0 ? Math.ceil(n / L) : Math.floor(n / L)
		}

		function c(e) {
			return s(e)
				.toFixed(O ? E : 0) + (F ? " " + P[e[p]] : "")
		}
		var d, m, u, h, f, p, b, v, g, x, T, y, _, w, M = Ve({}, e.settings)
			, S = Ve(e.settings, Ut, M)
			, C = {}
			, k = [[]]
			, D = {}
			, N = {}
			, V = {}
			, A = []
			, I = S.sign
			, F = S.units && S.units.length
			, H = F ? S.defaultUnit || S.units[0] : ""
			, P = []
			, O = S.step < 1
			, L = S.step > 1 ? S.step : 1
			, E = O ? Math.max(S.scale, (S.step + "")
				.split(".")[1].length) : 1
			, Y = Math.pow(10, E)
			, z = Math.round(O ? S.step * Y : S.step)
			, j = 0
			, W = 0
			, $ = 0;
		if (e.setVal = function (t, a, n, s, r) {
				e._setVal(ke.isArray(t) ? c(t) : t, a, n, s, r)
			}, S.units)
			for (w = 0; w < S.units.length; ++w) _ = S.units[w], P.push(S.unitNames ? S.unitNames[_] || _ : _);
		if (I)
			if (I = !1, F)
				for (w = 0; w < S.units.length; w++) o(S.min, H, S.units[w]) < 0 && (I = !0);
			else I = S.min < 0;
		if (I && (k[0].push({
				data: ["-", "+"]
				, label: S.signText
			}), $++), N = {
				label: S.wholeText
				, data: function (e) {
					return g % L + e * L
				}
				, getIndex: function (e) {
					return Math.round((e - g % L) / L)
				}
			}, k[0].push(N), f = $++, l(H), O) {
			for (k[0].push(V), V.data = [], V.label = S.fractionText, w = W; w < Y; w += z) A.push(w), V.data.push({
				value: w
				, display: "." + function (e, t) {
					for (e += ""; e.length < t;) e = "0" + e;
					return e
				}(w, E)
			});
			h = $++, d = Math.ceil(100 / z), S.invalid && S.invalid.length && (ke.each(S.invalid, function (e, t) {
				var a = t > 0 ? Math.floor(t) : Math.ceil(t);
				0 === a && (a = t <= 0 ? -.001 : .001), D[a] = (D[a] || 0) + 1, 0 === t && (a = .001, D[a] = (D[a] || 0) + 1)
			}), ke.each(D, function (e, t) {
				t < d ? delete D[e] : D[e] = e
			}))
		}
		if (F) {
			for (C = {
					data: []
					, label: S.unitText
					, cssClass: "mbsc-msr-whl-unit"
					, circular: !1
				}, w = 0; w < S.units.length; w++) C.data.push({
				value: w
				, display: P[w]
			});
			k[0].push(C)
		}
		return p = $, {
			wheels: k
			, minWidth: I && O ? 70 : 80
			, showLabel: !1
			, formatValue: c
			, compClass: "mbsc-msr"
			, parseValue: function (e) {
				var t, a = ("number" == typeof e ? e + "" : e) || S.defaultValue
					, s = (a + "")
					.split(" ")
					, r = +s[0]
					, o = []
					, c = "";
				return F && (c = ke.inArray(s[1], P), c = -1 == c ? ke.inArray(H, S.units) : c, c = -1 == c ? 0 : c), u = F ? S.units[c] : "", l(u), r = isNaN(r) ? 0 : r, r = i(r, b, v), t = n(r), t[1] = i(t[1], g, x), m = r, I && (o[0] = t[0], t[1] = Math.abs(t[1])), o[f] = t[1], O && (o[h] = t[2]), F && (o[p] = c), o
			}
			, onCancel: function () {
				m = void 0
			}
			, validate: function (t) {
				var a, c, d, _, w, M = t.values
					, C = t.index
					, k = t.direction
					, V = {}
					, P = []
					, E = {}
					, Y = F ? S.units[M[p]] : "";
				if (I && 0 === C && (m = Math.abs(m) * ("-" == M[0] ? -1 : 1)), (C === f || C === h && O || void 0 === m || void 0 === C) && (m = s(M), u = Y), (F && C === p && u !== Y || void 0 === C) && (l(Y), m = o(m, u, Y), u = Y, c = n(m), void 0 !== C && (E[f] = N, e.changeWheel(E)), I && (M[0] = c[0])), P[f] = [], I)
					for (P[0] = [], b > 0 && (P[0].push("-"), M[0] = "+"), v < 0 && (P[0].push("+"), M[0] = "-"), w = Math.abs("-" == M[0] ? g : x), $ = w + L; $ < w + 20 * L; $ += L) P[f].push($), V[$] = !0;
				if (m = i(m, b, v), c = n(m), d = I ? Math.abs(c[1]) : c[1], a = I ? "-" == M[0] : m < 0, M[f] = d, a && (c[0] = "-"), O && (M[h] = c[2]), ke.each(O ? D : S.invalid, function (e, t) {
						if (I && a) {
							if (!(t <= 0)) return;
							t = Math.abs(t)
						}
						t = r(o(t, H, Y), O ? 1 : z), V[t] = !0, P[f].push(t)
					}), M[f] = e.getValidValue(f, d, k, V), c[1] = M[f] * (I && a ? -1 : 1), O) {
					P[h] = [];
					var j = I ? M[0] + M[1] : (m < 0 ? "-" : "+") + Math.abs(c[1])
						, W = (b < 0 ? "-" : "+") + Math.abs(g)
						, R = (v < 0 ? "-" : "+") + Math.abs(x);
					j === W && ke(A)
						.each(function (e, t) {
							(a ? t > T : t < T) && P[h].push(t)
						}), j === R && ke(A)
						.each(function (e, t) {
							(a ? t < y : t > y) && P[h].push(t)
						}), ke.each(S.invalid, function (e, t) {
							_ = n(o(t, H, Y)), (c[0] === _[0] || 0 === c[1] && 0 === _[1] && 0 === _[2]) && c[1] === _[1] && P[h].push(_[2])
						})
				}

				return {
					disabled: P
					, valid: M
				}
			}
		}
	}, ie.presetShort("measurement");
	var Bt = ie.presets.scroller
		, qt = {
			min: 0
			, max: 100
			, defaultUnit: "km"
			, units: ["m", "km", "in", "ft", "yd", "mi"]
		}
		, Gt = {
			mm: .001
			, cm: .01
			, dm: .1
			, m: 1
			, dam: 10
			, hm: 100
			, km: 1e3
			, in: .0254
			, ft: .3048
			, yd: .9144
			, ch: 20.1168
			, fur: 201.168
			, mi: 1609.344
			, lea: 4828.032
		};
	ie.presetShort("distance"), Bt.distance = function (e) {
		var t = Ve({}, qt, e.settings);
		return Ve(e.settings, t, {
			sign: !1
			, convert: function (e, t, a) {
				return e * Gt[t] / Gt[a]
			}
		}), Bt.measurement.call(this, e)
	};
	var Xt = ie.presets.scroller
		, Zt = {
			min: 0
			, max: 100
			, defaultUnit: "N"
			, units: ["N", "kp", "lbf", "pdl"]
		}
		, Qt = {
			N: 1
			, kp: 9.80665
			, lbf: 4.448222
			, pdl: .138255
		};
	ie.presetShort("force"), Xt.force = function (e) {
		var t = Ve({}, Zt, e.settings);
		return Ve(e.settings, t, {
			sign: !1
			, convert: function (e, t, a) {
				return e * Qt[t] / Qt[a]
			}
		}), Xt.measurement.call(this, e)
	};
	var ea = ie.presets.scroller
		, ta = {
			min: 0
			, max: 1e3
			, defaultUnit: "kg"
			, units: ["g", "kg", "oz", "lb"]
			, unitNames: {
				tlong: "t (long)"
				, tshort: "t (short)"
			}
		}
		, aa = {
			mg: .001
			, cg: .01
			, dg: .1
			, g: 1
			, dag: 10
			, hg: 100
			, kg: 1e3
			, t: 1e6
			, drc: 1.7718452
			, oz: 28.3495
			, lb: 453.59237
			, st: 6350.29318
			, qtr: 12700.58636
			, cwt: 50802.34544
			, tlong: 1016046.9088
			, tshort: 907184.74
		};
	ie.presetShort("mass"), ea.mass = function (e) {
		var t = Ve({}, ta, e.settings);
		return Ve(e.settings, t, {
			sign: !1
			, convert: function (e, t, a) {
				return e * aa[t] / aa[a]
			}
		}), ea.measurement.call(this, e)
	};
	var na = ie.presets.scroller
		, sa = {
			min: 0
			, max: 100
			, defaultUnit: "kph"
			, units: ["kph", "mph", "mps", "fps", "knot"]
			, unitNames: {
				kph: "km/h"
				, mph: "mi/h"
				, mps: "m/s"
				, fps: "ft/s"
				, knot: "knot"
			}
		}
		, ra = {
			kph: 1
			, mph: 1.60934
			, mps: 3.6
			, fps: 1.09728
			, knot: 1.852
		};
	ie.presetShort("speed"), na.speed = function (e) {
		var t = Ve({}, sa, e.settings);
		return Ve(e.settings, t, {
			sign: !1
			, convert: function (e, t, a) {
				return e * ra[t] / ra[a]
			}
		}), na.measurement.call(this, e)
	};
	var oa = ie.presets.scroller
		, ia = {
			min: -20
			, max: 40
			, defaultUnit: "c"
			, units: ["c", "k", "f", "r"]
			, unitNames: {
				c: "°C"
				, k: "K"
				, f: "°F"
				, r: "°R"
			}
		}
		, la = {
			c2k: function (e) {
				return e + 273.15
			}
			, c2f: function (e) {
				return 9 * e / 5 + 32
			}
			, c2r: function (e) {
				return 9 * (e + 273.15) / 5
			}
			, k2c: function (e) {
				return e - 273.15
			}
			, k2f: function (e) {
				return 9 * e / 5 - 459.67
			}
			, k2r: function (e) {
				return 9 * e / 5
			}
			, f2c: function (e) {
				return 5 * (e - 32) / 9
			}
			, f2k: function (e) {
				return 5 * (e + 459.67) / 9
			}
			, f2r: function (e) {
				return e + 459.67
			}
			, r2c: function (e) {
				return 5 * (e - 491.67) / 9
			}
			, r2k: function (e) {
				return 5 * e / 9
			}
			, r2f: function (e) {
				return e - 459.67
			}
		};
	ie.presetShort("temperature"), oa.temperature = function (e) {
		var t = Ve({}, ia, e.settings);
		return Ve(e.settings, t, {
			sign: !0
			, convert: function (e, t, a) {
				return la[t + "2" + a](e)
			}
		}), oa.measurement.call(this, e)
	};
	var ca = 1
		, da = function (e, t, n) {
			function s(e) {
				clearTimeout(v), v = setTimeout(function () {
					l("load" !== e.type)
				}, 200)
			}

			function o(t, a) {
				if (t.length) {
					if (a = k._onItemTap(t, a), c = t, t.parent()[0] == e) {
						var n = t.offset()
							.left
							, s = t[0].offsetLeft
							, r = t[0].offsetWidth
							, o = d.offset()
							.left;
						g && (s = _ - s - r), "a" == y.variant ? n < o ? x.scroll(g ? s + r - f : -s, C, !0) : n + r > o + f && x.scroll(g ? s : f - s - r, C, !0) : x.scroll(f / 2 - s - r / 2, C, !0)
					}
					a && M("onItemTap", {
						target: t[0]
					})
				}
			}

			function i() {
				var e, t;
				k._initMarkup(d), D.find(".mbsc-ripple")
					.remove(), k._$items = D.children(), k._$items.each(function (a) {
						var n, s = ke(this)
							, r = s.attr("data-ref");
						r || (r = ca++), 0 === a && (e = s), c || (c = k._getActiveItem(s)), t = k._getItemProps(s) || {}, n = "mbsc-scv-item " + (t.cssClass || ""), s.attr("data-ref", r)
							.removeClass(S[r])
							.addClass(n), S[r] = n
					}), c || (c = e), k._markupReady(d)
			}

			function l(t, a) {
				var n = y.itemWidth
					, s = y.layout;
				k.contWidth = f = d.width(), t && b === f || !f || (b = f, r(s) && (p = f ? f / s : n) < n && (s = "liquid"), n && ("liquid" == s ? p = f ? f / Math.min(Math.floor(f / n), k._$items.length) : n : "fixed" == s && (p = n)), k._size(f, p), p && D.children()
					.css("width", p + "px"), k.totalWidth = _ = e.offsetWidth, Ve(x.settings, {
						contSize: f
						, maxSnapScroll: !!y.paging && 1
						, maxScroll: 0
						, minScroll: _ > f ? f - _ : 0
						, snap: y.paging ? f : !!T && (p || ".mbsc-scv-item")
						, elastic: _ > f && (p || f)
					}), x.refresh(a))
			}
			var c, d, u, h, f, p, b, v, g, x, T, y, _, w, M, S = {}
				, C = 1e3
				, k = this
				, D = ke(e);
			Ae.call(this, e, t, !0), k.navigate = function (e, t) {
				o(k._getItem(e), t)
			}, k.next = function (e) {
				if (c) {
					var t = c.next();
					t.length && (c = t, o(c, e))
				}
			}, k.prev = function (e) {
				if (c) {
					var t = c.prev();
					t.length && (c = t, o(c, e))
				}
			}, k.refresh = k.position = function (e) {
				i(), l(!1, e)
			}, k._init = function () {
				var e;
				if(y.itemWidth && y.snap == undefined){
                	y.snap = true;
                }
				u = ke(y.context), h = ke("body" == y.context ? window : y.context), k.__init(), 
				g = y.rtl, 
				T = y.snap, 
				e = "mbsc-scv-c mbsc-"+y.theme+" "+(y.cssClass || '') +" "+ (g ? 'mbsc-rtl':'') + " mbsc-ltr" + (k._getContClass() || ""), d ? (d.attr("class", e), D.off(".mbsc-ripple")) : (d = ke('<div class="' + e + '"><div class="mbsc-scv-sc"></div></div>')
						.insertAfter(D), d.find(".mbsc-scv-sc")
						.append(D), x = new Ge(d[0], {
							axis: "X"
							, contSize: 0
							, maxScroll: 0
							, maxSnapScroll: 1
							, minScroll: 0
							, snap: 1
							, elastic: 1
							, rtl: g
							, mousewheel: y.mousewheel
							, thresholdX: y.threshold
							, onStart: function (e) {
								w || "touchstart" != e.domEvent.type || (w = !0, u.find(".mbsc-no-touch")
									.removeClass("mbsc-no-touch"))
							}
							, onBtnTap: function (e) {
								"touchend" === e.domEvent.type && m(e.domEvent, e.target), o(ke(e.target), !0)
							}
							, onGestureStart: function (e) {
								M("onGestureStart", e)
							}
							, onGestureEnd: function (e) {
								M("onGestureEnd", e)
							}
							, onMove: function (e) {
								M("onMove", e)
							}
							, onAnimationStart: function (e) {
								M("onAnimationStart", e)
							}
							, onAnimationEnd: function (e) {
								M("onAnimationEnd", e)
							}
						})), D.css("display", "")
					.addClass("mbsc-scv"), i(), M("onMarkupReady", {
						target: d[0]
					}), l(), d.find("img")
					.on("load", s), h.on("orientationchange resize", s)
			}, k._size = a, k._initMarkup = a, k._markupReady = a, k._onItemTap = a, k._getContClass = a, k._getItemProps = a, k._getActiveItem = a, k.__init = a, k.__destroy = a, k._destroy = function () {
				k.__destroy(), h.off("orientationchange resize", s), D.removeClass("mbsc-scv")
					.insertAfter(d)
					.find(".mbsc-scv-item")
					.each(function () {
						var e = ke(this);
						e.width("")
							.removeClass(S[e.attr("data-ref")])
					}), d.remove(), x.destroy()
			}, k._getItem = function (e) {
				return "object" !== (void 0 === e ? "undefined" : le(e)) && (e = k._$items.filter('[data-id="' + e + '"]')), ke(e)
			}, y = k.settings, M = k.trigger, n || k.init(t)
		};
	da.prototype = {
		_class: "scrollview"
		, _hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _defaults: {
			tap: !0
			, context: "body"
			, layout: "liquid"
		}
	}, ie.classes.ScrollView = da, ie.presetShort("scrollview", "ScrollView");
	var ma = function (e, t, n) {
		function s() {
			l && "inline" != l && i.find(".mbsc-page")
				.css("padding-" + l, "")
		}

		function r(e) {
			e.addClass(m)
				.attr("data-selected", "true")
				.attr("aria-selected", "true")
		}

		function o(e) {
			e.removeClass(m)
				.removeAttr("data-selected")
				.removeAttr("aria-selected")
		}
		var i, l, c, d, m, u, h = ke(e)
			, f = this;
		da.call(this, e, t, !0), f.select = function (e) {
			c || o(f._$items.filter(".mbsc-ms-item-sel")), r(f._getItem(e))
		}, f.deselect = function (e) {
			o(f._getItem(e))
		}, f.enable = function (e) {
			f._getItem(e)
				.removeClass("mbsc-btn-d mbsc-fr-btn-d")
				.removeAttr("data-disabled")
				.removeAttr("aria-disabled")
		}, f.disable = function (e) {
			f._getItem(e)
				.addClass("mbsc-btn-d mbsc-fr-btn-d")
				.attr("data-disabled", "true")
				.attr("aria-disabled", "true")
		}, f.setBadge = function (e, t) {
			var a;
			e = f._getItem(e)
				.attr("data-badge", t), a = ke(".mbsc-ms-badge", e), a.length ? t ? a.html(t) : a.remove() : t && e.append('<span class="mbsc-ms-badge">' + t + "</span>")
		}, f._markupReady = function (e) {
			f._hasIcons ? e.addClass("mbsc-ms-icons") : e.removeClass("mbsc-ms-icons"), f._hasText ? e.addClass("mbsc-ms-txt") : e.removeClass("mbsc-ms-txt"), f.__markupReady(e)
		}, f._size = function (t, a) {
			f.__size(t, a), "inline" != l && i.find(".mbsc-page")
				.css("padding-" + l, e.offsetHeight + "px")
		}, f._onItemTap = function (e, t) {
			return !1 !== f.__onItemTap(e, t) && (void 0 === t && (t = !c), d && t && !e.hasClass("mbsc-btn-d") && (c ? "true" == e.attr("data-selected") ? o(e) : r(e) : (o(f._$items.filter(".mbsc-ms-item-sel")), r(e))), t)
		}, f._getActiveItem = function (e) {
			var t = "true" == e.attr("data-selected");
			if (d && !c && t) return e
		}, f._getItemProps = function (e) {
			var t = "true" == e.attr("data-selected")
				, a = "true" == e.attr("data-disabled")
				, n = e.attr("data-icon")
				, s = e.attr("data-badge");
			return e.attr("data-role", "button")
				.attr("aria-selected", t ? "true" : "false")
				.attr("aria-disabled", a ? "true" : "false"), s && e.append('<span class="mbsc-ms-badge">' + s + "</span>"), n && (f._hasIcons = !0), e.text() && (f._hasText = !0), {
					cssClass: "mbsc-ms-item mbsc-btn-e " + (u.itemClass || "") + " " + (t ? m : "") + (a ? " mbsc-btn-d mbsc-fr-btn-d " + (u.disabledClass || "") : "") + (n ? " mbsc-ms-ic mbsc-ic mbsc-ic-" + n : "")
				}
		}, f._getContClass = function () {
			return " mbsc-ms-c mbsc-ms-" + u.variant + " mbsc-ms-" + l + (d ? "" : " mbsc-ms-nosel") + (f.__getContClass() || "")
		}, f.__init = function () {
			f.___init(), i = ke(u.context), s(), l = u.display, c = "multiple" == u.select, d = "off" != u.select, m = " mbsc-ms-item-sel " + (u.activeClass || ""), h.addClass("mbsc-ms mbsc-ms-base " + (u.groupClass || ""))
		}, f.__destroy = function () {
			h.removeClass("mbsc-ms mbsc-ms-base " + (u.groupClass || "")), s(), f.___destroy()
		}, f.__onItemTap = a, f.__getContClass = a, f.__markupReady = a, f.__size = a, f.___init = a, f.___destroy = a, u = f.settings, n || f.init(t)
	};
	ma.prototype = {
		_defaults: Ve({}, da.prototype._defaults)
	};
	var ua = function (e, t) {
		var a = this;
		ma.call(this, e, t, !0), a.___init = function () {}, a.settings, a.init(t)
	};
	ua.prototype = {
		_class: "optionlist"
		, _hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _defaults: Ve({}, ma.prototype._defaults, {
			select: "multiple"
			, variant: "a"
			, display: "inline"
		})
	}, ie.classes.Optionlist = ua, ie.themes.optionlist = ie.themes.navigation, ie.presetShort("optionlist", "Optionlist");
	var ha = function (e, t) {
		var a, n, s, r, o, i = ke(e)
			, l = i.is("ul,ol")
			, c = this;
		ma.call(this, e, t, !0), c._initMarkup = function () {
			a && a.remove(), n && i.append(n.children())
		}, c.__size = function (e, t) {
			var l, d = t || 72
				, m = c._$items.length
				, u = 0;
			o.hide(), "bottom" == r.type && (i.removeClass("mbsc-scv-liq"), a.remove(), c._$items.remove()
				.each(function (a) {
					var s = ke(this);
					i.append(s), u += t || this.offsetWidth || 0, Math.round(u + (a < m - 1 ? d : 0)) > e && (l = !0, n.append(s.css("width", "")
						.addClass("mbsc-fr-btn-e")))
				}), a.attr("class", s + (r.moreIcon ? " mbsc-menu-item-ic mbsc-ms-ic mbsc-ic mbsc-ic-" + r.moreIcon : ""))
				.html(c._hasIcons && c._hasText ? r.moreText : ""), l && i.append(a)), "liquid" == r.layout && i.addClass("mbsc-scv-liq")
		}, c.__onItemTap = function (e) {
			if (e.hasClass("mbsc-menu-item")) return o.show(!1, !0), !1
		}, c.__getContClass = function () {
			return "hamburger" == r.type ? " mbsc-ms-hamburger" : ""
		}, c.__markupReady = function (e) {
			"hamburger" == r.type && (n.append(c._$items.addClass("mbsc-fr-btn-e")), a.attr("class", s + (r.menuIcon ? " mbsc-menu-item-ic mbsc-ms-ic mbsc-ic mbsc-ic-" + r.menuIcon : ""))
				.html(r.menuText || ""), i.append(a), r.menuText && r.menuIcon || e.removeClass("mbsc-ms-icons"), r.menuText ? e.addClass("mbsc-ms-txt") : e.removeClass("mbsc-ms-txt"))
		}, c.___init = function () {
			"tab" == r.type ? (r.display = r.display || "top", r.variant = r.variant || "b") : "bottom" == r.type ? (r.display = r.display || "bottom", r.variant = r.variant || "a") : "hamburger" == r.type && (r.display = r.display || "inline", r.variant = r.variant || "a"), s = "mbsc-scv-item mbsc-ms-item mbsc-btn-e mbsc-menu-item " + (r.itemClass || ""), a || (a = ke(l ? "<li></li>" : "<div></div>"), n = ke(l ? "<ul></ul>" : "<div></div>")
				.addClass("mbsc-scv mbsc-ms")), o = new vt(n[0], {
				display: "bubble"
				, theme: r.theme
				, lang: r.lang
				, context: r.context
				, buttons: []
				, anchor: a
				, onBeforeShow: function (e, t) {
					t.settings.cssClass = "mbsc-wdg mbsc-ms-a mbsc-ms-more" + (c._hasText ? "" : " mbsc-ms-more-icons")
				}
				, onMarkupReady: function (e, t) {
					c.tap(t._markup.find(".mbsc-fr-c"), function (e) {
						var t = ke(e.target)
							.closest(".mbsc-ms-item");
						t.length && !t.hasClass("mbsc-btn-d") && (c.navigate(t, !0), o.hide())
					})
				}
			})
		}, c.___destroy = function () {
			o.destroy(), i.append(c._$items), a.remove()
		}, r = c.settings, c.init(t)
	};
	ha.prototype = {
		_class: "navigation"
		, _hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _defaults: Ve({}, ma.prototype._defaults, {
			type: "bottom"
			, moreText: "More"
			, moreIcon: "material-more-horiz"
			, menuIcon: "material-menu"
		})
	}, ie.classes.Navigation = ha, ie.presetShort("nav", "Navigation"), ie.presets.scroller.number = ie.presets.scroller.measurement, ie.presetShort("number");
	var fa = ie.presets.numpad
		, pa = function (e, t, a) {
			function n(t) {
				var a, n = T.validate.call(e, {
						values: A.slice(0)
						, variables: z
					}, L) || []
					, r = n && n.disabled || [];
				if (L._isValid = !n.invalid, L._tempValue = T.formatValue.call(e, A.slice(0), z, L), x = A.length, I = n.length || H, L._isVisible && ie.Wodxy) {
					if (ke(".mbsc-np-ph", b)
						.each(function (e) {
							ke(this)
								.html("ltr" == T.fill ? e >= x ? g : _ || A[e] : e >= H - I ? e + x < H ? g : _ || A[e + x - H] : "")
						}), ke(".mbsc-np-cph", b)
						.each(function () {
							ke(this)
								.html(z[ke(this)
										.attr("data-var")] || ke(this)
									.attr("data-ph"))
						}), x === H)
						for (a = 0; a <= 9; a++) r.push(a);
					for (ke(".mbsc-np-btn", b)
						.removeClass(v), a = 0; a < r.length; a++) ke('.mbsc-np-btn[data-val="' + r[a] + '"]', b)
						.addClass(v);
					L._isValid ? ke(".mbsc-fr-btn-s .mbsc-fr-btn", b)
						.removeClass(v) : ke(".mbsc-fr-btn-s .mbsc-fr-btn", b)
						.addClass(v), L.live && (L._hasValue = t || L._hasValue, s(t, !1, t), t && F("onSet", {
							valueText: L._value
						}))
				}
			}

			function s(e, t, a, s) {
				t && n(), s || (P = A.slice(0), j = Ve({}, z), E = Y.slice(0), L._value = L._hasValue ? L._tempValue : null), e && (L._isInput && O.val(L._hasValue && L._isValid ? L._value : ""), F("onFill", {
					valueText: L._hasValue ? L._tempValue : ""
					, change: a
				}), a && (L._preventChange = !0, O.trigger("change")))
			}

			function o(e) {
				var t, a, n = e || []
					, s = [];
				for (Y = [], z = {}, t = 0; t < n.length; t++) /:/.test(n[t]) ? (a = n[t].split(":"), z[a[0]] = a[1], Y.push(a[0])) : (s.push(n[t]), Y.push("digit"));
				return s
			}

			function i(e, t) {
				!(x || t || T.allowLeadingZero) || e.hasClass("mbsc-fr-btn-d") || e.hasClass("mbsc-np-btn-empty") || x < H && ie.Wodxy && (Y.push("digit"), A.push(t), n(!0))
			}

			function l(e) {
				var t, a, s = e.attr("data-val")
					, o = "false" !== e.attr("data-track")
					, i = e.attr("data-var");
				if (!e.hasClass("mbsc-fr-btn-d")) {
					if (i && (a = i.split(":"), o && Y.push(a[0]), z[a[0]] = void 0 === a[2] ? a[1] : z[a[0]] == a[1] ? a[2] : a[1]), s.length + x <= I)
						for (t = 0; t < s.length; ++t) a = r(s[t]) ? +s[t] : s[t], (T.allowLeadingZero || x || a) && (Y.push("digit"), A.push(a), x = A.length);
					n(!0)
				}
			}

			function c() {
				var e, t, a = Y.pop();
				if (x || "digit" !== a) {
					if ("digit" !== a && z[a])
						for (delete z[a], t = Y.slice(0), Y = [], e = 0; e < t.length; e++) t[e] !== a && Y.push(t[e]);
					else A.pop();
					n(!0)
				}
			}

			function d(e) {
				N = !0, w = u(e, "X"), M = u(e, "Y"), clearInterval(V), clearTimeout(V), c(), V = setInterval(function () {
					c()
				}, 150)
			}

			function m() {
				clearInterval(V), N = !1
			}

			function h(e) {
				if (y(e, this)) {
					if ("keydown" == e.type && 32 != e.keyCode) return;
					d(e), "mousedown" == e.type && ke(document)
						.on("mousemove", f)
						.on("mouseup", p)
				}
			}

			function f(e) {
				N && (S = u(e, "X"), C = u(e, "Y"), k = S - w, D = C - M, (Math.abs(k) > 7 || Math.abs(D) > 7) && m())
			}

			function p(e) {
				N && (e.preventDefault(), m(), "mouseup" == e.type && ke(document)
					.off("mousemove", f)
					.off("mouseup", p))
			}
			var b, v, g, x, T, _, w, M, S, C, k, D, N, V, A, I, F, H, P, O = ke(e)
				, L = this
				, E = []
				, Y = []
				, z = {}
				, j = {}
				, W = {
					107: "+"
					, 109: "-"
				}
				, $ = {
					48: 0
					, 49: 1
					, 50: 2
					, 51: 3
					, 52: 4
					, 53: 5
					, 54: 6
					, 55: 7
					, 56: 8
					, 57: 9
					, 96: 0
					, 97: 1
					, 98: 2
					, 99: 3
					, 100: 4
					, 101: 5
					, 102: 6
					, 103: 7
					, 104: 8
					, 105: 9
				};
			Be.call(this, e, t, !0), L.setVal = L._setVal = function (t, a, n, r) {
				L._hasValue = null !== t && void 0 !== t, A = o(ke.isArray(t) ? t.slice(0) : T.parseValue.call(e, t, L)), s(a, !0, void 0 === n ? a : n, r)
			}, L.getVal = L._getVal = function (e) {
				return L._hasValue || e ? L[e ? "_tempValue" : "_value"] : null
			}, L.setArrayVal = L.setVal, L.getArrayVal = function (e) {
				return e ? A.slice(0) : L._hasValue ? P.slice(0) : null
			}, L._readValue = function () {
				var t = O.val() || "";
				"" !== t && (L._hasValue = !0), _ ? (z = {}, Y = [], A = []) : (z = L._hasValue ? j : {}, Y = L._hasValue ? E : [], A = L._hasValue && P ? P.slice(0) : o(T.parseValue.call(e, t, L)), s(!1, !0))
			}, L._fillValue = function () {
				L._hasValue = !0, s(!0, !1, !0)
			}, L._generateContent = function () {
				var e, t, a, n = 1
					, s = ""
					, r = "";
				for (r += '<div class="mbsc-np-hdr"><div role="button" tabindex="0" aria-label="' + T.deleteText + '" class="mbsc-np-del mbsc-fr-btn-e mbsc-ic mbsc-ic-' + T.deleteIcon + '"></div><div class="mbsc-np-dsp">', s = T.template.replace(/d/g, '<span class="mbsc-np-ph">' + g + "</span>")
					.replace(/&#100;/g, "d"), s = s.replace(/{([a-zA-Z0-9]*)\:?([a-zA-Z0-9\-\_]*)}/g, '<span class="mbsc-np-cph" data-var="$1" data-ph="$2">$2</span>'), r += s, r += "</div></div>", r += '<div class="mbsc-np-tbl-c mbsc-w-p"><div class="mbsc-np-tbl">', e = 0; e < 4; e++) {
					for (r += '<div class="mbsc-np-row">', t = 0; t < 3; t++) a = n, 10 == n || 12 == n ? a = "" : 11 == n && (a = 0), "" === a ? 10 == n && T.leftKey ? r += '<div role="button" tabindex="0" class="mbsc-np-btn mbsc-np-btn-custom mbsc-fr-btn-e" ' + (T.leftKey.variable ? 'data-var="' + T.leftKey.variable + '"' : "") + ' data-val="' + (T.leftKey.value || "") + '" ' + (void 0 !== T.leftKey.track ? ' data-track="' + T.leftKey.track + '"' : "") + ">" + T.leftKey.text + "</div>" : 12 == n && T.rightKey ? r += '<div role="button" tabindex="0" class="mbsc-np-btn mbsc-np-btn-custom mbsc-fr-btn-e" ' + (T.rightKey.variable ? 'data-var="' + T.rightKey.variable + '"' : "") + ' data-val="' + (T.rightKey.value || "") + '" ' + (void 0 !== T.rightKey.track ? ' data-track="' + T.rightKey.track + '"' : "") + " >" + T.rightKey.text + "</div>" : r += '<div class="mbsc-np-btn mbsc-np-btn-empty"></div>' : r += '<div tabindex="0" role="button" class="mbsc-np-btn mbsc-fr-btn-e" data-val="' + a + '">' + a + "</div>", n++;
					r += "</div>"
				}
				return r += "</div></div>"
			}, L._markupReady = function () {
				b = L._markup, n()
			}, L._attachEvents = function (e) {
				e.on("keydown", function (t) {
						var a;
						void 0 !== W[t.keyCode] ? (a = ke('.mbsc-np-btn[data-var="sign:-:"]', e), a.length && (z.sign = 107 == t.keyCode ? "-" : "", l(a))) : void 0 !== $[t.keyCode] ? i(ke('.mbsc-np-btn[data-val="' + $[t.keyCode] + '"]', e), $[t.keyCode]) : 8 == t.keyCode && (t.preventDefault(), c())
					}), L.tap(ke(".mbsc-np-btn", e), function () {
						var e = ke(this);
						e.hasClass("mbsc-np-btn-custom") ? l(e) : i(e, +e.attr("data-val"))
					}, !1, 30, !0), ke(".mbsc-np-del", e)
					.on("touchstart mousedown keydown", h)
					.on("touchmove mousemove", f)
					.on("touchend mouseup keyup", p)
			}, L.__init = function () {
				T = L.settings, T.cssClass = (T.cssClass || "") + " mbsc-np", T.template = T.template.replace(/\\d/, "&#100;"), g = T.placeholder, H = (T.template.match(/d/g) || [])
					.length, v = "mbsc-fr-btn-d " + (T.disabledClass || ""), _ = T.mask, F = L.trigger, _ && O.is("input") && O.attr("type", "password")
			}, L._indexOf = function (e, t) {
				var a;
				for (a = 0; a < e.length; ++a)
					if (e[a].toString() === t.toString()) return a;
				return -1
			}, a || L.init(t)
		};
	pa.prototype = {
		_hasDef: !0
		, _hasTheme: !0
		, _hasLang: !0
		, _hasPreset: !0
		, _class: "numpad"
		, _defaults: Ve({}, Be.prototype._defaults, {
			template: "dd.dd"
			, placeholder: "0"
			, deleteIcon: "backspace"
			, allowLeadingZero: !1
			, headerText: !1
			, fill: "rtl"
			, deleteText: "Delete"
			, decimalSeparator: "."
			, thousandsSeparator: ","
			, validate: a
			, parseValue: a
			, formatValue: function (e, t, a) {
				var n, s = 1
					, r = a.settings
					, o = r.placeholder
					, i = r.template
					, l = e.length
					, c = i.length
					, d = "";
				for (n = 0; n < c; n++) "d" == i[c - n - 1] ? (d = s <= l ? e[l - s] + d : o + d, s++) : d = i[c - n - 1] + d;
				return ke.each(t, function (e, t) {
						d = d.replace("{" + e + "}", t)
					}), ke("<div>" + d + "</div>")
					.text()
			}
		})
	}, ie.classes.Numpad = pa, ie.themes.numpad = ie.themes.frame, ie.presetShort("numpad", "Numpad", !1);
	var ba = {
		min: 0
		, max: 99.99
		, scale: 2
		, prefix: ""
		, suffix: ""
		, returnAffix: !1
	};
	fa.decimal = function (e) {
		function t(e, t) {
			for (var a, n = e.slice(0), r = 0; n.length;) r = 10 * r + n.shift();
			for (a = 0; a < s.scale; a++) r /= 10;
			return t ? -1 * r : r
		}

		function a(e) {
			return t(e)
				.toFixed(s.scale)
				.replace(".", s.decimalSeparator)
				.replace(/\B(?=(\d{3})+(?!\d))/g, s.thousandsSeparator)
		}
		var n = Ve({}, e.settings)
			, s = Ve(e.settings, ba, n)
			, o = s.min < 0;
		return e.getVal = function (t) {
			var a = e._getVal(t)
				, n = (a + "")
				.replace(s.decimalSeparator, ".")
				.replace(s.thousandsSeparator, "");
			return r(n) ? +n : a
		}, {
			template: (o ? "{sign}" : "") + s.prefix.replace(/d/g, "\\d") + Array((Math.floor(Math.max(s.max, Math.abs(s.min))) + "")
					.length + 1)
				.join("d") + (s.scale ? "." + Array(s.scale + 1)
					.join("d") : "") + s.suffix.replace(/d/g, "\\d")
			, leftKey: o ? {
				text: "-/+"
				, variable: "sign:-:"
				, track: !1
			} : void 0
			, parseValue: function (e) {
				var t, a, n = e || s.defaultValue
					, r = [];
				if (n && (n = (n + "")
						.replace(s.decimalSeparator, ".")
						.replace(s.thousandsSeparator, ""), a = n.match(/\d+\.?\d*/g)))
					for (a = (+a[0])
						.toFixed(s.scale), t = 0; t < a.length; t++) "." != a[t] && (+a[t] ? r.push(+a[t]) : r.length && r.push(0));
				return e < 0 && r.push("sign:-"), r
			}
			, formatValue: function (e, n) {
				var r = a(e);
				return (t(e, n && "-" == n.sign) < 0 ? "-" : "") + (s.returnAffix ? s.prefix + r + s.suffix : r)
			}
			, validate: function (n) {
				var r = n.values
					, o = a(r)
					, i = t(r, n.variables && "-" == n.variables.sign)
					, l = [];
				return r.length || s.allowLeadingZero || l.push(0), e.isVisible() && ke(".mbsc-np-dsp", e._markup)
					.html((n.variables.sign || "") + s.prefix + o + s.suffix), {
						disabled: l
						, invalid: i > s.max || i < s.min || !!s.invalid && -1 != e._indexOf(s.invalid, i)
					}
			}
		}
	};
	var va = ["h", "m", "s"]
		, ga = {
			min: 0
			, max: 362439
			, defaultValue: 0
			, hourTextShort: "h"
			, minuteTextShort: "m"
			, secTextShort: "s"
		};
	fa.timespan = function (e) {
		function t(e) {
			var t, a = ""
				, n = 3600;
			return ke(va)
				.each(function (r, o) {
					t = Math.floor(e / n), e -= t * n, n /= 60, (t > 0 || "s" == o && !a) && (a = a + (a ? " " : "") + t + s[o])
				}), a
		}
		var a = Ve({}, e.settings)
			, n = Ve(e.settings, ga, a)
			, s = {
				h: n.hourTextShort.replace(/d/g, "\\d")
				, m: n.minuteTextShort.replace(/d/g, "\\d")
				, s: n.secTextShort.replace(/d/g, "\\d")
			}
			, o = 'd<span class="mbsc-np-sup mbsc-np-time">' + s.s + "</span>";
		return n.max > 9 && (o = "d" + o), n.max > 99 && (o = '<span class="mbsc-np-ts-m">' + (n.max > 639 ? "d" : "") + 'd</span><span class="mbsc-np-sup mbsc-np-time">' + s.m + "</span>" + o), n.max > 6039 && (o = '<span class="mbsc-np-ts-h">' + (n.max > 38439 ? "d" : "") + 'd</span><span class="mbsc-np-sup mbsc-np-time">' + s.h + "</span>" + o), e.setVal = function (a, n, s, o) {
			return r(a) && (a = t(a)), e._setVal(a, n, s, o)
		}, e.getVal = function (t) {
			return e._hasValue || t ? ee(e.getArrayVal(t)) : null
		}, {
			template: o
			, parseValue: function (e) {
				var a, r = e || t(n.defaultValue)
					, o = [];
				return r && ke(va)
					.each(function (e, t) {
						a = new RegExp("(\\d+)" + s[t], "gi")
							.exec(r), a ? (a = +a[1], a > 9 ? (o.push(Math.floor(a / 10)), o.push(a % 10)) : (o.length && o.push(0), (a || o.length) && o.push(a))) : o.length && (o.push(0), o.push(0))
					}), o
			}
			, formatValue: function (e) {
				return t(ee(e))
			}
			, validate: function (t) {
				var a = t.values
					, s = ee(a.slice(0))
					, r = [];
				return a.length || r.push(0), {
					disabled: r
					, invalid: s > n.max || s < n.min || !!n.invalid && -1 != e._indexOf(n.invalid, +s)
				}
			}
		}
	};
	var xa = {
		timeFormat: "hh:ii A"
		, amText: "am"
		, pmText: "pm"
	};
	fa.time = function (e) {
		function t(e, t) {
			var a, n = "";
			for (a = 0; a < e.length; ++a) n += e[a] + (a % 2 == (e.length % 2 == 1 ? 0 : 1) && a != e.length - 1 ? ":" : "");
			return ke.each(t, function (e, t) {
				n += " " + t
			}), n
		}

		function a(e) {
			var t, a, n, i, l, b, v, g, x, T, y = []
				, _ = 2 * r.length;
			if (c = _, e.length || (o && (y.push(0), y.push(s.leftKey.value)), y.push(s.rightKey.value)), !o && (_ - e.length < 2 || 1 != e[0] && (e[0] > 2 || e[1] > 3) && _ - e.length <= 2) && (y.push("30"), y.push("00")), (o ? e[0] > 1 || e[1] > 2 : 1 != e[0] && (e[0] > 2 || e[1] > 3)) && e[0] && (e.unshift(0), c = _ - 1), e.length == _)
				for (t = 0; t <= 9; ++t) y.push(t);
			else if (1 == e.length && o && 1 == e[0] || e.length && e.length % 2 == 0 || !o && 2 == e[0] && e[1] > 3 && e.length % 2 == 1)
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
				if (a = +d == +x, n = +m == +x, l = n && T, i = a && T, 0 === e.length) {
					for (t = o ? 2 : d > 19 ? d[0] : 3; t <= (1 == d[0] ? 9 : d[0] - 1); ++t) y.push(t);
					if (d >= 10 && (y.push(0), 2 == d[0]))
						for (t = 3; t <= 9; ++t) y.push(t);
					if (m && m < 10 || d && d >= 10)
						for (t = m && m < 10 ? +m[0] + 1 : 0; t < (d && d >= 10 ? d[0] : 10); ++t) y.push(t)
				}
				if (1 == e.length) {
					if (0 === e[0])
						for (t = 0; t < d[0]; ++t) y.push(t);
					if (d && 0 !== e[0] && (o ? 1 == e[0] : 2 == e[0]))
						for (t = o ? 3 : 4; t <= 9; ++t) y.push(t);
					if (e[0] == d[0])
						for (t = 0; t < d[1]; ++t) y.push(t);
					if (e[0] == m[0] && !o)
						for (t = +m[1] + 1; t <= 9; ++t) y.push(t)
				}
				if (2 == e.length && (a || n))
					for (t = n ? +h[0] + 1 : 0; t < (a ? +u[0] : 10); ++t) y.push(t);
				if (3 == e.length && (n && e[2] == h[0] || a && e[2] == u[0]))
					for (t = n && e[2] == h[0] ? +h[1] + 1 : 0; t < (a && e[2] == u[0] ? +u[1] : 10); ++t) y.push(t);
				if (4 == e.length && (i || l))
					for (t = l ? +p[0] + 1 : 0; t < (i ? +f[0] : 10); ++t) y.push(t);
				if (5 == e.length && (i && e[4] == f[0] || l && e[4] == p[0]))
					for (t = l && e[4] == p[0] ? +p[1] + 1 : 0; t < (i && e[4] == f[0] ? +f[1] : 10); ++t) y.push(t)
			}
			return y
		}
		var n = Ve({}, e.settings)
			, s = Ve(e.settings, xa, n)
			, r = s.timeFormat.split(":")
			, o = s.timeFormat.match(/a/i)
			, i = o ? "a" == o[0] ? s.amText : s.amText.toUpperCase() : ""
			, l = o ? "a" == o[0] ? s.pmText : s.pmText.toUpperCase() : ""
			, c = 0
			, d = s.min ? "" + s.min.getHours() : ""
			, m = s.max ? "" + s.max.getHours() : ""
			, u = s.min ? "" + (s.min.getMinutes() < 10 ? "0" + s.min.getMinutes() : s.min.getMinutes()) : ""
			, h = s.max ? "" + (s.max.getMinutes() < 10 ? "0" + s.max.getMinutes() : s.max.getMinutes()) : ""
			, f = s.min ? "" + (s.min.getSeconds() < 10 ? "0" + s.min.getSeconds() : s.min.getSeconds()) : ""
			, p = s.max ? "" + (s.max.getSeconds() < 10 ? "0" + s.max.getSeconds() : s.max.getSeconds()) : "";
		return s.min && s.min.setFullYear(2014, 7, 20), s.max && s.max.setFullYear(2014, 7, 20), {
			placeholder: "-"
			, allowLeadingZero: !0
			, template: (3 == r.length ? "dd:dd:dd" : 2 == r.length ? "dd:dd" : "dd") + (o ? '<span class="mbsc-np-sup">{ampm:--}</span>' : "")
			, leftKey: o ? {
				text: i
				, variable: "ampm:" + i
				, value: "00"
			} : {
				text: ":00"
				, value: "00"
			}
			, rightKey: o ? {
				text: l
				, variable: "ampm:" + l
				, value: "00"
			} : {
				text: ":30"
				, value: "30"
			}
			, parseValue: function (e) {
				var t, a, n = e || s.defaultValue
					, r = [];
				if (n) {
					if (n += "", a = n.match(/\d/g))
						for (t = 0; t < a.length; t++) r.push(+a[t]);
					o && r.push("ampm:" + (n.match(new RegExp(s.pmText, "gi")) ? l : i))
				}
				return r
			}
			, formatValue: function (e, a) {
				return t(e, a)
			}
			, validate: function (n) {
				var r = n.values
					, i = n.variables
					, l = t(r, i)
					, d = r.length >= 3 ? new Date(2014, 7, 20, "" + r[0] + (r.length % 2 == 0 ? r[1] : ""), "" + r[r.length % 2 == 0 ? 2 : 1] + r[r.length % 2 == 0 ? 3 : 2]) : "";
				return {
					disabled: a(r)
					, length: c
					, invalid: (o ? !new RegExp("^(0?[1-9]|1[012])(:[0-5]\\d)?(:[0-5][0-9]) (?:" + s.amText + "|" + s.pmText + ")$", "i")
						.test(l) : !/^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$/.test(l)) || !!s.invalid && -1 != e._indexOf(s.invalid, d) || !((!s.min || s.min <= d) && (!s.max || d <= s.max))
				}
			}
		}
	};
	var Ta = {
		dateOrder: "mdy"
		, dateFormat: "mm/dd/yy"
		, delimiter: "/"
	};
	fa.date = function (e) {
		function t(e) {
			return e % 4 == 0 && e % 100 != 0 || e % 400 == 0
		}

		function a(e) {
			var a, n, i, l, c, m = []
				, g = void 0 !== e[s + 3] ? "" + e[s] + e[s + 1] + e[s + 2] + e[s + 3] : ""
				, x = void 0 !== e[r + 1] ? "" + e[r] + e[r + 1] : ""
				, T = void 0 !== e[o + 1] ? "" + e[o] + e[o + 1] : ""
				, y = "" + d.getMaxDayOfMonth(g || 2012, x - 1 || 0)
				, _ = b === g && +u == +x
				, w = v === g && +h == +x;
			if (d.invalid)
				for (a = 0; a < d.invalid.length; ++a) {
					if (i = d.getYear(d.invalid[a]), l = d.getMonth(d.invalid[a]), c = d.getDay(d.invalid[a]), i == +g && l + 1 == +x && (c < 10 ? 0 : +("" + c)[0]) == +e[o]) {
						m.push(c < 10 ? c : +("" + c)[1]);
						break
					}
					if (l + 1 == +x && c == +T && ("" + i)
						.substring(0, 3) == "" + e[s] + e[s + 1] + e[s + 2]) {
						m.push(("" + i)[3]);
						break
					}
					if (i == +g && c == +T && (l < 10 ? 0 : +("" + (l + 1))[0]) == +e[r]) {
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
			if (e.length == o) {
				for (a = w ? 1 + (+p > 10 ? +p[0] : 0) : +y[0] + 1; a <= 9; ++a) m.push(a);
				if (_)
					for (a = 0; a < (+f < 10 ? 0 : f[0]); ++a) m.push(a)
			}
			if (e.length == o + 1) {
				if (e[o] >= 3 || "02" == x)
					for (a = +y[1] + 1; a <= 9; ++a) m.push(a);
				if (w && +p[0] == e[o])
					for (a = +p[1] + 1; a <= 9; ++a) m.push(a);
				if (_ && f[0] == e[o])
					for (a = 0; a < +f[1]; ++a) m.push(a);
				if (0 === e[o] && (m.push(0), w || _))
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
			return new Date(+("" + e[s] + e[s + 1] + e[s + 2] + e[s + 3]), +("" + e[r] + e[r + 1]) - 1, +("" + e[o] + e[o + 1]))
		}
		var s, r, o, i, l = []
			, c = Ve({}, e.settings)
			, d = Ve(e.settings, Ie, Ta, c)
			, m = d.dateOrder
			, u = d.min ? "" + (d.getMonth(d.min) + 1) : 0
			, h = d.max ? "" + (d.getMonth(d.max) + 1) : 0
			, f = d.min ? "" + d.getDay(d.min) : 0
			, p = d.max ? "" + d.getDay(d.max) : 0
			, b = d.min ? "" + d.getYear(d.min) : 0
			, v = d.max ? "" + d.getYear(d.max) : 0;
		for (m = m.replace(/y+/gi, "yyyy"), m = m.replace(/m+/gi, "mm"), m = m.replace(/d+/gi, "dd"), s = m.toUpperCase()
			.indexOf("Y"), r = m.toUpperCase()
			.indexOf("M"), o = m.toUpperCase()
			.indexOf("D"), m = "", l.push({
				val: s
				, n: "yyyy"
			}, {
				val: r
				, n: "mm"
			}, {
				val: o
				, n: "dd"
			}), l.sort(function (e, t) {
				return e.val - t.val
			}), ke.each(l, function (e, t) {
				m += t.n
			}), s = m.indexOf("y"), r = m.indexOf("m"), o = m.indexOf("d"), m = "", i = 0; i < 8; ++i) m += "d", i + 1 != s && i + 1 != r && i + 1 != o || (m += d.delimiter);
		return e.getVal = function (t) {
			return e._hasValue || t ? n(e.getArrayVal(t)) : null
		}, {
			placeholder: "-"
			, fill: "ltr"
			, allowLeadingZero: !0
			, template: m
			, parseValue: function (e) {
				var t, a = []
					, n = e || d.defaultValue
					, s = x(d.dateFormat, n, d);
				if (n)
					for (t = 0; t < l.length; ++t) a = /m/i.test(l[t].n) ? a.concat(((d.getMonth(s) < 9 ? "0" : "") + (d.getMonth(s) + 1))
						.split("")) : /d/i.test(l[t].n) ? a.concat(((d.getDay(s) < 10 ? "0" : "") + d.getDay(s))
						.split("")) : a.concat((d.getYear(s) + "")
						.split(""));
				return a
			}
			, formatValue: function (e) {
				return g(d.dateFormat, n(e), d)
			}
			, validate: function (t) {
				var s = t.values
					, r = n(s);
				return {
					disabled: a(s)
					, invalid: !("Invalid Date" != r && (!d.min || d.min <= r) && (!d.max || r <= d.max)) || !!d.invalid && -1 != e._indexOf(d.invalid, r)
				}
			}
		}
	};
	var ya = {
		autoCorrect: !0
		, showSelector: !0
		, minRange: 1
		, rangeTap: !0
		, fromText: "Start"
		, toText: "End"
	};
	ie.presetShort("range"), ie.presets.scroller.range = function (e) {
		function t(e, t) {
			e && (e.setFullYear(t.getFullYear()), e.setMonth(t.getMonth()), e.setDate(t.getDate()))
		}

		function a(t) {
			e._startDate = D = v, e._endDate = N = _, F.startInput && (ke(F.startInput)
				.val(p), t && ke(F.startInput)
				.trigger("change")), F.endInput && (ke(F.endInput)
				.val(b), t && ke(F.endInput)
				.trigger("change"))
		}

		function n(e, t) {
			var a = !0;
			return e && v && _ && (_ - v > F.maxRange - 1 && (V ? v = new Date(_ - F.maxRange + 1) : _ = new Date(+v + F.maxRange - 1)), _ - v < F.minRange - 1 && (V ? v = new Date(_ - F.minRange + 1) : _ = new Date(+v + F.minRange - 1))), v && _ || (a = !1), t && i(), a
		}

		function s() {
			return v && _ ? Math.max(1, Math.round((new Date(_)
				.setHours(0, 0, 0, 0) - new Date(v)
				.setHours(0, 0, 0, 0)) / 864e5) + 1) : 0
		}

		function r(e) {
			e.addClass(L)
				.attr("aria-checked", "true")
		}

		function o() {
			k && d && (ke(".mbsc-range-btn", d)
				.removeClass(L)
				.removeAttr("aria-checked"), r(ke(".mbsc-range-btn", d)
					.eq(V)))
		}

		function i() {
			var e, t, a, n, s, r = 0
				, o = P || !V ? " mbsc-cal-day-hl mbsc-cal-sel-start" : " mbsc-cal-sel-start"
				, i = P || V ? " mbsc-cal-day-hl mbsc-cal-sel-end" : " mbsc-cal-sel-end";
			if (p = v ? g(u, v, F) : "", b = _ ? g(u, _, F) : "", d && (ke(".mbsc-range-btn-v-start", d)
					.html(p || "&nbsp;"), ke(".mbsc-range-btn-v-end", d)
					.html(b || "&nbsp;"), e = v ? new Date(v) : null, a = _ ? new Date(_) : null, !e && a && (e = new Date(a)), !a && e && (a = new Date(e)), s = V ? a : e, ke(".mbsc-cal-day-picker .mbsc-cal-day-hl", d)
					.removeClass(E), ke(".mbsc-cal-day-picker .mbsc-selected", d)
					.removeClass("mbsc-cal-sel-start mbsc-cal-sel-end " + L)
					.removeAttr("aria-selected"), e && a))
				for (t = e.setHours(0, 0, 0, 0), n = a.setHours(0, 0, 0, 0); a >= e && r < 84;) ke('.mbsc-cal-day[data-full="' + s.getFullYear() + "-" + (s.getMonth() + 1) + "-" + s.getDate() + '"]', d)
					.addClass(L + " " + (s.getTime() === t ? o : "") + (s.getTime() === n ? i : ""))
					.attr("aria-selected", "true"), s.setDate(s.getDate() + (V ? -1 : 1)), r++
		}

		function l(e, t) {
			return {
				h: e ? e.getHours() : t ? 23 : 0
				, i: e ? e.getMinutes() : t ? 59 : 0
				, s: e ? e.getSeconds() : t ? 59 : 0
			}
		}
		var c, d, m, u, h, f, p, b, v, T, _, w, M, S, C, k, D = e._startDate
			, N = e._endDate
			, V = 0
			, A = new Date
			, I = Ve({}, e.settings)
			, F = Ve(e.settings, ya, I)
			, H = F.anchor
			, P = F.rangeTap
			, O = "mbsc-fr-btn-d " + (F.disabledClass || "")
			, L = "mbsc-selected " + (F.selectedClass || "")
			, E = "mbsc-cal-day-hl"
			, Y = null === F.defaultValue ? [] : F.defaultValue || [new Date(A.setHours(0, 0, 0, 0)), new Date(A.getFullYear(), A.getMonth(), A.getDate() + 6, 23, 59, 59, 999)];
		return P && (F.tabs = !0), c = st.call(this, e), u = e._format, M = "time" === F.controls.join(""), k = 1 != F.controls.length || "calendar" != F.controls[0] || F.showSelector, F.startInput && (S = ke(F.startInput)
			.prop("readonly"), e.attachShow(ke(F.startInput)
				.prop("readonly", !0)
				, function () {
					V = 0, F.anchor = H || ke(F.startInput)
				})), F.endInput && (C = ke(F.endInput)
			.prop("readonly"), e.attachShow(ke(F.endInput)
				.prop("readonly", !0)
				, function () {
					V = 1, F.anchor = H || ke(F.endInput)
				})), e._getDayProps = function (e) {
			var t = v ? new Date(v.getFullYear(), v.getMonth(), v.getDate()) : null
				, a = _ ? new Date(_.getFullYear(), _.getMonth(), _.getDate()) : null;
			return {
				selected: t && a && e >= t && e <= _
				, cssClass: ((P || !V) && t && t.getTime() === e.getTime() || (P || V) && a && a.getTime() === e.getTime() ? E : "") + (t && t.getTime() === e.getTime() ? " mbsc-cal-sel-start" : "") + (a && a.getTime() === e.getTime() ? " mbsc-cal-sel-end" : "")
			}
		}, e.setVal = function (t, a, n, s, r) {
			var o = t || []
				, i = t;
			(void 0 === o[0] || null === o[0] || o[0].getTime) && (f = !0, v = o[0] || null, p = v ? g(u, v, F) : "", V || (i = c.parseValue(p, e))), (void 0 === o[1] || null === o[1] || o[1].getTime) && (f = !0, _ = o[1] || null, b = _ ? g(u, _, F) : "", V && (i = c.parseValue(b, e))), s || (e._startDate = D = v, e._endDate = N = _), e._setVal(i, a, n, s, r)
		}, e.getVal = function (t) {
			return t ? [v, _] : e._hasValue ? [D, N] : null
		}, e.setActiveDate = function (t) {
			var a;
			V = "start" == t ? 0 : 1, a = "start" == t ? v : _, e.isVisible() && (o(), P || (ke(".mbsc-cal-table .mbsc-cal-day-hl", d)
				.removeClass(E), a && ke('.mbsc-cal-day[data-full="' + a.getFullYear() + "-" + (a.getMonth() + 1) + "-" + a.getDate() + '"]', d)
				.addClass(E)), a && (h = !0, e.setDate(a, !1, 1e3, !0)))
		}, e.getValue = e.getVal, Ve({}, c, {
			highlight: !1
			, outerMonthChange: !1
			, formatValue: function () {
				return p + (F.endInput ? "" : b ? " - " + b : "")
			}
			, parseValue: function (t) {
				var a = t ? t.split(" - ") : [];
				return F.defaultValue = Y[1], N = F.endInput ? ke(F.endInput)
					.val() ? x(u, ke(F.endInput)
						.val(), F) : Y[1] : a[1] ? x(u, a[1], F) : Y[1], F.defaultValue = Y[0], D = F.startInput ? ke(F.startInput)
					.val() ? x(u, ke(F.startInput)
						.val(), F) : Y[0] : a[0] ? x(u, a[0], F) : Y[0], F.defaultValue = Y[V], p = D ? g(u, D, F) : "", b = N ? g(u, N, F) : "", e._startDate = D, e._endDate = N, c.parseValue(V ? b : p, e)
			}
			, onFill: function (e) {
				a(e.change)
			}
			, onBeforeClose: function (t) {
				if ("set" === t.button && !n(!0, !0)) return e.setActiveDate(V ? "start" : "end"), !1
			}
			, onHide: function () {
				c.onHide.call(e), V = 0, d = null, F.anchor = H
			}
			, onClear: function () {
				P && (V = 0)
			}
			, onBeforeShow: function () {
				F.headerText = !1, v = D || Y[0], _ = N || Y[1], T = l(v, 0), w = l(_, 1), F.counter && (F.headerText = function () {
					var e = s();
					return (e > 1 ? F.selectedPluralText || F.selectedText : F.selectedText)
						.replace(/{count}/, e)
				}), f = !0
			}
			, onMarkupReady: function (t) {
				var a;
				v && (h = !0, e.setDate(v, !1, 0, !0), v = e.getDate(!0)), _ && (h = !0, e.setDate(_, !1, 0, !0), _ = e.getDate(!0)), (V && _ || !V && v) && (h = !0, e.setDate(V ? _ : v, !1, 0, !0)), i(), c.onMarkupReady.call(this, t), d = ke(t.target), d.addClass("mbsc-range"), k && (a = '<div class="mbsc-range-btn-t" role="radiogroup"><div class="mbsc-range-btn-c mbsc-range-btn-start"><div role="radio" data-select="start" class="mbsc-fr-btn-e mbsc-fr-btn-nhl mbsc-range-btn">' + F.fromText + '<div class="mbsc-range-btn-v mbsc-range-btn-v-start">' + (p || "&nbsp;") + '</div></div></div><div class="mbsc-range-btn-c mbsc-range-btn-end"><div role="radio" data-select="end" class="mbsc-fr-btn-e mbsc-fr-btn-nhl mbsc-range-btn">' + F.toText + '<div class="mbsc-range-btn-v mbsc-range-btn-v-end">' + (b || "&nbsp;") + "</div></div></div></div>", ke(F.headerText ? ".mbsc-fr-hdr" : ".mbsc-fr-aria", d)
						.after(a), o()), ke(".mbsc-range-btn", d)
					.on("touchstart click", function (t) {
						y(t, this) && (e._showDayPicker(), e.setActiveDate(ke(this)
							.attr("data-select")))
					})
			}
			, onDayChange: function (e) {
				e.active = V ? "end" : "start", m = !0
			}
			, onSetDate: function (a) {
				var s = a.date
					, r = e._order;
				h || (void 0 === r.h && s.setHours(V ? 23 : 0), void 0 === r.i && s.setMinutes(V ? 59 : 0), void 0 === r.s && s.setSeconds(V ? 59 : 0), s.setMilliseconds(V ? 999 : 0), f && !m || (P && m && (1 == V && s < v && (V = 0), V ? s.setHours(w.h, w.i, w.s, 999) : s.setHours(T.h, T.i, T.s, 0)), V ? (_ = new Date(s), w = l(_)) : (v = new Date(s), T = l(v)), M && F.autoCorrect && (t(v, s), t(_, s)), P && m && !V && (_ = null))), M && !F.autoCorrect && _ < v && (_ = new Date(_.setDate(_.getDate() + 1))), e._isValid = n(f || m || F.autoCorrect, !h), a.active = V ? "end" : "start", !h && P && (m && (V = V ? 0 : 1), o()), e.isVisible() && (e._isValid ? ke(".mbsc-fr-btn-s .mbsc-fr-btn", e._markup)
					.removeClass(O) : ke(".mbsc-fr-btn-s .mbsc-fr-btn", e._markup)
					.addClass(O)), m = !1, f = !1, h = !1
			}
			, onTabChange: function (t) {
				"calendar" != t.tab && e.setDate(V ? _ : v, !1, 1e3, !0), n(!0, !0)
			}
			, onDestroy: function () {
				ke(F.startInput)
					.prop("readonly", S), ke(F.endInput)
					.prop("readonly", C)
			}
		})
	};
	var _a = 0;
	ie.util.getJson = ne;
	var wa = {
		inputClass: ""
		, invalid: []
		, rtl: !1
		, showInput: !0
		, groupLabel: "Groups"
		, dataHtml: "html"
		, dataText: "text"
		, dataValue: "value"
		, dataGroup: "group"
		, dataDisabled: "disabled"
		, filterPlaceholderText: "Type to filter"
		, filterEmptyText: "No results"
		, filterClearIcon: "material-close"
	};
	ie.presetShort("select"), ie.presets.scroller.select = function (e) {
		function t(e) {
			var t, a, n, s, r, o, i = 0
				, l = 0
				, c = {};
			if (Y = {}, C = {}, V = [], S = [], ee.length = 0, U) ke.each(T, function (i, d) {
				r = d[O.dataText], a = d[O.dataHtml], o = d[O.dataValue], n = d[O.dataGroup], s = {
					value: o
					, html: a
					, text: r
					, index: i
				}, Y[o] = s, e && !b(r, e) || (V.push(s), B && (void 0 === c[n] ? (t = {
					text: n
					, value: l
					, options: []
					, index: l
				}, C[l] = t, c[n] = l, S.push(t), l++) : t = C[c[n]], X && (s.index = t.options.length), s.group = c[n], t.options.push(s)), d[O.dataDisabled] && ee.push(o))
			});
			else if (B) {
				var d = !0;
				ke("optgroup", H)
					.each(function (t) {
						C[t] = {
								text: this.label
								, value: t
								, options: []
								, index: t
							}, d = !0, ke("option", this)
							.each(function (a) {
								s = {
									value: this.value
									, text: this.text
									, index: X ? a : i++
									, group: t
								}, Y[this.value] = s, e && !b(this.text, e) || (d && (S.push(C[t]), d = !1), V.push(s), C[t].options.push(s), this.disabled && ee.push(this.value))
							})
					})
			} else ke("option", H)
				.each(function (t) {
					s = {
						value: this.value
						, text: this.text
						, index: t
					}, Y[this.value] = s, e && !b(this.text, e) || (V.push(s), this.disabled && ee.push(this.value))
				});
			O.defaultValue ? y = O.defaultValue : V.length && (y = V[0].value), Z && (V = [], i = 0, ke.each(C, function (e, t) {
				t.options.length && (o = "__group" + e, s = {
					text: t.text
					, value: o
					, group: e
					, index: i++
					, cssClass: "mbsc-sel-gr"
				}, Y[o] = s, V.push(s), ee.push(s.value), ke.each(t.options, function (e, t) {
					t.index = i++, V.push(t)
				}))
			})), L && (V.length ? L.removeClass("mbsc-sel-empty-v") : L.addClass("mbsc-sel-empty-v"))
		}

		function i(e, t, a) {
			var n, s = [];
			for (n = 0; n < e.length; n++) s.push({
				value: e[n].value
				, display: e[n].html || e[n].text
				, cssClass: e[n].cssClass
			});
			return {
				circular: !1
				, multiple: t
				, data: s
				, label: a
			}
		}

		function l() {
			return i(S, !1, O.groupLabel)
		}

		function c() {
			return i(X ? C[M].options : V, $, K)
		}

		function d() {
			var e, t, a = [[]];
			return G && (e = l(), j ? a[0][k] = e : a[k] = [e]), t = c(), j ? a[0][A] = t : a[A] = [t], a
		}

		function m(e) {
			W && (e && o(e) && (e = e.split(",")), ke.isArray(e) && (e = e[0])), N = void 0 === e || null === e || "" === e ? y : e, G && (M = Y[N] ? Y[N].group : null)
		}

		function u(e) {
			return F[e] || (Y[e] ? Y[e].text : "")
		}

		function h(t) {
			var a, n, s = [];
			if ($) {
				for (a in e._tempSelected[A]) s.push(u(a));
				return s.join(", ")
			}
			return n = t[A], u(n)
		}

		function f() {
			var t, a = ""
				, n = e.getVal()
				, s = h(e.getArrayVal());
			if (O.filter && "inline" == O.display || x.val(s), H.is("select") && U) {
				if (W)
					for (t = 0; t < n.length; t++) a += '<option value="' + n[t] + '">' + u(n[t]) + "</option>";
				else a = '<option value="' + n + '">' + s + "</option>";
				H.html(a)
			}
			H[0] !== x[0] && H.val(n)
		}

		function p() {
			var t = {};
			t[A] = c(), I = !0, e.changeWheel(t)
		}

		function b(e, t) {
			return t = t.replace(/[-\/\\^$*+?.()|[\]{}]/g, "\\$&"), e.match(new RegExp(t, "ig"))
		}

		function v(e) {
			return O.data.dataField ? e[O.data.dataField] : O.data.processResponse ? O.data.processResponse(e) : e
		}

		function g(a) {
			var n = {};
			t(a), O.wheels = d(), m(N), n[A] = c(), e._tempWheelArray[A] = N, G && (n[k] = l(), e._tempWheelArray[k] = M), e._isVisible && e.changeWheel(n, 0, !0)
		}
		var x, T, y, _, w, M, S, C, k, D, N, V, A, I, F = {}
			, H = ke(this)
			, P = Ve({}, e.settings)
			, O = Ve(e.settings, wa, P)
			, L = ke('<div class="mbsc-sel-empty">' + O.filterEmptyText + "</div>")
			, E = O.readonly
			, Y = {}
			, z = O.layout || (/top|bottom|inline/.test(O.display) || O.filter ? "liquid" : "")
			, j = "liquid" == z
			, W = r(O.select) ? O.select : "multiple" == O.select || H.prop("multiple")
			, $ = W || !!O.filter && 1
			, R = this.id + "_dummy"
			, J = ke('label[for="' + this.id + '"]')
			.attr("for", R)
			, K = void 0 !== O.label ? O.label : J.length ? J.text() : H.attr("name")
			, U = !!O.data
			, B = U ? !!O.group : ke("optgroup", H)
			.length
			, q = O.group
			, G = B && q && !1 !== q.groupWheel
			, X = B && q && G && !0 === q.clustered
			, Z = B && (!q || !1 !== q.header && !X)
			, Q = H.val() || (W ? [] : [""])
			, ee = [];
		return e.setVal = function (t, a, n, r, i) {
				$ && (t && !W && (t = [t]), t && o(t) && (t = t.split(",")), e._tempSelected[A] = s(t), r || (e._selected[A] = s(t)), t = t ? t[0] : null), e._setVal(t, a, n, r, i)
			}, e.getVal = function (t, a) {
				var s;
				return $ ? (s = n(t ? e._tempSelected[A] : e._selected[A]), s = W ? s : s.length ? s[0] : null) : (s = t ? e._tempWheelArray : e._hasValue ? e._wheelArray : null, s = s ? s[A] : null), W ? s : s ? B && a ? [Y[s] ? Y[s].group : null, s] : s : null
			}, e.refresh = function (e, t, n) {
				n = n || a, e ? T = e : ke.isArray(O.data) && (T = O.data), !e && D && void 0 === t ? ne(O.data.url, function (e) {
					T = v(e), g(), n()
				}, O.data.dataType) : (g(t), n())
			}, O.invalid.length || (O.invalid = ee), G ? (k = 0, A = 1) : (k = -1, A = 0), $ && (W && H.prop("multiple", !0), Q && o(Q) && (Q = Q.split(",")), e._selected[A] = s(Q)), e._$input && e._$input.remove(), H.next()
			.is("input.mbsc-control") ? x = H.next()
			.removeAttr("tabindex") : O.input ? x = ke(O.input) : (O.filter && "inline" == O.display ? e._$input = ke('<div class="mbsc-sel-input-wrap"><input type="text" id="' + R + '" class="mbsc-control ' + O.inputClass + '" readonly /></div>') : (x = ke('<input type="text" id="' + R + '" class="mbsc-control ' + O.inputClass + '" readonly />'), e._$input = x), O.showInput && (e._$input.insertBefore(H), x || (x = e._$input.find("#" + R)))), e.attachShow(x.attr("placeholder", O.placeholder || "")), x[0] !== H[0] && H.addClass("mbsc-sel-hdn")
			.attr("tabindex", -1), O.filter && (_ = O.filter.minLength || 0), D = O.data && O.data.url, D ? e.refresh(void 0, void 0, f) : (U && (T = O.data), t(), m(H.val())), {
				layout: z
				, headerText: !1
				, anchor: x
				, compClass: "mbsc-sel" + (G ? " mbsc-sel-gr-whl" : "") + ($ ? " mbsc-sel-multi" : "")
				, setOnTap: !G || [!1, !0]
				, formatValue: h
				, parseValue: function (e) {
					return m(void 0 === e ? H.val() : e), G ? [M, N] : [N]
				}
				, validate: function (e) {
					var t = e.index
						, a = [];
					return a[A] = O.invalid, X && !I && void 0 === t && p(), I = !1, {
						disabled: a
					}
				}
				, onRead: f
				, onFill: f
				, onMarkupReady: function (e, t) {
					if (O.filter) {
						var a, n, s, r = ke(".mbsc-fr-w", e.target)
							, o = ke('<span class="mbsc-sel-filter-clear mbsc-ic mbsc-ic-' + O.filterClearIcon + '"></span>');
						"inline" == O.display ? (a = x, x.parent()
								.find(".mbsc-sel-filter-clear")
								.remove()) : (r.prepend('<div class="mbsc-input mbsc-sel-filter-cont mbsc-control-w"><span class="mbsc-input-wrap"><input type="text" class="mbsc-sel-filter-input mbsc-control"/></span></div>'), a = r.find(".mbsc-sel-filter-input")), w = null, s = a[0], a.prop("readonly", !1)
							.attr("placeholder", O.filterPlaceholderText)
							.parent()
							.append(o), r.find(".mbsc-fr-c")
							.prepend(L), t.tap(o, function () {
								s.value = "", t.refresh(), o.removeClass("mbsc-sel-filter-show-clear")
							}), a.on("keydown", function (e) {
								13 != e.keyCode && 27 != e.keyCode || (e.stopPropagation(), s.blur())
							})
							.on("keyup", function () {
								clearTimeout(n), s.value.length ? o.addClass("mbsc-sel-filter-show-clear") : o.removeClass("mbsc-sel-filter-show-clear"), n = setTimeout(function () {
									w !== s.value && !1 !== t.trigger("onFilter", {
										filterText: s.value
									}) && (w = s.value, (w.length >= _ || !w.length) && (D && O.data.remoteFilter ? ne(O.data.url + encodeURIComponent(w), function (e) {
										t.refresh(v(e))
									}, O.data.dataType) : t.refresh(void 0, w)))
								}, 500)
							})
					}
				}
				, onBeforeShow: function () {
					W && O.counter && (O.headerText = function () {
						var t = 0;
						return ke.each(e._tempSelected[A], function () {
								t++
							}), (t > 1 ? O.selectedPluralText || O.selectedText : O.selectedText)
							.replace(/{count}/, t)
					}), m(H.val()), O.filter && t(void 0), e.settings.wheels = d(), I = !0
				}
				, onWheelGestureStart: function (e) {
					e.index == k && (O.readonly = [!1, !0])
				}
				, onWheelAnimationEnd: function (t) {
					var a = e.getArrayVal(!0);
					t.index == k ? (O.readonly = E, a[k] != M && (M = a[k], N = C[M].options[0].value, a[A] = N, X ? p() : e.setArrayVal(a, !1, !1, !0, 1e3))) : t.index == A && a[A] != N && (N = a[A], G && Y[N] && Y[N].group != M && (M = Y[N].group, a[k] = M, e.setArrayVal(a, !1, !1, !0, 1e3)))
				}
				, onItemTap: function (e) {
					if (e.index == A && (F[e.value] = Y[e.value].text, $ && !W && e.selected)) return !1
				}
				, onClose: function () {
					D && O.data.remoteFilter && w && e.refresh()
				}
				, onDestroy: function () {
					e._$input && e._$input.remove(), H.removeClass("mbsc-sel-hdn")
						.removeAttr("tabindex")
				}
			}
	};
	var Ma = {
		autostart: !1
		, step: 1
		, useShortLabels: !1
		, labels: ["Years", "Months", "Days", "Hours", "Minutes", "Seconds", ""]
		, labelsShort: ["Yrs", "Mths", "Days", "Hrs", "Mins", "Secs", ""]
		, startText: "Start"
		, stopText: "Stop"
		, resetText: "Reset"
		, lapText: "Lap"
		, hideText: "Hide"
	};
	ie.presetShort("timer"), ie.presets.scroller.timer = function (e) {
		function t(e) {
			return new Date(e.getUTCFullYear(), e.getUTCMonth(), e.getUTCDate(), e.getUTCHours(), e.getUTCMinutes(), e.getUTCSeconds(), e.getUTCMilliseconds())
		}

		function a(e) {
			var a = {};
			if (P && M[I].index > M.days.index) {
				var n, s, r, o, i = new Date
					, l = b ? i : H
					, c = b ? H : i;
				for (c = t(c), l = t(l), a.years = l.getFullYear() - c.getFullYear(), a.months = l.getMonth() - c.getMonth(), a.days = l.getDate() - c.getDate(), a.hours = l.getHours() - c.getHours(), a.minutes = l.getMinutes() - c.getMinutes(), a.seconds = l.getSeconds() - c.getSeconds(), a.fract = (l.getMilliseconds() - c.getMilliseconds()) / 10, n = w.length; n > 0; n--) s = w[n - 1], r = M[s], o = w[ke.inArray(s, w) - 1], M[o] && a[s] < 0 && (a[o]--, a[s] += "months" == o ? 32 - new Date(l.getFullYear(), l.getMonth(), 32)
					.getDate() : r.until + 1);
				"months" == I && (a.months += 12 * a.years, delete a.years)
			} else ke(w)
				.each(function (t, n) {
					M[n].index <= M[I].index && (a[n] = Math.floor(e / M[n].limit), e -= a[n] * M[n].limit)
				});
			return a
		}

		function n(e) {
			var t = 1
				, a = M[e]
				, n = a.wheel
				, r = a.prefix
				, o = a.until
				, i = M[w[ke.inArray(e, w) - 1]];
			if (a.index <= M[I].index && (!i || i.limit > A))
				if (S[e] || O[0].push(n), S[e] = 1, n.data = [], n.label = a.label || "", n.cssClass = "mbsc-timer-whl-" + e, A >= a.limit && (t = Math.max(Math.round(A / a.limit), 1), d = t * a.limit), e == I) n.min = 0, n.data = function (e) {
					return {
						value: e
						, display: s(e, r, a.label)
					}
				}, n.getIndex = function (e) {
					return e
				};
				else
					for (l = 0; l <= o; l += t) n.data.push({
						value: l
						, display: s(l, r, a.label)
					})
		}

		function s(e, t, a) {
			return (t || "") + (e < 10 ? "0" : "") + e + '<span class="mbsc-timer-lbl">' + a + "</span>"
		}

		function r(e) {
			var t, n = []
				, s = a(e);
			return ke(w)
				.each(function (e, a) {
					S[a] && (t = Math.max(Math.round(A / M[a].limit), 1), n.push(Math.round(s[a] / t) * t))
				}), n
		}

		function o(e) {
			P ? (f = H - new Date, f < 0 ? (f *= -1, b = !0) : b = !1, p = 0, V = !0) : void 0 !== H ? (V = !1, f = 1e3 * H, b = "countdown" != T.mode, e && (p = 0)) : (f = 0, b = "countdown" != T.mode, V = b, e && (p = 0))
		}

		function i() {
			D ? (ke(".mbsc-fr-w", v)
				.addClass("mbsc-timer-running mbsc-timer-locked"), ke(".mbsc-timer-btn-toggle-c > div", v)
				.text(T.stopText), e.buttons.start.icon && ke(".mbsc-timer-btn-toggle-c > div", v)
				.removeClass("mbsc-ic-" + e.buttons.start.icon), e.buttons.stop.icon && ke(".mbsc-timer-btn-toggle-c > div", v)
				.addClass("mbsc-ic-" + e.buttons.stop.icon), "stopwatch" == T.mode && (ke(".mbsc-timer-btn-resetlap-c > div", v)
					.text(T.lapText), e.buttons.reset.icon && ke(".mbsc-timer-btn-resetlap-c > div", v)
					.removeClass("mbsc-ic-" + e.buttons.reset.icon), e.buttons.lap.icon && ke(".mbsc-timer-btn-resetlap-c > div", v)
					.addClass("mbsc-ic-" + e.buttons.lap.icon))) : (ke(".mbsc-fr-w", v)
				.removeClass("mbsc-timer-running"), ke(".mbsc-timer-btn-toggle-c > div", v)
				.text(T.startText), e.buttons.start.icon && ke(".mbsc-timer-btn-toggle-c > div", v)
				.addClass("mbsc-ic-" + e.buttons.start.icon), e.buttons.stop.icon && ke(".mbsc-timer-btn-toggle-c > div", v)
				.removeClass("mbsc-ic-" + e.buttons.stop.icon), "stopwatch" == T.mode && (ke(".mbsc-timer-btn-resetlap-c > div", v)
					.text(T.resetText), e.buttons.reset.icon && ke(".mbsc-timer-btn-resetlap-c > div", v)
					.addClass("mbsc-ic-" + e.buttons.reset.icon), e.buttons.lap.icon && ke(".mbsc-timer-btn-resetlap-c > div", v)
					.removeClass("mbsc-ic-" + e.buttons.lap.icon)))
		}
		var l, c, d, m, u, h, f, p, b, v, g, x = Ve({}, e.settings)
			, T = Ve(e.settings, Ma, x)
			, y = T.useShortLabels ? T.labelsShort : T.labels
			, _ = ["resetlap", "toggle"]
			, w = ["years", "months", "days", "hours", "minutes", "seconds", "fract"]
			, M = {
				years: {
					index: 6
					, until: 10
					, limit: 31536e6
					, label: y[0]
					, wheel: {}
				}
				, months: {
					index: 5
					, until: 11
					, limit: 2592e6
					, label: y[1]
					, wheel: {}
				}
				, days: {
					index: 4
					, until: 31
					, limit: 864e5
					, label: y[2]
					, wheel: {}
				}
				, hours: {
					index: 3
					, until: 23
					, limit: 36e5
					, label: y[3]
					, wheel: {}
				}
				, minutes: {
					index: 2
					, until: 59
					, limit: 6e4
					, label: y[4]
					, wheel: {}
				}
				, seconds: {
					index: 1
					, until: 59
					, limit: 1e3
					, label: y[5]
					, wheel: {}
				}
				, fract: {
					index: 0
					, until: 99
					, limit: 10
					, label: y[6]
					, prefix: "."
					, wheel: {}
				}
			}
			, S = {}
			, C = []
			, k = 0
			, D = !1
			, N = !0
			, V = !1
			, A = Math.max(10, 1e3 * T.step)
			, I = T.maxWheel
			, F = "stopwatch" == T.mode || P
			, H = T.targetTime
			, P = H && void 0 !== H.getTime
			, O = [[]];
		return e.start = function () {
				if (N && e.reset(), !D) {
					if (o(), !V && p >= f) return;
					D = !0, N = !1, u = new Date, m = p, T.readonly = !0, e.setVal(r(b ? p : f - p), !0, !0, !1, 100), c = setInterval(function () {
						p = new Date - u + m, e.setVal(r(b ? p : f - p), !0, !0, !1, Math.min(100, d - 10)), !V && p + d >= f && (clearInterval(c), setTimeout(function () {
							e.stop(), p = f, e.setVal(r(b ? p : 0), !0, !0, !1, 100), e.trigger("onFinish", {
								time: f
							}), N = !0
						}, f - p))
					}, d), i(), e.trigger("onStart")
				}
			}, e.stop = function () {
				D && (D = !1, clearInterval(c), p = new Date - u + m, i(), e.trigger("onStop", {
					ellapsed: p
				}))
			}, e.toggle = function () {
				D ? e.stop() : e.start()
			}, e.reset = function () {
				e.stop(), p = 0, C = [], k = 0, e.setVal(r(b ? 0 : f), !0, !0, !1, 100), e.settings.readonly = F, N = !0, F || ke(".mbsc-fr-w", v)
					.removeClass("mbsc-timer-locked"), e.trigger("onReset")
			}, e.lap = function () {
				D && (h = new Date - u + m, g = h - k, k = h, C.push(h), e.trigger("onLap", {
					ellapsed: h
					, lap: g
					, laps: C
				}))
			}, e.resetlap = function () {
				D && "stopwatch" == T.mode ? e.lap() : e.reset()
			}, e.getTime = function () {
				return f
			}, e.setTime = function (e) {
				H = e / 1e3, f = e
			}, e.getEllapsedTime = function () {
				return D ? new Date - u + m : 0
			}, e.setEllapsedTime = function (t, a) {
				N || (m = p = t, u = new Date, e.setVal(r(b ? p : f - p), !0, a, !1, 100))
			}, o(!0), I || f || (I = "minutes"), "inline" !== T.display && _.unshift("hide"), I || ke(w)
			.each(function (e, t) {
				if (!I && f >= M[t].limit) return I = t, !1
			}), ke(w)
			.each(function (e, t) {
				n(t)
			}), d = Math.max(87, d), T.autostart && setTimeout(function () {
				e.start()
			}, 0), e.handlers.toggle = e.toggle, e.handlers.start = e.start, e.handlers.stop = e.stop, e.handlers.resetlap = e.resetlap, e.handlers.reset = e.reset, e.handlers.lap = e.lap, e.buttons.toggle = {
				parentClass: "mbsc-timer-btn-toggle-c"
				, text: T.startText
				, icon: T.startIcon
				, handler: "toggle"
			}, e.buttons.start = {
				text: T.startText
				, icon: T.startIcon
				, handler: "start"
			}, e.buttons.stop = {
				text: T.stopText
				, icon: T.stopIcon
				, handler: "stop"
			}, e.buttons.reset = {
				text: T.resetText
				, icon: T.resetIcon
				, handler: "reset"
			}, e.buttons.lap = {
				text: T.lapText
				, icon: T.lapIcon
				, handler: "lap"
			}, e.buttons.resetlap = {
				parentClass: "mbsc-timer-btn-resetlap-c"
				, text: T.resetText
				, icon: T.resetIcon
				, handler: "resetlap"
			}, e.buttons.hide = {
				parentClass: "mbsc-timer-btn-hide-c"
				, text: T.hideText
				, icon: T.closeIcon
				, handler: "cancel"
			}, {
				wheels: O
				, headerText: !1
				, readonly: F
				, buttons: _
				, mode: "countdown"
				, compClass: "mbsc-timer"
				, parseValue: function () {
					return r(b ? 0 : f)
				}
				, formatValue: function (e) {
					var t = ""
						, a = 0;
					return ke(w)
						.each(function (n, s) {
							"fract" != s && S[s] && (t += e[a] + ("seconds" == s && S.fract ? "." + e[a + 1] : "") + " " + y[n] + " ", a++)
						}), t
				}
				, validate: function (e) {
					var t = e.values
						, a = e.index
						, n = 0;
					N && void 0 !== a && (H = 0, ke(w)
						.each(function (e, a) {
							S[a] && (H += M[a].limit * t[n], n++)
						}), H /= 1e3, o(!0))
				}
				, onBeforeShow: function () {
					T.showLabel = !0
				}
				, onMarkupReady: function (e) {
					v = ke(e.target), i(), F && ke(".mbsc-fr-w", v)
						.addClass("mbsc-timer-locked")
				}
				, onPosition: function (e) {
					ke(".mbsc-fr-w", e.target)
						.css("min-width", 0)
						.css("min-width", ke(".mbsc-fr-btn-cont", e.target)[0].offsetWidth)
				}
				, onDestroy: function () {
					clearInterval(c)
				}
			}
	};
	var Sa = {
		wheelOrder: "hhiiss"
		, useShortLabels: !1
		, min: 0
		, max: 1 / 0
		, labels: ["Years", "Months", "Days", "Hours", "Minutes", "Seconds"]
		, labelsShort: ["Yrs", "Mths", "Days", "Hrs", "Mins", "Secs"]
	};
	ie.presetShort("timespan"), ie.presets.scroller.timespan = function (e) {
		function t(e) {
			var t = {};
			return ke(b)
				.each(function (a, n) {
					t[n] = T[n] ? Math.floor(e / v[n].limit) : 0, e -= t[n] * v[n].limit
				}), t
		}

		function a(e) {
			var t = !1
				, a = x[T[e] - 1] || 1
				, s = v[e]
				, r = s.label
				, o = s.wheel;
			if (o.data = [], o.label = s.label, f.match(new RegExp(s.re + s.re, "i")) && (t = !0), e == y) o.min = d[e], o.max = m[e], o.data = function (e) {
				return {
					value: e * a
					, display: n(e * a, t, r)
				}
			}, o.getIndex = function (e) {
				return Math.round(e / a)
			};
			else
				for (i = 0; i <= s.until; i += a) o.data.push({
					value: i
					, display: n(i, t, r)
				})
		}

		function n(e, t, a) {
			return (e < 10 && t ? "0" : "") + e + '<span class="mbsc-ts-lbl">' + a + "</span>"
		}

		function s(e) {
			var t = 0;
			return ke.each(g, function (a, n) {
				isNaN(+e[0]) || (t += v[n.v].limit * e[a])
			}), t
		}

		function o(e, t) {
			return Math.floor(e / t) * t
		}
		var i, l, c, d, m, u = Ve({}, e.settings)
			, h = Ve(e.settings, Sa, u)
			, f = h.wheelOrder
			, p = h.useShortLabels ? h.labelsShort : h.labels
			, b = ["years", "months", "days", "hours", "minutes", "seconds"]
			, v = {
				years: {
					ord: 0
					, index: 6
					, until: 10
					, limit: 31536e6
					, label: p[0]
					, re: "y"
					, wheel: {}
				}
				, months: {
					ord: 1
					, index: 5
					, until: 11
					, limit: 2592e6
					, label: p[1]
					, re: "m"
					, wheel: {}
				}
				, days: {
					ord: 2
					, index: 4
					, until: 31
					, limit: 864e5
					, label: p[2]
					, re: "d"
					, wheel: {}
				}
				, hours: {
					ord: 3
					, index: 3
					, until: 23
					, limit: 36e5
					, label: p[3]
					, re: "h"
					, wheel: {}
				}
				, minutes: {
					ord: 4
					, index: 2
					, until: 59
					, limit: 6e4
					, label: p[4]
					, re: "i"
					, wheel: {}
				}
				, seconds: {
					ord: 5
					, index: 1
					, until: 59
					, limit: 1e3
					, label: p[5]
					, re: "s"
					, wheel: {}
				}
			}
			, g = []
			, x = h.steps || []
			, T = {}
			, y = "seconds"
			, _ = h.defaultValue || Math.max(h.min, Math.min(0, h.max))
			, w = [[]];
		return ke(b)
			.each(function (e, t) {
				(l = f.search(new RegExp(v[t].re, "i"))) > -1 && (g.push({
					o: l
					, v: t
				}), v[t].index > v[y].index && (y = t))
			}), g.sort(function (e, t) {
				return e.o > t.o ? 1 : -1
			}), ke.each(g, function (e, t) {
				T[t.v] = e + 1, w[0].push(v[t.v].wheel)
			}), d = t(h.min), m = t(h.max), ke.each(g, function (e, t) {
				a(t.v)
			}), e.getVal = function (t, a) {
				return a ? e._getVal(t) : e._hasValue || t ? s(e.getArrayVal(t)) : null
			}, {
				showLabel: !0
				, wheels: w
				, compClass: "mbsc-ts"
				, parseValue: function (e) {
					var a, n = [];
					return r(e) || !e ? (c = t(e || _), ke.each(g, function (e, t) {
							n.push(c[t.v])
						})) : ke.each(g, function (t, s) {
							a = new RegExp("(\\d+)\\s?(" + h.labels[v[s.v].ord] + "|" + h.labelsShort[v[s.v].ord] + ")", "gi")
								.exec(e), n.push(a ? a[1] : 0)
						}), ke(n)
						.each(function (e, t) {
							n[e] = o(t, x[e] || 1)
						}), n
				}
				, formatValue: function (e) {
					var t = "";
					return ke.each(g, function (a, n) {
						t += +e[a] ? e[a] + " " + v[n.v].label + " " : ""
					}), t ? t.replace(/\s+$/g, "") : 0
				}
				, validate: function (a) {
					var n, r, o, i, l = a.values
						, c = a.direction
						, u = []
						, h = !0
						, f = !0;
					return ke(b)
						.each(function (a, p) {
							if (void 0 !== T[p]) {
								if (o = T[p] - 1, u[o] = [], i = {}, p != y) {
									if (h)
										for (r = m[p] + 1; r <= v[p].until; r++) i[r] = !0;
									if (f)
										for (r = 0; r < d[p]; r++) i[r] = !0
								}
								l[o] = e.getValidValue(o, l[o], c, i), n = t(s(l)), h = h && n[p] == m[p], f = f && n[p] == d[p], ke.each(i, function (e) {
									u[o].push(e)
								})
							}
						}), {
							disabled: u
						}
				}
			}
	}, ie.presets.scroller.treelist = ie.presets.scroller.list, ie.presetShort("list"), ie.presetShort("treelist"),  ie.i18n["en-GB"] = ie.i18n["en-UK"] = {
		dateFormat: "dd/mm/yy"
		, timeFormat: "HH:ii"
	}, ie.i18n.zh = {
		setText: "确定"
		, cancelText: "取消"
		, clearText: "明确"
		, selectedText: "{count} 选"
		, dateFormat: "yy/mm/dd"
		, dayNames: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"]
		, dayNamesShort: ["日", "一", "二", "三", "四", "五", "六"]
		, dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"]
		, dayText: "日"
		, hourText: "时"
		, minuteText: "分"
		, monthNames: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"]
		, monthNamesShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"]
		, monthText: "月"
		, secText: "秒"
		, timeFormat: "HH:ii"
		, yearText: "年"
		, nowText: "当前"
		, pmText: "下午"
		, amText: "上午"
		, todayText: "今天"
		, dateText: "日"
		, timeText: "时间"
		, calendarText: "日历"
		, closeText: "关闭"
		, fromText: "开始时间"
		, toText: "结束时间"
		, wholeText: "合计"
		, fractionText: "分数"
		, unitText: "单位"
		, labels: ["年", "月", "日", "小时", "分钟", "秒", ""]
		, labelsShort: ["年", "月", "日", "点", "分", "秒", ""]
		, startText: "开始"
		, stopText: "停止"
		, resetText: "重置"
		, lapText: "圈"
		, hideText: "隐藏"
		, backText: "返回"
		, undoText: "复原"
		, offText: "关闭"
		, onText: "开启"
		, decimalSeparator: ","
		, thousandsSeparator: " "
	};
	var ka = ie.themes;
	ka.frame.bootstrap = {
		disabledClass: "disabled"
		, selectedClass: "btn-primary"
		, selectedTabClass: "active"
		, tabLink: !0
		, todayClass: "text-primary"
		, onMarkupInserted: function (e) {
			var t = ke(e.target);
			ke(".mbsc-fr-popup", t)
				.addClass("popover"), ke(".mbsc-fr-w", t)
				.addClass("popover-content"), ke(".mbsc-fr-hdr", t)

				.addClass("popover-title popover-header"), ke(".mbsc-fr-arr-i", t)
				.addClass("popover"), ke(".mbsc-fr-arr", t)
				.addClass("arrow"), ke(".mbsc-fr-btn", t)
				.addClass("btn btn-default btn-secondary"), ke(".mbsc-fr-btn-s .mbsc-fr-btn", t)
				.removeClass("btn-default btn-secondary")
				.addClass("btn btn-primary"), ke(".mbsc-sc-btn-plus", t)
				.addClass("glyphicon glyphicon-chevron-down"), ke(".mbsc-sc-btn-minus", t)
				.addClass("glyphicon glyphicon-chevron-up"), ke(".mbsc-cal-next", t)
				.prepend('<i class="glyphicon glyphicon-chevron-right"></i>'), ke(".mbsc-cal-prev", t)
				.prepend('<i class="glyphicon glyphicon-chevron-left"></i>'), ke(".mbsc-cal-tabs", t)
				.addClass("nav nav-tabs"), ke(".mbsc-cal-picker", t)
				.addClass("popover"), ke(".mbsc-cal-events", t)
				.addClass("popover"), ke(".mbsc-cal-events-arr", t)
				.addClass("arrow"), ke(".mbsc-range-btn", t)
				.addClass("btn btn-sm btn-small btn-default"), ke(".mbsc-np-btn", t)
				.addClass("btn btn-default"), ke(".mbsc-sel-filter-cont", t)
				.removeClass("mbsc-input"), ke(".mbsc-sel-filter-input", t)
				.addClass("form-control")
		}
		, onPosition: function (e) {
			setTimeout(function () {
				ke(".mbsc-fr-bubble-top, .mbsc-fr-bubble-top .mbsc-fr-arr-i", e.target)
					.removeClass("bottom")
					.addClass("top"), ke(".mbsc-fr-bubble-bottom, .mbsc-fr-bubble-bottom .mbsc-fr-arr-i", e.target)
					.removeClass("top")
					.addClass("bottom")
			}, 10)
		}
	}, ka.scroller.bootstrap = Ve({}, ka.frame.bootstrap, {
		dateDisplay: "Mddyy"
		, btnCalPrevClass: ""
		, btnCalNextClass: ""
		, selectedLineHeight: !0
		, onEventBubbleShow: function (e) {
			var t = ke(e.eventList);
			ke(".mbsc-cal-event-list", t)
				.addClass("list-group"), ke(".mbsc-cal-event", t)
				.addClass("list-group-item"), setTimeout(function () {
					t.hasClass("mbsc-cal-events-b") ? t.removeClass("top")
						.addClass("bottom") : t.removeClass("bottom")
						.addClass("top")
				}, 10)
		}
	}), ka.navigation.bootstrap = {
		wrapperClass: "popover panel panel-default"
		, groupClass: "btn-group"
		, activeClass: "btn-primary"
		, disabledClass: "disabled"
		, itemClass: "btn btn-default"
	};
	var Da = ie.themes;
	Da.frame.ios = {
		display: "bottom"
		, headerText: !1
		, btnWidth: !1
		, deleteIcon: "ios-backspace"
		, scroll3d: !0
	}, Da.scroller.ios = Ve({}, Da.frame.ios, {
		rows: 5
		, height: 34
		, minWidth: 55
		, selectedLineHeight: !0
		, selectedLineBorder: 1
		, showLabel: !1
		, useShortLabels: !0
		, btnPlusClass: "mbsc-ic mbsc-ic-arrow-down5"
		, btnMinusClass: "mbsc-ic mbsc-ic-arrow-up5"
		, checkIcon: "ion-ios7-checkmark-empty"
		, filterClearIcon: "ion-close-circled"
		, dateDisplay: "MMdyy"
		, btnCalPrevClass: "mbsc-ic mbsc-ic-arrow-left5"
		, btnCalNextClass: "mbsc-ic mbsc-ic-arrow-right5"
	}), Da.listview.ios = {
		leftArrowClass: "mbsc-ic-ion-ios7-arrow-back"
		, rightArrowClass: "mbsc-ic-ion-ios7-arrow-forward"
	}, Da.form.ios = {};
	var Na, Va, Aa = ie.themes;
	Aa.frame.material = {
		headerText: !1
		, btnWidth: !1
		, deleteIcon: "material-backspace"
		, onMarkupReady: function (e) {
			oe(ke(e.target), ".mbsc-fr-btn-e", "mbsc-fr-btn-d", "mbsc-fr-btn-nhl")
		}
	}, Aa.scroller.material = Ve({}, Aa.frame.material, {
		showLabel: !1
		, selectedLineBorder: 2
		, weekDays: "min"
		, icon: {
			filled: "material-star"
			, empty: "material-star-outline"
		}
		, checkIcon: "material-check"
		, btnPlusClass: "mbsc-ic mbsc-ic-material-keyboard-arrow-down"
		, btnMinusClass: "mbsc-ic mbsc-ic-material-keyboard-arrow-up"
		, btnCalPrevClass: "mbsc-ic mbsc-ic-material-keyboard-arrow-left"
		, btnCalNextClass: "mbsc-ic mbsc-ic-material-keyboard-arrow-right"
		, onEventBubbleShow: function (e) {
			var t = ke(e.eventList)
				, a = ke(e.target)
				.closest(".mbsc-cal-row")
				.index() < 2
				, n = ke(".mbsc-cal-event-color", t)
				.eq(a ? 0 : -1)
				.css("background-color");
			ke(".mbsc-cal-events-arr", t)
				.css("border-color", a ? "transparent transparent " + n + " transparent" : n + "transparent transparent transparent")
		}
	}), Aa.listview.material = {
		leftArrowClass: "mbsc-ic-material-keyboard-arrow-left"
		, rightArrowClass: "mbsc-ic-material-keyboard-arrow-right"
		, onItemActivate: function (e) {
			se(ke(e.target), e.domEvent)
		}
		, onItemDeactivate: function () {
			re(Va)
		}
		, onSlideStart: function (e) {
			ke(".mbsc-ripple", e.target)
				.remove()
		}
		, onSortStart: function (e) {
			ke(".mbsc-ripple", e.target)
				.remove()
		}
	}, Aa.navigation.material = {
		onInit: function () {
			oe(ke(this), ".mbsc-ms-item.mbsc-btn-e", "mbsc-btn-d", "mbsc-btn-nhl")
		}
		, onMarkupInit: function () {
			ke(".mbsc-ripple", this)
				.remove()
		}
		, onDestroy: function () {
			ke(this)
				.off(".mbsc-ripple")
		}
	}, Aa.form.material = {
		addRipple: function (e, t) {
			se(e, t)
		}
		, removeRipple: function () {
			re(Va)
		}
	};
	var Ia = ie.themes;
	Ia.frame.windows = {
		headerText: !1
		, deleteIcon: "backspace4"
		, setIcon: "checkmark"
		, cancelIcon: "close"
		, closeIcon: "close"
		, clearIcon: "close"
		, okIcon: "checkmark"
		, nowIcon: "loop2"
		, startIcon: "play3"
		, stopIcon: "pause2"
		, resetIcon: "stop2"
		, lapIcon: "loop2"
		, btnWidth: !1
		, btnReverse: !0
	}, Ia.scroller.windows = Ve({}, Ia.frame.windows, {
		minWidth: 76
		, height: 76
		, dateDisplay: "mmMMddDDyy"
		, showLabel: !1
		, icon: {
			filled: "star3"
			, empty: "star"
		}
		, btnCalPrevClass: "mbsc-ic mbsc-ic-arrow-left2"
		, btnCalNextClass: "mbsc-ic mbsc-ic-arrow-right2"
		, btnPlusClass: "mbsc-ic mbsc-ic-plus"
		, btnMinusClass: "mbsc-ic mbsc-ic-minus"
	}), Ia.form.windows = {}, ie.customTheme("ios-dark", "ios"), ie.customTheme("material-dark", "material"), ie.customTheme("mobiscroll-dark", "mobiscroll"), ie.customTheme("windows-dark", "windows");
	var Fa = ie.themes
		, Ha = void 0;
	return "android" == pe ? Ha = "material" : "ios" == pe ? Ha = "ios" : "wp" == pe && (Ha = "windows"), ie.setAutoTheme = function () {
		ke.each(Fa.frame, function (e, t) {
			if (Ha && t.baseTheme == Ha && "material-dark" != e && "windows-dark" != e && "ios-dark" != e) return ie.autoTheme = e, !1;
			e == Ha && (ie.autoTheme = e)
		})
	}, ie.setAutoTheme(), ie.apiKey = "2b3dbdbc", ie.apiUrl = "https://trial.mobiscroll.com/", ie
});
