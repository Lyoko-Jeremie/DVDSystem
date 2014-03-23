import java.util.Scanner;

/**
 * �˵�<br>
 * TODO �˵�ҲҪԤ������չ�ռ䣬�ر���Ԥ���û���֤���ֺ͹���Ա�˵�<br>
 */

/**
 * @author Jeremie
 *
 */
public class Menu {

	/**
	 * �û��˵��ӿ�
	 */
	UserMenu userMenuHandle; 
	
	/**
	 * �����ݽڵ�
	 */
	private ControlMain mainDate;
	
	/**
	 * ������󱣻�
	 */
	private static int PRO = 0;
	
	/**
	 * Ψһ���޲ι��캯��<br>
	 * @param mainDate
	 */
	public Menu() {
		if ( Menu.PRO>0) {
			// ������󱣻�
			throw new ExceptionInInitializerError(
				"\n\tOnly Can Create One Menu Object!!!"
				);
		}
		++Menu.PRO;
		this.mainDate = new ControlMain();
	}
	
	/**
	 * ����<br>
	 * ���ټ���
	 */
	protected void finalize() {
		--Menu.PRO;
	}
	
	/**
	 * ������ѭ��<br>
	 * Ψһ��һ�����к���<br>
	 * @param in	����̨Scanner����
	 */
	public void mainMenu( Scanner in){
		
		{
			//TODO ���������ݳ�ʼ����û���ļ�ʱʹ�õķ���
			Test.init(mainDate);
		}
		
		// ��ʼ��&������ʾ
		Toolz.println("��ӭ����DVD����ϵͳ");
		
		// ����ֻ�����û����棬���λ��Ϊ��չ��������Ԥ��
		this.userMenuHandle = new UserMenu(mainDate, "");
		this.userMenuHandle.menu(in);
		
		//TODO ����ϵͳ�˳�
		Toolz.println("ллʹ��DVD����ϵͳ");

	}
	

}














/**
 * �û��˵���
 * @author Jeremie
 *
 */
class UserMenu{
	
	/**
	 * �����ݽڵ�
	 */
	private ControlMain mainDate;
	
	/**
	 * �û�������
	 */
	private User userHandle;
	
//	/**
//	 * ������󱣻�
//	 */
//	private static int PRO = 0;
	
	/**
	 * ���캯��
	 * @param mainDate
	 * @param userName
	 */
	public UserMenu(ControlMain mainDate, String userName) {
//		if ( UserMenu.PRO>0) {
//			// ������󱣻�
//			throw new ExceptionInInitializerError(
//				"\n\tOnly Can Create One UserMenu Object!!!"
//				);
//		}
//		++UserMenu.PRO;
		this.mainDate = mainDate;
		this.userHandle = mainDate.getUser(userName);
	}
	
//	/**
//	 * ����<br>
//	 * ���ټ���
//	 */
//	protected void finalize() {
//		--UserMenu.PRO;
//	}
	
	/**
	 * �û�
	 * @param in
	 */
	public void menu(Scanner in) {
		while (true) {
			
			// ѭ��������ʾ
			this.MainU();
			
			int selectInt = Toolz.getInt(in.nextLine());
			
			Toolz.clearConsole();
			
			switch (selectInt) {
			case 1:
				{	// 1)\t�鿴���п���������DVD
					this.listAllDVD();
				}
				break;

			case 2:
				{	// 2)\t�鿴�Լ��Ѿ���ĺ����DVD
					this.listMyDVD();
				}
				break;

			case 3:
				{	// 3)\t��һ��DVD
					this.buyDVD(in);
				}
				break;

			case 4:
				{	// 4)\t��һ��DVD
					this.rentDVD(in);
				}
				break;

			case 5:
				{	// 5)\t��һ���Ѿ����DVD
					this.reDVD(in);
				}
				break;

			case 6:
				{	// 6)\t��������DVD
					
				}
				break;

			case 7:
				{	// 7)\t������ʾDVD
					
				}
				break;
				
			case 8:
			{	// Test
			}
			break;

			case 9:
				{
					// TO DO �ļ�����
					Toolz.println("���Ѿ��˳��û��˵�.");
					return;
				}
//				break;

			case 0:	// ͬdefault
			default:
				Toolz.println("��������ȷ��ѡ��.");
				break;
			}
			
			// ��ͣ���ȴ������
			in.reset();
			Toolz.println("\n�밴�س�������.....");
			in.nextLine();
			
			Toolz.clearConsole();
			
		}
	}
	
	
	/**
	 * �û��˵��˵�ѡ�����
	 */
	private void MainU(){
		Toolz.println();
//		Toolz.println("Test, These is Menu Text.");
		Toolz.println("��ӭ " + this.userHandle.getName() + " �����û��˵�");
		Toolz.println("==========================");
		Toolz.println("1)\t�鿴���п���������DVD");
		Toolz.println("2)\t�鿴�Լ��Ѿ���ĺ����DVD");
		Toolz.println("3)\t��һ��DVD");
		Toolz.println("4)\t��һ��DVD");
		Toolz.println("5)\t��һ���Ѿ����DVD");
		Toolz.println("6)\t��������DVD");
		Toolz.println("7)\t������ʾDVD");
		Toolz.println("9)\t�˳��û��˵�");
		Toolz.println("==========================");
		Toolz.println("����������ѡ��Ĺ��ܵ����֣�");
	}

	/**
	 * �г����е�
	 */
	private void listAllDVD()
	{
		/*
 		 *��Ӱ���������֡���ݡ���Ӱ���͡�״̬
		 *���磺 Сʱ�� ��2013�꣺���� ϲ�� У԰������|����
		 */
		Toolz.println();
		for (int i = 0; i < mainDate.getDVDSize(); i++) {
			DVD Temp = mainDate.getDVD(i);
			Toolz.print( i + ") " + getDVDFormartBaseInform(Temp) + getDVDFormartRBInform(Temp) );
			Toolz.println();
		}
	}
	
	/**
	 * ���ظ�ʽ����DVD��������Ϣ
	 * @param t
	 * @return
	 */
	private String getDVDFormartRBInform(DVD t) {
		String f = new String();
		f+="������" + t.getAmount() + " ; ";
		if (t.canSell()) {
			f+="����";
		} else {
			f+="������";
		}
		f+="|";
		if (t.canRent()) {
			f+="����";
		} else {
			f+="������";
		}
		return f;
	}
	
	/**
	 * ���ظ�ʽ���Ļ���DVD��Ϣ
	 * @param t
	 * @return
	 */
	private String getDVDFormartBaseInform(DVD t) {
		String f = new String( t.getTitle() + " ; " + t.getYear() + "�� ; " );
		for (int j = 0; j < t.styleGetSize(); j++) {
			String ts = mainDate.getStyle(t.styleGet(j));
			if (null == ts) {
				return null;
			}
			f += ts;
			if ( j != t.styleGetSize() - 1 ) {
				f += " ";	// �ո����
			}else {
				f += " ; ";
			}
		}
		return f;
	}

	/**
	 * �г��Լ���
	 */
	private void listMyDVD()
	{
		Toolz.println();
		Toolz.println( "�û� " + userHandle.getName() + " ������DVD");
		for (int i = 0; i < userHandle.getDVDListSize(); i++) {
			DVD Temp = mainDate.getDVD( userHandle.getDVDListIndexID(i) );
			if (Temp.getTitle().equals(userHandle.getDVDListIndexName(i))) {
				Toolz.print( i + ") " + getDVDFormartBaseInform(Temp) );
				if (userHandle.getDVDListIndexBuyAmount(i) > 0) {
					Toolz.print( "����������" + userHandle.getDVDListIndexBuyAmount(i) );
				}
				if (userHandle.getDVDListIndexRentAmount(i) > 0) {
					Toolz.print( "����������" + userHandle.getDVDListIndexRentAmount(i) );
				}
				Toolz.println();
			}
		}
		if (userHandle.getDVDListSize() == 0) {
			Toolz.println("ʲôҲû��...");
		}
	}

	/**
	 * ��
	 */
	private void buyDVD(Scanner in)
	{
		Toolz.println("��DVD������ѡ1\t��DVD��Ź���ѡ2\n��ѡ�񲢻س����е����ֿ�������������");
		int s = Toolz.getInt(in.nextLine());
		DVD Temp = null;
		switch (s) {
		case 1:
		{
			Toolz.println("��������Ҫ���DVD�����Իس�������");
			String name = in.nextLine();
			Temp = mainDate.getDVD(name);
			if (Temp == null) {
				Toolz.println("�Ҳ���ָ����DVD");
				return;
			}
		}
			break;
			
		case 2:
		{
			Toolz.println("��������Ҫ�����DVD��Ų��س�");
			int index = Toolz.getCompInt( in.nextLine() );
			Temp = mainDate.getDVD(index);
			if (Temp == null) {
				Toolz.println("�Ҳ���ָ����DVD");
				return;
			}
		}
			break;

		default:
			Toolz.println( "������󣬹���ʧ�ܡ�" );
			return;
//			break;
		}
		
		Toolz.println( "�ҵ���DVD��Ϣ��" );
		Toolz.println( getDVDFormartBaseInform(Temp) + getDVDFormartRBInform(Temp) );
		
		Toolz.println( "�۸�\t�⣺" + Temp.getRentPrice() + "\t��" + Temp.getBuyPrice() );
		if (!Temp.canSell()) {
			Toolz.println( "�ܿ�ϧ�����DVD�Ѿ��޷��ٳ��ۡ�" );
			return;
		}
		if (userHandle.buyDVD(Temp)) {
			Toolz.println( "����ɹ�" );
			return;
		}
		Toolz.println( "����ʧ��" );
		return;
		
	}
	
	/**
	 * ��
	 */
	private void rentDVD(Scanner in)
	{
		Toolz.println("��DVD�����ѡ1\t��DVD������ѡ2\n��ѡ�񲢻س����е����ֿ�������������");
		int s = Toolz.getInt(in.nextLine());
		DVD Temp = null;
		switch (s) {
		case 1:
		{
			Toolz.println("��������Ҫ���DVD�����Իس�������");
			String name = in.nextLine();
			Temp = mainDate.getDVD(name);
			if (Temp == null) {
				Toolz.println("�Ҳ���ָ����DVD");
				return;
			}
		}
			break;
			
		case 2:
		{
			Toolz.println("��������Ҫ����DVD��Ų��س�");
			int index = Toolz.getCompInt(in.nextLine());
			Temp = mainDate.getDVD(index);
			if (Temp == null) {
				Toolz.println("�Ҳ���ָ����DVD");
				return;
			}
		}
			break;

		default:
			Toolz.println( "����������ʧ�ܡ�" );
			return;
//			break;
		}
		
		Toolz.println( "�ҵ���DVD��Ϣ��" );
		Toolz.println( getDVDFormartBaseInform(Temp) + getDVDFormartRBInform(Temp) );
		
		Toolz.println( "�۸�\t�⣺" + Temp.getRentPrice() + "\t��" + Temp.getBuyPrice() );
		if (!Temp.canRent()) {
			Toolz.println( "�ܿ�ϧ�����DVD�Ѿ��޷�����衣" );
			return;
		}
		if (userHandle.rentDVD(Temp)) {
			Toolz.println( "���ɹ�" );
			return;
		}
		Toolz.println( "���ʧ��" );
		return;
		
	}

	/**
	 * ��
	 */
	private void reDVD(Scanner in)
	{
		Toolz.println("��DVD����ѡ1\t��DVD�����ѡ2\n��ѡ�񲢻س����е����ֿ�������������");
		int s = Toolz.getInt(in.nextLine());
		switch (s) {
		case 1:
		{
			Toolz.println("��������Ҫ����DVD�����Իس�������");
			String name = in.nextLine();
			if ( userHandle.reDVD(name) ) {
				Toolz.println("�黹�ɹ�");
			}else {
				Toolz.println("�黹ʧ��");
			}
			return;
		}
//			break;
			
		case 2:
		{
			Toolz.println("��������Ҫ����DVD��Ų��س�");
			int index = Toolz.getCompInt(in.nextLine());
			if ( userHandle.reDVD(index) ) {
				Toolz.println("�黹�ɹ�");
			}else {
				Toolz.println("�黹ʧ��");
			}
			return;
		}
//			break;

		default:
			Toolz.println( "����������ʧ�ܡ�" );
			return;
//			break;
		}
		
	}
}







/**
 * ��̬ר����<br>
 * ��ֹ����<br>
 * @author Jeremie
 *
 */
class Toolz {
	
	/**
	 * ���ù��캯��
	 */
	private Toolz() {
		// ���ù��캯��
	}
	
	/**
	 * ���������ַ�����int<br>
	 * @param in
	 * @return	 û�н�������������0	����1~9
	 */
	public static int getInt(String in) {
		for (char a : in.toCharArray() ) {
			if (Character.isDigit(a)) {
				return (int) ( a - '0' );
			}
		}
		return 0;
	}
	
	/**
	 * ��ȡ��ͷ��int
	 * @param in
	 * @return û�н�������������-1	����int
	 */
	public static int getCompInt(String in) {
		int i = 0;
		boolean flag = false;
		char tc = in.toCharArray()[0];
		if ( '0' <= tc && tc <= '9' ) {
			return -1;
		}
		for (char a : in.toCharArray()) {
			if ( '0' <= a && a <= '9' ) {
				flag = true;
				i*=10;
				i+= (int) a - '0';
			}
		}
		if (!flag) {
			return -1;
		}
		return i;
	}
	
	
	/**
	 * ����̨����
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
		
		// û��ʵ�ְ�.............
		
		
	}
	
	/**
	 * ��װ�����<br>
	 * �������ذ汾<br>
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





