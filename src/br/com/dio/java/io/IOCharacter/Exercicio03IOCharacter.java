package br.com.dio.java.io.IOCharacter;

import java.io.*;

public class Exercicio03IOCharacter {

    public static void criarCopiaArquivoTxt() throws IOException {
        File f = new File("filmes.txt");
        String nomeArquivo = f.getName();

        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        String line = br.readLine();

        String nomeArquivoCopia = nomeArquivo.substring(0, nomeArquivo.indexOf(".")).concat("2.txt");
        File fcopy = new File(nomeArquivoCopia);

        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        }while (!(line == null));

        System.out.printf("Arquivo \"%s\" copiado com sucesso! Com o tamanho '%d' bytes. \n", f.getName(), f.length());
        System.out.printf("Arquivo \"%s\" criado com sucesso! Com o tamanho '%d' bytes. \n", fcopy.getName(), fcopy.length());

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        lerTecladoEscreverNoArquivo(fcopy.getName());

        pw.printf("Tudo certo. Tamanho do arquivo %d bytes.", fcopy.length());

        br.close();
        bw.close();
        pw.close();

    }
    public static void lerTecladoEscreverNoArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
        //append true serve pra acrescentar mantendo o conteudo que ja tem no arquivo

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }while (!(line.equalsIgnoreCase("fim")));

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        criarCopiaArquivoTxt();
    }

}
