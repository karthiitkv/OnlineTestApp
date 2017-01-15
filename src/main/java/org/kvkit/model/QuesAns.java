package org.kvkit.model;

import javax.xml.bind.annotation.XmlRootElement;

// Generated 15 Oct, 2013 10:47:56 PM by Hibernate Tools 3.2.1.GA



/**
 * QuesAns generated by hbm2java
 */
@XmlRootElement
public class QuesAns  implements java.io.Serializable {


     private Integer queId;
     private String question;
     private String opt1;
     private String opt2;
     private String opt3;
     private String opt4;
     private String ans;
     private Integer difficultLevel;
     private Integer attempts;
     private Integer answered;

    public QuesAns() {
    }

	
    public QuesAns(String question) {
        this.question = question;
    }
    public QuesAns(String question, String opt1, String opt2, String opt3, String opt4, String ans, Integer difficultLevel, Integer attempts, Integer answered) {
       this.question = question;
       this.opt1 = opt1;
       this.opt2 = opt2;
       this.opt3 = opt3;
       this.opt4 = opt4;
       this.ans = ans;
       this.difficultLevel = difficultLevel;
       this.attempts = attempts;
       this.answered = answered;
    }
   
    public Integer getQueId() {
        return this.queId;
    }
    
    public void setQueId(Integer queId) {
        this.queId = queId;
    }
    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOpt1() {
        return this.opt1;
    }
    
    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }
    public String getOpt2() {
        return this.opt2;
    }
    
    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }
    public String getOpt3() {
        return this.opt3;
    }
    
    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }
    public String getOpt4() {
        return this.opt4;
    }
    
    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }
    public String getAns() {
        return this.ans;
    }
    
    public void setAns(String ans) {
        this.ans = ans;
    }
    public Integer getDifficultLevel() {
        return this.difficultLevel;
    }
    
    public void setDifficultLevel(Integer difficultLevel) {
        this.difficultLevel = difficultLevel;
    }
    public Integer getAttempts() {
        return this.attempts;
    }
    
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }
    public Integer getAnswered() {
        return this.answered;
    }
    
    public void setAnswered(Integer answered) {
        this.answered = answered;
    }




}


