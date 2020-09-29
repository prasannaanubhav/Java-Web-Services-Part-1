package com.soap.mtom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

	@Override
	public void upload(DataHandler attachments) {

		try {
			InputStream inputStream = attachments.getInputStream();
			OutputStream outputStream = new FileOutputStream(
					new File("C:\\Users\\Anubhav\\Desktop\\upload\\upload.jpg"));
			byte b[] = new byte[10000000];
			int len = 0;
			while ((len = inputStream.read(b)) != -1) {
				outputStream.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataHandler download() {

		return new DataHandler(new FileDataSource(new File("C:\\Users\\Anubhav\\Desktop\\upload\\upload.jpg")));
	}

}
