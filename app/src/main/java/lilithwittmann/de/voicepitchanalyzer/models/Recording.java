package lilithwittmann.de.voicepitchanalyzer.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.util.Date;

/**
 * Created by Yuri on 04/07/15.
 */
public class Recording implements Parcelable {
    public static final String KEY = Recording.class.getSimpleName();
    private File recording;
    private Date date;
    private PitchRange range;
    private String name;

    public Recording(Date date) {
        setDate(date);
    }

    protected Recording(Parcel src) {
        this.setDate(new Date(src.readLong()));
        this.setName(src.readString());
        this.setRange((PitchRange) src.readParcelable(PitchRange.class.getClassLoader()));
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PitchRange getRange() {
        return range;
    }

    public void setRange(PitchRange range) {
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getRecording() {
        return recording;
    }

    public void setRecording(File recording) {
        this.recording = recording;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.getName());
        dest.writeLong(this.getDate().getTime());
        dest.writeParcelable(this.range, flags);
    }

    private void readFromParcel(Parcel src) {
        this.setDate(new Date(src.readLong()));
    }
}