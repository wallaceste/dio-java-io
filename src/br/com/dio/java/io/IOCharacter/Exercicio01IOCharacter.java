package br.com.dio.java.io.IOCharacter;

import java.io.*;

public class Exercicio01IOCharacter {
    public static void receberTecladoImpirmirConsole() throws IOException {

        /* forma menos comum

        InputStream is = System.in; //recebe do teclado
        InputStreamReader isr = new InputStreamReader(is); //converte em caractere
        BufferedReader br = new BufferedReader(isr); //armazena em um buffer

        */

        System.out.println("Recomende 3 filmes: ");

        //é mais comum fazer da proxima forma, usando o padrão decorator
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //cria um buffer de leitura com todas as funções do metodo comentado


        String line = br.readLine(); //metodo buffered que lé o que foi digitado e joga em uma string

        /* forma menos comum
        OutputStream os = System.out; //imprime no console
        OutputStreamWriter osw = new OutputStreamWriter(os); //converte em caractere
        BufferedWriter bw = new BufferedWriter(osw); //armazena em um buffer
        */

        //é mais comum fazer da proxima forma, usando o padrão decorator
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //cria um buffer de leitura com todas as funçães do metodo comentado


        do {
            bw.write(line); //escrever no console
            bw.newLine(); //pular linha
            line = br.readLine(); //recarregar linha pra seguir laço
        }while (!(line.isEmpty()));
        bw.flush(); //descarregar o buffer

        br.close(); //fechar o buffer
        bw.close(); //fechar o buffer

    }

    public static void main(String[] args) throws IOException {
        receberTecladoImpirmirConsole();
    }
}
