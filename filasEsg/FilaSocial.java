package filasEsg;

import entidades.Comentario;

public class FilaSocial {
	public class NO {
		Comentario dado;
		NO prox;
	}

	NO ini;
	NO fim;

	public void init() {
		ini = fim = null;
	}

	public boolean isEmpty() {
		if (ini == null && fim == null)
			return true;
		else
			return false;
	}

	public void enqueue(Comentario comentario) {
		NO novo = new NO();
		novo.dado = comentario;
		novo.prox = null;
		if (isEmpty()) {
			ini = novo;
		} else
			fim.prox = novo;

		fim = novo;
	}

	public Comentario dequeue() {
		Comentario elem = ini.dado;
		ini = ini.prox;
		if (ini == null) {
			fim = null;
		}
		return elem;

	}

	public void apresentar() {
		NO aux = ini;
		System.out.println("\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "------FILA SOCIAL------");
		while (aux != null) {
			System.out.println(aux.dado.toString());
			aux = aux.prox;
		}
	}

}
