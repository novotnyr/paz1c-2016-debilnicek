package sk.upjs.ics.paz1c.debilnicek;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuborovyUlohaDao {
    public List<Uloha> dajUlohy() {
        List<Uloha> ulohy = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File("ulohy.txt"))) {
            while (scanner.hasNextLine()) {
                String riadok = scanner.nextLine();
                String[] polozky = riadok.split(";");
                
                Uloha uloha = new Uloha();
                uloha.setPopis(polozky[0]);
                
                ulohy.add(uloha);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return ulohy;        
    }
}
