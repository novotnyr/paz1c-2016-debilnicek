package sk.upjs.ics.paz1c.debilnicek;

import java.util.List;

public interface UlohaDao {

    List<Uloha> dajUlohy();

    void saveOrUpdate(Uloha uloha);

    List<Uloha> najdiPodlaKategorie(Kategoria kategoria);    
}
