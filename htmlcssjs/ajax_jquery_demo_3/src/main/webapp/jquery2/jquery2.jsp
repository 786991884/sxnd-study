<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<title>Insert title here</title>
</head>
<body>
	<p>I would like to say:</p>
	<b class="foo">Hello</b>
	<b class="foo">Good Bye</b>
	<div></div>
	<div></div>
	<div class="container">
		<div class="inner first">Hello</div>
		<div class="inner second">And</div>
		<div class="inner third">Goodbye</div>
	</div>
	<script type="text/javascript">
		$("p").append("<b>hello</b>");
		$("p").appendTo("div");
		//前置一些代码
		$("p").prepend("<b>hello</b>");
		//将一个dom元素前置入所有段落
		$("p").prepend($(".foo")[0]);
		//向所有段落中前置一个Jquery对象
		$("p").prepend($("b"));
		//把所有段落追加到ID值为foo的元素中。
		$("p").prependTo('#foo');
		//在所有段落之后插入一些HTML标记代码
		$("p").after("<b>hello</b>");
		//在所有段落之后插入一个DOM元素
		$("p").after($("b"));
		//在所有段落之前插入一些HTML标记代码
		$("p").before("<b>hello</b>");
		//在所有段落之前插入一个元素
		$("p").before($("#foo")[0]);
		//在所有段落中前插入一个jQuery对象
		$("p").before($("b"));
		//把所有段落插入到一个元素之后
		$("P").insertAfter("#foo");
		//把所有段落插入到一个元素之前
		$("p").insertBefore("#foo");
		//把所有的段落用一个新创建的div包裹起来
		$("P").wrap("<div class='wrap'></div>");
		//用ID是"content"的div将每一个段落包裹起来
		$("p").wrap(document.getElementById("content"));
		//用原先div的内容作为新div的class，并将每一个元素包裹起来
		$('.inner').wrap(function() {
			return '<div class="' + $(this).text() + '"/>';
		});
		//用ID是"content"的div将每一个段落包裹起来
		$("p").unwrap();
		//用一个生成的div将所有段落包裹起来
		$("p").wrapAll("<div></div>");
		//用一个生成的div将所有段落包裹起来
		$("p").wrapAll(document.createElement("div"));
		//把所有段落内的每个子内容加粗
		$("P").wrapInner("<b></b>");
		$("P").wrapInner(document.createElement("b"));
		//把所有的段落标记替换成加粗的标记
		$("P").replaceWith("<b>paragraph</b>");
		//用第一段替换第三段，你可以发现他是移动到目标位置来替换，而不是复制一份来替换
		$('.third').replaceWith($('.first'));
		//把所有的段落标记替换成加粗标记
		$("<b>paragraph</b>").replaceAll("p");
		//把所有段落的子元素（包括文本节点）删除
		$("p").empty();
		//从DOM中把所有段落删除
		$("p").remove();
		$("p").detach();
		//从DOM中把带有hello类的段落删除
		$("p").remove(".hello");
		$("p").detach(".hello");
		//克隆所有b元素（并选中这些克隆的副本），然后将它们前置到所有段落中
		$("b").clone().prependTo("p");
		//创建一个按钮，他可以复制自己，并且他的副本也有同样功能
		$("button").click(function() {
			$(this).clone(true).insertAfter(this);
		});
	</script>
</body>
</html>