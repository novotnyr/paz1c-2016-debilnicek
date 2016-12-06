package sk.upjs.ics.paz1c.debilnicek;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Kategoria {
    private Long id; 
    
    private String nazov;
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String toString() {
        return nazov;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nazov);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kategoria other = (Kategoria) obj;
        if (!Objects.equals(this.nazov, other.nazov)) {
            return false;
        }
        return true;
    }
   
    
    
}
