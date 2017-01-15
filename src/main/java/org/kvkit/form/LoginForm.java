/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kvkit.form;

import java.util.Collection;

/**
 *
 * @author dell
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String name;
    private String email;
    private int id;
    private String attendedDate;
    private String marks;
    private String dispatch;
    private Collection markColl;
    private Collection quesColl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttendedDate() {
        return attendedDate;
    }

    public void setAttendedDate(String attendedDate) {
        this.attendedDate = attendedDate;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getDispatch() {
        return dispatch;
    }

    public void setDispatch(String dispatch) {
        this.dispatch = dispatch;
    }

    public Collection getMarkColl() {
        return markColl;
    }

    public void setMarkColl(Collection markColl) {
        this.markColl = markColl;
    }

    public Collection getQuesColl() {
        return quesColl;
    }

    public void setQuesColl(Collection quesColl) {
        this.quesColl = quesColl;
    }
    
}
