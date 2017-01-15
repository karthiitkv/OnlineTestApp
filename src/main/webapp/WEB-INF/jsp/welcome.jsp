
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html><head><title>KVKIT-SAT-Index Page</title>
        <%@ page language="java" %>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<script type="text/javascript">
var error="";
function mailval()
{
	mail=document.forms.login.email.value;
	if(mail==null || mail=="")
	{
		alert("Please Enter valid Employee Id");
		error+="error1";
		document.forms.login.email.value="";
		document.forms.login.email.focus();
		//alert(error);
		return false;
	}
	 //error="";
	 if(pwdcheck())
		return true;
	else return false;
}
function pwdcheck()
{
	//if(error!="") document.forms.login.email.focus();
	charval=document.forms.login.pwd.value;//alert(char);
	if(charval==null || charval=="")
	{
		alert("Please enter your Password");
		error="error1";
		document.forms.login.pwd.focus();
		document.forms.login.pwd.value="";
		return false;
	}
	if(validate())
		return true;
	else return false;

}

function checkValues()
{
    var form = document.getElementById("indexForm");
    var name = form.name.value;
    var mail = form.email.value;
    if(name=='' || mail=='')
        {
            alert("Enter Name and Email Id to proceed");
            return false;
        }
    else
        {
            form.dispatch.value = "loadTestPage";
            form.submit();
        }
}

function validate()
{
	//mailval();
	//pwdcheck();
	/*if(error==null || error=="")
	{*/
		uname=document.forms.login.email.value;
		pwd=document.forms.login.pwd.value;
		
		return true;
	//}
	/*alert("The user name or password you enter is incorrecet\n please verify it");
	//document.forms.login.email.value="";
	document.forms.login.pwd.value="";
	return false;*/
}
</script>

<style type="text/css">
body
{
	margin: 0% 0%;
        background-color:lightgreen;
}

.header
{
	color:blue;
	background-color:darkturquoise;
	text-align:center;
	font-family:"Times New Roman", times, sans-serif;
	font-size:300%;
        padding :20px
	/*text-shadow:5px 5px 5px blue;*/
}
.header sub
{
	font-size:20%;
}

.left
{

	background-color:lightgreen;
	float:left;
	width:50%;
}
.leftcont
{
	padding:10%;
	text-align:justify;
	text-indent:35px;
        
}
h4
{
	text-indent:0px;
}
.right
{
	/*color:blue;*/
	width:50%;
	background-color:lightgreen;
	float:right;
	
}
.rightcont
{
	padding:10%;
        /*border: brown groove 1px;*/
	/*text-align:center;*/
}
.ret
{
    text-align: center;
}
fieldset
{
    /*color :black;*/
	padding:10%;
}
.footer
{
	color:blue;
	background-color:gold;
	text-align:center;
}
input:focus
{
	background-color:yellow;
}
a:link
{
	color:red;
	text-decoration:none;
}
a:hover
{
	color:red;
	background-color:blue;
}
.msg
{
    color: red;    
}
</style>

</head>
<body>
    <html:form action="/index" styleId="indexForm">
<div class="whole">
	<div class="header">
			Self Assessment Test<sub></sub>	</div>
	<div class="body">
		<div class="left">
		<div class="leftcont">
                    <b><h4>Welcome to <b>Self Assessment Test</b>,</h4></b>
					<p>This is the Application used to Assess your general knowledge by yourself. I have did this for sample based on your interest the application will be developed to full fledged mode.
					<p>Set of questions given in the test page, After completion of test, the marks and answers will be displayed to you for your assessment
					<p>The question set can be changed frequently, there are so many features in this application. We have make so many things as easily configurable through user interfaces.
                                        <p>We are welcoming your queries and feedbacks, please mail us to the mail id <b>karthiitkv@gmail.com</b></p>
					<p>Enter your Name and email provided in next section to start the test.
		</div>
		</div>
		<div class="right">
		<div class="rightcont">
			<div>
				<b><h4>Enter the below details to proceed test</h4></b>
				<table cellspacing="2">
				<tr><td>Name:</td><td><input type="text" name="name" id="name"/></td></tr>
				<tr><td>E-Mail:</td><td><input type="text" name="email" id="email"/></td></tr>
                                <tr><td  colspan="2" align="centre"><input type="button" name="StartTest" style="align:center" value="Start Test" onclick="checkValues()"></input></td></tr>
				<table>
				
				<br/>
				<ol type="1"><b>Instructions:</b>
				<li>Please provide correct email id.
				<li>Total numbers of questions to attend is 10
				<li>Each questions carries 1 mark
				<li>Time allocated for the test is 2 min
				<li>After completion of 2 min, your test will be submitted automatically.
				<li>The Marks history will be displayed to you after completion of test.
			</div>				
                                            
		</div>
		</div>
	</div>
</div>
<div class="footer" style="width:100%">KVKIT &#9400; 2013</div>
        <html:hidden property="dispatch" styleId="dispatch"/>
</html:form>
</body>

</html>
