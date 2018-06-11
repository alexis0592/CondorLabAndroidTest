package co.com.yacalder.condormovies;

import org.junit.Test;

import co.com.yacalder.condormovies.model.interactor.GuestUserInteractor;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void guestUserTest(){
        GuestUserInteractor guestUserInteractor = new GuestUserInteractor();

    }
}