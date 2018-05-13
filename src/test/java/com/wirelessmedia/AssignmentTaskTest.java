package com.wirelessmedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wirelessmedia.controller.api.TaskController;
import com.wirelessmedia.controller.facade.TaskFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssignmentApplication.class)
public class AssignmentTaskTest
{
    private static ObjectMapper mapper;
    private MockMvc mockMvcTask;

    @Autowired
    private TaskFacade taskFacade;

    @Before
    public void setup() throws Exception {
        this.mockMvcTask = MockMvcBuilders.standaloneSetup(new TaskController(taskFacade)).build();
    }

    @Test
    @Transactional
    public void testTaskSave() throws Exception
    {
        mockMvcTask.perform(
            post("/api/task").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
                + "\t\"taskName\":\"Task1\"\n"
                + "}"))
            .andDo(print()).andExpect(status().isCreated());
    }




}
