package game;

import java.util.*;

public class Main {
	public static Random random = new Random();
	public static String[] palavras = { 
			"JAVA",
			"UBUNTU",
			"JOGO",
			"ECLIPSE"
	};
	public static String palavraSorteada = palavras[random.nextInt(palavras.length)];
	public static String[] palavraSorteadaDividida = palavraSorteada.split("(?!^)");
	public static List<String> letrasCorretas = new ArrayList<String>();
	public static List<String> letrasEscolhidas = new ArrayList<String>();
	public static String letra = "";
	public static int vidas = 6;
	
	public static void main(String[] args) {
		boolean jogando = true;
		Scanner scanner = new Scanner(System.in);
		letrasCorretas.addAll(Arrays.asList(palavraSorteadaDividida));
		
		System.out.println("===================================================");
		System.out.println("                   JOGO DA FORCA                   ");
		System.out.println("===================================================");
		
		while (jogando) {
			desenhaForca();
			System.out.print("\n\nDigite uma letra: ");
			letra = scanner.next().toUpperCase();
			System.out.println("\n\n");
			if (letrasEscolhidas.contains(letra)) {
				System.out.println("Letra escolhida: [" + letra + "]");
				System.out.println("Você já escolheu essa letra, digite outra...\n");
				vidas--;
			} else {
				letrasEscolhidas.add(letra);
				if (palavraSorteada.contains(letra)) {
					Iterator<String> i = letrasCorretas.iterator();
					while (i.hasNext()) {
						String s = i.next();
						if (s.equals(letra)) {
							i.remove();
						}
					}
					if (letrasCorretas.size() <= 0) {
						desenhaForca();
						jogando = false;
						System.out.println("\n\nVocê venceu, a palavra era: " + palavraSorteada);
					}
				} else {
					vidas--;
					if (vidas <= 0) {
						desenhaForca();
						jogando = false;
						System.out.println("\n\nVocê perdeu, a palavra era: " + palavraSorteada);
					}
				}
			}
		}
		scanner.close();
	}
	
	public static void desenhaForca() {
		System.out.println(" -------");
		System.out.println("|       !");
		if (vidas == 0) {
			System.out.println("|       O");
			System.out.println("|      /|\\");
			System.out.println("|      / \\");
		} else if (vidas == 1) {
			System.out.println("|       O");
			System.out.println("|      /|\\");
			System.out.println("|        \\");
		} else if (vidas == 2) {
			System.out.println("|       O");
			System.out.println("|      /|\\");
			System.out.println("|        ");
		} else if (vidas == 3) {
			System.out.println("|       O");
			System.out.println("|      /|");
			System.out.println("|        ");
		} else if (vidas == 4) {
			System.out.println("|       O");
			System.out.println("|       |");
			System.out.println("|        ");
		} else if (vidas == 5) {
			System.out.println("|       O");
			System.out.println("|        ");
			System.out.println("|        ");
		} else {
			System.out.println("|       ");
			System.out.println("|       ");
			System.out.println("|       ");
		}
		System.out.print("|               ");
		
		for (int i = 0; i < palavraSorteadaDividida.length; i++) {
			if (letra.equals(palavraSorteadaDividida[i])) {
				System.out.print(palavraSorteadaDividida[i] + " ");
			} else if (letrasEscolhidas.contains(palavraSorteadaDividida[i])) {
				System.out.print(palavraSorteadaDividida[i] + " ");
			} else {
				System.out.print("_ ");
			}
		}
		
	}
	
}