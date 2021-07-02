package com.chris.jobmanager.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.jobmanager.models.entity.Employees;
import com.chris.jobmanager.models.services.IEmployeeService;
import com.chris.jobmanager.models.services.IEmployerService;

@RestController
@RequestMapping("/api")
public class EmployeesController {
	@Autowired
	IEmployeeService employeeService;
	IEmployerService employerService;

	@GetMapping("/employers/{employerId}/employees")
	public ResponseEntity<?> getEmployees(@PathVariable Integer employerId) {
		Map<String, Object> response = new HashMap<>();
		List<Employees> employeesList = null;
		try {

			employeesList = employeesList.stream()
					.filter((emp) -> emp.getEmployers().getId() == employerService.findById(employerId).getId())
					.collect(Collectors.toList());
			employeesList = employeeService.findAll();

		} catch (DataAccessException e) { // Falla al acceder a la base de datos
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		if (listaClientes.size() == 0) {
//			response.put("mensaje", "La lista està vacia");
//			response.put("clientes", listaClientes);
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//		}
		return new ResponseEntity<List<Employees>>(employeesList, HttpStatus.OK);
	}

	@GetMapping("/employers/{employerId}/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer employerId, @PathVariable Integer id) {
		Employees employee = null;
		Map<String, Object> response = new HashMap<>();
		try {
			employeeService.findById(id);
			employee = employeeService.findById(id); // Comprobar Accesso a la base de datos

		} catch (DataAccessException e) { // Falla al acceder a la base de datos
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (employee == null) {
			response.put("mensaje",
					"El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<Employees>(employee, HttpStatus.OK);
	}

	@PostMapping("/employers/{employerId}/employees")
	public ResponseEntity<?> create(@RequestBody Employees employee, @PathVariable Integer employerId,
			BindingResult result) {
		Employees newEmployee = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errores = result.getFieldErrors().stream()
					.map((err) -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errores", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			employee.setEmployers(employerService.findById(employerId));
			newEmployee = employeeService.save(employee);
		} catch (DataAccessException e) { // Falla al acceder a la base de datos
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido insertado con exito");
		response.put("cliente", newEmployee);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
