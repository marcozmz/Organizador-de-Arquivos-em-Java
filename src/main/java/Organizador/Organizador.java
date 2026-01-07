package Organizador;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.stream.Stream;

public class Organizador {
    public static void main(String[] args) {
        JFileChooser seletor = new JFileChooser();

        seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int resposta = seletor.showOpenDialog(null);

        if(resposta != JFileChooser.APPROVE_OPTION){
            System.out.println("Nenhuma pasta foi selecionada. Encerrando...");
            return;
        }

        Path pasta = seletor.getSelectedFile().toPath();

        int contImg = 1;
        int contArq = 1;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(pasta)){
            for(Path arquivo : stream) {
                if(Files.isDirectory(arquivo)){
                    continue;
                }

                System.out.println("Arquivo encontrado: " + arquivo.getFileName());
                String nome = arquivo.getFileName().toString();

                if (nome.endsWith(".jpg") || nome.endsWith(".jpeg") || nome.endsWith(".webp")) {
                    System.out.println(nome + " é uma imagem");

                    String extensao = "";
                    int ponto = nome.lastIndexOf(".");
                    if(ponto >= 0){
                        extensao = nome.substring(ponto);
                    }

                    String novoNome = String.format("foto_%02d%s", contImg, extensao);

                    Path subpastaImg = pasta.resolve("imagens");
                    Files.createDirectories(subpastaImg);
                    Path destinoFinal = subpastaImg.resolve(novoNome);
                    Files.move(arquivo, destinoFinal, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(nome + " foi para pasta imagens!");
                    System.out.println(nome + " -> " + novoNome);
                    contImg++;

                } else if (nome.endsWith(".pdf")) {
                    System.out.println(nome + " é um pdf");

                    String extensao = "";
                    int ponto = nome.lastIndexOf(".");
                    if(ponto >= 0){
                        extensao = nome.substring(ponto);
                    }

                    String novoNome = String.format("arquivo_%02d%s", contArq, extensao);

                    Path subpastaArq = pasta.resolve("arquivos");
                    Files.createDirectories(subpastaArq);
                    Path destinoFinal = subpastaArq.resolve(novoNome);
                    Files.move(arquivo, destinoFinal, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println(nome + " foi para pasta arquivos!");
                    System.out.println(nome + " -> " + novoNome);
                    contArq++;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
