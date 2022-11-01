package com.mbavellar.coursesb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbavellar.coursesb.domain.Client;
import com.mbavellar.coursesb.repositories.ClientRepository;
import com.mbavellar.coursesb.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	public Client findById(Integer id) {
		return clientRepository.findById(id).orElseThrow(
				() -> new ObjectNotFoundException("Object NOT found! Id: " + id +
						", Tipo: " + Client.class.getName()));
		
	}
}
