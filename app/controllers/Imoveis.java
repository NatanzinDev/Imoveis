package controllers;

import java.util.List;

import models.Imovel;
import models.Status;
import models.TipoImovel;
import play.mvc.Controller;

public class Imoveis extends Controller{
	
	public static void formimovel() {
		List<TipoImovel> tipos = TipoImovel.find("status <> ?1", Status.DESATIVADO).fetch();
		render(tipos);
	}
	
	public static void salvar(Imovel imovel) {
		List<Imovel> imoveis = Imovel.find("status <> ?1", Status.DESATIVADO).fetch();
		if (imovel != null) {
			
			for(Imovel i : imoveis) {
				if(i.codigoAnuncio.equals(imovel.codigoAnuncio)) {
					flash.error("Ocorreu algum erro ao salvar");
					listar();
				}
			}
			
			imovel.save();
			flash.success("Imóvel salvo com sucesso!");
			detalhar(imovel.id);
		} else {
			flash.error("Ocorreu algum erro ao salvar");
			listar();
		}
		
	}
	
	public static void listar() {
		List<Imovel> imoveis = Imovel.find("status <> ?1", Status.DESATIVADO).fetch();
		render(imoveis);
	}
	
	
	public static void detalhar(Long id) {
		Imovel imovel = Imovel.findById(id);
		render(imovel);
	}
	
	public static void editar(Long id) {
		List<TipoImovel> tipos = TipoImovel.find("status <> ?1", Status.DESATIVADO).fetch();
		Imovel imovel = TipoImovel.findById(id);
		renderTemplate("Imoveis/formimovel.html", imovel, tipos);
		
	}
}
