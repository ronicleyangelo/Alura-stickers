package GerarFigurinhas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Font;
import java.io.InputStream;

public class GeradorDeFigurinhas {
    public void criar(InputStream inputStream, String nomeArquivo, String texto) throws Exception {

        //leitura da imagem
        BufferedImage imageOriginal = ImageIO.read(inputStream);
        // criar nova imagem em memória com transparência e com tamnanho novo

        Integer largura   = imageOriginal.getWidth() + 300;
        Integer altura    = imageOriginal.getHeight();
        Integer newAltura = altura + 300;
        BufferedImage novaImage = new BufferedImage(largura,newAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics2D = (Graphics2D) novaImage.getGraphics();
        graphics2D.drawImage(imageOriginal, 0,0, null);

        var fonte = new Font(Font.MONOSPACED, Font.HANGING_BASELINE, 88);
        graphics2D.setFont(fonte);
        graphics2D.setColor(Color.YELLOW);
        graphics2D.setBackground(Color.darkGray);

        // escrever uma nova imagem
        graphics2D.drawString(texto, 0, newAltura - 90);
        ImageIO.write(novaImage,"png", new File("./src/saida/" + nomeArquivo));
    }
}
