<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Parser page</title>
</head>
<body>
Please select parse to get data:
<form action="PageController" method="get">
<input type="hidden" name="command" value="xmlparser" />
<input type="radio" id="parserType1" name="xmlParserType" value="DOM" />
<label for="parserType1">DOM</label>
<input type="radio" id="parserType2" name="xmlParserType" value="SAX" />
<label for="parserType2">SAX</label>
<input type="radio" id="parserType3" name="xmlParserType" value="StAX" />
<label for="parserType3">StAX</label>
<br/>
<input type="submit" name="PageController" value="Get xml content" />
</form>
</body>
</html>