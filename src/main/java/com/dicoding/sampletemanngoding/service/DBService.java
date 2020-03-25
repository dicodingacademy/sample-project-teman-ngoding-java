package com.dicoding.sampletemanngoding.service;

import com.dicoding.sampletemanngoding.database.Dao;
import com.dicoding.sampletemanngoding.model.JointEvents;
import com.dicoding.sampletemanngoding.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DBService {
    @Autowired
    private Dao mDao;

    //method mendaftarkan LINE ID
    public int regLineID(String aUserId, String aLineId, String aDisplayName){
        if(findUser(aUserId) == null)
        {
            return mDao.registerLineId(aUserId, aLineId, aDisplayName);
        }

        return -1;
    }

    //method untuk mencari user terdaftar di database
    public String findUser(String aUserId){
        List<User> self=mDao.getByUserId("%"+aUserId+"%");

        if(self.size() > 0)
        {
            return self.get(0).line_id;
        }

        return null;
    }

    //method untuk bergabung dalam event
    public int joinEvent(String eventID, String userId, String lineID, String displayname){
        JointEvents joinedEvent = isUserJoinedEvent(eventID, userId);

        if(joinedEvent == null) {
            return mDao.joinEvent(eventID, userId, lineID, displayname);
        }

        return -1;
    }

    //method untuk cek apakah sudah join event
    private JointEvents isUserJoinedEvent(String eventID, String userID){
        List<JointEvents> result = mDao.getByJoin(eventID, userID);

        if (result.size() > 0) {
            return result.get(0);
        }

        return null;
    }

    //method untuk melihat teman terdaftar di dalam suatu event
    public List<JointEvents> getJoinedEvent(String eventID){
        return mDao.getByEventId(eventID);
    }
}
