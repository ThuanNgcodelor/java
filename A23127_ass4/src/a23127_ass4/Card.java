package a23127_ass4;

import java.util.Scanner;

public class Card {

    private String cardNumber;

    public static void main(String[] args) {
        Card hi = new Card();
        hi.checkThe();
        // 5368235896831135
        //Lỗi
        //5368235896831131
//1235654
    }

    public void checkThe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thẻ của bạn (Chỉ là số): ");
        setCardNumber(sc.nextLine());

        if (cardNumber == null) {
            return;
        }
        //ktra xem có lỗi số ko,ko là sẽ báo lỗi

        int cardLength = getCardNumber().length();
        int prefix = Integer.parseInt(getCardNumber().substring(0, 2));
        // chuyển từ Chuỗi thành int và bắt đầu kiểm từ 0 và 2 đầu tiền

        // Kiểm tra loại thẻ
        if (cardLength == 16 && (prefix >= 51 && prefix <= 55)) {
            System.out.println("Loại thẻ: MasterCard");
        } else if ((cardLength == 13 || cardLength == 16) && prefix / 100 == 4) {
            System.out.println("Loại thẻ: Visa");
        } else if (cardLength == 15 && (prefix == 34 || prefix == 37)) {
            System.out.println("Loại thẻ: American Express");
        } else if (cardLength == 16 && Integer.parseInt(getCardNumber().substring(0,4)) == 6011) {
            System.out.println("Loại thẻ: Discover");
        } else {
            System.out.println("Loại thẻ không xác định");
            return;
        }
        System.out.println("Mã thẻ: " + cardNumber);

        //Kiem tra thẻ xem có hợp lệ
        if (kiemTra(getCardNumber())) {
            System.out.println("Thẻ hợp lệ");
        } else {
            System.out.println("Lỗi: Thẻ không hợp lệ");
        }
    }

    //kiểm tra thẻ
    public boolean kiemTra(String cardNumber) {

        int sum = 0;
        boolean ktra = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int so = Integer.parseInt(cardNumber.substring(i, i + 1));
            //Chạy từ i cuối cùng và + thêm 1(lập lại khi để trong for)
            if (ktra) {
                so *= 2;
//                System.out.println(so);
                if (so > 9) {
                    so = (so % 10) + 1;
                }
            }
            sum += so;
            ktra = !ktra;
        }
//        System.out.println(sum);

        return sum % 10 == 0;
    }

    public final void setCardNumber(String cardNumber) {
        // Kiểm tra xem cardNumber có chỉ chứa số không
        if (!cardNumber.matches("\\d+")) {
            //matches trả về giá trị xem coi nó f hay true
            System.out.println("Lỗi: Số thẻ chỉ chứa các chữ số!");
            return;
        }
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Card(String cardNumber) {
        setCardNumber(cardNumber);
    }

    public Card() {
        this.cardNumber = null;
    }

}
