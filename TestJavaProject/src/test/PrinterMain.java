package test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PrinterMain {

	public static void main(String[] args) {

		// Spring Container 생성 
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
	
		
		Printer printer = (Printer) ctx.getBean("printer");
		printer.print();
	}

}
