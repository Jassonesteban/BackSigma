package com.mobile.sigma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mobile.sigma.domain.Admin;
import com.mobile.sigma.service.impl.AdminService;
import com.mobile.sigma.util.exception.AppuebliarNotFoundException;
import com.mobile.sigma.util.exception.NullAppuebliarException;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,
		RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.TRACE }, allowedHeaders = "*")
public class AdminController {

	@Autowired
	private AdminService AdminService;

	@PutMapping
	public ResponseEntity<Object> guardarAdmin(@RequestBody Admin Admin) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(AdminService.guardarAdmin(Admin));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> borrarAdmin(@PathVariable String id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(AdminService.borrarAdmin(id));
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<Object> obtenerAdmines() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(AdminService.obtenerAdmines());
		} catch (NullAppuebliarException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		} catch (AppuebliarNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(exception.getMessage());
		}
	}

	

}
