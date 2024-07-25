package Diario_Virtual;

import java.util.Scanner;

//classe principal do "principal"
public class Principal {
	public static void main(String[] args) {
	//incicializando scanner, objetos e variáveis
    Scanner scanner = new Scanner(System.in);
    Diario diario = new Diario();
	//variavel responsável por manter o usuário logado, ou não logado
    Usuario usuarioLogado = null;
    //variavel que confirma informações de login e controla o looo do menu 1
	boolean autenticado_usuario = false;
    //variavel que controla o loop dos menus
	boolean rodando = true;
     
	//loop geral
	while(rodando){
		//loop do menu 1
	    while (!autenticado_usuario) {
	
	    	//opções do menu 1        	
	    	System.out.println("Olá, seja bem vindo ao Diário Virtual!");
			System.out.println("1. Registrar novo usuário");
			System.out.println("2. Login");
			System.out.println("3. Sair do Diário");
			System.out.print("Escolha uma opção: ");
			String opcao1 = scanner.nextLine();
			switch (opcao1) {
				case "1":
						
				//sistema que coleta e compara dados de login
				System.out.print("Informe o nome de usuário: ");
				String username = scanner.nextLine();
				System.out.print("Informe a senha: ");
				String senha = scanner.nextLine();
	
				//nesta função as informações fornecidas pelo usuário são verificadas, e caso sejam confimadas o menu 1 retorna para que o usuario possa logar	
				diario.registrarUsuario(username, senha, false);
				
				boolean rodando2=false;
				while (!rodando2)
				{
					System.out.println("Deseja logar com a conta criada?");
					System.out.println("Digite Sim ou Não");
					//iniciando variável para controlar o while
					String answer = scanner.nextLine();
					switch (answer.toLowerCase())
					{
						case "sim":
						//alterando o valor de autenticado_usuario para sair do menu 1 
						autenticado_usuario = true;
						//autenticando e logando o usuário
						usuarioLogado = diario.autenticarUsuario(username, senha);
						System.out.println("\nLogin bem-sucedido!");
						//método responsável por efetuar o login						
						Diario.login(usuarioLogado);
						//alterando o valor de rodando2 para sair do loop
						rodando2=true;
						break;
						
						case "não":
						System.out.println("Retornando ao menu...\n");
						//alterando o valor de rodando2 para sair do loop
						rodando2=true;
						break;
						
						default:
						System.out.println("Opção Inválida. Tente Novamente\n");
					}
				}
				break;
				
				case "2":
				//sistema usado para logar o usuário 					
				System.out.print("Nome de usuário: ");
				username = scanner.nextLine();
				System.out.print("Senha: ");
				senha = scanner.nextLine();
				//usando a variavel usuarioLogado, é possível verificar se o processo de autenticação de username e senha sucedeu
				usuarioLogado = diario.autenticarUsuario(username, senha);
				//caso usuarioLogado não retorne null, o processo foi um sucesso
				if (usuarioLogado != null) {
					//alterando o valor de autenticado_usuario para sair do menu 1						
					autenticado_usuario = true;
					System.out.println("\nLogin bem-sucedido!");
					//método responsável por efetuar o login						
					Diario.login(usuarioLogado);
					}
					//caso usuárioLogado retorne null, o usuário é notificado e o menu 1 volta a ser repetido
					else {
						System.out.println("\nLogin falhou. Tente novamente.\n");
					}
				break;
				
				case "3":
				//opção para fechamento direto do diario					
				System.out.println("Volte sempre :)");
				System.out.println("Saindo do Diário de Bordo...\n");
				
				//com essas alterações em "autenticado_usuario" e "rodando" o loop acaba e o código encerra               	
				autenticado_usuario = false;
	           	rodando = false;					
	          	return;
				default: 
				//caso o usuário fuja das entradas válidas nesse menu, uma mensagem	é exibida e o menu 1 volta a ser exibido	
				System.out.print("\nOpção inválida. Tente novamente.\n\n");
				break;
			}
    }

    //uma vez que o usuário está devidamente autenticado e logado, e a variável autenticado_usuario == true, o menu 2 é exibido 
    while(autenticado_usuario){
	    System.out.println("\nDiário de Bordo");
	    //caso o usuário tenha acesso aos dados de login como adimin, e faça login como, opções extras são exibidas
	    if (usuarioLogado.isAdmin()) {
		    //opções extras ao ser admin
		    //admin pode visualizar qualquer entrada salva posteriormente por qualquer usuário          	
		    System.out.println("001. ADM Visualizar Entradas");
		
		    //admins podem substituir a ultima entrada do diário de qualquer usuário por uma nova entrada           	
		    System.out.println("002. ADM Substituir Entradas");
		
		    //admins podem continuar a escrever sob a última entrada de qualquer usuário        	
		    System.out.println("003. ADM Sobrescrever Entradas");
		
		    //admins podem excluir a última entrada escrita posteriormente por qualquer usuário     	
		    System.out.println("004. ADM Deletar Entradas");
	    }
	
	    //opções disponíveis para usuarios comuns e admins            
	    //apenas adiciona uma entrada 
	    System.out.println("1. Adicionar Entrada");
	
	    //vizualiza as entradas escritas pelo próprio usuário             
	    System.out.println("2. Visualizar Entradas");
	
	    //usando uma palavra-chave, realiza-se uma pesquisa nas entradas escritas pelo usuário posteriormente    
	    System.out.println("3. Pesquisar Entradas");
	
	    //conta-se o número de palavras escritas pelo usuário         
	    System.out.println("4. Contar Palavras nas Entradas");
	
	    //realiza o logout do usuário e retorna ao menu 1            
	    System.out.println("5. Logout");
	
	    //fecha o diario diretamente            
	    System.out.println("6. Sair do Diário");
	    System.out.print("Escolha uma opção: ");
	          
	    String opcao2 = scanner.nextLine();
	
	    switch (opcao2) {
		    case "001":
		    //verificação de segurança 
		    if (usuarioLogado.isAdmin()) {
		    	//função responsável por exibir entradas de usuários diversos          			
		    	diario.visualizarEntradasAdmin();
		        } else {
		        	System.out.println("Opção inválida. Tente novamente.\n");
		        }
		    break;
		    case "002":
		    //verificação de segurança 
		    if (usuarioLogado.isAdmin()) {
			    //exibe entradas de usuários diversos
			    diario.visualizarEntradasAdmin();
			    System.out.print("\nDigite o usuario que deseja modificar a entrada: ");
		        String username = scanner.nextLine();
		     	System.out.print("Digite uma nova entrada: ");
		   		String novaEntrada = scanner.nextLine();
		
		   		//método que, usando o usuário e entrada fornecidos, adiona-a ao diário escolhido         			
		   		diario.substituirEntradasAdmin(username, novaEntrada);
		    } else {
		    	System.out.println("Opção inválida. Tente novamente.");
		    }
		    break;
		    case "003":
		    //verificação de segurança 
		    if (usuarioLogado.isAdmin()) {
		    	//exibe entradas de usuários diversos            			
		    	diario.visualizarEntradasAdmin();
		        System.out.print("\nDigite o usuario que deseja modificar a entrada: ");
		   		String username = scanner.nextLine();
		        System.out.print("Adicione uma nova entrada sobre a do usuário: ");
		 		String novaEntrada = scanner.nextLine();
		
		 		//método responsável por substituir a entrada do usuário escolhido pela entrada escrita pelo admin
		
		 		diario.sobrescreverEntradasAdmin(username, novaEntrada);
		        } else {
		        System.out.println("Opção inválida. Tente novamente.");
		    }
		    break;
		    case "004":
		    //verificação de segurança 
          	if (usuarioLogado.isAdmin()) {
          		diario.visualizarEntradasAdmin();
          		System.out.print("\nDigite o nome do usuario: ");
          		String usuario = scanner.nextLine();
          		//método resposável por apagar todas entradas de um usuário
         		diario.deletarEntradasAdmin(usuario);
          		diario.visualizarEntradasAdmin();
          		} else {
          			System.out.println("Opção inválida. Tente novamente.");
          		}
          	break;
            case "1":
                  System.out.println("\nEscreva sua entrada (linha em branco para terminar):");
                  //inicializando o StringBuilder
                  StringBuilder entrada = new StringBuilder();
                  String linha;
                  //while responsável por terminar uma entrada
                  while (!(linha = scanner.nextLine()).isEmpty()) {
                      entrada.append(linha).append("\n");
                  }
                  diario.adicionarEntrada(entrada.toString().trim());
                  break;
              case "2":
              	diario.visualizarEntradas();
              break;
              case "3":
                  System.out.print("\nDigite a palavra-chave para pesquisar: ");
                  String palavraChave = scanner.nextLine();
                  //método responsável por pesquisar a palavra-chave nas entradas do usuário
                  diario.pesquisarEntradas(palavraChave);
              break;
              case "4":
            	//método por contar quantas palavras existem na entrada
              	int Qntd_Palavras = diario.contarPalavrasTotais();
              	if(Qntd_Palavras == 0){
              		System.out.print("\nNão há entradas escritas no diário\n");
              	}
              	else {
              		System.out.print("Há " + Qntd_Palavras + " palavra(s) escrita(s) no diário.\n");
              	}
              break;
              case "5":
            	  //método que realiza o logout do usuário e retorna ao menu 1
                  Diario.logout();
                  //redefinindo autenticado_usuario para que o loop do menu 1 possa recomeçar
                  autenticado_usuario = false;
              break;
              case "6":
            	  //realizando logout do usuário
              	Diario.logout();
              	//saindo do loop do menu 2
              	autenticado_usuario = false;
              	//saindo do loop geral
              	rodando = false;
              	System.out.println("Saindo do Diário de Bordo...\n");
              break;
              default:
            	  System.out.println("Opção inválida. Tente novamente.");
            	  break;
	    			}
    		}
		}
		scanner.close();
	}
}
