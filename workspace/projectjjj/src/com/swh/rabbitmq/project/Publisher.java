package com.swh.rabbitmq.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.SerializationUtils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class Publisher {

	private final static String QUEUE_NAME = "ykm";

	private Publisher(FileInputStream file){

	}

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("183.99.87.90");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);

		WatchService watchService
		= FileSystems.getDefault().newWatchService();

		Path path = Paths.get("C:/Users/ykm09/Desktop/coding/_publishTestFile");

		path.register(
				watchService, 
				StandardWatchEventKinds.ENTRY_CREATE, 
				StandardWatchEventKinds.ENTRY_DELETE, 
				StandardWatchEventKinds.ENTRY_MODIFY);

		WatchKey key;

		while ((key = watchService.take()) != null) {
			for (WatchEvent<?> event : key.pollEvents()) {

				if(StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())){
					String sPath = "C:/Users/ykm09/Desktop/coding/_publishTestFile/"+event.context();

					byte[] arr = new byte[500];

					FileInputStream inputStream = new FileInputStream(sPath);
					FileData d = new FileData(event.context().toString());
					
					int data = -1;
					while((data = inputStream.read()) != -1 ){
						d.setData(data);
//						outputStream.write(d.getData());
						byte[] data2 = SerializationUtils.serialize(d);
						channel.basicPublish("", QUEUE_NAME, null, data2);
						Arrays.fill(arr, (byte)0);
					}

//					channel.basicPublish("", QUEUE_NAME, null, data2);
					inputStream.close();
					System.out.println(" [x] Sent Success  ");

					Files.delete(Paths.get(sPath));
//					channel.close();
//					connection.close();
					
					//					System.out.println(event.context());
				}

				key.reset();
			}
		}
	}
}