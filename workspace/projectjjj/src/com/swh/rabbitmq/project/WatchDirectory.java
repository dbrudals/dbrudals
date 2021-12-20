package com.swh.rabbitmq.project;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeoutException;

public class WatchDirectory{

	private String fileName;

	public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {

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
					Publisher12 publisher = new Publisher12();
					publisher.publish(event.context().toString());
					
//					Thread t = new Thread(new Runnable() {
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//							try {
//								Publisher12 publisher = new Publisher12();
//								publisher.publish(event.context().toString());
//							} catch (IOException | TimeoutException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						}
//					});
//
//					t.start();
				}
				// * 파일을 보내는 코드.
				//				System.out.println(
				//						"Event kind:" + event.kind() 
				//						+ ". File affected: " + event.context() + ".");
			}
			key.reset();
		}
	}
}