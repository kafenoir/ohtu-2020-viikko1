package paaohjelma;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {
        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);
        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("getTilavuus    = " + olutta.getTilavuus());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());
        System.out.println("Mehusetterit:");
        System.out.println("Lisätään 50.7");
        mehua.lisaaVarastoon(50.7);
        System.out.println("Mehuvarasto: " + mehua);
        
        int summa = 0;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                summa++;
            }
        }
        
        if (summa < 5) 
        {
            summa++;
            
                        if (summa < 3) {
                summa--;
                
                if (summa < 1) {
                    summa++;
                }
            }
        }
    }
}
