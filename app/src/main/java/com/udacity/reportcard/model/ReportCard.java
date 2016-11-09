package com.udacity.reportcard.model;

/**
 * Created by geovani on 08/11/16.
 */

public class ReportCard {

    public final String id;
    private int mImage;
    private String mGrade;
    private String mContent;
    private String mDetails;


    public ReportCard(String id, int image, String grade, String content, String details) {
        this.id  = id;
        mImage   = image;
        mGrade   = grade;
        mContent = content;
        mDetails = details;
    }


    @Override
    public String toString() {
        return mContent;
    }


    public int getImage() {
        return mImage;
    }

    public String getGrade() {
        return mGrade;
    }

    public String getContent() {
        return mContent;
    }

    public String getDetails() {
        return mDetails;
    }


    public void setImage(int image) {
        mImage = image;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public void setDetails(String details) {
        mDetails = details;
    }



}
