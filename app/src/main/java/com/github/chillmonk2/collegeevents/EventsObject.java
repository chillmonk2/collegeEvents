package com.github.chillmonk2.collegeevents;

public class EventsObject {
    public String eOrganiser;
    public String eDate;
    public String eDesc;
    public String eLink=null;

    public int eImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    boolean heartLiked = true;
    public int eLikes;
    public EventsObject(String eOrganiser, String eDate, String eDesc, String eLink, int eImageResourceId, int eLikes)
    {
        this.eOrganiser = eOrganiser;
        this.eDate = eDate;
        this.eDesc = eDesc;
        this.eLink = eLink;
        this.eImageResourceId = eImageResourceId;
        this.eLikes = eLikes;
    }

    String geteOrganiser(){ return eOrganiser;}
    String geteDate(){ return eDate;}
    String geteDesc(){ return eDesc;}
    String geteLink(){ return eLink;}
    int geteImageResourceId(){ return eImageResourceId;}
    int geteLikes(){ return eLikes;}
    boolean hasImage(){
        if(eImageResourceId == NO_IMAGE_PROVIDED)
            return false;
        else
            return  true;
    }
    void setHeartLiked(boolean heartState)
    {
        if(heartState == true)
            heartLiked = true;
        else
            heartLiked = false;
    }
    boolean hasLiked()
    {
        if(heartLiked==true)
            return  true;
        else
            return false;
    }


}
