package hsiao.spring4hibernate4.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	/**
	 * define Pointcut
	 */
	@Pointcut("execution(* hsiao.spring4hibernate4.dao.impl.*.*(..))") // expression
	public void adviceMethod(){
		
	}
	@Before("adviceMethod()")
	public void doBeforeTask(){
		System.out.println("		─▀▀▀▀▀▀█▀▀▀▀▀▀──────▄▄");
		System.out.println("		───▄▀█▀▀█▀▀█▄▄▄▄▄▄▄▄▀▀");
		System.out.println("		─▄█▄▄█▄▄█▄▄█████▀▀▀──");
		System.out.println("		█████████████▀");
		System.out.println("		─▄▄█▄▄▄▄▄▄▄█▄▄ ★○ ★ . *:. *. ° ○ °.. *.☾° *♥¸　.　☾ °☆. • *¨ `* •");
	}
	
	@After("adviceMethod()")
	public void doAfterTask(){
		System.out.println("		█◣　　　█　　　　　　　◢█ ");
		System.out.println("		█◥◣　　█　◢██◣　　　 █ ");
		System.out.println("		█　◥◣　 █　 █　    █　　　  █ ");
		System.out.println("		█　　◥◣ █　█　　█　　　  █ ");
		System.out.println("		█　　　◥ █   ◥██◤   　   ██");
	}
}
