import java.util.List;
import java.util.Scanner;

public class ViewCadastro {
	private Scanner teclado;

	public ViewCadastro() {
		teclado = new Scanner(System.in);
	}

	public String mostraMenu() {
		System.out.println("MENU");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar");
		System.out.println("4 - Excluir");
		System.out.println("5 - Pesquisar");
		System.out.println("6 - Sair");
		System.out.println("Opção: ");
		return teclado.nextLine();
	}

	public Pessoa inserir() {
		Pessoa umaPessoa = new Pessoa();
		System.out.println("INSERIR");
		System.out.println("Nome: ");
		umaPessoa.setNome(teclado.nextLine());

		System.out.println("E-Mail: ");
		umaPessoa.setEmail(teclado.nextLine());

		System.out.println("Fone: ");
		umaPessoa.setFone(teclado.nextLine());

		return umaPessoa;
	}

	public void listar(List<Pessoa> agenda) {
		System.out.println("\nLISTA DE CADASTRADOS");
		for (int pos = 0; pos < agenda.size(); pos++) {
			System.out.println("Posição: " + pos + " : " + agenda.get(pos).toString());
		}

	}
	
	public void excluir(List<Pessoa> agenda) {
	System.out.println("Digite o número da posição:");
		int n = Integer.parseInt(teclado.nextLine());
		agenda.remove(n);
	        }
	
	public void pesquisar(List<Pessoa> agenda) {
		boolean controlador = true;
		Pessoa pesquisa = new Pessoa();
		System.out.println("Digite o nome da pessoa:");
		pesquisa.setNome(teclado.nextLine());
		
		for(int i = 0; i < agenda.size(); i++) {
			if(agenda.get(i).getNome().contains(pesquisa.getNome()) == true)
			{
				System.out.println("Encontrado:");
				System.out.println("Nome "+ agenda.get(i).getNome());
				System.out.println("E-Mail: " + agenda.get(i).getEmail());
				System.out.println("Fone: " + agenda.get(i).getFone());
				controlador = false;
			}
		}
		if(controlador == true)
		{
			System.out.println("Nome não foi encontrado em nosso cadastro.");
		}
	}
	
	public void alterar(List<Pessoa> agenda) {
		listar(agenda);
		boolean continuar = true;
		int pos = 0;
		do {
			System.out.println("Digite a posição do registro para alterar: ");
			try {
				pos = Integer.parseInt(teclado.nextLine());
				if (pos >= 0 & pos < agenda.size()) {
					continuar = false;
				}else {
					System.out.println("Digite um valor válido!");
				}
			} catch (Exception e) {
				System.out.println("Valor digitado inválido!!!");
			}
		} while (continuar);
		
		
		
		System.out.println("Nome ("+ agenda.get(pos).getNome() +"): ");
		agenda.get(pos).setNome(teclado.nextLine());
		
		System.out.println("E-Mail ("+ agenda.get(pos).getEmail() +"): ");
		agenda.get(pos).setEmail(teclado.nextLine());
		
		System.out.println("Fone ("+ agenda.get(pos).getFone() +"): ");
		agenda.get(pos).setFone(teclado.nextLine());
		
		
	}
	public void sair() {
		System.exit(0);
	}


}
