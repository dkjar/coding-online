// createwindow(title, url , w, h) ; 创建有 “确定”, “关闭” 按钮对话框
// createCloseWindow(title, url , w, h) ; 创建有  “关闭” 按钮对话框  
// createNoButtonWindow(title, url , w, h) ; 创建无按钮对话框  
// getParentDialog(); 获取当前弹出窗口的父窗口
// showParentDialog();关闭子窗口时调用， 当前父窗口显示在最前面
// W ; 获取当前弹出窗口的父页面
+function($){
	
	var iframe;// iframe操作对象
	var win;//窗口对象
	var gridname="";//操作datagrid对象名称
	var windowapi = frameElement!=undefined?frameElement.api:undefined, W = windowapi !=undefined? windowapi.opener :undefined;//内容页中调用窗口实例对象接口
	var windowIndex = 10;
	var defaultWidth = 1000;
	var defaultHeight = 550;
	
	function getParentDialog(){
		 if(W != undefined){   
			 return windowapi.get(windowapi.data - 10);
		 }
	}
	
	function infos(msg) {
		if(W)
			W.$.messager.alert('提示', msg, 'info' , function(){ } );
		else
			$.messager.alert('提示', msg, 'info' , function(){ } );
	}
	
	function defaultwindow(title, addurl){
		return createwindow(title, addurl, defaultWidth, defaultHeight)
	}
	function viewindow(title, addurl){
		return closewindow(title, addurl, defaultWidth, defaultHeight)
	}
	function selectwindow(title, addurl){
		return selectW(title, addurl, defaultWidth-200, defaultHeight-50)
	}
	function createwindow(title, addurl, _width, _height) {
		 if(W){   
			 windowIndex = windowapi.data +10; 
			 var d =  W.$.dialog({ 
				 	id:windowIndex,
				 	data:windowIndex,
					content: 'url:'+addurl,
					lock : true,
					cache:true,
					width: _width,
					height: _height, 
					title:title,
					parent:windowapi, 
					close:function(){  W.$.dialog({ id: windowapi.data }); return true;},
				    ok: function(){ 
				    	$.codingol.form.submit(this);
						return false;
				    },
				    cancelVal: '关闭',
				    cancel: function(){  return true;} /*为true等价于function(){}*/
				});
			 if(!_width||!_height){
				 d.max();
			 }
			 return d;
		 }else{
			var d = $.dialog({ 
				 	id: windowIndex,
				 	data: windowIndex,
					content: 'url:'+addurl,
					cache: true,
					lock : true,
					width: _width,
					height: _height,
					title: title, 
					close:function(){ return true;},
				    ok: function(){
				    	$.codingol.form.submit(this);
				    	return false;
				    },
				    cancelVal: '关闭',
				    cancel: true /*为true等价于function(){}*/
				});
			if(!_width||!_height){
				 d.max();
			 }
			return d;
		 }
	}
	function selectW(title, addurl, _width, _height) {
		 if(W){   
			 windowIndex = windowapi.data +10; 
			 var d =  W.$.dialog({ 
				 	id:windowIndex,
				 	data:windowIndex,
					content: 'url:'+addurl,
					lock : true,
					cache:true,
					left :'85%',
					top :'65%',
					width: _width,
					height: _height, 
					title:title,
					parent:windowapi, 
					close:function(){  W.$.dialog({ id: windowapi.data }); return true;},
				    ok: function(){ 
				    	$.codingol.form.submit(this);
						return false;
				    },
				    cancelVal: '关闭',
				    cancel: function(){ return $.codingol.form.close(this); } /*为true等价于function(){}*/
				});
			 if(!_width||!_height){
				 d.max();
			 }
			 return d;
		 }else{
			var d = $.dialog({ 
				 	id: windowIndex,
				 	data: windowIndex,
					content: 'url:'+addurl,
					cache: true,
					lock : true,
					left :'85%',
					top :'65%',
					width: _width,
					height: _height,
					title: title, 
					close:function(){ return true;},
				    ok: function(){
				    	$.codingol.form.submit(this);
				    	return false;
				    },
				    cancelVal: '关闭',
				    cancel: function(){return $.codingol.form.close(this); } /*为true等价于function(){}*/
				});
			if(!_width||!_height){
				 d.max();
			 }
			return d;
		 }
	}
	function closewindow(title, addurl, _width, _height) {
		 if(W){   
			 windowIndex = windowapi.data +10; 
			 var d =  W.$.dialog({ 
				 	id:windowIndex,
				 	data:windowIndex,
					content: 'url:'+addurl,
					lock : true,
					cache:true,
					width: _width,
					height: _height, 
					title:title,
					parent:windowapi, 
					close:function(){  W.$.dialog({ id: windowapi.data }); return true;},
				    cancelVal: '关闭',
				    cancel: function(){  return true;} /*为true等价于function(){}*/
				});
			 if(!_width||!_height){
				 d.max();
			 }
			 return d;
		 }else{ 
			var d = $.dialog({ 
				 	id: windowIndex,
				 	data: windowIndex,
					content: 'url:'+addurl,
					cache: true,
					lock : true,
					width: _width,
					height: _height,
					title: title, 
					close:function(){ return true;},
				    cancelVal: '关闭',
				    cancel: true /*为true等价于function(){}*/
				});
			if(!_width||!_height){
				 d.max();
			 }
			return d;
		 }
	}
	
	function confirm(title, callback){
		if(W){
			W.$.dialog.confirm(title, function(){
				if(callback){
					callback();
				}
			});
		}else{
			$.dialog.confirm(title, function(){
				if(callback){
					callback();
				}
			});
		}
	}
	
	
	$.codingol = {};
	$.codingol.form = {};
	$.codingol.grid = {};
	$.codingol.length = 4;
	
	$.codingol.get = function(url, params, callback){
		$.ajax({
			url: url,  
			type:'get', 
			data: params,
			success:function(msg) {
				if(callback){
					callback(msg)
				}
				return msg
			},
			error:function(result){
				return null;
			}
		}); 
	};
	
	$.codingol.linkPost = function(url, params){
		 
		$.ajax({
			url: url,  
			type:'POST', 
			data:  params,
			success:function(msg) {
				var d = $.parseJSON(msg);
				if(d.success){
					 
				}
				infos(d.msg);
				return true;
			},
			error:function(result){
				return false;
			}
		}); 
	};
	
	$.codingol.post = function(url, params, callback){
		$.ajax({
			url: url,  
			type:'POST', 
			processData:true,
			data: params,
			success:function(msg) {
				var d = $.parseJSON(msg);
				if(d.success){
					if(callback)
						callback(msg);
				}
				infos(d.msg);
				return true;
			},
			error:function(result){
				return false;
			}
		}); 
	};
	
	$.codingol.dataGridFormatUrl = function(val, row){
		console.log(val);
		if (val < 30){
			return '<span style="color:red;">('+val+')</span>';
		} else {
			return val;
		}
	};
	
	 //translate {key} to value
	$.codingol.urlTranslate = function (url, type, items) {
		if(!items)
			return url;
    	var link  = url;
    	if(link){
    		var fields = url.match(/\{\w+\}/g);
    		if(fields && fields.length){
    			if(!items && type !="addchild"){
    				infos("请选择一条数据");
    				return;
    			}
    			$.each(fields, function(i, field){
    				link = link.replace(field, items[field.substring(1, field.length-1)]);
    			});
    		}
    		
    		if(type && (type == "addchild"|| type=="editchild" || type =="viewchild")){
    			if(items){
    				if(link.indexOf("?") > 0){
    					link += "&pid=" + items.id;
    				}else{
    					link += "?pid=" + items.id;
    				}
    			}
    		}
    	}
    	return link;
    };
    
    
    $.codingol.urlTimestamp = function (url){
         var getTimestamp=new Date().getTime();
         if(url.indexOf("?")>-1){
        	 url=url+"&s="+getTimestamp
         }else{
        	 url=url+"?s="+getTimestamp
         }
         return url;
    }
	
    
    $.codingol.datagrid = function(indexUrl){
    	$('.datagrid,.treegrid').each(function(){
        	var ths = $(this).find("th");
        	var singleselect  = $(this).data("singleselect");
        	if(ths && ths.length){
        		var treefield = $(this).data("treefield");
        		var models = new Array();
        		var querys = new Array();
        		var columns = new Array(); //所有显示列
        		$(ths).each(function(){
        			var f = $(this).data("field");
        			if(singleselect !== undefined && singleselect == false){
        				$(this).data("checkbox", true);
        				$(this).data("hidden", false);
        				singleselect = undefined;
        			}
        			$(this).data("title", $(this).text());
        			//width
        			if(!$(this).data("width")){
        				if(treefield &&  f == treefield){
        					$(this).data("width", 80);
        				}else{
        					$(this).data("width", $(this).width());
        				}
        			}
        			//formatter  url
        			var url = $(this).data("url");
        			if(url){
        				$(this).data("formatter", function(cellvalue, rowObject){
        					if(cellvalue)
        						return "<a href='javascript:void(0)' class='view-url'  data-title='"+cellvalue+"' data-url='"+$.codingol.urlTranslate(url, rowObject)+"'>"+cellvalue+"</a>";
        				});
        			}
        			//fotmatter 图片
        			var image = $(this).data("image");
        			if(image){
        				$(this).data("formatter", function(cellvalue, rowObject){
        					if(cellvalue)
        						return "<img src='../systemController/image.htm?path="+cellvalue+"'/>";
        				});
        			}
        			//formatter  编辑
        			var edit = $(this).data("edit");
        			if(edit){
        				$(this).data("formatter", function(cellvalue, rowObject){
        					return "<a href="+$.codingol.urlTranslate(edit, rowObject)+">编辑</a>";
        				});
        			}
        			
        			//查询条件
        			if($(this).data("query")){
        				var q = {};
        				q["field"] = $(this).data("field");
        				q["title"] = $(this).data("title");
        				q["hidden"] = $(this).data("hidden");
        				querys.push(q);
        			}
        			
        			if(f != "ol-methods")
        				columns.push(f);
        			
        			models.push($(this).data());
        		});
        		
        		var defaults = $.extend({}, {
        			url : '',
        			fit : true,
        			fitColumns:true,
        			queryParams:{fields:columns.join(",")},
        			border : false,
        			loadMsg: "数据加载中，请稍后...",
        			pagination : true,
        			idField : 'id',
        			pageSize : 20,
        			pageList : [10, 20, 30, 40, 50],
        			sortOrder:'asc', 
        			singleselect:true,
        			rownumbers:true,
        			nowrap : false,
        			selectid:-1,
        			onClickRow:function(index, row){
        				if(!treefield){
        					if($(this).datagrid('options').singleselect){
        						if($(this).datagrid('options').selectid == index){
            						$(this).datagrid('unselectRow', index);
            						$(this).datagrid('options').selectid = -1;
            					}
            					else
            						$(this).datagrid('options').selectid = index;
        					} 
        				}else{
        					if($(this).treegrid('options').singleselect){
        						if($(this).treegrid('options').selectid == index.id){
            						$(this).treegrid('unselect', index.id);
            						$(this).treegrid('options').selectid = -1;
            					}
            					else
            						$(this).treegrid('options').selectid = index.id;
        					}
        				}
        				
        			},
        			onLoadSuccess:function(data){
        				$(".view-url").click(function(){
        					$.codingol.form.init("view", $(this).data("title"), $(this).data("url"));
        				});
        			},
        			columns: [models]
               }, $(this).data());
        		
        	   $(this).empty();
        	   
        	   if($(this).hasClass("treegrid")){
        		   $.codingol.grid = $(this).treegrid(defaults);
        		   $.codingol.grid.type = "treegrid";
        	   }else{
        		   $.codingol.grid = $(this).datagrid(defaults);
        		   $.codingol.grid.type = "datagrid";
        	   }
        	   
        	   if($(this).data("toolbar")){
	           	   $.codingol.toolbar($(this).data("toolbar"), indexUrl);
	           	   $.codingol.listQuery($(this).data("toolbar"), querys);
	           }
        	}
        });
    };
     
    
    $.codingol.listQuery = function(toolbar, querys){
    	if(querys && querys.length){
    		var i = 0, n = 0;
    		var tr;
    		var listform = $("<div class='listform'></form>");
    		var table  = $("<table class='listquerytable'></table>");
    		$(querys).each(function(){
    			
    			if(i % $.codingol.length == 0){
    				if(i != 0){
    					$(table).append(tr);
    				}
    				i=0; 
    				tr = $("<tr></tr>");
    			}
    			
    			if(!this.hidden){
    				i++;
    				n++;
    				tr.append("<td class='label'>"+this.title+"</td>");
    				var input = $("<input type='text'  name="+this.field+"  />");
    				$(input).keydown(function(e){if(e.which ==13){ $.codingol.toolbar.query(toolbar); }});
    				if(n == querys.length && querys.length > $.codingol.length && i !=$.codingol.length){
    					var colspan = ($.codingol.length - i) * 2 + 1;
    					tr.append($("<td colspan='"+colspan+"'></td>").append(input));
    				}
    				else
    					tr.append($("<td></td>").append(input));
    				
    			}else{
    				$(listform).append("<input type='hidden'  name="+this.field+"  />");
    				n++;
    			}
    		});
    		
    		$(table).append(tr);
    		$(listform).append(table);
    		$(toolbar).prepend(listform);
    	}
    };
    
    $.codingol.toolbar = function(toolbar, indexUrl){
    	$(toolbar).find("[action]").each(function(){
    		$(this).click(function(){
    			var text = $(this).text().trim();
    			var field = $(this).attr("action");
    			if(field){
	    			field = field.replace(/'/gm, "\"");
	    			field = field.replace(/:/gm, "\":");
	    			field = field.replace(/,/gm, ",\"");
	    			 
	    			var actions = jQuery.parseJSON("{\""+field+"}");
	    			
	    			var params = {};
	    			var fields = actions.grid;
	    			var row = $.codingol.grid.datagrid('getChecked');
	    			if(!fields){
	    				fields = "id";
	    			}
        			if(fields){
        				if(row && row.length){
        					$(fields.split(',')).each(function(){
        						var f = {};
        						var v = new Array();
        						var that = this;
        						$(row).each(function(){
        							v.push(this[that]);
        						});
        						f[this] =  v.join(",");
        						params = $.extend({}, params, f);
        					});
        				}
        			}
        			if(actions.url){
        				indexUrl = actions.url;
        			}
        			
        			if(actions.method == "query"){
        				$.codingol.toolbar.query(toolbar);
        			}else if(actions.method == "recycle"){
        				$.codingol.toolbar.recycle(toolbar, this);
        			}else if(actions.method == "ajax"){
        				$.codingol.post(indexUrl, params, function(){
        					if($.codingol.grid.type == "datagrid"){
    	    					$.codingol.grid.datagrid('reload');
    	    				}else{
    	    					$.codingol.grid.treegrid('reload');
    	    				}
        				});
	        		}else if(actions.method == "delete"){
	        			indexUrl = indexUrl.substring(0, indexUrl.lastIndexOf("/"));
	        			indexUrl += "/delete.htm";
	        			confirm("你确定要删除所选的"+row.length+"条数据吗？", function(){
	        				$.codingol.post(indexUrl, params, function(){
	        					if($.codingol.grid.type == "datagrid"){
	    	    					$.codingol.grid.datagrid('reload');
	    	    				}else{
	    	    					$.codingol.grid.treegrid('reload');
	    	    				}
	        				});
	        			});
	        		}else if(actions.method == "select"){ //选择页面 选择按钮
	        			if(!row || !row.length){
	        				infos("请选择一第数据");
	        				return false;
	        			}
	        			var dg = getParentDialog();
	        			if(!dg){
	        				dg = frameElement.api.opener;
	        			}
	        			if(row.length == 1){
	        				var map = $(this).data("map");
	        				var kv = map.split(",");
	        				$(kv).each(function(){
	        					var k = this.split(":");
	        					$("input[name='"+k[0]+"']", dg.document).val(row[0][k[1]]);
	        					$("textarea[name='"+k[0]+"']", dg.document).val(row[0][k[1]]);
	        					$("select[name='"+k[0]+"']", dg.document).val(row[0][k[1]]);
	        				});
	        			}
	        			frameElement.api.close();
	        		}else if(actions.method == "addgrid"){//多对多添加
	        			$.codingol.form.addgrid = true; 
	        			var d = selectwindow(text, indexUrl);
	        		}else{
	        			if(row && row.length > 1){
	        				infos("只能选择一条数据进行操作");
	        				return false;
	        			}
	        			
	        			$.codingol.form.init(actions.method, text, indexUrl, row, params);
	        		}
    			}
    		});
    	});
    }
    $.codingol.toolbar.query = function(toolbar){
    	if($.codingol.grid.type == "datagrid"){
    		var queryParams = $.codingol.grid.datagrid('options').queryParams;
    		$(toolbar).find(':input').each(function() {
    			queryParams[$(this).attr('name')] = $(this).val();
    		});
    		
    		$.codingol.grid.datagrid('reload');
    	}else{
    		var queryParams = $.codingol.grid.treegrid('options').queryParams;
    		$(toolbar).find(':input').each(function() {
    			queryParams[$(this).attr('name')] = $(this).val();
    		});
    		
    		$.codingol.grid.treegrid('reload');
    	}
    };
   
    $.codingol.toolbar.recycle = function(toolbar, button){
    	if($.codingol.grid.status == undefined || $.codingol.grid.status == 1){
    		$.codingol.grid.status = 0;
			var queryParams = $.codingol.grid.datagrid('options').queryParams;
			$(toolbar).find(':input').each(function() {
				queryParams[$(this).attr('name')] = $(this).val();
			});
			queryParams["status"] = 0;  //0： 数据删除
			$.codingol.grid.datagrid('reload');
			
			$(button).find(".l-btn-text").text("返回");
			var recycle = $(button).find(".icon-recycle");
			recycle.text("返回");
			recycle.removeClass("icon-recycle").addClass("icon-back");
			
		}else{
			$.codingol.grid.status = 1;
			var queryParams = $.codingol.grid.datagrid('options').queryParams;
			$(toolbar).find(':input').each(function() {
				queryParams[$(this).attr('name')] = $(this).val();
			});
			queryParams["status"] = undefined;
			$.codingol.grid.datagrid('reload');
			
			$(button).find(".l-btn-text").text("回收站");
			var back = $(button).find(".icon-back");
			back.text("回收站");
			back.removeClass("icon-back").addClass("icon-recycle");
		}
    };
	
	$.codingol.form.init = function(type, text, url, rows, params){
		if(!url) return;
		if(type){
			if(type=="edit"){
				url = url.substring(0, url.lastIndexOf("/"));
				url = url+"/edit.htm?id={id}";
			}else if(type=="add"){
				url = url.substring(0, url.lastIndexOf("/"));
				url = url+"/edit.htm";
			}else if(type == "view"){
				url = url.substring(0, url.lastIndexOf("/"));
				url = url+"/view.htm?id={id}";
			}
		}
		
		url = $.codingol.urlTranslate(url, type, rows[0]);
		var qentity = {};
		
		if(url.indexOf("?")>0){
			var qs = url.substring(url.indexOf("?")+1);
			if(qs){
				$(qs.split("&")).each(function(){
					var q  = this.split("=");
					qentity[q[0]] = q[1];
				});
			}
		}
		url  = $.codingol.urlTimestamp(url);
		$.codingol.form.title = text;
		$.codingol.form.url = url;
		$.codingol.form.bindUrl = url.replace(".htm", "data.htm");
		$.codingol.form.saveUrl = url.replace(".htm", "save.htm")
		$.codingol.form.saveUrl = $.codingol.form.saveUrl.substring(0, $.codingol.form.saveUrl.indexOf("?"));
		
		var d;
		if(type && type == "view"){
			d = viewindow(text, url);
		}else{
			d = defaultwindow(text, url);
			if(type.indexOf("_max") > 0){
				d.max();
			}
			if(type == "children"){
				d.max();
			}
		}
		
		if(type &&  type == "edit" ){
			$.codingol.get($.codingol.form.bindUrl, null, function(msg){
				d.iframe.onload = function(){
					$.codingol.form.bind(d.iframe.contentWindow, $.parseJSON(msg));
				};
			});
		}else if(type && type == "view"){
			$.codingol.get($.codingol.form.bindUrl.replace("viewdata.htm", "editdata.htm"),null, function(msg){
				d.iframe.onload = function(){
					$.codingol.form.bind(d.iframe.contentWindow, $.parseJSON(msg));
				};
			});
		}else if(type && type == "addchild"){ //树形 添加子节点
			if(rows && rows.length){
				var treefield = $.codingol.grid.treegrid('options').treefield;
				d.iframe.onload = function(){
					$.codingol.form.bind(d.iframe.contentWindow, qentity);
					$('.pid', d.iframe.contentWindow.document).show();
					$("input[name='pid']", d.iframe.contentWindow.document).val(rows[0].id);
					$('.pid p', d.iframe.contentWindow.document).text(rows[0][treefield]);
					var level = $.codingol.grid.treegrid("getLevel", rows[0].id);
					$("input[name='level']", d.iframe.contentWindow.document).val(level + 1);
					$("input[name='parentname']", d.iframe.contentWindow.document).val(rows[0][treefield]);
					$("input[name='state']", d.iframe.contentWindow.document).val(1);
				};
			}else{
				d.iframe.onload = function(){
					$.codingol.form.bind(d.iframe.contentWindow, qentity);
					$('.pid', d.iframe.contentWindow.document).remove();
					$("input[name='state']", d.iframe.contentWindow.document).val(1);
					$("input[name='level']", d.iframe.contentWindow.document).val(1);
				}
			}
		}else if(type &&  type == "editchild" ){
			$.codingol.get($.codingol.form.bindUrl, null, function(msg){
				d.iframe.onload = function(){
					$.codingol.form.bind(d.iframe.contentWindow, $.parseJSON(msg));
				};
			});
		}else{
			d.iframe.onload = function(){
				$.codingol.form.bind(d.iframe.contentWindow, qentity);
			};
		}
	};
	
	//form 表单绑定
	$.codingol.form.bind = function(frame, entity){
    	$('[codingform]', frame.document).each(function(){
    		$.codingol.form.codingform = this;
    		if(entity)
    			$(this).form("load", entity); 
    		
    		$.codingol.form.enableUpload(frame);
    	});
	};
	
	//确定按钮执行事件
	$.codingol.form.submit = function(dialog){
		if($.codingol.form.codingform && dialog.iframe.contentWindow.valid()){
			$.codingol.post($.codingol.form.saveUrl, $($.codingol.form.codingform).serialize(), function(){
				if($.codingol.grid.type == "datagrid"){
					$.codingol.grid.datagrid('reload');
				}else{
					$.codingol.grid.treegrid('reload');
				}
				dialog.close();
			});
		}else if($.codingol.form.select.object){
			var map = $($.codingol.form.select.object).data("map");
			$(".select-button", dialog.iframe.contentWindow.document).each(function(){
				$(this).attr("data-map", map);
				$(this).click();
			});
		}else if($.codingol.form.addgrid){ //grid选择并添加。
			$(".select-button", dialog.iframe.contentWindow.document).each(function(){
				$(this).click();
			});
		}
		return false;
	};
	
	//dialog close
	$.codingol.form.close = function(){
		if($.codingol.form.addgrid){
			if($.codingol.grid.type == "datagrid"){
				$.codingol.grid.datagrid('reload');
			}else{
				$.codingol.grid.treegrid('reload');
			}
		}
		return true;
	};
	
	$.codingol.enhance = function(indexUrl){
		 
		 $.codingol.datagrid(indexUrl);
	};
	
	//form 表单选择按钮绑定
	$.codingol.form.select = function(){
		$('.select-table .glyphicon-search').each(function(){
    		 $(this).click(function(){
    			 var url = $(this).data("url");
    			 if(url){
    				 $.codingol.form.select.object = this;
    				 var d = selectwindow("", url);
    			 }
    		 });
    	});
		
	};
	
	$.codingol.form.enableUpload = function(iframe){
		//图片上传
		$('.image-upload', iframe.document).each(function(){
	    	var that = this;
	    	
	    	var img = $(that).find(".icon");
	    	var p = $(that).find('.progress');
	    	var path = $(that).find(".form-control").val();
	    	 
	    	if(path){
	    		$(img).attr("src", "../systemController/image.htm?path="+path);
	    	}else{
	    		$(img).hide();
	    	}
	    	$(p).hide();
	    	$(that).find(".fileupload").fileupload({
		        url: $(this).data("url"),
		        dataType: 'json',
		        done: function (e, data) {
		            $(img).attr("src", "../systemController/image.htm?path="+data.result.msg)
		            $(img).show();
		            $(that).find(".form-control").val(data.result.msg);
		        },
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $(that).find('.progress-bar').css(
		                'width',
		                progress + '%'
		            );
		            $(p).show();
		        }
		    });
	    });
	}
	
	$(function () {
		$.codingol.form.select();
		$.codingol.enhance();
		$('[data-toggle="tooltip"]').tooltip();
    });
}(jQuery);


$(function(){
	$("#login").click(function(){
		var submit = true;
		$("input[nullmsg]").each(function() {
			if ($(this).val() == "") { 
				$.messager.alert('提示', $(this).attr("nullmsg"), 'info');
				submit = false;
				return false;
			}
		});
		
		if (submit) { 
			var b = new Base64();  
			var p  = $("#password").val();
			 
			$.ajax({
				url : "homeController/login.htm",
				type : 'post',
				data : {
					 number: $("#number").val(),
					 password: b.encode(p)
				},
				success : function(data) {
					var d = $.parseJSON(data);
					if (!d.success) {
						$.messager.alert('提示', d.msg, 'info');
					}else{
						window.location='homeController/main.htm';
					}
				}
			});
		}
		
	});
	
	

	function Base64() {
		// private property
		_keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
	 
		// public method for encoding
		this.encode = function (input) {
			var output = "";
			var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
			var i = 0;
			input = _utf8_encode(input);
			while (i < input.length) {
				chr1 = input.charCodeAt(i++);
				chr2 = input.charCodeAt(i++);
				chr3 = input.charCodeAt(i++);
				enc1 = chr1 >> 2;
				enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
				enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
				enc4 = chr3 & 63;
				if (isNaN(chr2)) {
					enc3 = enc4 = 64;
				} else if (isNaN(chr3)) {
					enc4 = 64;
				}
				output = output +
				_keyStr.charAt(enc1) + _keyStr.charAt(enc2) +
				_keyStr.charAt(enc3) + _keyStr.charAt(enc4);
			}
			return output;
		}
	 
		// public method for decoding
		this.decode = function (input) {
			var output = "";
			var chr1, chr2, chr3;
			var enc1, enc2, enc3, enc4;
			var i = 0;
			input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
			while (i < input.length) {
				enc1 = _keyStr.indexOf(input.charAt(i++));
				enc2 = _keyStr.indexOf(input.charAt(i++));
				enc3 = _keyStr.indexOf(input.charAt(i++));
				enc4 = _keyStr.indexOf(input.charAt(i++));
				chr1 = (enc1 << 2) | (enc2 >> 4);
				chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
				chr3 = ((enc3 & 3) << 6) | enc4;
				output = output + String.fromCharCode(chr1);
				if (enc3 != 64) {
					output = output + String.fromCharCode(chr2);
				}
				if (enc4 != 64) {
					output = output + String.fromCharCode(chr3);
				}
			}
			output = _utf8_decode(output);
			return output;
		}
	 
		// private method for UTF-8 encoding
		_utf8_encode = function (string) {
			string = string.replace(/\r\n/g,"\n");
			var utftext = "";
			for (var n = 0; n < string.length; n++) {
				var c = string.charCodeAt(n);
				if (c < 128) {
					utftext += String.fromCharCode(c);
				} else if((c > 127) && (c < 2048)) {
					utftext += String.fromCharCode((c >> 6) | 192);
					utftext += String.fromCharCode((c & 63) | 128);
				} else {
					utftext += String.fromCharCode((c >> 12) | 224);
					utftext += String.fromCharCode(((c >> 6) & 63) | 128);
					utftext += String.fromCharCode((c & 63) | 128);
				}
	 
			}
			return utftext;
		}
	 
		// private method for UTF-8 decoding
		_utf8_decode = function (utftext) {
			var string = "";
			var i = 0;
			var c = c1 = c2 = 0;
			while ( i < utftext.length ) {
				c = utftext.charCodeAt(i);
				if (c < 128) {
					string += String.fromCharCode(c);
					i++;
				} else if((c > 191) && (c < 224)) {
					c2 = utftext.charCodeAt(i+1);
					string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
					i += 2;
				} else {
					c2 = utftext.charCodeAt(i+1);
					c3 = utftext.charCodeAt(i+2);
					string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
					i += 3;
				}
			}
			return string;
		}
	}
	
	
});


