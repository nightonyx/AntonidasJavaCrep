import org.junit.Test;

import static org.junit.Assert.*;


public class Tests {

    private final Crep crep1 = new Crep("(легендарный меч короля Артура)", "TestFiles/Test2");
    private final Crep crep2 = new Crep("меч", "TestFiles/Test1");
    private final Crep crep3 = new Crep("меч", "TestFiles/Test1");

    @Test
    public void r() throws Exception {
        assertEquals("легендарный меч короля Артура\n" +
                "легендарный меч короля Артура\n" +
                "легендарный меч короля Артура\n" +
                "легендарный меч короля Артура", crep1.paramR());
    }

    @Test
    public void v() throws Exception {
        assertEquals("3 Впервые появляется в «Истории королей Британии» Гальфрида Монмутского.\n" +
                "4 Согласно одной из легенд, Экскалибур выковал бог-кузнец Велунд.", crep2.paramV());
    }

    @Test
    public void i() throws Exception {
        assertEquals("1 Этот меч король Артур добыл при содействии волшебника Мерлина.\n" +
                "2 Там обнажил он меч Эскалибур.\n" +
                "5 Гальфрид Монмутский латинизировал название — меч в его работе\n" +
                "6 Легендарный меч короля Артура, которому часто приписываются мистические и волшебные свойства", crep3.paramI());
    }

}
