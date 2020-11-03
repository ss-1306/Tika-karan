package karan.tika.tikakaran;

/**
 * Created by Shreya on 11/5/2016.
 */

public class VaccinationDataProvider {
    private String vaccinationName;
    private String dates;

    public VaccinationDataProvider(String vaccinationName, String dates){
        this.setVaccinationName(vaccinationName);
        this.setDates(dates);
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }



    public void setVaccinationName(String vaccinationName) {
        this.vaccinationName = vaccinationName;
    }

    public String getVaccinationName() {
        return vaccinationName;
    }
}
