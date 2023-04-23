import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

class Systemer{
	private Scanner scan;			//�L�[�{�[�h����
	private Random rnd;				//��������
	private BufferedReader br;		//�t�@�C���ǂݍ���
	private String file;			//�t�@�C����
	private String line;			//�s�ǂݍ���
	private String[] spl;			//�s�̕�����
	private String[][] buf;			//��U�o�b�t�@��
	private String[] toi;			//��蕶
	private String[][] kot;			//����
	private int ban;				//�񓚂̓Y��
	private int i,j;				//���[�v�p
	private byte[] mi;				//�񓚍ς݂�
	private String tou;				//�񓚗�
	private byte stop;				//�ʉ�T��
	private String ru;				//�J��Ԃ���
	private int zat;				//�G�p
	private int cnt,suu;			//�������Ɩ�萔
	
	public Systemer(){				//�R���X�g���N�^
		rnd = new Random();
		buf = new String[999][999];
		ban = -1;
		stop = 0;
		ru = "0";
		suu = 0;
		cnt = 0;
	}
	
	public void select(){
		System.out.println("�P�F�S����񏈗�����v���O���~���O����P���p��");
		System.out.println("�Q�F�S����񏈗�����v���O���~���O����Q���p��");
		System.out.println("�R�F�S����񏈗�����r�W�l�X��񕔖�P���p��");
		System.out.println("�S�F�S����񏈗�����r�W�l�X��񕔖�Q���p��(�f�[�^������܂���)");
		System.out.println("�T�F�S����񏈗�����P�����ʔ͈͗p��(��������Ă�������)");
		System.out.println("�U�F�S����񏈗�����Q�����ʔ͈͗p��(�f�[�^������܂���)");
		System.out.println("�O�F���̑��i�����œ��́j");
		do{
			ru = "0";
			zat = judge(zat);
			switch(zat){
				case 1:
						file = "C:\\Users\\PCR1-s01\\Desktop\\�̌������֘A\\tokunaga\\�S����񏈗��v���P���p��.csv";
						break;
				case 2:
						file = "C:\\Users\\PCR1-s01\\Desktop\\�̌������֘A\\tokunaga\\�S����񏈗��v���Q���p��.csv";
						break;
				case 3:
						file = "C:\\Users\\PCR1-s01\\Desktop\\�̌������֘A\\tokunaga\\�S����񏈗��r��P���p��.csv";
						break;
				case 4:
						file = "C:\\Users\\PCR1-s01\\Desktop\\�̌������֘A\\tokunaga\\�S����񏈗��r��Q���p��.csv";
						break;
				case 5:
						file = "C:\\Users\\PCR1-s01\\Desktop\\�̌������֘A\\tokunaga\\�S����񏈗����ʂP���p��.csv";
						break;
				case 6:
						file = "C:\\Users\\PCR1-s01\\Desktop\\�̌������֘A\\tokunaga\\�S����񏈗����ʂQ���p��.csv";
						break;
				case 0:
						System.out.println("�Q�Ƃ���t�@�C�����w�肵�Ă��������B");
						System.out.println("�i�g���q���K�v�ł��B�j");
						file = scan.next();
						break;
				default:
						System.out.println("�I�����ɂ���܂���B");
						System.out.println("������x���͂��Ă��������B");
						ru = "1";
			}
		}while("1".equals(ru));
		try{
			br = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e){
			System.out.println(file);
			System.out.println("��������܂���ł����B");
			System.exit(0);
		}
	}
	
	public int judge(int n){
		do{
			try{
				scan = new Scanner(System.in);
				n = scan.nextInt();
				ru = "0";
			}
			catch(Exception e){
				System.out.println("�G���[���������܂����B");
				System.out.println("�ȉ��̓G���[���b�Z�[�W�ł��B");
				System.out.println(e);
				System.out.println("������x���͂��Ă��������B");
				ru = "1";
			}
		}while("1".equals(ru));
		return n;
	}
	
	public String judge(String n){
		do{
			try{
				scan = new Scanner(System.in);
				n = scan.nextLine();
				ru = "0";
			}
			catch(Exception e){
				System.out.println("�G���[���������܂����B");
				System.out.println("�ȉ��̓G���[���b�Z�[�W�ł��B");
				System.out.println(e);
				System.out.println("������x���͂��Ă��������B");
				ru = "1";
			}
		}while("1".equals(ru));
		return n;
	}
	
	public void input(){
		try{
			while((line = br.readLine()) != null){
				spl = line.split(",",-1);
				for(i = 0;i < spl.length;i++){
					buf[i][ban + 1] = spl[i];
				}
				ban++;
			}
		}
		catch(IOException e){
			System.out.println("�t�@�C�����͎��ɃG���[���������܂����B");
			System.out.println("�ȉ��̓G���[���b�Z�[�W�ł��B");
			System.out.println(e);
			System.exit(0);
		}
		zat = i;
		toi = new String[ban + 1];
		kot = new String[zat + 1][ban + 1];
		for(i = 0;i <= ban;i++){
			toi[i] = buf[0][i];
			for(j = 1;j <= zat;j++){
				kot[j -1][i] = buf[j][i];
			}
		}
		mi = new byte[toi.length];
	}
	
	public void output(){
		do{
			for(i = 0;i <= ban;i++){
				mi[i] = 0;
			}
			suu = 0;
			cnt = 0;
			System.out.printf("%n����o�肷�邩����͂��Ă��������B%n");
			System.out.println("����葍���ȏ�̐����w�肵���ꍇ�͖�葍���Ɠ����ɒ�������܂��B");
			zat = judge(zat);
			if(zat >= toi.length){
				zat = toi.length;
			}
			for(i = 1;i <= zat;i++){
				System.out.printf("----------��%2d��----------%n",i);
				suu++;
				do{
					ban = rnd.nextInt(toi.length);
				}while(mi[ban] == 1);
				System.out.printf(" %s%n",toi[ban]);
				mi[ban] = 1;
				tou = judge(tou);
				stop = 0;
				while(!kot[stop][ban].equals(tou) && !"end".equals(kot[stop][ban])){
					stop++;
				}
				if(kot[stop][ban].equals(tou) && !"end".equals(tou)){
					System.out.printf("%n����%n");
					cnt++;
				}else{
					System.out.printf("%n�s����%n");
					System.out.printf("������ %s �ł����B%n%n",kot[0][ban]);
				}
			}
			try{
				System.out.printf("--------------------------%n%n");
				zat = 10000000 * zat;
				for(i = 0;i < zat;i++){}								//�ҋ@����
				System.out.printf("��萔�F%2d%n�������F%2d%n�������F%2d ��%n%n���������܂����H%n",suu,cnt,cnt * 100 / suu);
			}
			catch(ArithmeticException e){
				System.out.println("0�͎w��ł��܂���B");
			}
			System.out.println("�P�ŌJ��Ԃ��܂��B");
			scan = new Scanner(System.in);
			ru = scan.next();
			if("1".equals(ru) || "�P".equals(ru)){
				ru = "1";
			}else{
				ru = "0";
			}
		}while("1".equals(ru));
		scan.close();
		try{
			br.close();
		}
		catch(IOException e){
			System.out.println("�t�@�C���𐳏�ɕ����܂���ł����B");
			System.exit(0);
		}
	}
}


public class Question{
	public static void main(String[] args){
		Systemer sub = new Systemer();		//�����N���X�̃C���X�^���X��
		sub.select();
		sub.input();
		sub.output();
	}
}
