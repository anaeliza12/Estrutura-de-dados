package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entidades.Comentario;
import entidades.Conta;
import filasEsg.FilaAmbiental;
import filasEsg.FilaGovernamental;
import filasEsg.FilaSocial;
import lista_comentario.Lista;
//Ana Eliza Perobelli RM:96277
//Vinicius Panessa RM:94591
//Leonardo Alves Batista RM:93868
//Lara Gonçalves RM: 95028
public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner tec = new Scanner(System.in);
		FilaAmbiental fa = new FilaAmbiental();
		FilaSocial fs = new FilaSocial();
		FilaGovernamental fg = new FilaGovernamental();

		Lista comentarios = new Lista();
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		Date data = new Date();
		Date data1 = sdf.parse("31/07/2023 15:22:38"); //4º
		Date data2 = sdf.parse("10/08/2023 18:30:24"); //5º
		Date data3 = sdf.parse("09/03/2023 12:45:46"); //2º
		Date data4 = sdf.parse("12/06/2023 22:39:39"); //3º
		Date data5 = sdf.parse("12/02/2023 23:50:55"); //1º
		Date data6 = sdf.parse("19/12/2023 19:29:12"); //6º
		

		

		Conta consumidor1 = new Conta("Amanda", "amanda@gmail.com", " amanda123", "Brasil", "São Paulo");
		Comentario comentario1 = new Comentario(consumidor1, "Não gostei da embalagem, muito difícil de abrir", data1);

		Conta consumidor2 = new Conta("Carlos", "carlos@gmail.com", " carlos123", "Brasil", "São Paulo");
		Comentario comentario2 = new Comentario(consumidor2, "Amei o design novo da lata de milho Quero!", data2);

		Conta consumidor3 = new Conta("Rosana", "rosana@gmail.com", " rosana123", "Brasil", "São Paulo");
		Comentario comentario3 = new Comentario(consumidor3,
				"Gostei da organização dos funcionário da empresa ao fechar com eles!", data3);

		Conta consumidor4 = new Conta("Pedro", "pedro@gmail.com", " Pedro123", "Brasil", "São Paulo");
		Comentario comentario4 = new Comentario(consumidor4,
				"Melhorar no tempo de resposta, não tive retorno até agora sobre a devolução de um produto", data4);

		Conta consumidor5 = new Conta("Ana", "ana@gmail.com", " ana123", "Brasil", "São Paulo");
		Comentario comentario5 = new Comentario(consumidor5, "Gostei do atendimento", data5);

		Conta consumidor6 = new Conta("Isabela", "isabela@gmail.com", " isabela123", "Brasil", "São Paulo");
		Comentario comentario6 = new Comentario(consumidor6, "Produto fora da validade", data6);
		
       //Inserção de comentarios gerais de usuários, em ordem crescente atraves da data 
		comentarios.inserir(comentario1);
		comentarios.inserir(comentario2);
		comentarios.inserir(comentario3);
		comentarios.inserir(comentario4);
		comentarios.inserir(comentario5);
		comentarios.inserir(comentario6);
		//Inicialização das filas
		fa.init();
		fg.init();
		fs.init();
		
		
		//colocando comentarios nas filas por categoria filtradas no banco de dados 
		fa.enqueue(comentario1);
		fa.enqueue(comentario2);
		
		fg.enqueue(comentario6);
		fg.enqueue(comentario4);
		
		
		fs.enqueue(comentario3);
		fs.enqueue(comentario5);

		
		int opcao ;

		do {

			System.out.println(menuPrincipal());
			opcao = tec.nextInt();
			switch (opcao) {
			case 1:
					System.out.println("Informe o ID do comentario que deseja remover");
					int id = tec.nextInt();
					if(comentarios.remover(id) ) {
						System.out.println("Não ha comentário com o ID informado.");
						
					}else				
						System.out.println("Comentário removido.");
					
				break;

			case 2:
				System.out.println("Comentário removido.");
				fa.dequeue();

				break;

			case 3:

				System.out.println("Comentário removido.");
				fs.dequeue();

				break;
			case 4:
				System.out.println("Comentário removido.");
				fg.dequeue();

				break;

			case 5:
				comentarios.apresentar();
				break;
			case 6:
				fa.apresentar();
				break;
			case 7:
				fs.apresentar();
				break;
			case 8:
				fg.apresentar();
				break;

			}

		} while (opcao != 9);



	}

	public static String menuComentario() {
		String aux = "";

		aux += "1. Inserir comentario" + "\n";
		aux += "2. Remover comentario" + "\n";

		return aux;
	}


	public static String menuPrincipal() {
		String aux = "";

		System.out.println();
		aux += "1. Remover comentario da lista genérica" + "\n";
		aux += "2. Remover comentario da fila do tipo ambiental" + "\n";
		aux += "3. Remover comentario da fila do tipo social" + "\n" ;
		aux += "4. Remover comentario da fila do tipo governamental" + "\n";
		aux += "5. Vizualizar lista de comentarios gerais " + "\n";
		aux += "6. Vizualizar lista de comentarios do tipo ambiental" + "\n";
		aux += "7. Vizualizar lista de comentarios do tipo social" + "\n";
		aux += "8. Vizualizar lista de do tipo governamental"  + "\n";
		aux += "9. Encerrar programa";

		return aux;
	}

	
}
