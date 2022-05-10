package com.dicoding.TemanNgoding.database;

import com.dicoding.TemanNgoding.model.JointEvents;
import com.dicoding.TemanNgoding.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.util.List;
import java.util.Vector;

public class DaoImpl implements Dao {
    //query untuk table user
    private final static String USER_TABLE = "tbl_user";
    private final static String SQL_SELECT_ALL = "SELECT id, user_id, line_id, display_name FROM " + USER_TABLE;
    private final static String SQL_GET_BY_USER_ID = SQL_SELECT_ALL + " WHERE LOWER(user_id) LIKE LOWER(?);";
    private final static String SQL_REGISTER = "INSERT INTO " + USER_TABLE + " (user_id, line_id, display_name) VALUES (?, ?, ?);";

    //query untuk table event
    private final static String EVENT_TABLE = "tbl_event";
    private final static String SQL_SELECT_ALL_EVENT = "SELECT id, event_id, user_id, line_id, display_name FROM " + EVENT_TABLE;
    private final static String SQL_GET_BY_EVENT_ID = SQL_SELECT_ALL_EVENT + " WHERE LOWER(event_id) LIKE LOWER(?);";
    private final static String SQL_GET_BY_JOIN = SQL_SELECT_ALL_EVENT + " WHERE event_id = ? AND user_id = ?;";
    private final static String SQL_JOIN_EVENT = "INSERT INTO " + EVENT_TABLE + " (event_id, user_id, line_id, display_name) VALUES (?, ?, ?, ?);";
    private final static ResultSetExtractor<User> SINGLE_RS_EXTRACTOR = resultSet -> {
        while (resultSet.next()) {
            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("user_id"),
                    resultSet.getString("line_id"),
                    resultSet.getString("display_name")
            );
        }

        return null;
    };
    private final static ResultSetExtractor<List<User>> MULTIPLE_RS_EXTRACTOR = aRs -> {
        List<User> list = new Vector<>();
        while (aRs.next()) {
            User p = new User(
                    aRs.getLong("id"),
                    aRs.getString("user_id"),
                    aRs.getString("line_id"),
                    aRs.getString("display_name"));
            list.add(p);
        }
        return list;
    };
    private final static ResultSetExtractor<JointEvents> SINGLE_RS_EXTRACTOR_EVENT = resultSet -> {
        while (resultSet.next()) {
            return new JointEvents(
                    resultSet.getLong("id"),
                    resultSet.getString("event_id"),
                    resultSet.getString("user_id"),
                    resultSet.getString("line_id"),
                    resultSet.getString("display_name"));
        }
        return null;
    };
    private final static ResultSetExtractor<List<JointEvents>> MULTIPLE_RS_EXTRACTOR_EVENT = resultSet -> {
        List<JointEvents> list = new Vector<>();
        while (resultSet.next()) {
            JointEvents jointEvents = new JointEvents(
                    resultSet.getLong("id"),
                    resultSet.getString("event_id"),
                    resultSet.getString("user_id"),
                    resultSet.getString("line_id"),
                    resultSet.getString("display_name"));
            list.add(jointEvents);
        }
        return list;
    };

    @Autowired
    private final JdbcTemplate mJdbc;

    @Autowired
    public DaoImpl(DataSource aDataSource) {
        mJdbc = new JdbcTemplate(aDataSource);
    }

    public List<User> get() {
        return mJdbc.query(SQL_SELECT_ALL, MULTIPLE_RS_EXTRACTOR);
    }

    public List<User> getByUserId(String aUserId) {
        return mJdbc.query(SQL_GET_BY_USER_ID, MULTIPLE_RS_EXTRACTOR, aUserId);
    }

    public int registerLineId(String aUserId, String aLineId, String aDisplayName) {
        return mJdbc.update(SQL_REGISTER, aUserId, aLineId, aDisplayName);
    }

    public int joinEvent(String aEventId, String aUserId, String aLineId, String aDisplayName) {
        return mJdbc.update(SQL_JOIN_EVENT, aEventId, aUserId, aLineId, aDisplayName);
    }

    public List<JointEvents> getEvent() {
        return mJdbc.query(SQL_SELECT_ALL_EVENT, MULTIPLE_RS_EXTRACTOR_EVENT);
    }

    public List<JointEvents> getByEventId(String aEventId) {
        return mJdbc.query(SQL_GET_BY_EVENT_ID, MULTIPLE_RS_EXTRACTOR_EVENT, aEventId);
    }

    public List<JointEvents> getByJoin(String aEventId, String aUserId) {
        return mJdbc.query(SQL_GET_BY_JOIN, MULTIPLE_RS_EXTRACTOR_EVENT, aEventId, aUserId);
    }
}
