/*时间工具*/
Date.prototype.pattern = function (fmt) {
    var o = {
        "MM": this.getMonth() + 1, //月份
        "dd": this.getDate(), //日
        "hh": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
        "HH": this.getHours(), //小时
        "mm": this.getMinutes(), //分
        "ss": this.getSeconds(), //秒
        "qq": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    var week = ["日", "一", "二", "三", "四", "五", "六"];
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? " 星期" : " 周") : "") + "<span>" + week[this.getDay()] + "</span>");
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}


