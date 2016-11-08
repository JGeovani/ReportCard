package com.udacity.reportcard.model;

/**
 * Created by geovani on 08/11/16.
 */

public class ReportCard {

    public final String id;
    public final int image;
    public final String grade;
    public final String content;
    public final String details;


    public ReportCard(String id, int image, String grade, String content, String details) {
        this.id      = id;
        this.image   = image;
        this.grade   = grade;
        this.content = content;
        this.details = details;
    }


    @Override
    public String toString() {
        return content;
    }



}
