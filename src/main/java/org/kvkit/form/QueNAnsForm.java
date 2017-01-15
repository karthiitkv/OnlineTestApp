/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kvkit.form;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author dell
 */
public class QueNAnsForm extends org.apache.struts.action.ActionForm {
    
    private String name;
    private int userId;
    private String email;
    private Collection markColl;
    private Collection quesColl;

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }
    /**
     *
     */
    public QueNAnsForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
