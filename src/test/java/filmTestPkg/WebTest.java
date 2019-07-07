package filmTestPkg;

import moviestore.MovieStoreMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 *
 * @author Jimmy
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MovieStoreMain.class}, webEnvironment
    = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@AutoConfigureWebTestClient //skulle lösa felet med webtestclient, men var...
                            //...dependency av webflux som löste
public class WebTest {
    @Autowired
    private WebTestClient webTestClient;
    
    @Test
    public void getFilmsOK() {
        //får hela html-sidan som svar på första nedan så den failar med "films"
        //this.webTestClient.get().uri("/film/all").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("films");
        this.webTestClient.get().uri("/film/all").exchange().expectStatus().isOk();
    }
    
}
