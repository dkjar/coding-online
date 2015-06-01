 
<ul id="menu" ></ul>
<SCRIPT type="text/javascript">
		<!--
		$(document).ready(function(){
			 var mtree = $('#menu').tree({
		          url:'../homeController/menudata.htm',
		          queryParams:{id:"${first.id}"},
		          onClick:function(node){
		               if(node && node.functionurl){
		               		$("#mainPanle").panel({region:"center", href:node.functionurl + "?functionid="+node.id, onLoad: function(){
								$.codingol.enhance(node.functionurl);
							}}); 
		               }
		          }
		     });
		     
		     $("#nav .item").each(function(){
		     	$(this).click(function(){
		     		var params =  $(mtree).tree("options").queryParams;
		     		params.id = $(this).data("id")
		     		$(mtree).tree('reload');
		     	});
		     });
		});
		//-->
	</SCRIPT>