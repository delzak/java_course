package ru.web.moysklad.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RepeatTutorial extends TestBase{

    @Test
    public void testRepeatTutorial() {
        app.click().help();
        app.tutorial().clickRepeatTutorial();
        assertEquals(app.tutorial().getHintText(), "Перейдите в раздел «Юр. лица»");
    }
}
