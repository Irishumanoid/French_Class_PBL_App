package com.example.duofrencholingo;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.duofrencholingo.Readings.ConceptLandingPage;

import java.text.Normalizer;

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
    public void testDiacritics() {
        assertFalse(Normalizer.isNormalized("āăąēîïĩíĝġńñšŝśûůŷ", Normalizer.Form.NFKD));
        assertEquals("aaaeiiiiggnnsssuuy", ConceptLandingPage.removeDiacritics("āăąēîïĩíĝġńñšŝśûůŷ"));
    }



}