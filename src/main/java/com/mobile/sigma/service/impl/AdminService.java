package com.mobile.sigma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.sigma.dao.AdminDAO;
import com.mobile.sigma.domain.Admin;
import com.mobile.sigma.domain.Status;
import com.mobile.sigma.util.exception.AppuebliarNotFoundException;
import com.mobile.sigma.util.exception.NullAppuebliarException;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminDAO AdminDAO;

	public Admin guardarAdmin(Admin Admin) throws NullAppuebliarException, AppuebliarNotFoundException {
		Admin response = AdminDAO.save(Admin);
		return response;
	}

	public Status borrarAdmin(String nickname) throws NullAppuebliarException, AppuebliarNotFoundException {
		AdminDAO.deleteById(nickname);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");
		return response;
	}

	public Object obtenerAdmines() throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Admin> response = (List<Admin>) AdminDAO.findAll();
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "No hay administradores activos");
		}

		return response;
	}


}
