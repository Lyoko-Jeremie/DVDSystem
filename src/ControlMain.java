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
	
	/**
	 * �û��б�
	 */
	private ArrayList<User> usersMainDateArrayList;
	
	/**
	 * Ψһ�Ĺ��췽��<br>
	 * ��ʼ��������ṹArrayList
	 */
	public ControlMain() {
		this.dVDMainDateArrayList = new ArrayList<DVD>();
		this.styleArray = new String[64];
		this.styleArray[0] = new String("");
		this.usersMainDateArrayList = new ArrayList<User>();
	}
	/**
	 * ���һ��DVD����������DVD����
	 * @param title
	 * @param year
	 * @param style	ע���̺�
	 * @param amount
	 * @param sell
	 * @param rent
	 * @param buyprice
	 * @param rentPrice
	 */
	public void addDVD(String title, int year, long style, int amount, boolean sell, boolean rent, double buyPrice, double rentPrice) {
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, buyPrice, rentPrice));
	}
	/**
	 * ���һ��DVD���Զ������Ƿ�������
	 * @param title
	 * @param year
	 * @param style	ע���̺�
	 * @param amount
	 * @param buyprice
	 * @param rentPrice
	 */
	public void addDVD(String title, int year, long style, int amount, double buyPrice, double rentPrice) {
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
		dVDMainDateArrayList.add( new DVD(title, year, style, amount, sell, rent, buyPrice, rentPrice));
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
	
	/**
	 * ���һ���û�<br>
	 * ����ʼ���ֽ���<br>
	 * @return dVDMainDateArrayList���Ϊnullʱ����false
	 */
	public boolean addOneUser( double money) {
		if (this.dVDMainDateArrayList != null) {
			usersMainDateArrayList.add(new User(money, this.dVDMainDateArrayList));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ��ȡָ���û�����
	 * @param n	�±�
	 * @return	������Χ����null
	 */
	public User getUser(int n) {
		if (n > this.usersMainDateArrayList.size()) {
			return null;
		}
		return this.usersMainDateArrayList.get(n);
	}
	
	/**
	 * ��ȡָ��DVD����
	 * @param n	�±�
	 * @return	������Χ����null
	 */
	public DVD getDVD(int n) {
		if (n > this.dVDMainDateArrayList.size()) {
			return null;
		}
		return this.dVDMainDateArrayList.get(n);
	}

}
