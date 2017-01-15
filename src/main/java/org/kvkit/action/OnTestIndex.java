/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kvkit.action;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kvkit.form.LoginForm;
import org.kvkit.form.QueNAns;
import org.kvkit.hibernate.QueNAnsHibernate;
import org.kvkit.model.Marks;
import org.kvkit.model.QuesAns;

/**
 *
 * @author dell
 */
public class OnTestIndex extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String INDEX = "index";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception 
    {
        LoginForm lform = (LoginForm) form;
        System.out.println("dispatch --> "+lform.getDispatch());
        System.out.println("name --> "+lform.getName());
        System.out.println("email --> "+lform.getEmail());
        if("loadTestPage".equals(lform.getDispatch()))
        {
            return loadTestPage(mapping,form,request,response);
        }
        if("setMarks".equals(lform.getDispatch()))
        {
            return markUpdate(mapping,form,request,response);
        }
        java.util.ArrayList list = new java.util.ArrayList();
        QueNAns qa = new QueNAns();
        qa.setQuestion("q1");
        qa.setOpt1("op1");
        list.add(qa);
        qa = new QueNAns();
        qa.setQuestion("q2");
        qa.setOpt1("op2");
        list.add(qa);
//        list.add("First");
// list.add("Second");
//
//        list.add("Third"); 
// list.add("Fourth");
// list.add("Fifth");
        request.setAttribute("list", list);
        System.out.println("index page executed");
        return mapping.findForward(INDEX);
    }

    private ActionForward loadTestPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        LoginForm lform = (LoginForm) form;
        System.out.println("dispatch --> "+lform.getDispatch());
        System.out.println("name --> "+lform.getName());
        System.out.println("email --> "+lform.getEmail());
        QueNAnsHibernate qHiber = new QueNAnsHibernate();
        Collection queList = qHiber.getQueNAns();
        QueNAns que;
//        System.out.println("queList --> "+queList.size());
//        for (Iterator it = queList.iterator(); it.hasNext();) {
//            QuesAns obj = (QuesAns) it.next();
//            que = new QueNAns();
//            System.out.println("que --> "+obj.getQuestion());
//            que.setQuestion(obj.getQuestion());
//            que.setOpt1(obj.getOpt1());
//            que.setOpt2(obj.getOpt2());
//            que.setOpt3(obj.getOpt3());
//            que.setOpt4(obj.getOpt4());
//            que.setAns(obj.getAns());
//        }
        
        HashMap markList = qHiber.getUserAndMarks(lform.getName(), lform.getEmail());
        
        //QueNAns que = new QueNAns();
        /*que.setQuestion("What is the National Animal of India?");
        que.setOpt1("Peacock");
        que.setOpt2("Tiger");
        que.setOpt3("Cheetah");
        que.setOpt4("Pegion");
        que.setAns("Tiger");
        queList.add(que);
        que = new QueNAns();
        que.setQuestion("What is the National bird of India?");
        que.setOpt1("Peacock");
        que.setOpt2("Tiger");
        que.setOpt3("Cheetah");
        que.setOpt4("Pegion");
        que.setAns("Tiger");
        queList.add(que);*/
        lform.setQuesColl(queList);
        lform.setMarkColl((Collection) markList.get("marksCol"));
        int id;
        id = (Integer)markList.get("userId");
        lform.setId(id);
        return mapping.findForward("quenans");
    }
    private ActionForward markUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        try {
            LoginForm lform = (LoginForm) form;
            System.out.println("dispatch --> "+lform.getDispatch());
            System.out.println("name --> "+lform.getName());
            System.out.println("email --> "+lform.getEmail());
            Marks marks = new Marks();
            marks.setUserId(lform.getId());
            marks.setMarks(Integer.valueOf(lform.getMarks()));
            marks.setAttendedDate(new Date());
            QueNAnsHibernate qHiber = new QueNAnsHibernate();
            qHiber.setMarks(marks);
            String subject = "KVK IT Online Test Result";
            String content = "Dear <b>"+lform.getName()+"</b>,<br/>"
                    + "<br/>You have scores <b>"+lform.getMarks()+"</b> marks from our online test application.<br/>"
                    + "<br/>Thank you for showing interest with us. Please visit again.<br/>"
                    + "<br/>Regards,<br/>Karthikeyan.K<br/>Admin.";
            String[] sendTo = {lform.getEmail()};
			SendMailG3.sendSSLMessage(sendTo, subject,content);
            System.out.println("Sucessfully Sent mail to All Users");
            
        } catch (MessagingException ex) {
            Logger.getLogger(OnTestIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
