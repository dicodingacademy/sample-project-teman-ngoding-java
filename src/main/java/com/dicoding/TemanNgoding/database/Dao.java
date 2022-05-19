package com.dicoding.TemanNgoding.database;

import com.dicoding.TemanNgoding.model.JointEvents;
import com.dicoding.TemanNgoding.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Dao {
    List<User> get();

    List<User> getByUserId(String aUserId);

    int registerLineId(String aUserId, String aLineId, String aDisplayName);

    int joinEvent(String aEventId, String aUserId, String aLineId, String aDisplayName);

    List<JointEvents> getEvent();

    List<JointEvents> getByEventId(String aEventId);

    List<JointEvents> getByJoin(String aEventId, String aUserId);
}