package sk.upjs.ics.paz1c.debilnicek;

import java.util.Date;

public class Uloha {
    private String popis;
    
    private Date termin;
    
    private boolean stav;

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }

    public boolean isStav() {
        return stav;
    }

    public void setStav(boolean stav) {
        this.stav = stav;
    }
    
    
    
}
