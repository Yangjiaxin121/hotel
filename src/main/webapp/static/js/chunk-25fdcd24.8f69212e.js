(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-25fdcd24"],{"0b1c":function(t,e,a){},"0e5e":function(t,e,a){"use strict";var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"navbar"},[a("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":t.activeIndex,router:"",mode:"horizontal"},on:{select:t.handleSelect}},[a("el-menu-item",[a("svg-icon",{attrs:{"icon-class":"bug"}}),a("span",[t._v(" 梦之家")])],1),a("el-menu-item",{attrs:{index:"DreamHome"}},[t._v("主页")]),a("el-menu-item",{attrs:{index:"userCenter"}},[t._v("个人中心")]),a("div",{staticClass:"right-menu"},[a("el-dropdown",{staticClass:"avatar-container right-menu-item hover-effect",attrs:{trigger:"click"}},[a("div",{staticClass:"avatar-wrapper"},[a("img",{staticClass:"user-avatar",attrs:{src:t.avatar+"?imageView2/1/w/80/h/80"}}),a("i",{staticClass:"el-icon-caret-bottom"})]),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("router-link",{attrs:{to:"/userCenter"}},[a("el-dropdown-item",[t._v("个人中心")])],1),a("router-link",{attrs:{to:"/center/index"}},[a("el-dropdown-item",[t._v("管理员界面")])],1),a("el-dropdown-item",{attrs:{divided:""},nativeOn:{click:function(e){return t.logout(e)}}},[a("span",{staticStyle:{display:"block"}},[t._v("退出登录")])])],1)],1)],1)],1)],1)},i=[],r=(a("96cf"),a("1da1")),c=a("5530"),n=a("2f62"),o=a("6350"),l=a("4f1e"),u=a("baee"),d=a("e886"),m=a("fe79"),f=a("144c"),v={components:{Breadcrumb:o["a"],Hamburger:l["a"],ErrorLog:u["a"],Screenfull:d["a"],SizeSelect:m["a"],Search:f["a"]},computed:Object(c["a"])({},Object(n["b"])(["sidebar","avatar","device"])),methods:{toggleSideBar:function(){this.$store.dispatch("app/toggleSideBar")},logout:function(){var t=this;return Object(r["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,t.$store.dispatch("user/logout");case 2:t.$router.push("/login?redirect=".concat(t.$route.fullPath));case 3:case"end":return e.stop()}}),e)})))()}}},g=v,p=(a("696c"),a("2877")),h=Object(p["a"])(g,s,i,!1,null,"d99319ca",null);e["a"]=h.exports},"60b7":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("Nav"),a("div",{staticClass:"img-show"},[a("div",{staticClass:"img-big"},[a("el-image",{attrs:{src:t.url,fit:t.fits}})],1),a("div",{staticClass:"img-small"},[a("div",{staticClass:"img1"},[a("div",{staticClass:"img1-1"},[a("el-image",{attrs:{src:t.url,fit:t.fits}})],1),a("div",{staticClass:"img1-2"},[a("el-image",{attrs:{src:t.url,fit:t.fits}})],1)]),a("div",{staticClass:"img2"},[a("div",{staticClass:"img2-1"},[a("el-image",{attrs:{src:t.url,fit:t.fits}})],1),a("div",{staticClass:"img2-2"},[a("el-image",{attrs:{src:t.url,fit:t.fits}})],1)])])])],1)},i=[],r=a("0e5e"),c={components:{Nav:r["a"]},data:function(){return{fits:"contain",url:"https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"}}},n=c,o=(a("60f8"),a("2877")),l=Object(o["a"])(n,s,i,!1,null,"cad9b362",null);e["default"]=l.exports},"60f8":function(t,e,a){"use strict";a("0b1c")},"696c":function(t,e,a){"use strict";a("de7e")},de7e:function(t,e,a){}}]);