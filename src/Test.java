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
//		 TR.addDVD("", , "", 1000, 100, 100);
		// TR.addDVD("", , "", 1000, 100, 100);
		
	}

}
