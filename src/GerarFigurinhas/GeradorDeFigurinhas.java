package GerarFigurinhas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class GeradorDeFigurinhas {
    public void criar() throws Exception {

        //leitura da imagem
        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BY2Q2NDI1MjUtM2Q5ZS00MTFlLWJiYWEtNTZmNjQ3OGJkZDgxXkEyXkFqcGdeQXVyNTI4MjkwNjA@.jpg").openStream();
//       InputStream inputStream = new FileInputStream("./src/image/DancesWith.jpg");
        BufferedImage imageOriginal = ImageIO.read(inputStream);

        // criar nova imagem em memória com transparência e com tamnanho novo
        Integer largura   = imageOriginal.getWidth() + 200;
        Integer altura    = imageOriginal.getHeight();
        Integer newAltura = altura + 200;
        BufferedImage novaImage = new BufferedImage(largura,newAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics2D = (Graphics2D) novaImage.getGraphics();
        graphics2D.drawImage(imageOriginal, 0,0, null);

        var fonte = new Font(Font.MONOSPACED, Font.HANGING_BASELINE, 89);
        graphics2D.setFont(fonte);
        graphics2D.setColor(Color.MAGENTA);
        graphics2D.setBackground(Color.CYAN);

        // escrever uma nova imagem
        graphics2D.drawString("Default is about", 0, newAltura - 100);
        ImageIO.write(novaImage,"png", new File("./src/saida/.png"));
    }
    public static void main (String[] args) throws Exception {
        var geradora = new GeradorDeFigurinhas();
        geradora.criar();
    }
}
