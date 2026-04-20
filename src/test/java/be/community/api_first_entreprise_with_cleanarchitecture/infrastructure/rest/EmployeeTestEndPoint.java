package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.rest;

import be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.persistence.employee.JpaEmployeeRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional()
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeTestEndPoint {

    @Autowired
    JpaEmployeeRepository jpaEmployeeRepository;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnListOfEmployee() throws Exception {
        mockMvc.perform(get("/employee?currentPage=0&pageSize=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5));
    }

    @Test
    void shouldReturnEmployeeById() throws Exception {
        mockMvc.perform(get("/employee/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Coq"));
    }

    @Test
    void shouldReturnEmployeeByName() throws Exception {
        mockMvc.perform(get("/employee/search/Habiba"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Habiba"));
    }

    @Test
    void shouldAddEmployee() throws Exception {
        String newEmployee = """
                {
                  "name": "Achour",
                  "firstname": "Mouloud",
                  "service": "DRHH",
                  "floor": 6,
                  "email": "achou@mouloud.com",
                  "address": {
                    "street": "Rue quelque part",
                    "zipcode": 5000,
                    "city": "Namur"
                  }
                }
                """;

        mockMvc.perform(post("/employee/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newEmployee))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void shouldReturnErrorEmployeeById() throws Exception {
        mockMvc.perform(get("/employee/15"))
                .andExpect(status().is4xxClientError());

    }

}
