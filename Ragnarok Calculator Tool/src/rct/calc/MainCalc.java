package rct.calc;

public class MainCalc {
	
	private int atk1,atk2;

	public double cast(int cast_dex , int cast_int , int cast_equip){
		double stats, equips, casttime;
		stats = 1 - Math.sqrt((2*cast_dex + cast_int)/530.);
		if(stats<0){
			stats=0;
		}
		equips = 1 - (cast_equip/100.);
		if(equips<0){
			equips = 0;
		}
		casttime = 100*(1 - (stats*equips));
	
		return casttime;
	}
	
	public double mdef(int mdef_foe, int mdef_mp){
		double damage, foe, mp;
		if(mdef_mp>100){
			mdef_mp=100;
		}
		
		mp = 1-(mdef_mp/100.);
		foe = mp*mdef_foe;
		
		damage =100*((foe+1000)/((foe*10)+1000));

	return damage;
	}
	
	public double def(int def_foe, int def_p){
		double damage, foe, p;
		if(def_p>100){
			def_p=100;
		}
		
		p = 1-(def_p/100.);
		foe = p*def_foe;
		
		damage =100*((foe+4000)/((foe*10)+4000));

	return damage;
		
	}
	
	public String refine(int refine_lvl, int refine_over, int refine_atk){
		String bonus=null;
		int max_over = 8-refine_lvl;
		int overrefine = refine_over-max_over;
		int[] overrefineB= new int[3];
		switch(refine_lvl){
			case 1:
				overrefineB[0]=2;
				overrefineB[1]=3;
				overrefineB[2]=12;
				break;
			case 2:
				overrefineB[0]=3;
				overrefineB[1]=5;
				overrefineB[2]=24;
				break;
			case 3:
				overrefineB[0]=5;
				overrefineB[1]=8;
				overrefineB[2]=36;
				break;
			case 4:
				overrefineB[0]=7;
				overrefineB[1]=14;
				overrefineB[2]=48;
				break;
			default:
				break;
				
		}
		int b1 = refine_over * overrefineB[0];
		int b2 = b1 + (overrefine * overrefineB[1]);
		if(refine_over > 15){
			b1 = b1 + overrefineB[2]*(refine_over-15);
			b2 = b2 + overrefineB[2]*(refine_over-15);
		}
		
		if(overrefine > 0){
			bonus = String.valueOf(b1)+"~"+String.valueOf(b2);
			atk1=refine_atk+b1;
			atk2=refine_atk+b2;
		} else{
			bonus = String.valueOf(b1)+"~"+String.valueOf(b1);
			atk1=refine_atk+b1;
			atk2=atk1;
		}

		return bonus;
	}
	
	public int getAtk1(){
		return atk1;
	}
	
	public int getAtk2(){
		return atk2;
	}
	
}
