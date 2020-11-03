package karan.tika.tikakaran;

/**
 * Created by Shreya on 11/9/2016.
 */



/**
 * Created by Shreya on 11/5/2016.
 */

public class BabyProfileDataProvider {
    private String babyName;
    private String dates;

    public BabyProfileDataProvider(String babyName, String dates){
        this.setBabyName(babyName);
        this.setDates(dates);
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }



    public void setBabyName(String vaccinationName) {
        this.babyName = vaccinationName;
    }

    public String getBabyName() {
        return babyName;
    }
}

