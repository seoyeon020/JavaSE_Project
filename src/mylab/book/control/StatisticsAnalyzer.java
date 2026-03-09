package mylab.book.control;

import java.text.DecimalFormat;
import java.util.*;

import mylab.book.entity.*;

public class StatisticsAnalyzer {
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
		//타입별 평균 가격 계산 메서드 
		Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        
        for (Publication p : publications) {
            String type = getPublicationType(p);
            sumMap.put(type, sumMap.getOrDefault(type, 0) + p.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> result = new HashMap<>();
        for (String type : sumMap.keySet()) {
            result.put(type, (double) sumMap.get(type) / countMap.get(type));
        }
        return result;
	}
	
	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		//출판물 유형 분포 계산 메서드 
		Map<String, Integer> countMap = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> result = new HashMap<>();
        for (String type : countMap.keySet()) {
            result.put(type, (double) countMap.get(type) / publications.length * 100);
        }
        return result;
	}
	
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
		//특정 연도 출판물 비율 계산 메서드 
		int count = 0;
        for (Publication p : publications) {
            if (p.getPublishDate().startsWith(year)) count++;
        }
        return (double) count / publications.length * 100;
	}
	
	private String getPublicationType(Publication pub) {
		//출판물 타입 확인 헬퍼 메서드 
		if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
	}
	
	public void printStatistics(Publication[] publications) {
		//통계 정보 출력 메서드 
		DecimalFormat dfPrice = new DecimalFormat("#,###원");
		DecimalFormat dfRatio = new DecimalFormat("##.##%");
		
		System.out.println("\n==== 출판물 통계 분석 ====");
		
		// 1. 타입별 평균 가격
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("1. 타입별 평균 가격:");
        for (String type : avgPrices.keySet()) {
            System.out.println("   - " + type + ": " + dfPrice.format(avgPrices.get(type)));
        }
        
        // 2. 유형 분포
        Map<String, Double> dist = calculatePublicationDistribution(publications);
        System.out.println("\n2. 출판물 유형 분포:");
        for (String type : dist.keySet()) {
            System.out.println("   - " + type + ": " + String.format("%.2f%%", dist.get(type)));
        }
        
        // 3. 특정 연도 비율
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + String.format("%.2f%%", ratio2007));
	}

}
