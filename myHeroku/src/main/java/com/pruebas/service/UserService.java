package com.pruebas.service;

import org.springframework.stereotype.Service;

import com.pruebas.modelo.dto.UserDTO;

@Service
public interface UserService {

	boolean isUser(String name, String password);
}
