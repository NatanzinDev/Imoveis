package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Imovel extends Model{
	public Integer codigoAnuncio;
	public String bairro;
	public Integer quantidadeComodos;
	@Override
	public String toString() {
		return "Imovel: codigoAnuncio=" + codigoAnuncio + ", bairro=" + bairro + ", quantidadeComodos="
				+ quantidadeComodos + ", areaInterna=" + areaInterna + ", areaExterna=" + areaExterna + ", tipoImovel=" + tipoImovel.descricao;
	}

	public Double areaInterna;
	public Double areaExterna;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	@ManyToOne
	public TipoImovel tipoImovel;
	
	public Double getAreaTotal() {
		return this.areaInterna + this.areaExterna;
	}
	
	public Imovel() {
		this.status = Status.ATIVO;
	}
}
