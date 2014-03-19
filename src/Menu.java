import java.util.Scanner;

/**
 * 菜单
 */

/**
 * @author Jeremie
 *
 */
public class Menu {
	//TODO 菜单也要预留可扩展空间，特别是预留用户验证部分和管理员菜单
	
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
		if (PRO>0) {
			// 反多对象保护
			throw new ExceptionInInitializerError("\n\tOnly Can Create One Menu Object!!!");
		}
		++PRO;
		this.mainDate = new ControlMain();
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
		
		while (true) {
			
			// 循环界面显示
			this.mainU();
			
			int selectInt = this.resolveInputInt(in.nextLine());
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
					//TODO 扫尾&退出提示
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
	 * 解析输入字符串到int<br>
	 * @param in
	 * @return	没有解析出整数返回0	返回1~9
	 */
	private int resolveInputInt(String in) {
		for (char a : in.toCharArray() ) {
			if (Character.isDigit(a)) {
				return (int) ( a - '0' );
			}
		}
		return 0;
	}
	
	/**
	 * 菜单选择界面
	 */
	private void mainU(){
		//TODO U Text
		System.out.println("Test, These is Menu Text.");
		System.out.println("请选择您所需的功能");
	}

}




