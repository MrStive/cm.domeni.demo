package cm.domeni.demo.e2e.steps;

import cm.domeni.demo.DemoApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"e2e"})
@CucumberContextConfiguration
@AutoConfigureMockMvc
@SpringBootTest(
        classes = {
                DemoApplication.class
        })
public class CucumberSpringConfiguration {
}
