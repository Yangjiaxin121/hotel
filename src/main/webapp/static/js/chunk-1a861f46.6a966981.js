(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1a861f46"],{"09f4":function(e,t,a){"use strict";a.d(t,"a",(function(){return o})),Math.easeInOutQuad=function(e,t,a,r){return e/=r/2,e<1?a/2*e*e+t:(e--,-a/2*(e*(e-2)-1)+t)};var r=function(){return window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(e){window.setTimeout(e,1e3/60)}}();function i(e){document.documentElement.scrollTop=e,document.body.parentNode.scrollTop=e,document.body.scrollTop=e}function n(){return document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop}function o(e,t,a){var o=n(),s=e-o,l=20,d=0;t="undefined"===typeof t?500:t;var u=function e(){d+=l;var n=Math.easeInOutQuad(d,o,s,t);i(n),d<t?r(e):a&&"function"===typeof a&&a()};u()}},"0a9b":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("div",{staticClass:"filter-container"},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"订单号"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleFilter(t)}},model:{value:e.listQuery.orderNo,callback:function(t){e.$set(e.listQuery,"orderNo",t)},expression:"listQuery.orderNo"}}),a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"房间ID"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleFilter(t)}},model:{value:e.listQuery.roomId,callback:function(t){e.$set(e.listQuery,"roomId",t)},expression:"listQuery.roomId"}}),a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"用户id"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleFilter(t)}},model:{value:e.listQuery.userId,callback:function(t){e.$set(e.listQuery,"userId",t)},expression:"listQuery.userId"}}),a("el-select",{staticClass:"filter-item",staticStyle:{width:"90px"},attrs:{placeholder:"房间状态",clearable:""},model:{value:e.listQuery.status,callback:function(t){e.$set(e.listQuery,"status",t)},expression:"listQuery.status"}},e._l(e.importanceOptions,(function(e){return a("el-option",{key:e,attrs:{label:e,value:e}})})),1),a("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.handleFilter}},[e._v(" 搜索 ")]),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{type:"primary",icon:"el-icon-edit"},on:{click:e.handleCreate}},[e._v(" 添加订单 ")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],key:e.tableKey,staticStyle:{width:"100%"},attrs:{data:e.list,border:"",fit:"","highlight-current-row":""},on:{"sort-change":e.sortChange}},[a("el-table-column",{attrs:{label:"订单号",prop:"orderNo",width:"150px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.orderNo))])]}}])}),a("el-table-column",{attrs:{label:"房间ID",prop:"roomId","min-width":"150px"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.roomId))])]}}])}),a("el-table-column",{attrs:{label:"订单状态",prop:"status","class-name":"status-col",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("el-tag",{attrs:{type:(r.status,"success")}},[e._v(" "+e._s(e.statusArr[r.status.toString()])+" ")])]}}])}),a("el-table-column",{attrs:{label:"用户姓名",prop:"realName",width:"110px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.realName))])]}}])}),a("el-table-column",{attrs:{label:"单价",prop:"payment",width:"80px"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.payment))])]}}])}),a("el-table-column",{attrs:{label:"总金额",prop:"totalPayment",align:"center",width:"95"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.totalPayment))])]}}])}),a("el-table-column",{attrs:{label:"房间状态",prop:"roomStatus","class-name":"status-col",width:"100"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("el-tag",{attrs:{type:10===r.roomStatus?"success":"error"}},[e._v(" "+e._s(e.roomStatusArr[r.roomStatus.toString()])+" ")])]}}])}),a("el-table-column",{attrs:{label:"付款时间",prop:"paymentTime",width:"110px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(e.format(r.paymentTime)))])]}}])}),a("el-table-column",{attrs:{label:"入住时间",prop:"intakeTime",width:"110px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(e.format(r.intakeTime)))])]}}])}),a("el-table-column",{attrs:{label:"退房时间",prop:"endTime",width:"110px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(e.format(r.endTime)))])]}}])}),a("el-table-column",{attrs:{label:"入住天数",prop:"stayDays",width:"110px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(r.stayDays))])]}}])}),a("el-table-column",{attrs:{label:"订单创建时间",prop:"createTime",width:"110px",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row;return[a("span",[e._v(e._s(e.format(r.createTime)))])]}}])}),a("el-table-column",{attrs:{label:"Actions",align:"center",width:"230","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){var r=t.row,i=t.$index;return[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.handleUpdate(r)}}},[e._v(" 编辑 ")]),r.intakeTime?e._e():a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.handleInTake(r.id)}}},[e._v(" 入住 ")]),r.intakeTime&&!r.endTime?a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){return e.handleOut(r.id)}}},[e._v(" 退房 ")]):e._e(),"deleted"!=r.status?a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(t){return e.handleDelete(r,i)}}},[e._v(" 删除订单 ")]):e._e()]}}])})],1),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.listQuery.page,limit:e.listQuery.limit},on:{"update:page":function(t){return e.$set(e.listQuery,"page",t)},"update:limit":function(t){return e.$set(e.listQuery,"limit",t)},pagination:e.getList}}),a("el-dialog",{attrs:{title:e.textMap[e.dialogStatus],visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"dataForm",staticStyle:{width:"400px","margin-left":"50px"},attrs:{rules:e.rules,model:e.orderForm,"label-position":"left","label-width":"70px"}},[a("el-form-item",{attrs:{label:"房间号"}},[a("el-input",{attrs:{placeholder:"请输入房间ID"},model:{value:e.orderForm.orderNo,callback:function(t){e.$set(e.orderForm,"orderNo",t)},expression:"orderForm.orderNo"}})],1),a("el-form-item",{attrs:{label:"用户姓名"}},[a("el-input",{attrs:{placeholder:"请输入用户真实姓名"},model:{value:e.orderForm.realName,callback:function(t){e.$set(e.orderForm,"realName",t)},expression:"orderForm.realName"}})],1),a("el-form-item",{attrs:{label:"房间价格"}},[a("el-input",{attrs:{placeholder:"请输入房间价格"},model:{value:e.orderForm.price,callback:function(t){e.$set(e.orderForm,"price",t)},expression:"orderForm.price"}})],1),a("el-form-item",{attrs:{label:"总价格"}},[a("el-input",{attrs:{disabled:""},model:{value:e.orderForm.totalPayment,callback:function(t){e.$set(e.orderForm,"totalPayment",t)},expression:"orderForm.totalPayment"}})],1),a("el-form-item",{attrs:{label:"入住-退订时间"}},[a("el-date-picker",{attrs:{type:"daterange","range-separator":"至","start-placeholder":"开始日期","end-placeholder":"结束日期","picker-options":e.pickerOptions},model:{value:e.orderFrom.createTime,callback:function(t){e.$set(e.orderFrom,"createTime",t)},expression:"orderFrom.createTime"}}),e._v(" "+e._s(e.orderFrom.createTime)+" ")],1),a("el-form-item",{attrs:{label:"总天数"}},[a("el-input",{attrs:{disabled:""},model:{value:e.orderForm.stayDays,callback:function(t){e.$set(e.orderForm,"stayDays",t)},expression:"orderForm.stayDays"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v(" 取消 ")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){"create"===e.dialogStatus?e.createData():e.updateData()}}},[e._v(" 确定 ")])],1)],1),a("el-dialog",{attrs:{visible:e.dialogPvVisible,title:"Reading statistics"},on:{"update:visible":function(t){e.dialogPvVisible=t}}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.pvData,border:"",fit:"","highlight-current-row":""}},[a("el-table-column",{attrs:{prop:"key",label:"Channel"}}),a("el-table-column",{attrs:{prop:"pv",label:"Pv"}})],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogPvVisible=!1}}},[e._v("Confirm")])],1)],1)],1)},i=[],n=(a("c740"),a("d81d"),a("13d5"),a("a434"),a("d3b7"),a("2423")),o=a("6724"),s=a("ed08"),l=a("333d"),d=a("b775");function u(e){return Object(d["a"])({url:"/manager1/order/set_order_checkin.do",method:"post",data:e})}function c(e){return Object(d["a"])({url:"/manager1/order/set_order_unsubscribed.do",method:"post",data:e})}function m(e){return Object(d["a"])({url:"/admin/order/get_order_list.do",method:"post",data:e})}var p=[{key:"CN",display_name:"China"},{key:"US",display_name:"USA"},{key:"JP",display_name:"Japan"},{key:"EU",display_name:"Eurozone"}],f=p.reduce((function(e,t){return e[t.key]=t.display_name,e}),{}),h={0:"已付款",10:"未付款",20:"已付款",50:"交易成功",60:"交易关闭"},y={0:"已预定",10:"已退房",20:"已续租"},v={name:"ComplexTable",components:{Pagination:l["a"]},directives:{waves:o["a"]},filters:{statusFilter:function(e){var t={published:"success",draft:"info",deleted:"danger"};return t[e]},typeFilter:function(e){return f[e]}},data:function(){return{orderFrom:{orderNo:1,roomId:30,userId:26,payment:0,totalPayment:250,paymentType:1,status:20,roomStatus:30,paymentTime:1613485351e3,intakeTime:1613485351e3,endTime:1613485351e3,stayDays:0,createTime:1613485351e3,updateTime:1613485351e3},pickerOptions:{disabledDate:function(e){return e.getTime()<Date.now()-864e5}},tableKey:0,statusArr:h,roomStatusArr:y,list:null,total:0,listLoading:!0,listQuery:{page:1,limit:20,importance:void 0,title:void 0,type:void 0,sort:"+id"},importanceOptions:[1,2,3],calendarTypeOptions:p,sortOptions:[{label:"ID Ascending",key:"+id"},{label:"ID Descending",key:"-id"}],statusOptions:["published","draft","deleted"],showReviewer:!1,orderForm:{id:void 0,importance:1,remark:"",timestamp:new Date,title:"",type:"",status:"published"},dialogFormVisible:!1,dialogStatus:"",textMap:{update:"Edit",create:"Create"},dialogPvVisible:!1,pvData:[],rules:{type:[{required:!0,message:"type is required",trigger:"change"}],timestamp:[{type:"date",required:!0,message:"timestamp is required",trigger:"change"}],title:[{required:!0,message:"title is required",trigger:"blur"}]},downloadLoading:!1}},created:function(){this.getList()},methods:{add0:function(e){return e<10?"0"+e:e},format:function(e){var t=new Date(e),a=t.getFullYear(),r=t.getMonth()+1,i=t.getDate(),n=t.getHours(),o=t.getMinutes(),s=t.getSeconds();return a+"-"+this.add0(r)+"-"+this.add0(i)+" "+this.add0(n)+":"+this.add0(o)+":"+this.add0(s)},handleInTake:function(e){var t=this,a={id:e};u(a).then((function(e){0===e.status&&(t.$message({type:"success",message:"入住成功"}),t.getList())}))},handelOut:function(e){var t=this,a={id:e};c(a).then((function(e){0===e.status&&(t.$message({type:"success",message:"退房成功"}),t.getList())}))},getList:function(){var e=this;this.listLoading=!0;var t={pageNum:this.listQuery.page,pageSize:this.listQuery.limit};m(t).then((function(t){e.list=t.data.list,e.total=t.data.total,e.listLoading=!1})).catch((function(t){e.listLoading=!1}))},handleFilter:function(){this.listQuery.page=1,this.getList()},handleModifyStatus:function(e,t){this.$message({message:"操作Success",type:"success"}),e.status=t},sortChange:function(e){var t=e.prop,a=e.order;"id"===t&&this.sortByID(a)},sortByID:function(e){this.listQuery.sort="ascending"===e?"+id":"-id",this.handleFilter()},resetTemp:function(){this.orderForm={}},handleCreate:function(){var e=this;this.resetTemp(),this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick((function(){e.$refs["dataForm"].clearValidate()}))},createData:function(){var e=this;this.$refs["dataForm"].validate((function(t){t&&(e.orderForm.id=parseInt(100*Math.random())+1024,e.orderForm.author="vue-element-admin",Object(n["a"])(e.orderForm).then((function(){e.list.unshift(e.orderForm),e.dialogFormVisible=!1,e.$notify({title:"Success",message:"Created Successfully",type:"success",duration:2e3})})))}))},handleUpdate:function(e){var t=this;this.orderForm=Object.assign({},e),this.orderForm.timestamp=new Date(this.orderForm.timestamp),this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick((function(){t.$refs["dataForm"].clearValidate()}))},updateData:function(){var e=this;this.$refs["dataForm"].validate((function(t){if(t){var a=Object.assign({},e.orderForm);a.timestamp=+new Date(a.timestamp),Object(n["e"])(a).then((function(){var t=e.list.findIndex((function(t){return t.id===e.orderForm.id}));e.list.splice(t,1,e.orderForm),e.dialogFormVisible=!1,e.$notify({title:"Success",message:"Update Successfully",type:"success",duration:2e3})}))}}))},handleDelete:function(e,t){this.$notify({title:"Success",message:"Delete Successfully",type:"success",duration:2e3}),this.list.splice(t,1)},handleFetchPv:function(e){var t=this;Object(n["d"])(e).then((function(e){t.pvData=e.data.pvData,t.dialogPvVisible=!0}))},handleDownload:function(){var e=this;this.downloadLoading=!0,Promise.all([a.e("chunk-6e83591c"),a.e("chunk-5164a781"),a.e("chunk-5b0190f0"),a.e("chunk-9a21ec70")]).then(a.bind(null,"4bf8")).then((function(t){var a=["timestamp","title","type","importance","status"],r=["timestamp","title","type","importance","status"],i=e.formatJson(r);t.export_json_to_excel({header:a,data:i,filename:"table-list"}),e.downloadLoading=!1}))},formatJson:function(e){return this.list.map((function(t){return e.map((function(e){return"timestamp"===e?Object(s["e"])(t[e]):t[e]}))}))},getSortClass:function(e){var t=this.listQuery.sort;return t==="+".concat(e)?"ascending":"descending"}}},b=v,g=a("2877"),w=Object(g["a"])(b,r,i,!1,null,null,null);t["default"]=w.exports},2423:function(e,t,a){"use strict";a.d(t,"c",(function(){return i})),a.d(t,"b",(function(){return n})),a.d(t,"d",(function(){return o})),a.d(t,"a",(function(){return s})),a.d(t,"e",(function(){return l}));var r=a("b775");function i(e){return Object(r["a"])({url:"/vue-element-admin/article/list",method:"get",params:e})}function n(e){return Object(r["a"])({url:"/vue-element-admin/article/detail",method:"get",params:{id:e}})}function o(e){return Object(r["a"])({url:"/vue-element-admin/article/pv",method:"get",params:{pv:e}})}function s(e){return Object(r["a"])({url:"/vue-element-admin/article/create",method:"post",data:e})}function l(e){return Object(r["a"])({url:"/vue-element-admin/article/update",method:"post",data:e})}},6724:function(e,t,a){"use strict";a("8d41");var r="@@wavesContext";function i(e,t){function a(a){var r=Object.assign({},t.value),i=Object.assign({ele:e,type:"hit",color:"rgba(0, 0, 0, 0.15)"},r),n=i.ele;if(n){n.style.position="relative",n.style.overflow="hidden";var o=n.getBoundingClientRect(),s=n.querySelector(".waves-ripple");switch(s?s.className="waves-ripple":(s=document.createElement("span"),s.className="waves-ripple",s.style.height=s.style.width=Math.max(o.width,o.height)+"px",n.appendChild(s)),i.type){case"center":s.style.top=o.height/2-s.offsetHeight/2+"px",s.style.left=o.width/2-s.offsetWidth/2+"px";break;default:s.style.top=(a.pageY-o.top-s.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",s.style.left=(a.pageX-o.left-s.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return s.style.backgroundColor=i.color,s.className="waves-ripple z-active",!1}}return e[r]?e[r].removeHandle=a:e[r]={removeHandle:a},a}var n={bind:function(e,t){e.addEventListener("click",i(e,t),!1)},update:function(e,t){e.removeEventListener("click",e[r].removeHandle,!1),e.addEventListener("click",i(e,t),!1)},unbind:function(e){e.removeEventListener("click",e[r].removeHandle,!1),e[r]=null,delete e[r]}},o=function(e){e.directive("waves",n)};window.Vue&&(window.waves=n,Vue.use(o)),n.install=o;t["a"]=n},"8d41":function(e,t,a){}}]);