package com.vitaltecnologia.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.vitaltecnologia.pedidovenda.model.Cliente;
import com.vitaltecnologia.pedidovenda.repository.Clientes;
import com.vitaltecnologia.pedidovenda.util.jpa.Transactional;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clientes.documentoReceitaFederal(cliente.getDocumentoReceitaFederal());
		//porSku(produto.getSku());
		
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente com o CPF informado.");
		}
		
		return clientes.guardar(cliente);
	}
	
}
