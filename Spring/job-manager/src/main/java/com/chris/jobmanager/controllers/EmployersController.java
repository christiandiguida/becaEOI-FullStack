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

import com.chris.jobmanager.models.entity.Employers;
import com.chris.jobmanager.models.services.IEmployeeService;
import com.chris.jobmanager.models.services.IEmployerService;

@RestController
@RequestMapping("/api")
public class EmployersController {

	@Autowired
	IEmployerService employerService;
	EmployeesController employeesController = new EmployeesController();
	IEmployeeService employeeService;

	@GetMapping("/employers")
	public ResponseEntity<?> index() {
		Map<String, Object> response = new HashMap<>();
		List<Employers> employersList = null;
		try {
			employersList = employerService.findAll();
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
		return new ResponseEntity<List<Employers>>(employersList, HttpStatus.OK);
	}

	@GetMapping("/employers/{id}")
	public ResponseEntity<?> index(@PathVariable Integer id) {
		Employers employer = null;
		Map<String, Object> response = new HashMap<>();
		try {
			employer = employerService.findById(id); // Comprobar Accesso a la base de datos
		} catch (DataAccessException e) { // Falla al acceder a la base de datos
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (employer == null) {
			response.put("mensaje",
					"El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}

		return new ResponseEntity<Employers>(employer, HttpStatus.OK);
	}

	@PostMapping("/employers")
	public ResponseEntity<?> create(@RequestBody Employers employer, BindingResult result) {
		Employers newEmployer = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map((err) -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			newEmployer = employerService.save(employer);
		} catch (DataAccessException e) { // Falla al acceder a la base de datos
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido insertado con exito");
		response.put("cliente", newEmployer);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
//
//	@PutMapping("/clientes/{id}")
////	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<?> update(@Valid @RequestBody Clientes cliente, @PathVariable Long id, BindingResult result) {
//		Clientes clienteUpdated = null;
//		Map<String, Object> response = new HashMap<>();
//		Clientes clienteParaModificar = null;
//		if (result.hasErrors()) {
//			List<String> errores = result.getFieldErrors().stream()
//					.map((err) -> "El campo " + err.getField() + " " + err.getDefaultMessage())
//					.collect(Collectors.toList());
//			response.put("errores", errores);
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
//		}
//		try {
//			clienteParaModificar = clienteService.findById(id); // busco el cliente a modificar
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al acceder a la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		if (clienteParaModificar == null) {
//			response.put("mensaje",
//					"El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
//		}
//
//		try {
//			clienteParaModificar.setNombre(cliente.getNombre()); // cambio los campos
//			clienteParaModificar.setApellido(cliente.getApellido());
//			clienteParaModificar.setEmail(cliente.getEmail());
//			clienteUpdated = clienteService.save(clienteParaModificar); // guardo los cambios
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al acceder a la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		response.put("mensaje", "El cliente ha sido modificado con exito");
//		response.put("cliente", clienteUpdated);
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
//	}
//
//	@DeleteMapping("/clientes/{id}")
////	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public ResponseEntity<?> deleteById(@PathVariable Long id) {
//		Map<String, Object> response = new HashMap<>();
//		try {
//			clienteService.deleteById(id);
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al acceder a la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		response.put("mensaje", "El cliente ha sido borrado con exito");
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/clientes")
////	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public ResponseEntity<?> deleteAll() {
//		Map<String, Object> response = new HashMap<>();
//		try {
//			clienteService.deleteAll();
//		} catch (DataAccessException e) {
//			response.put("mensaje", "Error al acceder a la base de datos");
//			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		response.put("mensaje", "Todos los clientes han sido borrados");
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//	}
}
