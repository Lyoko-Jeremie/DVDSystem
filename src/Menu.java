import java.util.Scanner;

/**
 * �˵�
 */

/**
 * @author Jeremie
 *
 */
public class Menu {
	//TODO �˵�ҲҪԤ������չ�ռ䣬�ر���Ԥ���û���֤���ֺ͹���Ա�˵�
	
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
		if (PRO>0) {
			// ������󱣻�
			throw new ExceptionInInitializerError("\n\tOnly Can Create One Menu Object!!!");
		}
		++PRO;
		this.mainDate = new ControlMain();
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
		
		while (true) {
			
			// ѭ��������ʾ
			this.mainU();
			
			int selectInt = this.resolveInputInt(in.nextLine());
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
					//TODO ɨβ&�˳���ʾ
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
	 * ���������ַ�����int<br>
	 * @param in
	 * @return	û�н�������������0	����1~9
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
	 * �˵�ѡ�����
	 */
	private void mainU(){
		//TODO U Text
		System.out.println("Test, These is Menu Text.");
		System.out.println("��ѡ��������Ĺ���");
	}

}




