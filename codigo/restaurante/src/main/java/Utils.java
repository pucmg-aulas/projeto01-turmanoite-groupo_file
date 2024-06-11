package main.java;


import java.util.regex.Pattern;

public class Utils {

    static void clear() { // Limpa a tela do console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean nomeValido(String nome) {
        if (nome == null || nome.isEmpty() || !Pattern.compile("[a-zA-Z ]*").matcher(nome).matches())
            return false;

        return true;
    }

    public static String formatarNome(String nome) {
        nome = nome.trim();// Remove espaços extras no início e no fim

        String[] palavras = nome.split(" "); // Separa o nome de usuário em palavras

        StringBuilder nomeFormatado = new StringBuilder(); // Construtor para o nome de usuário formatado

        for (int i = 0; i < palavras.length; i++) {
            if (i == 0 || Character.isSpaceChar(palavras[i - 1].charAt(palavras[i - 1].length() - 1))) { // Verifica se
                                                                                                         // é a primeira
                                                                                                         // palavra ou
                                                                                                         // após um
                                                                                                         // espaço
                nomeFormatado.append(palavras[i].substring(0, 1).toUpperCase())
                        .append(palavras[i].substring(1).toLowerCase());
            } else {
                nomeFormatado.append(palavras[i].toLowerCase());
            }
        }

        String formatado = nomeFormatado.toString().replaceAll(" +", " "); // Remove espaços extras entre palavras

        return formatado;
    }
}
