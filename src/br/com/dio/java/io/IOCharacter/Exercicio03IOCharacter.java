package br.com.dio.java.io.IOCharacter;

import java.io.*;

public class Exercicio03IOCharacter {

    public static void criarCopiaArquivoTxt() throws IOException {
        File f = new File("C:/Users/Wallace/IdeaProjects/dio-java-io/filmes.txt");
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

        System.out.printf("Arquivo \"%s\" copiado com sucesso! Com o tamanho '%d'", f.getName(), f.length());
        System.out.printf("Arquivo \"%s\" criado com sucesso! Com o tamanho '%d'", fcopy.getName(), fcopy.length());



    }
    public static void lerTecladoEscreverNoArquivo() throws IOException {

    }

    public static void main(String[] args) throws IOException {

    }

}
