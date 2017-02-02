package com.vows.websocket;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.vows.test.websocket.HttpReqMvcTestAjax;


public class WebsocketTest {
	@Test
	public void getSystimerTest(){
		HttpReqMvcTestAjax wta = new HttpReqMvcTestAjax(); // 搭建mockmvc
		MockMvc mock = MockMvcBuilders.standaloneSetup(wta).build();
		//mock.perform(get("/")).andExpect(view().name(""));
		//mock.perform(requestBuilder);
	}
}
