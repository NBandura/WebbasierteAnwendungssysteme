package edu.fra.uas.Notendurchschnitt;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import edu.fra.uas.Controller.NotenController;

@SpringBootTest
public class ControllerTest {

    @Autowired
    private NotenController notenController;

    @Test
    public void contextLoads() {
        assertThat(notenController).isNotNull();
    }

    @Test
    public void NotenControllerTest() {
        assertThat(notenController.addNote(0)).isEqualTo(notenController.getAnzahlNoten());
        assertThat(notenController.addNote(1)).isEqualTo(notenController.getAnzahlNoten());
        assertThat(notenController.addNote(2)).isEqualTo(notenController.getAnzahlNoten());
        assertThat(notenController.addNote(3)).isEqualTo(notenController.getAnzahlNoten());
        assertThat(notenController.addNote(4)).isEqualTo(notenController.getAnzahlNoten());
        assertThat(notenController.getDurchschnitt()).isEqualTo(notenController.getNotenSumme() / notenController.getAnzahlNoten());
    }

}

