package rct.calc;

public class StatCalc {
	
	private int bstat;
	private int PointsR;
	private int PointsS;
	private int AutoLvl;
	private int ALP;
	
	public StatCalc(Boolean trans){
		if(trans) {
			bstat=100;
		}else {
			bstat=48;
		}
		PointsR=0;
		PointsS=0;
		AutoLvl=2;
	}
	
	public void PointsR(int lvl) {
		if(lvl>150) {
			PointsR = PointsR+(int) Math.floor(6.6+(double)(lvl-1)/7);
			PointsR(lvl-1);
		}else if(lvl>99) {
			PointsR = PointsR+(int) Math.floor(13+(lvl-1)/10);
			PointsR(lvl-1);
		}else if(lvl>1) {
			PointsR = PointsR+(int) Math.floor(3+(lvl-1)/5);
			PointsR(lvl-1);
		}
	}
	
	public void StatSpent(int stat) {
		if(stat>100) {
			PointsS = PointsS+ (int) (4*Math.floor((stat-101)/5)+16);
			StatSpent(stat-1);
		}else if(stat>1) {
			PointsS = PointsS+ (int) (Math.floor((stat-2)/10)+2);
			StatSpent(stat-1);
		}

	}
	
	public void AutoLevel(int points) {
		ALP = bstat;
		AutoLvl = 2;
		while(ALP<points && AutoLvl<=99) {
			ALP = ALP+(int) Math.floor(3+(AutoLvl-1)/5);
			AutoLvl++;
		}
		while(ALP<points && AutoLvl<=150) {
			ALP = ALP +(int) Math.floor(13+(AutoLvl-1)/10);
			AutoLvl++;
		}
		while(ALP<points && AutoLvl<=175) {
			ALP = ALP +(int) Math.floor(6.6+(double)(AutoLvl-1)/7);
			AutoLvl++;
		}
		AutoLvl =AutoLvl-1;
	}

	public void clearPR() {
		this.PointsR = 0;
	}
	
	public void clearPS() {
		this.PointsS = 0;
	}
	
	
	public int getBstat() {
		return bstat;
	}

	public int getPointsR() {
		return PointsR;
	}

	public int getPointsS() {
		return PointsS;
	}

	public void setPointsS(int pointsS) {
		PointsS = pointsS;
	}

	public void setBstat(int bstat) {
		this.bstat = bstat;
	}

	public void setPointsR(int pointsR) {
		PointsR = pointsR;
	}

	public int getAutoLvl() {
		return AutoLvl;
	}

	public void setAutoLvl(int autoLvl) {
		AutoLvl = autoLvl;
	}

	public int getALP() {
		return ALP;
	}

	public void setALP(int aLP) {
		ALP = aLP;
	}
	


}
