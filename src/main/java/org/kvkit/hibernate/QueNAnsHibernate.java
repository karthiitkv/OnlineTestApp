/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kvkit.hibernate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.kvkit.model.Marks;
import org.kvkit.model.QuesAns;
import org.kvkit.model.Users;

/**
 *
 * @author dell
 */
public class QueNAnsHibernate {

    private static SessionFactory factory;
    
    public Collection getQueNAns() {
        Collection col = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            col = session.createQuery("FROM QuesAns where display=true").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return col ;
    }
    
    public Collection getAllQueNAns(String queryString) {
    	System.out.println("Query - "+queryString);
        Collection col = null;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            col = session.createQuery(queryString).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return col ;
    }
    
    public HashMap getUserAndMarks(String name,String email)
    {
        HashMap map = new HashMap();
        Collection col = null;
        Users usr = null;
        List userList;
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            userList = session.createQuery("FROM Users where email = '"+email+"'").list();
            if(userList.isEmpty())
            {
                usr = new Users();
                usr.setUserName(name);
                usr.setEmail(email);
                session.save(usr);
            }
            else
            {
                usr = (Users) userList.get(0);
                System.out.println("usr.getusername --> "+usr.getUserName());
                if(!name.equalsIgnoreCase(usr.getUserName()))
                {
                    usr.setUserName(name);
                    session.clear();
                    session.update(usr);
                }
            }
            col = session.createQuery("FROM Marks where userId="+usr.getUserId()).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        map.put("marksCol", col);
        map.put("userId", (int)usr.getUserId());
    return map ;
    }

    public void setMarks(Marks marks) {
        factory = HibernateUtil.getSessionFactory();
        System.out.println("In Marks Save Method");
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(marks);
            tx.commit();
            System.out.println("Marks Saved");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
        
    public void saveOrUpdateQueAns(List<QuesAns> quesAnss) {
    	factory = HibernateUtil.getSessionFactory();
        System.out.println("In quesAnss Save Method");
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Iterator<QuesAns> itr = quesAnss.iterator();
            while(itr.hasNext()) {
            	session.saveOrUpdate(itr.next());
            }
            tx.commit();
            System.out.println("Marks Saved");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void deleteQueAns(String queIds) {
    	factory = HibernateUtil.getSessionFactory();
        System.out.println("queIds value - "+queIds);
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //Iterator<Integer> itr = queIds.iterator();
            /*QuesAns que;
            while(itr.hasNext()) {
            	que = new QuesAns();
            	que.setQueId(itr.next());
            	session.delete(que);
            }*/
            org.hibernate.Query q = session.createQuery("delete QuesAns where queId = "+queIds);
            q.executeUpdate();

            tx.commit();
            System.out.println("Marks Saved");
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
