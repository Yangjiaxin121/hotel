(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4eaae9c0"],{"0f16":function(e,t,s){},"133c":function(e,t,s){"use strict";s("7c25")},"16c4":function(e,t,s){"use strict";s("90b6")},"23de":function(e,t,s){},2417:function(e,t,s){"use strict";var a=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":e.activeIndex,router:"",mode:"horizontal"},on:{select:e.handleSelect}},[s("el-menu-item",{attrs:{index:"DreamHome"}},[e._v("主页")]),s("el-menu-item",{attrs:{index:"userCenter"}},[e._v("个人中心")])],1)},r=[],i=(s("b0c0"),{props:{name:{type:String,default:"DreamHome"}},data:function(){return{activeIndex:"DreamHome",activeIndex2:"1"}},mounted:function(){this.activeIndex=this.name},methods:{handleSelect:function(e,t){console.log(e,t)}}}),n=i,o=s("2877"),l=Object(o["a"])(n,a,r,!1,null,null,null);t["a"]=l.exports},"3cbc":function(e,t,s){"use strict";var a=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"pan-item",style:{zIndex:e.zIndex,height:e.height,width:e.width}},[s("div",{staticClass:"pan-info"},[s("div",{staticClass:"pan-info-roles-container"},[e._t("default")],2)]),s("div",{staticClass:"pan-thumb",style:{backgroundImage:"url("+e.image+")"}})])},r=[],i=(s("a9e3"),{name:"PanThumb",props:{image:{type:String,required:!0},zIndex:{type:Number,default:1},width:{type:String,default:"150px"},height:{type:String,default:"150px"}}}),n=i,o=(s("133c"),s("2877")),l=Object(o["a"])(n,a,r,!1,null,"799537af",null);t["a"]=l.exports},"7c25":function(e,t,s){},"7f33":function(e,t,s){"use strict";s("23de")},"90b6":function(e,t,s){},db10:function(e,t,s){"use strict";s.r(t);var a=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"app-container"},[s("Nav",{attrs:{name:"userCenter"}}),e.userInfo?s("div",[s("el-row",{attrs:{gutter:20}},[s("el-col",{attrs:{span:6,xs:24}},[s("user-card",{attrs:{userInfo:e.userInfo}})],1),s("el-col",{attrs:{span:18,xs:24}},[s("el-card",[s("el-tabs",{model:{value:e.activeTab,callback:function(t){e.activeTab=t},expression:"activeTab"}},[s("el-tab-pane",{attrs:{label:"个人信息",name:"activity"}},[s("activity",{attrs:{userInfo:e.userInfo}})],1),s("el-tab-pane",{attrs:{label:"订单信息",name:"timeline"}},[s("timeline",{attrs:{userInfo:e.userInfo}})],1)],1)],1)],1)],1)],1):e._e()],1)},r=[],i=s("5530"),n=s("2f62"),o=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("el-card",{staticStyle:{"margin-bottom":"20px"}},[s("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[s("span",[e._v("个人中心")])]),s("div",{staticClass:"user-profile"},[s("div",{staticClass:"box-center"},[s("pan-thumb",{attrs:{image:"https://wpimg.wallstcn.com/fb57f689-e1ab-443c-af12-8d4066e202e2.jpg?imageView2/1/w/80/h/80",height:"100px",width:"100px",hoverable:!1}},[s("div",[e._v("Hello")]),e._v(" "+e._s(e.userInfo.role)+" ")])],1),s("div",{staticClass:"box-center"},[s("div",{staticClass:"user-name text-center"},[e._v(e._s(e.userInfo.username))])])]),s("div",{staticClass:"user-bio"},[s("div",{staticClass:"user-education user-bio-section"},[s("div",{staticClass:"user-bio-section-header"},[s("svg-icon",{attrs:{"icon-class":"education"}}),s("span",[e._v("账号信息")])],1),s("div",{staticClass:"user-bio-section-body"},[s("div",{staticClass:"text-muted"},[s("div",{staticClass:"username",staticStyle:{margin:"10px"}},[s("span",[e._v("账号:")]),e._v(e._s(e.userInfo.username||"--")+" ")]),s("div",{staticClass:"password",staticStyle:{margin:"10px"}},[s("span",[e._v("密码:")]),s("el-button",{attrs:{type:"text"},on:{click:e.changePassword}},[e._v("修改密码")])],1)])])]),s("div",{staticClass:"user-skills user-bio-section"},[s("div",{staticClass:"user-bio-section-header"},[s("svg-icon",{attrs:{"icon-class":"skill"}}),s("span",[e._v("常住")])],1),s("div",{staticClass:"user-bio-section-body"},[s("div",{staticClass:"progress-item"},[s("span",[e._v("民宿")]),s("el-progress",{attrs:{percentage:70}})],1),s("div",{staticClass:"progress-item"},[s("span",[e._v("酒店")]),s("el-progress",{attrs:{percentage:18}})],1),s("div",{staticClass:"progress-item"},[s("span",[e._v("电竞房")]),s("el-progress",{attrs:{percentage:12}})],1),s("div",{staticClass:"progress-item"},[s("span",[e._v("认证")]),s("el-progress",{attrs:{percentage:100,status:"success"}})],1)])])]),s("el-dialog",{attrs:{title:"修改密码",visible:e.dialogVisible,width:"40%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[s("el-form",{ref:"passwordForm",staticStyle:{margin:"0 20px"},attrs:{model:e.passwordForm,rules:e.rules}},[s("el-form-item",{attrs:{label:"原密码",prop:"password"}},[s("el-input",{attrs:{placeholder:"请输入密码",type:"password"},model:{value:e.passwordForm.password,callback:function(t){e.$set(e.passwordForm,"password",t)},expression:"passwordForm.password"}})],1),s("el-form-item",{attrs:{label:"新密码",prop:"newPassword"}},[s("el-input",{attrs:{placeholder:"请输入新密码",type:"password"},model:{value:e.passwordForm.newPassword,callback:function(t){e.$set(e.passwordForm,"newPassword",t)},expression:"passwordForm.newPassword"}})],1),s("el-form-item",{attrs:{label:"确定密码",prop:"repeatPassword"}},[s("el-input",{attrs:{placeholder:"请再次确认密码",type:"password"},model:{value:e.passwordForm.repeatPassword,callback:function(t){e.$set(e.passwordForm,"repeatPassword",t)},expression:"passwordForm.repeatPassword"}})],1)],1),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v(" 取消 ")]),s("el-button",{attrs:{type:"primary"},on:{click:e.handleClick}},[e._v(" 提交 ")])],1)],1)],1)},l=[],c=s("3cbc"),u=s("c24f"),d={components:{PanThumb:c["a"]},props:{userInfo:{type:Object,default:function(){return{username:"",email:"",role:""}}}},data:function(){var e=this,t=function(t,s,a){s!=e.$props.userInfo.password?a(new Error("请输入正确的密码")):a()},s=function(e,t,s){t.length<6?s(new Error("密码长度至少大于六位")):s()},a=function(t,s,a){s||a(new Error("请再次输入密码")),s!==e.passwordForm.newPassword?a(new Error("两次输入密码不一致")):a()};return{dialogVisible:!1,passwordForm:{password:"",newPassword:"",repeatPassword:""},rules:{password:[{required:!0,trigger:"blur",validator:t}],newPassword:[{required:!0,trigger:"blur",validator:s}],repeatPassword:[{required:!0,trigger:"blur",validator:a}]}}},methods:{changePassword:function(){var e=this;this.passwordForm={password:"",newPassword:"",repeatPassword:""},this.dialogVisible=!0,this.$nextTick((function(){e.$refs["passwordForm"].clearValidate()}))},handleClick:function(){var e=this;this.$refs["passwordForm"].validate((function(t){t&&(e.userInfo.password=e.passwordForm.newPassword,Object(u["i"])(e.userInfo).then((function(t){0===t.status&&(e.$message.success("修改成功，请下次登录使用新密码"),e.dialogVisible=!1)})))}))}}},m=d,p=(s("16c4"),s("2877")),f=Object(p["a"])(m,o,l,!1,null,"1085db1a",null),v=f.exports,b=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"user-activity"},[s("div",{staticClass:"post"},[s("div",{staticClass:"user-block"},[s("span",{staticClass:"username text-muted"},[e._v("姓名")]),0===e.infoEdit.realName?s("span",{staticClass:"description"},[e._v(e._s(e.userInfo.realName||"--"))]):s("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.realName,expression:"userInfo.realName"}],staticClass:"description",staticStyle:{width:"300px"},attrs:{type:"text"},domProps:{value:e.userInfo.realName},on:{input:function(t){t.target.composing||e.$set(e.userInfo,"realName",t.target.value)}}})]),s("p"),s("ul",{staticClass:"list-inline"},[s("li",[0===e.infoEdit.realName?s("el-button",{attrs:{icon:"el-icon-edit"},on:{click:function(t){return e.handleChange("realName")}}},[e._v("修改")]):s("el-button",{attrs:{icon:"el-icon-document"},on:{click:function(t){return e.handleSave("realName")}}},[e._v("保存")])],1)])]),s("div",{staticClass:"post"},[s("div",{staticClass:"user-block"},[s("span",{staticClass:"username text-muted"},[e._v("身份证号")]),0===e.infoEdit.idNumber?s("span",{staticClass:"description"},[e._v(e._s(e.userInfo.idNumber||"--"))]):s("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.idNumber,expression:"userInfo.idNumber"}],staticClass:"description",staticStyle:{width:"300px"},attrs:{type:"text"},domProps:{value:e.userInfo.idNumber},on:{input:function(t){t.target.composing||e.$set(e.userInfo,"idNumber",t.target.value)}}})]),s("p"),s("ul",{staticClass:"list-inline"},[s("li",[0===e.infoEdit.idNumber?s("el-button",{attrs:{icon:"el-icon-edit"},on:{click:function(t){return e.handleChange("idNumber")}}},[e._v("修改")]):s("el-button",{attrs:{icon:"el-icon-document"},on:{click:function(t){return e.handleSave("idNumber")}}},[e._v("保存")])],1)])]),s("div",{staticClass:"post"},[s("div",{staticClass:"user-block"},[s("span",{staticClass:"username text-muted"},[e._v("Email")]),0===e.infoEdit.email?s("span",{staticClass:"description"},[e._v(e._s(e.userInfo.email||"--"))]):s("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.email,expression:"userInfo.email"}],staticClass:"description",staticStyle:{width:"300px"},attrs:{type:"text"},domProps:{value:e.userInfo.email},on:{input:function(t){t.target.composing||e.$set(e.userInfo,"email",t.target.value)}}})]),s("p"),s("ul",{staticClass:"list-inline"},[s("li",[0===e.infoEdit.email?s("el-button",{attrs:{icon:"el-icon-edit"},on:{click:function(t){return e.handleChange("email")}}},[e._v("修改")]):s("el-button",{attrs:{icon:"el-icon-document"},on:{click:function(t){return e.handleSave("email")}}},[e._v("保存")])],1)])]),s("div",{staticClass:"post"},[s("div",{staticClass:"user-block"},[s("span",{staticClass:"username text-muted"},[e._v("Phone")]),0===e.infoEdit.phone?s("span",{staticClass:"description"},[e._v(e._s(e.userInfo.phone||"--"))]):s("input",{directives:[{name:"model",rawName:"v-model",value:e.userInfo.phone,expression:"userInfo.phone"}],staticClass:"description",staticStyle:{width:"300px"},attrs:{type:"text"},domProps:{value:e.userInfo.phone},on:{input:function(t){t.target.composing||e.$set(e.userInfo,"phone",t.target.value)}}})]),s("p"),s("ul",{staticClass:"list-inline"},[s("li",[0===e.infoEdit.phone?s("el-button",{attrs:{icon:"el-icon-edit"},on:{click:function(t){return e.handleChange("phone")}}},[e._v("修改")]):s("el-button",{attrs:{icon:"el-icon-document"},on:{click:function(t){return e.handleSave("phone")}}},[e._v("保存")])],1)])]),s("div",{staticClass:"post"},[s("div",{staticClass:"user-images"},[s("el-carousel",{attrs:{interval:6e3,type:"card",height:"220px"}},e._l(e.carouselImages,(function(t){return s("el-carousel-item",{key:t},[s("img",{staticClass:"image",attrs:{src:t+e.carouselPrefix}})])})),1)],1)])])},h=[],g="?imageView2/1/w/80/h/80",w="?imageView2/2/h/440",_={props:{userInfo:{type:Object,default:function(){return{}}}},data:function(){return{carouselImages:["https://wpimg.wallstcn.com/9679ffb0-9e0b-4451-9916-e21992218054.jpg","https://wpimg.wallstcn.com/bcce3734-0837-4b9f-9261-351ef384f75a.jpg","https://wpimg.wallstcn.com/d1d7b033-d75e-4cd6-ae39-fcd5f1c0a7c5.jpg","https://wpimg.wallstcn.com/50530061-851b-4ca5-9dc5-2fead928a939.jpg"],avatarPrefix:g,carouselPrefix:w,infoEdit:{realName:0,idNumber:0,email:0,phone:0},user:{}}},methods:{handleChange:function(e){switch(e){case"realName":this.infoEdit.realName=1;break;case"idNumber":this.infoEdit.idNumber=1;break;case"email":this.infoEdit.email=1;break;case"phone":this.infoEdit.phone=1;break}},handleSave:function(e){var t=this;switch(e){case"realName":this.infoEdit.realName=0;break;case"idNumber":this.infoEdit.idNumber=0;break;case"email":this.infoEdit.email=0;break;case"phone":this.infoEdit.phone=0;break}Object(u["i"])(this.userInfo).then((function(e){0===e.status&&t.$message.success("保存成功")}))}}},C=_,I=(s("e454"),Object(p["a"])(C,b,h,!1,null,"6c7c4a75",null)),x=I.exports,y=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"block"},[s("el-timeline",e._l(e.orderList,(function(t,a){return s("el-timeline-item",{key:a,attrs:{timestamp:e.format(t.reserveTime),placement:"top"}},[s("el-card",[s("ul",{staticClass:"list-inline"},[s("li",[e._v("订单号 ： "+e._s(t.id))]),s("li",[e._v("房间号 ： "+e._s(t.roomNumber))]),s("li",[e._v("总金额 ： "+e._s(t.totalPayment))])]),s("ul",{staticClass:"list-inline"},[s("li",[e._v(" 入住时间段 ： "+e._s(e.format(t.reserveTime)+"-"+e.format(t.reserveEndTime))+" ")]),s("li",[e._v(" 订单状态： "),s("el-tag",{attrs:{type:(t.status,"success")}},[e._v(" "+e._s(e.statusArr[t.status.toString()])+" ")])],1),s("li",[e._v(" 操作："),s("el-button",{on:{click:function(s){return e.handleClick(t.id,t.roomId)}}},[e._v("评价")])],1)])])],1)})),1),s("el-dialog",{attrs:{title:"评价",visible:e.dialogTableVisible,width:"60%","append-to-body":""},on:{"update:visible":function(t){e.dialogTableVisible=t}}},[s("el-form",{ref:"commentForm",staticStyle:{margin:"0 50px"},attrs:{model:e.commentForm,rules:e.rule,"label-position":"top"}},[s("el-form-item",{attrs:{label:"评分",prop:"score"}},[s("el-rate",{model:{value:e.commentForm.score,callback:function(t){e.$set(e.commentForm,"score",t)},expression:"commentForm.score"}})],1),s("el-form-item",{attrs:{label:"评论:",prop:"comment"}},[s("el-input",{attrs:{type:"textarea",rows:10,placeholder:"请输入评论内容"},model:{value:e.commentForm.comment,callback:function(t){e.$set(e.commentForm,"comment",t)},expression:"commentForm.comment"}})],1)],1),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(t){e.dialogTableVisible=!1}}},[e._v(" 取消 ")]),s("el-button",{attrs:{type:"primary"},on:{click:e.handleCommentClick}},[e._v(" 提交 ")])],1)],1)],1)},k=[],N=s("a78e"),F=s.n(N),E=s("f8b7"),P={props:{userInfo:{type:Object,default:function(){return{username:"",email:"",role:""}}}},data:function(){return{rule:{comment:[{required:!0,trigger:"blur",message:"请输入评论"}],score:[{required:!0,trigger:"blur",message:"此项位必选项"}]},orderList:[],statusArr:{10:"未付款",20:"已付款",50:"交易成功"},commentForm:{comment:"",score:0},dialogTableVisible:!1,orderId:0,roomId:0}},mounted:function(){this.getOrderList()},methods:{getOrderList:function(){var e=this,t={order:{userId:F.a.get("Admin-Token")},pageNum:1,pageSize:999999};Object(E["b"])(t).then((function(t){e.orderList=t.data.list}))},handleClick:function(e,t){this.commentForm={comment:"",score:0},this.orderId=e,this.roomId=t,this.dialogTableVisible=!0},handleCommentClick:function(){var e=this;this.$refs["commentForm"].validate((function(t){if(t){if(!e.commentForm.score)return void e.$message.error("请选择评分后进行提交");var s={orderId:e.orderId,roomId:e.roomId,userId:e.userInfo.id,commentLevel:e.commentForm.score,content:e.commentForm.comment};Object(u["a"])(s).then((function(t){0===t.status&&(e.$message.success("评论成功"),e.dialogTableVisible=!1,e.getOrderList())}))}}))},add0:function(e){return e<10?"0"+e:e},format:function(e){if(!e)return"--";var t=new Date(e),s=t.getFullYear(),a=t.getMonth()+1,r=t.getDate();return s+"-"+this.add0(a)+"-"+this.add0(r)+" "}}},j=P,$=(s("7f33"),Object(p["a"])(j,y,k,!1,null,"22d94db8",null)),O=$.exports,S=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("el-form",[s("el-form-item",{attrs:{label:"Name"}},[s("el-input",{model:{value:e.user.name,callback:function(t){e.$set(e.user,"name","string"===typeof t?t.trim():t)},expression:"user.name"}})],1),s("el-form-item",{attrs:{label:"Email"}},[s("el-input",{model:{value:e.user.email,callback:function(t){e.$set(e.user,"email","string"===typeof t?t.trim():t)},expression:"user.email"}})],1),s("el-form-item",[s("el-button",{attrs:{type:"primary"},on:{click:e.submit}},[e._v("Update")])],1)],1)},T=[],V={props:{user:{type:Object,default:function(){return{name:"",email:""}}}},methods:{submit:function(){this.$message({message:"User information has been updated successfully",type:"success",duration:5e3})}}},L=V,q=Object(p["a"])(L,S,T,!1,null,null,null),A=q.exports,z=s("2417"),D={name:"Profile",components:{UserCard:v,Activity:x,Timeline:O,Account:A,Nav:z["a"]},data:function(){return{userInfo:{},activeTab:"activity"}},computed:Object(i["a"])({},Object(n["b"])(["name","avatar","roles"])),mounted:function(){this.getUserInfo()},methods:{getUserInfo:function(){var e=this,t={userId:F.a.get("Admin-Token")};Object(u["f"])(t).then((function(t){e.userInfo=t.data}))}}},U=D,H=Object(p["a"])(U,a,r,!1,null,null,null);t["default"]=H.exports},e454:function(e,t,s){"use strict";s("0f16")},f8b7:function(e,t,s){"use strict";s.d(t,"d",(function(){return r})),s.d(t,"f",(function(){return i})),s.d(t,"e",(function(){return n})),s.d(t,"c",(function(){return o})),s.d(t,"a",(function(){return l})),s.d(t,"b",(function(){return c}));var a=s("b775");function r(e){return Object(a["a"])({url:"/manager1/order/set_order_checkin.do",method:"post",data:e})}function i(e){return Object(a["a"])({url:"/manager1/order/set_order_unsubscribed.do",method:"post",data:e})}function n(e){return Object(a["a"])({url:"/manager1/order/set_order_stay.do",method:"post",data:e})}function o(e){return Object(a["a"])({url:"/admin/order/get_order_list.do",method:"post",data:e})}function l(e){return Object(a["a"])({url:"/customer/order/create_my_order.do",method:"post",data:e})}function c(e){return Object(a["a"])({url:"/admin/order/get_order_by_attribute.do",method:"post",data:e})}}}]);