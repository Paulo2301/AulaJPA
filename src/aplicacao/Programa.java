package aplicacao;

	import java.util.List;
	import java.util.Scanner;
	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;

	import dominio.Pessoa;

	public class Programa {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Scanner ler = new Scanner(System.in);
			
//			System.out.println("Digite seu nome:");
//			String nome=ler.next();
//			System.out.println("Digite seu email:");
//			String email=ler.next();
//			Pessoa pessoa = new Pessoa(null, nome, email);
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Digite 1 para: Listar pessoas cadastradas\n"+"Digite 2 para: "
					+ "Buscar uma pessoa por ID\n"+"Digite 3 para: Cadastrar pessoa\n"+
					"Digite 4 para: Atualizar pessoa\n"+"Digite 5 para: Remover uma pessoa\n"+
					"Digite 0 para: Sair do Banco\n");
			int escolha = ler.nextInt();
			while(escolha != 0) {
			if(escolha==1) {
				String jpql="SELECT p FROM Pessoa p";
				List<Pessoa>pessoas = entityManager.createQuery(jpql,Pessoa.class).getResultList();
				System.out.println(pessoas\n);
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+ "Digite 1 para: Listar pessoas cadastradas\n"+"Digite 2 para: "
						+ "Buscar uma pessoa por ID\n"+"Digite 3 para: Cadastrar pessoa\n"+
						"Digite 4 para: Atualizar pessoa\n"+"Digite 5 para: Remover uma pessoa\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
			}
			else if(escolha==2) {
				System.out.println("Digite o ID a ser procurado:");
				int id=ler.nextInt();
				Pessoa pessoaFound= entityManager.find(Pessoa.class,id);
				System.out.println(pessoaFound);
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+ "Digite 1 para: Listar pessoas cadastradas\n"+"Digite 2 para: "
						+ "Buscar uma pessoa por ID\n"+"Digite 3 para: Cadastrar pessoa\n"+
						"Digite 4 para: Atualizar pessoa\n"+"Digite 5 para: Remover uma pessoa\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
			}
			else if (escolha==3) {
				System.out.println("Digite seu nome:");
				String nome=ler.next();
				System.out.println("Digite seu email:");
				String email=ler.next();
				Pessoa pessoa = new Pessoa(null, nome, email);
				entityManager.getTransaction().begin();
				entityManager.persist(pessoa);
				entityManager.getTransaction().commit();
				System.out.println("Cadastro feito com sucesso!");
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+ "Digite 1 para: Listar pessoas cadastradas\n"+"Digite 2 para: "
						+ "Buscar uma pessoa por ID\n"+"Digite 3 para: Cadastrar pessoa\n"+
						"Digite 4 para: Atualizar pessoa\n"+"Digite 5 para: Remover uma pessoa\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
			}
			else if(escolha==4) {
				System.out.println("Digite o ID a ser atualizado:");
				int id=ler.nextInt();
				Pessoa pessoaFound= entityManager.find(Pessoa.class,id);
				System.out.println("Se deseja atualizar:\n email:Digite 1\n nome:Digite 2\n"
						+ "os dois anteriores: Digite 3");
				int escolhaDeAlteracao = ler.nextInt();
				if(escolhaDeAlteracao==1) {
					System.out.println("Alterar email para:");
					String novoemail= ler.next();
					pessoaFound.setEmail(novoemail);
					entityManager.getTransaction().begin();
					entityManager.persist(pessoaFound);
					entityManager.getTransaction().commit();
					System.out.println("Alteração feita com sucesso!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
							+ "Digite 1 para: Listar pessoas cadastradas\n"+"Digite 2 para: "
							+ "Buscar uma pessoa por ID\n"+"Digite 3 para: Cadastrar pessoa\n"+
							"Digite 4 para: Atualizar pessoa\n"+"Digite 5 para: Remover uma pessoa\n"+
							"Digite 0 para: Sair do Banco\n");
					escolha = ler.nextInt();
				}
				else if(escolhaDeAlteracao==2) {
					System.out.println("Alterar nome para:");
					String novonome= ler.next();
					pessoaFound.setNome(novonome);
					entityManager.getTransaction().begin();
					entityManager.persist(pessoaFound);
					entityManager.getTransaction().commit();
					System.out.println("Alteração feita com sucesso!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
							+ "Digite 1 para: Listar pessoas cadastradas\n"+"Digite 2 para: "
							+ "Buscar uma pessoa por ID\n"+"Digite 3 para: Cadastrar pessoa\n"+
							"Digite 4 para: Atualizar pessoa\n"+"Digite 5 para: Remover uma pessoa\n"+
							"Digite 0 para: Sair do Banco\n");
					escolha = ler.nextInt();
				}
				else if(escolhaDeAlteracao==3) {
					System.out.println("Alterar email para:");
					String novoemail= ler.next();
					pessoaFound.setEmail(novoemail);
					System.out.println("Alterar nome para:");
					String novonome= ler.next();
					pessoaFound.setNome(novonome);
					entityManager.getTransaction().begin();
					entityManager.persist(pessoaFound);
					entityManager.getTransaction().commit();
					System.out.println("Alteração feita com sucesso!");
					System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
							+ "Digite 1 para: Listar pessoas cadastradas\n"+"Digite 2 para: "
							+ "Buscar uma pessoa por ID\n"+"Digite 3 para: Cadastrar pessoa\n"+
							"Digite 4 para: Atualizar pessoa\n"+"Digite 5 para: Remover uma pessoa\n"+
							"Digite 0 para: Sair do Banco\n");
					escolha = ler.nextInt();
				}
				
			}
			else if(escolha==5) {
				System.out.println("Digite o ID a ser removido:");
				int id=ler.nextInt();
				Pessoa pessoaFound= entityManager.find(Pessoa.class,id);
				entityManager.getTransaction().begin();
				entityManager.remove(pessoaFound);
				entityManager.getTransaction().commit();
				System.out.println("Removido com sucesso!");
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+ "Digite 1 para: Listar pessoas cadastradas\n"+"Digite 2 para: "
						+ "Buscar uma pessoa por ID\n"+"Digite 3 para: Cadastrar pessoa\n"+
						"Digite 4 para: Atualizar pessoa\n"+"Digite 5 para: Remover uma pessoa\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
			}

			
		 }	
			if(escolha==0) {
				entityManager.close();
				entityManagerFactory.close();
				System.out.println("Bye!");
				}
		
			
		}

}
