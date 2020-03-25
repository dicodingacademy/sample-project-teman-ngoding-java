package com.dicoding.sampletemanngoding.model;

public class User {
    public Long id;
    public String user_id;
    public String line_id;
    public String display_name;

    public User(Long aId, String aUserId, String aLineId, String aDisplayName)
    {
        id=aId;
        user_id=aUserId;
        line_id=aLineId;
        display_name=aDisplayName;
    }

    public User() {

    }
}
