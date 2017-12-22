<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.lbk.bean.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>home</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.7.2/css/amazeui.css"/>
  <link rel="stylesheet" type="text/css" href="http//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
  <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
  <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
  <script type="text/javascript" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
  <style>
    @media only screen and (min-width: 641px) {
      .am-offcanvas {
        display: block;
        position: static;
        background: none;
      }

      .am-offcanvas-bar {
        position: static;
        width: auto;
        background: none;
        -webkit-transform: translate3d(0, 0, 0);
        -ms-transform: translate3d(0, 0, 0);
        transform: translate3d(0, 0, 0);
      }
      .am-offcanvas-bar:after {
        content: none;
      }

    }

    @media only screen and (max-width: 640px) {
      .am-offcanvas-bar .am-nav>li>a {
        color:#ccc;
        border-radius: 0;
        border-top: 1px solid rgba(0,0,0,.3);
        box-shadow: inset 0 1px 0 rgba(255,255,255,.05)
      }

      .am-offcanvas-bar .am-nav>li>a:hover {
        background: #404040;
        color: #fff
      }

      .am-offcanvas-bar .am-nav>li.am-nav-header {
        color: #777;
        background: #404040;
        box-shadow: inset 0 1px 0 rgba(255,255,255,.05);
        text-shadow: 0 1px 0 rgba(0,0,0,.5);
        border-top: 1px solid rgba(0,0,0,.3);
        font-weight: 400;
        font-size: 75%
      }

      .am-offcanvas-bar .am-nav>li.am-active>a {
        background: #1a1a1a;
        color: #fff;
        box-shadow: inset 0 1px 3px rgba(0,0,0,.3)
      }

      .am-offcanvas-bar .am-nav>li+li {
        margin-top: 0;
      }
    }

    .my-head {
      margin-top: 40px;
      text-align: center;
    }

    .my-button {
      position: fixed;
      top: 0;
      right: 0;
      border-radius: 0;
    }
    .my-sidebar {
      padding-right: 0;
      border-right: 1px solid #eeeeee;
    }

    .my-footer {
      border-top: 1px solid #eeeeee;
      padding: 10px 0;
      margin-top: 10px;
      text-align: center;
    }
    .a-hide{
    	display: none;
    }
    .operation{
    	position: absolute;
    	right: 20px;
    	height: 30px;
    	top: 17px;
    }
    #myBlog li:hover .operation{
    	display: block;
    }
  </style>
</head>
<body>
<header class="am-g my-head">
  <div class="am-u-sm-12 am-article">
    <h1 class="am-article-title">山寨微博系统</h1>
  </div>
</header>
<hr class="am-article-divider"/>
<div class="am-g am-g-fixed">
<input id="logID" type="hidden" value="<%=request.getAttribute("id") %>">

	<!-- sidebar start -->
  <div class="am-u-md-3 my-sidebar">
    <div class="am-offcanvas" id="sidebar">
      <div class="am-offcanvas-bar">
      	<div class="am-panel am-panel-primary" style="height: 50px; text-align: center; line-height: 50px;">
  				xxx
      	</div>
        <ul class="am-nav">
          <li id="one" class="am-active"><a href="javascript:void(0)">最新博客</a></li>
          <!-- <li id="two"><a href="javascript:void(0)">我的信息</a></li> -->
          <li id="three"><a href="javascript:void(0)">好友列表</a></li>
          <li id="four"><a href="javascript:void(0)">我的博客</a></li>
          <li id="five"><a href="javascript:void(0)">发布博客</a></li>
        </ul>
      </div>
    </div>
  </div>
	<!-- sidebar end -->
  <div class="am-u-md-9">
    <div class="am-g">
      <div class="am-u-sm-11 am-u-sm-centered">
        <div class="am-cf am-article">
        	<!-- new blog start -->
           <div id="newBlog">
        		<ul class="am-list am-list-border" id="nb_ul"></ul>
        		<div id="pages">
        			<select id="ss"></select>
        		</div>
        	</div>
          <!-- new blog end -->
          <!-- blog content start -->
          <div id="blogContent" class="a-hide">
          	<!-- <button class="am-btn am-btn-secondary" id="backNewBlog"><——</button> -->
          	<ol class="am-breadcrumb">
			  <li><a href="javascript:void(0);" id="backNewBlog">最新博客</a></li>
			  <li class="am-active">博客文章</li>
			</ol>
			<div class="am-article">
			    <p class="am-article-meta">发布人：<b id="person"></b>	<a class="am-badge am-badge-primary" title="关注" style="margin-left: 20px;">+</a></p>
			    <p>
			    	<span class="am-badge am-badge-default" id="time"></span>
			    </p>
			  	<hr/>
			  	<div><p id="in_content"></p></div>
				<hr/>
				<div id="coment_panel"></div>
	         </div>
          </div>
          <!-- blog content end -->
          <!-- friends start -->
          <div id="friends" class="a-hide"></div>
          <!-- friends end -->
          <!-- my blog start -->
          <div id="myBlog" class="a-hide">
          	<ul class="am-list am-list-border">
	          	<li>
	          		<a href="#" class="am-text-truncate">
	          			博客文章<br/>
									<span class="am-badge am-badge-default">2017-12-18</span>
	          		</a>
	          		<div class="operation a-hide">
	          			<div class="am-btn-group">
	          				<button class="am-btn am-btn-primary am-btn-sm">
	          					<span class="am-icon-pencil"></span>
	          					edit
	          				</button>
	          				<button class="am-btn am-btn-danger am-btn-sm">
	          					<span class="am-icon-trash"></span>
	          					delete
	          				</button>	          			
	          			</div>
	          		</div>
	          	</li>
	          	<li>
	          		<a href="#" class="am-text-truncate">
	          			博客文章<br/>
									<span class="am-badge am-badge-default">2017-12-18</span>
	          		</a>
	          		<div class="operation a-hide">
	          			<div class="am-btn-group">
	          				<button class="am-btn am-btn-primary am-btn-sm">
	          					<span class="am-icon-pencil"></span>
	          					edit
	          				</button>
	          				<button class="am-btn am-btn-danger am-btn-sm">
	          					<span class="am-icon-trash"></span>
	          					delete
	          				</button>	          			
	          			</div>
	          		</div>
	          	</li>
	          	<li>
	          		<a href="#" class="am-text-truncate">
	          			博客文章<br/>
									<span class="am-badge am-badge-default">2017-12-18</span>
	          		</a>
	          		<div class="operation a-hide">
	          			<div class="am-btn-group">
	          				<button class="am-btn am-btn-primary am-btn-sm">
	          					<span class="am-icon-pencil"></span>
	          					edit
	          				</button>
	          				<button class="am-btn am-btn-danger am-btn-sm">
	          					<span class="am-icon-trash"></span>
	          					delete
	          				</button>	          			
	          			</div>
	          		</div>
	          	</li>
	          	<li>
	          		<a href="#" class="am-text-truncate">
	          			博客文章<br/>
									<span class="am-badge am-badge-default">2017-12-18</span>
	          		</a>
	          		<div class="operation a-hide">
	          			<div class="am-btn-group">
	          				<button class="am-btn am-btn-primary am-btn-sm">
	          					<span class="am-icon-pencil"></span>
	          					edit
	          				</button>
	          				<button class="am-btn am-btn-danger am-btn-sm">
	          					<span class="am-icon-trash"></span>
	          					delete
	          				</button>	          			
	          			</div>
	          		</div>
	          	</li>
	          </ul>
          </div>
          <!-- my blog end -->
          <!-- publish blog -->
          <div id="publishBlog" class="a-hide">
          	<div class="am-tab-panel">
		          <form class="am-form" action="pubWeibo.do" method="POST">
		          	<input type="hidden" name="id" value="<%=request.getAttribute("id") %>">
		            <div class="am-g am-margin-top-sm">
		              <div class="am-u-sm-12 am-u-md-2 am-text-right admin-form-text">
		               		 内容描述
		              </div>
		              <div class="am-u-sm-12 am-u-md-10">
		                <textarea id="pubContent" name="content" rows="10" placeholder="请使用富文本编辑插件"></textarea>
		              </div>
		            </div>
		            <div class="am-g am-margin-top-sm">
		            	<div class="am-u-sm-12 am-u-md-10 am-u-md-push-2">
		                <button id="publish" class="am-btn am-btn-primary" type="submit">发布</button>
		              </div>
		            	
		            </div>

		          </form>
		        </div>
          </div>
          <!-- publish blog -->
        </div>
      </div>
	</div>
  </div>
</div>

<footer class="my-footer">
  <p>This system is free for studying and working<br><small>© Copyright XXX. by the 凉白开团队.</small></p>
</footer>

<script type="text/javascript" src="http://cdn.amazeui.org/amazeui/2.7.2/js/amazeui.js"></script>
<script type="text/javascript">

	var id = $("#logID").val();
	
	console.log(id)
	
	var global_new_blog;


	function getInContent(p_id) {
		$("#newBlog").hide();
		$("#blogContent").show();
		// article details
		$.ajax({
			url: "viewWeibo.do",
			type: "POST",
			data: {
				"pid": p_id
			},
			success: function(data) {
				// data = eval(data);
				console.log(data);
				data = JSON.parse(data);
				console.log(data);
				console.log(111);
				$("#person").html(data[0]['name']);
				$("#time").html(data[0]['date']);
				$("#content").html(data[0]['content']);
			},
			error: function() {
				console.log("getInContent error");
			}
			
		});
		// comment
		/*
		$.ajax({
			url: "",
			type: "POST",
			data: {
				"id": id,
				"pid": p_id
			},
			success: function(data) {
				data = eval(data);
				$("#comment_user").html(data['name']); // 评论者名字
				$("#comment_date").html(data['date']); // 评论时间
				$("#comment_content").html(data['content']); // 评论内容
				
				$("#comment_panel").html("");
				var length = data.length;
				for (var i=0; i<length; i++ ) {
					var item = '<article class="am-comment">\
									  <a href="javascript:void(0)">\
							    <p id="comment_user">'+data[i]["name"]+'</p>\
							  </a>\
							  <div class="am-comment-main">\
							    <header class="am-comment-hd">\
							      <div class="am-comment-meta">\
							        <a href="#link-to-user" class="am-comment-author">..</a>\
							        评论于 <p id="comment_date">'+data[i]["date"]+'</p>\
							      </div>\
							    </header>\
							    <div class="am-comment-bd"><p id="comment_content">'+data[i]["content"]+'</p></div>\
							  </div>\
							</article>';
				}
				
			},
			error: function() {
				console.log("getInContent error");
			}
			
		});
		*/
	}
	$("#backNewBlog").click(function(){
		$("#newBlog").show();
		$("#blogContent").hide();
	});
	$("#one").click(function(){
		$(".am-nav li").removeClass("am-active");
		$(this).addClass("am-active")
		$("#newBlog").show();
		$("#myMsg").hide();
		$("#friends").hide();
		$("#myBlog").hide();
		$("#publishBlog").hide();
		$("#blogContent").hide();
	});
	$("#two").click(function(){
		$(".am-nav li").removeClass("am-active");
		$(this).addClass("am-active")
		$("#newBlog").hide();
		$("#myMsg").show();
		$("#friends").hide();
		$("#myBlog").hide();
		$("#publishBlog").hide();
		$("#blogContent").hide();
	});
	$("#three").click(function(){
		$(".am-nav li").removeClass("am-active");
		$(this).addClass("am-active")
		$("#newBlog").hide();
		$("#myMsg").hide();
		$("#friends").show();
		$("#myBlog").hide();
		$("#publishBlog").hide();
		$("#blogContent").hide();
	});
	$("#four").click(function(){
		$(".am-nav li").removeClass("am-active");
		$(this).addClass("am-active")
		$("#newBlog").hide();
		$("#myMsg").hide();
		$("#friends").hide();
		$("#myBlog").show();
		$("#publishBlog").hide();
		$("#blogContent").hide();
	});
	$("#five").click(function(){
		$(".am-nav li").removeClass("am-active");
		$(this).addClass("am-active")
		$("#newBlog").hide();
		$("#myMsg").hide();
		$("#friends").hide();
		$("#myBlog").hide();
		$("#publishBlog").show();
		$("#blogContent").hide();
	});
	
	
	getNewBlog();
	function getNewBlog() {
		$.ajax({
			url: "lastestWbArticle.do",
			type: "GET",
			success: function(data) {
				data = eval(data);
				console.log(data);
				global_new_blog = data;
				var num = data.length / 10;
				$("#ss").html("");
				for ( var i=1; i<=num; i++ ) {
					$("#ss").append("<option name='"+i+"'>"+i+"</option>");
				}
				var length = (data.length<10) ? data.length :10; 
				for ( var i=0; i<length; i++ ) {
					var li = '<li>\
		          		<a href="javascript:void(0)" onclick="getInContent('+data[i]['id']+')" class="am-text-truncate">\
          					'+data[i]["content"]+'\
          					<span class="am-badge am-badge-secondary am-fr">'+data[i]["browsertime"]+'</span>\
          					<br/>\
								<span class="am-badge am-badge-default">'+data[i]["date"]+'</span>\
			          		</a>\
			          	</li>';
					$("#nb_ul").append(li);
					
				}
			},
			error: function() {
				console.log("error");
			}
		});
		
	}

	$("#ss").change(function(){
		var index = $(this).val();
		$("#nb_ul").html("");
		for ( var i = (index-1)*10; i<index*10; i++ ) {
			var li = '<li>\
          		<a href="javascript:void(0)" onclick="getInContent('+global_new_blog[i]['id']+')" class="am-text-truncate">\
  					'+global_new_blog[i]["content"]+'\
  					<span class="am-badge am-badge-secondary am-fr">'+global_new_blog[i]["browsertime"]+'</span>\
  					<br/>\
						<span class="am-badge am-badge-default">'+global_new_blog[i]["date"]+'</span>\
	          		</a>\
	          	</li>';
			$("#nb_ul").append(li);
		}
	});
	
	getFriends();
	
	function getFriends() {
		$.ajax({
			url: "getFriendVector.do",
			type: "POST",
			data: {
				"id": id
			},
			success: function(data) {
				data = eval(data);				
				$("#friends").html("");
				var length = (data.length<10) ? data.length :10; 
				for ( var i=0; i<length; i++ ) {
					var panel = '<div class="am-u-md-3">\
			          		<div class="am-panel" style="box-shadow: 0 0 3px #ddd; border: 1px solid #ddd;">\
			          			<div class="am-panel-bd">\
			          				'+data[i]["name"]+'\
			          			</div>\
			          		</div>\
			          	</div>'
					$("#friends").append(panel);
					
				}
			},
			error: function() {
				console.log("error");
			}
		});
	}
	
	/* $("#publish").click(function(){
		$.ajax({
			url: "pubWeibo.do",
			type: "POST",
			data: {
				"id": id,
				"content": $("#pubContent").val()
			},
			success: function() {
				// window.location.href = "login.do";
			},
			error: function() {
				// window.location.href = "login.do";
				
			}
		});
	}); */

	// $("#blogTable").DataTable();
</script>
</body>
</html>