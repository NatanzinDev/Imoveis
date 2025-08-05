package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import play.db.jpa.Model;

@Entity
public class TipoImovel extends Model{
	public String descricao;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	public TipoImovel(String descricao) {
		super();
		this.descricao = descricao;
		this.status = Status.ATIVO;
	}
	
	public TipoImovel() {
		
		this.status = Status.ATIVO;
	}
	
}
