<%-- 
    Document   : iterate
    Created on : 14 Oct, 2013, 2:13:37 PM
    Author     : dell
--%>

<%@ page language="java" %>
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%
    java.util.ArrayList list = new java.util.ArrayList();
        
        
 pageContext.setAttribute("list", request.getAttribute("list"),
        PageContext.PAGE_SCOPE);
%>

<logic:iterate id="myCollectionElement" name="list" indexId="currentIndexId">
    <p><bean:write name="currentIndexId"/>.<bean:write name="myCollectionElement" property="question" /></p>
    <input type="radio" name="myCollectionElement<bean:write name="currentIndexId"/>" id="id<bean:write name="currentIndexId"/>1" value='<bean:write name="myCollectionElement" property="opt1" />'><bean:write name="myCollectionElement" property="opt1" /></input>
    <input type="radio" name="myCollectionElement<bean:write name="currentIndexId"/>" id="id<bean:write name="currentIndexId"/>2" value='<bean:write name="myCollectionElement" property="opt2" />'><bean:write name="myCollectionElement" property="opt1" /></input>
    <%--<html:radio indexed="true" name="myCollectionElement" property="opt1" idName="myCollectionElement" styleId="myCollectionElement1" value="opt1"  />
    <html:radio indexed="true" name="myCollectionElement" property="opt2" idName="myCollectionElement" styleId="myCollectionElement2" value="opt2"/>
    <%--<bean:write name="myCollectionElement" property="question" />
 Answer : <bean:write name="myCollectionElement" property="opt1"/>--%>
 <br />
</logic:iterate>
