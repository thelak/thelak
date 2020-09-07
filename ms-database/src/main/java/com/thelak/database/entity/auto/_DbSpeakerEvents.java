package com.thelak.database.entity.auto;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import com.thelak.database.entity.DbSpeaker;

/**
 * Class _DbSpeakerEvents was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DbSpeakerEvents extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<Long> ID_EVENT = Property.create("idEvent", Long.class);
    public static final Property<DbSpeaker> EVENT_TO_SPEAKER = Property.create("eventToSpeaker", DbSpeaker.class);

    public void setIdEvent(long idEvent) {
        writeProperty("idEvent", idEvent);
    }
    public long getIdEvent() {
        Object value = readProperty("idEvent");
        return (value != null) ? (Long) value : 0;
    }

    public void setEventToSpeaker(DbSpeaker eventToSpeaker) {
        setToOneTarget("eventToSpeaker", eventToSpeaker, true);
    }

    public DbSpeaker getEventToSpeaker() {
        return (DbSpeaker)readProperty("eventToSpeaker");
    }


}