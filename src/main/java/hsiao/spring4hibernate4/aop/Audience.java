package hsiao.spring4hibernate4.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect//定義一個切面
public class Audience {
	/**
	 * 定義一個切點
	 * define Pointcut
	 */
	@Pointcut("execution(* hsiao.spring4hibernate4.dao.impl.*.*(..))") // expression
	public void adviceMethod(){
		
	}
	//定義一個通知Before
	@Before("adviceMethod()")
	public void doBeforeTask(){
		System.out.println("		─▀▀▀▀▀▀█▀▀▀▀▀▀──────▄▄");
		System.out.println("		───▄▀█▀▀█▀▀█▄▄▄▄▄▄▄▄▀▀");
		System.out.println("		─▄█▄▄█▄▄█▄▄█████▀▀▀──");
		System.out.println("		█████████████▀");
		System.out.println("		─▄▄█▄▄▄▄▄▄▄█▄▄ ★○ ★ . *:. *. ° ○ °.. *.☾° *♥¸　.　☾ °☆. • *¨ `* •");
	}
	//定義一個通知After
	@After("adviceMethod()")
	public void doAfterTask(){
		System.out.println("		█◣　　　█　　　　　　　◢█ ");
		System.out.println("		█◥◣　　█　◢██◣　　　 █ ");
		System.out.println("		█　◥◣　 █　 █　    █　　　  █ ");
		System.out.println("		█　　◥◣ █　█　　█　　　  █ ");
		System.out.println("		█　　　◥ █   ◥██◤   　   ██");
	}
}
