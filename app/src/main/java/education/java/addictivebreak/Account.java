package education.java.addictivebreak;

public class Account {
    String fullname, email, pass, d, m, y, s, ay, t, starting;
    String mental, physical, spiritual, sexualhealth;

    private Account(){}


    public Account(String fullname, String email, String pass, String d, String m, String y, String s, String ay, String t, String starting, String mental, String physical, String spiritual, String sexualhealth) {
        this.fullname = fullname;
        this.email = email;
        this.pass = pass;
        this.d = d;
        this.m = m;
        this.y = y;
        this.s = s;
        this.ay = ay;
        this.t = t;
        this.starting = starting;
        this.mental = mental;
        this.physical = physical;
        this.spiritual = spiritual;
        this.sexualhealth = sexualhealth;
    }

    public String getMental() {
        return mental;
    }

    public void setMental(String mental) {
        this.mental = mental;
    }

    public String getPhysical() {
        return physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical;
    }

    public String getSpiritual() {
        return spiritual;
    }

    public void setSpiritual(String spiritual) {
        this.spiritual = spiritual;
    }

    public String getSexualhealth() {
        return sexualhealth;
    }

    public void setSexualhealth(String sexualhealth) {
        this.sexualhealth = sexualhealth;
    }

    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }
}
