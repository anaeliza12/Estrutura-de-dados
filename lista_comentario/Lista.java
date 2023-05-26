package lista_comentario;



import entidades.Comentario;

public class Lista {

	NO lista;


	public class NO {
		Comentario dado;
		NO prox;

	}

	public void inserir(Comentario comentario) {
		NO novo = new NO();
		novo.dado = comentario;
		novo.prox = null;

		if (lista == null) {
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado.getData().before(lista.dado.getData())) {
				novo.prox = lista;
				lista = novo;
			} else {

				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getData().before(novo.dado.getData())) {
						aux = aux.prox;
					} else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}

	}

	



	public boolean remover(int id) {

		boolean achou = false;
		if (lista != null) {
			if (lista.dado.getIdComentario() == id) {

				lista = lista.prox;
				achou = true;
			} else {
				NO aux = lista;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getIdComentario() != id) {
						aux = aux.prox;
					} else {

						aux.prox = aux.prox.prox;
						achou = true;
					}
				}
			}

		}
		return achou;

	}

	public void apresentar() {
		NO aux = lista;
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "------LISTA DE COMENTARIOS ------");
		while (aux != null) {
			System.out.println("\n " + " ID do comentário: " + aux.dado.getIdComentario());
			System.out.println(aux.dado.toString());
			aux = aux.prox;

		}
	}

}