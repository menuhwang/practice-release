package com.likelion.hospital;

import com.likelion.hospital.context.ReadLineContext;
import com.likelion.hospital.dao.HospitalDao;
import com.likelion.hospital.domain.Hospital;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HospitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

//	private static final int THREAD_COUNT = 16;
//	public static void main(String[] args) throws IOException {
//		ConfigurableApplicationContext context = SpringApplication.run(HospitalApplication.class, args);
//		ReadLineContext<Hospital> hospitalReadLineContext = (ReadLineContext<Hospital>) context.getBean("hospitalReadLineContext");
//		HospitalDao hospitalDao = context.getBean(HospitalDao.class);
//		List<Hospital> hospitals = hospitalReadLineContext.readByLine("fulldata.txt");
//
//		long start = System.currentTimeMillis();
//		/* 약 25분 소요
//		for (Hospital hospital : hospitals) {
//			hospitalDao.insert(hospital);
//		}
//		*/
//
//		// thread 적용 : 178초
//		List<Thread> threads = new ArrayList<>();
//		for (int i = 0; i < THREAD_COUNT; i++) {
//			int total = hospitals.size();
//			int unit = total / THREAD_COUNT;
//			int fromIdx = i * unit;
//			int toIdx = (i < THREAD_COUNT - 1) ? fromIdx + unit : total;
//			InsertThread insertThread = new InsertThread(hospitalDao, hospitals, fromIdx, toIdx);
//			insertThread.start();
//			threads.add(insertThread);
//		}
//		for (Thread th : threads) {
//			try {
//				th.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println("Insert done. " + (System.currentTimeMillis() - start) + "ms");
//	}
//
//	static class InsertThread extends Thread {
//		final HospitalDao dao;
//		final List<Hospital> hospitals;
//		final int fromIdx;
//		final int toIdx;
//
//		public InsertThread(HospitalDao dao, List<Hospital> hospitals, int fromIdx, int toIdx) {
//			this.dao = dao;
//			this.hospitals = hospitals;
//			this.fromIdx = fromIdx;
//			this.toIdx = toIdx;
//		}
//
//		@Override
//		public void run() {
//			for (int i = fromIdx; i < toIdx; i++) {
//				dao.insert(hospitals.get(i));
//			}
//		}
//	}
}
