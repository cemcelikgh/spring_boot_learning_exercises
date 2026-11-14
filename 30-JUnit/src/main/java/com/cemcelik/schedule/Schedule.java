package com.cemcelik.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

	@Scheduled(cron = "0 00 5 * * *")
//	@Scheduled(cron = "*/5 * * * * *")
	public void writeOneToTen() {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}

	}

}
