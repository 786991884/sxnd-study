package day02;

class Man {
	int eyes = 2;// 眼睛数量为2

	// 返回人眼睛的颜色

	String getEyesColor() {
		return null;
	}
}

// 亚洲人
class AsiaMan extends Man {
	String getEyesColor() {
		return "black";
	}
}

// 欧洲人
class EuroMan extends Man {
	String getEyesColor() {
		return "bule";
	}
}

public class PolymorphismTest {
	public static void main(String[] args) {
		Man asiaMan = new AsiaMan();
		Man euroMan = new EuroMan();
		System.out.println("亚洲人眼睛颜色是：" + asiaMan.getEyesColor());
		System.out.println("欧洲人的眼睛颜色是：" + euroMan.getEyesColor());
	}
}
