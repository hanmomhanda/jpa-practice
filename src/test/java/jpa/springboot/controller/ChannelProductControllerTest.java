package jpa.springboot.controller;

import jpa.springboot.TestJpaSpringBootApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestJpaSpringBootApplication.class, initializers = {ConfigFileApplicationContextInitializer.class})
@WebAppConfiguration
public class ChannelProductControllerTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext ctx;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(ctx)
                .alwaysDo(print())
                .build();
    }

    private ResultActions saveOneChannelProduct() throws Exception {
        return mockMvc.perform(
                post("/v1/channel-product")
                        .param("channelCode", "9333048")
                        .param("channelName", "너만오면바로고")
                        .param("productCode", "1203789578")
                        .param("productName", "신제품!11번가단독기획]블루밍 대표 비데ICON-600/NEW 디자인/AMS노즐/온풍건조/어린이기능")
                        .param("displayStartDate", "2016-05-09")
                        .param("displayEndDate", "2018-07-31")
                        .param("displayYn", "Y")
                        .param("priority", "1")

        );
    }

    @Test
    public void 채널노출상품_단건_1회_등록() throws Exception {
        saveOneChannelProduct().andExpect(status().isOk());
    }

    @Test
    public void 채널노출상품_단건_2회_등록() throws Exception {
        saveOneChannelProduct().andExpect(status().isOk());

        saveOneChannelProduct().andExpect(status().isOk());
    }
}
