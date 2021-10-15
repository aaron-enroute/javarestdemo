package com.enroute.ws.javarestdemo.employee.api.v1;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;
import org.junit.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.enroute.ws.javarestdemo.model.Employee;
import com.enroute.ws.javarestdemo.model.Titles;
import com.enroute.ws.javarestdemo.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class)
@WithMockUser
public class EmployeeControllerTest {
/*
	@Test
	public void testRetrieveAllUsers() {
		fail("Not yet implemented");
	}
	*/
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;

	//Employee e = new Employee("10017", "birthDate", "firstName", "");
	
	@Test
	public void testRetrieveUser() throws Exception {
	//	EmployeeRepository empRepo;
	//	Employee e = new Employee();
		//.000+00:00
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
		String birthDate = "1958-01-06T06:00:00";
		String hireDate="1993-01-03T06:00:00";
		String fromDate = "2000-08-03T05:00:00";
		String toDate = "9999-01-01T06:00:00";
		Date birthDate_ = sdt.parse(birthDate);
		Date hireDate_= sdt.parse(hireDate);
		Date fromDate_ = sdt.parse(fromDate);
		Date toDate_= sdt.parse(toDate);
		
		Employee employeeMock = new Employee();
		List<Titles> titlesMock = new ArrayList<>();
		Titles titleMock =new Titles();
		
		employeeMock.setEmp_no(10017);
		employeeMock.setBirthDate(birthDate_);
		employeeMock.setFirstName("Cristinel");
		employeeMock.setLastName("Bouloucos");
		employeeMock.setGender("F");
		employeeMock.setHireDate(hireDate_);
		
		titleMock.setEmp_no(10017);
		titleMock.setTitle("Senior Staff");
		titleMock.setFromDate(fromDate_);
		titleMock.setToDate(toDate_);
		
		titlesMock.add(titleMock);
		titlesMock.add(titleMock);
		employeeMock.setTitles(titlesMock);
		
		String expected = "{\"emp_no\":10017,\"birthDate\":\"1958-01-06T12:00:00.000+00:00\",\"firstName\":\"Cristinel\",\"lastName\":\"Bouloucos\",\"gender\":\"F\",\"hireDate\":\"1993-01-03T12:00:00.000+00:00\",\"titles\":[{\"emp_no\":10017,\"title\":\"Senior Staff\",\"fromDate\":\"2000-08-03T05:00:00.000+00:00\",\"toDate\":\"9999-01-01T06:00:00.000+00:00\"},{\"emp_no\":10017,\"title\":\"Senior Staff\",\"fromDate\":\"2000-08-03T05:00:00.000+00:00\",\"toDate\":\"9999-01-01T06:00:00.000+00:00\"}]}";
		Mockito.when(employeeService.findById(Mockito.anyInt())).thenReturn(Optional.of(employeeMock));

		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employee/10017").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
		//Mockito.verify(employeeService).findById(10017);
	}
	
	/*
	
	@Test
	public void get_allVehicles_returnsOkWithListOfVehicles() throws Exception {

		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss.SSSZ");
		String birthDate = "1958-07-06T06:00:00.000+00:00";
		String hireDate="1993-08-03T06:00:00.000+00:00";
		String fromDate = "2000-08-03T05:00:00.000+00:00";
		String toDate = "9999-01-01T06:00:00.000+00:00";
		Date birthDate_ = dt.parse(birthDate);
		Date hireDate_= dt.parse(hireDate);
		Date fromDate_ = dt.parse(fromDate);
		Date toDate_= dt.parse(toDate);
		
		Employee employeeMock = new Employee();
		List<Titles> titlesMock = new ArrayList<>();
		Titles titleMock =new Titles();
		
		employeeMock.setEmp_no(10017);
		employeeMock.setBirthDate(birthDate_);
		employeeMock.setFirstName("Cristinel");
		employeeMock.setLastName("Bouloucos");
		employeeMock.setGender("F");
		employeeMock.setHireDate(hireDate_);
		
		titleMock.setEmp_no(10017);
		titleMock.setTitle("Senior Staff");
		titleMock.setFromDate(fromDate_);
		titleMock.setToDate(toDate_);
		
		titlesMock.add(titleMock);
	
		Vehicle vehicle1 = new Vehicle("AD23E5R98EFT3SL00", "Ford", "Fiesta", 2016, false);
		Vehicle vehicle2 = new Vehicle("O90DEPADE564W4W83", "Volkswagen", "Jetta", 2016, false);
		vehicleList.add(vehicle1);
		vehicleList.add(vehicle2);

		// Mocking out the vehicle service
		Mockito.when(vechicleService.getAllVehicles()).thenReturn(vehicleList);

		mockMvc.perform(MockMvcRequestBuilders.get("/demo/vehicles").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].vin", is("AD23E5R98EFT3SL00"))).andExpect(jsonPath("$[0].make", is("Ford")))
				.andExpect(jsonPath("$[1].vin", is("O90DEPADE564W4W83")))
				.andExpect(jsonPath("$[1].make", is("Volkswagen")));
	}
	
	
    @Test
    public void testGetSpain() throws Exception {
    	
        String response = mockMvc.perform(get("/employee/{id}/"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.name", is("Spain")))
                .andReturn().getResponse().getContentAsString();
    }
    
    @Test
    public void testRetrieveUser2() {
    	this.mockMvc.perform(get("/employee")).andDo(print()).andExpect(status().isOk())
          .andExpect(jsonPath("$.message").value("Hello World!!!"))
          .andReturn();
        
        Assert.assertEquals("application/json;charset=UTF-8", 
          mvcResult.getResponse().getContentType());
    }
	private RequestBuilder get(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	*/ 

}
