package com.wirelessmedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wirelessmedia.controller.api.EmployeeController;
import com.wirelessmedia.controller.facade.EmployeeFacade;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.transaction.Transactional;
import java.io.File;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssignmentApplication.class)
public class AssignmentEmployeeTest
{
    private static ObjectMapper mapper;
    private static String employeeJdInputAndOutput;
    private static String employeeJd_1InputAndOutput;
    private static String employeeSdInputAndOutput;
    private static String employeeSd_1InputAndOutput;
    private static String employeeSd_2InputAndOutput;
    private static String employeeTlInputAndOutput;
    private static String employeeTl_1InputAndOutput;
    private static String employeePmInputAndOutput;
    private static String employeePm_1InputAndOutput;
    private static String employeeAllInputAndOutput;

    private MockMvc mockMvc;

    @Autowired
    private EmployeeFacade employeeFacade;

    @BeforeClass
    public static void prepare() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AssignmentEmployeeTest.class.getClassLoader();
        employeeJdInputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeeJdInputAndOutput").getFile()),
                Object.class));
        employeeJd_1InputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeeJd_1InputAndOutput").getFile()),
                Object.class));
        employeeSdInputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeeSdInputAndOutput").getFile()),
                Object.class));
        employeeSd_1InputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeeSd_1InputAndOutput").getFile()),
                Object.class));
        employeeSd_2InputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeeSd_2InputAndOutput").getFile()),
                Object.class));
        employeeTlInputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeeTlInputAndOutput").getFile()),
                Object.class));
        employeeTl_1InputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeeTl_1InputAndOutput").getFile()),
                Object.class));
        employeePmInputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeePmInputAndOutput").getFile()),
                Object.class));
        employeePm_1InputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeePm_1InputAndOutput").getFile()),
                Object.class));
        employeeAllInputAndOutput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentEmployeeTest/employeeAllInputAndOutput").getFile()),
                Object.class));

    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController(employeeFacade)).build();
    }

    @Test
    @Transactional
    public void testEmployeeSave() throws Exception
    {
        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeJdInputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeJdInputAndOutput));


        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeJd_1InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeJd_1InputAndOutput));

        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeSd_1InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeSd_1InputAndOutput));


        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeSdInputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeSdInputAndOutput));

        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeSd_2InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeSd_2InputAndOutput));


        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeTlInputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeTlInputAndOutput));

        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeTl_1InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeTl_1InputAndOutput));


        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeePmInputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeePmInputAndOutput));

        mockMvc.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeePm_1InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeePm_1InputAndOutput));

        mockMvc.perform(
            get("/api/employee")).andDo(print()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeAllInputAndOutput));

    }

}
