package com.example.mevscovid.ui;

public class Members {

    String mId;
    String mname;
    String mgenre;

    public Members(){}

    public Members(String mId, String mname, String mgenre)
    {
        this.mId = mId;
        this.mname = mname;
        this.mgenre = mgenre;
    }

    public String getMId(){return mId;}
    public String getMname(){return mname;}
    public String getMgenre(){return mgenre;}

}
