import java.util.*;

public class Jogo {
    private Palavra palavra;
    private Jogador jogador;
    private int tentativasRestantes;
    private Set<Character> letrasCertas;
    private Set<Character> letrasErradas;

    public Palavra getPalavra() {
        return palavra;
    }

    public Jogo(Jogador jogador, String palavraEscolhida) {
        this.jogador = jogador;
        this.palavra = new Palavra(palavraEscolhida);
        this.tentativasRestantes = 6;
        this.letrasCertas = new HashSet<>();
        this.letrasErradas = new HashSet<>();
    }

    public void iniciar(Scanner scanner) {
        while (tentativasRestantes > 0 && !palavra.completou(letrasCertas)) {
            exibirEstado();

            System.out.print("Digite uma letra: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Digite apenas UMA letra válida.");
                continue;
            }

            char letra = input.charAt(0);

            if (letrasCertas.contains(letra) || letrasErradas.contains(letra)) {
                System.out.println("Letra já foi tentada.");
                continue;
            }

            if (palavra.contemLetra(letra)) {
                letrasCertas.add(letra);
                System.out.println("Letra correta!");
            } else {
                letrasErradas.add(letra);
                tentativasRestantes--;
                System.out.println("Letra errada!");
            }
        }

        exibirEstado();

        if (palavra.completou(letrasCertas)) {
            System.out.println("Parabéns " + jogador.getNome() + ", você venceu!");
        } else {
            System.out.println("Você perdeu... a palavra era: " + palavra.getTexto());
        }
    }

    private void exibirEstado() {
        System.out.println("\nPalavra: " + palavra.revelar(letrasCertas));
        System.out.println("Erros: " + letrasErradas);
        System.out.println("Tentativas restantes: " + tentativasRestantes);
    }
}
