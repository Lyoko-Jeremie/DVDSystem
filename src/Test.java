import java.util.Scanner;


/**
 * �����ڲ�����<br>
 * @author Jeremie
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		ControlMain Test = new ControlMain();
		Menu a = new Menu();
//		Menu b = new Menu();
		a.mainMenu(in);
		
		in.close();

	}
	
	public static void init( ControlMain TR ) {
		TR.addOneUser("", "", Integer.MAX_VALUE);
		// TR.addStyle("����");
		// TR.addStyle("ϲ��");
		// TR.addStyle("У԰");
		// TR.addStyle("����");
		// TR.addStyle("����");
		// TR.addStyle("����");
		// TR.addStyle("ð��");
		// TR.addStyle("����");
		// TR.addStyle("����");
		// TR.addStyle("����");
		// TR.addStyle("����");
		// TR.addStyle("����");
		// TR.addStyle("��ʷ");
		// TR.addStyle("ս��");
		// TR.addStyle("����");
		// TR.addStyle("ð��");
		// TR.addStyle("�ƻ�");
		// TR.addStyle("����");
		// TR.addStyle("ð��");
		// TR.addStyle("����");
		// TR.addStyle("���");
		TR.addDVD("Сʱ��", 2004, "���� ϲ�� У԰", 1000, 100, 100);
		TR.addDVD("Ф��˵ľ���", 1994, "", 1000, 100, 100);
		TR.addDVD("�̸�", 1972, "���� ���� ����", 1000, 100, 100);
		TR.addDVD("�̸���II", 1974, "���� ���� ����", 1000, 100, 100);
		TR.addDVD("����С˵", 1994, "", 1000, 100, 100);
		TR.addDVD("�ƽ����ڿ�", 1967, "ð�� ����", 1000, 100, 100);
		TR.addDVD("ʮ��ŭ��", 1957, "���� ����", 1000, 100, 100);
		TR.addDVD("����������", 1993, "���� ���� ��ʷ ս��", 1000, 100, 100);
		TR.addDVD("ָ���������߹���", 2003, "", 1000, 100, 100);
		TR.addDVD("�������ֲ�", 1999, "", 1000, 100, 100);
		TR.addDVD("�����ս�����۹�����ս", 1980, "���� ð�� �ƻ�", 1000, 100, 100);
		TR.addDVD("��Խ����Ժ", 1975, "", 1000, 100, 100);
		TR.addDVD("ָ����������ʹ��", 2001, "���� ð�� ���� ���", 1000, 100, 100);
		TR.addDVD("���οռ�", 2010, "", 1000, 100, 100);
		TR.addDVD("�üһ�", 1990, "", 1000, 100, 100);
		TR.addDVD("�����սIV����ϣ��", 1977, "���� ð�� ��� �ƻ�", 1000, 100, 100);
		TR.addDVD("����ʿ", 1956, "���� ð�� ����", 1000, 100, 100);
		TR.addDVD("�ڿ͵۹�", 1999, "���� ð�� �ƻ�", 1000, 100, 100);
		TR.addDVD("�ϵ�֮��", 2002, "", 1000, 100, 100);
		TR.addDVD("��������", 1994, "���� ����", 1000, 100, 100);
		TR.addDVD("ָ������˫�����", 2002, "���� ð�� ���", 1000, 100, 100);
		TR.addDVD("��������", 1968, "����", 1000, 100, 100);
		TR.addDVD("����������", 1943, "���� ���� ս��", 1000, 100, 100);
		TR.addDVD("������", 1995, "���� ���� ���� ����", 1000, 100, 100);
		TR.addDVD("��Ĭ�ĸ���", 1991, "���� ����", 1000, 100, 100);
		TR.addDVD("�ᱦ���", 1981, "���� ð��", 1000, 100, 100);
		TR.addDVD("�ǳ����ɷ�", 1995, "���� ���� ����", 1000, 100, 100);
		TR.addDVD("��", 1955, "���� ���� ���� ����", 1000, 100, 100);
		TR.addDVD("���������ڰ���ʿ����", 2012, "", 1000, 100, 100);
		TR.addDVD("�����", 1960, "���� �ֲ� ���� ����", 1000, 100, 100);
		TR.addDVD("��������", 1947, "���� ��� ����", 1000, 100, 100);
		TR.addDVD("ɱ������", 1994, "���� ���� ����", 1000, 100, 100);
		TR.addDVD("������", 1950, "���� ��ɫ", 1000, 100, 100);
		TR.addDVD("������Ƭ", 2000, "���� ���� ���� ����", 1000, 100, 100);
		TR.addDVD("����X����", 1998, "", 1000, 100, 100);
		TR.addDVD("�ִ���ʾ¼", 1979, "���� ս��", 1000, 100, 100);
		TR.addDVD("�ս���2��������", 1991, "���� �ƻ� ����", 1000, 100, 100);
		TR.addDVD("�氮��ʿ", 1964, "ϲ�� ����", 1000, 100, 100);
		TR.addDVD("���ȴ�����", 1998, "���� ���� ��ʷ ս��", 1000, 100, 100);
		TR.addDVD("����", 1979, "�ֲ� �ƻ�", 1000, 100, 100);
		TR.addDVD("����ƫ��", 1959, "���� ð�� ���� ���� ���� ����", 1000, 100, 100);
		TR.addDVD("����֮��", 1931, "ϲ�� ���� ����", 1000, 100, 100);
		TR.addDVD("ǧ��ǧѰ", 2001, "���� ð�� ��ͥ ���", 1000, 100, 100);
		// TR.addDVD("", , "", 1000, 100, 100);
		
//		{
//			System.out.println(TR.getMainFile().createNewFile());
//			System.out.println(TR.getMainFile().openWriteHandle());
//			System.out.println(TR.getMainFile().isOpenWriteHandle());
//			System.out.println(TR.getMainFile().writeMainDate());
//			TR.getMainFile().closeWriteHandle();
//		}
		
	}

}



