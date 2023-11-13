package christmas.view;

public class EventOutputView {
    public static void printEventPreview(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public static void printEventApplicableMessage() {
        System.out.println("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        System.out.println();
    }

    public void printEventBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
