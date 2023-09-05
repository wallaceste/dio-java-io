package br.com.dio.java.io.IOCharacter;

import java.io.*;
import java.util.Scanner;

public class Exercicio02IOCharacter {

    public static void lerTecladoEscreverDocumento() throws IOException {
        PrintWriter pw = new PrintWriter(System.out); //classe que funciona tal qual o sout
        pw.println("Recomende 3 filmes: ");
        pw.flush(); //descarregar console

        Scanner scan = new Scanner(System.in); //classe que incia teclado
        String line = scan.nextLine(); //ler linha e pula pra proxima

        File f =  new File("filmes.txt"); //define o  arquivo que vai ser usado pra armazenar os dados

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName())); //cria um buffer de leitura e cria o documento

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = scan.nextLine();
        }while (!(line.equalsIgnoreCase("fim")));

        pw.println("Arquivo \"%s\" salvo com sucesso" + f.getName());

        scan.close();
        bw.close();
        pw.close();

    }

    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }

}
