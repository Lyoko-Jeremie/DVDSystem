
import java.util.Scanner;



/**
 * 启动引导用<br>
 * @author Jeremie
 *
 */
public class Test {

	public static void main(String[] args) {
		// 启动范例
		Scanner in = new Scanner(System.in);
		Menu a = new Menu();
		a.mainMenu(in);
		in.close();
	}
	
}



