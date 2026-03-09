package mylab.book.control;

import java.util.*;
import mylab.book.entity.*;
import java.text.DecimalFormat;

public class ShoppingCart {
	//장바구니
	private List<Publication> items = new ArrayList<>();
	
	public ShoppingCart() {}
	
	//장바구니에 출판물 추가하고 메시지 출력 
	public void addItem(Publication item) {
		items.add(item); 
		System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
	}
	
	//제목으로 출판물 검색하여 장바구니에서 제거 
	public boolean removeItem(String title) {
		for (int i = 0; i < items.size(); i++) { 
			if (items.get(i).getTitle().equals(title)) { 
				Publication removed = items.remove(i); 
				System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다."); 
				return true;} // 성공적으로 제거됨  
			} 
			System.out.println("해당 제목의 출판물을 찾을 수 없습니다."); 
			return false; } // 제거 실패 

	
	//장바구니 내용을 항목별로 출력, 총 가격과 할인 적용 가격 표시 
	public void displayCart() {
		DecimalFormat df = new DecimalFormat("#,###원");
        System.out.println("\n====== 장바구니 내용 ======");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getTitle() + " - " + df.format(items.get(i).getPrice()));
        }
        System.out.println("총 가격: " + df.format(calculateTotalPrice()));
        System.out.println("할인 적용 가격: " + calculateDiscountedPrice() + "원");
	}
	
	//장바구니에 있는 모든 출판물의 원래 가격을 합산하여 반환 
	public int calculateTotalPrice() {
		int total = 0;
		for (Publication p : items) total += p.getPrice();
		return total;
	}
	
	//출판물 타입에 따라 다른 할인율을 적용하여 총 할인가 계산 
	public int calculateDiscountedPrice() {
		int total = 0; 
	     for (Publication item : items) { 
	         // ManageBook과는 다른 할인율 적용 (용도별 차별화) 
	    	 if (item instanceof Magazine) { 
	    		 total += item.getPrice() * 0.9; // 10% 할인 
	    	 } else if (item instanceof Novel) { 
	    		 total += item.getPrice() * 0.85; // 15% 할인 
	    	 } else if (item instanceof ReferenceBook) { 
	    		 total += item.getPrice() * 0.8; // 20% 할인 
	    	 } else { 
	    		 total += item.getPrice(); // 기본 출판물은 할인 없음 
	     } 
	} 
	  return total; 

	}
	
	//장바구니에 담긴 출판물 타입별 통계를 출력 
	public void printStatistics() {
		int magazineCount = 0; 
	    int novelCount = 0; 
	    int referenceBookCount = 0; // instanceof를 활용한 타입별 카운팅 
	    
	    for (Publication item : items) { 
	    	if (item instanceof Magazine) { 
	    		magazineCount++; 
	        } else if (item instanceof Novel) { 
	            novelCount++; 
	        } else if (item instanceof ReferenceBook) { 
	            referenceBookCount++; 
	        }
	    }
	    	System.out.println("\n====== 장바구니 통계 ======"); 
	        System.out.println("잡지: " + magazineCount + "권"); 
	        System.out.println("소설: " + novelCount + "권"); 
	        System.out.println("참고서: " + referenceBookCount + "권"); 
	        System.out.println("총 출판물: " + items.size() + "권"); 

	 }
	
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        cart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        cart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        cart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        cart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));

        cart.displayCart();
        cart.printStatistics();
        cart.removeItem("빠삐용");
        cart.displayCart();
	}

}
