package sk.upjs.ics.paz1c.debilnicek;

import java.util.Date;

public class Uloha {
    private Long id;
    
    private String popis;
    
    private Date termin;
    
    private boolean stav;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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
