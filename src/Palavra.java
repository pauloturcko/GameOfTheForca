import java.util.Set;

public class Palavra {
    private final String texto;

    public Palavra(String texto) {
        this.texto = texto.toLowerCase();
    }

    public boolean contemLetra(char letra) {
        return texto.indexOf(letra) != -1;
    }

    public String revelar(Set<Character> letrasCertas) {
        StringBuilder revelada = new StringBuilder();
        // ^ Classe nativa do Java
        // Manipula sequencia de caracteres - Thread Safe

        for (char c : texto.toCharArray()) {
            if (letrasCertas.contains(c)) {
                revelada.append(c).append(" ");
            } else {
                revelada.append("_ ");
            }
        }

        return revelada.toString().trim();
    }

    public boolean completou(Set<Character> letrasCertas) {
        for (char c : texto.toCharArray()) {
            if (!letrasCertas.contains(c)) return false;
        }
        return true;
    }

    public String getTexto() {
        return texto;
    }
}
