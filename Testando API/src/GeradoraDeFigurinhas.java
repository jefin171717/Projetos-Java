import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;


import javax.imageio.ImageIO;


public class GeradoraDeFigurinhas {
    

    public void cria(InputStream inputStream, String nomeArquivo) throws IOException{

        // leitura da imagen
        // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
        
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        //criar nova imagem em memoria com transparencia e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);
        
        // copiar a imagem original para a nova imagem(em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        

        // escrever uma frase na nova imagem
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 150);
        graphics.setFont(fonte);
        graphics.setColor(Color.RED);
        graphics.drawString("Finalmente", 90, novaAltura - 70);
        //escrever a nova imagem em um arquivo
        ImageIO.write( novaImagem, "png", new File("saida/"+ nomeArquivo));

    }
    
}
