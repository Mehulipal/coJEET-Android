package com.example.mevscovid.ui;

public class Members {

    String mid;
    String mname;
    String mgenre;

    public Members(){}

    public Members(String mId, String mname, String mgenre)
    {
        this.mid = mId;
        this.mname = mname;
        this.mgenre = mgenre;
    }

    public String getMId(){return mid;}
    public String getMname(){return mname;}
    public String getMgenre(){return mgenre;}

}
