import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    

    public void cria() throws IOException{

        // leitura da imagen
        BufferedImage imagemOriginal = ImageIO.read(getClass().getResource("filme.jpg"));
        //criar nova imagem em memoria com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);
        // copiar a imagem original para a nova imagem(em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        

        // escrever uma frase na nova imagem

        //escrever a nova imagem em um arquivo
        ImageIO.write( novaImagem, "png", new File("figurinha.png"));

    }
    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }
}
