package com.zebra;

import java.lang.management.ManagementFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CommodityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommodityApplication.class, args);
		String jvmName = ManagementFactory.getRuntimeMXBean().getName();
		log.info("当前项目进程号：" + jvmName.split("@")[0]);
	}
}
