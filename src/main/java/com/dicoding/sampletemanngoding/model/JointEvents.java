package com.dicoding.sampletemanngoding.model;

public class JointEvents {
    public Long id;

    public String event_id;

    public String user_id;
    public String line_id;
    public String display_name;

    public JointEvents(Long aId, String aEventId, String aUserId, String aLineId, String aDisplayName)
    {
        id = aId;
        event_id = aEventId;
        user_id = aUserId;
        line_id = aLineId;
        display_name = aDisplayName;
    }

    public JointEvents()
    {

    }
}
