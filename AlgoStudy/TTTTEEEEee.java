package AlgoStudy;

import java.util.Random;

public class TTTTEEEEee {

	public static void main(String[] args) {
		String st;
		int num = 2041;
		Random rand = new Random();
		String[] first = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };
		String[] last = { "����", "����", "����", "����", "����", "����", "����", "����", "����", "�ϸ�", "����", "����", "�ÿ�", "����", "����",
				"����", "�ؿ�", "����" };
		String[] dream = { "����", "��", "�Ǳ�", "��" };
		String[] year = { "1998", "1999", "2000", "2001", "2002" };
		String[] year2 = { "2015", "2016", "2017", "2018", "2019", "2014" };
		String[] sex = { "M", "F" };
		String[] add = { "����", "���", "��õ", "��õ", "�λ�", "����", "����", "�뱸", "����", "���", "�泲" };

		int tnum = 10;
		int snum = 4030;
		int jjj = 0;
		String[] subname = { "�νεǴ���", "�μ�������", "�����", "���߱�", "���ñ���", "�����߱�", "���ð��", "���ʱ�", "�Ǳ��߱�", "�Ǳ��ʱ�", "��������" };
		for (int i = 0; i < 800; i++) {
			String si =null;
			int traineenum = rand.nextInt(300)+1;
			if(traineenum < 10)
			si = "00"+String.valueOf(traineenum);
			else if(traineenum <100)
			si = "0"+String.valueOf(traineenum);
			else 
			si = String.valueOf(traineenum);
			
			String bal = null;
			int teachernum = rand.nextInt(40);
			if(teachernum < 10)
				bal = "00"+String.valueOf(teachernum);
				else 
				bal = "0"+String.valueOf(teachernum);
			
					
			System.out.println("insert into evaluation values(2"+si+",0"+bal+",'2019-" + (rand.nextInt(12) + 1) + "-" + (rand.nextInt(29) + 1)+
					"',"+(rand.nextInt(50) + 50)+","+(rand.nextInt(50) + 50)+")");
		}

	}
}
// String si =null;
// String bal = null;
// int traineenum = rand.nextInt(441)+1;
// if(traineenum < 10)
// si = "00"+String.valueOf(traineenum);
// else if(traineenum <100)
// si = "0"+String.valueOf(traineenum);
// else
// si = String.valueOf(traineenum);
// int Subjectnum = rand.nextInt(100);
// if(Subjectnum < 10)
// bal = "00"+String.valueOf(Subjectnum);
// else if(Subjectnum <100)
// bal = "0"+String.valueOf(Subjectnum);
//
// System.out.println("insert into TAKE_A_LESSON values(2"+si+",4"+bal+");");

// System.out.println("insert into Subject
// values("+(snum++)+",'"+subname[rand.nextInt(subname.length)]+"',00"+(rand.nextInt(31)+10)+");");
// System.out.println("insert into Teacher values
// (00"+(tnum++)+",'"+dream[rand.nextInt(dream.length)]+
// "','"+first[rand.nextInt(first.length)]+last[rand.nextInt(last.length)]+
// "','"+year[rand.nextInt(year.length)] + "-" + (rand.nextInt(12) + 1) + "-" +
// (rand.nextInt(29) + 1)+"','"+
// add[rand.nextInt(add.length)]+"','"+sex[rand.nextInt(sex.length)]+"')");
// System.out.println("insert into trainee values (" + (num++) + ",'" +
// first[rand.nextInt(first.length)]
// + last[rand.nextInt(last.length)] + "','" + dream[rand.nextInt(dream.length)]
// + "','"
// + sex[rand.nextInt(sex.length)] + "','" + add[rand.nextInt(add.length)] +
// "','"
// + year[rand.nextInt(year.length)] + "-" + (rand.nextInt(12) + 1) + "-" +
// (rand.nextInt(29) + 1)
// + "')");

// String si =null;
// int traineenum = rand.nextInt(300)+1;
// if(traineenum < 10)
// si = "00"+String.valueOf(traineenum);
// else if(traineenum <100)
// si = "0"+String.valueOf(traineenum);
// else
// si = String.valueOf(traineenum);
//
// String bal = null;
// int teachernum = rand.nextInt(40);
// if(teachernum < 10)
// bal = "00"+String.valueOf(teachernum);
// else
// bal = "0"+String.valueOf(teachernum);
//
//
// System.out.println("insert into evaluation
// values(2"+si+",0"+bal+",'"+year2[rand.nextInt(year.length)] + "-" +
// (rand.nextInt(12) + 1) + "-" + (rand.nextInt(29) + 1)+
// "',"+(rand.nextInt(50) + 50)+","+(rand.nextInt(50) + 50)+")");

// String bal = null;
// int SingerNum = jjj++;
// if(SingerNum < 10)
// bal = "00"+String.valueOf(SingerNum);
// else
// bal = "0"+String.valueOf(SingerNum);
// System.out.println("insert into health
// values(1"+bal+",'"+year2[rand.nextInt(year.length)] + "-" + (rand.nextInt(12)
// + 1) + "-" + (rand.nextInt(29) + 1)+"',"+
// (rand.nextInt(25)+160)+","+(rand.nextInt(60)+20)+","+(rand.nextInt(10)+13)+","+(rand.nextInt(12)+21)+")");
// }