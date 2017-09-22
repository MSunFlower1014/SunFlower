package Zxing_二维码;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Zxing_Code {

	public static void main(String[] args) throws UnsupportedEncodingException {
       //设置长宽，格式，内容
		int width = 300;
       int height =300;
       String format = "png";
       String content = "这是一个使用Zxing生成的二维码";
       //设置编码方式，错误恢复能力，留白
       HashMap hints =new HashMap();
       hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
       hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
       hints.put(EncodeHintType.MARGIN, 2);
       
       try {
    	   BitMatrix bitMatrix = new MultiFormatWriter().encode(new String(content.getBytes("UTF-8"),"ISO-8859-1"), BarcodeFormat.QR_CODE, width, height);
    	   
    	  Path file = new File("G:/JAVA/二维码/code/Zxing_Code.png").toPath();
    	   try {
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (WriterException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
            
	}

}
