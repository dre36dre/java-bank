package com.br.dre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.dre.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

//	void save(com.br.dre.model.Client client);

}
