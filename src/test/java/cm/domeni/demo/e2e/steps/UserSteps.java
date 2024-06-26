package cm.domeni.demo.e2e.steps;

import cm.domeni.demo.dto.UserDTO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class UserSteps implements En {
    UUID userid;
    private BaseHttpClient httpClient;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserSteps() {
        And("I create a new business with the following data",
                (DataTable dataTable) -> {
                    final var map = dataTable.asMaps().get(0);
                    final var userDTO = new UserDTO().userName(map.get("user name"))
                            .firstName(map.get("first name"))
                            .lastName(map.get("last name"));
                    userid = httpClient
                            .post("/user")
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(userDTO)
                            .exchange()
                            .expectStatus().isCreated()
                            .expectBody(UUID.class)
                            .returnResult()
                            .getResponseBody();
                }
        );

        And("I should see that the message with the following data have been created",
                (DataTable dataTable) -> {
                    final var map = dataTable.asMaps().get(0);
                    final var userDate = jdbcTemplate.queryForObject(
                            "SELECT * FROM t_user WHERE c_id = ?",
                            (rs, rowNum) ->
                                    new UserDate(rs.getString("c_user_name"),
                                            rs.getString("c_first_name"),
                                            rs.getString("c_last_name"))
                            ,
                            userid.toString()
                    );
                    assertThat(userDate)
                            .returns(map.get("user name"), UserDate::userName)
                            .returns(map.get("first name"), UserDate::firstname)
                            .returns(map.get("last name"), UserDate::lastName);
                }
        );

    }

    record UserDate(
            String userName,
            String lastName,
            String firstname
    ) {

    }
}
