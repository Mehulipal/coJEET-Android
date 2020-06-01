package com.example.mevscovid.ui;

import com.google.gson.annotations.SerializedName;

public class PoliciesClass {

    private String title;
    @SerializedName("body")
    private String text;

   // private Integer mPolicy_image_id;

 //   private String mVisit_us;

  /**  public PoliciesClass(String Policy_name, String Policy_description, String Visit_us) {
        mPolicy_name = Policy_name;
        mPolicy_description = Policy_description;
        //mPolicy_image_id=Policy_image_id;
     //   mVisit_us=Visit_us;
    }**/


    public String getmPolicy_name() {
        return title;
    }
    public String getmPolicy_description() {
        return text;
    }


    /**public Integer getmPolicy_image_id(){
        return mPolicy_image_id;
    }**/

  /**  public String getmVisit_us() {
        return mVisit_us;
    }**/
}