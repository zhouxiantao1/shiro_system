<!doctype html public "-//w3c//dtd html 4.01 transitional//en" "http://www.w3.org/tr/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>new document</title>
<script>
	//xxbh:学校编号，bjbh:班级编号,xx：姓名

	
	var arrjson1= new Array();
	var arrjson2= new Array();
	var arrjson3= new Array();
	
	function creatmapbyxxbh() {
		
		var newarrjson1= [
				    {"name":"A","name1":"A","name2":"A","text":"1"},
				    {"name":"A","name1":"A","name2":"B","text":"2"},
				    {"name":"A","name1":"A","name2":"C","text":"3"},
				    {"name":"A","name1":"B","name2":"A","text":"4"},
				    {"name":"A","name1":"B","name2":"B","text":"5"},
				    {"name":"A","name1":"B","name2":"C","text":"6"}
			    ];
		var newarrjson2= [
					{"name":"A"},
					{"name":"B"},
					{"name":"C"}
		   	    ];
		var newarrjson3= [
					{"name":"A"},
					{"name":"B"},
					{"name":"C"}
		   	    ];
		
		if(arrjson1.length == 0){
			arrjson1 = newarrjson1;
		}
		if(arrjson1.length == 0){
			arrjson1 = newarrjson2;
		}
		if(arrjson1.length == 0){
			arrjson1 = newarrjson3;
		}
		
		
		var oldStr= new Array();

		var str = "<table border='1'>";
		var n = 0;
		for (var i = 0; i < arrjson1.length; i++) {
			var len = 1;
			if(arrjson2.length != 0 && arrjson3.length != 0){
				len = arrjson2.length * arrjson3.length;
			}else if(arrjson2.length != 0){
				len = arrjson2.length
			}
			str += "<tr><td width='200' rowspan='"+len+"'>" + arrjson1[i].name
					+ "</td>";
			var strr = "<tr><td width='200' rowspan='"+len+"'>" + arrjson1[i].name + "</td>"; 
			if(arrjson2.length != 0 ){
				for (var j = 0; j < arrjson2.length; j++) {
					console.log("2"+arrjson2.length);
					str += "<td width='200' rowspan='"+arrjson3.length+"'>" + arrjson2[j].name
							+ "</td>";
					var jstrr = "";
					var jstr = "<td width='200' rowspan='"+arrjson3.length+"'>" + arrjson2[j].name
							+ "</td>";
					jstrr = strr + jstr;
					if(arrjson3.length != 0){
						for (var k = 0; k < arrjson3.length; k++) {
							console.log("3"+arrjson3.length);
							str += "<td width='200' rowspan='"+1+"'>" + arrjson3[k].name + "</td><td width='200'>test"+n+"</td></tr>";
							var kstr = "<td width='200' rowspan='"+1+"'>" + arrjson3[k].name + "</td><td width='200'>test"+n+"</td></tr>";
							n++; 
							oldStr.push(jstrr+kstr);
						}
					}else{
						str += "<td width='200'>test"+n+"</td></tr>";
						n++;
					}
				}
			}else{
				str += "<td width='200'>test"+n+"</td></tr>";
				n++;
			}
			
		}
		
		arrjson1 = newarrjson1;
		arrjson2 = newarrjson2;
		arrjson3 = newarrjson3;

		str += "</table> ";
		for(var t = 0;t<oldStr.length;t++){
			console.log(oldStr[t]+"</br>");
		}
		document.write(str)
	}
</script>
</head>
<body>
	<button onclick='creatmapbyxxbh()'>测试</button>
</body>
</html>