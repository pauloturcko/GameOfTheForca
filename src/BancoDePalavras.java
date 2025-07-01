import java.io.*;
import java.util.*;

public class BancoDePalavras {
    private final List<String> palavras;

    public BancoDePalavras(String caminhoArquivo) {
        this.palavras = new ArrayList<>();
        carregarDeArquivo(caminhoArquivo);
    }

    private void carregarDeArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    palavras.add(linha.trim().toLowerCase());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo de palavras: " + e.getMessage());
            System.exit(1);
        }
    }

    public String sortearPalavra() {
        Random random = new Random();
        return palavras.get(random.nextInt(palavras.size()));
    }
}
