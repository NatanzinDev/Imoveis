package controllers;

import java.util.List;

import models.Status;
import models.TipoImovel;
import play.mvc.Controller;

public class TipoImoveis extends Controller {

	public static void formTipo() {
		render();
	}

	public static void salvar(TipoImovel tipo) {
		if (tipo != null) {
			tipo.save();
			flash.success("Tipo de imóvel salvo com sucesso!", tipo.descricao);
		} else {
			flash.error("Ocorreu algum erro ao salvar");
		}
		listar();
	}

	public static void excluir(Long id) {

		TipoImovel tipo = TipoImovel.findById(id);

		if (tipo != null) {
			tipo.status = Status.DESATIVADO;
			tipo.save();
			flash.success("Tipo de imóvel foi desativado com sucesso!");
			listar();
		} else {
			flash.error("Ocorreu algum erro ao desativar");
			listar();
		}
		
	}

	public static void editar(Long id) {

		TipoImovel tipo = TipoImovel.findById(id);
		renderTemplate("TipoImoveis/formtipo.html", tipo);
		
	}

	public static void listar() {
		List<TipoImovel> tipos = TipoImovel.find("status <> ?1", Status.DESATIVADO).fetch();
		render(tipos);
	}

}
