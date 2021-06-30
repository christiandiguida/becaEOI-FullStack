package com.fran.eoimvc2.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fran.eoimvc2.models.dto.ClienteDTO;
import com.fran.eoimvc2.models.entity.Clientes;
import com.fran.eoimvc2.models.services.IclienteService;

//@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClientesController {

	@Autowired
	IclienteService clienteService;

	@GetMapping("/clientes")
	public ResponseEntity<?> index() {
		Map<String, Object> response = new HashMap<>();
		List<Clientes> listaClientes = null;
		try {
			listaClientes = clienteService.findAll();

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
		return new ResponseEntity<List<Clientes>>(listaClientes, HttpStatus.OK);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> index(@PathVariable Long id) {
		Clientes cliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cliente = clienteService.findById(id); // Comprobar Accesso a la base de datos
		} catch (DataAccessException e) { // Falla al acceder a la base de datos
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (cliente == null) {
			response.put("mensaje",
					"El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
// Ha podido acceder a la base de datos y el cliente existe
		return new ResponseEntity<Clientes>(cliente, HttpStatus.OK);
	}

	@GetMapping("/clientesdto/{id}")
	public ResponseEntity<?> dto(@PathVariable Long id) {
		Clientes cliente = null;
		Map<String, Object> response = new HashMap<>();
		try {
			cliente = clienteService.findById(id); // Comprobar Accesso a la base de datos
		} catch (DataAccessException e) { // Falla al acceder a la base de datos
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (cliente == null) {
			response.put("mensaje",
					"El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		ClienteDTO dto = new ClienteDTO();
		dto.setId(cliente.getId());
		dto.setEmail(cliente.getEmail());
		dto.setNombre(cliente.getNombre());

		return new ResponseEntity<ClienteDTO>(dto, HttpStatus.OK);
	}

	@PostMapping("/clientes")
//	@ResponseStatus(HttpStatus.CREATED)

	public ResponseEntity<?> create(@Valid @RequestBody Clientes cliente, BindingResult result) {
		Clientes clienteNew = null;
		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {
			List<String> errores = result.getFieldErrors().stream()
					.map((err) -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errores", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			cliente.setCreateAt(new Date()); // Le cambio la fecha que me pase en el front-end
			clienteNew = clienteService.save(cliente);
		} catch (DataAccessException e) { // Falla al acceder a la base de datos
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido insertado con exito");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/clientes/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Clientes cliente, @PathVariable Long id, BindingResult result) {
		Clientes clienteUpdated = null;
		Map<String, Object> response = new HashMap<>();
		Clientes clienteParaModificar = null;
		if (result.hasErrors()) {
			List<String> errores = result.getFieldErrors().stream()
					.map((err) -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errores", errores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			clienteParaModificar = clienteService.findById(id); // busco el cliente a modificar
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (clienteParaModificar == null) {
			response.put("mensaje",
					"El cliente con ID: ".concat(id.toString().concat(" no existe en la base de datos.")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			clienteParaModificar.setNombre(cliente.getNombre()); // cambio los campos
			clienteParaModificar.setApellido(cliente.getApellido());
			clienteParaModificar.setEmail(cliente.getEmail());
			clienteUpdated = clienteService.save(clienteParaModificar); // guardo los cambios
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El cliente ha sido modificado con exito");
		response.put("cliente", clienteUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/clientes/{id}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			clienteService.deleteById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido borrado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@DeleteMapping("/clientes")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deleteAll() {
		Map<String, Object> response = new HashMap<>();
		try {
			clienteService.deleteAll();
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al acceder a la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Todos los clientes han sido borrados");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
