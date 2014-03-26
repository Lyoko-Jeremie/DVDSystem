import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * �ļ�������
 */

/**
 * @author Jeremie
 *
 */
public class ControlFile {
	
	private File mainFile;
	
	private Scanner mainReadHandle;
	
	private PrintWriter mainWriteHandle;
	
	private ControlMain mainDate;
	
	/**
	 * ���캯��
	 * @param filePathName
	 * @param mainDate
	 */
	public ControlFile( String filePathName, ControlMain mainDate) throws ExceptionInInitializerError {
		this.mainDate = mainDate;
		this.mainFile = new File(filePathName);
		if ( mainFile.exists() && !( mainFile.canRead() && mainFile.canWrite() ) ) {
			throw new ExceptionInInitializerError("File Cant Read or Write.");
		}
		if ( mainFile.exists() && !mainFile.isFile() ) {
			throw new ExceptionInInitializerError("Not a file");
		}
		mainReadHandle = null;
		mainWriteHandle = null;
	}
	
	/**
	 * �ļ��Ƿ����
	 * @return
	 */
	public boolean isFileExists() {
		return mainFile.exists();
	}
	
	/**
	 * �������ļ�
	 * @return �쳣����false �ɹ�����true
	 */
	public boolean createNewFile() {
		try {
			mainFile.createNewFile();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * ��������<br>
	 * �رվ��<br>
	 */
	@Override
	protected void finalize() throws Throwable {
		mainReadHandle.close();
		mainWriteHandle.close();
		super.finalize();
	}
	
	/**
	 * �򿪶�ȡ���ļ����
	 * @return
	 */
	public boolean openReadHandle() {
		if (mainReadHandle == null) {
			try {
				mainReadHandle = new Scanner(mainFile);
			} catch (FileNotFoundException e) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ��ȡ���ļ�����Ƿ��
	 * @return
	 */
	public boolean isOpenReadHandle() {
		if ( mainReadHandle == null ) {
			return false;
		}
		return true;
	}
	
	/**
	 * ��ȡ��һ��
	 * @return	���Ϊnull or û����һ�� �򷵻� null
	 */
	public String readNextLN() {
		if ( mainReadHandle != null && mainReadHandle.hasNextLine() ) {
			return mainReadHandle.nextLine();
		}
		return null;
	}
	
	/**
	 * ��ȡ��һ��int
	 * @return	���Ϊnull or û����һ��int �򷵻� null
	 */
	public Integer readNextInt() {
		if ( mainReadHandle != null && mainReadHandle.hasNextLine() ) {
			try {
				return mainReadHandle.nextInt();
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	
	/**
	 * ��д�����ļ����
	 * @return
	 */
	public boolean openWriteHandle() {
		if (mainWriteHandle == null) {
			try {
				mainWriteHandle = new PrintWriter(mainFile);
			} catch (FileNotFoundException e) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * д�����ļ�����Ƿ��
	 * @return
	 */
	public boolean isOpenWriteHandle() {
		if ( mainWriteHandle == null ) {
			return false;
		}
		return true;
	}
	
	/**
	 * д��һ��<br>
	 * ����<br>
	 * @param line	
	 * @return ���Ϊ�շ���null
	 */
	public boolean writeNextLN( String line) {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.println(line);
			return true;
		}
		return false;
	}
	public boolean writeNextLN( int line) {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.println(line);
			return true;
		}
		return false;
	}
	public boolean writeNextLN() {
		if ( mainWriteHandle != null ) {
			mainWriteHandle.println();
			return true;
		}
		return false;
	}
	
	/**
	 * д��һ��DVD����<br>
	 * @param dbject
	 * @return ���Ϊnull����null
	 */
	public boolean writeDVD(DVD dbject) {
		if ( mainWriteHandle == null ) {
			return false;
		}
		if (dbject == null) {
			return false;
		}
		mainWriteHandle.println();
		mainWriteHandle.println("DVDObjectB");
		mainWriteHandle.println(dbject.getTitle());
		mainWriteHandle.println(dbject.getID());
		mainWriteHandle.println(dbject.getYear());
		mainWriteHandle.println(dbject.getAmount());
		mainWriteHandle.println(dbject.getBuyPrice());
		mainWriteHandle.println(dbject.getRentPrice());
		mainWriteHandle.println(dbject.getRentAmount());
		mainWriteHandle.println(dbject.canSell());
		mainWriteHandle.println(dbject.canRent());
		// δ����չ�Ĳ���λ��
		mainWriteHandle.println("DVDObjectSB");
		mainWriteHandle.println(dbject.styleGetSize());
		for (Long a : dbject.styleGetAll()) {
			mainWriteHandle.println(a);
		}
		mainWriteHandle.println("DVDObjectSE");
		mainWriteHandle.println("DVDObjectE");
		return true;
	}

}
