package IOBytes;

import java.io.*;

public class ExemploIOBytes {

    public static void copiarArquivo() throws IOException {

        File f = new File("filmes2.txt");
        String nomeArquivo = f.getName();


       /*metodo nao muito utilizado
        InputStream is = new FileInputStream(f.getName());
        BufferedInputStream bis = new BufferedInputStream(is);
        */
        //com o decorator
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f.getName()));


        String nomeArquivoCopia = nomeArquivo.substring(0, nomeArquivo.indexOf("2")).concat("3.txt");

        File fCopia = new File(nomeArquivoCopia);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fCopia.getName()));

        int line = 0;
        while ((line = bis.read()) != -1){
            bos.write((char)line);
            bos.flush();
        }

        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo %s copiado com sucesso e está no diretório %s com %d bytes.", fCopia.getName(), fCopia.getPath(),fCopia.length());
    }
    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }
}
