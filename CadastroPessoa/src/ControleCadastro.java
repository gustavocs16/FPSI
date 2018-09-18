import java.util.ArrayList;

public class ControleCadastro {
	private ViewCadastro viewCadastro;
	private ArrayList<Pessoa> agenda;

	public ControleCadastro() {
		viewCadastro = new ViewCadastro();
		agenda = new ArrayList<>();
		trataMenu();
	}

	private void trataMenu() {
		boolean continuar = true;
		do {
			String opc = viewCadastro.mostraMenu();

			switch (opc) {
			case "1":
				 agenda.add(viewCadastro.inserir());
				break;
			case "2":
				viewCadastro.listar(agenda);
				break;
			case "3":
				viewCadastro.alterar(agenda);
				break;
			case "4":
				viewCadastro.excluir(agenda);
				break;
			case "5":
				viewCadastro.pesquisar(agenda);
				break;
			case "6":
				System.out.println("Você saiu do software.");
				viewCadastro.sair();
				continuar = false;
				break;	
			default:
				System.out.println("Opção inválida");
				break;
			}
		} while (continuar);
	}

}
