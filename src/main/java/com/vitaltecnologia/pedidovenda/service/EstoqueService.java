package com.vitaltecnologia.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.vitaltecnologia.pedidovenda.model.ItemPedido;
import com.vitaltecnologia.pedidovenda.model.Pedido;
import com.vitaltecnologia.pedidovenda.repository.Pedidos;
import com.vitaltecnologia.pedidovenda.util.jpa.Transactional;

public class EstoqueService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pedidos pedidos;
	
	@Transactional
	public void baixarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		for (ItemPedido item : pedido.getItens()) {
			item.getProduto().baixarEstoque(item.getQuantidade());
		}
	}

	public void retornarItensEstoque(Pedido pedido) {
		pedido = this.pedidos.porId(pedido.getId());
		
		for (ItemPedido item : pedido.getItens()) {
			item.getProduto().adicionarEstoque(item.getQuantidade());
		}
	}
	
}
