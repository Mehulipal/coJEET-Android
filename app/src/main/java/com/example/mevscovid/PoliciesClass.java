package com.example.mevscovid;

public class PoliciesClass {

    private String mPolicy_name;

    private String mPolicy_description;

   // private Integer mPolicy_image_id;

    private String mVisit_us;

    public PoliciesClass(String Policy_name, String Policy_description, String Visit_us) {
        mPolicy_name = Policy_name;
        mPolicy_description = Policy_description;
        //mPolicy_image_id=Policy_image_id;
        mVisit_us=Visit_us;
    }


    public String getmPolicy_name() {
        return mPolicy_name;
    }
    public String getmPolicy_description() {
        return mPolicy_description;
    }

    /**public Integer getmPolicy_image_id(){
        return mPolicy_image_id;
    }**/

    public String getmVisit_us() {
        return mVisit_us;
    }
}