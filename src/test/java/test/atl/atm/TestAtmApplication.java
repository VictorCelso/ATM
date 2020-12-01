package test.atl.atm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
class TestingAtmApplicationTests {

    @LocalServerPort
    private int port;
    @Autowired
    private MockMvc mockMvc;


  @Test
    void accountWithdraw() throws Exception {
     mockMvc.perform(MockMvcRequestBuilders.get(
        new URI("http://localhost:"+port+"/api/account/1/withdraw/?value=100"))
       .header("Authorization","Basic cm9vdDpyb290"))
       .andExpect(MockMvcResultMatchers.status().isOk())
     .andExpect(MockMvcResultMatchers.content().string("{\"$100\":1}"));
    }

  @Test
  void accountBalance() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(
      new URI("http://localhost:"+port+"/api/account/1/balance"))
      .header("Authorization","Basic cm9vdDpyb290"))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().string("9899.5"));
  }

}
