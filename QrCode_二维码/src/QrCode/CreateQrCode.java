package QrCode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class CreateQrCode {

	public static void main(String[] args) throws IOException {
		Qrcode x =new Qrcode();
		x.setQrcodeErrorCorrect('M');   //纠错等级
		x.setQrcodeEncodeMode('B');     //N代表数字，A代表a-Z ,B代表其他字符
		x.setQrcodeVersion(7);     // 版本号
		
		int width = 67 + 12 *(7-1);    //长宽为67+12*(version-1)
		int height =67 + 12 *(7-1);
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D gs = bufferedImage.createGraphics();
		String qrDate ="使用qrcode生成的二维码";
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		gs.clearRect(0, 0, width, height);
		int pixoff =2 ; //偏移量
		byte [] d = qrDate.getBytes("UTF-8");
		if(d.length > 0 && d.length <120){
			boolean [] [] s = x .calQrcode(d);
			for(int i =0;i<s.length;i++){
				for(int j =0;j< s.length;j++){
					if(s [j] [i]){
						gs.fillRect(j*3 + pixoff, i*3 + pixoff, 3, 3);
					}
				}
			}
		}
		
		gs.dispose();
		bufferedImage.flush();
		
		ImageIO.write(bufferedImage, "png", new File("G:/JAVA/二维码/code/Qr_Code.png"));
	}

}
