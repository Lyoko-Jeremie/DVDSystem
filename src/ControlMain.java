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
	 * DVD������ṹ<br>
	 * User��DVDUser��DVD�±��ʶDVD�����Բ���ɾ��<br>
	 */
	private ArrayList<DVD> dVDMainDateArrayList;
	
	/**
	 * Style����ṹ
	 */
	private ArrayList<Style> dVDStyleArrayList;
	
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
		this.dVDStyleArrayList = new ArrayList<Style>();
		this.usersMainDateArrayList = new ArrayList<User>();
	}
	
	// TO DO ��DVD��ʹ��������������ʱ��Ҫ���һ�����������Ƶ�DVDadd
	
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
	 * ���һ��Style
	 * @param name
	 * @return ��������false
	 */
	public boolean addStyle(String name){
		for (Style a : this.dVDStyleArrayList) {
			if (a.getName().equals(name)) {
				return false;
			}
		}
		this.dVDStyleArrayList.add( new Style(name) );
		return true;
	}

	/**
	 * ��Index��ȡStyle��<br>
	 * ������<br>
	 * <br>
	 * Javaû��size_type��.<br>
	 * @param Index
	 * @return	�Ҳ���������null
	 */
	public String getStyle(int Index){
		if (Index < this.dVDStyleArrayList.size()) {
			return this.dVDStyleArrayList.get(Index).getName();
		}
		return null;
	}
	
	/**
	 * ��ID��ȡStyle��<br>
	 * @param ID
	 * @return	�Ҳ���������null
	 */
	public String getStyle( long ID){
		for (Style a : this.dVDStyleArrayList) {
			if (a.getID() == ID) {
				return a.getName();
			}
		}
		return null;
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
	 * ��ȡָ���û�����<br>
	 * ������<br>
	 * @param Index	�±�
	 * @return	������Χ����null
	 */
	public User getUser(int Index) {
		if (Index > this.usersMainDateArrayList.size()) {
			return null;
		}
		return this.usersMainDateArrayList.get(Index);
	}
	
	/**
	 * ��ȡָ���û�����<br>
	 * ����<br>
	 * @param name		�û���
	 * @return	�Ҳ�������null
	 */
	public User getUser(String name) {
		for (User a : this.usersMainDateArrayList) {
			// ע�⣺��Ϊnull�ַ������û�
			// ��ʵ��ֻҪ��Ϊnull������Ϊ""������Ҫ���null
			if (a.getName() != null) {
				if (a.getName().equals(name)) {
					return a;
				}
			}
		}
		return null;
	}

	/**
	 * ��ȡָ��DVD����<br>
	 * ������<br>
	 * @param Index	�±�
	 * @return	������Χ����null
	 */
	public DVD getDVD(int Index) {
		if (Index > this.dVDMainDateArrayList.size()) {
			return null;
		}
		return this.dVDMainDateArrayList.get(Index);
	}
	
	/**
	 * ��ȡָ��DVD����<br>
	 * ������<br>
	 * @param Title		����
	 * @return	������Χ����null
	 */
	public DVD getDVD(String Title) {
		for (DVD a : this.dVDMainDateArrayList) {
			if (a.getTitle().equals(Title)) {
				return a;
			}
		}
		return null;
	}
	

}
