package com.test.myfirst.classactivity2;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable {

    String pname,pheight,ptype,pability,pweight,description,pimgurl;

    public Pokemon(String pname, String pimgurl, String ptype, String pability, String pheight, String pweight, String description) {
        this.pname = pname;

        this.pheight = pheight;
        this.ptype = ptype;
        this.pability = pability;
        this.pweight = pweight;
        this.description = description;
        this.pimgurl = pimgurl;
    }

    protected Pokemon(Parcel in) {
        pname = in.readString();

        pheight = in.readString();
        ptype = in.readString();
        pability = in.readString();
        pweight = in.readString();
        description = in.readString();
        pimgurl = in.readString();
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel in) {
            return new Pokemon(in);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }



    public String getPheight() {
        return pheight;
    }

    public void setPheight(String pheight) {
        this.pheight = pheight;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPability() {
        return pability;
    }

    public void setPability(String pability) {
        this.pability = pability;
    }

    public String getPweight() {
        return pweight;
    }

    public void setPweight(String pweight) {
        this.pweight = pweight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPimgurl() {
        return pimgurl;
    }

    public void setPimgurl(String pimgurl) {
        this.pimgurl = pimgurl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pname);

        dest.writeString(pheight);
        dest.writeString(ptype);
        dest.writeString(pability);
        dest.writeString(pweight);
        dest.writeString(description);
        dest.writeString(pimgurl);
    }
}
