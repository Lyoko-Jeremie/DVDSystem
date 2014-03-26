import java.util.ArrayList;
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
	UserMenu userMenuHandle; 
	
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
			throw new ExceptionInInitializerError(
				"\n\tOnly Can Create One Menu Object!!!"
				);
		}
		++Menu.PRO;
		this.mainDate = new ControlMain();
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
			Test.init(mainDate);
		}
		
		// 初始化&启动提示
		Toolz.println("欢迎进入DVD租买系统");
		
		// 现在只是有用户界面，这个位置为扩展管理界面而预留
		this.userMenuHandle = new UserMenu(mainDate, "");
		this.userMenuHandle.menu(in);
		
		//TODO 整个系统退出
		Toolz.println("谢谢使用DVD租买系统");

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
	 * 用户对象句柄
	 */
	private User userHandle;
	
//	/**
//	 * 反多对象保护
//	 */
//	private static int PRO = 0;
	
	/**
	 * 构造函数
	 * @param mainDate
	 * @param userName
	 */
	public UserMenu(ControlMain mainDate, String userName) {
//		if ( UserMenu.PRO>0) {
//			// 反多对象保护
//			throw new ExceptionInInitializerError(
//				"\n\tOnly Can Create One UserMenu Object!!!"
//				);
//		}
//		++UserMenu.PRO;
		this.mainDate = mainDate;
		this.userHandle = mainDate.getUser(userName);
	}
	
//	/**
//	 * 析构<br>
//	 * 减少计数
//	 */
//	protected void finalize() {
//		--UserMenu.PRO;
//	}
	
	/**
	 * 用户
	 * @param in
	 */
	public void menu(Scanner in) {
		while (true) {
			
			// 循环界面显示
			this.MainU();
			
			int selectInt = Toolz.getInt(in.nextLine());
			
			Toolz.clearConsole();
			
			switch (selectInt) {
			case 1:
				{	// 1)\t查看所有可租或可卖的DVD
					this.listAllDVD();
				}
				break;

			case 2:
				{	// 2)\t查看自己已经租的和买的DVD
					this.listMyDVD();
				}
				break;

			case 3:
				{	// 3)\t买一个DVD
					this.buyDVD(in);
				}
				break;

			case 4:
				{	// 4)\t租一个DVD
					this.rentDVD(in);
				}
				break;

			case 5:
				{	// 5)\t退一个已经租的DVD
					this.reDVD(in);
				}
				break;

			case 6:
				{	// 6)\t按名搜索DVD
					this.searchInKey(in);
				}
				break;

			case 7:
				{	// 7)\t分类显示DVD
					this.viewDVDInStyle(in);
				}
				break;
				
//			case 10:
//			{	// Test
//				for (int i = 0; i < this.mainDate.getStyleSize(); i++) {
//					Toolz.println(this.mainDate.getStyle(i));
//				}
//			}
//			break;

			case 0:
				{
					// TO DO 文件保存
					Toolz.println("您已经退出用户菜单.");
					return;
				}
//				break;
				
			case -1:	// 同default
			default:
				Toolz.println("请输入正确的选项.");
				break;
			}
			
			// 暂停，等待任意键
			in.reset();
			Toolz.println("\n请按回车键继续.....");
			in.nextLine();
			
			Toolz.clearConsole();
			
		}
	}
	
	
	/**
	 * 用户菜单菜单选择界面
	 */
	private void MainU(){
		Toolz.println();
//		Toolz.println("Test, These is Menu Text.");
		Toolz.println("欢迎 " + this.userHandle.getName() + " 来到用户菜单");
		Toolz.println("==========================");
		Toolz.println("1)\t查看所有可租或可卖的DVD");
		Toolz.println("2)\t查看自己已经租的和买的DVD");
		Toolz.println("3)\t买一个DVD");
		Toolz.println("4)\t租一个DVD");
		Toolz.println("5)\t退一个已经租的DVD");
		Toolz.println("6)\t关键字搜索DVD");
		Toolz.println("7)\t分类显示DVD");
		Toolz.println("0)\t退出用户菜单");
		Toolz.println("==========================");
		Toolz.println("请输入您所选择的功能的数字：");
	}

	/**
	 * 列出所有的
	 */
	private void listAllDVD()
	{
		/*
 		 *电影必须有名字、年份、电影类型、状态
		 *例如： 小时代 ：2013年：爱情 喜剧 校园：可买|可租
		 */
		Toolz.println();
		for (int i = 0; i < mainDate.getDVDSize(); i++) {
			DVD Temp = mainDate.getDVD(i);
			Toolz.print( i + ") " + getDVDFormartBaseInform(Temp) + getDVDFormartRBInform(Temp) );
			Toolz.println();
		}
	}
	
	/**
	 * 返回格式化的DVD可租买信息
	 * @param t
	 * @return
	 */
	private String getDVDFormartRBInform(DVD t) {
		String f = new String();
		f+="余量：" + t.getAmount() + " ; ";
		if (t.canSell()) {
			f+="可买";
		} else {
			f+="不可买";
		}
		f+="|";
		if (t.canRent()) {
			f+="可租";
		} else {
			f+="不可租";
		}
		return f;
	}
	
	/**
	 * 返回格式化的基本DVD信息
	 * @param t
	 * @return
	 */
	private String getDVDFormartBaseInform(DVD t) {
		String f = new String( t.getTitle() + " ; " + t.getYear() + "年 ; " );
		for (int j = 0; j < t.styleGetSize(); j++) {
			String ts = mainDate.getStyle(t.styleGet(j));
			if (null == ts) {
				return null;
			}
			f += ts;
			if ( j != t.styleGetSize() - 1 ) {
				f += " ";	// 空格分离
			}else {
				f += " ; ";
			}
		}
		return f;
	}

	/**
	 * 列出自己的
	 */
	private void listMyDVD()
	{
		Toolz.println();
		Toolz.println( "用户 " + userHandle.getName() + " 的所有DVD");
		for (int i = 0; i < userHandle.getDVDListSize(); i++) {
			DVD Temp = mainDate.getDVD( userHandle.getDVDListIndexID(i) );
			if (Temp.getTitle().equals(userHandle.getDVDListIndexName(i))) {
				Toolz.print( i + ") " + getDVDFormartBaseInform(Temp) );
				if (userHandle.getDVDListIndexBuyAmount(i) > 0) {
					Toolz.print( "已买数量：" + userHandle.getDVDListIndexBuyAmount(i) );
				}
				if (userHandle.getDVDListIndexRentAmount(i) > 0) {
					Toolz.print( "已租数量：" + userHandle.getDVDListIndexRentAmount(i) );
				}
				Toolz.println();
			}
		}
		if (userHandle.getDVDListSize() == 0) {
			Toolz.println("什么也没有...");
		}
	}

	/**
	 * 买
	 */
	private void buyDVD(Scanner in)
	{
		Toolz.println("以DVD名购买选1\t以DVD编号购买选2\n请选择并回车【有的名字可能搜索不到】");
		int s = Toolz.getInt(in.nextLine());
		DVD Temp = null;
		switch (s) {
		case 1:
		{
			Toolz.println("请输入想要买的DVD名并以回车结束：");
			String name = in.nextLine();
			Temp = mainDate.getDVD(name);
			if (Temp == null) {
				Toolz.println("找不到指定的DVD");
				return;
			}
		}
			break;
			
		case 2:
		{
			Toolz.println("请输入想要购买的DVD编号并回车");
			int index = Toolz.getCompInt( in.nextLine() );
			Temp = mainDate.getDVD(index);
			if (Temp == null) {
				Toolz.println("找不到指定的DVD");
				return;
			}
		}
			break;

		default:
			Toolz.println( "输入错误，购买失败。" );
			return;
//			break;
		}
		
		Toolz.println( "找到的DVD信息：" );
		Toolz.println( getDVDFormartBaseInform(Temp) + getDVDFormartRBInform(Temp) );
		
		Toolz.println( "价格：\n租价：" + Temp.getRentPrice() + "\t买价：" + Temp.getBuyPrice() );
		if (!Temp.canSell()) {
			Toolz.println( "很可惜，这个DVD已经无法再出售。" );
			return;
		}
		if (userHandle.buyDVD(Temp)) {
			Toolz.println( "购买成功" );
			return;
		}
		Toolz.println( "购买失败" );
		return;
		
	}
	
	/**
	 * 借
	 */
	private void rentDVD(Scanner in)
	{
		Toolz.println("以DVD名租借选1\t以DVD编号租借选2\n请选择并回车【有的名字可能搜索不到】");
		int s = Toolz.getInt(in.nextLine());
		DVD Temp = null;
		switch (s) {
		case 1:
		{
			Toolz.println("请输入想要租的DVD名并以回车结束：");
			String name = in.nextLine();
			Temp = mainDate.getDVD(name);
			if (Temp == null) {
				Toolz.println("找不到指定的DVD");
				return;
			}
		}
			break;
			
		case 2:
		{
			Toolz.println("请输入想要租借的DVD编号并回车");
			int index = Toolz.getCompInt(in.nextLine());
			Temp = mainDate.getDVD(index);
			if (Temp == null) {
				Toolz.println("找不到指定的DVD");
				return;
			}
		}
			break;

		default:
			Toolz.println( "输入错误，租借失败。" );
			return;
//			break;
		}
		
		Toolz.println( "找到的DVD信息：" );
		Toolz.println( getDVDFormartBaseInform(Temp) + getDVDFormartRBInform(Temp) );

		Toolz.println( "价格：\n租价：" + Temp.getRentPrice() + "\t买价：" + Temp.getBuyPrice() );
		if (!Temp.canRent()) {
			Toolz.println( "很可惜，这个DVD已经无法再租借。" );
			return;
		}
		if (userHandle.rentDVD(Temp)) {
			Toolz.println( "租借成功" );
			return;
		}
		Toolz.println( "租借失败" );
		return;
		
	}

	/**
	 * 退
	 */
	private void reDVD(Scanner in)
	{
		Toolz.println("以DVD名退选1\t以DVD编号退选2\n请选择并回车【有的名字可能搜索不到】");
		int s = Toolz.getInt(in.nextLine());
		switch (s) {
		case 1:
		{
			Toolz.println("请输入想要还的DVD名并以回车结束：");
			String name = in.nextLine();
			if ( userHandle.reDVD(name) ) {
				Toolz.println("归还成功");
			}else {
				Toolz.println("归还失败");
			}
			return;
		}
//			break;
			
		case 2:
		{
			Toolz.println("请输入想要还的DVD编号并回车");
			int index = Toolz.getCompInt(in.nextLine());
			if ( userHandle.reDVD(index) ) {
				Toolz.println("归还成功");
			}else {
				Toolz.println("归还失败");
			}
			return;
		}
//			break;

		default:
			Toolz.println( "输入错误，租借失败。" );
			return;
//			break;
		}
		
	}
	
	private void viewDVDInStyle(Scanner in) {
		Toolz.println("现有的类型如下：");
		for (int i = 0; i < this.mainDate.getStyleSize(); i++) {
			Toolz.print(this.mainDate.getStyle(i) + " ");
		}
		Toolz.println();
		Toolz.println();
		Toolz.println("请输入要限定的类型，多个类型之间请以空格格开：");
		String inString = in.nextLine();
		String[] inStringArray = inString.split(" ");
		ArrayList<Long> inIDArrayList = new ArrayList<Long>();
		for (String a : inStringArray) {
			if ( this.mainDate.getStyleID(a) != 0) {
				inIDArrayList.add( this.mainDate.getStyleID(a) );
			}
		}
		Toolz.println();
//		Toolz.println("从输入中解析到的已有类型如下：");
		Toolz.println("将以下类型的搜索结果：");
		for (Long a : inIDArrayList) {
			Toolz.print( this.mainDate.getStyle(a) + " " );
		}
		Toolz.println();
		Toolz.println();
		// 搜索
		for (int i = 0; i < this.mainDate.getDVDSize(); i++) {
			for (Long a : inIDArrayList) {
				if (  this.mainDate.getDVD(i).styleTest(a) ) {
					Toolz.println( i + ") " + this.getDVDFormartBaseInform(this.mainDate.getDVD(i)) + this.getDVDFormartRBInform(this.mainDate.getDVD(i)) );
					break;	// 防止重复显示
				}
			}
		}
		Toolz.println();
	}
	
	/**
	 * 以部分关键字搜索DVD
	 * @param in
	 */
	private void searchInKey(Scanner in) {
		Toolz.println("请输入一个简短的关键字：");
		String keyString = in.nextLine();
		int keySize = keyString.length();
		Toolz.println("下面是搜索结果：");
		for (int i = 0; i < this.mainDate.getDVDSize(); i++) {
			String targetString = this.mainDate.getDVD(i).getTitle();
			if (targetString.length() >= keySize) {
				for (int j = 0; j <= targetString.length() - keySize; j++) {
					if ( targetString.substring(j, j + keySize).equals(keyString) ) {
						Toolz.println( i + ") " + this.getDVDFormartBaseInform(this.mainDate.getDVD(i)) + this.getDVDFormartRBInform(this.mainDate.getDVD(i)) );
						break;
					}
				}
			}
		}
	}
	
}







/**
 * 静态专用类<br>
 * 禁止构造<br>
 * @author Jeremie
 *
 */
class Toolz {
	
	/**
	 * 禁用构造函数
	 */
	private Toolz() {
		// 禁用构造函数
	}
	
	/**
	 * 解析输入字符串到int<br>
	 * 现在同getCompInt<br>
	 * @param in
	 * @return	 没有解析出整数返回0	【delete 返回1~9】
	 */
	public static int getInt(String in) {
		return getCompInt(in);
//		for (char a : in.toCharArray() ) {
//			if (Character.isDigit(a)) {
//				return (int) ( a - '0' );
//			}
//		}
//		return 0;
	}
	
	/**
	 * 获取开头的int
	 * @param in
	 * @return 没有解析出整数返回-1	返回int
	 */
	public static int getCompInt(String in) {
		int i = 0;
		boolean flag = false;
//		char tc = in.toCharArray()[0];
//		if ( '0' <= tc && tc <= '9' ) {
//			return -1;
//		}
		for (char a : in.toCharArray()) {
			if ( '0' <= a && a <= '9' ) {
				flag = true;
				i*=10;
				i+= (int) a - '0';
			}else {
				return -1;
			}
		}
		if (!flag) {
			return -1;
		}
		return i;
	}
	
	
	/**
	 * 控制台清屏
	 */
	public static void clearConsole()
	{
//	    try
//	    {
//	        String os = System.getProperty("os.name");
//
//	        if (os.contains("Windows"))
//	        {
//	            Runtime.getRuntime().exec("cls");
//	        }
//	        else
//	        {
//	            Runtime.getRuntime().exec("clear");
//	        }
//	    }
//	    catch (Exception exception)
//	    {
//	        //  Handle exception.
//	    }
		
//		for (int i = 0; i < 100; i++) {
//			Toolz.println();
//		}
		
		// 没法实现啊.............
		
		
	}
	
	/**
	 * 包装的输出<br>
	 * 各个重载版本<br>
	 */
	public static void println() {
		System.out.println();
	}
	public static void println(String in) {
		System.out.println(in);
	}
	public static void println(double in) {
		System.out.println(in);
	}
	public static void println(boolean in) {
		System.out.println(in);
	}
	public static void println(char in) {
		System.out.println(in);
	}
	public static void println(char[] in) {
		System.out.println(in);
	}
	public static void println(float in) {
		System.out.println(in);
	}
	public static void println(int in) {
		System.out.println(in);
	}
	public static void println(long in) {
		System.out.println(in);
	}
	public static void println(Object in) {
		System.out.println(in);
	}
	
	public static void print(String in) {
		System.out.print(in);
	}
	public static void print(double in) {
		System.out.print(in);
	}
	public static void print(boolean in) {
		System.out.print(in);
	}
	public static void print(char in) {
		System.out.print(in);
	}
	public static void print(char[] in) {
		System.out.print(in);
	}
	public static void print(float in) {
		System.out.print(in);
	}
	public static void print(int in) {
		System.out.print(in);
	}
	public static void print(long in) {
		System.out.print(in);
	}
	public static void print(Object in) {
		System.out.print(in);
	}
	
}





