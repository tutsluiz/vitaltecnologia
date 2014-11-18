package com.vitaltecnologia.pedidovenda.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.vitaltecnologia.pedidovenda.model.Cliente;
import com.vitaltecnologia.pedidovenda.service.CadastroClienteService;
import com.vitaltecnologia.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//@Inject
	//private Categorias categorias;
	
	@Inject
	private CadastroClienteService cadastroClienteService;
	
	private Cliente cliente;
	//private Categoria categoriaPai;
	
	//private List<Categoria> categoriasRaizes;
	//private List<Categoria> subcategorias;
	
	public CadastroClienteBean() {
		limpar();
	}
	
	/*
	public void inicializar() {
		/*
		if (FacesUtil.isNotPostback()) {
			categoriasRaizes = categorias.raizes();
			
			if (this.categoriaPai != null) {
				carregarSubcategorias();
			}
		}
		
		FacesUtil.addInfoMessage("Cliente inicializado com sucesso!");
	}
	/*
	public void carregarSubcategorias() {
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}
	*/
	private void limpar() {
		cliente = new Cliente();
		//categoriaPai = null;
		//subcategorias = new ArrayList<>();
	}
	
	public void salvar() {
		this.cliente = cadastroClienteService.salvar(this.cliente);
		limpar();
		
		FacesUtil.addInfoMessage("Cliente salvo com sucesso!");
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		/*
		if (this.cliente != null) {
			this.categoriaPai = this.cliente.getCategoria().getCategoriaPai();
		}
		*/
	}
/*
	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	*/
	public boolean isEditando() {
		return this.cliente.getId() != null;
	}

}