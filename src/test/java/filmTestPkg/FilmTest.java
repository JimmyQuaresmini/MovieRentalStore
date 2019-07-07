package filmTestPkg;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import moviestore.MovieStoreMain;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 *
 * @author Jimmy
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MovieStoreMain.class}, webEnvironment
    = WebEnvironment.DEFINED_PORT)
public class FilmTest {
    private static final String ALL_FILMS = "http://localhost:8080/film/all";
    
    @Autowired
    private WebTestClient webTestClient;
    
    @Test
    public void getAllFilmsOK() {
        Response response = RestAssured.get(ALL_FILMS);
        
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
    
    @Test
    public void getFilmsOK() {
        this.webTestClient.get().uri("/film/all").exchange().expectStatus().isOk().expectBody(String.class).isEqualTo("films");
    }
}
