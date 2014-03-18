import java.util.ArrayList;

/**
 * ����ϵͳ���Ŀ��ƽṹ<br>
 * @author Jeremie
 */

/**
 * ��ϵͳ��Ҫ�ṹ<br>
 * @author Jeremie
 */
public class ControlMain {
	
	/**
	 * DVD������ṹ
	 */
	private ArrayList<DVD> dVDMainDateArrayList;
	
	/**
	 * Style������		DVD.StyleΪlong����64^2���ɼ�¼64-1��
	 */
	private String[] styleArray;	// = new String[64];
	private static final int STYLE_ARRAY_LONG = 64;
	
	//TODO UserMainDateArrayList
	
	/**
	 * Ψһ�Ĺ��췽��<br>
	 * ��ʼ��������ṹArrayList
	 */
	public ControlMain() {
		this.dVDMainDateArrayList = new ArrayList<DVD>();
		this.styleArray = new String[64];
		this.styleArray[0] = new String("");
	}
	/**
	 * ���һ��DVD����������DVD����
	 * @param title
	 * @param year
	 * @param style	ע���̺�
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param price
	 */
	public void addDVD(String title, int year, long style, int amount, boolean sell, boolean rent, double price) {
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, price));
	}
	/**
	 * ���һ��DVD���Զ������Ƿ�������
	 * @param title
	 * @param year
	 * @param style	ע���̺�
	 * @param amount
	 * @param price
	 */
	public void addDVD(String title, int year, long style, int amount, double price) {
		boolean sell;
		if (amount > DVD.getSELL_LIMIT()) {
			sell = true;
		} else {
			sell = false;
		}
		boolean rent;
		if (amount > DVD.getRENT_LIMIT()) {
			rent = true;
		} else {
			rent = false;
		}
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, price));
	}
	/**
	 * @param n	���ɴ����ܳ���
	 * @return styleArray	����NULL�����ʾû���������λ��
	 */
	public String getStyleName( int n) {
		if (n<STYLE_ARRAY_LONG) {
			return styleArray[n];
		} else {
			return styleArray[0];
		}
	}
	/**
	 * @param n ���õ�style��λ��
	 * @param style Ҫ���õ� style
	 * @return ������Χ����false	���óɹ�����true
	 */
	public boolean setStyleName( int n, String style) {
		if (n<STYLE_ARRAY_LONG) {
			this.styleArray[n] = style;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * ��ȡ����styleArray<br>
	 * ���ɸı�����<br>
	 * @return styleArray
	 */
	public final String[] getStyleArray() {
		return styleArray;
	}
	

}
