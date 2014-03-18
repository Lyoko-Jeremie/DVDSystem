import java.util.ArrayList;

/**
 * �û���
 */

/**
 * �û���<br>
 * ���ɿ���չ�ıȽϺ�<br>
 * @author Jeremie
 *
 */
public class User {
	/**
	 * �Ѿ��򵽵ĺ��Ѿ��赽��DVD��
	 */
	private ArrayList<DVDUser> userDVDArrayList; //= new ArrayList<DVDUser>();
	/**
	 * �ֽ�
	 */
	private double money;
	/**
	 * Ψһ�Ĺ��캯��<br>
	 * @param money	��ʼ���
	 */
	public User(double money) {
		this.userDVDArrayList = new ArrayList<DVDUser>();
		this.money = money;
	}
	
	/**
	 * �����ֽ�����
	 * @param m	���ӵ���
	 * @return	���Ӻ����
	 */
	public double addMoney(double m) {
		this.money += m;
		return this.money;
	}

	/**
	 * ��һ��DVD<br>
	 * @param n	DVD�±�
	 * @param Date	��DVD�б������
	 * @return	��������or��Ǯ����orû���践��false
	 */
	public boolean rentDVD(int n, ArrayList<DVD> Date) {
		if (n < Date.size()) {
			if (this.money >= Date.get(n).getRentPrice()) {
				if (Date.get(n).rentOne()) {
					this.addRentDate(Date.get(n).getTitle());
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * ��һ��DVD<br>
	 * @param n	DVD�±�
	 * @param Date	��DVD�б������
	 * @return	��������or��Ǯ����orû���践��false
	 */
	public boolean buyDVD(int n, ArrayList<DVD> Date) {
		if (n < Date.size()) {
			if (this.money >= Date.get(n).getBuyPrice()) {
				if (Date.get(n).sellOne()) {
					this.addBuyDate(Date.get(n).getTitle());
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * ���ӽ��¼
	 * @return	�����ķ���true �Ѿ��еķ���false
	 */
	private boolean addRentDate(String name) {
		DVDUser pDvdUser = null;
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.name)) {
				pDvdUser = a;
				break;
			}
		}
		if (pDvdUser == null) {
			this.userDVDArrayList.add(new DVDUser(name,1,0));
			return true;
		} else {
			++pDvdUser.rentAmount;
			return false;
		}
	}
	
	//TODO ��DVD
	 //TODO ���ٽ��¼������¼��
	
	/**
	 * �������¼
	 * @return	�����ķ���true �Ѿ��еķ���false
	 */
	private boolean addBuyDate(String name) {
		DVDUser pDvdUser = null;
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.name)) {
				pDvdUser = a;
				break;
			}
		}
		if (pDvdUser == null) {
			this.userDVDArrayList.add(new DVDUser(name,0,1));
			return true;
		} else {
			++pDvdUser.buyAmount;
			return false;
		}
	}
	
}














/**
 * User��¼��DVD��<br>
 * ���ͼ�¼��<br>
 * @author Jeremie
 *
 */
class DVDUser {
	/**
	 * DVD��<br>
	 * ������Ϊ����<br>
	 * <br>
	 * <br>
	 * TO DO��<br>
	 * ��DVD��hashΪ����<br>
	 * ��DVD����Ϊ����<br>
	 * ��DVD���Ϊ����<br>
	 * 
	 */
	public String name;
	/**
	 * �Ѿ��������
	 */
	public int rentAmount = 0;
	/**
	 * �Ѿ��������
	 */
	public int buyAmount = 0;
	
	/**
	 * ���캯��
	 * @param name
	 * @param rentAmount
	 * @param buyAmount
	 */
	public DVDUser(String name, int rentAmount, int buyAmount) {
		this.name = name;
		this.rentAmount = rentAmount;
		this.buyAmount = buyAmount;
	}
}

