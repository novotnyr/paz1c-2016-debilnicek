package sk.upjs.ics.paz1c.debilnicek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuborovyUlohaDao implements UlohaDao {
    @Override
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

    @Override
    public void pridaj(Uloha uloha) {
        try(FileWriter writer = new FileWriter(new File("ulohy.txt"), true)) {
            // TODO zapisovat aktualny datum
            writer.append(uloha.getPopis() + ";11. 10. 2016;" + uloha.isStav() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
