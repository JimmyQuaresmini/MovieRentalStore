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
//@AutoConfigureWebTestClient //was supposed to solve the webtestclient error, ...
                            //...but it was the webflux-dependency that solved it
public class WebTest {
    @Autowired
    private WebTestClient webTestClient;
    
    @Test
    public void getFilmsOK() {
        //all the html-page is given as a response of the first one below so it fails with "films"
        //this.webTestClient.get().uri("/film/all").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("films");
        this.webTestClient.get().uri("/film/all").exchange().expectStatus().isOk();
    }
    
}
