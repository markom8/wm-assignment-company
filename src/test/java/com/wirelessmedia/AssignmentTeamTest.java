package com.wirelessmedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wirelessmedia.controller.EmployeeController;
import com.wirelessmedia.controller.TeamController;
import com.wirelessmedia.controller.facade.EmployeeFacade;
import com.wirelessmedia.controller.facade.TeamFacade;
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
public class AssignmentTeamTest
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
    private static String teamInput;
    private static String teamInput_1;
    private static String teamInput_2;
    private static String team1Input;
    private static String team1Input_1;

    private MockMvc mockMvcEmployeeController;

    private MockMvc mockMvcTeamController;

    @Autowired
    private TeamFacade teamFacade;

    @Autowired
    private EmployeeFacade employeeFacade;

    @BeforeClass
    public static void prepare() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AssignmentTeamTest.class.getClassLoader();
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
        teamInput = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentTeamTest/teamInput").getFile()),
                Object.class));
        teamInput_1 = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentTeamTest/teamInput_1").getFile()),
                Object.class));
        teamInput_2 = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentTeamTest/teamInput_2").getFile()),
                Object.class));
        team1Input = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentTeamTest/team1Input").getFile()),
                Object.class));
        team1Input_1 = mapper.writeValueAsString(
            mapper.readValue(new File(classLoader.getResource("assignmentTeamTest/team1Input_1").getFile()),
                Object.class));
    }

    @Before
    public void setup() throws Exception {
        this.mockMvcTeamController = MockMvcBuilders.standaloneSetup(new TeamController(teamFacade)).build();
        this.mockMvcEmployeeController = MockMvcBuilders.standaloneSetup(new EmployeeController(employeeFacade)).build();

        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeJdInputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeJdInputAndOutput));


        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeJd_1InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeJd_1InputAndOutput));

        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeSd_1InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeSd_1InputAndOutput));


        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeSdInputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeSdInputAndOutput));

        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeSd_2InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeSd_2InputAndOutput));


        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeTlInputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeTlInputAndOutput));

        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeeTl_1InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeTl_1InputAndOutput));


        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeePmInputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeePmInputAndOutput));

        mockMvcEmployeeController.perform(
            post("/api/employee").contentType(MediaType.APPLICATION_JSON_UTF8).content(employeePm_1InputAndOutput))
            .andDo(print()).andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeePm_1InputAndOutput));

        mockMvcEmployeeController.perform(
            get("/api/employee")).andDo(print()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(content().json(employeeAllInputAndOutput));
    }

    @Test
    @Transactional
    public void testTeamSave() throws Exception
    {
        mockMvcTeamController.perform(
            post("/api/team").contentType(MediaType.APPLICATION_JSON_UTF8).content(teamInput))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcTeamController.perform(
            post("/api/team").contentType(MediaType.APPLICATION_JSON_UTF8).content(teamInput_1))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcTeamController.perform(
            post("/api/team").contentType(MediaType.APPLICATION_JSON_UTF8).content(teamInput_2))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcTeamController.perform(
            post("/api/team").contentType(MediaType.APPLICATION_JSON_UTF8).content(team1Input))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcTeamController.perform(
            post("/api/team").contentType(MediaType.APPLICATION_JSON_UTF8).content(team1Input_1))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcTeamController.perform(
            post("/api/team").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
                + "\t\"teamName\":\"PROGRESSIVE\",\n"
                + "\t\"developerPersonalNumber\":\"1234567\"\n"
                + "}"))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcTeamController.perform(
            get("/api/team")).andDo(print());
    }

}
