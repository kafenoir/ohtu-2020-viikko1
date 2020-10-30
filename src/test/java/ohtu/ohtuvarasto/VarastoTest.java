package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto toinenVarasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        toinenVarasto = new Varasto(10, 5);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiLisataNegatiivista() {
        
        varasto.lisaaVarastoon(5);
        
        varasto.lisaaVarastoon(-1);
        
        assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void liikaaLisattaessaSaldoEiYlitaTilavuutta() {
        varasto.lisaaVarastoon(11);
        
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiOttaaNegatiivista() {
        
        varasto.lisaaVarastoon(5);
        
        varasto.otaVarastosta(-1);
        
        assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void varastostaEiVoiOttaaEnemmanKuinSaldon() {
        varasto.lisaaVarastoon(5);
        
        varasto.otaVarastosta(6);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test 
    public void tilavuusNollaJosAnnettuNollaTaiNegatiivinen() {
        
        Varasto nollavarasto = new Varasto(0);
        Varasto negavarasto = new Varasto(-1);
        
        assertEquals(0, nollavarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, negavarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test 
    public void toinenKonstruktoriLuoVarastonOikeallaTilavuudella() {
        
        assertEquals(10, toinenVarasto.getTilavuus(), vertailuTarkkuus);
 
    }
    
    @Test 
    public void toinenKonstruktoriLuoVarastonOikeallaSaldolla() {
        
        assertEquals(5, toinenVarasto.getSaldo(), vertailuTarkkuus);
 
    }
    
    @Test 
    public void toinenKonstruktoriTilavuusNollaJosNollaTaiNegatiivinen() {
        
        Varasto negavarasto = new Varasto(-1, 0);
        
        assertEquals(0, negavarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenNollaaAlkuSaldon() {
        
        Varasto negaSaldoVarasto = new Varasto(10, -1);
        
        assertEquals(0, negaSaldoVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void tilavuusEiYlityJosLiikaaAlkusaldoa() {
        
        Varasto yliSaldoVarasto = new Varasto(10, 11);
        
        assertEquals(10, yliSaldoVarasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void varastonMerkkijonoesitysOikein() {
        
        String merkkijono = varasto.toString();
        String toinenMerkkijono = toinenVarasto.toString();
        
        String vertailu = "saldo = 0.0, vielä tilaa 10.0";
        String toinenVertailu = "saldo = 5.0, vielä tilaa 5.0";
        
        assertEquals(vertailu, merkkijono);
        assertEquals(toinenVertailu, toinenMerkkijono);
    }

}