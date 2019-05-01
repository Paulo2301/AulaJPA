package aplicacao;

	import java.util.Scanner;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;

	import dominio.Pessoa;

	public class Programa {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Scanner ler = new Scanner(System.in);
			System.out.println("Digite seu nome:");
			String nome=ler.next();
			System.out.println("Digite seu email:");
			String email=ler.next();
			Pessoa pessoa = new Pessoa(null, nome, email);
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
//			Pessoa pessoaFound = entityManager.find(Pessoa.class, 1);
//			System.out.println(pessoaFound);
//			public void inserPessoa() {
			entityManager.getTransaction().begin();
			entityManager.persist(pessoa);
			entityManager.getTransaction().commit();
//			}
			entityManager.close();
			entityManagerFactory.close();
			
			
		}

}
