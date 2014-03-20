import java.util.Scanner;

/**
 * 菜单<br>
 * TODO 菜单也要预留可扩展空间，特别是预留用户验证部分和管理员菜单<br>
 */

/**
 * @author Jeremie
 *
 */
public class Menu {

	/**
	 * 用户菜单接口
	 */
	UserMenu um; 
	
	/**
	 * 主数据节点
	 */
	private ControlMain mainDate;
	
	/**
	 * 反多对象保护
	 */
	private static int PRO = 0;
	
	/**
	 * 唯一的无参构造函数<br>
	 * @param mainDate
	 */
	public Menu() {
		if ( Menu.PRO>0) {
			// 反多对象保护
			throw new ExceptionInInitializerError("\n\tOnly Can Create One Menu Object!!!");
		}
		++Menu.PRO;
		this.mainDate = new ControlMain();
		this.um= new UserMenu( this.mainDate );
	}
	
	/**
	 * 析构<br>
	 * 减少计数
	 */
	protected void finalize() {
		--Menu.PRO;
	}
	
	/**
	 * 程序主循环<br>
	 * 唯一的一个公有函数<br>
	 * @param in	控制台Scanner对象
	 */
	public void mainMenu( Scanner in){
		
		{
			//TODO 测试用数据初始化，没有文件时使用的方法
		}
		
		// 初始化&启动提示
		System.out.println("欢迎进入DVD租买系统");
		
		// 现在只是有用户界面，这个位置为扩展管理界面而预留
		um.menu(in);
		
		//TODO 整个系统退出
		System.out.println("谢谢使用DVD租买系统");

	}
	

}














/**
 * 用户菜单类
 * @author Jeremie
 *
 */
class UserMenu{
	
	/**
	 * 主数据节点
	 */
	private ControlMain mainDate;
	
	/**
	 * 反多对象保护
	 */
	private static int PRO = 0;
	
	/**
	 * 构造函数
	 * @param mainDate
	 */
	public UserMenu(ControlMain mainDate) {
		if ( UserMenu.PRO>0) {
			// 反多对象保护
			throw new ExceptionInInitializerError("\n\tOnly Can Create One Menu Object!!!");
		}
		++UserMenu.PRO;
		this.mainDate = mainDate;
	}
	
	/**
	 * 析构<br>
	 * 减少计数
	 */
	protected void finalize() {
		--UserMenu.PRO;
	}
	
	/**
	 * 用户
	 * @param in
	 */
	public void menu(Scanner in) {
		while (true) {
			
			// 循环界面显示
			this.MainU();
			
			int selectInt = resolveInput.getInt(in.nextLine());
			
			//TODO 清空界面
			
			switch (selectInt) {
			case 1:
				{
					
				}
				break;

			case 2:
				{
					
				}
				break;

			case 3:
				{
					
				}
				break;

			case 4:
				{
					
				}
				break;

			case 5:
				{
					
				}
				break;

			case 6:
				{
					
				}
				break;

			case 7:
				{
					
				}
				break;

			case 8:
				{
					
				}
				break;

			case 9:
				{
					//TODO 扫尾&用户退出提示
					return;
				}
//				break;

			case 0:	// 同default
			default:
				break;
			}
			
			// 暂停，等待任意键
			in.reset();
			System.out.println("\n请按任意键继续.....");
			in.nextLine();
			
			//TODO 清空界面
			
		}
	}
	
	
	/**
	 * 用户菜单菜单选择界面
	 */
	private void MainU(){
//		System.out.println("Test, These is Menu Text.");
		System.out.println("欢迎来到用户菜单");
		System.out.println("==========================");
		System.out.println("1)\t查看所有可租或可卖的DVD");
		System.out.println("2)\t查看自己已经租的和买的DVD");
		System.out.println("3)\t买一个DVD");
		System.out.println("4)\t租一个DVD");
		System.out.println("5)\t退一个已经租的DVD");
		System.out.println("6)\t");
		System.out.println("9)\t退出用户菜单");
		System.out.println("==========================");
		System.out.println("请输入您所选择的功能的数字：");
	}
	
}







/**
 * 静态专用类<br>
 * 禁止构造<br>
 * @author Jeremie
 *
 */
class resolveInput {
	
	/**
	 * 禁用构造函数
	 */
	private resolveInput() {
		// 禁用构造函数
	}
	
	/**
	 * 解析输入字符串到int<br>
	 * @param in
	 * @return	没有解析出整数返回0	返回1~9
	 */
	public static int getInt(String in) {
		for (char a : in.toCharArray() ) {
			if (Character.isDigit(a)) {
				return (int) ( a - '0' );
			}
		}
		return 0;
	}
	
}





