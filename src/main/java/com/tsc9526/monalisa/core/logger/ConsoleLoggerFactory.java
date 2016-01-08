package com.tsc9526.monalisa.core.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLoggerFactory implements LoggerFactory {
	ConsoleLoggerFactory() {
	}

	public Logger getLogger(String category) {
		return INSTANCE;
	}

	private static final Logger INSTANCE = new Logger() {
		public void debug(String message) {
			println("DEBUG",message);
		}

		public void debug(String message, Throwable t) {
			println("DEBUG",message,t);
		}

		public void error(String message) {
			println("ERROR",message);
		}

		public void error(String message, Throwable t) {
			println("ERROR",message,t);
		}

		public void info(String message) {
			println("INFO",message);
		}

		public void info(String message, Throwable t) {
			println("INFO",message,t);
		}

		public void warn(String message) {
			println("WARN",message);
		}

		public void warn(String message, Throwable t) {
			println("WARN",message,t);
		}

		public boolean isDebugEnabled() {
			return false;
		}

		public boolean isInfoEnabled() {
			return true;
		}

		public boolean isWarnEnabled() {
			return true;
		}

		public boolean isErrorEnabled() {
			return true;
		}

		public boolean isFatalEnabled() {
			return true;
		}
		
		private void println(String level,String message){
			println(message,null);
		}
		
		private void println(String level,String message, Throwable t){
			StringBuffer sb=new StringBuffer();
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sb.append(sdf.format(new Date())).append(" [").append(level).append("] ").append(message);
			
			if(t!=null){
				StringWriter writer=new StringWriter(4*1024);
				t.printStackTrace(new PrintWriter(writer));
				sb.append("\r\n").append(writer.getBuffer().toString());
			}
			
			if(level.equals("ERROR")){
				System.err.println(sb.toString());
			}else{
				System.out.println(sb.toString());
			}
		}
	};
}