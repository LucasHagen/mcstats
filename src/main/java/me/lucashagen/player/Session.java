package me.lucashagen.player;

import java.util.concurrent.TimeUnit;

public class Session {

    private long startTime;
    private long endTime;

    public Session() {
        this(System.currentTimeMillis(), Long.MIN_VALUE);
    }

    public Session(long startTime) {
        this(startTime, Long.MIN_VALUE);
    }

    public Session(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Gets the time the session started/was created.
     *
     * @return Timestamp in milliseconds
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time of a session
     *
     * @param startTime Timestamp in MILLISECONDS
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the time the session ended.
     * If value == Long.MIN_VALUE: session is still active
     * value != Long.MIN_VALUE: session has already ended
     *
     * @return Timestamp in milliseconds
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of a Session.
     *
     * @param endTime Timestamp in MILLISECONDS
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * If the Session is active.
     *
     * @return If session is active
     */
    public boolean isActive() {
        return endTime == Long.MIN_VALUE;
    }

    /**
     * Gets the duration of a Session in MILLISECONDS.
     * If the Session is still active, 0 is returned.
     *
     * @return Duration in the specified unit
     */
    public long getDuration() {
        return getDuration(TimeUnit.MILLISECONDS);
    }

    /**
     * Gets the duration of a Session.
     * If the Session is still active, 0 is returned.
     *
     * @param unit Time unit to be used
     * @return Duration in the specified unit
     */
    public long getDuration(TimeUnit unit) {
        long duration = 0;

        if (!isActive()) {
            duration = unit.convert(endTime - startTime, TimeUnit.MILLISECONDS);
        }

        return duration;
    }

    /**
     * Sets the end time to the current timestamp
     */
    public void end() {
        setEndTime(System.currentTimeMillis());
    }
}
