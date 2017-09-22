package QrCode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class ReadQRCode {

	public static void main(String[] args) throws IOException {
        File  file = new File("G:/JAVA/二维码/code/Qr_Code.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        
        QRCodeDecoder codeDecoder = new QRCodeDecoder();
        
        String result =new String (codeDecoder.decode(new MYQRCodeImage(bufferedImage)),"UTF-8");
        
        System.out.println(result);
	}

}
