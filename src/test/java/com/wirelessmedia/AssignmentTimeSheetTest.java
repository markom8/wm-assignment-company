package com.wirelessmedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wirelessmedia.controller.api.*;
import com.wirelessmedia.controller.facade.*;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AssignmentApplication.class)
public class AssignmentTimeSheetTest
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

    private MockMvc mockMvcProjectController;

    private MockMvc mockMvcTaskController;

    private MockMvc mockMvcTimeSheetController;

    @Autowired
    private TimeSheetFacade timeSheetFacade;

    @Autowired
    private ProjectFacade projectFacade;

    @Autowired
    private TeamFacade teamFacade;

    @Autowired
    private EmployeeFacade employeeFacade;

    @Autowired
    private TaskFacade taskFacade;

    @BeforeClass
    public static void prepare() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = AssignmentTimeSheetTest.class.getClassLoader();
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
        this.mockMvcProjectController = MockMvcBuilders.standaloneSetup(new ProjectController(projectFacade)).build();
        this.mockMvcTeamController = MockMvcBuilders.standaloneSetup(new TeamController(teamFacade)).build();
        this.mockMvcEmployeeController = MockMvcBuilders.standaloneSetup(new EmployeeController(employeeFacade)).build();
        this.mockMvcTaskController = MockMvcBuilders.standaloneSetup(new TaskController(taskFacade)).build();
        this.mockMvcTimeSheetController = MockMvcBuilders.standaloneSetup(new TimeSheetController(timeSheetFacade)).build();

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

        mockMvcProjectController.perform(
            post("/api/project").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
                + "\t\"projectName\":\"momp\",\n"
                + "\t\"clientName\":\"Oman\",\n"
                + "\t\"teamName\":\"TESLA\",\n"
                + "\t\"projectManagerPersonalNumber\":\"12345678911\"\n"
                + "\t\n"
                + "}"))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcProjectController.perform(
            post("/api/project").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
                + "\t\"projectName\":\"burs\",\n"
                + "\t\"clientName\":\"Bocvana\",\n"
                + "\t\"teamName\":\"PROGRESSIVE\",\n"
                + "\t\"projectManagerPersonalNumber\":\"12345678912\"\n"
                + "\t\n"
                + "}"))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcTaskController.perform(
            post("/api/task").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
                + "\t\"taskName\":\"Task1\"\n"
                + "}"))
            .andDo(print()).andExpect(status().isCreated());

        mockMvcTaskController.perform(
            post("/api/task").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
                + "\t\"taskName\":\"Task2\"\n"
                + "}"))
            .andDo(print()).andExpect(status().isCreated());

    }

    @Test
    @Transactional
    public void testTimeSheetSave() throws Exception
    {
        mockMvcTimeSheetController.perform(post("/api/timesheet").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
            + "\t\"projectName\":\"momp\",\n"
            + "\t\"workedHours\":8,\n"
            + "\t\"team\":\"TESLA\",\n"
            + "\t\"employeePersonalNumber\":\"1234\",\n"
            + "\t\"date\":\"2018-01-01\",\n"
            + "\t\"taskName\":\"Task1\"\n"
            + "}")).andDo(print());

        mockMvcTimeSheetController.perform(post("/api/timesheet").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
            + "\t\"projectName\":\"momp\",\n"
            + "\t\"workedHours\":8,\n"
            + "\t\"team\":\"TESLA\",\n"
            + "\t\"employeePersonalNumber\":\"1234\",\n"
            + "\t\"date\":\"2018-01-01\",\n"
            + "\t\"taskName\":\"Task2\"\n"
            + "}")).andDo(print());

        mockMvcTimeSheetController.perform(post("/api/timesheet/worklog").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\n"
            + "\t\"projectName\":\"momp\",\n"
            + "\t\"employeePersonalNumber\":\"1234\"\n"
            + "}")).andDo(print());
    }
}
