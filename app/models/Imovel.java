package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Imovel extends Model{
	public Integer codigoAnuncio;
	public String bairro;
	public Integer quantidadeComodos;
	public Double areaInterna;
	public Double areaExterna;
	
	@ManyToOne
	public TipoImovel tipoImovel;
	
	public Double getAreaTotal() {
		return this.areaInterna + this.areaExterna;
	}
}
