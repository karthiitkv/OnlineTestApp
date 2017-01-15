<%-- 
    Document   : quenans
    Created on : 15 Oct, 2013, 7:05:00 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title id="title">KVKIT-SAT-Test Page</title>
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
        </style>
        <script type="text/javascript" src="../../WEB-INF/Scripts/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="../../WEB-INF/Scripts/quenans.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="http://jchavannes.com/include/scripts/3p/jquery.timer.js"></script>
        <script type='text/javascript' src="D:/Programming/JQuery References/timer-demo.js"></script>
        <script type="text/javascript">
            //alert("JQuery run successfull");
            /**
 * Example 4 is as simple as it gets.  Just a timer object and
 * a counter that is displayed as it updates.
 */
//var percent= 100/(30*1000);
//var value = 100;
/*var count = 10,
    timer = $.timer(function() {
        count--;
        value -= percent;
        $('#title').html('KVKIT-SAT-Test Page - Time Remaining <b>'+count+'<b> min');
        //$('#counter').html(''+count+'');
        //alert(value);
        $('div.timerDisplayBarReduce').css("width",value+"%");
		if(count==0)
		{
			timer.stop();
			//count = 30;
                        closeTest();
		}
    });
timer.set({ time : 1000, autostart : true });*/
            
            
            /**
 * Example 2 is similar to Example 1. Two things that are
 * different are counting down instead of up and allowing
 * user input for start time. Also, when the timer counts
 * down to zero, an alert is triggered.
 */
var Example2 = new (function() {

    var $countdown;
    var $form;
    var incrementTime = 100;
    var currentTime = 2*60*1000; //mm*60*1000 // 15000-5 minutes (in milliseconds)
    var percent= 100/(2*600); //100/(mm*600)to reduce width against time
    var value = 100;
    
    $(function() {

        // Setup the timer
        $countdown = $('#counter'); 
        Example2.Timer = $.timer(updateTimer, incrementTime, true);

        // Setup form
        $form = $('#example2form');
        $form.bind('submit', function() {
            Example2.resetCountdown();
            return false;
        });

    });

    function updateTimer() {

        // Output timer position
        var timeString = formatTime(currentTime);
        $countdown.html(timeString);
        value -= percent;
        $('div.timerDisplayBarReduce').css("width",value+"%");
        // If timer is complete, trigger alert
        if (currentTime == 0) {
            $('div.timerDisplay').html("Time exceeds. Your test has been submitted");
            closeTest();
//            alert('Example 2: Countdown timer complete!');
//            Example2.resetCountdown();
            return;
        }

        // Increment timer position
        currentTime -= incrementTime;
        if (currentTime < 0) currentTime = 0;

    }

    this.resetCountdown = function() {

        // Get time from form
        var newTime = parseInt($form.find('input[type=text]').val()) * 1000;
        if (newTime > 0) {currentTime = newTime;}

        // Stop and reset timer
        Example2.Timer.stop().once();

    };

});

// Common functions
function pad(number, length) {
    var str = '' + number;
    while (str.length < length) {str = '0' + str;}
    return str;
}

function formatTime(time) {
    time = time / 10;
    var min = parseInt(time / 6000),
		hr = parseInt(min / 60),
        sec = parseInt(time / 100) - (min * 60),
        hundredths = pad(time - (sec * 100) - (min * 6000), 2);
//    return (hr > 0 ? pad(hr, 2) : "00") +":" +  (min > 0 ? pad(min, 2) : "00") + ":" + pad(sec, 2) + ":" + hundredths;
    return (hr > 0 ? pad(hr, 2) : "00") +":" +  (min > 0 ? pad(min, 2) : "00") + ":" + pad(sec, 2);
}
            
            var marks=0;var ans='';
                var selected='';
            $(document).ready(function(){
              $("#subBut").click(function(){
                //alert("JQuery run successfull");
                closeTest();
              });
            });
            
            function closeTest()
            {
            $('input[type=radio]').prop("disabled",true);
            Example2.Timer.stop();
                for(var i=0;i<10;i++)
                    {
                        selected=$('input:radio[name=ans'+i+']:checked').val();
                        ans=$('input:hidden[name=selans'+i+']').val();
                        //alert(selected +" == "+ans);
                        if(selected==ans)
                        {
                            marks++;    
                        }
                    }
                    var xmlhttp;
                    xmlhttp=new XMLHttpRequest();
                    var dispatch="setMarks";
                    xmlhttp.open("GET","index.do?dispatch="+dispatch+"&marks="+marks,false);
                    xmlhttp.send();
                    $("div#marksDisplay").show();
                    $("div#ansBlock").show();
                    $("div#currentMark").text("You have scored "+marks+" marks in current test");
                    $("#subBut").hide();
                    alert("Thanks for attending test, You have scored "+marks+" marks\nWe are in process of upgrading the app.\nPlease visit frequently.");
            }
            
        </script>
    </head>
    <body>
        <html:form action="/index" styleId="form">
            <div id="timer" style="position: fixed">
            <div class="timerDisplayBar" style="text-align: center; background-color: yellow; float: right;position: fixed;width: 100%;font-size: large;">&nbsp;</div>
            <div class="timerDisplayBarReduce" style="text-align: center; background-color: orange; float:  left;position: fixed;width: 100%;font-size: large;">&nbsp;</div>
            <div class="timerDisplay" style="text-align: center; position: fixed;width: 100%;font-size: large;">Time Remaining <b><span id="counter"></span></b> (hh:mm:ss)</div>
            </div>s
        <div class="header">Self Assessment Test<sub></sub></div>
        
        <div class="body">
            <%--<logic:notEmpty name="LoginForm" property="markColl">--%>
                <div id="marksDisplay" style="display: none;padding-left: 30%;padding-right: 30%;">
                    <b><div id="currentMark"></div></b>
                    Your Previous Scores are,
                    <table border="1" style="border: 1;border-color: black;border-style: solid">
                        <thead><th>Date</th><th>Mark</th></thead>
                    <logic:notEmpty name="LoginForm" property="markColl">
                    <logic:iterate id="MarkCol" name="LoginForm" property="markColl" indexId="markIndexId">
                        
                            <tr>
                                <td><bean:write name="MarkCol" property="attendedDate" /></td>
                                <td><bean:write name="MarkCol" property="marks" /></td>
                            </tr>
                    </logic:iterate>
                            </logic:notEmpty>
                    </table>
            </div>
            <%--</logic:notEmpty>--%>
            <div id='queDisplay'>
                <div class="utilSpace" style="width: 20%;height: 100%;float: left;">
                    &nbsp;
                    <!--<div style="float: left;position: fixed">Time Remaining <b><span id="counter"></span></b> min</div>-->
                
            </div>
                <div class="quePart">
                <% int i=0;%>
                <table cellspacing="2" style="width: 60%">
                    
                    <logic:iterate id="LoginMarkCol" name="LoginForm" property="quesColl" indexId="currentIndexId">
                        <tr>
                            <% if(i%2==0){%>
                            <td style="background-color: bisque">
                            <%} else{%>
                            <td style="background-color: aqua">
                            <%}%>
                            <table>
                                <tr><td colspan="2"><%=++i%>) <b><bean:write name="LoginMarkCol" property="question" /></b><br/>
                                        <%--<logic:notEmpty name="LoginForm" property="markColl">--%>
                                <div id="ansBlock" style="display: none">
                                Ans : <bean:write name="LoginMarkCol" property="ans" />
                                </div>
                            <%--</logic:notEmpty>--%></td></tr>
                    <tr><td><input type="radio" name="ans<bean:write name="currentIndexId"/>" id="id<bean:write name="currentIndexId"/>1" value='<bean:write name="LoginMarkCol" property="opt1" />'><bean:write name="LoginMarkCol" property="opt1" /></input></td>
                        <td><input type="radio" name="ans<bean:write name="currentIndexId"/>" id="id<bean:write name="currentIndexId"/>2" value='<bean:write name="LoginMarkCol" property="opt2" />'><bean:write name="LoginMarkCol" property="opt2" /></input></td>
                    </tr>
                    <tr><td><input type="radio" name="ans<bean:write name="currentIndexId"/>" id="id<bean:write name="currentIndexId"/>3" value='<bean:write name="LoginMarkCol" property="opt3" />'><bean:write name="LoginMarkCol" property="opt3" /></input></td>
                        <td><input type="radio" name="ans<bean:write name="currentIndexId"/>" id="id<bean:write name="currentIndexId"/>4" value='<bean:write name="LoginMarkCol" property="opt4" />'><bean:write name="LoginMarkCol" property="opt4" /></input></td>
                    </tr>
                    <tr><td><input type="hidden" name='selans<bean:write name="currentIndexId"/>' id='id<bean:write name="currentIndexId"/>5' value='<bean:write name="LoginMarkCol" property="ans" />'></input></td></tr>
                    <!--<tr><td colspan="2">-----------------------------------------------------------------------------------------------------------------------------------</td></tr>-->
                    </table>
                </td></tr>
                    </logic:iterate>
                        <!--<tr><input type="button" id="subBut" name="subBut" value="Submit"/></tr>-->
                </table>
                </div>
                <!--<div class="utilSpace" style="width: 20%;height: 100%;float: right"></div>-->
        </div>
            </div>
                <div  style="padding-left: 20%;padding-right: 20%;"><input type="button" id="subBut" name="subBut" value="Submit" style="vertical-align: central"/></div>
                
                <html:hidden property="name" styleId="name"></html:hidden>
                <html:hidden property="email" styleId="email"></html:hidden>
                <html:hidden property="id" styleId="id"></html:hidden>
                <html:hidden property="dispatch" styleId="dispatch"></html:hidden>
        </html:form>
    </body>
</html>
