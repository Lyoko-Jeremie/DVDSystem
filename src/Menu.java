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
	UserMenu um; 
	
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
			throw new ExceptionInInitializerError("\n\tOnly Can Create One Menu Object!!!");
		}
		++Menu.PRO;
		this.mainDate = new ControlMain();
		this.um= new UserMenu( this.mainDate );
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
		}
		
		// ��ʼ��&������ʾ
		System.out.println("��ӭ����DVD����ϵͳ");
		
		// ����ֻ�����û����棬���λ��Ϊ��չ��������Ԥ��
		um.menu(in);
		
		//TODO ����ϵͳ�˳�
		System.out.println("ллʹ��DVD����ϵͳ");

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
	 * ������󱣻�
	 */
	private static int PRO = 0;
	
	/**
	 * ���캯��
	 * @param mainDate
	 */
	public UserMenu(ControlMain mainDate) {
		if ( UserMenu.PRO>0) {
			// ������󱣻�
			throw new ExceptionInInitializerError("\n\tOnly Can Create One UserMenu Object!!!");
		}
		++UserMenu.PRO;
		this.mainDate = mainDate;
	}
	
	/**
	 * ����<br>
	 * ���ټ���
	 */
	protected void finalize() {
		--UserMenu.PRO;
	}
	
	/**
	 * �û�
	 * @param in
	 */
	public void menu(Scanner in) {
		while (true) {
			
			// ѭ��������ʾ
			this.MainU();
			
			int selectInt = resolveInput.getInt(in.nextLine());
			
			//TODO ��ս���
			
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
					//TODO ɨβ&�û��˳���ʾ
					return;
				}
//				break;

			case 0:	// ͬdefault
			default:
				break;
			}
			
			// ��ͣ���ȴ������
			in.reset();
			System.out.println("\n�밴���������.....");
			in.nextLine();
			
			//TODO ��ս���
			
		}
	}
	
	
	/**
	 * �û��˵��˵�ѡ�����
	 */
	private void MainU(){
//		System.out.println("Test, These is Menu Text.");
		System.out.println("��ӭ�����û��˵�");
		System.out.println("==========================");
		System.out.println("1)\t�鿴���п���������DVD");
		System.out.println("2)\t�鿴�Լ��Ѿ���ĺ����DVD");
		System.out.println("3)\t��һ��DVD");
		System.out.println("4)\t��һ��DVD");
		System.out.println("5)\t��һ���Ѿ����DVD");
		System.out.println("6)\t");
		System.out.println("9)\t�˳��û��˵�");
		System.out.println("==========================");
		System.out.println("����������ѡ��Ĺ��ܵ����֣�");
	}
	
}







/**
 * ��̬ר����<br>
 * ��ֹ����<br>
 * @author Jeremie
 *
 */
class resolveInput {
	
	/**
	 * ���ù��캯��
	 */
	private resolveInput() {
		// ���ù��캯��
	}
	
	/**
	 * ���������ַ�����int<br>
	 * @param in
	 * @return	û�н�������������0	����1~9
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





