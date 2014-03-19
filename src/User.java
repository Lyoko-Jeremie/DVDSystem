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
	 * ָ�����������ľ��
	 */
	private ArrayList<DVD> dateHandle;
	/**
	 * Ψһ�Ĺ��캯��<br>
	 * @param money	��ʼ���
	 * @param Handle	ָ�����������ľ��
	 */
	public User(double money, ArrayList<DVD> Handle) {
		this.userDVDArrayList = new ArrayList<DVDUser>();
		this.money = money;
		this.dateHandle = Handle;
		if (Handle==null) {
			throw new ExceptionInInitializerError(new Throwable("Handle Cant are null !!"));
		}
	}
	
	/**
	 * �����ֽ�����<br>
	 * �����Ǹ���<br>
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
	public boolean rentDVD(int n) {
		if (n < dateHandle.size()) {
			// û��Խ��
			if (this.money >= dateHandle.get(n).getRentPrice()) {
				// Ǯ��
				if (dateHandle.get(n).rentOne()) {
					// �ܽ�
					this.addRentDate(dateHandle.get(n).getTitle(), n);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * ��DVD
	 * @param name DVD��
	 * @return	��û�н����&û����� ����false
	 */
	public boolean reDVD(String name) {
		int i = 0;
		for (; i < this.userDVDArrayList.size(); i++) {
			if (this.userDVDArrayList.get(i).getName().equals(name)) {	// �ҵ�
				{	// �жϿ�ʼ
					if (this.dateHandle.size() > this.userDVDArrayList.get(i).getIndex()) {
						// û��Խ��
						if ( this.dateHandle.get(this.userDVDArrayList.get(i).getIndex()).getTitle().equals(name) ) {
							// ����һ��
							if ( this.userDVDArrayList.get(i).rentAmount > 0 ) {
								// ȷʵ����
								if ( this.dateHandle.get(this.userDVDArrayList.get(i).getIndex()).surrenderOne() ) {
									// ȷʵ����
									--this.userDVDArrayList.get(i).rentAmount;	// �������� TAT
									return true;
								}
							}
						}
					}
				}	// �жϽ���
				break;
			}
		}
		return false;
	}
	
	/**
	 * ��һ��DVD<br>
	 * @param n	DVD�±�
	 * @param Date	��DVD�б������
	 * @return	��������orǮ����orû���践��false
	 */
	public boolean buyDVD(int n) {
		if (n < dateHandle.size()) {
			// δԽ��
			if (this.money >= dateHandle.get(n).getBuyPrice()) {
				// Ǯ��
				if (dateHandle.get(n).sellOne()) {
					// ����
					this.addBuyDate(dateHandle.get(n).getTitle(), n);
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
	private boolean addRentDate(String name,int index) {
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.getName())) {
				// �ҵ�
				++a.rentAmount;
				return false;
			}
		}
		// δ�ҵ�
		this.userDVDArrayList.add(new DVDUser(name,index,1,0));
		return true;
	}
	
	 //TODO ���ٽ��¼������¼��
	
	/**
	 * �������¼
	 * @return	�����ķ���true �Ѿ��еķ���false
	 */
	private boolean addBuyDate(String name, int index) {
		for (DVDUser a : this.userDVDArrayList) {
			if (name.equals(a.getName())) {
				// �ҵ�
				++a.buyAmount;
				return false;
			}
		}
		// δ�ҵ�
		this.userDVDArrayList.add(new DVDUser(name,index,0,1));
		return true;
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
	private String name;
	/**
	 * �±�
	 */
	private int index;
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
	 * @param index
	 * @param rentAmount
	 * @param buyAmount
	 */
	public DVDUser(String name, int index, int rentAmount, int buyAmount) {
		this.name = name;
		this.rentAmount = rentAmount;
		this.buyAmount = buyAmount;
		this.index = index;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}
	
}

