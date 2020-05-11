package proxy;
/*真实类*/
public class Lenovo implements saleComputer{
    @Override
    public String sale(double money) {
        System.out.println("客户花了"+money+"元买了一台电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("show...");
    }
}
