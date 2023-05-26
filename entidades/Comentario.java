package entidades;

import java.util.Date;


public class Comentario {
	private Conta consumidor;
	private Date data;
	private String comentario;
	private int idComentario;

	
	public Comentario(Conta consumidor,  String comentario,  Date data) {
		this.consumidor = consumidor;
		this.data = data;
		this.comentario = comentario;
		this.idComentario = gerarId();
	}
	
	public int gerarId() {
		int id = (int) (Math.random() * 1001);
		return id;
	}


	public Conta getConsumidor() {
		return consumidor;
	}





	public Date getData() {
		return data;
	}




	public String getComentario() {
		return comentario;
	}




	@Override
	public String toString() {
		return "\n " + "Consumidor: " + consumidor +  "\n" + " Data: " + data +  "\n " + "Comentario: " + comentario ;
	}

	public int getIdComentario() {
		return idComentario;
	}



	
	

}
