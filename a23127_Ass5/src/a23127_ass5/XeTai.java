package a23127_ass5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class XeTai extends XeOTo {

    private int maXe;
    private String bienSo;
    private int trongTai;
    private ArrayList<XeTai> them = new ArrayList<XeTai>();
    private Scanner sc = new Scanner(System.in);

    public void themXeTai() {
        System.out.println("THÊM XE TẢI MỚI.");
        System.out.print("Nhập tên xe: ");
        setTenXe(sc.next());
        System.out.print("Nhập hãng sản xuất: ");
        setHangsx(sc.next());
        System.out.print("Nhập năm sản xuất: ");
        setNamsx(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập mã số xe: ");
        setMaXe(sc.nextInt());
        sc.nextLine();
        System.out.print("Nhập biển số xe: ");
        setBienSo(sc.next());
        System.out.print("Nhập trọng tải xe: ");
        setTrongTai(sc.nextInt());
        sc.nextLine();
        them.add(new XeTai(getTenXe(), getHangsx(), getNamsx(), getMaXe(), getBienSo(), getTrongTai()));
        //tạo 1 list Thêm để add tất cả
        System.out.println("Đã thêm xe mới.");
    }

    public void menu() {
        while (true) {
            System.out.println("===== QUẢN LÝ XE TẢI =====");
            System.out.println("1. Nhập thêm một xe tải mới.");
            System.out.println("2. Tìm kiếm xe tải khi biết biển số xe.");
            System.out.println("3. In danh sách xe tải theo thứ tự trọng tải tăng dần.");
            System.out.println("4. Kết thúc.");
            System.out.print("Chọn chức năng: ");
            int chon = sc.nextInt();

            switch (chon) {
                case 1:
                    themXeTai();
                    break;
                case 2:
                    timKiem();
                    break;
                case 3:
                    hienThi();
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Vui lòng chọn lại");
            }
        }
    }

    public void hienThi() {
        System.out.println("DANH SÁCH XE TẢI (Tăng dần theo trọng tải)");
        them.sort(Comparator.comparingInt(XeTai::getTrongTai));
        //Hiển thị danh sách tăng dần từ List XeTai với cân nặng xe.
        for (XeTai xetai : them) {
            xetai.display();
        }

    }

    public void display() {
        System.out.println("Tên xe: " + getTenXe());
        System.out.println("Hãng xe: " + getHangsx());
        System.out.println("Năm sản xuất: " + getNamsx());
        System.out.println("Mã xe: " + getMaXe());
        System.out.println("Biển số xe: " + getBienSo());
        System.out.println("Trọng tải: " + getTrongTai());
    }
    //Dùng để in

    public void timKiem() {
        System.out.print("NHẬP BIỂN SỐ: ");
        String bienso = sc.next();
        boolean fond = false;
        for (XeTai xeTai : them) {
            if (xeTai.getBienSo().equals(bienso)) {
                System.out.println("Thông tin xe tải.");
                xeTai.display();
                fond = true;
                //Đúng thì chạy
                break;
            }
            if (!fond) {
                System.out.println("Không tìm thấy xe nào với biển số :" + bienso);
                //Phủ định của fond là đúng thì sẽ báo lỗi
            }
        }
    }

    public XeTai(String tenXe, String hangsx, int namsx, int maXe, String bienSo, int trongTai) {
        super(tenXe, hangsx, namsx);
        this.maXe = maXe;
        this.bienSo = bienSo;
        this.trongTai = trongTai;
    }

    public XeTai() {
        super();
        this.maXe = 0;
        this.bienSo = null;
        this.trongTai = 0;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

}
