package com.study.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.bean.Config;
import com.study.springboot.bean.Member;
import com.study.springboot.bean.Printer;

//@SpringBootApplication	//자동등록을 안하고 수작업으로 주입하기에 주석처리
public class Spring0915Application {

	public static void main(String[] args) {
//		SpringApplication.run(Spring0915Application.class, args);
		
		// 1.Ioc 컨테이너 생성
		ApplicationContext context =		//설정 클래스를 인수로 넘겨서 ApplicationContext를 만든다(생성부터 모든관리를 해준다)
				new AnnotationConfigApplicationContext(Config.class);
		
		// 2.Member Bean 가져오기
		Member member1 = (Member)context.getBean("member1");	//Member.class를 생략하면 Member라고 형변환해준다
		member1.print();
		
		// 3.Member Bean 가져오기		
		Member member2 = context.getBean("hello", Member.class);
		member2.print();
		
		// 4.PrinterB Bean 가져오기
		Printer printer = context.getBean("printerB", Printer.class);	//printerB로 설정했기에 member1은 printerA가 아니고 printerB로 출력
		member1.setPrinter(printer);
		member1.print();
		
		//5.싱글톤인지 확인
//		if(member1 == member2) {
//			System.out.println("동일한 객체입니다.");
//		} else {
//			System.out.println("서로 다른 객체입니다.");
//		}
		
		
	}

}
