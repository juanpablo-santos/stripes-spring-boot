<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
  <title>My First Stripe</title>
  <style type="text/css">
    input.error { background-color: yellow; }
  </style> 
</head>
<body>
<h1>File Upload sample</h1>
 
Hi, let's try to read some uploaded file!
 
<stripes:form beanclass="net.sourceforge.stripes.examples.springboot.actionbeans.FileUploadActionBean" focus="">
<stripes:errors/> 
    <table>
        <tr>
            <td>Select file to upload</td>
            <td><stripes:file name="attachment"/> </td>
        </tr>
        <tr>
            <td colspan="2">
                <stripes:submit name="uploadFile" value="Upload"/>
            </td>
        </tr>
        <tr>
            <td>Result:</td>
            <td>${actionBean.fileName}</td>
        </tr>
    </table>
</stripes:form>
</body>
</html>     