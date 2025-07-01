import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== JOGO DA FORCA ====");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        Jogador jogador = new Jogador(nome);
        BancoDePalavras banco = new BancoDePalavras("palavras.txt");

        boolean continuar = true;

        while (continuar) {
            Jogo jogo = new Jogo(jogador, banco.sortearPalavra());
            jogo.iniciar(scanner);

            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            continuar = resposta.equals("s");
        }

        System.out.println("Obrigado por jogar!");
        scanner.close();
    }
}
