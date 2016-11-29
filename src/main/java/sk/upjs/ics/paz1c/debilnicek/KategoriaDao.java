package sk.upjs.ics.paz1c.debilnicek;

import java.util.List;

public interface KategoriaDao {
    public List<Kategoria> dajKategorie();
    
    public Kategoria najdiPodlaId(Long id);
    
    public void uloz(Kategoria kategoria);
    
}
